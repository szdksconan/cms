package com.cms.iservice.maoyi;

import java.util.List;

import com.cms.model.maoyi.EnterpriseInfo;
import com.cms.model.maoyi.EnterpriseToOutBean;
import com.cms.model.maoyi.StorageService;

public interface LoginRegService {

	public Long getEnterId(Long id);

	/**
	 * 
	 * @param 生成的企业信息对象-enterpriseInfo
	 */
	public void addEnterInfo(EnterpriseInfo enterpriseInfo);	
}
