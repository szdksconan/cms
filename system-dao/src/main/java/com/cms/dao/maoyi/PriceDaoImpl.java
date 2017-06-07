package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.PriceMapper;
import com.cms.model.maoyi.CmsPrice;

@Component
public class PriceDaoImpl implements PriceDao {
	@Autowired
	private PriceMapper priceMapper;


	public void insert(List<CmsPrice> lcp) {
		// TODO Auto-generated method stub
		Map<String,List<CmsPrice>> map = new HashMap<String,List<CmsPrice>>();
		map.put("list", lcp);
		priceMapper.insert(map);
	}
}
