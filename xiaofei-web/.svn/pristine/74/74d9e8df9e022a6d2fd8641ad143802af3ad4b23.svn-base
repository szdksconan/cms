package com.cms.controller.xiaofei;


import java.io.UnsupportedEncodingException;

import javax.jms.Message;

import com.cms.model.User;
import com.cms.service.activemq.listener.AbstractMessageListener;
import com.cms.service.common.redis.SerializeUtil;

public  class MQreceive extends AbstractMessageListener {
	
	public MQreceive() {
		//调用父类构造方法，启动心跳监听
		super();
	}

	@Override
	public void onMessage(String message) {
//System.out.println("get:"+message);
        //具体的业务在这里面进行处理
		try {
			User user = new User();
			user= (User) SerializeUtil.convertBytes2Obj(message.getBytes("ISO8859-1"));
			System.out.println("this is MESSAGE:"+user.getLoginName().toString());

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}