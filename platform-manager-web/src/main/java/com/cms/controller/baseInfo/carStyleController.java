package com.cms.controller.baseInfo;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.Tree;
import com.cms.model.manager.carDicBean;
import com.cms.model.util.GlobalConstant;
import com.cms.iservice.manager.baseInfo.baseService;

/**
 * 车辆属性
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("carStyle")
public class carStyleController {
	@Autowired
	private baseService baseService;
	
	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/index")
	public String manager(HttpServletRequest request) {
		//request.setAttribute("map", GlobalConstant.getTitleMap());
		return "/baseInfo/carStyle";
	}

	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<carDicBean> treeGrid() {
		return this.baseService.dataGridCarStyle();
	}
	
	/**
	 * 新增
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/baseInfo/carStyleAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(carDicBean bean) {
		JSONObject obj = new JSONObject();
		try {
			this.baseService.addCarStyle(bean);
			obj = new JSONObject();
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("editPage")
	public ModelAndView editPage(Long id) {
		ModelAndView model = new ModelAndView("/baseInfo/carStyleEdit");
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		model.addObject("carStyle", this.baseService.getCarStyle(obj));
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(carDicBean carDicBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.updateCarStyle(carDicBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 获取所有字典
	 * @return
	 */
	@RequestMapping("allTree")
	@ResponseBody
	public List<Tree> allTree(){
		return this.baseService.allTreeCarStyle();
	}
}
