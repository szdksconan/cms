package com.cms.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.model.manager.userBean;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.SessionInfo;
import com.cms.util.UploadUtil;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.login.loginService;
import com.cms.iservice.manager.role.accessService;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("login")
public class loginContorller {
	@Autowired
	private loginService loginService;
	
	@Autowired
	private accessService accessService;
	
	/**
	 * 跳转首页
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		if ((sessionInfo != null) && (sessionInfo.getUserId() != null)) {
			request.setAttribute("menu_tree", accessService.tree(sessionInfo));
			return "/index";
		}
		return "/login";
	}
	
	/**
	 * 登录并保存session
	 * @param bean
	 * @param request
	 * @return
	 */
	@RequestMapping("/checkLogin")
	@ResponseBody
	public JSONObject checkLogin(userBean bean,HttpServletRequest request){
		userBean us = new userBean();
		JSONObject obj = new JSONObject();
		try{
			us = this.loginService.login(bean);
			if (us != null) {
				obj.put("success", true);
				SessionInfo sessionInfo = new SessionInfo();
				sessionInfo.setUserId(us.getUserId().toString());
				sessionInfo.setLoginName(us.getLoginName());
				sessionInfo.setName(us.getName());
				sessionInfo.setDepartmentId(us.getDepartmentId());
				sessionInfo.setAllAccessList(this.accessService.getAllAccessList());//获取所有资源
				sessionInfo.setAccessList(this.accessService.accessList(us.getUserId()));//获取用户资源
				request.getSession().setAttribute(GlobalConstant.SESSION_INFO, sessionInfo);
			}
		}catch(Exception e){
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 退出
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public JSONObject logout(HttpSession session) {
		JSONObject obj = new JSONObject();
		if (session != null) {
			session.invalidate();
		}
		obj.put("success", true);
		obj.put("msg", "注销成功！");
		return obj;
	}
	
	@RequestMapping("showImg")
	public void showImg(String url,HttpServletResponse response){
		try{
			if (!"".equals(url)){
				UploadUtil.showImg(response, StringEscapeUtils.unescapeHtml4(url));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
