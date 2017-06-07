package com.cms.util;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.cms.model.xiaofei.logon.CmsXSysUser;


public class CmsUtil {
	
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 返回cookie值
	 * 
	 * @author ywfy
	 * @param request
	 * @param key
	 * @return
	 * @throws Exception 
	 */
	public  static String CheckLogin(HttpServletRequest request) throws Exception {
		
		
		String ip=AddressUtils.getIp2(request);
		System.out.println("**********************************************************************ip="+ip);
		//String address=AddressUtils.getAddress(request);
		//System.out.println("**********************************************************************address="+address);
		Cookie cookie = getCookie(request,"dl_cms_user");
		String name="";
		CmsXSysUser list;
		Cookie cookies[]=request.getCookies();
	  	
	  	 if(cookies != null){
	  		for(int i=0;i<cookies.length;i++){
		  		if("dl_cms_user".equals(cookies[i].getName())){
	       		 //name=cookies[i].getValue();
		  			name=cookies[i].getValue();
	    			return name;
	       		 }
	  		}
	  		
	        /* for(int i=0;i<cookies.length;i++){
	        	 if("dl_cms_user".equals(cookies[i].getName())){
	        		 //name=cookies[i].getValue();
	        		 list = (CmsXSysUser) RedisUtil.hget("ComXiaofeiLoginUserList", cookies[i].getValue());
	     			return list;
	        		 }
	        	 }*/
	        	 
	        	 
	        }
		/*if(cookie!=null){
			
			}*/
		
		System.out.println("-------------------CheckLogin="+name);
		return "";
	}
	
	private static void getIp2(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	public static  Cookie getCookie(HttpServletRequest request, String key) {
		if (key != null) {
			HashMap<String, Cookie> hm = new HashMap<String, Cookie>();
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					hm.put(cookie.getName(), cookie);
				}
			}
			return hm.get(key);
		} else {
			return null;
		}
	}
	
}
