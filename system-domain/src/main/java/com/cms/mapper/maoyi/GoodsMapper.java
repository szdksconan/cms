package com.cms.mapper.maoyi;

import java.util.List;

import com.cms.model.maoyi.CmsGoods;

public interface GoodsMapper {
	public int insert(CmsGoods cg) throws Exception;
	public List<CmsGoods> getGoodsList(CmsGoods cg) throws Exception;
	public CmsGoods selectGoodsInfoById(String id) throws Exception;
}
