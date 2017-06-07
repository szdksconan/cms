package com.cms.service.common.redis;

import redis.clients.jedis.Jedis;

public interface IJedisCallback {
	public Object doInJedis(Jedis js) throws RuntimeException;
}
