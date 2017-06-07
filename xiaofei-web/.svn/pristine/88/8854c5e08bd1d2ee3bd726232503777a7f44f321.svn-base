package com.cms.controller.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @date 2013-01-17
 * @author Administrator
 * @category 远程访问WebService获取数据并转化返回为XML
 */
public class WSClient {

	private static final String SERVICE_HOST = "http://15049by693.iask.in";
	private static final String SERVICE_URL = "http://15049by693.iask.in:8001/api/platform/unusedline";// WebService访问路径头部分
	private static String serverURL;// 调用WebService完整地址

	static Logger log = Logger.getLogger(WSClient.class.getClass());// 日志记录对象
	
	

	/**
	 * 调用WebService服务
	 * @param requestMethod：请求方式：GET 或 POST
	 * @param paramString:请求参数
	 * @return Document DOM 对象
	 * @throws IOException 
	 */
	public static Document callServiceForDoc(String requestMethod,String paramString) throws IOException {
		InputStream inputStream = null;
		Document document = null;
		URL url = null;
		HttpURLConnection urlConn = null;
		DocumentBuilderFactory documentBuilderFactory = null;
		DocumentBuilder documentBuilder = null;
		
		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			if ("GET".equalsIgnoreCase(requestMethod)) {// GET方式
				serverURL = SERVICE_URL + "?" + paramString;
				log.error("【请求WebService地址：" + serverURL + "，请求方式：" + requestMethod.toUpperCase() + "】");
				url = new URL(serverURL);
				urlConn = (HttpURLConnection) url.openConnection();
				urlConn.setRequestMethod("GET");
				urlConn.setRequestProperty("Host", SERVICE_HOST);
				urlConn.setConnectTimeout(10000);// （单位：毫秒）
				urlConn.setReadTimeout(10000);// （单位：毫秒）
				urlConn.connect();
				inputStream = urlConn.getInputStream();
				document = documentBuilder.parse(inputStream);
				inputStream.close();
				urlConn.disconnect();
			} else if ("POST".equalsIgnoreCase(requestMethod)) {// POST方式
				log.error("【请求WebService地址：" + serverURL + "，请求方式：" + requestMethod.toUpperCase() + "】");
				url = new URL(serverURL);
				urlConn = (HttpURLConnection) url.openConnection();
				urlConn.setRequestMethod("POST");

				urlConn.setConnectTimeout(10000);// （单位：毫秒）
				urlConn.setReadTimeout(10000);// （单位：毫秒）
				urlConn.setDoOutput(true);
				byte[] byteArray = paramString.getBytes();
				urlConn.getOutputStream().write(byteArray, 0, byteArray.length);
				urlConn.getOutputStream().flush();
				urlConn.getOutputStream().close();
				inputStream = urlConn.getInputStream();
				document = documentBuilder.parse(inputStream);
			} else {
				log.error(">>>>WebService请求方式错误！");
			}
		} catch (ParserConfigurationException e) {
			log.error("请求Webservice异常：解析配置文件异常！" + e.getMessage());
			e.printStackTrace();
			document = null;
		} catch (MalformedURLException e) {
			log.error("请求Webservice异常：URL协议错误！" + e.getMessage());
			e.printStackTrace();
			document = null;
		} catch (ConnectException e) {
			log.error("请求WebService连接超时！" + e.getMessage());
			e.printStackTrace();
			document = null;
		} catch (SocketTimeoutException e) {
			log.error("请求WebService连接超时！" + e.getMessage());
			e.printStackTrace();
			document = null;
		} catch (IOException e) {
			if (urlConn != null) {
				try {
					int errorCode = urlConn.getResponseCode();
					String errorMessage = "请求Webservice异常!服务器返回状态码:";
					switch (errorCode) {
					case 400:
						log.error(errorMessage + "400，错误的请求！");
						break;
					case 403:
						log.error(errorMessage + "403，服务器拒绝访问！");
						break;
					case 404:
						log.error(errorMessage + "404，请求地址不存在！");
						break;
					case 500:
						log.error(errorMessage + "500，WebService服务器内部错误！");
						break;
					case 503:
						log.error(errorMessage + "503，WebService服务不可用！");
						break;
					default:
						log.error(errorMessage + errorCode);
						break;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			document = null;
		} catch (SAXException e) {
			log.error("请求Webservice异常：SAXException！" + e.getMessage());
			e.printStackTrace();
			document = null;
		}finally{
			inputStream.close();
			urlConn.disconnect();
		}
		return document;
	}
	
	public static void main(String[] args) throws IOException {
		WSClient w = new WSClient();
		w.callServiceForDoc("GET", "PageIndex=0&PageSize=20");
	}
}
