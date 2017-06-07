package com.cms.dao.shengchan;

import com.cms.model.shengchang.PurchaseIntentAreaBean;
import com.cms.model.shengchang.PurchaseIntentBean;
import com.cms.model.util.Grid;

import java.util.List;

/**
 * Created by liuxin on 2016/5/13.
 */
public interface PurchaseIntentDao {
    public void savePurchaseIntent(PurchaseIntentBean purchaseIntentBean);

    public void savePurchaseIntentArea(List<PurchaseIntentAreaBean> purchaseIntentAreaBeanList);

    public Grid getPurchaseIntentList(PurchaseIntentBean purchaseIntentBean);

    public void delPurchaseIntent(PurchaseIntentBean purchaseIntentBean);

    public void delPurchaseIntentArea(PurchaseIntentBean purchaseIntentBean);
}
