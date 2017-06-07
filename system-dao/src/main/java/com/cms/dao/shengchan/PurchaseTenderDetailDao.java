package com.cms.dao.shengchan;

import com.cms.model.shengchang.PurchaseTenderDetail;
import com.cms.model.shengchang.PurchaseTenderDetailDoc;
import com.cms.model.shengchang.PurchaseTenderOrder;

import java.util.List;

/**
 * Created by liuxin on 2016/5/18.
 */
public interface PurchaseTenderDetailDao {
    public void savePurchaseTenderDetail(List<PurchaseTenderDetail> purchaseTenderDetailList);
    public List<PurchaseTenderDetail> getPurchaseTenderDetailList(PurchaseTenderOrder purchaseTenderOrder);
}
