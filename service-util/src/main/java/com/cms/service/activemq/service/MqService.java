package com.cms.service.activemq.service;

import javax.jms.MessageListener;

public interface MqService {
	public  void init();
	public  boolean send(String queue,String msg);
	public  boolean receive(String queue,MessageListener lis);
}
