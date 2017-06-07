package com.cms.dao.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.CompBuyRule;
import com.cms.model.shengchang.CompBuyRuleArea;
import com.cms.model.shengchang.CompSaleRule;
import com.cms.model.shengchang.CompSaleRuleArea;

import java.util.List;

/**
 * 
 * @author weibo
 *
 */
public interface CompanyRuleDao {
	public CompBuyRule getBuyRuleById(String ruleId);
	public List<CompBuyRule> getAllBuyRule();
	public List<CompBuyRuleArea> getBuyAreaByRuleId(String ruleId);
	public CompSaleRule getSaleRuleById(String ruleId);
	public List<CompSaleRule> getAllSaleRule();
	public List<CompSaleRuleArea> getSaleAreaByRuleId(String ruleId);
	public void deleteBuyRule(String buyRuleId);
	/**
	 * 根据企业id获得 所有的采购规则
	 * @param compId
	 * @return
	 */
	public List getBuyRuleByCompId(String compId);
	
	public void insertBuyRule(CompBuyRule compBuyRule);
	
	public void updateBuyRule(CompBuyRule compBuyRule);
	
	public List<CompBuyRule> pageBuyRule(JSONObject obj);
	
	public int getTotalBuyRule(CompBuyRule compBuyRule);
	
	public void updateBuyRuleArea(CompBuyRuleArea compBuyRuleArea);
	
	public void deleteBuyRuleArea(Long buyId);
	
	public List<CompBuyRuleArea> getBuyArea(String buyId);
	
	public CompBuyRuleArea getBuyAreaById(Long id);
	
	public void delBuyAreaById(Long id);

    public List<CompBuyRule> getAllCompBuyRule(CompBuyRule compBuyRule);
}
