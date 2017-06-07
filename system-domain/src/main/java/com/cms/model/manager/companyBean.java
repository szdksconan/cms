package com.cms.model.manager;

import java.io.Serializable;

public class companyBean implements Serializable{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

	private String companyId;

    private String companyName;

    private String companyNo;

    private String companyLogin;

    private String companyPwd;

    private String companyAdd;

    private String companyTel1;

    private String companyTel2;

    private String companyCreateDate;

    private double companyMoney;

    private int messageSum;

    private int checkSum;

    private double telSum;

    private String beginAdd;

    private String endAdd;

    private String companyGarden;

    private String companyGis;

    private String companyType;

    private String companyPic;
    

    
    private String companyLinkman;
    
    private int paperType;
    
    private String paperPic;
    
    private String industryPic;
    
    private String keyword;
    
    private String paperNo;
    
    private String companyPicMin;
    
    private String paperPicMin;
    
    private String industryPicMin;
    
    private String longitude;
    
    private String latitude;
    
    private String joinType;
    
    private String checkType;
    
    private String pname;
    
    private String aname;
    
    private String cname;
    
    private String status;
    
    private String companyContactnum;

    
	public String getCompanyPicMin() {
		return companyPicMin;
	}

	public void setCompanyPicMin(String companyPicMin) {
		this.companyPicMin = companyPicMin;
	}

	public String getPaperPicMin() {
		return paperPicMin;
	}

	public void setPaperPicMin(String paperPicMin) {
		this.paperPicMin = paperPicMin;
	}

	public String getIndustryPicMin() {
		return industryPicMin;
	}

	public void setIndustryPicMin(String industryPicMin) {
		this.industryPicMin = industryPicMin;
	}

	public String getPaperNo() {
		return paperNo;
	}

	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPaperType() {
		return paperType;
	}

	public void setPaperType(int paperType) {
		this.paperType = paperType;
	}

	public String getPaperPic() {
		return paperPic;
	}

	public void setPaperPic(String paperPic) {
		this.paperPic = paperPic;
	}

	public String getIndustryPic() {
		return industryPic;
	}

	public void setIndustryPic(String industryPic) {
		this.industryPic = industryPic;
	}

	public String getCompanyLinkman() {
		return companyLinkman;
	}

	public void setCompanyLinkman(String companyLinkman) {
		this.companyLinkman = companyLinkman;
	}



	public String getCompanyId() {
//        try {
//			return RSAUtils.decryptByPrivateKey(companyId.getBytes(), GlobalConstant.privateKey);
//		} catch (Exception e) {
//			e.printStackTrace();
			return companyId;
//		}
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    public String getCompanyLogin() {
        return companyLogin;
    }

    public void setCompanyLogin(String companyLogin) {
        this.companyLogin = companyLogin == null ? null : companyLogin.trim();
    }

    public String getCompanyPwd() {
        return companyPwd;
    }

    public void setCompanyPwd(String companyPwd) {
        this.companyPwd = companyPwd == null ? null : companyPwd.trim();
    }

    public String getCompanyAdd() {
        return companyAdd;
    }

    public void setCompanyAdd(String companyAdd) {
        this.companyAdd = companyAdd == null ? null : companyAdd.trim();
    }

    public String getCompanyTel1() {
        return companyTel1;
    }

    public void setCompanyTel1(String companyTel1) {
        this.companyTel1 = companyTel1 == null ? null : companyTel1.trim();
    }

    public String getCompanyTel2() {
        return companyTel2;
    }

    public void setCompanyTel2(String companyTel2) {
        this.companyTel2 = companyTel2 == null ? null : companyTel2.trim();
    }

    public String getCompanyCreateDate() {
        return companyCreateDate;
    }

    public void setCompanyCreateDate(String companyCreateDate) {
        this.companyCreateDate = companyCreateDate;
    }
    
    public double getCompanyMoney() {
		return companyMoney;
	}

	public void setCompanyMoney(double companyMoney) {
		this.companyMoney = companyMoney;
	}

	public int getMessageSum() {
		return messageSum;
	}

	public void setMessageSum(int messageSum) {
		this.messageSum = messageSum;
	}

	public int getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(int checkSum) {
		this.checkSum = checkSum;
	}

	public double getTelSum() {
		return telSum;
	}

	public void setTelSum(double telSum) {
		this.telSum = telSum;
	}

	public String getBeginAdd() {
		return beginAdd;
	}

	public void setBeginAdd(String beginAdd) {
		this.beginAdd = beginAdd;
	}

	public String getEndAdd() {
		return endAdd;
	}

	public void setEndAdd(String endAdd) {
		this.endAdd = endAdd;
	}

	public String getCompanyGarden() {
        return companyGarden;
    }

    public void setCompanyGarden(String companyGarden) {
        this.companyGarden = companyGarden == null ? null : companyGarden.trim();
    }

    public String getCompanyGis() {
        return companyGis;
    }

    public void setCompanyGis(String companyGis) {
        this.companyGis = companyGis == null ? null : companyGis.trim();
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getCompanyPic() {
        return companyPic;
    }

    public void setCompanyPic(String companyPic) {
        this.companyPic = companyPic == null ? null : companyPic.trim();
    }

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getJoinType() {
		return joinType;
	}

	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompanyContactnum() {
		return companyContactnum;
	}

	public void setCompanyContactnum(String companyContactnum) {
		this.companyContactnum = companyContactnum;
	}
    
    
}