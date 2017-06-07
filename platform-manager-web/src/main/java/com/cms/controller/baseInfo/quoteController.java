package com.cms.controller.baseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.manager.quoteBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
/**
 * 报价
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/quote")
public class quoteController {
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/quote";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(quoteBean quote, PageFilter ph) {
		return this.baseService.dataGridQuote(quote, ph);
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/quoteAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(quoteBean quoteBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.addQuote(quoteBean);
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
	public JSONObject delete(String bid,String eid) {
		JSONObject obj = new JSONObject();
		try {
			baseService.deleteQuote(bid,eid);
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
	public ModelAndView updatePage(String bid,String eid) {
		ModelAndView model = new ModelAndView("/basic/quoteEdit");
		quoteBean quoteBean = this.baseService.getQuote(bid,eid);
		model.addObject("quoteBean", quoteBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(quoteBean quoteBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.editQuote(quoteBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
}
