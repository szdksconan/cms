package com.cms.model.shengchang;

import java.io.Serializable;

/**
 * 主营产品文档附件
 * @author weitianyu
 *
 */
public class MainDocBean implements Serializable,Comparable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private String id; //id
	private String pid; //主营产品ID或产品ID
	private String fileUrl;//文件地址
    private String fileKey;//文件key
	private Integer fileType;//文件类型，列如:txt,img,doc等
	private Boolean isMain;//是否主要标记 1：主要 0:次要
    private Integer sort;//排序
	private String createTime;//生成时间
	private String remark;//文字介绍

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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

    public int compareTo(Object o) {
        MainDocBean mainDocBean = (MainDocBean) o;
        if (this.sort==null || mainDocBean.sort==null){
            return 0;
        }
        if (this.id.equals(mainDocBean.id)){
            return 0;
        }
        return this.sort-mainDocBean.sort;
    }

    public boolean equals(Object o){
        if (o instanceof MainDocBean){
            MainDocBean bean = (MainDocBean) o;
            return id.equals(bean.getId());
        }
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }
}
