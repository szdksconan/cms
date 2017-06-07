
package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.SellRuleAreaMapper;
import com.cms.model.maoyi.CmsSellRuleArea;

@Component
public class SellRuleAreaDaoImpl implements SellRuleAreaDao {
	@Autowired
	private SellRuleAreaMapper sellRuleAreaMapper;	
	
	public void insert(List<CmsSellRuleArea> lcr) {
		Map<String,List<CmsSellRuleArea>> map = new HashMap<String,List<CmsSellRuleArea>>();
		map.put("list", lcr);
		sellRuleAreaMapper.insert(map);
	}

}
