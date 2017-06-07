package com.cms.controller.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.CompanyRuleSV;
import com.cms.model.shengchang.CompBuyRule;
import com.cms.model.shengchang.CompBuyRuleArea;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;

@Controller
@RequestMapping("compRule")
public class CompBuyRuleController {
	@Autowired
	private CompanyRuleSV companyRuleSV;
	// 注入唯一的id
	@Autowired
	private GlobalIdService globalIdService;

	@RequestMapping("getBuyRule")
	@ResponseBody
	public Grid getBuyRule(PageFilter pageFilter, CompBuyRule compBuyRule) {
		Grid grid = new Grid();
		try {
			List<CompBuyRule> pageBuyRule = companyRuleSV.pageBuyRule(pageFilter, compBuyRule);
			int total = companyRuleSV.getTotalBuyRule(compBuyRule);
			grid.setRows(pageBuyRule);
			grid.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grid;
	}

	@RequestMapping("deleteByRuleId")
	@ResponseBody
	public JSONObject deleteByRuleId(String ruleId,String compid) {
		JSONObject obj = new JSONObject();
		try {
			companyRuleSV.deleteBuyRule(ruleId,compid);
			obj.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("success", false);
		}
		return obj;
	}
	@RequestMapping("getBuyArea")
	@ResponseBody
	public JSONObject getBuyArea(String buyId){
		JSONObject obj = new JSONObject();
		try {
			List<CompBuyRuleArea> compBuyRuleAreas = companyRuleSV.getBuyArea(buyId);
			obj.put("area", compBuyRuleAreas);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}
	
	
	@RequestMapping("editBuyRule")
	@ResponseBody
	public JSONObject updateBuyRule(CompBuyRule compBuyRule,String  wzly) {
		JSONObject obj = new JSONObject();
		System.out.println("editBuyRule:" + wzly);
		String buyId ="";
		try {
			if (compBuyRule != null && compBuyRule.getId() != "") {
				companyRuleSV.updateBuyRule(compBuyRule);
			} else {
				buyId = globalIdService.getGlobalId().toString();
				compBuyRule.setId(buyId);
				// 后面到redis中去拿数据
				compBuyRule.setCompid("1313131313");
				compBuyRule.setCreator("唐平");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String str = sdf.format(date);
				compBuyRule.setRuleTime(str);
				companyRuleSV.insertBuyRule(compBuyRule);
			}
			if(wzly!=null && wzly !=""){
				wzlyd(compBuyRule,wzly,buyId);
			}
			obj.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("success", false);
		}
		return obj;
	}
	private void wzlyd(CompBuyRule compBuyRule, String wzly,String buyId) {
		if(compBuyRule!=null && compBuyRule.getId()!=""){
				String[] split = wzly.split("，");
				//先考个所有的地址信息删除
				companyRuleSV.deleteBuyRuleAreaByRuleId(compBuyRule.getId());
				for (String str : split) {
					String[] address = str.split("-");
					String province = address[0];
					String city = address[1];
					String region = address[2];
					CompBuyRuleArea compBuyRuleArea = new CompBuyRuleArea();
					compBuyRuleArea.setBuyId(compBuyRule.getId());
					compBuyRuleArea.setSheng(province);
					compBuyRuleArea.setCity(city);
					compBuyRuleArea.setXian(region);
					compBuyRuleArea.setId(globalIdService.getGlobalId()+"");
					companyRuleSV.updateBuyRuleArea(compBuyRuleArea);
			}
		}else{
				String[] split = wzly.split("，");
				//先考个所有的地址信息删除
				for (String str : split) {
					String[] address = str.split("-");
					String province = address[0];
					String city = address[1];
					String region = address[2];
					CompBuyRuleArea compBuyRuleArea = new CompBuyRuleArea();
					compBuyRuleArea.setBuyId(buyId);
					compBuyRuleArea.setSheng(province);
					compBuyRuleArea.setCity(city);
					compBuyRuleArea.setXian(region);
					compBuyRuleArea.setId(globalIdService.getGlobalId()+"");
					companyRuleSV.updateBuyRuleArea(compBuyRuleArea);
				}
		}
		
	}

    @RequestMapping("getAllCompBuyRule")
    @ResponseBody
    public List<CompBuyRule> getAllCompBuyRule(CompBuyRule compBuyRule){
        return this.companyRuleSV.getAllCompBuyRule(compBuyRule);
    }
}
