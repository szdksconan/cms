package com.cms.iservice.shengchan;

import java.util.List;

import com.cms.model.shengchang.CompBuyRule;
import com.cms.model.shengchang.CompBuyRuleArea;
import com.cms.model.shengchang.CompBuyRuleBean;
import com.cms.model.shengchang.CompSaleRule;
import com.cms.model.shengchang.CompSaleRuleBean;
import com.cms.model.util.PageFilter;

/**
 * 企业规则信息接口
 * @author weibo
 *
 */
public interface CompanyRuleSV {
	/**
	 * 根据采购规则id获取采购规则信息及规则适用区域信息
	 * @param id 规则id
	 * @return
	 */
	
	public CompBuyRuleBean getBuyRuleById(String id,String compid);
	/**
	 * 获取所有采购规则信息
	 * @return
	 */
	public List<CompBuyRule> getAllBuyRule(String compid);
	/**
	 * 根据销售规则id获取销售规则信息及规则适用区域信息
	 * @param id 规则id
	 * @return
	 */
	public CompSaleRuleBean getSaleRuleById(String id,String compid);
	/**
	 *  获取所有销售规则信息
	 * @return
	 */
	public List<CompSaleRule> getAllSaleRule(String compid);
	/**
	 * 根据采购规则id删除采购规则
	 * @param buyRuleId
	 */
	
	public void deleteBuyRule(String buyRuleId,String compid);
	/**
	 * 根据企业id获得 所有的采购规则
	 * @param compId
	 * @return
	 */
	public List getBuyRuleByCompId(String compId);
	/**
	 * 新增采购交易规则
	 * @param compBuyRule
	 */
	public void insertBuyRule(CompBuyRule compBuyRule);
	/**
	 * 修改交易规则
	 * @param compBuyRule
	 */
	public void updateBuyRule(CompBuyRule compBuyRule);
	public List<CompBuyRule> pageBuyRule(PageFilter pageFilter, CompBuyRule compBuyRule);
	
	public int getTotalBuyRule(CompBuyRule compBuyRule);
	
	public void updateBuyRuleArea(CompBuyRuleArea compBuyRuleArea);
	
	public void deleteBuyRuleAreaByRuleId(String ruleId);
	
	public List<CompBuyRuleArea> getBuyArea(String buyId);

    public List<CompBuyRule> getAllCompBuyRule(CompBuyRule compBuyRule);
}
