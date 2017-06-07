package com.cms.controller.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.manager.baseDicBean;
import com.cms.model.manager.premiumBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
/**
 * 险种
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/premium")
public class premiumController {
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/premium";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(premiumBean premium, PageFilter ph) {
		return this.baseService.dataGridPremium(premium, ph);
	}
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/premiumAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(premiumBean premiumBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.addPremium(premiumBean);
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
			baseService.deletePremium(id);
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
	@RequestMapping("/editPage")
	public ModelAndView updatePage(Long id) {
		ModelAndView model = new ModelAndView("/basic/premiumEdit");
		premiumBean premiumBean = this.baseService.getPremium(id);
		model.addObject("premiumBean", premiumBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(premiumBean premiumBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.editPremium(premiumBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/selectTypeJson")
	@ResponseBody
	public String  selectTypeJson(String q,String pid){
		JSONArray ja = new JSONArray();
		List<baseDicBean> list =  this.baseService.getByPidBaseDic(pid);
		for(int i=0;i<list.size();i++){
			baseDicBean baseDicBean = (baseDicBean) list.get(i);	
			ja.add(baseDicBean);
		}
		return ja.toString();
	}
}
