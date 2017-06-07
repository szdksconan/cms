package com.cms.dao.userCenter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.userCenter.SysUserTradeMapper;
import com.cms.model.userCenter.SysUserTradeInfo;
import com.cms.model.userCenter.SysUserTradeInfoQuery;
@Component
public class SysUserTradeDaoImpl implements SysUserTradeDao {
	//注入mapper 接口
	@Autowired
	private SysUserTradeMapper sysUserTradeMapper;
	
	//添加账户信息
//	public void addTradeInfo(SysUserTradeInfo sysUserTradeInfo) {
//		this.sysUserTradeMapper.addTradeInfo(sysUserTradeInfo);
//	}
	//显示账户信息
	public List<Map<String,Object>>  findTradeInfoByCreateTime(SysUserTradeInfoQuery query) {
		return this.sysUserTradeMapper.findTradeInfoByCreateTime(query);
	}

}
