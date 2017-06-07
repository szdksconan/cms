package com.cms.service.activemq.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class UtilCommon {
	/**
	 * 对象转换成字节数组并gzip压缩
	 * @param obj 对象
	 * @return 字节数组
	 */
	public final static byte[] objToBytesGzip(Object obj) {
		ByteArrayOutputStream bao = null;
		ObjectOutputStream oos = null;
		GZIPOutputStream gzout = null;
		try {
			bao = new ByteArrayOutputStream();
			//建立gzip压缩输出
			gzout=new GZIPOutputStream(bao); 
			oos = new ObjectOutputStream(gzout);
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			oos = null;
			return bao.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(oos != null) {
					oos.close();
					oos = null;
				}
				if(gzout != null) {
					gzout.close();
					gzout = null;
				}
				if (bao != null) {
					bao.close();
					bao = null;
				}
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 字节数组转成对象，并gzip压缩
	 * @param bytes
	 * @return
	 */
	public final static Object bytesToObjGzip(byte[] bytes) {
		ByteArrayInputStream bai = null;
		GZIPInputStream gzin = null;
		ObjectInputStream ois = null;
		try {
			bai = new ByteArrayInputStream(bytes);
			gzin=new GZIPInputStream(bai); 
			ois = new ObjectInputStream(gzin);
			Object obj = ois.readObject();
			ois.close();
			ois = null;
			return obj;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		} finally {
			try {
				if (bai != null) {
					bai.close();
					bai = null;
				}
				if (gzin != null) {
					gzin.close();
					gzin = null;
				}
				if (ois != null) {
					ois.close();
					ois = null;
				}
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * 对象转换成字节数
	 * @param obj 对象
	 * @return 字节数组
	 */
	public final static byte[] objToBytes(Object obj) {
		ByteArrayOutputStream bao = null;
		ObjectOutputStream oos = null;
		try {
			bao = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bao);
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			oos = null;
			return bao.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(oos != null) {
					oos.close();
					oos = null;
				}
				if (bao != null) {
					bao.close();
					bao = null;
				}
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 字节数组转成对象
	 * @param bytes
	 * @return
	 */
	public final static Object bytesToObj(byte[] bytes) {
		ByteArrayInputStream bai = null;
		ObjectInputStream ois = null;
		try {
			bai = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bai);
			Object obj = ois.readObject();
			ois.close();
			ois = null;
			return obj;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		} finally {
			try {
				if (bai != null) {
					bai.close();
					bai = null;
				}
				if (ois != null) {
					ois.close();
					ois = null;
				}
			} catch (IOException e) {
			}
		}
	}
	
	
	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if(obj == null || "".equals(obj.toString())) {
			return true;
		}
		return false;
	}
	
}
