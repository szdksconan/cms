package com.cms.controller.driver;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.driver.driverService;
import com.cms.model.manager.driverBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.util.MD5Util;

/**
 * 司机
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/driver")
public class driverController {
	@Autowired
	private driverService driverService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/driver/driver";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(driverBean driver, PageFilter ph) {
		if(driver.getState()== null)
			driver.setState("2");
		return this.driverService.dataGrid(driver, ph);
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/driver/driverAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(driverBean driverBean,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
		driverBean.setCreateUser(Long.parseLong(sessionInfo.getUserId()));
		driverBean.setPassword(MD5Util.md5("888888"));
		driverBean.setCreateDate(new Date(System.currentTimeMillis()));
		
		try{
			obj = (JSONObject) JSONObject.toJSON(driverBean);
			obj.put("sessionId", sessionInfo.getUserId());
			driverService.add(obj);
			obj = new JSONObject();
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		finally {
			
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
		
		try{
			driverService.delete(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");

		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		finally {
			
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
		ModelAndView model = new ModelAndView("/driver/driverEdit");
		
		try{
		driverBean driverBean = this.driverService.get(id);
		model.addObject("driverBean", driverBean);
		return model;
		}
		finally {
			
		}
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(driverBean driverBean) {
		JSONObject obj = new JSONObject();
		
		try{
			driverService.edit(driverBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");

		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		finally {
			
		}
		return obj;
	}
	
	@RequestMapping("/state")
	@ResponseBody
	public JSONObject state(Long id,String state) {
		JSONObject obj = new JSONObject();
		
		driverBean driverBean = driverService.get(id);
		driverBean.setState(state);
		try{
			driverService.edit(driverBean);
			obj.put("success", true);
			if("1".equals(state)){
				obj.put("msg", "审核不通过！");
			}
			else if("2".equals(state)){
				obj.put("msg", "禁用成功！");
			}
			else if("3".equals(state)){
				obj.put("msg", "审核通过记录变为启用状态！");
			}

		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		finally {
			
		}
		return obj;
	}
	/**
	 * 重置密码
	 * @param id
	 * @return
	 */
	@RequestMapping("/reset")
	@ResponseBody
	public JSONObject reset(Long id) {
		JSONObject obj = new JSONObject();
		
		driverBean driverBean = driverService.get(id);
		driverBean.setPassword(MD5Util.md5("888888"));
		try{
			driverService.editpassword(driverBean);
			obj.put("success", true);
			obj.put("msg", "重置成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		finally {
			
		}
		return obj;
	}
	
	@RequestMapping("/registerPage")
	public String registerPage() {
		return "/driver/driverRegister";
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public JSONObject register(driverBean driverBean,HttpServletRequest request){
		JSONObject obj = new JSONObject();
		try{
			obj = this.add(driverBean, request);
			if (obj.getBooleanValue("success")){
				obj.put("msg", "注册成功，等待后台审核确认！");
			}
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		finally {
			
		}
		return obj;
	}
}
