package com.cms.dao.maoyi.enterprise;

import java.util.List;

import com.cms.model.maoyi.GoodsService;

public interface GoodsServiceDao {

	//拿到对应企业id的所有服务
	 public List<GoodsService> getAllGoodsService(Long id);
	 
	 //保存服务
	 public void addGoodsService(GoodsService goodsService);

	//删除某个商品服务
	public void deleteService(Long id);
	
	//修改某个商品服务
	public void updateGoodsService(GoodsService goodsService);
	
	//拿到某个商品服务
	public GoodsService getGoodsService(Long id);
	 
	 
}
