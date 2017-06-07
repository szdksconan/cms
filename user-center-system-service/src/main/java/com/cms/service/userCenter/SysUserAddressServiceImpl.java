package com.cms.service.userCenter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.userCenter.SysUserGoodsAddressDao;
import com.cms.iservice.userCenter.SysUserGoodsAddressService;
import com.cms.model.userCenter.SysUserGoodsAddress;

public class SysUserAddressServiceImpl implements SysUserGoodsAddressService{
	@Autowired
	private SysUserGoodsAddressDao sysUserGoodsAddressDao;
	public Integer add(SysUserGoodsAddress address) {
		// TODO Auto-generated method stub
		return this.sysUserGoodsAddressDao.add(address);
	}

	public List<Map<String, Object>> selectSysUserGoodsAddress() {
		// TODO Auto-generated method stub
		return this.sysUserGoodsAddressDao.selectSysUserGoodsAddress();
	}

}
