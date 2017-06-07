package com.cms.model.maoyi;

import java.util.List;

public class MaoyiToOutJavaBean {

	 //贸易商基本信息
	 private EnterpriseInfo enterpriseInfo;
	 
	 //资质信息，内含图片信息实体
	 private List<EnterpriseQualification> enterQualifs;
	 
	 //贸易商网点分布信息
	 private List<NetworkBean> networks;

	public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}

	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}

	public List<EnterpriseQualification> getEnterQualifs() {
		return enterQualifs;
	}

	public void setEnterQualifs(List<EnterpriseQualification> enterQualifs) {
		this.enterQualifs = enterQualifs;
	}

	public List<NetworkBean> getNetworks() {
		return networks;
	}

	public void setNetworks(List<NetworkBean> networks) {
		this.networks = networks;
	}
	 
}
