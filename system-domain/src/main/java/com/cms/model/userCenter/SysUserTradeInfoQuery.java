package com.cms.model.userCenter;

import java.io.Serializable;

/**
 * 设置查询对象
 * @author Administrator
 *
 */
public class SysUserTradeInfoQuery implements Serializable {
	//查询的开始时间
	private String beginTime;
	//查询结束时间
	private String endTime;
	//查询最近这段时间
	private String lately;
	//查询最近一周
	private String week;
	//查询最近一个月
	private String latelymonth;
	//查询一年中具体的某个月
	private String month;
	
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getLately() {
		return lately;
	}
	public void setLately(String lately) {
		this.lately = lately;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getLatelymonth() {
		return latelymonth;
	}
	public void setLatelymonth(String latelymonth) {
		this.latelymonth = latelymonth;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "SysUserTradeInfoQuery [beginTime=" + beginTime + ", endTime=" + endTime + ", lately=" + lately
				+ ", week=" + week + ", latelymonth=" + latelymonth + ", month=" + month + "]";
	}
	
}
