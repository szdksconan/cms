package com.cms.model.shengchang;

import java.io.Serializable;

/**
 * 产品附件
 * @author liuxin
 *
 */

public class ProductDocBean implements Serializable,Comparable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 5826935376824779363L;
	private String id; //id
	private String productId; //产品ID
	private String fileUrl; //文件url
    private String fileKey;//文件key
	private Integer fileType; //文件类型
	private Boolean isMain; //是否主要
    private Integer sort;//排序
	private String createTime; //生成时间

    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getFileKey() {
        return fileKey;
    }
    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    public Integer getFileType() {
        return fileType;
    }
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
    public Boolean getIsMain() {
        return isMain;
    }
    public void setIsMain(Boolean isMain) {
        this.isMain = isMain;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int compareTo(Object o) {
        ProductDocBean productDocBean = (ProductDocBean) o;
        if (this.sort==null || productDocBean.sort==null){
            return 0;
        }
        if (this.id.equals(productDocBean.id)){
            return 0;
        }
        return this.sort - productDocBean.sort;
    }

    public boolean equals(Object o){
        if (o instanceof ProductDocBean){
            ProductDocBean bean = (ProductDocBean) o;
            return id.equals(bean.getId());
        }
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }
}
