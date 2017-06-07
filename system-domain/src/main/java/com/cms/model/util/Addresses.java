package com.cms.model.util;

import java.util.ArrayList;
import java.util.List;

public class Addresses {
	private String province;
	private List<CompanyAddress> addr = new ArrayList<CompanyAddress>();
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public List<CompanyAddress> getAddr() {
		return addr;
	}
	public void setAddr(List<CompanyAddress> addr) {
		this.addr = addr;
	}
	
	
}
