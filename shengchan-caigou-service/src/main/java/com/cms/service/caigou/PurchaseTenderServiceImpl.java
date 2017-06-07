package com.cms.service.caigou;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.dao.shengchan.PurchaseTenderDao;
import com.cms.dao.shengchan.PurchaseTenderDetailDao;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.CompanyService;
import com.cms.iservice.shengchan.PurchaseTenderService;
import com.cms.iservice.shengchan.ShengchanRecommendService;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.shengchang.CompSuppliers;
import com.cms.model.shengchang.PurchaseTenderOrder;
import com.cms.model.shengchang.PurchaseTenderOrderSupplier;
import com.cms.model.util.Grid;
import com.cms.service.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 2016/5/16.
 */
public class PurchaseTenderServiceImpl implements PurchaseTenderService {
    @Autowired
    private PurchaseTenderDao purchaseTenderDao;
    @Autowired
    private PurchaseTenderDetailDao purchaseTenderDetailDao;
    @Autowired
    private ShengchanRecommendService shengchanRecommendService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private GlobalIdService globalIdService;

    public void savePurchaseTender(PurchaseTenderOrder purchaseTenderOrder) {
        this.purchaseTenderDao.savePurchaseTender(purchaseTenderOrder);
        if (purchaseTenderOrder.getPurchaseTenderAreaList().size()!=0){
            this.purchaseTenderDao.delPurchaseTenderArea(purchaseTenderOrder);
            this.purchaseTenderDao.savePurchaseTenderArea(purchaseTenderOrder.getPurchaseTenderAreaList());
        }
        if (purchaseTenderOrder.getPurchaseTenderDetailList().size()!=0){
            this.purchaseTenderDetailDao.savePurchaseTenderDetail(purchaseTenderOrder.getPurchaseTenderDetailList());
        }
        if (purchaseTenderOrder.getPurchaseTenderOrderSupplierList().size()!=0){
            this.purchaseTenderDao.delPurchaseTenderSupplier(purchaseTenderOrder);
            this.purchaseTenderDao.savePurchaseTenderSupplier(purchaseTenderOrder.getPurchaseTenderOrderSupplierList());
        }
    }

    public void delPurchaseTender(PurchaseTenderOrder purchaseTenderOrder) {
        this.purchaseTenderDao.delPurchaseTender(purchaseTenderOrder);
    }

    public Grid getPurchaseTender(PurchaseTenderOrder purchaseTenderOrder) {
        return this.purchaseTenderDao.getPurchaseTender(purchaseTenderOrder);
    }

    public PurchaseTenderOrder getPurchaseTenderOrderById(PurchaseTenderOrder purchaseTenderOrder) {
        PurchaseTenderOrder tender = this.purchaseTenderDao.getPurchaseTenderOrderById(purchaseTenderOrder);
        if (tender!=null){
            tender.setPurchaseTenderAreaList(this.purchaseTenderDao.getPurchaseTenderArea(purchaseTenderOrder));
            tender.setPurchaseTenderDetailList(this.purchaseTenderDetailDao.getPurchaseTenderDetailList(purchaseTenderOrder));
        }
        return tender;
    }

    public Grid getPurchaseSupplier(PurchaseTenderOrderSupplier purchaseTenderOrderSupplier) {
        return this.purchaseTenderDao.getPurchaseSupplier(purchaseTenderOrderSupplier);
    }

    public void savePurchaseTenderSupplier(PurchaseTenderOrder purchaseTenderOrder) {
        JSONArray supplierArray = JSONArray.parseArray(purchaseTenderOrder.getPurchaseTenderOrderSupplierStr());
        List<PurchaseTenderOrderSupplier> purchaseTenderOrderSupplierList = new ArrayList<PurchaseTenderOrderSupplier>();
        for (int i=0;i<supplierArray.size();i++){
            if (!"".equals(supplierArray.get(i))){
                PurchaseTenderOrderSupplier purchaseTenderOrderSupplier = JSONObject.toJavaObject(JSONObject.parseObject(supplierArray.getString(i)), PurchaseTenderOrderSupplier.class);
                purchaseTenderOrderSupplier.setId(purchaseTenderOrderSupplier.getId()!=null&&!"".equals(purchaseTenderOrderSupplier.getId())?purchaseTenderOrderSupplier.getId():globalIdService.getGlobalId().toString());
                purchaseTenderOrderSupplier.setPurchaseTenderOrderId(purchaseTenderOrder.getId());
                purchaseTenderOrderSupplierList.add(purchaseTenderOrderSupplier);
            }
        }
        purchaseTenderOrder.setPurchaseTenderOrderSupplierList(purchaseTenderOrderSupplierList);
        if (purchaseTenderOrder.getPurchaseTenderOrderSupplierList().size()!=0){
            this.purchaseTenderDao.savePurchaseTenderSupplier(purchaseTenderOrder.getPurchaseTenderOrderSupplierList());
        }
    }

    public List<CompBaseInfo> getSupplierRecommend() {
        List<String> list = this.shengchanRecommendService.getSupplierRecommend("1312312313",0,1000);
        List<CompBaseInfo> compBaseInfoList = new ArrayList<CompBaseInfo>();
        for (String id:list){
            CompBaseInfo compBaseInfo = (CompBaseInfo) RedisUtil.hget("CompBaseInfoList",id);
            if (compBaseInfo==null){
                compBaseInfo = this.companyService.getCompanyInfoById(id);
            }
            compBaseInfoList.add(compBaseInfo);
        }
        return compBaseInfoList;
    }

    public void insertConcernCompany(CompSuppliers compSuppliers) {
        this.purchaseTenderDao.insertConcernCompany(compSuppliers);
    }

    public void saveReview(PurchaseTenderOrder purchaseTenderOrder) {
        this.purchaseTenderDao.saveReview(purchaseTenderOrder);
    }
}
