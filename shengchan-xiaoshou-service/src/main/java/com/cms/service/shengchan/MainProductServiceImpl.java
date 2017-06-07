package com.cms.service.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.shengchan.CompanyDao;
import com.cms.dao.shengchan.MainProductDao;
import com.cms.dao.shengchan.ProductBeanDao;
import com.cms.dao.shengchan.ProductSellRuleDao;
import com.cms.iservice.shengchan.MainProductService;
import com.cms.model.shengchang.*;
import com.cms.model.util.GlobalTypeEnum;
import com.cms.model.util.GlobalUtil;
import com.cms.model.util.Grid;
import com.cms.service.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainProductServiceImpl implements MainProductService {

	@Autowired
	private MainProductDao mainProductDao;
    @Autowired
    private ProductBeanDao productBeanDao;
    @Autowired
    private ProductSellRuleDao productSellRuleDao;
    @Autowired
    private CompanyDao companyDao;

	public void saveMainProduct(MainProductBean mainProductBean) {
        if (mainProductBean.getDelMainDocList().size()!=0){
            this.mainProductDao.delMainProductDoc(mainProductBean.getDelMainDocList());
        }
		this.mainProductDao.addMainProduct(mainProductBean);
        if (mainProductBean.getDelProductBeanList().size()!=0){
            this.productBeanDao.delProductList(mainProductBean.getDelProductBeanList());
        }
        if (mainProductBean.getProductBeanList().size()!=0){
            this.productBeanDao.saveProduct(mainProductBean.getProductBeanList());
        }
        if (mainProductBean.getDelProductSellRuleBeanList().size()!=0){
            this.productSellRuleDao.delProductSellRuleList(mainProductBean.getDelProductSellRuleBeanList());
        }
        if (mainProductBean.getProductSellRuleBeanList().size()!=0){
            this.productSellRuleDao.saveProductSellRule(mainProductBean.getProductSellRuleBeanList());
        }
        if (mainProductBean.getProductPriceBeanList().size()!=0){
            Map map = new HashMap();
            map.put("mainProductId",mainProductBean.getId());
            this.productSellRuleDao.delProductSellRulePrice(map);
            this.productSellRuleDao.saveProductSellRulePrice(mainProductBean.getProductPriceBeanList());
        }
	}

	public void delMainProductById(MainProductBean mainProductBean) {
        this.mainProductDao.delMainProductById(mainProductBean);
	}
	
	//主营产品展示
	public Grid getMainProductList(MainProductBean bean) {
        return this.mainProductDao.getMainProductList(bean);
	}

    public List<MainProductBean> getMainProductById(MainProductBean bean) {
        List<MainProductBean> list =  mainProductDao.getMainProductList(bean).getRows();
        List list2 = new ArrayList();
        for(MainProductBean mainProductBean : list){
            try{
                mainProductBean.setMainDocList(GlobalUtil.MapToList(RedisUtil.hgetAll("produceMainDocList" + mainProductBean.getId()),MainDocBean.class));
            }catch (Exception e){}
            if (mainProductBean.getMainDocList()==null){
                mainProductBean.setMainDocList(this.mainProductDao.getMainProductDocList(mainProductBean));
            }
            ProductBean productBean = new ProductBean();
            productBean.setMainProductId(mainProductBean.getId());
            mainProductBean.setProductBeanList(this.productBeanDao.getProductById(productBean));
            mainProductBean.setProductSellRuleBeanList(this.productSellRuleDao.getProductSellRule(mainProductBean));
            list2.add(mainProductBean);
        }
        return list2;
    }

    public void delProductById(MainProductBean mainProductBean) {
        ProductBean productBean = new ProductBean();
        productBean.setId(mainProductBean.getId());
		this.productBeanDao.delProductById(productBean);
	}

	public List<ProductBean> getProductList(MainProductBean mainProductBean) {
        ProductBean productBean = new ProductBean();
        productBean.setMainProductId(mainProductBean.getId());
		return this.productBeanDao.getProductById(productBean);
	}

    public void updateMainProduct(MainProductBean mainProductBean) {
        this.mainProductDao.updateMainProduct(mainProductBean);
    }

	public void addBrand(CompBrandBean compBrandBean) {
	
		this.mainProductDao.addBrand(compBrandBean);
		
	}

	public void updateBrand(Long id, String brandName) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		obj.put("brandName", brandName);
		this.mainProductDao.updateBrand(obj);
	}

	public void delAllBrand(Long companyId) {
		this.mainProductDao.delAllBrand(companyId);
	}

	public List<CompBrandBean> getBrandList(Long companyId) {
		return this.mainProductDao.getBrandList(companyId);
	}

	public void delBrand(CompBrandBean compBrandBean) {
		this.mainProductDao.delBrand( compBrandBean);
	}

	public List<MainDocBean> getMainProductDocListByFilter(Long mainProductId, String fileType, String isMain) {
		JSONObject obj = new JSONObject();
		obj.put("mainProductId", mainProductId);
		obj.put("fileType", fileType);
		obj.put("isMain", isMain);
		return this.mainProductDao.getMainProductDocListByFilter(obj);
	}
	
	public List<ProductDocBean> getProductDocListByFilter(Long mainProductId, String fileType, String isMain) {
		JSONObject obj = new JSONObject();
		obj.put("productId", mainProductId);
		obj.put("fileType", fileType);
		obj.put("isMain", isMain);
		return this.mainProductDao.getProductDocListByFilter(obj);
	}

	public List<Map> getProductPricListByRuleId(Long ruleId) {
		
		return  this.mainProductDao.getProductPricListByRuleId(ruleId);
	}

	public JSONObject getPurchaseHall(MainProductBean mainProductBean,String areaId,String cityId,String provinceId,Integer rows) {
		
		//获得主营产品数据

    	Grid grid =  this.mainProductDao.getMainProductList(mainProductBean);
    	
    	List<MainProductBean>  list = grid.getRows();
    	
    	Integer total = grid.getTotal();
    	
    	//初始化输出List
    	List pruchaseListOut = new ArrayList();
    	
    
    	
    	//循环遍历主营产品信息
    	for(MainProductBean mainProductBeanOut :list){
    		
    	//初始化输出Map
    	 HashMap purchaseHallMap = new HashMap();
    		
    	//得到销售规则列表
    	 List<ProductSellRuleBean> ruleList = this.productSellRuleDao.getProductSellRule(mainProductBeanOut);
    	 
    	 
    	 ProductSellRuleBean  productSellRuleBeanCheck = new ProductSellRuleBean();
    	 
    	 //筛选出该主营产品中最符合条件的规则信息
    	 for(ProductSellRuleBean productSellRuleBean :ruleList){
    		 
    		List<ProductSellRuleAreaBean>  	areaList =	productSellRuleBean.getProductSellRuleAreaBeanList();
    		
    		for(ProductSellRuleAreaBean productSellRuleAreaBean :areaList){
    			
    			if(productSellRuleAreaBean.getAreaId() !=null && productSellRuleAreaBean.getAreaId().equals(areaId)){
    				
    				productSellRuleBeanCheck = productSellRuleBean;
    				
    				break;
    			}
    			
    			if(productSellRuleAreaBean.getCityId() !=null && productSellRuleAreaBean.getCityId().equals(cityId)){
    				
    				productSellRuleBeanCheck = productSellRuleBean;
    				
    				break;
    			}
    			
    			if(productSellRuleAreaBean.getProvinceId() !=null && productSellRuleAreaBean.getProvinceId().equals(provinceId)){
    				
    				productSellRuleBeanCheck = productSellRuleBean;
    				
    				break;
    			}
    				
    		}
    	 
    	 }
    	if(productSellRuleBeanCheck.getId() == null){
    			
    			productSellRuleBeanCheck = ruleList.get(0);
    			
    		}
    	
		    //根据规则信息得到相应的产品价格List
    		List<ProductPriceBean> priceList = productSellRuleBeanCheck.getProductPriceBeanList();
    		
    		//初始化显示产品List
    		List productListOut = new ArrayList();
    		
    		//循环产品价格得到productId查询到产品信息并封装到 productOutList    		
    		for(ProductPriceBean productPriceBean :priceList){
    			
        		HashMap map = new HashMap();
        		    			
    			String productId = productPriceBean.getProductId();
    			
    			BigDecimal price = productPriceBean.getPrice();
    			
    			ProductBean  productBean = new ProductBean();
    			
    			productBean.setId(productId);
    			
    			//得到产品
    			ProductBean  productBeanCheck = productBeanDao.getProductById(productBean).get(0);
    			
    			//得到产品DOCList
    			List<ProductDocBean>  productDocList = productBeanCheck.getProductDocBeanList();
    			
    			//得到产品PARAMList
    			List<ProductParameterBean> paramList = productBeanCheck.getProductParameterBeanList();
    			
    			//获取第一张IMG
    			ProductDocBean productDocBean = productDocList.get(0);
    			
    			//组装显示参数img
    			map.put("img", productDocBean.getFileUrl());
    			
    			//组装显示参数goodsname+
    			StringBuffer goodsname = new StringBuffer();
    			
    			goodsname.append(productBeanCheck.getProductName());
    			
    			for(ProductParameterBean productParameterBean : paramList){
    				
    				goodsname.append(" "+productParameterBean.getParameterValue());
    			
    			}
    			
    			map.put("goodsname", goodsname.toString());
    			
    			//组装显示参数price
    			map.put("price",price);
    			
    			//组装显示参数
    			map.put("count",productBeanCheck.getWarehouseBalance()+""+productBeanCheck.getUnitName());
    			
    			//将map添加到productListOut
    			productListOut.add(map);
    			
    		}
    		
    		CompBaseInfo compBaseInfo = this.companyDao.getById(mainProductBeanOut.getCompanyId());
    		
			//组装主营产品参数imgList
    		purchaseHallMap.put("imgList", productListOut);
    		
    		//组装主营产品参数companyname
    		purchaseHallMap.put("companyname", compBaseInfo.getCompanyName());
    		
    		//组装主营产品参数address
    		purchaseHallMap.put("address", compBaseInfo.getAddress());
    		
    		pruchaseListOut.add(purchaseHallMap);
    	}
    	
    	JSONObject json = new JSONObject();
    	
    	json.put("list", pruchaseListOut);
    	
    	if((total%rows)>0){
    		Integer	totalPage = (total/rows)+1;
    		json.put("totalPage",totalPage );
    	}
    	else{
    		Integer	totalPage = (total/rows);
    		json.put("totalPage",totalPage );
    	}
    	
    	
    	
    	return json;
    	
	}


}
