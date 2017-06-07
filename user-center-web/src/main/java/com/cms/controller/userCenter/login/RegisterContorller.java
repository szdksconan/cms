package com.cms.controller.userCenter.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.userCenter.SysUserService;
import com.cms.model.userCenter.SysUser;
import com.google.code.kaptcha.Constants;

/**
 * register
 * @author st
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterContorller {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private GlobalIdService globalIdService;
	
	/**
	 * 企业注册第1步
	 * @param request
	 * @return
	 */
	@RequestMapping("/step1")
	@ResponseBody
	public String stepOne(SysUser user,HttpServletRequest request,HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		
		try{
			long uid = globalIdService.getGlobalId();
			user.setUid(uid);
			sysUserService.addUserOne(user);
			obj.put("success", true);
			obj.put("uid", uid+"");
		}catch(Exception e){
			obj.put("msg", e.getMessage());
		}
		return obj.toString();
	}
	/**
	 * 企业注册第2步
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/step2")
	@ResponseBody
	public String steptwo(SysUser user,HttpServletRequest request,HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		
		try{
			sysUserService.addUserTwo(user);
			obj.put("success", true);
		}catch(Exception e){
			obj.put("msg", e.getMessage());
		}
		return obj.toString();
	}
	@RequestMapping("/validate")  
	@ResponseBody
    public void validate(HttpServletRequest request, HttpServletResponse response) throws Exception {  
		response.setContentType("text/html; charset=utf-8");
        String validatecode = request.getParameter("validateCode").trim();
        String code = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString().trim(); 
        if(!code.equals(validatecode)){
        	response.getWriter().print(false);
        }else{
        	response.getWriter().print(true);
        }
    }  
	@RequestMapping("/nameRegist")  
	@ResponseBody
    public void name(SysUser user,HttpServletRequest request, HttpServletResponse response) throws Exception {  
		response.setContentType("text/html; charset=utf-8");
		try{
			String name = request.getParameter("comusername").trim();
			List ls = sysUserService.getByName(user);
			if(ls.size() > 0){
				response.getWriter().print(false);
			}else{
				response.getWriter().print(true);
			}
		}catch(Exception e){
			response.getWriter().print(false);
			e.getStackTrace();
		}
        
    } 
	@RequestMapping("/newbieRoad")
	public String newbieRoad(HttpServletRequest request) {
		return "/newbieRoad";
	}
}
