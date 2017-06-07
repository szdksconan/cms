package com.cms.dao.maoyi;

import java.util.List;
import java.util.Map;

import com.cms.model.maoyi.CmsAttrVal;
import com.cms.model.maoyi.CmsValProducts;

public interface AttrValDao {
	public int insert(List<CmsAttrVal> lcv);
	public void insertValP(List<CmsValProducts> lvp);
	public List<CmsAttrVal> getAttrValByAttrIds(Map<String,Object> map);
	public List<CmsAttrVal> getAttrValByProductId(String productId) throws Exception;
}
