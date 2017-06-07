package com.cms.service.activemq.demo;

import java.util.List;

import com.cms.service.activemq.connection.ConnectionPool;
import com.cms.service.activemq.connection.SessionPool;


/**
 * 接收层，必须要有其他非demo线程，否则会随着主线程退出
 * 
 */
public class Recive {
	/**
	 * 封装后的单机接收
	 */
	public static void init() {
		String url = "failover:(tcp://192.168.2.213:61616)?initialReconnectDelay=100&timeout=3000&jms.useAsyncSend=true";
		// 接收消息
		Listener lis = new Listener();
		//接收mq中的消息
		SessionPool pool = ConnectionPool.getJMSSessionPool(url,"", "");
		pool.receive("adsbbgsdown", true, lis);
	}

	/**
	 * 集群数据接收
	 */
	public static void initCluster() {
		// 创建session池
		Listener lis = new Listener();
		//接收mq中的消息
		List<SessionPool> poolList = ConnectionPool.getJMSSessionPoolForRecive("192.168.2.213", 
				"192.168.2.213", 61616, "", "", "myPool");
		for (SessionPool jmsSessionPool : poolList) {
			jmsSessionPool.receive("adsbbgsdown", false, lis);
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
//		for (JMSSessionPool jmsSessionPool : poolList) {
//			jmsSessionPool.closeSession("test");
//		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		init();
	}

}
