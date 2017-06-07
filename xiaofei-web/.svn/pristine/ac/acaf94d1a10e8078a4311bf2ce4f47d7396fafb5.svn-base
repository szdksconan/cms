package com.cms.controller.xiaofei.shoppingcart;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.controller.test.DataTime;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.xiaofei.CmsXShoppingcartService;
import com.cms.model.xiaofei.CmsXShoppingcart;
import com.cms.model.xiaofei.DataList;

@Controller
@RequestMapping("/cart")
public class CmsXShoppinctartController {
	@Autowired
	private CmsXShoppingcartService cmsXShoppingcartService;
	@Autowired
	private GlobalIdService globalIdService;
	
	/**
	 * 把商品添加到购物车中
	 * 作者： 郑泽
	 * 日期：2016年5月13日
	 * @param cmsXShoppingcart
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addGoodsToShoppinctart")
	@ResponseBody
	public void addGoodsToShoppinctart(CmsXShoppingcart cmsXShoppingcart,HttpServletRequest request,HttpServletResponse response){
		//System.out.println(cmsXShoppingcart+"*********************");
		/*JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		try {  
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXShoppingcartService.addGoodsToShoppinctart(cmsXShoppingcart))+")"); //返回jsonp数据  
			//response.getWriter().write(callbackFunName + "([ { name:\"John\"} ])");cmsXReqRecService.selectAllCmsXReqRecGetInfo()
	     } catch (IOException e) {  
	         e.printStackTrace();  
	     } */
		cmsXShoppingcart.setId(Long.toString(globalIdService.getGlobalId()));
		cmsXShoppingcart.setAddTime(DataTime.getTime());
		cmsXShoppingcartService.addGoodsToShoppingcart(cmsXShoppingcart);
	}
	
	/**
	 * 根据用户ID查询用户购物车中的商品信息
	 * 作者： 郑泽
	 * 日期：2016年5月26日
	 * @param userId
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/userCart")
	@ResponseBody
	public void selectGetUserIdAndShoppingcartAllInfo(String t,@RequestParam("userId")String userId,
			@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		/*List<Map<String, Object>> list = (List<Map<String, Object>>) cmsXShoppingcartService.selectGetUserIdAndShoppingcartAllInfo(userId,(page -1) *pageSize , pageSize);
		for (Map<String, Object> map : list) {
			System.out.println("*************"+map+"*******");
		}*/
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXShoppingcartService.selectGetUserIdAndShoppingcartAllInfo(userId,(page -1) *pageSize , pageSize));
			response.getWriter().write(data.toString());
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXShoppingcartService.selectGetUserIdAndShoppingcartAllInfo(userId,(page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据购物车ID查询用户购物车中的商品信息
	 * 作者： 郑泽
	 * 日期：2016年5月26日
	 * @param lj_jscart
	 * @param g_cart
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectUserShopping")
	@ResponseBody
	public void selectUserShopping(String t,@RequestParam("lj_jscart[]")List<String> lj_jscart,
			@RequestParam("g_cart[]")List<Double> g_cart,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		Double pricet=0.0;
		for (int i = 0,j=0;i < lj_jscart.size()&&j<g_cart.size(); i++,j++) {
			CmsXShoppingcart cart = cmsXShoppingcartService.selectGetIdAndShoppingcartAllInfo(lj_jscart.get(i));
			pricet+=cart.getProductPrice()*g_cart.get(j);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("sp_num", lj_jscart.size());
		map.put("sp_pricet", pricet);
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(map);
			response.getWriter().write(data.toString());
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(map)+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据ID删除购物车中对应的商品
	 * 作者： 郑泽
	 * 日期：2016年5月26日
	 * @param Id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/del_cart")
	@ResponseBody
	public void delShoppingcartAndGoods(@RequestParam("Id")String Id,HttpServletRequest request,HttpServletResponse response){
		if(Id!=null){
			cmsXShoppingcartService.delShoppingcartAndGoods(Id);
		}
	}
}
