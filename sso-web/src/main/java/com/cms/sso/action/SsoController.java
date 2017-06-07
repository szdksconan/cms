package com.cms.sso.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.iservice.sso.SsoAuthService;

@Controller
@RequestMapping(value="/")
public class SsoController {
	@Autowired
	private SsoAuthService ssoAuthService; 
	
	@Value("#{configProperties['sso.cookieName']}")
	private String COOKIE_NAME;
	@Value("#{configProperties['sso.cookieDomain']}")
	private String COOKIE_DOMAIN;
	@Value("#{configProperties['sso.cookieMaxage']}")
	private String COOKIE_MAXAGE;
	@Value("#{configProperties['sso.cookieSecure']}")
	private String COOKIE_SECURE;
	@Value("#{configProperties['sso.cookieHttpOnly']}")
	private String COOKIE_HTTPONLY;
				
	@RequestMapping(value="/login")
	public ModelAndView LoginPage(LoginForm form){
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("loginForm",form);
		mv.addObject("message","");
		return mv;
	}
	
	@RequestMapping(value="/loginAuth")
	public ModelAndView LoginAuth(LoginForm form, HttpServletRequest request, HttpServletResponse response ){
	
		//得到页面传值：用户名，密码，systemID,原地址
		String loginName = form.getLoginName();
		String password = form.getPassword();
		String systemId = form.getSystemId();
		String redirect = form.getRedirect();
		boolean autoLogin = form.getAutoLogin();
		
		//验证用户信息是否合法：用户验证，用户权限验证（是否有该systemID的权限）
		try {
			Map<String, Object> auth = ssoAuthService.userLoginAuth(loginName, password, systemId);
			String msg = (String)auth.get("msg");
						
			//消息（SUCCESS 成功,NO_PERMISSION 无权限, ERROR 用户名密码错误, DB_ERROR 数据库操作异常）
			if ("SUCCESS".equals(msg)){
				loginName = (String)auth.get("loginName");
				//设置页面cookie
				setCookie(loginName, autoLogin, request, response);
				
				//转发
				if (redirect!=null && !"".equals(redirect)){
					byte[] rdb = Base64.decodeBase64(redirect);
					response.sendRedirect(new String(rdb));  //转发到原页面
					return null;
				}else
					return new ModelAndView("/index"); //首页
			}else{
				ModelAndView mv = new ModelAndView("/login");
				if ("NO_PERMISSION".equals(msg))
					return new ModelAndView("/index"); //首页
				else if ("ERROR".equals(msg))
					mv.addObject("message", "用户名密码错误！");
				else if ("DB_ERROR".equals(msg))
					mv.addObject("message", "网络连接异常，请重试！");
				mv.addObject(form);
				return mv;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//返回认证结果：1、认证失败，提示用户名密码错误或无权限，2、认证成功，重定向到原地址，如果原地址为空，重定向到平台首页
		return null;
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView Logout(LoginForm form, HttpServletResponse response){
		//删除cookie
		Cookie cookie = new Cookie(COOKIE_NAME, null);
		cookie.setDomain(COOKIE_DOMAIN);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
			
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("loginForm",form);
		mv.addObject("message","");
		return mv;
	}
	
	/**
	 * 认证cookie是否合法，如果合法，转回源地址，并说明合法
	 */	
	private void setCookie(String loginName, boolean autoLogin, HttpServletRequest request, HttpServletResponse response){
		String ticket = null;
		try {
			ticket = ssoAuthService.newCookie(loginName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//需要做加密
		Cookie cookie = new Cookie(COOKIE_NAME, ticket);
		cookie.setDomain(COOKIE_DOMAIN);
		cookie.setPath("/");
		
		cookie.setValue(ticket);
		if (autoLogin)
			cookie.setMaxAge(new Integer(COOKIE_MAXAGE).intValue());
		
		if ("true".equals(this.COOKIE_SECURE))
			cookie.setSecure(true);
		else
			cookie.setSecure(false);
		
		if ("true".equals(this.COOKIE_HTTPONLY))
			cookie.setHttpOnly(true);
		else
			cookie.setHttpOnly(false);
		
		response.addCookie(cookie);
	}
	
	
}
