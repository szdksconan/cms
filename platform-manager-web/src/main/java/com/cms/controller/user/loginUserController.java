package com.cms.controller.user;

import javax.servlet.http.HttpServletRequest;

import com.cms.model.manager.loginUserBean;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.cargoods.loginUserService;

/**
 * 用户中心
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("loginUser")
public class loginUserController {
	@Autowired
	private loginUserService loginUserService;
	
	@RequestMapping("userCenter")
	@ResponseBody
	public ModelAndView userCenter(HttpServletRequest request){
		JSONObject obj = new JSONObject();
		obj.put("id", ((SessionInfo)request.getSession().getAttribute(GlobalConstant.SESSION_INFO)).getUserId());
		ModelAndView mode = new ModelAndView("/admin/userCenter");
		try{
			mode.addObject("info", this.loginUserService.get(obj));
		}finally{
			
		}
		return mode;
	}
	
	/**
	 * 审核
	 * @param id
	 * @return
	 */
	@RequestMapping("auditPage")
	public ModelAndView auditPage(Long id){
		ModelAndView model = new ModelAndView("/admin/audit");
		model.addObject("id", id);
		return model;
	}
	
	@RequestMapping("audit")
	@ResponseBody
	public JSONObject audit(loginUserBean bean){
		JSONObject obj = new JSONObject();
		try{
			obj = (JSONObject) JSONObject.toJSON(bean);
			this.loginUserService.updateAudit(obj);
			obj = new JSONObject();
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 修改
	 * @param bean
	 * @param type
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public JSONObject update(loginUserBean bean,int type){
		JSONObject obj = new JSONObject();
		try{
			
			obj = (JSONObject) JSONObject.toJSON(bean);
			switch (type) {
			case 1:
				this.loginUserService.updateInfo(obj);
				break;
			case 2:
				this.loginUserService.updateTel(obj);
				break;
			case 3:
				this.loginUserService.updateLoginPwd(obj);
				break;
			case 4:
				this.loginUserService.updatePayPwd(obj);
				break;
			}
			obj = new JSONObject();
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		finally {
			
		}
		return obj;
	}
}
