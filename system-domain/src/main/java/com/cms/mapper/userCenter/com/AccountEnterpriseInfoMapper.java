package com.cms.mapper.userCenter.com;

import com.cms.model.userCenter.SysUserEnterpriseInfo;

/**
 * @author penglei
 *
 * 2016年2月29日
 */
public interface AccountEnterpriseInfoMapper {
	
	//拿到企业信息
	SysUserEnterpriseInfo getEnterpriseInfo(String uid);
	
	//添加企业信息
	void saveEnterpriseInfo(SysUserEnterpriseInfo enterpriseInfo);
	
	//修改企业信息
	void updateEnterpriseInfo(SysUserEnterpriseInfo enterpriseInfo);
}
