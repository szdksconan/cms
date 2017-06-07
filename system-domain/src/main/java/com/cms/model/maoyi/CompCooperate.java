package com.cms.model.maoyi;


public class CompCooperate {
    private Long id;

    private Long entId;

    private Long compId;

    private String compName;

    private String compAc;

    private String compAn;

    private String compAl;

    private String compAd;

    private String brand;

    private Integer cooperateType;

    private String cooperateArea;

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

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    public String getCompAc() {
        return compAc;
    }

    public void setCompAc(String compAc) {
        this.compAc = compAc == null ? null : compAc.trim();
    }

    public String getCompAn() {
        return compAn;
    }

    public void setCompAn(String compAn) {
        this.compAn = compAn == null ? null : compAn.trim();
    }

    public String getCompAl() {
        return compAl;
    }

    public void setCompAl(String compAl) {
        this.compAl = compAl == null ? null : compAl.trim();
    }

    public String getCompAd() {
        return compAd;
    }

    public void setCompAd(String compAd) {
        this.compAd = compAd == null ? null : compAd.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Integer getCooperateType() {
        return cooperateType;
    }

    public void setCooperateType(Integer cooperateType) {
        this.cooperateType = cooperateType;
    }

    public String getCooperateArea() {
        return cooperateArea;
    }

    public void setCooperateArea(String cooperateArea) {
        this.cooperateArea = cooperateArea == null ? null : cooperateArea.trim();
    }
}