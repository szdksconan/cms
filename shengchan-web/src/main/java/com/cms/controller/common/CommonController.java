package com.cms.controller.common;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.shengchan.PurchaseNeedService;
import com.cms.iservice.shengchan.ShengchanRecommendService;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductBean;
import com.cms.model.shengchang.ProductPriceBean;
import com.cms.model.util.GlobalTypeEnum;
import com.cms.model.util.PageFilter;

/**
 * weitianyu
 * @author Administrator
 *
 */

@Controller
@RequestMapping("common")
public class CommonController {
	
	
	@Autowired
	private ShengchanRecommendService shengchanRecommendService;
	
	@Autowired
	private PurchaseNeedService  purchaseNeedService;

	
	 /**
     * 获取推荐物资列表
     * @param request
     * @return
     */
    @RequestMapping("getPurchaseRecommendList")
    @ResponseBody
    public JSONObject  getPurchaseList(PageFilter pageFilter){
    	
    	
    	//获取当前起始条数
    	Integer beginNum = (pageFilter.getPage()-1)*pageFilter.getRows();
    	
    	List<String> list = this.shengchanRecommendService.getGoodsRecommend("1312312313",beginNum,pageFilter.getRows());
    	
    	//TODO:假如我在四川
    	String areaId = "001001019002";
    	
    	String cityId = "001001019001";
    	
    	String provinceId = "001001";
    	
    	//得到物资最适合价格,主营产品ID
    	for(int i=0;i<list.size();i++){
    		
    		ProductBean productBean = new ProductBean();
    		
    		String productId = String.valueOf(list.get(i));
    		
    		List<ProductPriceBean> priceList = this.purchaseNeedService.getProductPriceByProductIdAndAreaId(productId, areaId);
    		
    		if(priceList.size()>0){
    			
    				ProductPriceBean productPriceBean = (ProductPriceBean) priceList.get(0);
    			
    				productBean.setId(productPriceBean.getId());
    			
    				productBean.setMainProductId(productPriceBean.getMainProductId());
    			
    			if(productPriceBean.getPrice() != null && !"".equals(productPriceBean.getPrice())){
    				
    				productBean.setPrice(String.valueOf( productPriceBean.getPrice()));
    			
    			}
    			else{
    				
    				productBean.setPrice("--");	
    			}

    		}
    		else{
    			
    			List<ProductPriceBean> priceList2 = this.purchaseNeedService.getProductPriceByProductIdAndAreaId(productId, cityId);
    			
    			if(priceList2.size()>0){
        			
    				ProductPriceBean productPriceBean = (ProductPriceBean) priceList2.get(0);
    			
    				productBean.setId(productPriceBean.getId());
    			
    				productBean.setMainProductId(productPriceBean.getMainProductId());
    			
    			if(productPriceBean.getPrice() != null && !"".equals(productPriceBean.getPrice())){
    				
    				productBean.setPrice(String.valueOf( productPriceBean.getPrice()));
    			
    			}
    			else{
    				
    				productBean.setPrice("--");	
    			}

    		}
    		
    	
    	}
    		
    		
    	}
        
    	
    	return null;
    	
    }
}
