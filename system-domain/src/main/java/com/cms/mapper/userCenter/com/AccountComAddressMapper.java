package com.cms.mapper.userCenter.com;

import java.util.List;

import com.cms.model.userCenter.SysUserGoodsAddress;


/**
 * @author penglei
 *
 * 2016年2月29日
 */
public interface AccountComAddressMapper {

	//拿到收货地址列表
	List<SysUserGoodsAddress> findAllComeAds();

	//保存收货地址
	void addComeAds(SysUserGoodsAddress address);
	
	//清空默认收货地址设置
	void removeDefault(long uid);

	//删除收货地址
	void deleteAds(String id);

}
