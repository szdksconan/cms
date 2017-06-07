package com.cms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
}
	
