package com.cms.dao.shengchan;

import com.cms.model.shengchang.*;
import com.cms.model.util.Grid;

import java.util.List;

/**
 * Created by liuxin on 2016/5/16.
 */
public interface PurchaseTenderDao {
    public void savePurchaseTender(PurchaseTenderOrder purchaseTenderOrder);
    public void delPurchaseTender(PurchaseTenderOrder purchaseTenderOrder);
    public void savePurchaseTenderArea(List<PurchaseTenderArea> purchaseTenderAreaList);
    public Grid getPurchaseTender(PurchaseTenderOrder purchaseTenderOrder);
    public PurchaseTenderOrder getPurchaseTenderOrderById(PurchaseTenderOrder purchaseTenderOrder);
    public List<PurchaseTenderArea> getPurchaseTenderArea(PurchaseTenderOrder purchaseTenderOrder);
    public void delPurchaseTenderArea(PurchaseTenderOrder purchaseTenderOrder);
    public void savePurchaseTenderSupplier(List<PurchaseTenderOrderSupplier> purchaseTenderOrderSupplierList);
    public Grid getPurchaseSupplier(PurchaseTenderOrderSupplier purchaseTenderOrderSupplier);
    public void delPurchaseTenderSupplier(PurchaseTenderOrder purchaseTenderOrder);
    public void insertConcernCompany(CompSuppliers compSuppliers);
    public List<PurchaseTenderOrder> getTenderRecommendList(List<String> ids);
    public void saveReview(PurchaseTenderOrder purchaseTenderOrder);
}
