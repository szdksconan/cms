package com.cms.service.activemq.demo;


import com.cms.service.activemq.connection.ConnectionPool;
import com.cms.service.activemq.connection.SessionPool;

public class SimpleSend {
	/**
	 * 普通连接
	 */
	public static void init() {
		String url = "failover:(tcp://192.168.2.213:61616)?initialReconnectDelay=100&timeout=3000&jms.useAsyncSend=true";
		//创建session池
		SessionPool pool = ConnectionPool.getJMSSessionPool(url,
				"", url);
		//获取session 发送消息
		while(true) {
			System.out.println("传统消息：" + pool.send("test", "发送一条消息", true));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		init();
	}

}
