package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.ProductAttrValueMapper;
import com.cms.model.maoyi.CmsAttrVal;
import com.cms.model.maoyi.CmsGoodsAttr;
import com.cms.model.maoyi.CmsValProducts;

@Component
public class AttrValDaoImpl implements AttrValDao {
	@Autowired
	private ProductAttrValueMapper productAttrValueMapper;


	public int insert(List<CmsAttrVal> lcv) {
		// TODO Auto-generated method stub
		Map<String,List<CmsAttrVal>> map = new HashMap<String,List<CmsAttrVal>>();
		map.put("list", lcv);
		productAttrValueMapper.insert(map);
		return 1;
	}


	public void insertValP(List<CmsValProducts> lvp) {
		// TODO Auto-generated method stub
		Map<String,List<CmsValProducts>> map = new HashMap<String,List<CmsValProducts>>();
		map.put("list", lvp);
		productAttrValueMapper.insertValP(map);
	}


	public List<CmsAttrVal> getAttrValByAttrIds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return productAttrValueMapper.getAttrValByAttrIds(map);
	}


	public List<CmsAttrVal> getAttrValByProductId(String productId) throws Exception {
		// TODO Auto-generated method stub
		return productAttrValueMapper.getAttrValByProductId(productId);
	}
}
