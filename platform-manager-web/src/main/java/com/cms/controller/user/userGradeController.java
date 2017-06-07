package com.cms.controller.user;

import com.cms.model.manager.userGradeBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.user.userGradeService;
/**
 * 用户等级维护
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("userGrade")
public class userGradeController {
	@Autowired
	private userGradeService userGradeService;
	
	@RequestMapping("manager")
	public String manager(){
		return "user/userGrade";
	}
	
	@RequestMapping("dataGrid")
	@ResponseBody
	public Grid dataGrid(PageFilter ph){
		return this.userGradeService.dataGrid(ph);
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "user/userGradeAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(userGradeBean userGradeBean) {
		JSONObject obj = new JSONObject();
		try {
			userGradeService.add(userGradeBean);
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
	public JSONObject delete(Long id) {
		JSONObject obj = new JSONObject();
		try {
			userGradeService.delete(id);
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
	public ModelAndView editPage(Long id) {
		ModelAndView model = new ModelAndView("user/userGradeEdit");
		userGradeBean userGradeBean = this.userGradeService.get(id);
		model.addObject("userGradeBean", userGradeBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(userGradeBean userGradeBean) {
		JSONObject obj = new JSONObject();
		try {
			userGradeService.edit(userGradeBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
}
