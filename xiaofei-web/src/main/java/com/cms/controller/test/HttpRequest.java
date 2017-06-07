package com.cms.controller.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.cms.service.common.redis.SerializeUtil;
/**
 * HTTP请求
 *
 * 作者： 郑泽
 * 日期：2016年5月20日
 */
public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }  
    
    public static String sendHPost(String url, String param) throws ClientProtocolException, IOException {
    	String result="";
    	HttpClient httpclient = new DefaultHttpClient();
	    // 创建Get方法实例   
        HttpGet httpgets = new HttpGet(url);  
        HttpResponse response = httpclient.execute(httpgets);  
        HttpEntity entity = response.getEntity();  
        if (entity != null) {  
            InputStream instreams = entity.getContent();  
            String str = convertStreamToString(instreams);
            System.out.println("请求:"+url+"成功"+httpgets);
            result=str;
            System.out.println(str);
            // Do not need the rest  
            httpgets.abort();  
        }
        return result;
    }
    
    public static String convertStreamToString(InputStream is) {    
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));    
        StringBuilder sb = new StringBuilder();    
     
        String line = null;    
        try {    
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");    
            }    
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb.toString();    
    }
    
    
    public static String readAddress(HttpServletRequest request,String name){
		 String path = "";
		 //String realpath = request.getSession().getServletContext().getRealPath("/META-INF/spring");
		 Properties pro = new Properties();  
		 try{  
		 //读取配置文件
		 //FileInputStream in = new FileInputStream(realpath+"/httpRequest.properties");  
		 InputStream in = SerializeUtil.class.getClassLoader().getResourceAsStream("META-INF/spring/httpRequest.properties");  
		 pro.load(in);  
		 }  
		 catch(FileNotFoundException e){  
		    System.out.println(e);
		 }  
		 catch(IOException e){ 
			 System.out.println(e);
		} 
		 
		//通过key获取配置文件
		 path = pro.getProperty(name); 
		 System.out.println(path +"------------------");
		 //byte b[]=title.getBytes("utf-8");
		 //title=new String(b);
		 return path;
	}
	public static String readAddress(HttpServletRequest request){
		 String path = "";
		// String realpath = request.getSession().getServletContext().getRealPath("/META-INF/spring");
		 Properties pro = new Properties();  
		 try{  
		 //读取配置文件
		 //FileInputStream in = new FileInputStream(realpath+"/httpRequest.properties");  
		 InputStream in = SerializeUtil.class.getClassLoader().getResourceAsStream("META-INF/spring/httpRequest.properties"); 
		 pro.load(in);  
		 }  
		 catch(FileNotFoundException e){  
		    System.out.println(e);
		 }  
		 catch(IOException e){ 
			 System.out.println(e);
		} 
		 
		//通过key获取配置文件
		 path = pro.getProperty("address"); 
		 System.out.println(path +"------------------");
		 //byte b[]=title.getBytes("utf-8");
		 //title=new String(b);
		 return path;
	}
	
	public static void main(String[] args) {
		String url = "http://15049by693.iask.in:8001/api/platform/unusedline";
        String json = loadJSON(url);
        System.out.println(json);
	}

	public static String loadJSON (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        yc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }
	
	/*public static void main(String[] args) {
		HttpServletRequest request=null;
		 try {
			 String IP = HttpRequest.readAddress(request, "msgIp");
			 String getURL="?memberId=125556&memberName=bn&memberType=3&phone=15823895412&accountStatus=0";
			 System.out.println(getURL);
			 //发送 POST 请求
			 String sr=HttpRequest.sendHPost("http://"+IP+"/tzyy/member/addMember.do"+getURL, "key=123&v=456");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/*public static void main(String[] args) {
        String url = "http://15049by693.iask.in:8001/api/platform/unusedline";
        String json = loadJSON(url);
        System.out.println(json);
    }
 */
    public static String load_JSON (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        yc.getInputStream(),"utf-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }
	
}