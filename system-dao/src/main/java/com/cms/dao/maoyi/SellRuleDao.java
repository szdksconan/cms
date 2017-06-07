package com.cms.dao.maoyi;

import java.util.List;

import com.cms.model.maoyi.CmsSellRule;


public interface SellRuleDao{
	public int insert(List<CmsSellRule> lcr);
	public List<CmsSellRule> getSellRuleByGoodsId(String goodsId) throws Exception;
}
