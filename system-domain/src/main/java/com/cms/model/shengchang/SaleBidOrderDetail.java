package com.cms.model.shengchang;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liuxin on 2016/5/16.
 */
public class SaleBidOrderDetail implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;//id
    private String saleBidOrderId;//投标单id
    private String purchaseTenderId;//招标单id
    private String purchaseTenderDetailId;//招标单明细id
    private String productName;//物资名称
    private String productModelSize;//物资规格型号
    private Integer count;//数量
    private Integer actuallyCount;//实际数量
    private String unitId;//单位
    private String unitName;//单位
    private BigDecimal offerPrice;//报价单价
    private BigDecimal offerSubtotal;//报价小计
    private String offerRemark;//报价备注
    private String productDescription;//产品功能介绍
    private BigDecimal offerAmount;//报价总金额
    private String offerExplain;//报价文字说明
    private String deliveryTime;//交货日期
    private String productTypeId;//物资类别
    private String productTypeName;//物资类别
    private String docs;//附件
    private String description;//产品描述
    private Boolean saved;//评审是否暂存
    private Boolean reviewFlag;//评审标记

    public String getPurchaseTenderId() {
        return purchaseTenderId;
    }
    public void setPurchaseTenderId(String purchaseTenderId) {
        this.purchaseTenderId = purchaseTenderId;
    }
    public Boolean getReviewFlag() {
        return reviewFlag;
    }
    public void setReviewFlag(Boolean reviewFlag) {
        this.reviewFlag = reviewFlag;
    }
    public Boolean getSaved() {
        return saved;
    }
    public void setSaved(Boolean saved) {
        this.saved = saved;
    }
    public Integer getActuallyCount() {
        return actuallyCount;
    }
    public void setActuallyCount(Integer actuallyCount) {
        this.actuallyCount = actuallyCount;
    }
    public String getDocs() {
        return docs;
    }
    public void setDocs(String docs) {
        this.docs = docs;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public String getDeliveryTime() {
        return deliveryTime;
    }
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSaleBidOrderId() {
        return saleBidOrderId;
    }
    public void setSaleBidOrderId(String saleBidOrderId) {
        this.saleBidOrderId = saleBidOrderId;
    }
    public String getPurchaseTenderDetailId() {
        return purchaseTenderDetailId;
    }
    public void setPurchaseTenderDetailId(String purchaseTenderDetailId) {
        this.purchaseTenderDetailId = purchaseTenderDetailId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductModelSize() {
        return productModelSize;
    }
    public void setProductModelSize(String productModelSize) {
        this.productModelSize = productModelSize;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
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
    public BigDecimal getOfferPrice() {
        return offerPrice;
    }
    public void setOfferPrice(BigDecimal offerPrice) {
        this.offerPrice = offerPrice;
    }
    public BigDecimal getOfferSubtotal() {
        return offerSubtotal;
    }
    public void setOfferSubtotal(BigDecimal offerSubtotal) {
        this.offerSubtotal = offerSubtotal;
    }
    public String getOfferRemark() {
        return offerRemark;
    }
    public void setOfferRemark(String offerRemark) {
        this.offerRemark = offerRemark;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public BigDecimal getOfferAmount() {
        return offerAmount;
    }
    public void setOfferAmount(BigDecimal offerAmount) {
        this.offerAmount = offerAmount;
    }
    public String getOfferExplain() {
        return offerExplain;
    }
    public void setOfferExplain(String offerExplain) {
        this.offerExplain = offerExplain;
    }
}
