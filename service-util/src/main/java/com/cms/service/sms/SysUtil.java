package com.cms.service.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SysUtil {
	public static String getSysTime(){
		Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar canlandar = Calendar.getInstance();
        canlandar.setTime(date);
        return df.format(canlandar.getTime());
	}
	public static String nullToString(String resource){
		if (resource == null)
			resource = "";
		return resource;
	}
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://192.168.2.214:3306/cms_user";
	    String username = "root";
	    String password = "cms1505";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	public static void saveLog(String flat,String func,String from,String to,String context,String status) {
	    Connection conn = getConn();
	    String sql = "insert into sms_log(plat,func,from_phone,to_phone,context,response_txt,create_time) values(?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	    	
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, flat);
	        pstmt.setString(2, func);
	        pstmt.setString(3, from);
	        pstmt.setString(4, to);
	        pstmt.setString(5, context);
	        pstmt.setString(6, status);
	        pstmt.setTimestamp(7,Timestamp.valueOf(getSysTime()));
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public static String getRespCode(String xml) throws DocumentException{
		String msg = "";
		try{
			Document doc = DocumentHelper.parseText(xml);
			Element rootElement = doc.getRootElement();
			Element code=rootElement.element("code");
			if (code != null) {
				msg = CodeDefine.getMessage(code.getData().toString().trim());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg;
		
	}
}
	
