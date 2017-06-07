package com.cms.util;

import org.apache.log4j.Logger;

public class LogTool {
	
	//输出到控制台
	public static void print(Object obj){
		if(obj instanceof Throwable){
			Throwable e = (Throwable)obj;
			LogTool.log_exception(e);
		}else{
			LogTool.log_debug(obj);			
		}
	}
	public static void println(Object obj){
		print(obj);
	}
	//异常信息
	public static void log_exception(Object obj) {
		Logger log = Logger.getLogger("exception");
		log.error(obj);
	}
	
	//异常信息
	public static void log_exception(String msg, Throwable t) {
		Logger log = Logger.getLogger("exception");
		log.error(msg, t);
	}

	// 系统登录日志文件
	public static void log_login(Object obj) {
		Logger log = Logger.getLogger("login");
		log.info(obj);
	}
	
	// DEBUG文件，为了查询某些特定问题使用
	public static void log_debug(Object obj) {
		Logger log = Logger.getLogger("debug");
		log.debug(obj);
	}
	
	// 生产平台日志文־
	public static void log_product(Object obj) {
		Logger log = Logger.getLogger("product");
		log.info(obj);
	}
	//贸易平台日志文־
	public static void log_sale(Object obj) {
		Logger log = Logger.getLogger("sale");
		log.info(obj);
	}
	// 物流平台日志文件
	public static void log_wuliu(Object obj) {
		Logger log = Logger.getLogger("wuliu");
		log.info(obj);
	}
	// 消费平台日志文件
	public static void log_consumer(Object obj) {
		Logger log = Logger.getLogger("consumer");
		log.info(obj);
	}
	// 用户中心日志文件
	public static void log_usercenter(Object obj) {
		Logger log = Logger.getLogger("usercenter");
		log.info(obj);
	}
	
	
	
	
}
