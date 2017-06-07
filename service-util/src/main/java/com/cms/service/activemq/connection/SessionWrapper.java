package com.cms.service.activemq.connection;

import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.log4j.Logger;

import com.cms.service.activemq.listener.AbstractMessageListener;
import com.cms.service.activemq.util.UtilCommon;
import com.cms.service.activemq.util.UtilConstants;
import com.cms.service.activemq.util.UtilGzip;

/**
 * session包装
 * 禁止某个队列又是监听者，又是消费者
 *
 */
public class SessionWrapper {
	private static Logger log = Logger.getLogger(SessionWrapper.class);

	/**
	 * 连接
	 */
	private Session session;
	/**
	 * 是否是队列
	 */
	private boolean isQueue;
	/**
	 * 传输
	 */
	private Destination dest;
	/**
	 * 消费者
	 */
	private MessageConsumer consumer;
	/**
	 * 生产者
	 */
	private MessageProducer producer;
	/**
	 * 发送心跳时间     10秒发送一次心跳信息    客户端三次没有收到心跳表示链接假死
	 */
	private long heartbeat = System.currentTimeMillis();
	/**
	 * 最近一次异常时间
	 */
	private long lastErrorTime = 0L;
	/**
	 * 已经启动
	 */
	private boolean started = false;
    /**
     * 本队列是否是使用协议发送
     */
    private boolean useSendPack = true;
    /**
     * 打包发送线程
     */
    private Thread packSendThread = null;
    /**
     * 打包线程是否需要停止
     */
    private boolean packSendThreadStop = false;
    /**
     * 协议发送队列
     */
    ConcurrentLinkedQueue<String> sendQueue = new ConcurrentLinkedQueue<String>();
	/**
	 * mq异常后，协议消息存放队列
	 */
	Queue<byte[]> errorQueue = new LinkedBlockingQueue<byte[]>(1000);
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public boolean isQueue() {
		return isQueue;
	}
	public void setQueue(boolean isQueue) {
		this.isQueue = isQueue;
	}
	public Destination getDest() {
		return dest;
	}
	public void setDest(Destination dest) {
		this.dest = dest;
	}
	public MessageConsumer getConsumer() {
		return consumer;
	}
	public void setConsumer(MessageConsumer consumer) {
		this.consumer = consumer;
	}
	public MessageProducer getProducer() {
		return producer;
	}
	public void setProducer(MessageProducer producer) {
		this.producer = producer;
	}
	/**
	 * 启动发送
	 */
	public synchronized void start(boolean usePack) {
		//如果启动时没有第一次以打包方式发送，判断线程是否启动，如果没有启动则启动线程
		if(usePack && !useSendPack) {
			if(packSendThread != null && !packSendThread.isAlive()) {
				packSendThread.start();
			}
		}
		if(started) {
			return;
		}
		useSendPack = usePack;
		//每次创建连接这个线程都new成功只是不启动。
		if(packSendThread == null) {
			packSendThreadStop = false;
			final StringBuffer sb = new StringBuffer();
			packSendThread = new Thread(new Runnable() {
				public void run() {
					//循环执行方法，线程停止变量控制线程停止
					while(!packSendThreadStop) {
						//定时执行mq数据推送
				    	//int（个数）int(body长度) byte4（协议）strn（body）{str4（分割符）strn（正文）str4（分割符）}
				        try {
				        	//发送端心跳操作
				        	if(UtilConstants.isHeartbeat()) {
				        		//长时间没有通信，发送一次心跳
				        		if(System.currentTimeMillis() - heartbeat > 10000) {
				        			try {
										producer.send(session.createTextMessage("heartbeat"));
										heartbeat = System.currentTimeMillis();
									} catch (Exception e) {
										log.error("MQ发送心跳异常：" + dest.toString());
									}
				        		}
				        	}
				        	if (System.currentTimeMillis() - lastErrorTime > UtilConstants.getJmsErrorConnTime()) {
					        	String msg = null;
					        	int j;
					        	for (j = 0; j <= UtilConstants.getMaxPackNum(); j++) {
					        		msg = sendQueue.poll();
					        		if (msg != null) {
					        			sb.append(UtilConstants.getSplitStr());
					        			sb.append(msg);
					        		} else {
					        			//队列取空
					        			break;
					        		}
					        	}
					        	msg = sb.toString();
					        	sb.setLength(0);
					        	//没有数据不进行传输
					        	if(UtilCommon.isEmpty(msg)) {
					        		try {
										Thread.sleep(UtilConstants.getPackTime());
									} catch (InterruptedException e) {
										log.error("打包睡眠失败", e);
									}
					        		continue;
					        	}
					        	byte[] byteMsgs = null;
					        	//采用加密处理
					            byte b1 = 0x00,b2,b3 = 0x00,b4 = 0x00;
					            //序列化
					            byteMsgs = UtilCommon.objToBytes(msg);
					            //压缩
					            b2 = UtilConstants.getCompress();
					            switch(b2) {
					    	        case 0x01://gzip压缩
					    	        	byteMsgs = UtilGzip.compress(byteMsgs);
					    	        	break;
					    	        default ://无压缩
					    	    }
					            //协议封装
					            ByteBuffer bf = ByteBuffer.allocate(byteMsgs.length + 100);
					            bf.putInt(j);
					            bf.putInt(byteMsgs.length);
					            bf.put(b1);
					            bf.put(b2);
					            bf.put(b3);
					            bf.put(b4);
					            bf.put(byteMsgs);
					            
					            //判断异常队列大小，如果为0正常运行，如果大于20000存放文件，  大于0小于20000尝试发送异常队列中的消息
					            int errorsize = errorQueue.size();
					            if(errorsize == 0) {//正常流转
					            	 try {
										BytesMessage bm = session.createBytesMessage();
										bm.writeBytes(bf.array());
										producer.send(bm);
										heartbeat = System.currentTimeMillis();
									} catch (Exception e) {
										log.error("MQ" + dest.toString() +  "发送错误消息", e);
										lastErrorTime = System.currentTimeMillis();
										//记录异常queue
										errorQueue.add(bf.array());
									}
					            } else {//mq异常流转
					            	//记录异常queue
									errorQueue.add(bf.array());
					            	if(errorsize > 0 && errorsize < 100) {
						            	//发送测试心跳
						            	try {
											producer.send(session.createTextMessage("heartbeat"));
											heartbeat = System.currentTimeMillis();
											
											//测试成功后就可以正常转发部分异常数据
											for (int i = 0; i < 10; i++) {
												try {
													BytesMessage bm = session.createBytesMessage();
													byte[] by = errorQueue.poll(); 
													if(by != null) {
														bm.writeBytes(by);
														producer.send(bm);
														heartbeat = System.currentTimeMillis();
													} else {
														break;
													}
												} catch (Exception e) {
													log.error("MQ" + dest.toString() +  "发送错误消息", e);
													lastErrorTime = System.currentTimeMillis();
												}
											}
										} catch (Exception e) {
											log.error("MQ发送心跳异常：" + dest.toString());
										}
						            } else if(errorsize >= 100) {
						            	//按时 队列地址 间戳写文件     索引文件    异常队列文件
						            	
						            	//清空队列
						            	
						            	//设置有文件标识
						            	
						            	//如果文件读写存在异常，直接清空   (目前考虑复杂度，先直接清空)
						            	errorQueue.clear();
						            	log.warn("异常队列满，清空数据" + dest.toString());
						            } 
					            } 
				            } else {
				    			log.error("MQ异常期取消发送：" + dest.toString());
				    		}
						} catch (Exception e) {
							log.error("协议推送失败", e);
						}
						
						try {
							Thread.sleep(UtilConstants.getPackTime());
						} catch (InterruptedException e) {
							log.error("打包睡眠失败", e);
						}
					}
					log.warn("打包打包发送循环退出");
				}
			});
			//使用打包发送，或者使用心跳信息，启动线程
			if(useSendPack || UtilConstants.isHeartbeat()) {
				packSendThread.start();
			}
		}
		started = true;
	}
	
	/**
	 * 关闭session
	 */
	public void close() {
		try {
			//停止打包线程
			if(packSendThread != null) {
				packSendThreadStop = true;
				packSendThread = null;
			}
			if(this.consumer != null) {
				try {
					//把消费者心跳侦听关闭
					MessageListener lis = this.consumer.getMessageListener();
					if(lis != null && lis instanceof AbstractMessageListener) {
						((AbstractMessageListener)lis).stopHeartbeat();
					}
					this.consumer.close();
				} catch (Exception e) {
					log.error("consumer关闭失败", e);
				}
			}
			if(this.producer != null) {
				try {
					this.producer.close();
				} catch (Exception e) {
					log.error("producer关闭失败", e);
				}
			}
			if(this.session != null) {
				try {
					this.session.close();
				} catch (Exception e) {
					log.error("session关闭失败", e);
				}
			}
		} catch (Exception e) {
			log.error("session关闭失败", e);
		}
		started = false;
		log.info("session关闭成功");
	}
	
	/**
	 * 普通发送报文
	 * @param msg
	 */
	public boolean send (String msg) {
		if (System.currentTimeMillis() - lastErrorTime > UtilConstants.getJmsErrorConnTime()) {
			try {
				start(false);
				this.producer.send(this.session.createTextMessage(msg));
				this.heartbeat = System.currentTimeMillis();
				return true;
			} catch (Exception e) {
				log.error("MQ" + dest.toString() +  "发送错误消息", e);
		        lastErrorTime = System.currentTimeMillis();
		        //防止消息丢失,发送到协议队列   目前mq异常不需要处理
//		        sendQueue.add(msg);
			}
		} else {
			log.error("MQ异常期取消发送：" + dest.toString() + " ->" + msg);
		}
		return false;
	}
	
	/**
	 * 发送二进制
	 * @param bytes 二进制
	 * @return
	 */
	public boolean send(BytesMessage bytes) {
		if (System.currentTimeMillis() - lastErrorTime > UtilConstants.getJmsErrorConnTime()) {
			try {
				start(false);
				this.producer.send(bytes);
				this.heartbeat = System.currentTimeMillis();
				return true;
			} catch (Exception e) {
				log.error("MQ" + dest.toString() +  "发送错误消息", e);
		        lastErrorTime = System.currentTimeMillis();
		        //防止消息丢失,发送到协议队列   目前mq异常不需要处理
//		        sendQueue.add(msg);
			}
		} else {
			log.error("MQ异常期取消发送：" + dest.toString() + " ->" + bytes);
		}
		return false;
	}
	/**
	 * 协议推送
	 * @param msg
	 */
	public boolean sendPact(String msg) {
		try {
			sendQueue.add(msg);
			return true;
		} catch (Exception e) {
			log.error("协议发送失败", e);
		}
		return false;
	}
	
	/**
	 * 添加监听器
	 * @param lis
	 * @return
	 */
	public boolean addLis(MessageListener lis) {
		try {
			this.consumer.setMessageListener(lis);
			return true;
		} catch (Exception e) {
			log.error("监听器添加失败", e);
			return false;
		}
	}
}
