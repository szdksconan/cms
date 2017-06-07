package com.cms.mapper.shengchan;

import com.cms.model.shengchang.PurchaseTenderDetail;
import com.cms.model.shengchang.PurchaseTenderDetailDoc;
import com.cms.model.shengchang.PurchaseTenderOrder;

import java.util.List;

/**
 * Created by liuxin on 2016/5/18.
 */
public interface PurchaseTenderDetailMapper {

    /**
     * 保存招标单明细
     * @param purchaseTenderDetailList
     */
    public void savePurchaseTenderDetail(List<PurchaseTenderDetail> purchaseTenderDetailList);

    /**
     * 保存明细附件
     * @param purchaseTenderDetailDocList
     */
    public void savePurchaseTenderDetailDoc(List<PurchaseTenderDetailDoc> purchaseTenderDetailDocList);

    /**
     * 获取招标单明细
     * @param purchaseTenderOrder
     * @return
     */
    public List<PurchaseTenderDetail> getPurchaseTenderDetailList(PurchaseTenderOrder purchaseTenderOrder);

    /**
     * 获取招标单明细附件
     * @param purchaseTenderDetail
     * @return
     */
    public List<PurchaseTenderDetailDoc> getPurchaseTenderDetailDoc(PurchaseTenderDetail purchaseTenderDetail);

    /**
     * 删除招标明细附件
     * @param purchaseTenderDetailDocList
     * @return
     */
    public void delPurchaseTenderDetailDoc(List<PurchaseTenderDetailDoc> purchaseTenderDetailDocList);

}
