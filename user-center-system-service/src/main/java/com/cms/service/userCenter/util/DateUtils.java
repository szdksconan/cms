package com.cms.service.userCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private static String defaultPattern = "yyyy-MM-dd";

    private static String[] numWordArray = {"零","壹","贰","叁","肆","伍",
    	                                  "陆","柒","捌","玖"};
    
    
	
	/**
	 * 判断日期是否有效
	 * @param dateStr	日期字串
	 * @param pattern	匹配模式	默认为"yyyy-MM-dd"
	 * @return	boolean true:日期有效/false:日期字串非法
	 */
	public static boolean isValidDate(String dateStr, String pattern) {
		boolean isValid = false;
		String patterns = "yyyy-MM-dd,MM/dd/yyyy";
		
		if (pattern == null || pattern.length() < 1) {
			pattern = "yyyy-MM-dd";
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String date = sdf.format(sdf.parse(dateStr));
			if (date.equalsIgnoreCase(dateStr)) {
				isValid = true;
			}
		} catch (Exception e) {
			isValid = false;
		}
		//如果目标格式不正确，判断是否是其它格式的日期
		if(!isValid){
			isValid = isValidDatePatterns(dateStr,"");
		}
		return isValid;
	}
	/**
	 * 判断日期是否有效
	 * @param dateStr	日期字串
	 * @param pattern	匹配模式	默认为"yyyy-MM-dd;dd/MM/yyyy;yyyy/MM/dd;yyyy/M/d h:mm"
	 * @return	boolean true:日期有效/false:日期字串非法
	 */
	public static boolean isValidDatePatterns(String dateStr,String patterns){
		if(patterns==null || patterns.length()<1){
			patterns = "yyyy-MM-dd;dd/MM/yyyy;yyyy/MM/dd;yyyy/M/d h:mm";
		}
		boolean isValid = false;
		String[] patternArr = patterns.split(";");
		for(int i=0;i<patternArr.length;i++){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(patternArr[i]);
				String date = sdf.format(sdf.parse(dateStr));
				if (date.equalsIgnoreCase(dateStr)) {
					isValid = true;
					DateUtils.defaultPattern = patternArr[i];
					break;
				}
			} catch (Exception e) {
				isValid = false;
			}
		}
		return isValid;
	}
	/**
	 * 返回日期字符串
	 * @param dateStr	日期字符串
	 * @param pattern	匹配模式 如:yyyy-MM-dd
	 * @return
	 */
	public static String getFormatDate(String dateStr, String pattern){
		if (pattern == null || pattern.length() < 1) {
			pattern = "yyyy-MM-dd";
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.defaultPattern);
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			String date = format.format(sdf.parse(dateStr));
			return date;
		} catch (Exception e) {
		}
		return null;
	}
	/**
	 * 日期格式转换
	 * @param date
	 * @return	返回格式为"yyyy-MM-dd"的字串
	 * @throws Exception
	 */
	public static String getFormatDate(Date date) throws Exception{
		return getFormatDate(date,"yyyy-MM-dd");
	}
	/**
	 * 格式转换
	 * @param date		日期变量
	 * @param pattern	匹配模式
	 * @return			日期字符号串
	 */
	public static String getFormatDate(Date date,String pattern) throws Exception{
		if (pattern == null || pattern.length() < 1) {
			pattern = "yyyy-MM-dd";
		}
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String strDate = sdf.format(date);
			return strDate;
		}catch (Exception e) {
			throw new Exception("日期格转换失败！");
		}
		
		
	}
	/**
	 * 格式化为中文大写日期
	 */
	public static String getChinaDate(Date date) throws Exception{
		
		try{
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DATE);
			int year = cal.get(Calendar.YEAR);
		
			String yearStr = "" ;
			while(year > 0){
				int num  = year % 10;
				yearStr = numWordArray[num]+ yearStr;
				year = (int)year/10;
			}
		    
			String monthStr = "";
			if(month < 10){
				monthStr= "零"+ numWordArray[month];
			}else if(month == 10){
				monthStr= "壹拾";
			}else{
				monthStr= "壹拾"+numWordArray[month%10];
			}
			
			String dayStr = "";
			if(day < 10){
				dayStr = "零"+ numWordArray[day];
			}else if(day%10==0){
				
				dayStr = numWordArray[day/10]+ "拾" ;
				
			}else{
				
				dayStr = numWordArray[day/10]+ "拾" +  numWordArray[day%10];
				
			}
			
			String resultStr= yearStr+"年"+monthStr+"月"+dayStr+"日";
			
			
			return resultStr;
		}catch (Exception e) {
			throw new Exception("日期格转换失败！");
		}
	}
	
	

	/**
	 * 格式化为中文大写日期
	 */
	public static String getChinaDate(String  dateStr) throws Exception{
		
		try{
				 String pattern ="";
				 
				 if(dateStr.indexOf("-") != -1 ){
					 pattern = "yyyy-MM-dd";
				 }else if(dateStr.indexOf("/") != -1 ){
					 pattern = "yyyy/MM/dd";
				 }else{
					 pattern = "yyyyMMDD";
				 }
				 
				 SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				 
				 Date date  = sdf.parse(dateStr);
				 
				 return getChinaDate(date);
		
		}catch (Exception e) {
			throw new Exception("日期格转换失败！");
		}
		
	}
	
	public  static Date getStringToDate(String str) {
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date parse=null;
		str=str.replace("T"," ");
		try {
			parse = date.parse(str);
		} catch (ParseException e) {
			
			e.getStackTrace();
		}
		return parse;
	}
	
	public static String getMsgIdCreDtTm(Date date) {	
		if(date==null){
			date=new Date();
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		String creDtTm = sdf1.format(date) + "T" + sdf2.format(date);
		return creDtTm;
	}
	//获得当前时间几天前的时间
	public static Date getDateBefore(Date d, int day) {
	        Calendar now = Calendar.getInstance();
	        now.setTime(d);
	        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
	        return now.getTime();
	 }
	//获得几个月以前的时间
	public static Date getMonthBefore(Date d, int month ) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) - month);
        return now.getTime();
	}
	//获得几年以前的时间
	public static Date getYearBefore(Date d, int year ) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.YEAR, now.get(Calendar.YEAR) - year);
        return now.getTime();
	}
	//指定一年中的某月份
	public static Date getMonth(Date d, int month ) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MONTH,month-1);
        return now.getTime();
	}
	
	
}
