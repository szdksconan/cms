package com.cms.service.activemq.bean;

import java.util.ArrayList;
import java.util.List;

import javax.jms.BytesMessage;

import com.cms.service.activemq.connection.ConnectionPool;
import com.cms.service.activemq.connection.SessionPool;
import com.cms.service.activemq.connection.SessionWrapper;
import com.cms.service.activemq.listener.AbstractMessageListener;
import com.cms.service.activemq.util.UtilMq;



public class BeanMq {
	//初始化参数
	private String ip;//ip地址
	private int port;//端口号
	private String userName = "";//用户名
	private String password = "";//密码
	private String ip1;//ip1地址
	private String pool;//集群连接方式
	private String queue;//队列信息
	//解析参数
	private String queueName = "";//队列名称
	private boolean isQueue = true;//是否是队列
	private List<SessionPool> sessionPoolList = new ArrayList<SessionPool>();//连接池
	private SessionWrapper session = null;//连接

	public BeanMq() {
		super();
	}
	
	public BeanMq(String ip, int port, String userName, String password,
			String ip1, String pool, String queue) {
		super();
		this.ip = ip;
		this.port = port;
		this.userName = userName;
		this.password = password;
		this.ip1 = ip1;
		this.pool = pool;
		this.queue = queue;
	}



	/**
	 * 解析队列名称
	 */
	private void passQueueName() {
		String[] array = UtilMq.splitDestinationName(queue);
		isQueue = Boolean.parseBoolean(array[0]);
		queueName = array[1];
	}

	/**
	 * 发送普通字符串消息
	 * 
	 * @param msg
	 *            文本消息
	 */
	public void send(String msg) throws Exception {
		if (sessionPoolList.size() == 0) {
			passQueueName();
			SessionPool sessionPool = ConnectionPool.getJMSSessionPool(
					ip, ip1, port, userName, password, pool);
			if (sessionPool != null) {
				sessionPoolList.add(sessionPool);
			}
		}
		if (sessionPoolList.size() != 0) {
			sessionPoolList.get(0).send(queueName, msg, isQueue);
		}
	}

	/**
	 * 发送二进制消息
	 * 
	 * @param bytes
	 *            二进制消息
	 */
	public void send(BytesMessage bytes) throws Exception {
		if (sessionPoolList.size() == 0) {
			passQueueName();
			SessionPool sessionPool = ConnectionPool.getJMSSessionPool(
					ip, ip1, port, userName, password, pool);
			if (sessionPool != null) {
				sessionPoolList.add(sessionPool);
			}
		}
		if (sessionPoolList.size() != 0) {
			sessionPoolList.get(0).send(queueName, bytes, isQueue);
		}
	}
	/**
	 * 打包成二进制发送
	 * @param msg
	 */
	public void sendPack(String msg) throws Exception {
		if (sessionPoolList.size() == 0) {
			passQueueName();
			SessionPool sessionPool = ConnectionPool.getJMSSessionPool(
					ip, ip1, port, userName, password, pool);
			if (sessionPool != null) {
				sessionPoolList.add(sessionPool);
			}
		}
		if (session == null) {
			session = sessionPoolList.get(0).getSessionWrapper(queueName,
					true, false, isQueue);
			session.start(true);
		}
		if (session != null) {
			session.sendPact(msg);
		}
	}

	/**
	 * 接收消息
	 * @param lis 监听器
	 */
	public void rcv(AbstractMessageListener lis) throws Exception {
		passQueueName();
		sessionPoolList = ConnectionPool.getJMSSessionPoolForRecive(ip, ip1,
				port, userName, password, pool);
		if (sessionPoolList.size() > 1) {
			sessionPoolList.get(1).receive(queueName, isQueue, lis);
		}
		if (sessionPoolList.size() > 0) {
			sessionPoolList.get(0).receive(queueName, isQueue, lis);
		}
	}

	/**
	 * 关闭接收session
	 */
	public void closeRcvSession() throws Exception {
		if(session != null) {
			session.close();
			session = null;
		}
		if (sessionPoolList.size() > 1) {
			sessionPoolList.get(1).closeSession(queueName);
		}
		if (sessionPoolList.size() > 0) {
			sessionPoolList.get(0).closeSession(queueName);
		}
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp1() {
		return ip1;
	}

	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public boolean isQueue() {
		return isQueue;
	}

	public void setQueue(boolean isQueue) {
		this.isQueue = isQueue;
	}

	public List<SessionPool> getSessionPoolList() {
		return sessionPoolList;
	}

	public void setSessionPoolList(List<SessionPool> sessionPoolList) {
		this.sessionPoolList = sessionPoolList;
	}

	public SessionWrapper getSession() {
		return session;
	}

	public void setSession(SessionWrapper session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "MqBean [ip=" + ip + ", port=" + port + ", userName=" + userName
				+ ", password=" + password + ", ip1=" + ip1 + ", pool=" + pool
				+ ", queue=" + queue + ", queueName=" + queueName
				+ ", isQueue=" + isQueue + ", sessionPoolList="
				+ sessionPoolList + ", session=" + session + "]";
	}
	
}
