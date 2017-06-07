package com.cms.service.activemq.util;

public class UtilMq {
	/**
	 * 获取集群url
	 * @param ip
	 * @param port
	 * @param ip1
	 * @param port1
	 * @return
	 */
	public static String getUrl(String ip, String port, String ip1, String port1 ) {
		StringBuffer sb = new StringBuffer();
		sb.append("failover:(tcp://").append(ip).append(":").
			append(port).append(",tcp://").append(ip1).append(":").
			append(port1).append(")?initialReconnectDelay=100&randomize=false&jms.useAsyncSend=true");
		return sb.toString();
	}
	
	/**
	 * 获取单机url
	 * @param ip
	 * @param port
	 * @return
	 */
	public static String getUrl(String ip, String port) {
		StringBuffer sb = new StringBuffer();
		sb.append("failover:(tcp://").append(ip).append(":").
			append(port).append(")?initialReconnectDelay=100&timeout=3000&jms.useAsyncSend=true");
		return sb.toString();
	}
	
	/**
	 * 拆分mq目标路径
	 * @param destinationName   /queue/aftnsnd  |  /topic/aftnsnd
	 * @return
	 */
	public static String[] splitDestinationName(String destinationName) {
		String[] result = new String[2];
		String[] split = destinationName.trim().split("/");
		boolean isQueue = true;
		String destination = "errorName";
		try {
			isQueue = "queue".equals(split[1]);
			destination = split[2];
		} catch (Exception e) {
		}
		result[0] = String.valueOf(isQueue);
		result[1] = destination;
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] ss = splitDestinationName("/queue/aftnsnd");
		System.out.println(ss);
	}

}
