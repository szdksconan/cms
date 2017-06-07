package com.cms.controller.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.login.loginService;
import com.cms.model.manager.Tree;
import com.cms.model.manager.userShortcutMenuBean;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.SessionInfo;

/**
 * 首页快捷菜单
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("shortcutmenu")
public class userShortcutMenuController{

	@Autowired
	private loginService loginService;
	
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		return "/basic/userShortcutMenuAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(HttpServletRequest request,userShortcutMenuBean userShortcutMenu) {
		JSONObject obj = new JSONObject();
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		try {
			userShortcutMenu.setUserId(Long.parseLong(sessionInfo.getUserId()));
			loginService.add(userShortcutMenu);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 获取用户配置的快捷菜单
	 * @param request
	 * @return
	 */
	@RequestMapping("/userShortMenuList")
	@ResponseBody
	public List<userShortcutMenuBean> userShortMenuList(HttpServletRequest request) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		return this.loginService.treeGrid(Long.parseLong(sessionInfo.getUserId()));
	}

	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(Long id) {
		JSONObject obj = new JSONObject();
		try {
			this.loginService.delete(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 获取菜单资源
	 * @param session
	 * @return
	 */
	@RequestMapping("userMenuTree")
	@ResponseBody
	public List<Tree> userMenuTree(HttpSession session){
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(GlobalConstant.SESSION_INFO);
		return this.loginService.userMenuTree(sessionInfo);
	}
}
