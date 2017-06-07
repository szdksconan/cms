package com.cms.model.shengchang;

import java.io.Serializable;

public class CompMainProArea implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long id;

 
    private Long compid;


    private String sheng;


    private String city;


    private String xian;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCompid() {
		return compid;
	}


	public void setCompid(Long compid) {
		this.compid = compid;
	}


	public String getSheng() {
		return sheng;
	}


	public void setSheng(String sheng) {
		this.sheng = sheng;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getXian() {
		return xian;
	}


	public void setXian(String xian) {
		this.xian = xian;
	}
    
   
}