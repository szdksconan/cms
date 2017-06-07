package com.cms.model.maoyi;

import java.io.Serializable;

public class NetworkBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;

    private Long entId;

    private Long networkId;
    
    private Long tempNetworkId;

    private Integer cooperateType;
    
    private Integer recordState;
    
    private String entName;

    private String entAc;

    private String entAn;

    private String entAl;

    private String entAd;

    private String contactPerson;

    private String tel;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEntId() {
		return entId;
	}

	public void setEntId(Long entId) {
		this.entId = entId;
	}

	public Long getNetworkId() {
		return networkId;
	}

	public void setNetworkId(Long networkId) {
		this.networkId = networkId;
	}
	
	public Integer getCooperateType() {
		return cooperateType;
	}

	public void setCooperateType(Integer cooperateType) {
		this.cooperateType = cooperateType;
	}

	public Long getTempNetworkId() {
		return tempNetworkId;
	}

	public void setTempNetworkId(Long tempNetworkId) {
		this.tempNetworkId = tempNetworkId;
	}

	public Integer getRecordState() {
		return recordState;
	}

	public void setRecordState(Integer recordState) {
		this.recordState = recordState;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getEntAc() {
		return entAc;
	}

	public void setEntAc(String entAc) {
		this.entAc = entAc;
	}

	public String getEntAn() {
		return entAn;
	}

	public void setEntAn(String entAn) {
		this.entAn = entAn;
	}

	public String getEntAl() {
		return entAl;
	}

	public void setEntAl(String entAl) {
		this.entAl = entAl;
	}

	public String getEntAd() {
		return entAd;
	}

	public void setEntAd(String entAd) {
		this.entAd = entAd;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
