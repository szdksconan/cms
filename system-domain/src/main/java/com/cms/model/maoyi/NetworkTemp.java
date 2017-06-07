package com.cms.model.maoyi;

import java.io.Serializable;


public class NetworkTemp implements Serializable{
    private Long id;

    private String entName;

    private String entAc;

    private String entAn;

    private String entAl;

    private String entAd;

    private String contactPerson;

    private String tel;
    
    private Integer recordState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName == null ? null : entName.trim();
    }

    public String getEntAc() {
        return entAc;
    }

    public void setEntAc(String entAc) {
        this.entAc = entAc == null ? null : entAc.trim();
    }

    public String getEntAn() {
        return entAn;
    }

    public void setEntAn(String entAn) {
        this.entAn = entAn == null ? null : entAn.trim();
    }

    public String getEntAl() {
        return entAl;
    }

    public void setEntAl(String entAl) {
        this.entAl = entAl == null ? null : entAl.trim();
    }

    public String getEntAd() {
        return entAd;
    }

    public void setEntAd(String entAd) {
        this.entAd = entAd == null ? null : entAd.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
    
    public Integer getRecordState() {
        return recordState;
    }

    public void setRecordState(Integer recordState) {
        this.recordState = recordState;
    }
}