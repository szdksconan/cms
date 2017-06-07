package com.cms.model.shengchang;

import java.io.Serializable;

/**
 * Created by liuxin on 2016/5/16.
 */
public class PurchaseTenderDetailDoc implements Serializable,Comparable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String purchaseTenderDetailId;//招标单id
    private String fileUrl;//文件url
    private String fileKey;//S3 key
    private Integer fileType;//文件类型
    private Integer sort;//排序
    private String createTime;//创建时间

    public String getPurchaseTenderDetailId() {
        return purchaseTenderDetailId;
    }
    public void setPurchaseTenderDetailId(String purchaseTenderDetailId) {
        this.purchaseTenderDetailId = purchaseTenderDetailId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public Integer getFileType() {
        return fileType;
    }
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int compareTo(Object o) {
        PurchaseTenderDetailDoc purchaseTenderDetailDoc = (PurchaseTenderDetailDoc) o;
        if (this.sort==null || purchaseTenderDetailDoc.sort==null){
            return 0;
        }
        if (this.id.equals(purchaseTenderDetailDoc.id)){
            return 0;
        }
        return this.sort - purchaseTenderDetailDoc.sort;
    }
}
