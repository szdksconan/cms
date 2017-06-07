package com.cms.controller.company;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.iservice.manager.company.companyService;
import com.cms.model.manager.companyBean;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.util.UploadUtil;
/**
 * 企业
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("company")
public class companyController {
	@Autowired	
	private companyService companyService;
	
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/company/company";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(companyBean company, PageFilter ph) {
		return this.companyService.dataGrid(company, ph);
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/company/companyAddBak";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(String json,MultipartHttpServletRequest request) {
		JSONObject obj = JSONObject.parseObject(json);
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		try {
			Map<String,String> map = UploadUtil.uploadImg(request, obj.getString("id"), GlobalConstant.companyFiles);
			obj.putAll(map);
			obj.put("sessionId", sessionInfo.getUserId());
			companyService.add(obj);
			obj = new JSONObject();
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally {
			
		}
		return obj;
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/updateFlag")
	@ResponseBody
	public JSONObject updateFlag(String json) {
		JSONObject obj = new JSONObject();
		try {
			
			companyService.updateFlag(JSONObject.parseObject(json));
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally {
			
		}
		return obj;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public ModelAndView updatePage(Long companyId) {
		JSONObject obj = new JSONObject();
		obj.put("companyId", companyId);
		ModelAndView model = new ModelAndView("/company/companyEditBak");
		try{
			
			companyBean companyBean = this.companyService.getInfo(obj);
			model.addObject("company", companyBean);
		}finally{
			
		}
//		model.addObject("list", this.baseDicService.getByPid("4"));
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(String json,MultipartHttpServletRequest request) {
		JSONObject obj = JSONObject.parseObject(json);
		try {
			Map<String,String> map = UploadUtil.uploadImg(request, obj.getString("id"), GlobalConstant.companyFiles);
			obj.putAll(map);
			
			companyService.update(obj);
			obj = new JSONObject();
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally{
			
		}
		return obj;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/viewPage")
	public ModelAndView viewPage(Long companyId) {
		JSONObject obj = new JSONObject();
		obj.put("companyId", companyId);
		ModelAndView model = new ModelAndView("/company/companyView");
		try{
			
			companyBean companyBean = this.companyService.getInfo(obj);
			model.addObject("company", companyBean);
		}finally{
			
		}
		model.addObject("list", this.baseService.getByPidBaseDic("4"));
		return model;
	}
	
	@RequestMapping("rePwd")
	@ResponseBody
	public JSONObject rePwd(String id){
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", id);
			
			companyService.updatePwd(obj);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally{
			
		}
		return obj;
	}
	
	@RequestMapping("/registerPage")
	public String registerPage() {
		return "/company/companyRegister";
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public JSONObject register(String json,MultipartHttpServletRequest request){
		JSONObject obj = new JSONObject();
		try{
			obj = this.add(json, request);
			if (obj.getBooleanValue("success")){
				obj.put("msg", "注册成功，等待后台审核确认！");
			}
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		finally {
			
		}
		return obj;
	}
	
	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager2")
	public String manager2() {
		return "/company/card";
	}

	@RequestMapping("/dataGrid2")
	@ResponseBody
	public Grid dataGrid2(companyBean company, PageFilter ph) {
		Grid grid = new Grid();
		
		try{
			List<companyBean> list = this.companyService.dataGrid2(company, ph);
			grid.setRows(list);
			grid.setTotal(list.size());
		}finally {
			
		}
		return grid;
	}
	
	/**
	 * 审核页面
	 * @param id
	 * @return
	 */
	@RequestMapping("auditPage")
	public ModelAndView auditPage(Long id){
		ModelAndView model = new ModelAndView("/company/companyaudit");
		model.addObject("id", id);
		return model;
	}
	
	/**
	 * 审核
	 * @return
	 */
	@RequestMapping("updateaudit")
	@ResponseBody
	public JSONObject updateaudit(companyBean company){
		JSONObject obj = new JSONObject();
		try{
			obj = (JSONObject) JSONObject.toJSON(company);
			this.companyService.updateaudit(obj);
			obj = new JSONObject();
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
}
