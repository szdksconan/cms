package com.cms.dao.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.shengchan.CompBuyRuleAreaMapper;
import com.cms.mapper.shengchan.CompBuyRuleMapper;
import com.cms.mapper.shengchan.CompSaleRuleAreaMapper;
import com.cms.mapper.shengchan.CompSaleRuleMapper;
import com.cms.model.shengchang.CompBuyRule;
import com.cms.model.shengchang.CompBuyRuleArea;
import com.cms.model.shengchang.CompSaleRule;
import com.cms.model.shengchang.CompSaleRuleArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CompanyRuleDaoImpl implements CompanyRuleDao {
	@Autowired
	private CompBuyRuleMapper compBuyRuleMapper;
	@Autowired
	private CompBuyRuleAreaMapper compBuyRuleAreaMapper;
	@Autowired
	private CompSaleRuleMapper compSaleRuleMapper;
	@Autowired
	private CompSaleRuleAreaMapper compSaleRuleAreaMapper;
	public CompBuyRule getBuyRuleById(String ruleId) {
		// TODO Auto-generated method stub
		return compBuyRuleMapper.selectByPrimaryKey(Long.parseLong(ruleId));
	}
	public List<CompBuyRule> getAllBuyRule() {
		// TODO Auto-generated method stub
		return compBuyRuleMapper.getAllBuyRule();
	}
	public List<CompBuyRuleArea> getBuyAreaByRuleId(String ruleId) {
		// TODO Auto-generated method stub
		return compBuyRuleAreaMapper.getBuyAreaByRuleId(Long.parseLong(ruleId));
	}
	public CompSaleRule getSaleRuleById(String ruleId) {
		// TODO Auto-generated method stub
		return compSaleRuleMapper.selectByPrimaryKey(Long.parseLong(ruleId));
	}
	public List<CompSaleRule> getAllSaleRule() {
		// TODO Auto-generated method stub
		return compSaleRuleMapper.getAllSaleRule();
	}
	public List<CompSaleRuleArea> getSaleAreaByRuleId(String ruleId) {
		// TODO Auto-generated method stub
		return compSaleRuleAreaMapper.getSaleAreaByRuleId(Long.parseLong(ruleId));
	}
	public void deleteBuyRule(String buyRuleId) {
		// TODO Auto-generated method stub
		compBuyRuleMapper.deleteByPrimaryKey(Long.parseLong(buyRuleId));
	}
	public List getBuyRuleByCompId(String compId) {
		// TODO Auto-generated method stub
		return compBuyRuleMapper.getBuyRuleByCompId(Long.parseLong(compId));
	}
	public void insertBuyRule(CompBuyRule compBuyRule) {
		// TODO Auto-generated method stub
		compBuyRuleMapper.insert(compBuyRule);
	}
	public void updateBuyRule(CompBuyRule compBuyRule) {
		// TODO Auto-generated method stub
		compBuyRuleMapper.updateByPrimaryKey(compBuyRule);
		
	}
	public List<CompBuyRule> pageBuyRule(JSONObject obj) {
		// TODO Auto-generated method stub
		return compBuyRuleMapper.pageBuyRule(obj);
	}
	public int getTotalBuyRule(CompBuyRule compBuyRule) {
		// TODO Auto-generated method stub
		return compBuyRuleMapper.getTotalBuyRule(compBuyRule);
	}
	public void updateBuyRuleArea(CompBuyRuleArea compBuyRuleArea) {
		// TODO Auto-generated method stub
		compBuyRuleAreaMapper.insert(compBuyRuleArea);
	}
	public void deleteBuyRuleArea(Long buyId) {
		// TODO Auto-generated method stub
		compBuyRuleAreaMapper.deleteBuyRuleByRuleId(buyId);
	}
	public List<CompBuyRuleArea> getBuyArea(String buyId) {
		// TODO Auto-generated method stub
		return compBuyRuleAreaMapper.getBuyAreaByRuleId(Long.parseLong(buyId));
	}
	public CompBuyRuleArea getBuyAreaById(Long id) {
		// TODO Auto-generated method stub
		return compBuyRuleAreaMapper.selectByPrimaryKey(id);
	}
	public void delBuyAreaById(Long id) {
		compBuyRuleAreaMapper.deleteByPrimaryKey(id);
		
	}

    public List<CompBuyRule> getAllCompBuyRule(CompBuyRule compBuyRule) {
        JSONObject obj = new JSONObject();
        obj.put("compid",compBuyRule.getCompid());
        List<CompBuyRule> compBuyRuleList = this.compBuyRuleMapper.pageBuyRule(obj);
        for (CompBuyRule rule : compBuyRuleList){
            Map map = this.compBuyRuleMapper.getBuyRuleAreaMap(rule);
            if (map != null){
                rule.setAreaIds(map.get("areaIds").toString());
                rule.setAreaNames(map.get("areaNames").toString());
            }
        }
        return compBuyRuleList;
    }


}
