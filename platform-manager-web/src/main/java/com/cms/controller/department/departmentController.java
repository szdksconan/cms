package com.cms.controller.department;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cms.model.manager.departmentBean;
import com.cms.model.util.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.department.departmentService;
/**
 * 部门
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("department")
public class departmentController {

	@Autowired
	private departmentService departmentService;
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/department";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public List<departmentBean> dataGrid(departmentBean bean, PageFilter ph) {
		return this.departmentService.dataGrid(bean,ph);
	}

	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		return "/basic/departmentAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(departmentBean department) {
		JSONObject obj = new JSONObject();
		try {
			this.departmentService.add(department);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}

	@RequestMapping("/get")
	@ResponseBody
	public departmentBean get(Long id) {
		return this.departmentService.get(id);
	}
	
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request,Long id) {
		request.setAttribute("department", this.departmentService.get(id));
		return "/basic/departmentEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(departmentBean org){
		JSONObject obj = new JSONObject();
		try {
			this.departmentService.update(org);
			obj.put("success", true);
			obj.put("msg", "编辑成功！");
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
			this.departmentService.delete(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/getDepartmentList")
	@ResponseBody
	public List<departmentBean> getDepartmentList(String json){
		return this.departmentService.getDepartmentList(json);
	}
}
