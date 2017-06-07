package com.cms.controller.xiaofei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;
import javax.xml.ws.spi.http.HttpContext;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.controller.test.ApplyJoin;
import com.cms.controller.test.DataTime;
import com.cms.controller.test.Http;
import com.cms.controller.test.HttpRequest;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.ShengchanOverseasService;
import com.cms.iservice.xiaofei.CmsXLocalDictService;
import com.cms.iservice.xiaofei.CmsXRecruitService;
import com.cms.iservice.xiaofei.CmsXShopApplyService;
import com.cms.model.xiaofei.CmsXAttachment;
import com.cms.model.xiaofei.CmsXLocalDict;
import com.cms.model.xiaofei.CmsXRecruit;
import com.cms.model.xiaofei.CmsXRecruitArea;
import com.cms.model.xiaofei.CmsXRecruitIndustry;
import com.cms.model.xiaofei.CmsXRecruitProduct;
import com.cms.model.xiaofei.CmsXShopApply;
import com.cms.model.xiaofei.DataList;

@Controller
@RequestMapping("/open")
@SuppressWarnings("static-access")
public class CmsXShopApplyController {
	
	@Autowired
	private GlobalIdService globalIdService;
	@Autowired
	private CmsXShopApplyService cmsXShopApplyService;
	@Autowired
	private CmsXLocalDictService cmsXLocalDictService;
	/*@Autowired
	private ShengchanOverseasService shengchanOverseasService;*/
	@Autowired
	private CmsXRecruitService cmsXRecruitService;
	
	public String getPath(String filePath,HttpServletRequest request){
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String path = realPath + filePath;
		return path;
	}
	
	public void addCmsXShopApplyInfo(){
		
	}
	
	/**
	 * 查询全部创业申请
	 * 作者： 郑泽
	 * 日期：2016年6月7日
	 * @param loclCode 地理位置代码
	 * @param typeCode 商品分类代码
	 * @param page 当前页码
	 * @param pageSize	分页需要显示的数量
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectAllUserAndShopAndAttachmentGetInfo")
	@ResponseBody
	public void selectAllUserAndShopAndAttachmentGetInfo(String t,@RequestParam("loclCode")String loclCode,@RequestParam("typeCode")String typeCode,
			@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXShopApplyService.selectAllUserAndShopAndAttachmentGetInfo( loclCode, typeCode, (page -1) *pageSize , pageSize));
			response.getWriter().write(data.toString());
		}else
			response.getWriter().write(callbackFunName + "("+
		obj.toJSONString(cmsXShopApplyService.selectAllUserAndShopAndAttachmentGetInfo( loclCode, typeCode, (page -1) *pageSize , pageSize))+")"); //返回jsonp数据  

	}
	
	/**
	 * 根据用户ID查询用户自己的创业信息
	 * 作者： 郑泽
	 * 日期：2016年6月2日
	 * @param uId
	 * @param page
	 * @param pageSize
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectUserByIdAndShopApplyGetInfo")
	@ResponseBody
	public void selectUserByIdAndShopApplyGetInfo(String t,@RequestParam("key")String key,@RequestParam("uId")String uId,
			@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		key = URLDecoder.decode(key, "UTF-8");
		System.out.println("key:>>>>>>>>>>>"+key);
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		if(t!=null&&t.equals("App")){
			response.getWriter().write(obj.toJSONString(cmsXShopApplyService.selectUserByIdAndShopApplyGetInfo(uId,key, (page -1) *pageSize , pageSize))); //返回jsonp数据  
		}else{
			response.getWriter().write(callbackFunName + "("+
					obj.toJSONString(cmsXShopApplyService.selectUserByIdAndShopApplyGetInfo(key,uId, (page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
		}
	}
	
	/**
	 * 根据ID查询创业详情
	 * 作者： 郑泽
	 * 日期：2016年6月2日
	 * @param Id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/selectGetCmsXShopApplyByIdAndInfo")
	@ResponseBody
	public void selectGetCmsXShopApplyByIdAndInfo(@RequestParam("Id")String Id,HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		try {  
			response.getWriter().write(callbackFunName + "("+
					obj.toJSONString(cmsXShopApplyService.selectGetCmsXShopApplyByIdAndInfo(Id))+")"); //返回jsonp数据  
		} catch (IOException e) {  
			e.printStackTrace();  
		}
	}
	
	@RequestMapping("/jumpOpenShop")
	public String jumpOpenShop(HttpServletRequest request,HttpServletResponse response){
		return "openshop/index_kd";
	}
	
	/**
	 * 添加用户创业信息申请
	 * 作者： 郑泽
	 * 日期：2016年6月14日
	 * @param t
	 * @param join
	 * @return
	 */
	@RequestMapping(value="/application",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String updateRepublicsApplicationForCustomer(String t,ApplyJoin join){
		JSONObject json = new JSONObject();
		JSONObject jsons = new JSONObject();
		CmsXShopApply cmsXShopApply = new CmsXShopApply(Long.toString(globalIdService.getGlobalId()), join.getMerchantInfoId(), null,
				join.getMerchantName(), join.getMerchantContactPerson(), join.getInvestmentOrderCode(), join.getProductIds(),
				join.getProvinceId(), join.getProvinceName(), join.getRegionId(), join.getRegionName(),
				join.getCityId(), join.getCityName(), join.getBrief(), DataTime.getTime(),join.getInvestmentOrderId());
		json.put("compId", join.getCompId());//生产商id
		json.put("companyName", join.getCompanyName());//生产商名称
		json.put("merchantInfoId", join.getMerchantInfoId());//消费者id
		json.put("merchantName", join.getMerchantName());//消费者名称
		json.put("investmentOrderId", join.getInvestmentOrderId());//招商单id
		json.put("investmentOrderCode", join.getInvestmentOrderCode());//招商单号
		json.put("investmentOrderName", join.getInvestmentOrderName());//招商单名称
		json.put("productIds", join.getProductIds());//招商产品id" (如果是多个用","分割)
		json.put("productNames", join.getProductNames());//产品名称(如果是多个用","分割)
		json.put("merchantLocationName", join.getMerchantLocationName());//所在区域
		json.put("merchantContactPerson", join.getMerchantContactPerson());//联系电话
		//JSONObject jsons1 = shengchanOverseasService.updateRepublicsApplicationForCustomer(json);
		Integer is = this.cmsXShopApplyService.addCmsXShopApplyInfo(cmsXShopApply);
		jsons.put("xf", is);
		//jsons.put("sc", jsons1);
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(jsons);
			return data.toString();
		}else
			return jsons.toString();
	}
	
	@RequestMapping(value="/addCmsXRecruit",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String addCmsXRecruit(String t){
		CmsXRecruit r = new CmsXRecruit();
		r.setId(Long.toString(globalIdService.getGlobalId()));
		CmsXRecruitArea a = new CmsXRecruitArea();
		a.setId(Long.toString(globalIdService.getGlobalId()));
		CmsXRecruitIndustry i = new CmsXRecruitIndustry();
		i.setId(Long.toString(globalIdService.getGlobalId()));
		CmsXRecruitProduct p = new CmsXRecruitProduct();
		p.setId(Long.toString(globalIdService.getGlobalId()));
		ArrayList<CmsXRecruitArea> cmsXRecruitAreas = new ArrayList<>();
		ArrayList<CmsXRecruitIndustry> cmsXRecruitIndustrys= new ArrayList<>();
		ArrayList<CmsXRecruitProduct> cmsXRecruitProducts= new ArrayList<>();
		cmsXRecruitAreas.add(a);
		cmsXRecruitIndustrys.add(i);
		cmsXRecruitProducts.add(p);
		boolean is = this.cmsXRecruitService.addCmsXRecruit(r, cmsXRecruitAreas, cmsXRecruitIndustrys, cmsXRecruitProducts);
		System.out.println(is+"&&&&&&&&&&&&&&&&&&&&");
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(r);
			return data.toString();
		}else
			return r.toString();
	}
	
	/**
	 * 查询全部招募信息
	 * 作者： 郑泽
	 * 日期：2016年6月6日
	* @param type 0:生产商 1:贸易商
	 * @param typeId 商品分类代码
	 * @param title 公司名称或者招募信息
	 * @param code	地区的代码
	 * @param page 	当前页码
	 * @param pageSize	每页显示多少条数据
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectAllCmsXRecruitGetInfo")
	@ResponseBody
	public void selectAllCmsXRecruitGetInfo(String t,@RequestParam("type")String type,@RequestParam("typeId")String typeId,
			@RequestParam("title")String title,@RequestParam("code")String code,
			@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXRecruitService.selectAllCmsXRecruitGetInfo(type, typeId, title, code, (page -1) *pageSize, pageSize));
			response.getWriter().write(obj.toJSONString(data));
		}else 
				response.getWriter().write(callbackFunName + "("+
						obj.toJSONString(cmsXRecruitService.selectAllCmsXRecruitGetInfo(type, typeId, title, code, (page -1) *pageSize, pageSize))+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据Id查询对应的招募信息
	 * 作者： 郑泽
	 * 日期：2016年6月14日
	 * @param t
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selectCmsXRecruitByIdAndInfo")
	@ResponseBody
	public void selectCmsXRecruitByIdAndInfo(String t,@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXRecruitService.selectCmsXRecruitByIdAndInfo(id));
			response.getWriter().write(obj.toJSONString(data));
		}else 
			response.getWriter().write(callbackFunName + "("+
					obj.toJSONString(cmsXRecruitService.selectCmsXRecruitByIdAndInfo(id))+")"); //返回jsonp数据  
	}
	/**
	 * 最新商机
	 * 作者： 郑泽
	 * 日期：2016年6月14日
	 * @param t
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selectLatestAndBusinessInfo")
	@ResponseBody
	public void selectLatestAndBusinessInfo(String t,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXRecruitService.selectLatestAndBusinessInfo());
			response.getWriter().write(obj.toJSONString(data));
		}else 
			response.getWriter().write(callbackFunName + "("+
					obj.toJSONString(cmsXRecruitService.selectLatestAndBusinessInfo())+")"); //返回jsonp数据  
	}
	/**
	 * 推荐商机
	 * 作者： 郑泽
	 * 日期：2016年6月14日
	 * @param t
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selectGetRecommendedAndBusinessInfo")
	@ResponseBody
	public void selectGetRecommendedAndBusinessInfo(String t,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXRecruitService.selectGetRecommendedAndBusinessInfo());
			response.getWriter().write(obj.toJSONString(data));
		}else 
			response.getWriter().write(callbackFunName + "("+
					obj.toJSONString(cmsXRecruitService.selectGetRecommendedAndBusinessInfo())+")"); //返回jsonp数据  
	}
	
	/**
	 * 物流招商
	 * 作者： 郑泽
	 * 日期：2016年6月18日
	 * @param t
	 * @param page
	 * @param pageSize
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	/*@RequestMapping("/chinaMerchantsLogistics")
	@ResponseBody
	public void chinaMerchantsLogistics(String t,@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		String IP = HttpRequest.readAddress(request, "wuliuapi");
		String getURL="?PageIndex="+1+"&PageSize="+2;
		HttpRequest.sendHPost(IP+"/api/platform/unusedline"+getURL, "key=123&v=456");
	}*/
	@RequestMapping("/chinaMerchantsLogistics")
	@ResponseBody
	public void chinaMerchantsLogistics(String t,@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		String IP = HttpRequest.readAddress(request, "wuliuapi");
		String getURL="PageIndex="+1+"&PageSize="+2;
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称  
		/*String url = IP+"/api/platform/unusedline"+getURL;
        String json = HttpRequest.load_JSON(url);*/
		String json = HttpRequest.sendGet(IP+"/api/platform/unusedline", getURL);
        System.out.println("---"+json);
        response.getWriter().write(callbackFunName + "("+
					json+")"); //返回jsonp数据  
	}
	
}
