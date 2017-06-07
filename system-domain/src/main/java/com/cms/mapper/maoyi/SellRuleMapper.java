package com.cms.mapper.maoyi;

import java.util.List;
import java.util.Map;

import com.cms.model.maoyi.CmsSellRule;

public interface SellRuleMapper {
	public int insert(Map<String,List<CmsSellRule>> lcr);
	public List<CmsSellRule> getSellRuleByGoodsId(String goodsId) throws Exception;
}
