package com.cms.controller.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.manager.Tree;
import com.cms.model.manager.baseDicBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;

/**
 * 基本字典
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/baseDic")
public class baseDicController {
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/baseDic";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(baseDicBean basic, PageFilter ph) {
		return this.baseService.dataGridBaseDic(basic, ph);
	}
	
	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<baseDicBean> treeGrid() {
		return this.baseService.treeGridBaseDic();
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/baseDicAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(baseDicBean baseDicBean) {

		JSONObject obj = new JSONObject();
		try {
			baseService.addBaseDic(baseDicBean);
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
			baseService.deleteBaseDic(id);
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
	@RequestMapping("/updatePage")
	public ModelAndView updatePage(Long id) {
		ModelAndView model = new ModelAndView("/admin/orderDicEdit");
		baseDicBean baseDicBean = this.baseService.getBaseDic(id);
		model.addObject("basic"+"Bean", baseDicBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(Long id) {
		JSONObject obj = new JSONObject();
		baseDicBean baseDicBean = baseService.getBaseDic(id);
		String tag = baseDicBean.getTag();
		if("1".equals(tag)){
			tag="0";
		}
		else{
			tag="1";
		}
		baseDicBean.setTag(tag);
		try {
			baseService.updateBaseDic(baseDicBean);
			obj.put("success", true);
			obj.put("msg", "更改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 获取所有字典资源
	 * @param flag
	 * @return
	 */
	@RequestMapping("/allTree")
	@ResponseBody
	public List<Tree> allTree(boolean flag) {//true获取全部资源,false只获取菜单资源
		return this.baseService.allTreeBaseDic(flag);
	}
}
