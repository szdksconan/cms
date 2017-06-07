package com.cms.model.util;

import java.util.List;

public class SessionInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;// 用户ID
	private String name;//用户姓名
	private String loginName;// 登录名
	private Long companyId;// 企业Id
	private Long roleId;//角色id
	private Long departmentId;//部门id
	private String companyName;//公司名称
	private String tel;//联系电话
	private String tel1;//备用电话1
	private String tel2;//备用电话2
	private String companyGarden;//物流园
	private Boolean isSuperAadmin=false;//是否厂商管理员
    private Integer belongAreaId;//所属省份区域
	private List<String> accessList;// 用户可以访问的资源地址列表
	private List<String> allAccessList;//系统中所有资源地址
	private Integer different;//信息保护时间 单位:分钟

    public Integer getBelongAreaId() {
        return belongAreaId;
    }

    public void setBelongAreaId(Integer belongAreaId) {
        this.belongAreaId = belongAreaId;
    }

    public String getCompanyGarden() {
		return companyGarden;
	}

	public void setCompanyGarden(String companyGarden) {
		this.companyGarden = companyGarden;
	}

	public List<String> getAllAccessList() {
		return allAccessList;
	}

	public void setAllAccessList(List<String> allAccessList) {
		this.allAccessList = allAccessList;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<String> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<String> accessList) {
		this.accessList = accessList;
	}

	public Boolean isSuperAadmin() {
		return isSuperAadmin;
	}

	public void setSuperAadmin(Boolean isSuperAadmin) {
		this.isSuperAadmin = isSuperAadmin;
	}

	public Integer getDifferent() {
		return different;
	}

	public void setDifferent(Integer different) {
		this.different = different;
	}
	
	
	
}
