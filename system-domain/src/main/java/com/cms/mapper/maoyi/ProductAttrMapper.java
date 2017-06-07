package com.cms.mapper.maoyi;

import java.util.List;
import java.util.Map;

import com.cms.model.maoyi.CmsAttr;

public interface ProductAttrMapper {
	public List<CmsAttr> getAttrByKindsId(String kindsId);
	public void insert(Map<String,List<CmsAttr>> lca);
}
