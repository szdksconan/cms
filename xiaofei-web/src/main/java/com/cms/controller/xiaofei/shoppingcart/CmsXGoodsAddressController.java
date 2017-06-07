package com.cms.controller.xiaofei.shoppingcart;

import java.io.IOException;
import java.util.List;

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
import com.cms.iservice.xiaofei.CmsXGoodsAddressService;
import com.cms.model.xiaofei.CmsXGoodsAddress;
import com.cms.model.xiaofei.DataList;
import com.cms.util.CmsUtil;

@Controller
@RequestMapping("/addr")
public class CmsXGoodsAddressController {
	@Autowired
	private CmsXGoodsAddressService cmsXGoodsAddressService;
	@Autowired
	private GlobalIdService globalIdService;
	
	/**
	 * 用户添加收货地址
	 * 作者： 郑泽
	 * 日期：2016年5月26日
	 * @param address
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("addUserAddress")
	@ResponseBody
	public void addUserAndDeliveryAndAddress(CmsXGoodsAddress address,HttpServletRequest request,HttpServletResponse response) throws Exception{
		address.setAddrId(Long.toString(globalIdService.getGlobalId()));
		address.setUserId(CmsUtil.CheckLogin(request).toString());
		/*address.setAddressProvince("四川");
		address.setAddressCity("成都");
		address.setAddressCounty("高新");*/
		address.setUserName("王二");
		address.setAddTime(DataTime.getTime());
		System.out.println(address+"***");
		cmsXGoodsAddressService.addUserAndDeliveryAndAddress(address);
	}
	
	/**
	 * 根据用户查询用户的收货地址
	 * 作者： 郑泽
	 * 日期：2016年5月26日
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("select_user_address")
	@ResponseBody
	public void selectUserAndGoodsAndAddress(String t,@RequestParam("uId")String uId,HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		uId=CmsUtil.CheckLogin(request);
		System.out.println(uId);
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXGoodsAddressService.selectUserAndGoodsAndAddress(uId));
			response.getWriter().write(obj.toJSONString(data));
		}else 
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXGoodsAddressService.selectUserAndGoodsAndAddress(uId))+")"); //返回jsonp数据  
	}
	/**
	 * 根据地址的ID 查询收货的详细地址
	 * 作者： 李俊霖
	 * 日期：2016年5月28日
	 * @param uId
	 * @param request
	 * @param response
	 */
	@RequestMapping("select_user_addressId")
	@ResponseBody
	public String selectUserAndGoodsAndAddressId(String t,String addressId,HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		CmsXGoodsAddress list=cmsXGoodsAddressService.selectUserAndGoodsAndAddressId(addressId);
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(list);
			return data.toString();
		}else 
			return obj.toJSONString(list);
		
		/*response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		try {  
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXGoodsAddressService.selectUserAndGoodsAndAddressId(addressId))+")"); //返回jsonp数据  
	     } catch (IOException e) {  
	         e.printStackTrace();  
	     }*/
	}
	/**
	 * 根据Id删除用户的收货地址
	 * 作者： 郑泽
	 * 日期：2016年6月15日
	 * @param t
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteOderByIdGetUser")
	@ResponseBody
	public void deleteOderByIdGetUser(String t,@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXGoodsAddressService.deleteOderByIdGetUser(id));
			response.getWriter().write(obj.toJSONString(data));
		}else 
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXGoodsAddressService.deleteOderByIdGetUser(id))+")"); //返回jsonp数据  
	}
	/**
	 * 修改信息
	 * 作者： 郑泽
	 * 日期：2016年6月21日
	 * @param address
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/updateUserAndGoodsAndAddressId")
	@ResponseBody
	public String updateUserAndGoodsAndAddressId(CmsXGoodsAddress address,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		/*response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 */	
		
		return obj.toJSONString(cmsXGoodsAddressService.updateUserAndGoodsAndAddressId(address));
		//response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXGoodsAddressService.updateUserAndGoodsAndAddressId(address))+")"); //返回jsonp数据  
	}

}
