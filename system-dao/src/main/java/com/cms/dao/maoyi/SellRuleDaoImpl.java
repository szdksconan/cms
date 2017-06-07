/**
 * @Title: ProductDAOImpl.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年5月4日  余波
 */

package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.SellRuleMapper;
import com.cms.model.maoyi.CmsSellRule;

@Component
public class SellRuleDaoImpl implements SellRuleDao {
	@Autowired
	private SellRuleMapper sellRuleMapper;	
	
	public int insert(List<CmsSellRule> lcr) {
		Map<String,List<CmsSellRule>> map = new HashMap<String,List<CmsSellRule>>();
		map.put("list", lcr);
		return sellRuleMapper.insert(map);
	}
 
	public List<CmsSellRule> getSellRuleByGoodsId(String goodsId) throws Exception {
		// TODO Auto-generated method stub
		return sellRuleMapper.getSellRuleByGoodsId(goodsId);
	}

}
