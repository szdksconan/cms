package com.cms.controller.baseInfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.manager.comboBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;

/**
 * 套餐
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/combo")
public class comboController {
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/combo";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(comboBean combo, PageFilter ph) {
		return this.baseService.dataGridCombo(combo, ph);
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/comboAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(comboBean comboBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.addCombo(comboBean);
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
			baseService.deleteCombo(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@RequestMapping("/editPage")
	public ModelAndView updatePage(Long id) {
		ModelAndView model = new ModelAndView("/basic/comboEdit");
		comboBean comboBean = this.baseService.getCombo(id);
		model.addObject("comboBean", comboBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(comboBean comboBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.editCombo(comboBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/state")
	@ResponseBody
	public JSONObject state(String json ) {
		JSONObject obj = new JSONObject();
		obj = JSONObject.parseObject(json);
		try {
			baseService.stateCombo(obj);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
}
