package com.cms.controller.baseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.manager.mileageBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
/**
 * 里程
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/mileage")
public class mileageController {
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/mileage";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(mileageBean mileage, PageFilter ph) {
		return this.baseService.dataGridMileage(mileage, ph);
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/mileageAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(mileageBean mileageBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.addMileage(mileageBean);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(String startid,String endid) {
		JSONObject obj = new JSONObject();
		try {
			baseService.deleteMileage(startid,endid);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 修改
	 * @return
	 */
	@RequestMapping("/editPage")
	public ModelAndView updatePage(String startid,String endid) {
		ModelAndView model = new ModelAndView("/basic/mileageEdit");
		mileageBean mileageBean = this.baseService.getMileage(startid,endid);
		model.addObject("mileageBean", mileageBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(mileageBean mileageBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.editMileage(mileageBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
}
