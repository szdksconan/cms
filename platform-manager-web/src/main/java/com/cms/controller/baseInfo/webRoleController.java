package com.cms.controller.baseInfo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.manager.webRoleBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
/**
 * 车货匹配角色
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("webRole")
public class webRoleController {
	@Autowired
	private baseService baseService;
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/role";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(webRoleBean role, PageFilter ph) {
		return this.baseService.dataGridWebRole(role, ph);
	}
	
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Long id) {

		
		try{
			webRoleBean r = this.baseService.getWebRole(id);
			request.setAttribute("role", r);
		
		}finally {
			
		}
		return "/basic/roleEdit";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(webRoleBean role) {
		JSONObject obj = new JSONObject();
			
		
		try{
			this.baseService.updateWebRole(role);
			obj.put("success", true);
			obj.put("msg", "编辑成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally {
			
		}
		return obj;
	}
	
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/roleAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(webRoleBean bean) {
		JSONObject obj = new JSONObject();
		
		try{
			this.baseService.addWebRole(bean);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally {
			
		}
		return obj;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(Long id) {
		JSONObject obj = new JSONObject();
		
		try{
			this.baseService.deleteWebRole(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally {
			
		}
		return obj;
	}
	
	@RequestMapping("/grantPage")
	public String grantPage(HttpServletRequest request, Long id) {
		JSONObject obj = new JSONObject();
		
		try{
		request.setAttribute("role", this.baseService.getWebRole(id));
		}finally {
			
		}
		return "/basic/roleGrant";
	}

	@RequestMapping("/grant")
	@ResponseBody
	public JSONObject grant(webRoleBean role) {
		JSONObject obj = new JSONObject();
		
		try{
			this.baseService.addGrantWebRole(role);
			obj.put("success", true);
			obj.put("msg", "授权成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally {
			
		}
		return obj;
	}
}
