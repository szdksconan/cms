package com.cms.service.xiaofei.shoppingcart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXShoppingcartDao;
import com.cms.iservice.xiaofei.CmsXShoppingcartService;
import com.cms.model.xiaofei.CmsXShoppingcart;
import com.cms.model.xiaofei.DataList;

public class CmsXShoppingcartServiceImpl implements CmsXShoppingcartService {
	@Autowired
	private CmsXShoppingcartDao cmsXShoppinctartDao;

	public void addGoodsToShoppingcart(CmsXShoppingcart cmsXShoppingcart) {
		Integer cart = this.cmsXShoppinctartDao.selectShoppingcartGetSize(cmsXShoppingcart.getProductCode(), cmsXShoppingcart.getGoodsId());
		// TODO Auto-generated method stub
		//this.cmsXShoppinctartDao.addGoodsToShoppingcart(cmsXShoppingcart);
		//this.cmsXShoppinctartDao.selectShoppingcartGetSize(pId, gId);
		//this.cmsXShoppinctartDao.updateShoppingcartAndGoodsInfo(productNumber, pId, gId);
		if(cart.equals(0)){
			this.cmsXShoppinctartDao.addGoodsToShoppingcart(cmsXShoppingcart);
		}else{
			Integer number = this.cmsXShoppinctartDao.selectGoodsGetNumber(cmsXShoppingcart.getProductCode(), cmsXShoppingcart.getGoodsId());
			if(number!=null){
				this.cmsXShoppinctartDao.updateShoppingcartAndGoodsInfo(cmsXShoppingcart.getProductNumber()+number, cmsXShoppingcart.getProductCode(), cmsXShoppingcart.getGoodsId());
			}else{
				this.cmsXShoppinctartDao.updateShoppingcartAndGoodsInfo(cmsXShoppingcart.getProductNumber(), cmsXShoppingcart.getProductCode(), cmsXShoppingcart.getGoodsId());
			}
		}
	}

	public DataList selectGetUserIdAndShoppingcartAllInfo(String userId,Integer page,Integer pageSize) {
		DataList data = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("page", page);
		map.put("pageSize", pageSize);
		data.setListData(this.cmsXShoppinctartDao.selectGetUserIdAndShoppingcartAllInfo(map));
		data.setSize(this.cmsXShoppinctartDao.selectGetUserIdAndShoppingcartAllInfoSize(map));
		return data;
	}


	public CmsXShoppingcart selectGetIdAndShoppingcartAllInfo(@Param("Id")String Id) {
		// TODO Auto-generated method stub
		return this.cmsXShoppinctartDao.selectGetIdAndShoppingcartAllInfo(Id);
	}

	public void delShoppingcartAndGoods(@Param("Id")String Id) {
		// TODO Auto-generated method stub
		this.cmsXShoppinctartDao.delShoppingcartAndGoods(Id);
	}

}
