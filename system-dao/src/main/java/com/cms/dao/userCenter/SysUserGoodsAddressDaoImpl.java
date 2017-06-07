package com.cms.dao.userCenter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.userCenter.SysUserGoodsAddressMapper;
import com.cms.model.userCenter.SysUserGoodsAddress;
@Component
public class SysUserGoodsAddressDaoImpl implements SysUserGoodsAddressDao {
	
	@Autowired
	private SysUserGoodsAddressMapper sysUserGoodsAddressMapper;

	/**
	 * 添加收货地址
	 */
	public Integer add(SysUserGoodsAddress address) {
		// TODO Auto-generated method stub
		return this.sysUserGoodsAddressMapper.add(address);
	}

	/**
	 * 查询已保存地址
	 */
	public List<Map<String, Object>> selectSysUserGoodsAddress() {
		// TODO Auto-generated method stub
		return this.sysUserGoodsAddressMapper.selectSysUserGoodsAddress();
	}

}
