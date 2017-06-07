package com.cms.controller.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.shengchan.CompanyOutService;
import com.cms.iservice.shengchan.CompanyService;
import com.cms.iservice.shengchan.MainProductService;
import com.cms.model.shengchang.CompanyToOutBean;

@Controller
@RequestMapping("comp")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompanyOutService companyOutService;

	/**
	 * 根据企业id获取企业基本信息
	 * 
	 * @param request
	 */
	@RequestMapping("getCompanyById")
	@ResponseBody
	public void topPage1(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		System.out.println(json.toJSONString(companyService.getCompanyInfoById("1312312313")));
	}

	/**
	 * 根据企业id推送企业门户信息给贸易平台或消费平台
	 * 
	 * @param request
	 */
	@RequestMapping("getOutBeanById")
	@ResponseBody
	public void topPage2(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		System.out.println(json.toJSONString(companyOutService.getOutBeanById("1312312313")));
	}

	/**
	 * 推送所有企业门户信息给贸易平台或消费平台
	 * 
	 * @param request
	 */
	/*@RequestMapping("getAllOutBean")
	@ResponseBody
	public void topPage3(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		System.out.println(json.toJSONString(companyService.getAllOutBeanList()));
	}*/

	/**
	 * 企业门户信息初始化
	 * 
	 * @param compId
	 * @param request
	 * @return
	 */
	@RequestMapping("initCompById")
	@ResponseBody
	public String initCompById(String compId, HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try {

			CompanyToOutBean bean = companyService.getOutBeanById(compId);
			obj.put("list", bean);
			obj.put("success", true);
		} catch (Exception e) {

			obj.put("success", false);
		}
		System.out.println(obj.toString());
		return obj.toString();

	}

	// 位前台提供一json数据
	@RequestMapping("getContact")
	@ResponseBody
	public String getcontact(String compId) {
		JSONObject obj = new JSONObject();
//		JSONObject data = new JSONObject();
		StringBuffer data = new StringBuffer();
		try {
			List contactInfoById = companyService.getContactInfoById(compId);
//			obj.put("list", contactInfoById);
//			data.put("data", obj);
			data.append(JSONObject.toJSONString(contactInfoById));
		} catch (Exception e) {
		}
		System.out.println();
		return data.toString();

	}
}
