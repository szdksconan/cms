package com.cms.controller.province;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.ProvinceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.province.provinceService;


@Controller
@RequestMapping("/province")
public class provinceController {
	@Autowired
	private provinceService provinceService;
	
	
	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("/province/province");
		return model;
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(String code,String name,String queryType,PageFilter ph) {
		ProvinceBean provinceBean = new ProvinceBean();
		provinceBean.setCode(code);
		provinceBean.setName(name);
		return this.provinceService.dataGrid(provinceBean, ph);
	}
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/province/provinceAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(ProvinceBean provinceBean) {
		JSONObject obj = new JSONObject();
		try {
			provinceService.add(provinceBean);
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
			provinceService.delete(id);
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
	public ModelAndView editPage(String id) {
		ModelAndView model = new ModelAndView("/province/provinceEdit");
        ProvinceBean provinceBean = this.provinceService.get(id);
		model.addObject("provinceBean", provinceBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(ProvinceBean provinceBean) {
		JSONObject obj = new JSONObject();
		try {
			provinceService.edit(provinceBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/selectProvinceJson")
	@ResponseBody
	public String  selectProvinceJson(String q){
		JSONArray ja = new JSONArray();
		String boxType[] = new String[]{"省份","区域","市县"};
		for(int i=0;i<boxType.length;i++){
			HashMap m = new HashMap();
			m.put("id",i+1);
			m.put("text", boxType[i]);
			ja.add(m);
		}
		return ja.toString();
	}
	@RequestMapping("/selectProvinceJson2")
	@ResponseBody
	public String  selectProvinceJson2(String q,boolean nosession){
		JSONArray ja = new JSONArray();
		List<ProvinceBean> list =  provinceService.getProvinceByType(q==null?"":q);
		for(int i=0;i<list.size();i++){
            ProvinceBean provinceBean = (ProvinceBean) list.get(i);
			ja.add(provinceBean);
		}
		if (nosession){
			return "callBack("+ja.toString()+",'province')";
		}else {
			return ja.toString();
		}
	}
	
	@RequestMapping("/selectProvinceJson3")
	@ResponseBody
	public String  selectProvinceJson3(String q,String pid1){
		JSONArray ja = new JSONArray();
		List<ProvinceBean> list =  provinceService.getProvinceByType2(q,pid1);
		for(int i=0;i<list.size();i++){
            ProvinceBean provinceBean = (ProvinceBean) list.get(i);
			ja.add(provinceBean);
		}
		return ja.toString();
	}
}
