package com.cms.model.shengchang;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 2016/5/16.
 */
public class PurchaseTenderDetail implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String purchaseTenderId;//招标单id
    private String productId;//物资id
    private String productName;//物资name
    private String productTypeId;//分类id
    private String productTypeName;//分类name
    private String industryId;//行业id
    private String industryName;//行业name
    private String productModelSize;//规格型号
    private String count;//数量
    private String unitId;//单位id
    private String unitName;//单位name
    private String description;//描述
    private String deliverTime;//交货日期
    private String purchaseTenderDetailDocName;//附件name
    private List<PurchaseTenderDetailDoc> purchaseTenderDetailDocList=new ArrayList<PurchaseTenderDetailDoc>();
    private String delFileKeys="";
    private List<PurchaseTenderDetailDoc> delPurchaseTenderDetailDocList=new ArrayList<PurchaseTenderDetailDoc>();
    private String orderStr;
    private String updateTime;//发布时间
    private String endTime;//到期时间

    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getOrderStr() {
        return orderStr;
    }
    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
    public List<PurchaseTenderDetailDoc> getDelPurchaseTenderDetailDocList() {
        return delPurchaseTenderDetailDocList;
    }
    public void setDelPurchaseTenderDetailDocList(List<PurchaseTenderDetailDoc> delPurchaseTenderDetailDocList) {
        this.delPurchaseTenderDetailDocList = delPurchaseTenderDetailDocList;
    }
    public String getDelFileKeys() {
        return delFileKeys;
    }
    public void setDelFileKeys(String delFileKeys) {
        this.delFileKeys = delFileKeys;
    }
    public String getPurchaseTenderDetailDocName() {
        return purchaseTenderDetailDocName;
    }
    public void setPurchaseTenderDetailDocName(String purchaseTenderDetailDocName) {
        this.purchaseTenderDetailDocName = purchaseTenderDetailDocName;
    }
    public List<PurchaseTenderDetailDoc> getPurchaseTenderDetailDocList() {
        return purchaseTenderDetailDocList;
    }
    public void setPurchaseTenderDetailDocList(List<PurchaseTenderDetailDoc> purchaseTenderDetailDocList) {
        this.purchaseTenderDetailDocList = purchaseTenderDetailDocList;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPurchaseTenderId() {
        return purchaseTenderId;
    }
    public void setPurchaseTenderId(String purchaseTenderId) {
        this.purchaseTenderId = purchaseTenderId;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductTypeId() {
        return productTypeId;
    }
    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }
    public String getProductTypeName() {
        return productTypeName;
    }
    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
    public String getIndustryId() {
        return industryId;
    }
    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }
    public String getIndustryName() {
        return industryName;
    }
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
    public String getProductModelSize() {
        return productModelSize;
    }
    public void setProductModelSize(String productModelSize) {
        this.productModelSize = productModelSize;
    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getUnitId() {
        return unitId;
    }
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    public String getDeliverTime() {
        return deliverTime;
    }
    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }
}
