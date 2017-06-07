package com.cms.mapper.shengchan;

import com.cms.model.shengchang.PurchaseIntentAreaBean;
import com.cms.model.shengchang.PurchaseIntentBean;

import java.util.List;
import java.util.Map;

/**
 * Created by liuxin on 2016/5/13.
 */
public interface PurchaseIntentMapper {
    /**
     * 获取采购意向列表
     * @param purchaseIntentBean
     * @return
     */
    public List<PurchaseIntentBean> getPurchaseIntentList(PurchaseIntentBean purchaseIntentBean);

    public Integer getPurchaseIntentListCot(PurchaseIntentBean purchaseIntentBean);

    /**
     * 获取意向区域
     * @param purchaseIntentAreaBean
     * @return
     */
    public Map getPurchaseIntentAreaList(PurchaseIntentAreaBean purchaseIntentAreaBean);

    /**
     * 保存采购意向
     * @param purchaseIntentBean
     */
    public void savePurchaseIntent(PurchaseIntentBean purchaseIntentBean);

    /**
     * 保存意向区域
     * @param purchaseIntentAreaBeanList
     */
    public void savePurchaseIntentArea(List<PurchaseIntentAreaBean> purchaseIntentAreaBeanList);

    /**
     * 更新意向
     * @param purchaseIntentBean
     */
    public void delPurchaseIntent(PurchaseIntentBean purchaseIntentBean);

    /**
     * 删除意向区域
     * @param purchaseIntentBean
     */
    public void delPurchaseIntentArea(PurchaseIntentBean purchaseIntentBean);
}
