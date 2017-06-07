package com.cms.controller.userCenter.sysUserSingelInfo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.userCenter.SysUserSingelInfoService;
import com.cms.iservice.userCenter.SysUserTradeAccountService;
import com.cms.iservice.userCenter.SysUserTradeService;
import com.cms.model.userCenter.SysUserTradeAccout;
import com.cms.model.userCenter.SysUserTradeInfoQuery;

@Controller
@RequestMapping("sysUserTradeAccount")
public class SysUserTradeAccountController {
	//注入账户信息服务
	@Autowired
	private SysUserTradeAccountService sysUserTradeAccountService;
	@Autowired
	private SysUserTradeService sysUserTradeService;
	
	
	
	@Autowired
	private SysUserSingelInfoService sysUserSingelInfoService;
	@Autowired
	private GlobalIdService globalIdService;
	
	private Long uid = 695597107440123904L;
	//对交易账户页面进行跳转
	@RequestMapping("/acc_trading_info")
	public ModelAndView accTrading(){
		ModelAndView model = new ModelAndView();
		//对账户管理页面进行处理
		Map<String, Object> sysUser = sysUserSingelInfoService.getSysUser(uid);
		
		model.addObject("loginUser", sysUser);
		model.setViewName("account-mana-child/acc-trading-per");
		return model;
	}
	
	
	//使用ajax请求对验证码进行处理
	
	@RequestMapping("/check_safeCode")
	public Map<String,Object> check_safeCode(String safeCode){
		Map<String,Object> infoMap = new HashMap();
		
		if(!"1000".equals(safeCode)){
			infoMap.put("message", "验证码错误,请重新输入");
		}
		return infoMap;
	}
	
	@RequestMapping("trade_save")
	public String trade_save(SysUserTradeAccout sysUserTradeAccount){
		System.out.println("执行账户信息的保存方法");
			//设置账户id
			//设置账户的uid
			sysUserTradeAccount.setUid(uid);
			sysUserTradeAccount.setAccoutId(globalIdService.getGlobalId());
			sysUserTradeAccountService.addTradeAccount(sysUserTradeAccount);
			return "redirect:acc_trading_info";
	}
	
	@RequestMapping("/trade_query")
	public ModelAndView trade_query(SysUserTradeInfoQuery query) throws Exception{
		ModelAndView model = new ModelAndView();
//		根据时间进行查询
		List<Map<String, Object>> list = sysUserTradeService.findTradeInfoByCreateTime(query);
		Integer income = 0;
		Integer expend = 0;
		for (Map<String, Object> map : list) {
			BigDecimal strIncome = (BigDecimal)map.get("income");
			income+=strIncome.intValue();
			BigDecimal strExpend =(BigDecimal) map.get("expenditure");
			expend+=strExpend.intValue();
			//对日期数据进行特殊处理
			Date date = (Date)map.get("create_time");
			
			String format = new SimpleDateFormat("yyyy/MM/dd").format(date);
			
			map.put("create_time", format);
		}
		//处理收入
		model.addObject("income", income);
		//处理支出
		model.addObject("expend", expend);
		
		//处理查询条件的回显
		if(StringUtils.isNotBlank(query.getLately())){
			query.setLately("1");
		}
		if(StringUtils.isNotBlank(query.getWeek())){
			query.setLately("2");
		}
		if(StringUtils.isNotBlank(query.getLatelymonth())){
			query.setLately("3");
		}
		if(StringUtils.isNotBlank(query.getMonth())){
			query.setLately(Integer.parseInt(query.getMonth())+3+"");
		}
		model.addObject("query", query);
		model.addObject("tradeinfos", list); 
		model.setViewName("account-mana-child/acc-trading-item-per");
		return model;
	}
	
}
