package com.cms.service.common.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import redis.clients.jedis.HostAndPort;

public class SerializeUtil {
	public static Object convertBytes2Obj(byte[] bytes) throws Exception {
		if (bytes == null) {
			System.out.println("error");
			return null;
		}
		Object obj = null;
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {
			bi = new ByteArrayInputStream(bytes);
			oi = new ObjectInputStream(bi);
			obj = oi.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bi != null) {
				bi.close();
			}
			if (oi != null) {
				oi.close();
			}
		}
		return obj;
	}
	public static byte[] convertObj2Btyes(Object obj) throws Exception {
		byte[] bytes = null;
		if (obj == null) {
			return bytes;
		}
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			bytes = bo.toByteArray();
		} catch (Exception e) {
			throw e;
		} finally {
			if (bo != null) {
				try {
					bo.close();
				} catch (IOException e) {
				}
			}
			if (oo != null) {
				try {
					oo.close();
				} catch (IOException e) {
				}
			}
		}
		return bytes;
	}
	public static Set<HostAndPort> getNodes(){
		
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();  
		InputStream in = SerializeUtil.class.getClassLoader().getResourceAsStream("reids-node.properties");

		Properties pps = new Properties();
		 try {
			pps.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 Enumeration enum1 = pps.propertyNames();//得到配置文件的名字
		 while(enum1.hasMoreElements()) {
			 String strKey = (String) enum1.nextElement();
			 String strValue = pps.getProperty(strKey);
			 String[] strArray = strValue.split("#");
			 jedisClusterNodes.add(new HostAndPort(strArray[0], Integer.parseInt(strArray[1])));  
			 
		}
		return jedisClusterNodes;
		
	}

}
