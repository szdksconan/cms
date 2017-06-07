package com.cms.dao.maoyi;

import java.util.List;

import com.cms.model.maoyi.CmsAttr;

public interface AttrDao {
	public List<CmsAttr> getAttrByKindsId(String kindsId);
	public int insert(List<CmsAttr> lca);

}
