package com.cms.service.common.redis;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.codis.jodis.JedisResourcePool;
import io.codis.jodis.RoundRobinJedisPool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	private static JedisResourcePool jedisPool;  
	private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);
	
	static {
		logger.info("init RedisUtil......");
		InputStream in = SerializeUtil.class.getClassLoader().getResourceAsStream("META-INF/spring/redis-node.properties");

		Properties pps = new Properties();
		 try {
			pps.load(in);
			String zkDomain = pps.getProperty("zkserver.domain").trim();
			String zkPort = pps.getProperty("zkserver.port").trim();
			String zkCodisPath = pps.getProperty("zkcodis.path").trim();
			String zkSessionTimeoutMs = pps.getProperty("zkcodis.zkSessionTimeoutMs","30000").trim();
			
			String maxActive = pps.getProperty("redis.pool.maxActive","8").trim();
			String maxIdle = pps.getProperty("redis.pool.maxIdle","1000").trim();
			String maxWaitMillis = pps.getProperty("redis.pool.maxWait","1000").trim();
			String testOnBorrow = pps.getProperty("redis.pool.testOnBorrow","true").trim();
			String testOnReturn = pps.getProperty("redis.pool.testOnReturn","true").trim();
			JedisPoolConfig poolConfig = new JedisPoolConfig();
			poolConfig.setMaxTotal(Integer.parseInt(maxActive));
			poolConfig.setMaxIdle(Integer.parseInt(maxIdle));
			poolConfig.setMaxWaitMillis(Long.parseLong(maxWaitMillis));
			poolConfig.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
			poolConfig.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
			
			jedisPool = RoundRobinJedisPool.create()
					.curatorClient(zkDomain+":"+zkPort,Integer.parseInt(zkSessionTimeoutMs))
					.zkProxyDir(zkCodisPath)
					.poolConfig(poolConfig)
					.build();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * set(key,value)：向名称为key的Object赋予值value
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean set(String key, Object value) {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			jc.set(key,new String(SerializeUtil.convertObj2Btyes(value),"ISO8859-1"));
			return true;
		}catch(RuntimeException e){
			logger.info("set方法得到{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			logger.info("set方法得到{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			logger.info("set方法得到{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw new RuntimeException(e);
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 向名称为key的Object赋予值value，设定过期时间seconds（秒）
	 * @param key
	 * @param seconds
	 * @param value
	 * @return
	 */
	public static boolean setex(String key, int seconds, Object value) {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			jc.setex(key,seconds,new String(SerializeUtil.convertObj2Btyes(value),"ISO8859-1"));
			return true;
		}catch(RuntimeException e){
			logger.info("setex方法添加"+key+"出错");
			e.getStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			logger.info("setex方法添加"+key+"出错");
			e.getStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			logger.info("setex方法添加"+key+"出错");
			e.getStackTrace();
			throw new RuntimeException(e);
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 返回名称为key的Object的value
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			String g = jc.get(key);
			if(g == null){
				return null;
			}
			return SerializeUtil.convertBytes2Obj(g.getBytes("ISO8859-1"));
			
		}catch(RuntimeException e){
			logger.info("get方法得到{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			logger.info("get方法得到{}出错:{}",key,e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			logger.info("get方法得到{}出错:{}",key,e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 删除名称为key的Object
	 * @param key
	 * @return
	 */
	public static  Long  del(String key) {
		if (jedisPool==null)
			return new Long(-1);
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.del(key);
		}catch(RuntimeException e){
			logger.info("del方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 删除多个key的键值
	 * @param key
	 * @return
	 */
	public static  Long  del(String ... key) {
		if (jedisPool==null)
			return new Long(-1);
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return 	jc.del(key);			
		}catch(RuntimeException e){
			logger.info("del(...)方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	

	/**
	 * 返回名称为key的String的value
	 * @param key
	 * @return
	 */
	public static Boolean exists(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.exists(key);			
		}catch(RuntimeException e){
			logger.info("exists方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}

	/**
	 * 返回名称为key的value的数据类型
	 * @param key
	 * @return
	 */
	public static String getType(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.type(key);
			
		}catch(RuntimeException e){
			logger.info("getType方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 设定key的过期时间seconds（秒）
	 * 过期时间都以key为标准，一个集合一组数据应该是一个整体，要过期都过期要存在都存在
	 * @param key
	 * @param seconds
	 * @return
	 */
	public static Long expire(String key,int seconds)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.expire(key, seconds);
		}catch(RuntimeException e){
			logger.info("expire方法{},{}出错：{}",key,seconds,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * set(key,value)：向名称为key的String赋予值value
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean setString(String key, String value)throws RuntimeException {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			jc.set(key,value);
			return true;
		}catch(RuntimeException e){
			logger.info("setString方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 向名称为key的Stromg赋予值value，设定过期时间seconds（秒）
	 * @param key
	 * @param seconds
	 * @param value
	 * @return
	 */
	public static boolean setStringEx(String key, int seconds, String value)throws RuntimeException {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			jc.setex(key,seconds,value);
			return true;
		}catch(RuntimeException e){
			logger.info("setStringEx方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 返回名称为key的String的value
	 * @param key
	 * @return
	 */
	public static String getString(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.get(key);			
		}catch(RuntimeException e){
			logger.info("get方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 数字递增1
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long incr(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.incr(key);
		}catch(RuntimeException e){
			logger.info("Incr方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 数字递减1
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long decr(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.decr(key);
		}catch(RuntimeException e){
			logger.info("decr方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 数字递增指定值
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long incrBy(String key, long increment)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.incrBy(key,increment);
		}catch(RuntimeException e){
			logger.info("incrBy方法{},{}出错:{}",key,increment,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 数字递减指定值
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long decrBy(String key, long increment)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.decrBy(key,increment);
		}catch(RuntimeException e){
			logger.info("decrBy方法{},{}出错:{}",key,increment,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 数字递增指定浮点值
	 * @param key
	 * @param value
	 * @return
	 */
	public static Double incrByFloat(String key, double increment)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.incrByFloat(key,increment);
		}catch(RuntimeException e){
			logger.info("incrByFloat方法{},{}出错:{}",key,increment,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 向后追加字符串
	 * @param key
	 * @param value
	 * @return 总长度
	 */
	public static Long append(String key, String app)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.append(key,app);
		}catch(RuntimeException e){
			logger.info("append方法{},{}出错:{}",key,app,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获取字符串长度
	 * @param key
	 * @param value
	 * @return 总长度
	 */
	public static Long strlen(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.strlen(key);
		}catch(RuntimeException e){
			logger.info("strlen方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获取指定位置的二进制位值
	 * @param key
	 * @param offset
	 * @return
	 */
	public static Boolean getbit(String key,long offset)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.getbit(key,offset);
		}catch(RuntimeException e){
			logger.info("getbit方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 设置指定位置的二进制位值
	 * @param key
	 * @param offset
	 * @return
	 */
	public static Boolean setbit(String key,long offset,boolean value)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.setbit(key,offset,value);
		}catch(RuntimeException e){
			logger.info("setbit方法{},{},{}出错:{}",key,offset,value,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * hset(key, field, value)：向名称为key的hash中添加元素field<—>value
	 * @param field
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean hset(String key, String field, Object value) {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			jc.hset(key, field, new String(SerializeUtil.convertObj2Btyes(value),"ISO8859-1"));
			return true;
		}catch(RuntimeException e){
			logger.info("hset方法{},{},{}出错,错误信息：{}",key,field,value,e.getMessage());
			e.getStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			logger.info("hset方法{},{},{}出错,错误信息：{}",key,field,value,e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			logger.info("hset方法{},{},{}出错,错误信息：{}",key,field,value,e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	/**
	 *  hget(key, field)：返回名称为key的hash中field对应的value
	 * @param field
	 * @param key
	 * @return
	 */
	public static Object hget(String key, String field) {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			String g = jc.hget(key, field);
			if(g == null){
				return null;
			}
			return SerializeUtil.convertBytes2Obj(g.getBytes("ISO8859-1"));
		} catch (RuntimeException e) {
			logger.info("hget方法{},{}出错,错误信息：{}",key,field,e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			logger.info("hget方法{},{}出错,错误信息：{}",key,field,e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			logger.info("hget方法{},{}出错,错误信息：{}",key,field,e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			if (jc!=null)
				jc.close();
		}
	}
	/**
	 * hsetex(key,seconds, field, value)：向名称为key的hash中添加元素field<—>value,设定过期时间seconds（秒）
	 * 过期时间都以key为标准，一个集合一组数据应该是一个整体，要过期都过期要存在都存在
	 * @param key
	 * @param seconds
	 * @param field
	 * @param value
	 * @return
	 */
	public static boolean hsetex(String key,int seconds, String field, Object value) {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			jc.hset(key, field, new String(SerializeUtil.convertObj2Btyes(value),"ISO8859-1"));
			jc.expire(key, seconds);
			return true;
		}catch(RuntimeException e){
			logger.info("hsetex方法{},{},{}出错,错误信息：{}",key,seconds,field,e.getMessage());
			e.getStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			logger.info("hsetex方法{},{},{}出错,错误信息：{}",key,seconds,field,e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			logger.info("hsetex方法{},{},{}出错,错误信息：{}",key,seconds,field,e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * hset(key, field, value)：向名称为key的hash中添加元素field<—>value
	 * @param field
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean hsetString(String key, String field, String value)throws RuntimeException {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			jc.hset(key, field, value);
			return true;
		}catch(RuntimeException e){
			logger.info("hsetString方法{},{},{}出错,错误信息：{}",key,field,value,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	/**
	 *  hget(key, field)：返回名称为key的hash中field对应的value
	 * @param field
	 * @param key
	 * @return
	 */
	public static String hgetString(String key, String field)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hget(key, field);
		} catch (RuntimeException e) {
			logger.info("hgetString方法{},{}出错,错误信息：{}",key,field,e.getMessage());
			e.printStackTrace();
			throw e;
		} finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 *  hgetAll(key, field)：返回名称为key的hash
	 * @param field
	 * @param key
	 * @return
	 */
	public static Map<String,String> hgetAll(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hgetAll(key);
		} catch (RuntimeException e) {
			logger.info("hgetAll方法{}出错,错误信息：{}",key,e.getMessage());
			e.printStackTrace();
			throw e;
		} finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 *  hmget(key, field)：返回名称为key的hash的0到多个字段
	 * @param field
	 * @param key
	 * @return
	 */
	public static List<String> hmget(String key,String ... field)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hmget(key,field);
		} catch (RuntimeException e) {
			logger.info("hmget方法{}出错,错误信息：{}",key,e.getMessage());
			e.printStackTrace();
			throw e;
		} finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 *  hmset(key, field)：返回名称为key的hash的0到多个字段
	 * @param field
	 * @param key
	 * @return
	 */
	public static String hmset(String key,Map<String,String> field)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hmset(key,field);
		} catch (RuntimeException e) {
			logger.info("hmset方法{}出错,错误信息：{}",key,e.getMessage());
			e.printStackTrace();
			throw e;
		} finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * hsetexString(key,seconds, field, value)：向名称为key的hash中添加元素field<—>value,设定过期时间seconds（秒）
	 * 过期时间都以key为标准，一个集合一组数据应该是一个整体，要过期都过期要存在都存在
	 * @param key
	 * @param seconds
	 * @param field
	 * @param value
	 * @return
	 */
	public static boolean hsetexString(String key,int seconds, String field, String value)throws RuntimeException {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			jc.hset(key, field, value);
			jc.expire(key, seconds);
			return true;
		}catch(RuntimeException e){
			logger.info("hsetexString方法"+key+"|"+field+"出错");
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * hsetnx(key, field, value)：向名称为key的hash中添加元素field<—>value,字段不存在时设置，否则不设置
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	public static boolean hsetnx(String key,String field, String value)throws RuntimeException {
		if (jedisPool==null)
			return false;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			jc.hset(key, field, value);
			//jc.expire(key, seconds);
			return true;
		}catch(RuntimeException e){
			logger.info("hsetnx方法{}，{}，{}出错：{}",key,field,value,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 删除名称为key的hash元素
	 * @param key
	 * @param field
	 * @return -1为失败
	 */
	public static Long hdel(String key,String ... field)throws RuntimeException{
		if (jedisPool==null)
			return new Long(-1);
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hdel(key, field);
		} catch (RuntimeException e) {
			logger.info("hdel方法{}出错：{}",key,e.getMessage());
			e.printStackTrace();
			throw e;
		} finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 字段是否存在
	 * @param key
	 * @param field
	 * @return -1为失败
	 */
	public static Boolean hexists(String key,String field)throws RuntimeException{
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hexists(key, field);
		} catch (RuntimeException e) {
			logger.info("hexists方法{},{}出错：{}",key,field,e.getMessage());
			e.printStackTrace();
			throw e;
		} finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 数字递增指定值
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long hincrBy(String key, String field, long increment)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hincrBy(key,field,increment);
		}catch(RuntimeException e){
			logger.info("incrBy方法{},{}出错:{}",key,increment,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 数字递增指定浮点值
	 * @param key
	 * @param value
	 * @return
	 */
	public static Double hincrByFloat(String key, String field, Double increment)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hincrByFloat(key,field,increment);
		}catch(RuntimeException e){
			logger.info("hincrByFloat方法{},{}出错:{}",key,increment,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得hash所有字段名
	 * @param key
	 * @param value
	 * @return
	 */
	public static Set<String> hkeys(String key) throws RuntimeException{
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hkeys(key);
		}catch(RuntimeException e){
			logger.info("hkeys方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得hash所有字段的值
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<String> hvals(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hvals(key);
		}catch(RuntimeException e){
			logger.info("hkeys方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得hash字段的个数
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long hlen(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.hlen(key);
		}catch(RuntimeException e){
			logger.info("hlen方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 从左侧放入元素
	 * @param key
	 * @param value
	 * @return 加入后队列的长度
	 */
	public static Long lpush(String key, String ... value)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.lpush(key,value);
		}catch(RuntimeException e){
			logger.info("lpush方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 从右侧放入元素
	 * @param key
	 * @param value
	 * @return 加入后队列的长度
	 */
	public static Long rpush(String key, String ... value)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.rpush(key,value);
		}catch(RuntimeException e){
			logger.info("lpush方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 从左侧弹出元素
	 * @param key
	 * @param value
	 * @return 返回元素值
	 */
	public static String lpop(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.lpop(key);
		}catch(RuntimeException e){
			logger.info("lpop方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 从右侧弹出元素
	 * @param key
	 * @param value
	 * @return 返回元素值
	 */
	public static String rpop(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.rpop(key);
		}catch(RuntimeException e){
			logger.info("rpop方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 队列长度
	 * @param key
	 * @param value
	 * @return 队列的长度
	 */
	public static Long llen(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.llen(key);
		}catch(RuntimeException e){
			logger.info("llen方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得队列片段
	 * @param key
	 * @param value
	 * @return 队列的长度
	 */
	public static List<String> lrange(String key,long start, long stop)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.lrange(key,start,stop);
		}catch(RuntimeException e){
			logger.info("lrange方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 队列删除指定值
	 * @param key
	 * @param value
	 * @return 返回删除的个数
	 */
	public static Long lrem(String key,long count, String value)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.lrem(key,count,value);
		}catch(RuntimeException e){
			logger.info("llen方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得指定索引的元素值
	 * @param key
	 * @param value
	 * @return 返回删除的个数
	 */
	public static String lindex(String key,long index)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.lindex(key,index);
		}catch(RuntimeException e){
			logger.info("lindex方法{}，{}出错:{}",key,index,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 设置指定索引的元素值
	 * @param key
	 * @param value
	 * @return 
	 */
	public static String lset(String key,long index,String value)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.lset(key,index,value);
		}catch(RuntimeException e){
			logger.info("lset方法{}，{}，{}出错:{}",key,index,value,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 向集合中加入若干成员
	 * @param key
	 * @param value
	 * @return 
	 */
	public static Long sadd(String key,String... value)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.sadd(key,value);
		}catch(RuntimeException e){
			logger.info("sadd方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 从集合中删除若干成员
	 * @param key
	 * @param value
	 * @return 
	 */
	public static Long srem(String key,String... value)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.srem(key,value);
		}catch(RuntimeException e){
			logger.info("srem方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得集合成员数量
	 * @param key
	 * @return 
	 */
	public static Long scard(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.scard(key);
		}catch(RuntimeException e){
			logger.info("scard方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得集合中所有成员
	 * @param key
	 * @param value
	 * @return 
	 */
	public static Set<String> smembers(String key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.smembers(key);
		}catch(RuntimeException e){
			logger.info("smembers方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 从集合中删除若干成员
	 * @param key
	 * @param value
	 * @return 
	 */
	public static Boolean sismember(String key,String value)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.sismember(key,value);
		}catch(RuntimeException e){
			logger.info("sismember方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得多个集合的差集
	 * @param key
	 * @return 
	 */
	public static Set<String> sdiff(String ... key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.sdiff(key);
		}catch(RuntimeException e){
			logger.info("sdiff方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得多个集合的交集
	 * @param key
	 * @return 
	 */
	public static Set<String> sinter(String ... key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.sinter(key);
		}catch(RuntimeException e){
			logger.info("sdiff方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得多个集合的并集
	 * @param key
	 * @return 
	 */
	public static Set<String> sunion(String ... key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.sunion(key);
		}catch(RuntimeException e){
			logger.info("sdiff方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	
	/**
	 * 获得多个集合的差集，并存储到dest
	 * @param key
	 * @return 
	 */
	public static Long sdiff(String dest,String ... key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.sdiffstore(dest,key);
		}catch(RuntimeException e){
			logger.info("sdiffstore方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得多个集合的交集,并存储到dest
	 * @param key
	 * @return 
	 */
	public static Long sinterstore(String dest, String ... key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.sinterstore(dest,key);
		}catch(RuntimeException e){
			logger.info("sinterstore方法{}出错:{}",dest,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 获得多个集合的并集并存储到dest
	 * @param key
	 * @return 
	 */
	public static Long sunionstore(String dest, String ... key)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.sunionstore(dest,key);
		}catch(RuntimeException e){
			logger.info("sunionstore方法{}出错:{}",dest,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 向有序集合中加入成员
	 * @param key
	 * @return 
	 */
	public static Long zadd(String key, Map<String,Double> member)throws RuntimeException {
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();
			return jc.zadd(key,member);
		}catch(RuntimeException e){
			logger.info("zadd方法{}出错:{}",key,e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	/**
	 * 批量执行自定义Jedis类方法
	 * @param action
	 * @return
	 */
	public static Object templateExcute(IJedisCallback action)throws RuntimeException{
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();			
			return action.doInJedis(jc);
		}catch(RuntimeException e){
			logger.info("templateExcute方法出错:{}",e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	public static Object templateByParamsExcute(IJedisByParamsCallback action, Object ... params)throws RuntimeException{
		if (jedisPool==null)
			return null;
		Jedis jc = null;
		try{
			jc = jedisPool.getResource();			
			return action.doInJedis(jc, params);
		}catch(RuntimeException e){
			logger.info("templateExcute方法出错:{}",e.getMessage());
			e.getStackTrace();
			throw e;
		}finally{
			if (jc!=null)
				jc.close();
		}
	}
	
	public static void main(String[] args){
		/*---------------------不带参数的方法调用例子-------------------------*/
		System.out.println("RedisUtil.templateExcute....");
		Object o = RedisUtil.templateExcute(new IJedisCallback(){
			public Object doInJedis(Jedis jc) throws RuntimeException{
				jc.set("user001", "caojun001");
				return jc.get("user001");
			}
		});
		System.out.println("RedisUtil.templateExcute no params return "+o);
		/*---------------------不带参数的方法调用例子-------------------------*/
		
		/*---------------------带参数的方法调用例子-------------------------*/
		System.out.println("RedisUtil.templateByParamsExcute....");
		String key = "user002";
		String value = "caojun002";
		Object op = RedisUtil.templateByParamsExcute(new IJedisByParamsCallback(){
			public Object doInJedis(Jedis jc, Object ... params) throws RuntimeException{
				jc.set(params[0].toString(), params[1].toString());
				return jc.get(params[0].toString());
			}
		}, key, value);
		System.out.println("RedisUtil.templateByParamsExcute have params return "+key+"="+op);
		/*---------------------带参数的方法调用例子-------------------------*/
	}
}
