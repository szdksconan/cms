package com.cms.iservice.shengchan;

import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.shengchang.CompSuppliers;
import com.cms.model.shengchang.PurchaseTenderOrder;
import com.cms.model.shengchang.PurchaseTenderOrderSupplier;
import com.cms.model.util.Grid;

import java.util.List;

/**
 * Created by liuxin on 2016/5/16.
 */
public interface PurchaseTenderService {
    public void savePurchaseTender(PurchaseTenderOrder purchaseTenderOrder);
    public void delPurchaseTender(PurchaseTenderOrder purchaseTenderOrder);
    public Grid getPurchaseTender(PurchaseTenderOrder purchaseTenderOrder);
    public PurchaseTenderOrder getPurchaseTenderOrderById(PurchaseTenderOrder purchaseTenderOrder);
    public Grid getPurchaseSupplier(PurchaseTenderOrderSupplier purchaseTenderOrderSupplier);
    public void savePurchaseTenderSupplier(PurchaseTenderOrder purchaseTenderOrder);
    public List<CompBaseInfo> getSupplierRecommend();
    public void insertConcernCompany(CompSuppliers compSuppliers);
    public void saveReview(PurchaseTenderOrder purchaseTenderOrder);
}
