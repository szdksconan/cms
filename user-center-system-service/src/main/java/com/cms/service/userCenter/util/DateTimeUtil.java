package com.cms.service.userCenter.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;


/**
 * @author weibo
 * 
 */

public class DateTimeUtil {
	
	private static final String[] parsePatterns = new String[]{"yyyy-MM-dd","yyyy/MM/dd","yyyyMMdd"};

	
	public static Date parse(String s){
		if (s == null || "".equals(s)) {
			return null;
		}  
		Date date = new Date();	
		try {
			 date = org.apache.commons.lang.time.DateUtils.parseDate(StringUtils.trimToEmpty(s),
					parsePatterns);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return date;
	}
	

	
	public static Date parseFrom_yyyyMMddhhmmss(String source) {
		if (source == null) {
			return null;
		}
		SimpleDateFormat mat = new SimpleDateFormat("yyyy/MM/dd");
		Date dd = new Date();
		try {
			dd = mat.parse(source);
		} catch (ParseException e) {
			e.getStackTrace();
		}
		return dd;
	}
	
	public static String getXX_Date(String source) {
		String str = "";
		if (source != null) {
			str = source.replaceAll("-", "/");
		}

		return str;
	}

	public static Date getNowDateTime() {
		Calendar cd = Calendar.getInstance();

		return cd.getTime();

	}

	public static String parse_time(String s) throws java.text.ParseException {
		if (s == null) {
			return null;
		}
		DateFormat f = DateFormat.getDateInstance(DateFormat.DEFAULT);
		Date d = f.parse(s);
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		return sdf.format(d);

	}

	public static String toDateString(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdff.format(date);
		return dateStr;
	}

	public static String toDateTimeString(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String s = "";
		s += cal.get(Calendar.YEAR);
		s += "-";
		s += cal.get(Calendar.MONTH) + 1;
		s += "-";
		s += cal.get(Calendar.DATE);
		s += " ";
		s += cal.get(Calendar.HOUR_OF_DAY);
		s += ":";
		s += cal.get(Calendar.MINUTE);
		s += ":";
		s += cal.get(Calendar.SECOND);
		return s;
	}

	public static String toTimeString(Date date) {
		return DateFormatUtils.format(date, "HH:mm:ss");
	}


	/**
	 * 将字符日期yyyy-MM-dd转换为yyyyMMdd.
	 */
	public static String get_YYYYMMDD_Date(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dt = sdf.format(date);
		return dt;
	}

	/**
	 * 将字符日期yyyy-MM-dd转换为yyyyMMdd.
	 */
	public static String getYYYY_MM_DD_Date(String dateStr) {
		return DateFormatUtils.format(parse(dateStr), "yyyy-MM-dd");
	}


	public static String get_YYYY_MM_DD_Date(Date date) {
		return DateFormatUtils.format(date, "yyyy-MM-dd");
	}
	/**
	 *  获得当前时间格式的字符串
	 * @return
	 */
	public static String get_hhmmss_time() {
		String dt = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			dt = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.getStackTrace();
		}
		return dt;
	}

	/**
	 * 计算某日期之后N天的日期
	 * 
	 * @param theDateStr
	 * @param days
	 * @return String
	 */
	public static String getDate(String theDateStr, int days) {
		Date theDate = java.sql.Date.valueOf(theDateStr);
		Calendar c = new GregorianCalendar();
		c.setTime(theDate);
		c.add(GregorianCalendar.DATE, days);
		java.sql.Date d = new java.sql.Date(c.getTime().getTime());
		return d.toString();
	}

	/**
	 * 计算一旬的头一天
	 * 
	 * @param theDate
	 * @param days
	 * @return
	 */
	public static java.sql.Date getDayOfPerMonth(String theDataStr) {
		Date theDate = java.sql.Date.valueOf(theDataStr);
		Calendar c = new GregorianCalendar();
		c.setTime(theDate);
		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day <= 10) {
			c.set(Calendar.DAY_OF_MONTH, 1);
		} else if (day > 10 && day <= 20) {
			c.set(Calendar.DAY_OF_MONTH, 11);
		} else {
			c.set(Calendar.DAY_OF_MONTH, 21);
		}
		c.add(Calendar.DAY_OF_MONTH, -1);

		return new java.sql.Date(c.getTime().getTime());
	}

	/**
	 * 判断是否为该月最后一天
	 * 
	 * @param theDate
	 * @param days
	 * @return
	 */
	public static boolean isLastDayOfMonth(String theDataStr) {
		Date theDate = java.sql.Date.valueOf(theDataStr);
		Calendar c = new GregorianCalendar();
		c.setTime(theDate);
		int nowDay = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		int lowDayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		if (nowDay == lowDayOfMonth) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取指定月份的最后一天
	 * @param date
	 * @return
	 */
	public static Date lastDateOfMonth(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		return c.getTime() ;
	}
	
	/**
	 * 获取指定月份的第一天
	 * @param date
	 * @return
	 */
	public static Date firstDateOfMonth(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return  c.getTime() ;
	}
	
	/**
	 * 获取指定年份的第一天
	 * @param date
	 * @return
	 */
	public static Date firstDateOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return  c.getTime() ;
	}
	
	/**
	 * 获取指定年份的最后一天
	 * @param date
	 * @return
	 */
	public static Date lastDateOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 31);
		return  c.getTime();
	}

	/**
	 * 计算某日期之后N天的日期
	 * 
	 * @param theDate
	 * @param days
	 * @return Date
	 */
	public static Date getDate(Date theDate, int days) {
		Calendar c = new GregorianCalendar();
		c.setTime(theDate);
		c.add(GregorianCalendar.DATE, days);
		return  c.getTime() ;
	}

	/**
	 * 计算某日期之后N的日期
	 * 
	 * @param theDate
	 * @param field，如GregorianCalendar.DATE,GregorianCalendar.MONTH
	 * @param amount
	 *            数目
	 * @return Date
	 */
	public static Date getDate(Date theDate, int field, int amount) {
		Calendar c = new GregorianCalendar();
		c.setTime(theDate);
		c.add(field, amount);
		return c.getTime();
	}
	/**
	 * 获得两个日期(字符串)之间的天数
	 * @param begin_dt
	 * @param end_dt
	 * @return
	 */
	public static long getDiffDays(String begin_dt, String end_dt) {
		Date end = java.sql.Date.valueOf(end_dt);
		Date begin = java.sql.Date.valueOf(begin_dt);
		return DateTimeUtil.getDaysBetween(begin, end);
	}

	/**
	 * 计算两日期之间的天数
	 * 
	 * @param start
	 * @param end
	 * @return int
	 */
	public static long getDaysBetween(final Date start, final Date end) {
		if(start==null || end==null)return 0;
		Date startTemp = (Date)start.clone();
		Date endTemp = (Date)end.clone();
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(startTemp);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		GregorianCalendar calEnd = new GregorianCalendar();
		calEnd.setTime(endTemp);
		calEnd.set(Calendar.HOUR_OF_DAY, 0);
		calEnd.set(Calendar.MINUTE, 0);
		calEnd.set(Calendar.SECOND, 0);
		calEnd.set(Calendar.MILLISECOND, 0);
		
		long days = (cal.getTimeInMillis()-calEnd.getTimeInMillis())/(24L*60L*60L*1000L);
		days = Math.abs(days);
		
		return days;
	}

	/**
	 * 以指定时间格式返回指定时间
	 * 
	 * @param dt
	 *            指定时间
	 * @param format
	 *            时间格式，如yyyyMMdd
	 * @return 返回指定格式的时间
	 */
	public static String getTime(Date dt, String format) {
		SimpleDateFormat st = new SimpleDateFormat(format);
		return st.format(dt);
	}
 
	/**
	 * 日期解析
	 * 
	 * @param source
	 *            日期字符
	 * @param format
	 *            解析格式，如果为空，使用系统默认格式解析
	 * @return 日期
	 */
	public static Date parse(String source, String format) {
		if (source == null) {
			return null;
		}

		DateFormat df = null;
		if (format != null) {
			df = new SimpleDateFormat(format);
		} else {
			df = DateFormat.getDateInstance(DateFormat.DEFAULT);
		}
		try {
			return df.parse(source);
		} catch (ParseException e) {
			e.getStackTrace();
			return new Date();
		}
	}


	public static boolean compartdate(Date d1, Date d2) {

		long due = d1.getTime() ;
		long due2 = d2.getTime() ;
		if (due > due2) {
			return false;
		}
		return true;
	}
	public static boolean compartdateOrEq(Date d1, Date d2) {
		
		long due = d1.getTime() ;
		long due2 = d2.getTime() ;
		if (due >= due2) {
			return false;
		}
		return true;
	}
	
	public static boolean equalsDate(Date d1, Date d2) { 
		String date1 = DateTimeUtil.get_YYYY_MM_DD_Date(d1);
		String date2 = DateTimeUtil.get_YYYY_MM_DD_Date(d2);
		return StringUtils.equals(date1, date2);
	}
	
}