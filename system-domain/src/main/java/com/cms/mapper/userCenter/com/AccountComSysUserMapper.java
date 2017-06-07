package com.cms.mapper.userCenter.com;

import java.util.List;

import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserEnterpriseInfo;
import com.cms.model.userCenter.SysUserGoodsAddress;

/**
 * @author penglei
 *
 * 2016年2月18日
 */
public interface AccountComSysUserMapper {
	//拿到一个企业账号的基本信息
	SysUser getSysUser(String uid);
	
	 //修改企业账户的基本信息
	 void updateBasicInfo(SysUser sysUser);
	 
}
