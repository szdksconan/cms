package com.cms.controller.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cms.model.manager.Tree;
import com.cms.model.manager.subCompanyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.company.subCompanyService;
/**
 * 网点
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("subCompany")
public class subCompanyController {
	@Autowired
	private subCompanyService subCompanyService;
	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/company/subCompany";
	}
	
	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<subCompanyBean> treeGrid() {
		return this.subCompanyService.treeGrid();
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree() {
		return this.subCompanyService.tree();
	}
	
	/**
	 * 新增
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request,Long pid) {
		request.setAttribute("pid", pid);
		return "/company/subCompanyAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(subCompanyBean subCompanyBean) {
		JSONObject obj = new JSONObject();
		try {
			subCompanyService.add(subCompanyBean);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(Long id) {
		JSONObject obj = new JSONObject();
		try {
			subCompanyService.delete(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("/editPage")
	public ModelAndView updatePage(Long id) {
		ModelAndView model = new ModelAndView("/company/subCompanyEdit");
		subCompanyBean subCompanyBean = this.subCompanyService.get(id);
		model.addObject("subCompany", subCompanyBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject update(subCompanyBean subCompanyBean) {
		JSONObject obj = new JSONObject();
		try {
			subCompanyService.update(subCompanyBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
}
