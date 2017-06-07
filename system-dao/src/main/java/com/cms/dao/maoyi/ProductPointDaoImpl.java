package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.ProductPointMapper;
import com.cms.model.maoyi.CmsProductPoint;
@Component
public class ProductPointDaoImpl implements ProductPointDao {
@Autowired
private ProductPointMapper productPointMapper;
	public List<CmsProductPoint> getStockPriceBypid(List<String> productIds) {
		// TODO Auto-generated method stub
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("list", productIds);
		return productPointMapper.getStockPriceBypid(map);
	}
	public void updateStock(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		productPointMapper.updateStock(map);
	}

}
