package com.cms.model.shengchang;

import java.io.Serializable;

public class PurchaseNeedDetailDocBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6685292221749457113L;

	private String filePath;
	
	private String fileKey;
	
	private String id;
	
	private String pid;

	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	
	

}
