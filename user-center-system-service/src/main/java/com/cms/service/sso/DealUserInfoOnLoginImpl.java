package com.cms.service.sso;

import com.cms.iservice.sso.DealUserInfoOnLogin;
import com.cms.service.common.redis.RedisUtil;

public class DealUserInfoOnLoginImpl implements DealUserInfoOnLogin {

	public void dealUserInfo(String loginName) {
		//同步方法将用户业务对象存入redis
		//RedisUtil.set("chpp:aaaa:"+loginName, "abcdefg");
		
		//异步方法将用户业务对象存入redis
		
		//登陆后的其他处理
		
	}

}
