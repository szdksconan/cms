package com.cms.iservice.maoyi;

import java.util.HashMap;
import java.util.List;

import com.cms.model.maoyi.EnterpriseToOutBean;
import com.cms.model.maoyi.StorageService;

public interface EnterpriseToOutService {

	/*
	 * 生产商或者消费者根据企业id拿到贸易商的基本信息
	 * 包括企业基本信息、网点布局、资质信息、服务能力
	 * @param id
	 * owner="ryan" group="maoyi"
	 * dubbo.registry.address:192.168.2.216
	 * */
			
	public EnterpriseToOutBean getEnterpriseOutInfo(Long id);
	
	//拿到所有的仓库信息
	public List<StorageService> getAllStorageById(Long id);
	
	
}
