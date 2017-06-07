package com.cms.service.activemq.demo;


import com.cms.service.activemq.connection.ConnectionPool;
import com.cms.service.activemq.connection.SessionPool;

/**
 * 接收层，必须要有其他非demo线程，否则会随着主线程退出
 *
 */
public class SimpleRecive {
	/**
	 * 封装后的接收层
	 */
	public static void init() {
		String url = "failover:(tcp://192.168.2.213:61616)?initialReconnectDelay=100&timeout=3000&jms.useAsyncSend=true";
		//创建监听器
		SimpleListener lis = new SimpleListener();
		//接收mq中的消息
		SessionPool pool = ConnectionPool.getJMSSessionPool(url,
				"", "");
		pool.receive("test", true, lis);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		init();
	}

}
