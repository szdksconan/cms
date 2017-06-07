package com.cms.model.shengchang;

import java.io.Serializable;

/**
 * Created by liuxin on 2016/5/16.
 */
public class PurchaseTenderDoc implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String purchaseTenderId;//招标单id
    private String fileUrl;//文件url
    private String fileKey;//S3 key
    private String fileType;//文件类型
    private String sort;//排序
    private String createTime;//创建时间

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPurchaseTenderId() {
        return purchaseTenderId;
    }
    public void setPurchaseTenderId(String purchaseTenderId) {
        this.purchaseTenderId = purchaseTenderId;
    }
    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    public String getFileKey() {
        return fileKey;
    }
    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
