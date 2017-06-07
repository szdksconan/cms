package com.cms.dao.maoyi;

import java.util.List;

import com.cms.model.maoyi.CmsGoodsAttr;

public interface GoodsAttrDao {
	public List<CmsGoodsAttr> getGoodsAttrValByGoodsId(String id);

}
