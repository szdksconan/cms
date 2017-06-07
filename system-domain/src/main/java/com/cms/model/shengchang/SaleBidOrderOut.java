package com.cms.model.shengchang;

import com.cms.model.util.GlobalOrderTypeEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 2016/5/16.
 */
public class SaleBidOrderOut implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String orderCode;//招标单号
    private String orderName;//招标单名称
    private String createTime;//创建时间
    private String updateTime;//更新时间
    private String purchaseTenderId;//招标单id
    private String companyId;//企业id
    private String companyName;//企业name
    private String companyAddress;//企业地址
    private String industryId;//行业id
    private String industryName;//行业name
    private String operationModel;//规格型号
    private String linkMan;//联系人
    private String linkTel;//联系电话
    private String faxNumber;//传真号
    private String email;//邮箱
    private List<SaleBidOrderDetailOut> saleBidOrderDetailList=new ArrayList<SaleBidOrderDetailOut>();
    private String priceExpiryTime;//价格有效期
    private String otherDescription;//其他说明
    private Integer state;//状态
    private String stateName;
    private String endTime;//投标截止日
    private Boolean deleteFlag;//删除标记
    private Boolean saved;//评审是否暂存

    public List<SaleBidOrderDetailOut> getSaleBidOrderDetailList() {
        return saleBidOrderDetailList;
    }
    public void setSaleBidOrderDetailList(List<SaleBidOrderDetailOut> saleBidOrderDetailList) {
        this.saleBidOrderDetailList = saleBidOrderDetailList;
    }
    public Boolean getSaved() {
        return saved;
    }
    public void setSaved(Boolean saved) {
        this.saved = saved;
    }
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getStateName() {
        try {
            return GlobalOrderTypeEnum.getName(this.state);
        }catch (Exception e){}
        return "";
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getOtherDescription() {
        return otherDescription;
    }
    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }
    public String getPriceExpiryTime() {
        return priceExpiryTime;
    }
    public void setPriceExpiryTime(String priceExpiryTime) {
        this.priceExpiryTime = priceExpiryTime;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getOrderCode() {
        return orderCode;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    public String getOrderName() {
        return orderName;
    }
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getPurchaseTenderId() {
        return purchaseTenderId;
    }
    public void setPurchaseTenderId(String purchaseTenderId) {
        this.purchaseTenderId = purchaseTenderId;
    }
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
    public String getCompanyAddress() {
        return companyAddress;
    }
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
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
    public String getOperationModel() {
        return operationModel;
    }
    public void setOperationModel(String operationModel) {
        this.operationModel = operationModel;
    }
    public String getLinkMan() {
        return linkMan;
    }
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    public String getLinkTel() {
        return linkTel;
    }
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }
    public String getFaxNumber() {
        return faxNumber;
    }
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
