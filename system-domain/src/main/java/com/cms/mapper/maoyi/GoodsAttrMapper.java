package com.cms.mapper.maoyi;

import java.util.List;

import com.cms.model.maoyi.CmsGoodsAttr;

public interface GoodsAttrMapper {
	public List<CmsGoodsAttr> getGoodsAttrValByGoodsId(String id);
}
