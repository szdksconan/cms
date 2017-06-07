package com.cms.controller.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.elasticsearch.produce.IQueryProduceService;
import com.cms.iservice.maoyi.GoodsCenterService;
import com.cms.iservice.maoyi.ProductCenterService;
//import com.cms.iservice.maoyi.GoodsCenterService;
//import com.cms.iservice.maoyi.ProductCenterService;
import com.cms.iservice.xiaofei.type.TCmsBaseProductService;
import com.cms.model.elasticsearch.cm.PageProduce;
import com.cms.model.maoyi.CmsGoods;
//import com.cms.model.maoyi.CmsGoods;
import com.cms.model.maoyi.CmsGoodsAttr;
//import com.cms.model.maoyi.CmsProduct;
import com.cms.model.maoyi.CmsProduct;
import com.cms.model.xiaofei.DataList;

@Controller
@RequestMapping("/tcbpc")
public class TCmsBaseProductController {
	@Autowired
	private TCmsBaseProductService tCmsBaseProductService;
	@Autowired
	private ProductCenterService productCenterService;
	@Autowired
	private GoodsCenterService goodsCenterService;
	@Autowired
	private IQueryProduceService iqps;
	
	@RequestMapping("/test")
	public void selectAllCmsXReqRecGetInfo(String t,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App")){
			data.setListData(tCmsBaseProductService.getProductLevelById());
			response.getWriter().write(obj.toJSONString(data)); //返回jsonp数据  
		}
		else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(tCmsBaseProductService.getProductLevelById())+")"); //返回jsonp数据  
	}
	@RequestMapping("/test1")
	@ResponseBody
	public void selectAllCmsXReqRecGetInfos(@RequestParam("id")String id,@RequestParam("shopId")String shopId,HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		try {  
			
			HashMap<String,CmsProduct> cmsProduct= new HashMap<String,CmsProduct>();
			CmsProduct cp = new CmsProduct();
			cp.setEnterpriceId(shopId);
			cp.setProductId(id);
			cmsProduct.put("cmsProduct",cp);
			
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(productCenterService.selectProductList(cmsProduct))+")"); //返回jsonp数据  
			//response.getWriter().write(callbackFunName + "([ { name:\"John\"} ])");cmsXReqRecService.selectAllCmsXReqRecGetInfo()
	     } catch (IOException e) {  
	         e.printStackTrace();  
	     } 
	}
	
	private String getProg(List<CmsGoodsAttr> list, String productId) {
		String aa="";
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getProductId().equals(productId)){
				aa+=("【"+list.get(i).getAttrNameCn()+":"+list.get(i).getValNameCn()+"】");
				
			}
		}
		return aa;
	}
	
	@RequestMapping("/testw")
	@ResponseBody
	public void selectAllCmsXReqRecGetInfoe(@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		CmsGoods g =  goodsCenterService.selectGoodsInfoById(id);
		List<String> str = new ArrayList<String>();
		List<Nature> ns = new ArrayList<>();
		if(g!=null){
			List<CmsGoodsAttr> list = g.getCmsGoodsAttr();
			int m=0;
			for (int i = 0; i < list.size(); i++) {
				for (int j = list.size()-1; j >i ; j--) {
					if(list.get(i).getProductId().equals(list.get(j).getProductId())){
						for( int n = 0; n < str.size(); n++)
							if(str.get(n).trim().equals(list.get(j).getProductId())){
								m++;
							}
						if(m==0){
							str.add(list.get(j).getProductId());
							//System.out.println(list.get(j).getProductId()+"***");
							//System.out.println(getProg( list, list.get(j).getProductId())+"**"+list.get(j).getProductId());
							Nature na = new Nature();
							na.setId(list.get(j).getProductId());
							na.setName(getProg( list, list.get(j).getProductId()));
							ns.add(na);
						}
						m=0;
								
					}
				}
			}
		}
		
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		try {  
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(ns)+")"); //返回jsonp数据  
			//response.getWriter().write(callbackFunName + "([ { name:\"John\"} ])");cmsXReqRecService.selectAllCmsXReqRecGetInfo()
		} catch (IOException e) {  
			e.printStackTrace();  
		} 
	}
	
	@RequestMapping("/selectGoodsInfoById")
	@ResponseBody
	public void selectEnterpriseToOutService(@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		try {  
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(goodsCenterService.selectGoodsInfoById(id))+")"); //返回jsonp数据  
			//response.getWriter().write(callbackFunName + "([ { name:\"John\"} ])");cmsXReqRecService.selectAllCmsXReqRecGetInfo()
		} catch (IOException e) {  
			e.printStackTrace();  
		} 
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public void selectAllCmsXReqRecbyInfo(String t,@RequestParam("cms")String code,@RequestParam("cmscodes")String codes ,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		if(!code.equals(""))
			code=code+"__";
		if(!codes.equals(""))
			codes=code+"__";
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App")){
			data.setListData(tCmsBaseProductService.getProductCodeOrderAsc(code,codes));
			response.getWriter().write(obj.toJSONString(data)); //返回jsonp数据  
			
		}else 
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(tCmsBaseProductService.getProductCodeOrderAsc(code,codes))+")"); //返回jsonp数据  
	}
	@RequestMapping("/test3")
	public void getProduct2LevelById(@RequestParam("cms")String id,HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		try {  
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(tCmsBaseProductService.getProduct2LevelById(id))+")"); //返回jsonp数据  
			//response.getWriter().write(callbackFunName + "([ { name:\"John\"} ])");cmsXReqRecService.selectAllCmsXReqRecGetInfo()
		} catch (IOException e) {  
			e.printStackTrace();  
		} 
	}
	@RequestMapping("/test4")
	public void getProduct3LevelById(@RequestParam("cms")String id ,HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		try {  
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(tCmsBaseProductService.getProduct3LevelById(id))+")"); //返回jsonp数据  
			//response.getWriter().write(callbackFunName + "([ { name:\"John\"} ])");cmsXReqRecService.selectAllCmsXReqRecGetInfo()
		} catch (IOException e) {  
			e.printStackTrace();  
		} 
	}
	/**
	 * 搜索引擎
	 * @param param  	关键字
	 * @param geoPoint
	 * @param distanceLimit
	 * @param areaId
	 * @param industryId		行业分类ID
	 * @param start
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/supc",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String queryProducesByPC(String param, String geoPoint, Double distanceLimit,
			String areaId,String industryId,Integer isFamousBrand,Integer start, Integer pageSize,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		//param="音箱";
		if(isFamousBrand==null)
			isFamousBrand=0;
		System.out.println("*---------"+isFamousBrand+"industryId="+industryId+"start="+start+"pagesize="+pageSize);
		if(start==null||start.equals(""))
			start=1;
		if(pageSize==null||pageSize.equals(""))
			pageSize=8;
		PageProduce list=iqps.queryProducesByPC(param==null||param.equals("")||param.equals("null")?"":param, "", new Double(0), new String[]{"2323"}, industryId==null||industryId.equals("")?"":industryId, isFamousBrand,start==null?0:(start-1)*pageSize, pageSize==null?8:start*pageSize);
		Map<String, Object> map=new HashMap();
		map.put("PageProduce", list);
		return JSON.json(map);
	}
	
	/**
	 * 获取行业的父级与子级
	 * @param industryId
	 * @param start
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/industry",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String industry(String industryId, Integer start, Integer pageSize,HttpServletRequest request,HttpServletResponse response) throws IOException{
		

		
		String strTemp = "";
		String str;
		Integer type=0;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int n=4;
		int m=0;
		int len=industryId.length();
		for (int i=0; i<len; i++) {
			if (i < ((len-4)/2+1)) {
				System.out.println("========"+n+"industryId.length()="+industryId.length()+"----"+((len-4)/2+1));
				str = industryId.substring(0,n);
				n+=2;
			}
			else{
				str=industryId+"__";
				type=1;
				}
			 list=tCmsBaseProductService.industry(industryId==null||industryId.equals("")?"":industryId,  new Integer(0), new Integer(10), type);
			 m++;
		}
		Map<String,Object> map=new HashMap();
		map.put("type", list);
		//List<Map<String, Object>> list=tCmsBaseProductService.industry(industryId==null||industryId.equals("")?"":industryId,  new Integer(0), new Integer(10));
		//map.put("PageProduce", list);
		return JSON.json(map);
	
		
		
	}
	/**
	 * 查询单位
	 * 作者： 郑泽
	 * 日期：2016年6月6日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/unit")
	@ResponseBody
	public void selectGetUnit(HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		try {  
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(tCmsBaseProductService.selectGetUnit())+")"); //返回jsonp数据  
		} catch (IOException e) {  
			e.printStackTrace();  
		} 
	}
}
