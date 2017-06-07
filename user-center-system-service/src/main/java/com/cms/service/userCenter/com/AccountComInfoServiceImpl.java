package com.cms.service.userCenter.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.iservice.userCenter.com.IAccountComInfoService;
import com.cms.mapper.userCenter.com.AccountComAddressMapper;
import com.cms.mapper.userCenter.com.AccountComSysUserMapper;
import com.cms.mapper.userCenter.com.AccountEnterpriseInfoMapper;
import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserEnterpriseInfo;
import com.cms.model.userCenter.SysUserGoodsAddress;

/**
 * @author penglei
 *
 * 2016年2月18日
 */
@Service
public class AccountComInfoServiceImpl implements IAccountComInfoService {
	
	@Autowired
	private AccountComSysUserMapper accountComSysUserMapper;
	
	@Autowired
	private AccountEnterpriseInfoMapper accountEnterpriseInfoMapper;
	
	@Autowired
	private AccountComAddressMapper accountComAddressMapper;
	
	//调用企业账户基本信息方法
	public SysUser getSysUser(String uid) {
		
		return accountComSysUserMapper.getSysUser(uid);
	}

	//调用更新企业账户基本信息方法
	public void updateBasicInfo(SysUser sysUser) {
		accountComSysUserMapper.updateBasicInfo(sysUser);
	}
	
	//调用拿到企业信息方法
	public SysUserEnterpriseInfo getEnterpriseInfo(String uid) {
		return accountEnterpriseInfoMapper.getEnterpriseInfo(uid);
	}
	
	//调用保存企业信息方法
	public void saveEnterpriseInfo(SysUserEnterpriseInfo enterpriseInfo) {
		accountEnterpriseInfoMapper.saveEnterpriseInfo(enterpriseInfo);
	}
	//调用更新企业信息方法
	public void updateEnterpriseInfo(SysUserEnterpriseInfo enterpriseInfo) {
		accountEnterpriseInfoMapper.updateEnterpriseInfo(enterpriseInfo);
		
	}
	//拿到收货地址列表
	public List<SysUserGoodsAddress> findAllComeAds() {
		
		return accountComAddressMapper.findAllComeAds();
	}
	//保存收货地址
	public void addComeAds(SysUserGoodsAddress address) {
		String isDefault=address.getIsDefault();
		if(isDefault!=null){
			//设置了默认收货地址,清空其他收货地址的默认设置
			accountComAddressMapper.removeDefault(address.getUid());
		}
		accountComAddressMapper.addComeAds(address);
	}
	//删除收货地址
	public void deleteAds(String id) {
		accountComAddressMapper.deleteAds(id);
	}

}
