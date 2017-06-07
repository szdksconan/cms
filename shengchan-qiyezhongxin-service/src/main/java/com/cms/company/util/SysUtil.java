package com.cms.company.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cms.model.shengchang.CompAttachRel;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.shengchang.CompContactInfo;
import com.cms.service.common.redis.SerializeUtil;

public class SysUtil {
	 public static List MapToList(Map map,Class c){
	        Iterator it = map.keySet().iterator();
	        List list = new LinkedList();
	        while (it.hasNext()){
	            String key = it.next().toString();
	            System.out.println("*********key********");
	            System.out.println(key);
	            System.out.println("*********key********");
	            try {
	                Object obj =  SerializeUtil.convertBytes2Obj(map.get(key).toString().getBytes("ISO8859-1"));
	                if (c == CompBaseInfo.class){
	                	CompBaseInfo bean = (CompBaseInfo) obj;
	                    list.add(bean);
	                }
	                if (c == CompAttachRel.class){
	                	CompAttachRel bean = (CompAttachRel) obj;
	                    list.add(bean);
	                }
	                if (c == CompContactInfo.class){
	                	
	                	CompContactInfo bean = (CompContactInfo) obj;
	                	System.out.println("*********CompContactInfo********");
	        	        System.out.println(bean.getCompBaseId()+bean.getId());
	        	        System.out.println("*********CompContactInfo********");
	                    list.add(bean);
	                }
	                
	               
	            }catch (Exception e){}
	        }
	        if (list.size()!=0){
	            Collections.sort(list);
	        }
	        System.out.println("*********list********");
	        System.out.println(list.size());
	        System.out.println("*********list********");
	        return list;
	        
	      
	    }
	 
	 
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
		
}
