package com.cms.iservice.shengchan;

import com.cms.model.shengchang.PurchaseIntentBean;
import com.cms.model.util.Grid;

import java.util.List;

/**
 * Created by liuxin on 2016/5/13.
 */
public interface PurchaseIntentService {
    public void savePurchaseIntent(PurchaseIntentBean purchaseIntentBean);

    public Grid getPurchaseIntentList(PurchaseIntentBean purchaseIntentBean);

    public void delPurchaseIntent(PurchaseIntentBean purchaseIntentBean);
}
