package com.cms.model.shengchang;

import java.io.Serializable;

/**
 * 招标邀请记录表
 * Created by liuxin on 2016/5/16.
 */
public class PurchaseTenderOrderSupplierOut implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;//id
    private String purchaseTenderOrderId;//招标单id
    private String purchaseCompanyId;//生产企业id
    private String purchaseCompanyName;//生产企业name
    private String tradersId;//贸易商id
    private String tradersName;//贸易商name
    private Integer compTypeId;//企业性质
    private String compType;//企业性质
    private String mainIndustryId;//所属行业
    private String mainIndustry;//所属行业
    private Integer businessModelId;//经营模式
    private String businessModel;//经营模式
    private String address;//所在地区
    private Boolean state;//状态
    private String orderStr;
    private String infoSource;//来源
    private String companyId;//供应商id
    private String companyName;//供应商名称

    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getInfoSource() {
        return infoSource;
    }
    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }
    public String getOrderStr() {
        return orderStr;
    }
    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPurchaseTenderOrderId() {
        return purchaseTenderOrderId;
    }
    public void setPurchaseTenderOrderId(String purchaseTenderOrderId) {
        this.purchaseTenderOrderId = purchaseTenderOrderId;
    }
    public String getPurchaseCompanyId() {
        return purchaseCompanyId;
    }
    public void setPurchaseCompanyId(String purchaseCompanyId) {
        this.purchaseCompanyId = purchaseCompanyId;
    }
    public String getPurchaseCompanyName() {
        return purchaseCompanyName;
    }
    public void setPurchaseCompanyName(String purchaseCompanyName) {
        this.purchaseCompanyName = purchaseCompanyName;
    }
    public String getTradersId() {
        return tradersId;
    }
    public void setTradersId(String tradersId) {
        this.tradersId = tradersId;
    }
    public String getTradersName() {
        return tradersName;
    }
    public void setTradersName(String tradersName) {
        this.tradersName = tradersName;
    }
    public Integer getCompTypeId() {
        return compTypeId;
    }
    public void setCompTypeId(Integer compTypeId) {
        this.compTypeId = compTypeId;
    }
    public String getCompType() {
        return compType;
    }
    public void setCompType(String compType) {
        this.compType = compType;
    }
    public String getMainIndustryId() {
        return mainIndustryId;
    }
    public void setMainIndustryId(String mainIndustryId) {
        this.mainIndustryId = mainIndustryId;
    }
    public String getMainIndustry() {
        return mainIndustry;
    }
    public void setMainIndustry(String mainIndustry) {
        this.mainIndustry = mainIndustry;
    }
    public Integer getBusinessModelId() {
        return businessModelId;
    }
    public void setBusinessModelId(Integer businessModelId) {
        this.businessModelId = businessModelId;
    }
    public String getBusinessModel() {
        return businessModel;
    }
    public void setBusinessModel(String businessModel) {
        this.businessModel = businessModel;
    }
    public Boolean getState() {
        return state;
    }
    public void setState(Boolean state) {
        this.state = state;
    }
}
