package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.ProductAttrMapper;
import com.cms.model.maoyi.CmsAttr;

@Component
public class AttrDaoImpl implements AttrDao {
	@Autowired
	private ProductAttrMapper productAttrMapper;

	public List<CmsAttr> getAttrByKindsId(String kindsId) {
		// TODO Auto-generated method stub
		return productAttrMapper.getAttrByKindsId(kindsId);
	}

	public int insert(List<CmsAttr> lca) {
		// TODO Auto-generated method stub
		Map<String,List<CmsAttr>> map = new HashMap<String,List<CmsAttr>>();
		map.put("list", lca);
		productAttrMapper.insert(map);
		return 1;
	}

}
