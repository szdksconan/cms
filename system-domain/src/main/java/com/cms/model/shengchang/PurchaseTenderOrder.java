package com.cms.model.shengchang;

import com.cms.model.util.GlobalOrderTypeEnum;
import com.cms.model.util.GlobalTypeEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 2016/5/16.
 */
public class PurchaseTenderOrder implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String companyId;//企业id
    private String companyName;
    private String orderCode="";//招标单号
    private String orderName;//招标单名称
    private String createTime;//创建时间
    private BigDecimal deposit;//投标保证金
    private String endTime;//截止日
    private String resultReleaseTime;//结果公布日期
    private String priceViewTime;//价格查看日期
    private String linkMan;//联系人
    private String linkTel;//联系电话
    private String faxNumber;//传真号
    private String email;//邮箱
    private String deliverAddress;//交货地址
    private String deliverAddressId;//
    private String deliverAddressDetail;//交货地址明细
    private String tenderType;//招标方式
    private BigDecimal registeredFunds;//企业注册资金
    private String companyProperty;//企业性质
    private String companyPropertyName;//
    private String operationModel;//经营模式
    private String operationModelName;
    private String creditGrade;//诚信等级
    private String creditGradeName;
    private String payType;//付款方式
    private String dealRuleDescription;//交易规则描述
    private String supplementRequire;//补充要求
    private Boolean deleteFlag=false;//删除标记
    private String purchaseTenderDetailArrayStr="";
    private List<PurchaseTenderDetail> purchaseTenderDetailList=new ArrayList<PurchaseTenderDetail>();
    private String purchaseTenderSourceId="";
    private String purchaseTenderSourceName="";
    private List<PurchaseTenderArea> purchaseTenderAreaList=new ArrayList<PurchaseTenderArea>();
    private String orderStr;
    private Integer state;
    private String stateName;
    private String updateTime;//更新时间
    private Boolean cyxz;
    private String createTimeStart;
    private String createTimeEnd;
    private String endTimeStart;
    private String endTimeEnd;
    private String purchaseTenderOrderSupplierStr="";
    private List<PurchaseTenderOrderSupplier> purchaseTenderOrderSupplierList;
    private String compBuyRuleId="";//规则id
    private String ruleName;//规则名称
    private String ruleTime;//编制时间
    private String creator;//编制人
    private String applyTypeId;//适用物资
    private String applyTypeName;//适用物资
    private String ruleSourceId;//物资来源
    private String ruleSourceName;//物资来源
    private String jiesuanType;//付款方式
    private String description;//交易规则
    private Integer saleBidNum=0;//投标人数
    private Boolean reviewFlag;//评审标记

    public Boolean getReviewFlag() {
        return reviewFlag;
    }
    public void setReviewFlag(Boolean reviewFlag) {
        this.reviewFlag = reviewFlag;
    }
    public Integer getSaleBidNum() {
        return saleBidNum;
    }
    public void setSaleBidNum(Integer saleBidNum) {
        this.saleBidNum = saleBidNum;
    }
    public String getRuleSourceId() {
        return ruleSourceId;
    }
    public void setRuleSourceId(String ruleSourceId) {
        this.ruleSourceId = ruleSourceId;
    }
    public String getRuleSourceName() {
        return ruleSourceName;
    }
    public void setRuleSourceName(String ruleSourceName) {
        this.ruleSourceName = ruleSourceName;
    }
    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getRuleTime() {
        return ruleTime;
    }
    public void setRuleTime(String ruleTime) {
        this.ruleTime = ruleTime;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getApplyTypeId() {
        return applyTypeId;
    }
    public void setApplyTypeId(String applyTypeId) {
        this.applyTypeId = applyTypeId;
    }
    public String getApplyTypeName() {
        return applyTypeName;
    }
    public void setApplyTypeName(String applyTypeName) {
        this.applyTypeName = applyTypeName;
    }
    public String getJiesuanType() {
        return jiesuanType;
    }
    public void setJiesuanType(String jiesuanType) {
        this.jiesuanType = jiesuanType;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCompBuyRuleId() {
        return compBuyRuleId;
    }
    public void setCompBuyRuleId(String compBuyRuleId) {
        this.compBuyRuleId = compBuyRuleId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyPropertyName() {
        try {
            return GlobalTypeEnum.getName(Integer.valueOf(this.companyProperty));
        }catch (Exception e){
            return "";
        }
    }
    public void setCompanyPropertyName(String companyPropertyName) {
        this.companyPropertyName = companyPropertyName;
    }
    public String getOperationModelName() {
        try {
            return GlobalTypeEnum.getName(Integer.valueOf(this.operationModel));
        }catch (Exception e){
            return "";
        }
    }
    public void setOperationModelName(String operationModelName) {
        this.operationModelName = operationModelName;
    }
    public String getCreditGradeName() {
        try {
            return GlobalTypeEnum.getName(Integer.valueOf(this.creditGrade));
        }catch (Exception e){
            return "";
        }
    }
    public void setCreditGradeName(String creditGradeName) {
        this.creditGradeName = creditGradeName;
    }
    public String getPurchaseTenderOrderSupplierStr() {
        return purchaseTenderOrderSupplierStr;
    }
    public void setPurchaseTenderOrderSupplierStr(String purchaseTenderOrderSupplierStr) {
        this.purchaseTenderOrderSupplierStr = purchaseTenderOrderSupplierStr;
    }
    public List<PurchaseTenderOrderSupplier> getPurchaseTenderOrderSupplierList() {
        return purchaseTenderOrderSupplierList;
    }
    public void setPurchaseTenderOrderSupplierList(List<PurchaseTenderOrderSupplier> purchaseTenderOrderSupplierList) {
        this.purchaseTenderOrderSupplierList = purchaseTenderOrderSupplierList;
    }
    public String getCreateTimeStart() {
        return createTimeStart;
    }
    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    public String getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    public String getEndTimeStart() {
        return endTimeStart;
    }
    public void setEndTimeStart(String endTimeStart) {
        this.endTimeStart = endTimeStart;
    }
    public String getEndTimeEnd() {
        return endTimeEnd;
    }
    public void setEndTimeEnd(String endTimeEnd) {
        this.endTimeEnd = endTimeEnd;
    }
    public Boolean getCyxz() {
        return cyxz;
    }
    public void setCyxz(Boolean cyxz) {
        this.cyxz = cyxz;
    }
    public String getStateName() {
        return GlobalOrderTypeEnum.getName(this.state);
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
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getOrderStr() {
        return orderStr;
    }
    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
    public List<PurchaseTenderArea> getPurchaseTenderAreaList() {
        return purchaseTenderAreaList;
    }
    public void setPurchaseTenderAreaList(List<PurchaseTenderArea> purchaseTenderAreaList) {
        this.purchaseTenderAreaList = purchaseTenderAreaList;
    }
    public String getPurchaseTenderSourceId() {
        return purchaseTenderSourceId;
    }
    public void setPurchaseTenderSourceId(String purchaseTenderSourceId) {
        this.purchaseTenderSourceId = purchaseTenderSourceId;
    }
    public String getPurchaseTenderSourceName() {
        return purchaseTenderSourceName;
    }
    public void setPurchaseTenderSourceName(String purchaseTenderSourceName) {
        this.purchaseTenderSourceName = purchaseTenderSourceName;
    }
    public String getDeliverAddressId() {
        return deliverAddressId;
    }
    public void setDeliverAddressId(String deliverAddressId) {
        this.deliverAddressId = deliverAddressId;
    }
    public String getPurchaseTenderDetailArrayStr() {
        return purchaseTenderDetailArrayStr;
    }
    public void setPurchaseTenderDetailArrayStr(String purchaseTenderDetailArrayStr) {
        this.purchaseTenderDetailArrayStr = purchaseTenderDetailArrayStr;
    }
    public List<PurchaseTenderDetail> getPurchaseTenderDetailList() {
        return purchaseTenderDetailList;
    }
    public void setPurchaseTenderDetailList(List<PurchaseTenderDetail> purchaseTenderDetailList) {
        this.purchaseTenderDetailList = purchaseTenderDetailList;
    }
    public String getDeliverAddressDetail() {
        return deliverAddressDetail;
    }
    public void setDeliverAddressDetail(String deliverAddressDetail) {
        this.deliverAddressDetail = deliverAddressDetail;
    }
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    public String getLinkTel() {
        return linkTel;
    }
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }
    public String getDealRuleDescription() {
        return dealRuleDescription;
    }
    public void setDealRuleDescription(String dealRuleDescription) {
        this.dealRuleDescription = dealRuleDescription;
    }
    public String getLinkMan() {
        return linkMan;
    }
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    public String getSupplementRequire() {
        return supplementRequire;
    }
    public void setSupplementRequire(String supplementRequire) {
        this.supplementRequire = supplementRequire;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
    public BigDecimal getDeposit() {
        return deposit;
    }
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getResultReleaseTime() {
        return resultReleaseTime;
    }
    public void setResultReleaseTime(String resultReleaseTime) {
        this.resultReleaseTime = resultReleaseTime;
    }
    public String getPriceViewTime() {
        return priceViewTime;
    }
    public void setPriceViewTime(String priceViewTime) {
        this.priceViewTime = priceViewTime;
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
    public String getDeliverAddress() {
        return deliverAddress;
    }
    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }
    public String getTenderType() {
        return tenderType;
    }
    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
    }
    public BigDecimal getRegisteredFunds() {
        return registeredFunds;
    }
    public void setRegisteredFunds(BigDecimal registeredFunds) {
        this.registeredFunds = registeredFunds;
    }
    public String getCompanyProperty() {
        return companyProperty;
    }
    public void setCompanyProperty(String companyProperty) {
        this.companyProperty = companyProperty;
    }
    public String getOperationModel() {
        return operationModel;
    }
    public void setOperationModel(String operationModel) {
        this.operationModel = operationModel;
    }
    public String getCreditGrade() {
        return creditGrade;
    }
    public void setCreditGrade(String creditGrade) {
        this.creditGrade = creditGrade;
    }
    public String getPayType() {
        return payType;
    }
    public void setPayType(String payType) {
        this.payType = payType;
    }
}
