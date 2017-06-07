package com.cms.model.shengchang;

import java.io.Serializable;

public class MainProduct implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String setIntroduce; //介绍
    private String fileurl;
	public String getSetIntroduce() {
		return setIntroduce;
	}
	public void setSetIntroduce(String setIntroduce) {
		this.setIntroduce = setIntroduce;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
   

    
	
}
