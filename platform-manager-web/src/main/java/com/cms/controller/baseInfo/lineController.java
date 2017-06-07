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
import com.cms.model.manager.lineBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;

/**
 * 线路
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/line")
public class lineController {
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/line";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(lineBean line, PageFilter ph) {
		return this.baseService.dataGridLine(line, ph);
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/lineAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(lineBean lineBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.addLine(lineBean);
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
	public JSONObject delete(String id) {
		JSONObject obj = new JSONObject();
		try {
			baseService.deleteLine(id);
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
	public ModelAndView updatePage(String id) {
		ModelAndView model = new ModelAndView("/basic/lineEdit");
		lineBean lineBean = this.baseService.getLine(id);
		model.addObject("lineBean", lineBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(lineBean lineBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.editLine(lineBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	@RequestMapping("/selectLineJson")
	@ResponseBody
	public String  selectLineJson(String q,String pid){
		JSONArray ja = new JSONArray();
		List<lineBean> list =  baseService.selectLineJsonLine(q,pid);
		for(int i=0;i<list.size();i++){
			lineBean lineBean = (lineBean) list.get(i);	
			ja.add(lineBean);
		}
		return ja.toString();
	}
}
