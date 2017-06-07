package com.cms.controller.userCenter.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.userCenter.CheckRegisterService;
import com.cms.model.userCenter.SysUser;
import com.cms.util.MD5Util;



/**
 * login
 * @author st
 *
 */
@Controller
@RequestMapping("/personRegister")
public class PersonRegisterContorller {
 @Autowired 
   private CheckRegisterService checkRegisterService;
 @Autowired 
 private GlobalIdService globalIdService;
	/**
	 * 跳转首页
	 * @param request
	 * @return
	 */
@RequestMapping("/register")
	public String index(HttpServletRequest request) {
		return "/register";
	}
	/*验证会员名
	 * @param uname
	 * 
	 */
	
	@RequestMapping("/checkRegister")
	@ResponseBody
	public void checkRegister(String uname,HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		response.setContentType("text/html; charset=utf-8");
		try{
			String name = request.getParameter("user").trim();
		int count=checkRegisterService.checkRegister(uname);
		
		if(count>0){
			response.getWriter().print(false);
		}
		else{
			response.getWriter().print(true);
		}
		}catch(Exception e){
			response.getWriter().print(false);
			e.getStackTrace();
		}
		
	}
	
	/*注册页面个人基本信息录入
	 *  @param realname	
	 *  @param sex
	 *  @param phone
	 *  @param tel
	 *  @param cert_type
	 *  @param cert_num
	 *  @param email
	 *  @param user_type     
	 * @return
	 */
	
	@RequestMapping("/addSysUser")
	@ResponseBody
	public String addSysUser(HttpServletRequest request,HttpServletResponse response,SysUser sysUser) throws Exception{
		String name = request.getParameter("personName").trim();
		System.out.println("对象信息"+sysUser);
		checkRegisterService.addSysUser(sysUser);
		return "Y";
	}
	
	/*
	 * 注册会员名、密码到数据库
	 *  @param request
	 * 
	 */
	@RequestMapping("/insertRegister")
	@ResponseBody
	public String insertRegister(HttpServletRequest request,HttpServletResponse response,SysUser sysUser){
		JSONObject obj = new JSONObject();
		try{
			sysUser.setUid(globalIdService.getGlobalId());//获取uid随机数.
			sysUser.setPassword(MD5Util.md5(sysUser.getPassword().toString()));//md5对密码进行加密.
			checkRegisterService.insertRegister(sysUser);//保存.
			obj.put("success", true);
		}catch(Exception e){
			obj.put("msg", e.getMessage());
		}
		return obj.toString();
	
	}
}
