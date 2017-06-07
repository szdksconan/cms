package com.cms.service.activemq.util;


import java.io.File;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

/** 
 * 配置文件读取 
 */
public class UtilConstants {
	/** 日志打印 */
	private static Logger logger = Logger.getLogger(UtilConstants.class);
	private static CompositeConfiguration config = new CompositeConfiguration();
	/**
	 * 默认连接地址
	 */
	private static String jmsUrl = "";
	/**
	 * 默认用户名
	 */
	private static String jmsUser = "";
	/**
	 * 超时时间 0 不超时  大于0  超时   默认超时5分钟
	 */
	private static int jmsTimeToLive = 300;
	/**
	 * mq是否序列化到磁盘，  1表示不序列化，2表示序列化
	 */
	private static int jmsDeliveryMode = 1;
	/**
	 * 异常重连间隔时间
	 */
	private static int jmsErrorConnTime = 5000;
	/**
	 * 默认密码
	 */
	private static String jmsPassword = "";
	/**
	 * 压缩协议   0x00 不压缩        0x01 gzip压缩
	 */
	private static byte compress = 0x01;
	/**
	 * 最大打包数
	 */
	private static int maxPackNum = 10000;
	/**
	 * 打包时间间隔毫秒
	 */
	private static int packTime = 10;
	/**
	 * 拆分协议串，必须是4位，不能用到正则里面的符号
	 */
	private static String splitStr = "&x7&";
	/**
	 * 是否启用mq心跳
	 */
	private static boolean isHeartbeat = false;
	static {
		try {
			String path = UtilConstants.class.getClassLoader().getResource("activemq.properties").getPath();
			File f = new File(path);
			if (f.exists()) {
				config.addConfiguration(new PropertiesConfiguration(path));
				jmsUrl = config.getString("mq.brokerURL", "failover:(tcp://127.0.0.1:61616)?initialReconnectDelay=100&timeout=3000&jms.useAsyncSend=true");
				jmsUser = config.getString("mq.user", "");
				jmsPassword = config.getString("mq.password", "");
				jmsTimeToLive = config.getInt("mq.timeToLive", 300);
				jmsDeliveryMode = config.getInt("mq.deliveryMode", 1);
				jmsErrorConnTime = config.getInt("mq.errorConnTime", 5) * 1000;
				isHeartbeat = config.getBoolean("mq.isheartbeat", false);
				compress = config.getByte("mq.compress", (byte)0x01);
				maxPackNum = config.getInt("mq.maxPackNum", 10000);
				packTime = config.getInt("mq.packTime", 10);
				splitStr = config.getString("mq.splitStr", "&x7&");
			}
			logger.info("没有对应的配置文件activemq.properties");
		} catch (Exception e) {
			logger.error("读取配置文件activemq.properties出错");
		}
	}
	public static String getJmsUrl() {
		return jmsUrl;
	}
	public static String getJmsUser() {
		return jmsUser;
	}
	public static String getJmsPassword() {
		return jmsPassword;
	}
	public static byte getCompress() {
		return compress;
	}
	public static int getJmsTimeToLive() {
		return jmsTimeToLive;
	}
	public static int getJmsDeliveryMode() {
		return jmsDeliveryMode;
	}
	public static int getJmsErrorConnTime() {
		return jmsErrorConnTime;
	}
	public static int getMaxPackNum() {
		return maxPackNum;
	}
	public static int getPackTime() {
		return packTime;
	}
	public static String getSplitStr() {
		return splitStr;
	}
	public static boolean isHeartbeat() {
		return isHeartbeat;
	}
	public static void setJmsUrl(String jmsUrl) {
		UtilConstants.jmsUrl = jmsUrl;
	}
	public static void setJmsUser(String jmsUser) {
		UtilConstants.jmsUser = jmsUser;
	}
	public static void setJmsTimeToLive(int jmsTimeToLive) {
		UtilConstants.jmsTimeToLive = jmsTimeToLive;
	}
	public static void setJmsDeliveryMode(int jmsDeliveryMode) {
		UtilConstants.jmsDeliveryMode = jmsDeliveryMode;
	}
	public static void setJmsErrorConnTime(int jmsErrorConnTime) {
		UtilConstants.jmsErrorConnTime = jmsErrorConnTime;
	}
	public static void setJmsPassword(String jmsPassword) {
		UtilConstants.jmsPassword = jmsPassword;
	}
	public static void setCompress(byte compress) {
		UtilConstants.compress = compress;
	}
	public static void setMaxPackNum(int maxPackNum) {
		UtilConstants.maxPackNum = maxPackNum;
	}
	public static void setPackTime(int packTime) {
		UtilConstants.packTime = packTime;
	}
	public static void setSplitStr(String splitStr) {
		UtilConstants.splitStr = splitStr;
	}
	public static void setHeartbeat(boolean isHeartbeat) {
		UtilConstants.isHeartbeat = isHeartbeat;
	}
	
	
}
