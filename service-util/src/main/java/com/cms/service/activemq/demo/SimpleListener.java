package com.cms.service.activemq.demo;

import com.cms.service.activemq.listener.AbstractMessageListener;

public class SimpleListener extends AbstractMessageListener {
	
	public SimpleListener() {
		//调用父类构造方法，启动心跳监听
		super();
	}

	@Override
	public void onMessage(String message) {
		System.out.println(message);
		
	}
	
}
