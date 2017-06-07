package com.cms.dao.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.shengchan.CompSuppliersMapper;
import com.cms.mapper.shengchan.PurchaseTenderMapper;
import com.cms.model.shengchang.*;
import com.cms.model.util.Grid;
import com.cms.service.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuxin on 2016/5/16.
 */
@Component
public class PurchaseTenderDaoImpl implements PurchaseTenderDao{
    @Autowired
    private PurchaseTenderMapper purchaseTenderMapper;

    @Autowired
    private CompSuppliersMapper compSuppliersMapper;

    public void savePurchaseTender(PurchaseTenderOrder purchaseTenderOrder) {
        this.purchaseTenderMapper.savePurchaseTender(purchaseTenderOrder);
    }

    public void delPurchaseTender(PurchaseTenderOrder purchaseTenderOrder) {
        this.purchaseTenderMapper.delPurchaseTender(purchaseTenderOrder);
    }

    public void savePurchaseTenderArea(List<PurchaseTenderArea> purchaseTenderAreaList) {
        this.purchaseTenderMapper.savePurchaseTenderArea(purchaseTenderAreaList);
    }

    public Grid getPurchaseTender(PurchaseTenderOrder purchaseTenderOrder) {
        Grid grid = new Grid();
        List<PurchaseTenderOrder> list = this.purchaseTenderMapper.getPurchaseTender(purchaseTenderOrder);
        for (PurchaseTenderOrder order : list){
            try {
                order.setSaleBidNum((Integer) RedisUtil.get("saleBidNum_" + order.getId()));
            }catch (Exception e){
                order.setSaleBidNum(this.purchaseTenderMapper.getSaleBidNum(order));
            }
            if (order.getSaleBidNum()==null){
                order.setSaleBidNum(this.purchaseTenderMapper.getSaleBidNum(order));
            }
        }
        grid.setRows(list);
        grid.setTotal(this.purchaseTenderMapper.getPurchaseTenderCot(purchaseTenderOrder));
        return grid;
    }

    public PurchaseTenderOrder getPurchaseTenderOrderById(PurchaseTenderOrder purchaseTenderOrder) {
        PurchaseTenderOrder order = this.purchaseTenderMapper.getPurchaseTenderOrderById(purchaseTenderOrder);
        try {
            order.setSaleBidNum((Integer) RedisUtil.get("saleBidNum_" + order.getId()));
        }catch (Exception e){
            order.setSaleBidNum(this.purchaseTenderMapper.getSaleBidNum(order));
        }
        if (order.getSaleBidNum()==null){
            order.setSaleBidNum(this.purchaseTenderMapper.getSaleBidNum(order));
        }
        return order;
    }

    public List<PurchaseTenderArea> getPurchaseTenderArea(PurchaseTenderOrder purchaseTenderOrder) {
        return this.purchaseTenderMapper.getPurchaseTenderArea(purchaseTenderOrder);
    }

    public void delPurchaseTenderArea(PurchaseTenderOrder purchaseTenderOrder) {
        this.purchaseTenderMapper.delPurchaseTenderArea(purchaseTenderOrder);
    }

    public void savePurchaseTenderSupplier(List<PurchaseTenderOrderSupplier> purchaseTenderOrderSupplierList) {
        this.purchaseTenderMapper.savePurchaseTenderSupplier(purchaseTenderOrderSupplierList);
    }

    public Grid getPurchaseSupplier(PurchaseTenderOrderSupplier purchaseTenderOrderSupplier) {
        Grid grid = new Grid();
        grid.setRows(this.purchaseTenderMapper.getPurchaseSupplierList(purchaseTenderOrderSupplier));
        grid.setTotal(this.purchaseTenderMapper.getPurchaseSupplierListCot(purchaseTenderOrderSupplier));
        return grid;
    }

    public void delPurchaseTenderSupplier(PurchaseTenderOrder purchaseTenderOrder) {
        this.purchaseTenderMapper.delPurchaseTenderSupplier(purchaseTenderOrder);
    }

    public void insertConcernCompany(CompSuppliers compSuppliers) {
        JSONObject obj = new JSONObject();
        obj.put("compId",compSuppliers.getSupplierId());
        obj.put("supplierRelationship",compSuppliers.getSupplierRelationship());
        obj.put("supplierType",compSuppliers.getSupplierType());
        if (this.compSuppliersMapper.getCompSuppliers(obj)==null){
            this.compSuppliersMapper.insert(compSuppliers);
        }
    }

    public List<PurchaseTenderOrder> getTenderRecommendList(List<String> ids) {
        return this.purchaseTenderMapper.getTenderRecommendList(ids);
    }

    public void saveReview(PurchaseTenderOrder purchaseTenderOrder) {
        this.purchaseTenderMapper.saveReview(purchaseTenderOrder);
    }
}
