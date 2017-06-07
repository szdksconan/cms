package com.cms.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.role.accessService;
import com.cms.iservice.manager.user.userGradeService;
import com.cms.model.manager.roleBean;
import com.cms.model.manager.userBean;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
/**
 * 用户
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private userGradeService userGradeService;
	@Autowired
	private accessService accessService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/admin/user";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(userBean user, PageFilter ph) {
		return this.userGradeService.dataGrid(user, ph);
	}
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/admin/userAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(userBean userBean) {
		JSONObject obj = new JSONObject();
		try {
			userGradeService.add(userBean);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(Long id) {
		JSONObject obj = new JSONObject();
		try {
			userGradeService.deleteuser(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 修改用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/updatePage")
	public ModelAndView updatePage(Long id) {
		ModelAndView model = new ModelAndView("/admin/userEdit");
		userBean userBean = this.userGradeService.getuser(id);
		model.addObject("userBean", userBean);
		return model;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject update(userBean userBean) {
		JSONObject obj = new JSONObject();
		try {
			userGradeService.update(userBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/editPwdPage")
	public String editPwdPage(HttpServletRequest request) {
		return "/admin/userEditPwd";
	}
	
	@RequestMapping("/editUserPwd")
	@ResponseBody
	public JSONObject editUserPwd(HttpServletRequest request,String oldPwd, String pwd) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		JSONObject obj = new JSONObject();
		try {
			this.userGradeService.editUserPwd(sessionInfo, oldPwd, pwd);
			obj.put("success", true);
			obj.put("msg", "密码修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("getRoleList")
	@ResponseBody
	public List<roleBean> getRoleList(){
		JSONObject obj = new JSONObject();
		obj.put("status", "1");
		return this.accessService.dataGridRole(null, null).getRows();
	}
}
