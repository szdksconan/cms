package com.cms.mapper.maoyi;

import java.util.HashMap;
import java.util.List;

import com.cms.model.maoyi.CmsProductPoint;

public interface ProductPointMapper {
	public CmsProductPoint getProductPointById(String id);
	public List<CmsProductPoint> getStockPriceBypid(HashMap<String,List<String>> productIds);
	public void updateStock(HashMap<String,Object> map) throws Exception;
}
