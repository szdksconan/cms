package com.cms.service.activemq.connection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.log4j.Logger;

import com.cms.service.activemq.util.UtilConstants;
import com.cms.service.activemq.util.UtilMq;

/**
 * session包装池
 * 这个session池管理着他的connection连接，当关闭session池的时候会关闭connection连接
 * （一个url 只能创建一个session池）
 *
 */
public class SessionPool {
	private static Logger log = Logger.getLogger(ConnectionPool.class);
	private String url;
	private String user;
	private String password;
	private Connection connection;
	private long lastErrorLinkTime = 0L;
	private Map<String, SessionWrapper> sessions = new ConcurrentHashMap<String, SessionWrapper>();
	/**
	 * 根据信息创建mq session连接池
	 * @param url 地址
	 * @param user 用户名
	 * @param password 密码
	 * @param factoryPool 是否是连接工厂
	 */
	protected SessionPool(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.connection = ConnectionPool.getConnection(url, user, password);
	}
	
	/**
	 * 关闭session
	 * @param destination
	 */
	public void closeSession(String destination) {
		SessionWrapper wra = sessions.remove(destination);
		if(wra != null) {
			wra.close();
		}
	}
	/**
	 * 关闭所有session
	 */
	public void closeSession() {
		for (String key : sessions.keySet()) {
			closeSession(key);
		}
		sessions.clear();
	}
	/**
	 * 发送报文
	 * @param destination 地址
	 * @param msg  信息
	 * @param isQueue 是否是队列
	 * @return 是否发送成功
	 */
	public boolean send(String destination, String msg, boolean isQueue) {
		return send(destination, msg, isQueue, UtilConstants.getJmsTimeToLive(),
				UtilConstants.getJmsDeliveryMode());
		
	}
	/**
	 * 发送报文
	 * @param destination 地址
	 * @param msg 消息
	 * @param isQueue 是否是队列
	 * @param timeToLive 超时时间
	 * @param deliveryMode 保存模式
	 * @return
	 */
	public boolean send(String destination, String msg, boolean isQueue, int timeToLive, int deliveryMode) {
		SessionWrapper session = getSessionWrapper(destination, true, false, isQueue, timeToLive, deliveryMode);
		if(session != null) {
			return session.send(msg);
		} else {
			return false;
		}
	}
	
	/**
	 * 发送二进制报文
	 * @param destination 地址
	 * @param bytes  信息
	 * @param isQueue 是否是队列
	 * @return 是否发送成功
	 */
	public boolean send(String destination, BytesMessage bytes, boolean isQueue) {
		return send(destination, bytes, isQueue, UtilConstants.getJmsTimeToLive(),
				UtilConstants.getJmsDeliveryMode());
		
	}
	/**
	 * 发送二进制报文
	 * @param destination 地址
	 * @param bytes 消息
	 * @param isQueue 是否是队列
	 * @param timeToLive 超时时间
	 * @param deliveryMode 保存模式
	 * @return
	 */
	public boolean send(String destination, BytesMessage bytes, boolean isQueue, int timeToLive, int deliveryMode) {
		SessionWrapper session = getSessionWrapper(destination, true, false, isQueue, timeToLive, deliveryMode);
		if(session != null) {
			return session.send(bytes);
		} else {
			return false;
		}
	}
	
	/**
	 * 注册监听器
	 * @param destinationName 目标路径 /queue/netsnatchadsbup   |  /topic/netsnatchadsbup
	 * @param lis
	 * @return
	 */
	public boolean receive(final String destinationName, final MessageListener lis) {
		String[] name = UtilMq.splitDestinationName(destinationName);
		return receive(name[1], Boolean.valueOf(name[0]), lis);
	}
	
	
	
	/**
	 * 添加监听器
	 * 一个队列最好只添加一个监听器
	 * 对这个队列添加了监听器就不要往队列里面发送消息
	 * @param destination  目标地址
	 * @param isQueue 是否是队列
	 * @param lis 监听器
	 * @return 是否监听成功
	 */
	public boolean receive(final String destination, final boolean isQueue, final MessageListener lis) {
		SessionWrapper session = getSessionWrapper(destination, false, true, isQueue);
		if(session != null) {
			return session.addLis(lis);
		} else {
			//开启线程自动重新注册事件
			log.warn("开启自动重新注册线程" + this.url);
			new Thread(new Runnable() {
				public void run() {
					boolean flag = true;
					while (flag) {
						try {
							SessionWrapper session = getSessionWrapper(destination, false, true, isQueue);
							if(session != null) {
								session.addLis(lis);
								flag = false;
							}
							Thread.sleep(5000);
						} catch (Exception e) {
							log.error("重连失败" + url);
						}
					}
				}
			}).start();
			return false;
		}
	}
	
	/**
	 * 获取session连接
	 * @param destination
	 * @param createProducer
	 * @param createConsumer
	 * @param isQueue
	 * @return
	 */
	public SessionWrapper getSessionWrapper(String destination, boolean createProducer, boolean createConsumer,
			boolean isQueue) {
		return getSessionWrapper(destination, createProducer, createConsumer, isQueue, UtilConstants.getJmsTimeToLive(),
				UtilConstants.getJmsDeliveryMode());
	}
	/**
	 * 获取池中session
	 * @param destination
	 * @param createProducer
	 * @param createConsumer
	 * @param isQueue
	 * @param timeToLive
	 * @param deliveryMode
	 * @return
	 */
	public SessionWrapper getSessionWrapper(String destination, boolean createProducer, boolean createConsumer,
			boolean isQueue, int timeToLive, int deliveryMode) {
		SessionWrapper wra = null;
		try {
			wra = sessions.get(destination);
			//连接工厂创建失败,重连
			if(connection == null) {
				if(System.currentTimeMillis() - lastErrorLinkTime > UtilConstants.getJmsErrorConnTime()) {
					this.connection = ConnectionPool.getConnection(url, user, password);
					lastErrorLinkTime = System.currentTimeMillis();
					log.warn("重连" + url);
				}
			}
			if(connection == null) {
				log.error("mq连接获取失败" + url);
				return null;
			}
			if(wra == null) {
				wra = new SessionWrapper();
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				wra.setSession(session);
				Destination dest = null;
				if(isQueue) {
					dest = session.createQueue(destination);
				} else {
					dest = session.createTopic(destination);
				}
				wra.setQueue(isQueue);
				wra.setDest(dest);
				if(createProducer) {
					MessageProducer producer = session.createProducer(dest);
					//设置消息超时时间
					if(timeToLive > 0) {
						producer.setTimeToLive(timeToLive * 1000);
					}
					//设置持久化
					producer.setDeliveryMode(deliveryMode);
					wra.setProducer(producer);
				}
				if(createConsumer) {
					MessageConsumer consumer = session.createConsumer(dest);
					wra.setConsumer(consumer);
				}
				sessions.put(destination, wra);
			} else {
				if(wra.getSession() == null) {
					Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
					wra.setSession(session);
				}
				if(wra.getDest() == null) {
					Destination dest = null;
					if(isQueue) {
						dest = wra.getSession().createQueue(destination);
					} else {
						dest = wra.getSession().createTopic(destination);
					}
					wra.setDest(dest);
					wra.setQueue(isQueue);
				}
				if(wra.getProducer() == null && createProducer) {
					MessageProducer producer = wra.getSession().createProducer(wra.getDest());
					//设置消息超时时间
					if(timeToLive > 0) {
						producer.setTimeToLive(timeToLive * 1000);
					}
					//设置持久化
					producer.setDeliveryMode(deliveryMode);
					wra.setProducer(producer);
				}
				if(wra.getConsumer() == null && createConsumer) {
					MessageConsumer consumer = wra.getSession().createConsumer(wra.getDest());
					wra.setConsumer(consumer);
				}
			}
		} catch (Exception e) {
			log.error("JMSSessionWrapper获取失败" + destination);
		}
		return wra;
	}
}
