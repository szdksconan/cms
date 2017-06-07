package com.cms.service.common.redis;

import redis.clients.jedis.Jedis;

public interface IJedisByParamsCallback {
	public Object doInJedis(Jedis js, Object ... params) throws RuntimeException;
}
