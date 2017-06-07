package com.cms.model.maoyi;

import java.io.Serializable;
import java.util.Date;

public class TradeImage implements Serializable {
    private Long id;

    private Long enterpriseId;

    private Integer type;

    private String path;

    private Date uploadTime;

    private String description;

    private Long qulifaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQulifaId() {
        return qulifaId;
    }

    public void setQulifaId(Long qulifaId) {
        this.qulifaId = qulifaId;
    }

	@Override
	public String toString() {
		return "TradeImage [id=" + id + ", enterpriseId=" + enterpriseId + ", type=" + type + ", path=" + path
				+ ", uploadTime=" + uploadTime + ", description=" + description + ", qulifaId=" + qulifaId + "]";
	}
    
}