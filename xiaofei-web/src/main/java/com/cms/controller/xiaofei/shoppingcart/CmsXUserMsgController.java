package com.cms.controller.xiaofei.shoppingcart;

import java.io.IOException;

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
import com.cms.iservice.xiaofei.CmsXUserMsgService;
import com.cms.model.xiaofei.CmsXUserMsg;
import com.cms.model.xiaofei.DataList;

@Controller
@RequestMapping("/msg")
public class CmsXUserMsgController {
	@Autowired
	private GlobalIdService globalIdService;
	@Autowired
	private CmsXUserMsgService cmsXUserMsgService;
	/**
	 * 添加消息信息
	 * 作者： 郑泽
	 * 日期：2016年6月21日
	 * @param cmsXUserMsg
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addCmsXUserMsgInfo")
	@ResponseBody
	public void addCmsXUserMsgInfo(CmsXUserMsg cmsXUserMsg,HttpServletRequest request,HttpServletResponse response){
		cmsXUserMsg.setId(Long.toString(globalIdService.getGlobalId()));
		cmsXUserMsg.setWriteTime(DataTime.getTime());
	}
	
	/**
	 * 根据用户Id查询未读取的消息
	 * 作者： 郑泽
	 * 日期：2016年6月21日
	 * @param uId
	 * @param page
	 * @param pageSize
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectUserByIdGetUserMsgAllInfo")
	@ResponseBody
	public void selectUserByIdGetUserMsgAllInfo(@RequestParam("uId")String uId,@RequestParam("page")Integer page,
			@RequestParam("pageSize")Integer pageSize,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
		response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXUserMsgService.selectUserByIdGetUserMsgAllInfo(uId, (page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据用户Id查询未读取的消息
	 * 作者： 郑泽
	 * 日期：2016年6月21日
	 * @param uId
	 * @param page
	 * @param pageSize
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectGetUserByIdGetUserMsgAllInfo")
	@ResponseBody
	public void selectGetUserByIdGetUserMsgAllInfo(@RequestParam("uId")String uId,@RequestParam("page")Integer page,
			@RequestParam("pageSize")Integer pageSize,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
		response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXUserMsgService.selectGetUserByIdGetUserMsgAllInfo(uId, (page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
	}
	
	

}
