package com.cms.dao.xiaofei;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.xiaofei.CmsXShoppingcartMapper;
import com.cms.model.xiaofei.CmsXShoppingcart;
@Component
public class CmsXShoppingcartDaoImpl implements CmsXShoppingcartDao {
	@Autowired
	private CmsXShoppingcartMapper cmsXShoppinctartMapper;

	/**
	 * 把商品添加到购物车
	 */
	public void addGoodsToShoppingcart(CmsXShoppingcart cmsXShoppingcart) {
		// TODO Auto-generated method stub
		this.cmsXShoppinctartMapper.addGoodsToShoppingcart(cmsXShoppingcart);
	}

	/**
	 * 查询购物车中是否添加过商品
	 */
	public Integer selectShoppingcartGetSize(String pId, String gId) {
		// TODO Auto-generated method stub
		return this.cmsXShoppinctartMapper.selectShoppingcartGetSize(pId, gId);
	}

	/**
	 * 更新购物车中的商品信息
	 */
	public void updateShoppingcartAndGoodsInfo(Integer productNumber,String pId, String gId) {
		// TODO Auto-generated method stub
		this.cmsXShoppinctartMapper.updateShoppingcartAndGoodsInfo(productNumber, pId, gId);
	}

	/**
	 * 查询商品数量
	 */
	public Integer selectGoodsGetNumber(String pId, String gId) {
		// TODO Auto-generated method stub
		return this.cmsXShoppinctartMapper.selectGoodsGetNumber(pId, gId);
	}

	/**
	 * 根据用户ID查询用户购物车中的商品信息
	 */
	public List<Map<String, Object>> selectGetUserIdAndShoppingcartAllInfo(String userId) {
		// TODO Auto-generated method stub
		return this.cmsXShoppinctartMapper.selectGetUserIdAndShoppingcartAllInfo(userId);
	}

	public CmsXShoppingcart selectGetIdAndShoppingcartAllInfo(String Id) {
		// TODO Auto-generated method stub
		return cmsXShoppinctartMapper.selectGetIdAndShoppingcartAllInfo(Id);
	}
	
	/**
	 * 根据ID删除购物车中对应的商品
	 */
	public void delShoppingcartAndGoods(String Id) {
		// TODO Auto-generated method stub
		this.cmsXShoppinctartMapper.delShoppingcartAndGoods(Id);
	}

}
