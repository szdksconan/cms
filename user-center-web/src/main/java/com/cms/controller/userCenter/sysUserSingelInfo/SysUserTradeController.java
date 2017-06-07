package com.cms.controller.userCenter.sysUserSingelInfo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.iservice.userCenter.SysUserSingelInfoService;
import com.cms.model.userCenter.SysUser;

@Controller
@RequestMapping("sysUserTradeInfo")
public class SysUserTradeController {
	private Long uid = 695597107440123904L;
	// 注入服务
	@Autowired
	private SysUserSingelInfoService sysUserSingelInfoService;

	// 对账户安全页面进行跳转
	@RequestMapping("/acc_safe_per")
	public ModelAndView accountSafe() {
		
		ModelAndView model = new ModelAndView();
		System.out.println("对账户安全页面进行跳转");
		
		
		//对个别用户名信息显示
		Map<String, Object> sysUser = sysUserSingelInfoService.getSysUser(uid);
		String phone= (String)sysUser.get("phone");
		//获得邮箱进行处理
		String email =(String)sysUser.get("email");
		//对数据进行特殊处理;
		String phoneTemp = phone.substring(3, 7);
		String phoneRe = phone.replace(phoneTemp, "****");
		String emalStr = email.substring(3, email.indexOf("@"));
		String emailPh = email.replace(emalStr, "***");
		
		sysUser.put("phoneTemp", phoneRe);
		sysUser.put("emailTemp", emailPh);
		
		
		model.addObject("loginUser", sysUser);
		model.setViewName("account-mana-child/acc-safety-per");
		
		return model;
	}
	// 处理账户安全页面
	@RequestMapping("/update_page")
	public ModelAndView update_page(){
		ModelAndView model = new ModelAndView();
		//获得登录用户目前的手机号
		
		Map<String, Object> sysUser = sysUserSingelInfoService.getSysUser(uid);
		Object phone = sysUser.get("phone");
		model.addObject("phone", phone);
		model.setViewName("account-mana-child/updatePhone1");
		return  model;
	}
	
	
	
	// 对修改邮箱页面进行跳转
	@RequestMapping("/email_page")
	public String addEmail() {
		
		
		
		return "account-mana-child/updateEmail1";
	}

	// 处理修改手机号码业务
	@RequestMapping("/update_phone")
	public ModelAndView pdate_phone(SysUser sysUser, String safeCode) {
		System.out.println("执行修改密码 程序++++++++++++++++++++===");
		System.out.println("updatePhone:" + sysUser);
		System.out.println("safeCode:" + safeCode);
		// 模拟登陆用户信息uid
		Long uid = 695597107440123904L;
		sysUser.setUid(uid);
		ModelAndView model = new ModelAndView();
		// 提供一个服务来进行判断;
		// 获得当前登录用户的id
		sysUserSingelInfoService.updatePhone(sysUser);
		// 将错误信息添加至页面
		model.addObject("phone", sysUser);
		model.setViewName("redirect:acc_safe_per");
		return model;
	}

	@RequestMapping("/email_update")
	public String update_email(SysUser sysUser) {

		System.out.println("执行邮箱信息修改:" + sysUser);
		Long uid = 695597107440123904L;
		sysUser.setUid(uid);
		// 执行邮箱修改
		sysUserSingelInfoService.updateEmail(sysUser);

		return "redirect:acc_safe_per";
	}

}
