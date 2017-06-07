package com.cms.dao.maoyi;

import java.util.List;

import com.cms.model.maoyi.CmsGoods;


public interface GoodsDao{
	public int insert(CmsGoods cg) throws Exception;
	public List<CmsGoods> getGoodsList(CmsGoods cg) throws Exception;
	public CmsGoods selectGoodsInfoById(String id) throws Exception;
}
