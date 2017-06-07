package com.cms.dao.maoyi.enterprise.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.dao.maoyi.enterprise.GoodsServiceDao;
import com.cms.mapper.maoyi.GoodsServiceMapper;
import com.cms.model.maoyi.GoodsService;

@Repository
public class GoodsServiceDaoImpl implements GoodsServiceDao {

	@Autowired
	private GoodsServiceMapper goodsServiceMapper;
	//拿到所有的商品服务
	public List<GoodsService> getAllGoodsService(Long id) {
		return goodsServiceMapper.getAllGoodsService(id);
	}
    //添加商品服务
	public void addGoodsService(GoodsService goodsService) {
         goodsServiceMapper.addGoodsService(goodsService);
	}

	//删除相应的商品服务
	public void deleteService(Long id) {
        goodsServiceMapper.deleteService(id);		
	}

	 //更新对应的商品服务
	public void updateGoodsService(GoodsService goodsService) {
		goodsServiceMapper.updateGoodsService(goodsService);
	}
    //拿到对于的商品服务
	public GoodsService getGoodsService(Long id) {
		return goodsServiceMapper.getGoodsService(id);
	}

}
