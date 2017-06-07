package com.cms.model.manager;

import java.io.Serializable;

public class stationBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String companyId;
	private String name;
	private String roleId;
	private String dataRoleId;
	private String roleName;
	private String dataRoleName;
	private int seq;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDataRoleName() {
		return dataRoleName;
	}
	public void setDataRoleName(String dataRoleName) {
		this.dataRoleName = dataRoleName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getDataRoleId() {
		return dataRoleId;
	}
	public void setDataRoleId(String dataRoleId) {
		this.dataRoleId = dataRoleId;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}
