package com.cms.dao.userCenter;

import java.util.List;
import java.util.Map;

import com.cms.model.userCenter.SysUserTradeInfo;
import com.cms.model.userCenter.SysUserTradeInfoQuery;

public interface SysUserTradeDao {
	/**
	 *  添加账户信息
	 * @param sysUserTradeInfo
	 */
//	void addTradeInfo(SysUserTradeInfo sysUserTradeInfo);
	/**
	 * 根据时间对交易信息进行查询
	 * @param tempMap 里面可以存放一些查询信息
	 * @return 返回的是交易信息的集合
	 */
	List<Map<String,Object>>   findTradeInfoByCreateTime(SysUserTradeInfoQuery query);
}
