package com.cms.model.dict;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuxin on 2016/4/14.
 */
public class BaseProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String value;
    private String code;
    private String name;
    private String label;
    private String superId;
    private Integer level;
    private String keywords;
    private String spell;
    private String status;
    private String remark;
    private List<BaseProduct> s;
    private String n;

    public String getN() {
        return n;
    }
    public void setN(String n) {
        this.n = n;
    }
    public String getSuperId() {
        return superId;
    }
    public void setSuperId(String superId) {
        this.superId = superId;
    }
    public List<BaseProduct> getS() {
        return s;
    }
    public void setS(List<BaseProduct> s) {
        this.s = s;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getSpell() {
        return spell;
    }
    public void setSpell(String spell) {
        this.spell = spell;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
