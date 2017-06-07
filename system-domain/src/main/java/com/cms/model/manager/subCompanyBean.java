package com.cms.model.manager;

import java.io.Serializable;

public class subCompanyBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long pid;
	private String companyId;
	private int floor;
	private String name;
	private int manageType;
	private int solicitation;
	private int provinceId;
	private int areaId;
	private int cityId;
	private String add;
	private String person;
	private String personTel;
	private String comTel;
	private double longitude;
	private double latitude;
	private String platformShow;
	private String substanceShow;
	private int seq;
	private String createTime;
	private String updateTime;
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getManageType() {
		return manageType;
	}
	public void setManageType(int manageType) {
		this.manageType = manageType;
	}
	public int getSolicitation() {
		return solicitation;
	}
	public void setSolicitation(int solicitation) {
		this.solicitation = solicitation;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getPersonTel() {
		return personTel;
	}
	public void setPersonTel(String personTel) {
		this.personTel = personTel;
	}
	public String getComTel() {
		return comTel;
	}
	public void setComTel(String comTel) {
		this.comTel = comTel;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getPlatformShow() {
		return platformShow;
	}
	public void setPlatformShow(String platformShow) {
		this.platformShow = platformShow;
	}
	public String getSubstanceShow() {
		return substanceShow;
	}
	public void setSubstanceShow(String substanceShow) {
		this.substanceShow = substanceShow;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}