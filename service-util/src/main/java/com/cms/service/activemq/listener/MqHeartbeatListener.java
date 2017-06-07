package com.cms.service.activemq.listener;
/**
 * mq心跳侦听器
 *
 */
public interface MqHeartbeatListener {
	/**
	 * 收到心跳或任意数据，这里不要做复杂操作，否则会阻断接收线程
	 */
	public void onHeartbeatStart();
	/**
	 * 心跳判定停止，30秒内没有收到任何数据
	 */
	public void onHeartbeatStop();
}
