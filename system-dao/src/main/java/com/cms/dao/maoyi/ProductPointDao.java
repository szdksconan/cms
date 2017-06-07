package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;

import com.cms.model.maoyi.CmsProductPoint;

public interface ProductPointDao {
	public List<CmsProductPoint> getStockPriceBypid(List<String> productIds);
	public void updateStock(HashMap<String,Object> map) throws Exception;

}
