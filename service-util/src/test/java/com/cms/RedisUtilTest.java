package com.cms;

import com.cms.service.common.redis.RedisUtil;

public class RedisUtilTest {
	public static void main(String[] args){
		RedisUtil.hsetex("user:user9", 10,"loginname", "wangzhiwei1");
		System.out.println("set user:user9 wangzhiwei1");		
		System.out.println("get user9: "+RedisUtil.hget("user:user9","loginname"));
		
	}
}
