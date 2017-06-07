package com.cms.mapper.maoyi;

import java.util.List;
import java.util.Map;

import com.cms.model.maoyi.CmsPrice;

public interface PriceMapper {
	public void insert(Map<String,List<CmsPrice>> lcp);
	public CmsPrice getPriceById(String id);
}
