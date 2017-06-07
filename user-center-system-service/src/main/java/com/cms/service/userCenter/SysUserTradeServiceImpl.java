package com.cms.service.userCenter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.userCenter.SysUserTradeDao;
import com.cms.iservice.userCenter.SysUserTradeService;
import com.cms.model.userCenter.SysUserTradeInfoQuery;
import com.cms.service.userCenter.util.DateUtils;

public class SysUserTradeServiceImpl implements SysUserTradeService{
	//注入dao进行
	@Autowired
	private SysUserTradeDao sysUserTradeInfoDao	;
	
//	public void addTradeInfo(SysUserTradeInfo sysUserTradeInfo) {
//		this.sysUserTradeInfoDao.addTradeInfo(sysUserTradeInfo);
//	}

	public List<Map<String,Object>> findTradeInfoByCreateTime(SysUserTradeInfoQuery query) throws Exception {
		String lately = query.getLately();
		String latelymonth = query.getLatelymonth();
		String month = query.getMonth();
		String week = query.getWeek();
		if(StringUtils.isNotBlank(lately)){
			Date dateBefore = DateUtils.getDateBefore(new Date(), 3);
			String formatDate = DateUtils.getFormatDate(dateBefore);
			query.setLately(formatDate);
			System.out.println("最近:"+formatDate);
		}
		if(StringUtils.isNotBlank(latelymonth)){
			Date dateBefore = DateUtils.getMonthBefore(new Date(), 1);
			String formatDate = DateUtils.getFormatDate(dateBefore);
			query.setLatelymonth(formatDate);
			System.out.println("一个月:"+formatDate);
		}
		if(StringUtils.isNotBlank(week)){
			Date dateBefore = DateUtils.getDateBefore(new Date(), 7);
			String formatDate = DateUtils.getFormatDate(dateBefore);
			query.setWeek(formatDate);
			System.out.println("一周:"+formatDate);
		}
		if(StringUtils.isNotBlank(month)){
			Date dateBefore = DateUtils.getMonth(new Date(), Integer.parseInt(month));
			String formatDate = DateUtils.getFormatDate(dateBefore,"yyyy-MM");
			query.setMonth(formatDate);
		}
		return this.sysUserTradeInfoDao.findTradeInfoByCreateTime(query);
	}

}
