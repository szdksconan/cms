package com.cms.mapper.maoyi;

import java.util.List;
import java.util.Map;

import com.cms.model.maoyi.CmsAttrVal;
import com.cms.model.maoyi.CmsValProducts;

public interface ProductAttrValueMapper {
	public void insert(Map<String,List<CmsAttrVal>> lcv);
	public void insertValP(Map<String,List<CmsValProducts>> lvp);
	public List<CmsAttrVal> getAttrValByAttrIds(Map<String,Object> map);
	public List<CmsAttrVal> getAttrValByProductId(String productId) throws Exception;
}
