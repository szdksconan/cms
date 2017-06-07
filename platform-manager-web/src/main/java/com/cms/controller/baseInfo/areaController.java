package com.cms.controller.baseInfo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.AreaBean;
import com.cms.iservice.manager.baseInfo.baseService;

/**
 * 地市
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/area")
public class areaController {
    @Autowired
	private baseService baseService;
	


	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/area";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(AreaBean area, PageFilter ph) {
		return this.baseService.dataGridArea(area, ph);
	}
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/areaAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(AreaBean areaBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.addArea(areaBean);
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
	public JSONObject delete(String id) {
		JSONObject obj = new JSONObject();
		try {
			baseService.deleteArea(id);
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
	public ModelAndView updatePage(String id) {
		ModelAndView model = new ModelAndView("/basic/areaEdit");
        AreaBean areaBean = this.baseService.getArea(id);
		model.addObject("areaBean", areaBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(AreaBean areaBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.editArea(areaBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 获取地市字典
	 * @param q
	 * @param pid
	 * @return
	 */
	@RequestMapping("/selectAreaJson")
	@ResponseBody
	public String  selectAreaJson(String q,String pid){
		JSONArray ja = new JSONArray();
		List<AreaBean> list =  baseService.selectAreaJsonArea(q,pid);
		for(int i=0;i<list.size();i++){
            AreaBean areaBean = (AreaBean) list.get(i);
			ja.add(areaBean);
		}
		return ja.toString();
	}
	/**
	 * 获取所有字典
	 * @param nosession 跨域请求
	 * @return
	 */
	@RequestMapping("getAll")
	@ResponseBody
	public String getAll(boolean nosession) {
		List<AreaBean> list = this.baseService.getAllArea();
		JSONArray array = JSONArray.parseArray(JSONObject.toJSONString(list));
		if (nosession){
			return "callBack("+array.toString()+",'city')";
		}else {
			return array.toString();
		}
	}
}
