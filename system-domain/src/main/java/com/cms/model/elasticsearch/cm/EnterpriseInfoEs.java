package com.cms.model.elasticsearch.cm;

import java.io.Serializable;
import java.util.Date;


public class EnterpriseInfoEs implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    private String name;

    private String regAddAc;

    private String regAddAn;

    private String regAddAl;

    private String webSite;

    private String logoPath;

    private String enterpriseType;

    private String legalPerson;

    private String partner;

    private Date setTime;

    private String registerCapital;

    private String manageScale;

    private String contactPerson;

    private String contactTel;

    private String contactPhone;

    private String postcode;

    private String email;

    private String platformCode;

    private String qq;

    private String briefIntroduction;

    private String businessScope;

    private String businessIndustry;

    private String product;

    private Integer recordState;

    private Integer checkState;

    private Integer fromType;

    private String registerDetail;

    private String manaAddAc;

    private String manaAddAn;

    private String manageDetail;

    private String manaAddAl;
    //商铺离给定坐标点的距离(km)
    private Double manaDistance;

    private String barcodePath;

    private String developWill;

    private String joinWill;

    
	public Double getManaDistance() {
		return manaDistance;
	}

	public void setManaDistance(Double manaDistance) {
		this.manaDistance = manaDistance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegAddAc() {
		return regAddAc;
	}

	public void setRegAddAc(String regAddAc) {
		this.regAddAc = regAddAc;
	}

	public String getRegAddAn() {
		return regAddAn;
	}

	public void setRegAddAn(String regAddAn) {
		this.regAddAn = regAddAn;
	}

	public String getRegAddAl() {
		return regAddAl;
	}

	public void setRegAddAl(String regAddAl) {
		this.regAddAl = regAddAl;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public Date getSetTime() {
		return setTime;
	}

	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	public String getRegisterCapital() {
		return registerCapital;
	}

	public void setRegisterCapital(String registerCapital) {
		this.registerCapital = registerCapital;
	}

	public String getManageScale() {
		return manageScale;
	}

	public void setManageScale(String manageScale) {
		this.manageScale = manageScale;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getBriefIntroduction() {
		return briefIntroduction;
	}

	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getBusinessIndustry() {
		return businessIndustry;
	}

	public void setBusinessIndustry(String businessIndustry) {
		this.businessIndustry = businessIndustry;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getRecordState() {
		return recordState;
	}

	public void setRecordState(Integer recordState) {
		this.recordState = recordState;
	}

	public Integer getCheckState() {
		return checkState;
	}

	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}

	public Integer getFromType() {
		return fromType;
	}

	public void setFromType(Integer fromType) {
		this.fromType = fromType;
	}

	public String getRegisterDetail() {
		return registerDetail;
	}

	public void setRegisterDetail(String registerDetail) {
		this.registerDetail = registerDetail;
	}

	public String getManaAddAc() {
		return manaAddAc;
	}

	public void setManaAddAc(String manaAddAc) {
		this.manaAddAc = manaAddAc;
	}

	public String getManaAddAn() {
		return manaAddAn;
	}

	public void setManaAddAn(String manaAddAn) {
		this.manaAddAn = manaAddAn;
	}

	public String getManageDetail() {
		return manageDetail;
	}

	public void setManageDetail(String manageDetail) {
		this.manageDetail = manageDetail;
	}

	public String getManaAddAl() {
		return manaAddAl;
	}

	public void setManaAddAl(String manaAddAl) {
		this.manaAddAl = manaAddAl;
	}

	public String getBarcodePath() {
		return barcodePath;
	}

	public void setBarcodePath(String barcodePath) {
		this.barcodePath = barcodePath;
	}

	public String getDevelopWill() {
		return developWill;
	}

	public void setDevelopWill(String developWill) {
		this.developWill = developWill;
	}

	public String getJoinWill() {
		return joinWill;
	}

	public void setJoinWill(String joinWill) {
		this.joinWill = joinWill;
	}
    
}
