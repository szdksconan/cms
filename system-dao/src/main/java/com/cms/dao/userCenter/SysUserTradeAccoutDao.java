package com.cms.dao.userCenter;

import java.util.List;
import java.util.Map;

import com.cms.model.userCenter.SysUserTradeAccout;
import com.cms.model.userCenter.SysUserTradeInfo;

public interface SysUserTradeAccoutDao {
	/**
	 *   添加账户信息
	 * @param sysUserTradeAccount
	 */
	void addTradeAccount(SysUserTradeAccout sysUserTradeAccount);
	/**
	 * 根据时间对交易信息进行查询
	 * @param tempMap 里面可以存放一些查询信息
	 * @return 返回的是交易信息的集合
	 */
//	List<SysUserTradeInfo> findTradeInfoByCreateTime(Map<String,Object> tempMap);
}
