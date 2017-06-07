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
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.CityBean;

/**
 * 区县
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/city")
public class cityController {
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/city";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(CityBean city, PageFilter ph) {
		return this.baseService.dataGridCity(city, ph);
	}
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/cityAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(CityBean cityBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.addCity(cityBean);
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
			baseService.deleteCity(id);
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
		ModelAndView model = new ModelAndView("/basic/cityEdit");
        CityBean cityBean = this.baseService.getCity(id);
		model.addObject("cityBean", cityBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(CityBean cityBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.editCity(cityBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/selectCityJson")
	@ResponseBody
	public String  selectAreaJson(String q,boolean nosession){
		JSONArray ja = new JSONArray();
		List<CityBean> list =  baseService.selectCityJsonCity(q==null?"":q);
		for(int i=0;i<list.size();i++){
            CityBean cityBean = (CityBean) list.get(i);
			ja.add(cityBean);
		}
		if (nosession){
			return "callBack("+ja.toString()+",'area')";
		}else {
			return ja.toString();
		}
	}
	
	@RequestMapping("/selectCityJson2")
	@ResponseBody
	public String  selectCityJson2(String q,String pid,String pid2){
		JSONArray ja = new JSONArray();
		List<CityBean> list =  baseService.selectCityJson2City(q,pid,pid2);
		for(int i=0;i<list.size();i++){
            CityBean cityBean = (CityBean) list.get(i);
			ja.add(cityBean);
		}
		return ja.toString();
	}
}
