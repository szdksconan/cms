package com.cms.iservice.xiaofei;

import java.util.List;
import java.util.Map;

import com.cms.model.xiaofei.CmsXGoodsAddress;

public interface CmsXGoodsAddressService {
	/**
	 * 用户添加收货地址 
	 * 作者： 郑泽
	 * 日期：2016年5月25日
	 * @param cmsXGoodsAddress
	 */
    public void addUserAndDeliveryAndAddress(CmsXGoodsAddress cmsXGoodsAddress);
    /**
     * 根据用户查询用户的收货地址
     * 作者： 郑泽
     * 日期：2016年5月26日
     * @param uId
     * @return
     */
    public List<Map<String, Object>> selectUserAndGoodsAndAddress(String uId);
    public CmsXGoodsAddress selectUserAndGoodsAndAddressId(String addressId);

}
