package com.cms.model.shengchang;

import java.io.Serializable;

public class DocOutBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 837104002450604912L;
	private String fileUrl;//文件地址
	private String fileType;//文件类型，列如:txt,img,doc等
	private String isMain;//是否主要标记 1：主要 0:次要
	private String remark;//文字介绍
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
