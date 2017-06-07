package com.cms.mapper.shengchan;

import com.cms.model.shengchang.PurchaseTenderArea;
import com.cms.model.shengchang.PurchaseTenderOrder;
import com.cms.model.shengchang.PurchaseTenderOrderSupplier;
import com.cms.model.util.PageFilter;

import java.util.List;

/**
 * Created by liuxin on 2016/5/16.
 */
public interface PurchaseTenderMapper {
    /**
     * 保存招标单
     * @param purchaseTenderOrder
     */
    public void savePurchaseTender(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 删除招标单
     * @param purchaseTenderOrder
     */
    public void delPurchaseTender(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 保存招标单地区要求
     * @param purchaseTenderAreaList
     */
    public void savePurchaseTenderArea(List<PurchaseTenderArea> purchaseTenderAreaList);

    /**
     * 获取招标单列表
     * @param purchaseTenderOrder
     * @return
     */
    public List<PurchaseTenderOrder> getPurchaseTender(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 获取招标单数量
     * @param purchaseTenderOrder
     * @return
     */
    public Integer getPurchaseTenderCot(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 获取单个招标单
     * @param purchaseTenderOrder
     * @return
     */
    public PurchaseTenderOrder getPurchaseTenderOrderById(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 获取招标单适用区域
     * @param purchaseTenderOrder
     * @return
     */
    public List<PurchaseTenderArea> getPurchaseTenderArea(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 删除招标单区域
     * @param purchaseTenderOrder
     */
    public void delPurchaseTenderArea(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 保存招标邀请
     * @param purchaseTenderOrderSupplierList
     */
    public void savePurchaseTenderSupplier(List<PurchaseTenderOrderSupplier> purchaseTenderOrderSupplierList);

    /**
     * 获取选中的供应商
     * @param purchaseTenderOrderSupplier
     * @return
     */
    public List<PurchaseTenderOrderSupplier> getPurchaseSupplierList(PurchaseTenderOrderSupplier purchaseTenderOrderSupplier);

    public Integer getPurchaseSupplierListCot(PurchaseTenderOrderSupplier purchaseTenderOrderSupplier);

    /**
     * 删除招标关联供应商
     * @param purchaseTenderOrder
     */
    public void delPurchaseTenderSupplier(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 获取投标人数
     * @param purchaseTenderOrder
     * @return
     */
    public Integer getSaleBidNum(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 获取推荐招标信息
     * @param ids
     * @return
     */
    public List<PurchaseTenderOrder> getTenderRecommendList(List<String> ids);

    /**
     * 保存评审
     * @param purchaseTenderOrder
     */
    public void saveReview(PurchaseTenderOrder purchaseTenderOrder);
}
