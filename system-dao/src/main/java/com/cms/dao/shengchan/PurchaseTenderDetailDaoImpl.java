package com.cms.dao.shengchan;

import com.cms.mapper.shengchan.PurchaseTenderDetailMapper;
import com.cms.model.shengchang.PurchaseTenderDetail;
import com.cms.model.shengchang.PurchaseTenderDetailDoc;
import com.cms.model.shengchang.PurchaseTenderOrder;
import com.cms.model.util.GlobalUtil;
import com.cms.service.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuxin on 2016/5/18.
 */
@Component
public class PurchaseTenderDetailDaoImpl implements PurchaseTenderDetailDao{
    @Autowired
    private PurchaseTenderDetailMapper purchaseTenderDetailMapper;

    public void savePurchaseTenderDetail(List<PurchaseTenderDetail> purchaseTenderDetailList) {
        this.purchaseTenderDetailMapper.savePurchaseTenderDetail(purchaseTenderDetailList);
        for (PurchaseTenderDetail purchaseTenderDetail:purchaseTenderDetailList){
            if (purchaseTenderDetail.getDelPurchaseTenderDetailDocList().size()!=0){
                this.purchaseTenderDetailMapper.delPurchaseTenderDetailDoc(purchaseTenderDetail.getDelPurchaseTenderDetailDocList());
            }
            if (purchaseTenderDetail.getPurchaseTenderDetailDocList().size()!=0){
                this.purchaseTenderDetailMapper.savePurchaseTenderDetailDoc(purchaseTenderDetail.getPurchaseTenderDetailDocList());
            }
        }
    }

    public List<PurchaseTenderDetail> getPurchaseTenderDetailList(PurchaseTenderOrder purchaseTenderOrder) {
        List<PurchaseTenderDetail> purchaseTenderDetailList = this.purchaseTenderDetailMapper.getPurchaseTenderDetailList(purchaseTenderOrder);
        for (PurchaseTenderDetail purchaseTenderDetail:purchaseTenderDetailList){
            purchaseTenderDetail.setPurchaseTenderDetailDocList(GlobalUtil.MapToList(RedisUtil.hgetAll("purchaseTenderDetailDoc" + purchaseTenderDetail.getId()), PurchaseTenderDetailDoc.class));
            if (purchaseTenderDetail.getPurchaseTenderDetailDocList()==null){
                purchaseTenderDetail.setPurchaseTenderDetailDocList(this.purchaseTenderDetailMapper.getPurchaseTenderDetailDoc(purchaseTenderDetail));
            }
        }
        return purchaseTenderDetailList;
    }
}
