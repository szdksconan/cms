package com.cms.service.activemq.demo;

import java.io.Serializable;

import com.cms.service.activemq.listener.AbstractMessageListener;
import com.cms.service.activemq.listener.MqHeartbeatListener;

public class Listener extends AbstractMessageListener implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public long num;
	public long time = System.currentTimeMillis();
	public String msg;
	public Listener() {
		// 调用父类构造方法，启动心跳监听
		super();
		// 添加心跳监听器
		addHeartBeatListener(new MqHeartbeatListener() {

			public void onHeartbeatStop() {
				System.out.println("stop");
			}

			public void onHeartbeatStart() {
				System.out.println("start");
			}
		});

	}

	@Override
	public void onMessage(String message) {
		++num;
		if(System.currentTimeMillis() - time >= 1000) {
			System.out.println(num+":"+message);
			setMsg(message);
			time = System.currentTimeMillis();
			num = 0;
		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
