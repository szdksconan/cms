package com.cms.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String loginName;
	private String password;
	private String isVail;
    private String tel;//联系电话
    private String tel1;//备用电话1
    private String tel2;//备用电话2
    private String companyName;//公司名称
    private Long companyId;// 企业Id
    private Integer belongAreaId;//所属省份区域

	public User() {

	}

    public Integer getBelongAreaId() {
        return belongAreaId;
    }

    public void setBelongAreaId(Integer belongAreaId) {
        this.belongAreaId = belongAreaId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsVail() {
		return isVail;
	}

	public void setIsVail(String isVail) {
		this.isVail = isVail;
	}
	
	
}
