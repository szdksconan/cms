package com.cms.controller.xiaofei;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.cms.elasticsearch.produce.IQueryProduceService;
import com.cms.iservice.maoyi.EnterpriseInfoService;
import com.cms.iservice.maoyi.EnterpriseToOutService;
import com.cms.iservice.maoyi.ProductCenterService;
import com.cms.iservice.xiaofei.CmsXGoodsAddressService;
import com.cms.model.elasticsearch.cm.PageProduce;
import com.cms.model.maoyi.CmsProduct;
import com.cms.model.maoyi.EnterpriseToOutBean;
import com.cms.model.xiaofei.CmsXOrderEvaluation;
import com.cms.model.xiaofei.CmsXProductEvaluation;
import com.cms.model.xiaofei.DataList;

@Controller
@RequestMapping("/shopData")
public class CmsShopDataController {
	
	@Autowired
	private EnterpriseInfoService enterpriseInfoService;
	
	@Autowired
	private EnterpriseToOutService enterpriseToOutService;
	@Autowired
	private ProductCenterService productCenterService;
	@Autowired
	private	CmsXGoodsAddressService cgas;
	@Autowired
	private IQueryProduceService iqps;
	
	/**
	 * 获取企业资质信息
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/getServInfo",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String  getServInfo(String t,@RequestParam("id")long id) throws IOException {
		
		Map<String, Object> map=new HashMap();
		System.out.println(id+">>>>>>>>>");
		EnterpriseToOutBean list=enterpriseToOutService.getEnterpriseOutInfo(id);
		System.out.println(id+">>>>>>>>>"+JSON.json(list));
		map.put("EnterpriseToOutBean", list);
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(list);
			return data.toString();
		}else
		return JSON.json(map);
	}
	
	/**
	 * 获取店铺商品列表
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/ProductList",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String  productList(String t,String id) throws Exception  {
		HashMap<String,CmsProduct> cmsProduct= new HashMap<String,CmsProduct>();
		  CmsProduct cp = new CmsProduct();
		if(!id.equals("")){
			cp.setEnterpriceId(id);
			System.out.println("id======="+cp.getEnterpriceId());
			  cp.setEnterpriceId(id);
			  cmsProduct.put("cmsProduct",cp);
			
			//map.
			List<CmsProduct> list=productCenterService.selectProductList(cmsProduct);
			DataList data=new DataList();
			if(t!=null&&t.equals("App"))
			{
				data.setListData(list);
				return data.toString();
			}else
				return JSON.json(list);
		}
		return "";
	}
	/**
	 * 推荐商铺内其他同类商品信息
	 * 作者： 李俊霖
	 * 日期：2016年6月21日
	 * @param entpriseId
	 * @param industryId
	 * @param produceId
	 * @param isFamousBrand
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/OtherProducesInEnterprise",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String OtherProducesInEnterprise(String entpriseId, String industryId, String produceId,
			Integer isFamousBrand, Integer start, Integer pageSize) throws IOException{
		if(start.equals("")||start==null)
			start=1;
		if(pageSize.equals("")||pageSize==null)
			pageSize=6;
		
		PageProduce page = iqps.queryOtherProducesInEnterprise("952719890107511324", "10010101", "789687623",
			     new Integer(-1),  (start-1)*pageSize, start*pageSize);
		
		return JSON.json(page);
	}
	/**
	 * 推荐附近的其他店铺同类商品（排除本店铺）
	 * 作者： 李俊霖
	 * 日期：2016年6月22日
	 * @param param
	 * @param geoPoint
	 * @param distanceLimit
	 * @param areaId
	 * @param industry
	 * @param busiScope
	 * @param isFamousBrand
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/queryProducesInOtherEnterprise",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String queryProducesInOtherEnterprise(String entpriseId, String industryId, Integer isFamousBrand, 
			String geoPoint, Double distanceLimit, String[] areaId,
			Integer start, Integer pageSize) throws IOException{
		
		PageProduce page = iqps.queryProducesInOtherEnterprise("9527198901075113", "10010101", 
			     new Integer(-1), "", new Double(0), new String[]{}, new Integer(0), new Integer(10));
		
		return JSON.json(page);
	}
	
	/**
	 * 查询订单评论
	 * 作者： 李俊霖
	 * 日期：2016年6月21日
	 * @param coe
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/selectAllCmsXOrderEvaluation",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String selectAllCmsXOrderEvaluation(CmsXOrderEvaluation coe,Integer page,Integer pagesize) throws IOException{
		if(page==null||page.equals(""))
			page=1;
		if(pagesize==null||pagesize.equals(""))
			pagesize=10;
		System.out.println("--------------------------------");
		DataList list=cgas.selectAllCmsXOrderEvaluation(coe, (page-1)*pagesize, page*pagesize);
		return JSON.json(list);
		
	}
	
	
	@RequestMapping(value="/selectAllCmsXProductEvaluation",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String selectAllCmsXProductEvaluation(String productId,String storeId,Integer page,Integer pagesize,String level) throws IOException{
		if(page==null||page.equals(""))
			page=1;
		if(pagesize==null||pagesize.equals(""))
			pagesize=10;
		if(level==null||level.equals("null"))
			level="9";
		System.out.println("--------------------------------"+level);
		DataList list=cgas.selectAllCmsXProductEvaluation(productId,storeId,(page-1)*pagesize, page*pagesize, level);
		System.out.println("--------------------------------"+JSON.json(list));
		return JSON.json(list);
		
	}


}
