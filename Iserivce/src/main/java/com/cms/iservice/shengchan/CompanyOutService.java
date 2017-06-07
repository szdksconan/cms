package com.cms.iservice.shengchan;

import com.cms.model.shengchang.CompanyToOutBean;

public interface CompanyOutService {

	
	/**
	 * 根据企业id获取企业门户信息封装成CompanyToOutBean
	 * 推送给贸易平台或消费平台
	 * @param id
	 * @return
	 */
	public CompanyToOutBean getOutBeanById(String id);
	
	
	
}
