package com.cms.dao.userCenter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.userCenter.SysUserTradeAccoutMapper;
import com.cms.model.userCenter.SysUserTradeAccout;
import com.cms.model.userCenter.SysUserTradeInfo;
@Component
public class SysUserTradeAccountDaoImpl implements SysUserTradeAccoutDao {
	//注入接口映射器
	@Autowired
	private SysUserTradeAccoutMapper sysUserTradeAccoutMapper;
	public void addTradeAccount(SysUserTradeAccout sysUserTradeAccount) {
		this.sysUserTradeAccoutMapper.addTradeAccount(sysUserTradeAccount);
	}
//	public List<SysUserTradeInfo> findTradeInfoByCreateTime(Map<String, Object> tempMap) {
//		return this.sysUserTradeAccoutMapper.findTradeInfoByCreateTime(tempMap);
//	}
}
