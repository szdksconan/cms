package com.cms.controller.baseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.manager.messageLogBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
/**
 * 短信
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/messageLog")
public class messageLogController {
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/messageLog";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(messageLogBean messageLog, PageFilter ph) {
		return this.baseService.dataGridMessageLog(messageLog, ph);
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/messageLogAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(messageLogBean messageLogBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.addMessageLog(messageLogBean);
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
			baseService.deleteMessageLog(id);
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
		ModelAndView model = new ModelAndView("/basic/messageLogEdit");
		messageLogBean messageLogBean = this.baseService.getMessageLog(id);
		model.addObject("messageLogBean", messageLogBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(messageLogBean messageLogBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.editMessageLog(messageLogBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
}
