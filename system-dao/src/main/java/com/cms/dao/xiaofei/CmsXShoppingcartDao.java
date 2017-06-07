package com.cms.dao.xiaofei;

import java.util.List;
import java.util.Map;

import com.cms.model.xiaofei.CmsXShoppingcart;

public interface CmsXShoppingcartDao {
	
	/**
	 * 把商品添加到购物车中
	 * 作者： 郑泽
	 * 日期：2016年5月13日
	 * @param cmsXShoppinctart
	 */
    public void addGoodsToShoppingcart(CmsXShoppingcart cmsXShoppingcart);
    /**
     * 查询购物车中是否添加过商品
     * 作者： 郑泽
     * 日期：2016年5月19日
     * @param pId
     * @param gId
     * @return
     */
    public Integer selectShoppingcartGetSize(String pId,String gId);
    /**
     * 查询商品数量
     * 作者： 郑泽
     * 日期：2016年5月19日
     * @param pId
     * @param gId
     * @return
     */
    public Integer selectGoodsGetNumber(String pId,String gId);
    /**
     * 更新购物车中的商品信息
     * 作者： 郑泽
     * 日期：2016年5月19日
     * @param productNumber
     * @param pId
     * @param gId
     */
    public void updateShoppingcartAndGoodsInfo(Integer productNumber,String pId,String gId);
    /**
     * 根据用户ID查询用户购物车中的商品信息
     * 作者： 郑泽
     * 日期：2016年5月24日
     * @param userId
     * @return
     */
    public List<Map<String, Object>> selectGetUserIdAndShoppingcartAllInfo(String userId);
    /**
     * 
     * 作者： 李俊霖
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
