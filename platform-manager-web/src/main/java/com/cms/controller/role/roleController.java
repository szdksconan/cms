package com.cms.controller.role;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.role.accessService;
import com.cms.model.manager.roleBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
/**
 * 资源角色
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("role")
public class roleController {
	@Autowired
	private accessService accessService;
	
	@RequestMapping("/manager")
	public String manager() {
		return "/role/role";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(roleBean role, PageFilter ph) {
		JSONObject obj = (JSONObject) JSONObject.toJSON(role);
		return this.accessService.dataGridRole(obj, ph);
	}
	
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Long id) {
		roleBean r = this.accessService.getRole(id);
		request.setAttribute("role", r);
		return "/role/roleEdit";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(roleBean role) {
		JSONObject obj = new JSONObject();
		try {
			this.accessService.update(role);
			obj.put("success", true);
			obj.put("msg", "编辑成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/addPage")
	public String addPage() {
		return "/role/roleAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(roleBean bean) {
		JSONObject obj = new JSONObject();
		try {
			this.accessService.add(bean);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(Long id) {
		JSONObject obj = new JSONObject();
		try {
			this.accessService.deleteRole(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/grantPage")
	public String grantPage(HttpServletRequest request, Long id) {
		request.setAttribute("role", this.accessService.getRole(id));
		return "/role/roleGrant";
	}

	@RequestMapping("/grant")
	@ResponseBody
	public JSONObject grant(roleBean role) {
		JSONObject obj = new JSONObject();
		try {
			this.accessService.addGrant(role);
			obj.put("success", true);
			obj.put("msg", "授权成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
}
