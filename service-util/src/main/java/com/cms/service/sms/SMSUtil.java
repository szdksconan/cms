package com.cms.service.sms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SMSUtil {
	private static String WSDL = "http://ws.iems.net.cn/GeneralSMS/ws/SmsInterface?wsdl";
	private static String USERNAME = "69722:admin";
	private static String PASSWORD = "50887727";
	private static String FROM = "cms";
	public static String PRODUCER_SMS = "producer";
	public static String COMMON_SMS = "common";
	public static String CONSUMER_SMS = "consumer";
	public static String TRADERS_SMS = "traders";
	public static String USER_SMS = "user";
	public static String CHPP_SMS = "chpp";
	public static String OTHER_SMS = "other";
	public static String SMS_TYPE = "0";
	public static String RE_CALL_NUM = "1";
	public static String RE_LISTEN_NUM = "1";
	public static String IS_ANSWER = "0";
	

	private static Logger logger = LoggerFactory.getLogger(SMSUtil.class);
	
	static {
		logger.debug("init SMSUtil......");
		InputStream in = SMSUtil.class.getClassLoader().getResourceAsStream("sms.properties");

		Properties pps = new Properties();
		 try {
			pps.load(in);
			WSDL = pps.getProperty("wsdl").trim();
			USERNAME = pps.getProperty("username").trim();
			PASSWORD = pps.getProperty("password").trim();
			FROM = pps.getProperty("from").trim();
			PRODUCER_SMS = pps.getProperty("producer_sms").trim();
			COMMON_SMS = pps.getProperty("common_sms").trim();
			CONSUMER_SMS = pps.getProperty("consumer_sms").trim();
			TRADERS_SMS = pps.getProperty("traders_sms").trim();
			USER_SMS = pps.getProperty("user_sms").trim();
			CHPP_SMS = pps.getProperty("chpp_sms").trim();
			OTHER_SMS = pps.getProperty("other_sms").trim();
			
			SMS_TYPE = pps.getProperty("sms_type").trim();
			RE_CALL_NUM = pps.getProperty("re_call_num").trim();
			RE_LISTEN_NUM = pps.getProperty("re_listen_num").trim();
			IS_ANSWER = pps.getProperty("is_answer").trim();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (in!=null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * 发送普通短信
	 * @param flatform 平台
	 * @param func    模块
	 * @param to	      接收方手机号
	 * @param context  短信内容
	 * @throws RuntimeException
	 */
	public static void sendSMS(String flatform,String func,String to, String context) throws RuntimeException{
		try {
			
             Service service = new Service();  
             Call call = (Call) service.createCall();  
             call.setTargetEndpointAddress(WSDL);  
             call.setOperationName("clusterSend");//WSDL里面描述的接口名称  
             call.addParameter("username", org.apache.axis.encoding.XMLType.SOAP_STRING,  
                           javax.xml.rpc.ParameterMode.IN);//接口的参数  
             call.addParameter("password", org.apache.axis.encoding.XMLType.SOAP_STRING,  
                     javax.xml.rpc.ParameterMode.IN);//接口的参数  
             call.addParameter("from", org.apache.axis.encoding.XMLType.SOAP_STRING,  
                     javax.xml.rpc.ParameterMode.IN);//接口的参数  
             call.addParameter("to", org.apache.axis.encoding.XMLType.SOAP_STRING,  
                     javax.xml.rpc.ParameterMode.IN);//接口的参数  
             call.addParameter("text", org.apache.axis.encoding.XMLType.SOAP_STRING,  
                     javax.xml.rpc.ParameterMode.IN);//接口的参数  
             call.addParameter("presendTime", org.apache.axis.encoding.XMLType.SOAP_STRING,  
                     javax.xml.rpc.ParameterMode.IN);//接口的参数  
             call.addParameter("isVoice", org.apache.axis.encoding.XMLType.SOAP_STRING,  
                     javax.xml.rpc.ParameterMode.IN);//接口的参数  
             call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型    
             
             
             flatform = "".equals(SysUtil.nullToString(flatform)) ? OTHER_SMS:flatform;
             
             //给方法传递参数，并且调用方法  
             /*<?xml version="1.0" encoding="GBK"?>
             <resp>
             <code>1000</code>
             <messages>
             <msg><messageId>1449547839</messageId>
             <from>18780213052</from>
             <to>18780213051</to></msg>
             </messages>
             </resp>*/
             String result = (String)call.invoke(new Object[]{USERNAME,PASSWORD,FROM,to,context,SysUtil.getSysTime(),"0|1|1|0"});  
             //日志记录
             SysUtil.saveLog(flatform, func, FROM, to, context, SysUtil.getRespCode(result));
             
             logger.info("sendSMS返回参数："+result);
		} catch (Exception e) {
			logger.info("invoke sendSMS fail",e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	
	public static void main(String args[]) throws Exception{
		SMSUtil.sendSMS(SMSUtil.OTHER_SMS,"", "", "测试短信");
		
	}

}
