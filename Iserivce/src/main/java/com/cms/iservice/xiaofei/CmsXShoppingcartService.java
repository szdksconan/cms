package com.cms.iservice.xiaofei;

import java.util.List;
import java.util.Map;

import com.cms.model.xiaofei.CmsXShoppingcart;

public interface CmsXShoppingcartService {
	
	/**
	 * 把商品添加到购物车中
	 * 作者： 郑泽
	 * 日期：2016年5月13日
	 * @param cmsXShoppinctart
	 */
    public void addGoodsToShoppingcart(CmsXShoppingcart cmsXShoppingcart);
    /**
     * 根据用户ID查询用户购物车中的商品信息
     * 作者： 郑泽
     * 日期：2016年5月24日
     * @param userId
     * @return
     */
    public List<Map<String, Object>> selectGetUserIdAndShoppingcartAllInfo(String userId);
    /**
     * 根据购物车ID查询用户购物车中的商品信息
     * 作者： 李俊林
     * 日期：2016年5月26日
     * @param Id
     * @return
     */
    public CmsXShoppingcart selectGetIdAndShoppingcartAllInfo(String Id);
    /**
     * 根据ID删除购物车中对应的商品
     * 作者： 郑泽
     * 日期：2016年5月26日
     * @param Id
     */
    public void delShoppingcartAndGoods(String Id);

}
