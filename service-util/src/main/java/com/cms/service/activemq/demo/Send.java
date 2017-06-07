package com.cms.service.activemq.demo;

import com.cms.service.activemq.connection.ConnectionPool;
import com.cms.service.activemq.connection.SessionPool;
import com.cms.service.activemq.connection.SessionWrapper;

public class Send {
	/**
	 * 普通发送
	 */
	public static void init() {
		String url = "failover:(tcp://192.168.2.213:61616)?initialReconnectDelay=100&timeout=3000&jms.useAsyncSend=true";
		//创建session池
		SessionPool pool = ConnectionPool.getJMSSessionPool(url, "", "");
		//获取session 发送消息   传统消息是字符串发送 或json串
		System.out.println("传统消息：" + pool.send("queue2", "发送一条消息", true));
		//协议消息是按照一定的二进制协议
		SessionWrapper session = pool.getSessionWrapper("queue2", true, false, true);//创建session
		session.start(true);//启动打包发送
		for (int i = 0; i < 10000; i++) {
			System.out.println("协议消息：" + session.sendPact("pact news"));
		}
		//如果长时间运行，不需要调用close
		pool.closeSession();
		ConnectionPool.closeConnection();
	}
	
	/**
	 * 集群发送
	 */
	public static void initCluster() {
		String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <skycenter type=\"ADSBResult\" source=\"ADSB\" reality=\"T\" rcvTime=\"2014-12-23 07:17:53\"><head><datagramId></datagramId><priority></priority><an>780CFB</an><fi>ZH9633</fi><rcvAddress></rcvAddress><sndAddress></sndAddress><bepTime></bepTime><smi></smi><dsp></dsp><rgs>CAN</rgs><msn></msn><datagramType></datagramType><icao24>780cfb</icao24><callcode>CSZ9633</callcode></head><data><unit name=\"LAT\">N22460814</unit><unit name=\"LON\">E112564103</unit><unit name=\"ALT\">5394.96</unit><unit name=\"CAS\">0.00</unit><unit name=\"VEC\">0.00</unit><unit name=\"UTC\">071755</unit></data><msg></msg></skycenter>";
		System.out.println(s.getBytes().length);
		String url = "failover:(tcp://192.168.2.213:61616,tcp://192.168.2.213:61616)?initialReconnectDelay=100&timeout=3000&jms.useAsyncSend=true";
		//创建session池
		SessionPool pool = ConnectionPool.getJMSSessionPool(url, "", "");
		SessionWrapper session = pool.getSessionWrapper("adsbbgsdown", true, false, true);//创建session
		session.start(true);//启动打包发送
		for (int i = 0; i < 100; i++) {
			long time = System.currentTimeMillis();
			session.sendPact(s);
			long t = (System.currentTimeMillis() - time);
            if(t > 10) {
                System.out.println("ADSB发送耗时" + t);
            }
            if(i % 3 == 0) {
	            try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
		}
		
//		//协议消息是按照一定的二进制协议,如果需要协议发送
//		for (int i = 0; i < 10000; i++) {
//			System.out.println("协议消息：" + pool.sendPact("test", "Pact news", true));
//		}
		//获取session 发送消息    传统消息是字符串发送 或json串
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		//如果长时间运行，不需要调用close
		pool.closeSession("test");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		pool = ConnectionPool.getJMSSessionPool(url, "", "");
		//协议消息是按照一定的二进制协议,如果需要协议发送，该队列必须要首先采用协议发送
		pool = ConnectionPool.getJMSSessionPool(url, "", "");
		session = pool.getSessionWrapper("adsbbgsdown", true, false, true);//创建session
		session.start(true);//启动打包发送
		for (int i = 0; i < 10000; i++) {
			System.out.println("协议消息：" + session.sendPact("Pact news"));
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		//如果长时间运行，不需要调用close
		pool.closeSession();
		ConnectionPool.closeConnection();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initCluster();
	}

}
