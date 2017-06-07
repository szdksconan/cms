package com.cms.controller.station;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cms.model.manager.stationBean;
import com.cms.model.manager.userBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.station.stationService;
@Controller
@RequestMapping("station")
public class stationController {
	@Autowired
	private stationService stationService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/station/station";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(stationBean station, PageFilter ph) {
		Grid grid = new Grid();
		List<stationBean> list = this.stationService.dataGrid(station, ph);
		grid.setRows(list);
		grid.setTotal(list.size());
		return grid;
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/station/stationAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(stationBean stationBean) {
		JSONObject obj = new JSONObject();
		try {
			stationService.add(stationBean);
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
			stationService.delete(id);
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
	@RequestMapping("/editPage")
	public ModelAndView updatePage(Long id) {
		ModelAndView model = new ModelAndView("/station/stationEdit");
		stationBean stationBean = this.stationService.get(id);
		model.addObject("station", stationBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(stationBean stationBean) {
		JSONObject obj = new JSONObject();
		try {
			stationService.update(stationBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/getStationList")
	@ResponseBody
	public List<stationBean> getStationList(){
		return this.stationService.dataGrid(null,null);
	}
	
	@RequestMapping("/grantPage")
	public ModelAndView grantPage(Long id,Long roleId){
		ModelAndView model = new ModelAndView("/role/roleGrant");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("roleId", roleId);
		model.addObject("map", map);
		return model;
	}
	
	@RequestMapping("/grant")
	@ResponseBody
	public JSONObject grant(userBean bean) {
		JSONObject obj = new JSONObject();
		try {
			this.stationService.updateGrant(bean);
			obj.put("success", true);
			obj.put("msg", "授权成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
}
