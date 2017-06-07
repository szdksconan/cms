package com.cms.model.maoyi;

import java.io.Serializable;
import java.util.List;

public class EnterpriseToOutBean implements Serializable  {

	 //贸易商基本信息
	 private EnterpriseInfo enterpriseInfo;
	 
	 //资质信息，内含图片信息实体
	 private List<EnterpriseQualification> enterQualifs;
	 
	 //贸易商网点分布信息
	 private List<NetworkBean> networks;
     
	 //服务能力
	 private List<GoodsService> goodsServices;
	 
     //仓库信息
     private List<StorageService> storageServices;
     
     
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

	public List<GoodsService> getGoodsServices() {
		return goodsServices;
	}

	public void setGoodsServices(List<GoodsService> goodsServices) {
		this.goodsServices = goodsServices;
	}

	public List<StorageService> getStorageServices() {
		return storageServices;
	}

	public void setStorageServices(List<StorageService> storageServices) {
		this.storageServices = storageServices;
	}

	@Override
	public String toString() {
		return "EnterpriseToOutBean [enterpriseInfo=" + enterpriseInfo + ", enterQualifs=" + enterQualifs
				+ ", networks=" + networks + ", goodsServices=" + goodsServices + ", storageServices=" + storageServices
				+ "]";
	}
}
