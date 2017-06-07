package com.cms.mapper.userCenter;

import java.util.List;
import java.util.Map;

import com.cms.model.userCenter.SysUserGoodsAddress;

public interface SysUserGoodsAddressMapper {
	
	/**
	 * 添加收货地址
	 * @param address
	 * @return
	 */
	public Integer add(SysUserGoodsAddress address);
	
	/**
	 * 查询已保存地址
	 * @return
	 */
	public List<Map<String, Object>> selectSysUserGoodsAddress();

}
