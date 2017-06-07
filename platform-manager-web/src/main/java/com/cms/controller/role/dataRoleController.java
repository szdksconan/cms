package com.cms.controller.role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.role.accessService;
import com.cms.model.manager.dataRoleBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
/**
 * 数据角色
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("dataRole")
public class dataRoleController {
	@Autowired
	private accessService accessService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/role/dataRole";
	}
	
	@RequestMapping("/getDataRoleList")
	@ResponseBody
	public List<dataRoleBean> getDataRoleList(dataRoleBean dataRole, PageFilter ph){
		return this.accessService.dataGrid(null, null).getRows();
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(dataRoleBean dataRole, PageFilter ph) {
		return this.accessService.dataGrid(dataRole, ph);
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/role/dataRoleAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(dataRoleBean dataRoleBean) {
		JSONObject obj = new JSONObject();
		try {
			accessService.add(dataRoleBean);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(Long id) {
		JSONObject obj = new JSONObject();
		try {
			accessService.delete(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/editPage")
	public ModelAndView updatePage(Long id) {
		ModelAndView model = new ModelAndView("/role/dataRoleEdit");
		dataRoleBean dataRoleBean = this.accessService.getDataRole(id);
		model.addObject("dataRole", dataRoleBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject update(dataRoleBean dataRoleBean) {
		JSONObject obj = new JSONObject();
		try {
			accessService.update(dataRoleBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/grantPage")
	public String grantPage(HttpServletRequest request, Long id) {
		request.setAttribute("dataRole", this.accessService.getDataRole(id));
		return "/role/dataRoleGrant";
	}

	@RequestMapping("/grant")
	@ResponseBody
	public JSONObject grant(dataRoleBean role) {
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
