package com.cms.iservice.userCenter.com;

import java.util.List;

import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserEnterpriseInfo;
import com.cms.model.userCenter.SysUserGoodsAddress;

/**
 * @author penglei
 *
 * 2016年2月18日
 */
public interface IAccountComInfoService {
	
	//拿到一个企业账号的基本信息
	SysUser getSysUser(String uid);
		
	 //修改企业账户的基本信息
	void updateBasicInfo(SysUser sysUser);
	
	//拿到企业信息
	SysUserEnterpriseInfo getEnterpriseInfo(String uid);
	
	//添加企业信息
	void saveEnterpriseInfo(SysUserEnterpriseInfo enterpriseInfo);
	
	//修改企业信息
	void updateEnterpriseInfo(SysUserEnterpriseInfo enterpriseInfo);

	//拿到收货地址列表
	List<SysUserGoodsAddress> findAllComeAds();
	
	//保存收货地址
	void addComeAds(SysUserGoodsAddress address);
	
	//删除收货地址
	void deleteAds(String id);
	
}
