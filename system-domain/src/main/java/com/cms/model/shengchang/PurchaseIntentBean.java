package com.cms.model.shengchang;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by liuxin on 2016/5/13.
 */
public class PurchaseIntentBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;//主键
    private String productTypeId;//物资类别
    private String productTypeName;//物资类别
    private String productModelSize;//规格型号
    private String intentType;//意向类型
    private Integer intentTypeId;//意向类型
    private Integer count;//采购数量
    private String unitId;//单位
    private String unitName;//单位
    private BigDecimal price;//金额
    private BigDecimal price1;//金额
    private BigDecimal price2;//金额
    private String sourceId;//物资来源
    private String sourceName;//物资来源
    private String orderStr;//
    private String createTime;//创建时间
    private String companyId;//企业id
    private Boolean deleteFlag;//删除标记
    private List<PurchaseIntentAreaBean> purchaseIntentAreaBeanList;
    private String endTime;//截止日期

    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public Integer getIntentTypeId() {
        return intentTypeId;
    }
    public void setIntentTypeId(Integer intentTypeId) {
        this.intentTypeId = intentTypeId;
    }
    public BigDecimal getPrice1() {
        return price1;
    }
    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }
    public BigDecimal getPrice2() {
        return price2;
    }
    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    public List<PurchaseIntentAreaBean> getPurchaseIntentAreaBeanList() {
        return purchaseIntentAreaBeanList;
    }
    public void setPurchaseIntentAreaBeanList(List<PurchaseIntentAreaBean> purchaseIntentAreaBeanList) {
        this.purchaseIntentAreaBeanList = purchaseIntentAreaBeanList;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getOrderStr() {
        return orderStr;
    }
    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public String getProductModelSize() {
        return productModelSize;
    }
    public void setProductModelSize(String productModelSize) {
        this.productModelSize = productModelSize;
    }
    public String getIntentType() {
        return intentType;
    }
    public void setIntentType(String intentType) {
        this.intentType = intentType;
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
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getSourceId() {
        return sourceId;
    }
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
    public String getSourceName() {
        return sourceName;
    }
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
