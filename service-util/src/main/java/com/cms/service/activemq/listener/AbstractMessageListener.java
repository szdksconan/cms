package com.cms.service.activemq.listener;

import java.util.ArrayList;
import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cms.service.activemq.util.UtilCommon;
import com.cms.service.activemq.util.UtilGzip;

/**
 * 默认监听器，需要被使用者集成
 * 传输只能是字符串
 *
 */
public abstract class AbstractMessageListener implements MessageListener {
    private final static Logger log = LoggerFactory.getLogger(AbstractMessageListener.class);
    /**
     * 本连接心跳监听器集合
     */
    private List<MqHeartbeatListener> heartbeatLis = new ArrayList<MqHeartbeatListener>();
    /**
     * 心跳时间
     */
    private long heartbeat = System.currentTimeMillis();
    /**
     * 连接状态
     */
    private boolean connStatus = false;
    /**
     * 心跳启动标识
     */
    private boolean heartbeatFlag = true;
    
    public AbstractMessageListener() {
    	startHeartbeat();
    }
    /**
     * 启动心跳侦听
     */
    public void startHeartbeat() {
    	heartbeatFlag = true;
    	//一个demon线程监听心跳超时状况
    	Thread t = new Thread(new Runnable() {
			public void run() {
				while (heartbeatFlag) {
					if(connStatus && System.currentTimeMillis() - heartbeat > 30000) {
						for (MqHeartbeatListener lis : heartbeatLis) {
							lis.onHeartbeatStop();
						}
						connStatus = false;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
    	t.setDaemon(true);
    	t.start();
    }
    /**
     * 停止心跳侦听
     */
    public void stopHeartbeat() {
    	heartbeatFlag = false;
    }
    
	public void onMessage(Message message) {
		try {
			if (message instanceof BytesMessage) {
				//二进制协议模式
				//int（个数）int(body长度) byte4（协议）strn（body）{str4（分割符）strn（正文）str4（分割符）}
				BytesMessage bytes = ((BytesMessage) message);
				//调用二进制获取，如果不需要继续解压，返回false
				if(!onBytes(bytes)) {
					return;
				}
				if (bytes != null) {
					//报文个数
					int num = bytes.readInt();
					//报文列表总长度
					int length = bytes.readInt();
					//序列化固定成jdk效率高
					byte b1 = bytes.readByte();
					//压缩
					byte b2 = bytes.readByte();
					//保留
					byte b3 = bytes.readByte();
					//保留
					byte b4 = bytes.readByte();
					//正文
					byte[] bodyByte = new byte[length];
					bytes.readBytes(bodyByte);
					//解压
	                switch(b2) {
	        	        case 0x01://gzip解压
	        	        	bodyByte = UtilGzip.decompress(bodyByte);
	        	        	break;
	        	        default ://无压缩
	        	    }
	                //反序列化
	                String str = UtilCommon.bytesToObj(bodyByte).toString();
	                if(str != null && str.length() > 4) {
	                	String splitStr = new String(str.substring(0, 4));
	                	String[] msgs = str.split(splitStr);
	                	if((msgs.length - 1) != num) {
	                		log.error("字符串拆分的不对:" + num + " " + msgs.length + "\r\n" + str);
	                		return;
	                	}
	                	for (int i = 1; i < msgs.length; i++) {
	                		this.onMessage(new String(msgs[i]));
						}
	                } else {
	                	log.error("mq接收到的数据不对：" + str);
	                }
					
				}
			} else if (message instanceof TextMessage) {
				//传统字符串模式
				String text = ((TextMessage) message).getText();
				//过滤掉心跳信息
				if (text != null && !"heartbeat".equals(text)) {
					this.onMessage(text);
				}
			}
			
			//心跳操作
			this.heartbeat = System.currentTimeMillis();
			for (MqHeartbeatListener lis : this.heartbeatLis) {
				if(!connStatus) {
					lis.onHeartbeatStart();
				}
				
			}
			connStatus = true;
		} catch (Exception e) {
			log.error("mq处理异常：" + message + " ", e);
		}
		
	}
	
	
	
	/**
	 * 接收到的字符串
	 * @param message
	 */
	public abstract void onMessage(String message);
	/**
	 * 接收到二进制数据
	 * 需要使用二进制的重写该方法
	 * @param bytes 二进制
	 */
	/**
	 * 接收到二进制数据
	 * 需要使用二进制的重写该方法
	 * @param bytes 二进制
	 * @return 是否需要继续解压
	 */
	public boolean onBytes(BytesMessage bytes) {
		return true;
	}
	
	/**
     * 添加连接状态监听器
     * @param lis
     */
    public void addHeartBeatListener(MqHeartbeatListener lis) {
    	this.heartbeatLis.add(lis);
    }
	
}
