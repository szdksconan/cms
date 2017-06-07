package com.cms.model.maoyi;

import java.io.Serializable;


public class Network implements Serializable{
    private Long id;

    private Long entId;

    private Long networkId;

    private Long tempNetworkId;

    private Integer cooperateType;

    private Integer recordState;

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

    public Long getTempNetworkId() {
        return tempNetworkId;
    }

    public void setTempNetworkId(Long tempNetworkId) {
        this.tempNetworkId = tempNetworkId;
    }

    public Integer getCooperateType() {
        return cooperateType;
    }

    public void setCooperateType(Integer cooperateType) {
        this.cooperateType = cooperateType;
    }

    public Integer getRecordState() {
        return recordState;
    }

    public void setRecordState(Integer recordState) {
        this.recordState = recordState;
    }
}