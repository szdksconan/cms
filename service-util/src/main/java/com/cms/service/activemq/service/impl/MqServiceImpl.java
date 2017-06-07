package com.cms.service.activemq.service.impl;

import javax.jms.MessageListener;

import com.cms.service.activemq.connection.ConnectionPool;
import com.cms.service.activemq.connection.SessionPool;
import com.cms.service.activemq.service.MqService;
import com.cms.service.activemq.util.UtilConstants;

public class MqServiceImpl implements MqService{ 
	public SessionPool pool;
	 
	public void init(){
		String url = UtilConstants.getJmsUrl();
		//创建session池
		 pool = ConnectionPool.getJMSSessionPool(url,
				 UtilConstants.getJmsUser(), UtilConstants.getJmsPassword()); 
	}
	/**
	 * 普通发送消息服务
	 * queue 队列名称
	 * msg 消息内容
	 */ 
	public boolean send(String queue,String msg) {
		 boolean ok = false;
		 init();
		//获取session 发送消息
		ok = pool.send(queue, msg, true);
		return ok;
	}
	
	/**
	 * 封装后的接收层
	 * queue 队列名称
	 */
	public boolean receive(String queue,MessageListener lis) { 
		boolean ok = false;
		init();
		ok = pool.receive(queue, true, lis);
		return ok;
	}
}
