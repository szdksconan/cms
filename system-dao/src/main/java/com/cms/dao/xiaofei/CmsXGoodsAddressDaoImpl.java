package com.cms.dao.xiaofei;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.xiaofei.CmsXGoodsAddressMapper;
import com.cms.model.xiaofei.CmsXGoodsAddress;
@Component
public class CmsXGoodsAddressDaoImpl implements CmsXGoodsAddressDao {
	@Autowired
	private CmsXGoodsAddressMapper cmsXGoodsAddressMapper;
	/**
	 * 用户添加收货地址 
	 */
	public void addUserAndDeliveryAndAddress(CmsXGoodsAddress cmsXGoodsAddress) {
		// TODO Auto-generated method stub
		this.cmsXGoodsAddressMapper.addUserAndDeliveryAndAddress(cmsXGoodsAddress);
	}
	/**
	 * 根据用户查询用户的收货地址
	 */
	public List<Map<String, Object>> selectUserAndGoodsAndAddress(String uId) {
		// TODO Auto-generated method stub
		return this.cmsXGoodsAddressMapper.selectUserAndGoodsAndAddress(uId);
	}
	public CmsXGoodsAddress selectUserAndGoodsAndAddressId(String addressId)
	{
		return cmsXGoodsAddressMapper.selectUserAndGoodsAndAddressId(addressId);
	}

}
