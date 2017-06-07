package com.cms.service.userCenter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.userCenter.SysUserTradeAccoutDao;
import com.cms.iservice.userCenter.SysUserTradeAccountService;
import com.cms.mapper.userCenter.SysUserTradeAccoutMapper;
import com.cms.model.userCenter.SysUserTradeAccout;
import com.cms.model.userCenter.SysUserTradeInfo;

public class SysUserTradeAccountServiceImpl implements SysUserTradeAccountService {
	/**
	 * 对账号信息进行保存
	 */
	//注入dao
	@Autowired
	private SysUserTradeAccoutDao sysUserTradeAccoutDao;
	public void addTradeAccount(SysUserTradeAccout sysUserTradeAccount) {
		this.sysUserTradeAccoutDao.addTradeAccount(sysUserTradeAccount);
	}
//	public List<SysUserTradeInfo> findTradeInfoByCreateTime(Map<String, Object> tempMap) {
//		return this.sysUserTradeAccoutDao.findTradeInfoByCreateTime(tempMap);
//	}
}
