package com.cms.service.activemq.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.jms.Connection;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import com.cms.service.activemq.util.UtilCommon;
import com.cms.service.activemq.util.UtilConstants;
import com.cms.service.activemq.util.UtilMq;


/**
 * 连接池类，缓存与mq的Connection连接
 * 与缓存session集合的比较紧密
 *
 *
 */
public class ConnectionPool {
	/** 日志打印 */
	private static Logger log = Logger.getLogger(ConnectionPool.class);
	/**
	 * 连接map
	 */
	private static Map<String, Connection> connection = new ConcurrentHashMap<String, Connection>();

	/**
	 * connection下的session池
	 */
	private static Map<String, SessionPool> sessionPools = new ConcurrentHashMap<String, SessionPool>();
	
	/**
	 * 获取创建完成的session连接池
	 * @param url
	 * @return
	 */
	public static SessionPool getJMSSessionPool(String url) {
		return sessionPools.get(url);
	}
	/**
	 * 获取session连接池
	 * 如果connection不存在的话默认会自动创建
	 * @param url failover:(tcp://127.0.0.1:61616)?initialReconnectDelay=100&timeout=3000&jms.useAsyncSend=true
	 * @param user ""
	 * @param password ""
	 * @param factoryPool false
	 * @return
	 */
	public static SessionPool getJMSSessionPool(String url, String user, String password) {
		SessionPool wraPool = sessionPools.get(url);
		if(wraPool == null) {
			wraPool = new SessionPool(url, user, password);
			sessionPools.put(url, wraPool);
		}
		return wraPool;
	}
	
	/**
	 * 配置中的ip和端口  获取session连接
	 * @param ip 127.0.0.1
	 * @param ip1 127.0.0.2
	 * @param port 61616
	 * @param user ""
	 * @param password ""
	 * @param pool 集群信息，如果是mypool  表示用mq集群，否则mq单机
	 * @return
	 */
	public static SessionPool getJMSSessionPool(String ip, String ip1, int port, String user, String password,
			String pool) {
		String url = "";
		if(UtilCommon.isEmpty(pool)) {
			url = UtilMq.getUrl(ip, String.valueOf(port));
		} else {
			url = UtilMq.getUrl(ip, String.valueOf(port), ip1, String.valueOf(port));
		}
		return getJMSSessionPool(url, user, password);
	}
	
	/**
	 * 获取接收的 session列表
	 * 配置中的ip和端口  获取session连接
	 * @param ip 127.0.0.1
	 * @param ip1 127.0.0.2
	 * @param port 61616
	 * @param user ""
	 * @param password ""
	 * @param pool 集群信息，如果是mypool  表示用mq集群，否则mq单机
	 * @return
	 */
	public static List<SessionPool> getJMSSessionPoolForRecive(String ip, String ip1, int port, String user, String password,
			String pool) {
		List<SessionPool> sessionPoolList = new ArrayList<SessionPool>();
		if(UtilCommon.isEmpty(pool)) {
			String url = UtilMq.getUrl(ip, String.valueOf(port));
			sessionPoolList.add(getJMSSessionPool(url, user, password));
		} else {
			String url1 = UtilMq.getUrl(ip, String.valueOf(port));
			String url2 = UtilMq.getUrl(ip1, String.valueOf(port));
			sessionPoolList.add(getJMSSessionPool(url1, user, password));
			sessionPoolList.add(getJMSSessionPool(url2, user, password));
		}
		return sessionPoolList;
	}
	
	/**
	 * 获取连接对象
	 * 
	 */
	public static Connection getConnection() {
		return getConnection(UtilConstants.getJmsUrl(),
				UtilConstants.getJmsUser(), UtilConstants.getJmsPassword());
	}

	/**
	 * 获取连接对象
	 * 
	 */
	public static Connection getConnection(String connAddr, String user, String password) {
		Connection reConn = null;

		if (connection.containsKey(connAddr)) {
			reConn = connection.get(connAddr);
		} else {
			createConnFactory(connAddr, user, password);
			reConn = connection.get(connAddr);
		}

		return reConn;
	}
	
	/**
	 * 关闭所有连接
	 */
	public static void closeConnection() {
		for (String key : connection.keySet()) {
			closeConnection(key);
		}

		connection.clear();
		sessionPools.clear();
	}
	
	/**
	 * 关闭某个连接
	 * @param url
	 */
	public static void closeConnection(String url) {
		//先关闭session
		SessionPool wraPool = sessionPools.remove(url);
		if(wraPool != null) {
			wraPool.closeSession();
		}
		//关闭Connection
		Connection reConn = connection.remove(url);
		if (reConn != null) {
			try {
				reConn.close();
			} catch (JMSException e) {
				log.error("关闭JMS连接出错" + url, e);
			}
		}
	}
	
	/**
	 * 创建普通连接
	 * @param url
	 * @param user
	 * @param password
	 */
	private static void createConnFactory(String url, String user, String password ) {
		Connection conn = null;

		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					url);
			conn = connectionFactory.createConnection(user, password);
			conn.start();
			connection.put(url, conn);
		} catch (Exception ex) {
			if(conn != null) {
				try {
					conn.stop();
				} catch (JMSException e) {
					log.error("连接关闭失败" + url, e);
				}
			}
			log.error("连接创建失败" + url, ex);
		}
	}
}

