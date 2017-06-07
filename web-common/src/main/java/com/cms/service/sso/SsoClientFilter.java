package com.cms.service.sso;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cms.iservice.sso.SsoAuthService;
       
public class SsoClientFilter {


	/**
	 * 单点登录验证转发： 1、当用户cookie不存在时，自动跳转到passport登陆页面； 2、当用户cookie存在时：
	 * 1）判断用户ticket是否合法， 2）如果合法则放行 3）如果不合法，跳转到登陆页面
	 * 
	 * @author 曹俊
	 */
	public static Map<String,Object> ssoFilter(ServletRequest request, ServletResponse response, String cookieName,
			String redirectPath) throws Exception {
		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
		
		Cookie cookie = null;
		
		//redirectPath += "?redirect="+httpreq.getRequestURL();
		String uri = httpreq.getRequestURL()+ (httpreq.getQueryString() == null ? "" : "?"+ httpreq.getQueryString());
		byte[] urib = Base64.encodeBase64(uri.getBytes());		
		redirectPath += "?redirect="+new String(urib);
		
		StringBuffer toPathB = httpreq.getRequestURL();
		String toPath = null;
		if (toPathB!=null && !"".equals(toPathB.toString()))
			toPath = toPathB.toString();
		
		if (httpreq.getCookies()==null || httpreq.getCookies().length==0){
			wrapper.sendRedirect(redirectPath);
			return null;
		}
			
		for (int i = 0; i < httpreq.getCookies().length; i++) {
			if (cookieName.equals(httpreq.getCookies()[i].getName())) {
				cookie = httpreq.getCookies()[i];
				break;
			}
		}
		
		Map<String,String> mr = null;
		if (cookie == null)
			wrapper.sendRedirect(redirectPath);
		else {
			// 消息（SUCCESS 成功,FAIL 失败)
			try {
				WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
				SsoAuthService ssoAuthService = (SsoAuthService)context.getBean("ssoAuthService");
				Map<String, Object> result = ssoAuthService.userAuth(cookie.getValue(), toPath);
				if (result!=null){
					return result;
				}else{
					wrapper.sendRedirect(redirectPath);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw e;
			}
		}
		return null;
	}
	
	/**
	 * 验证用户是否有权访问此路径
	 * @param loginName
	 * @param toPath
	 * @return
	 */
	public static Boolean verifyPower(ServletRequest request, String loginName){
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
		//UserAuthService userAuthService = (UserAuthService)context.getBean("userAuthService");
		//return userAuthService.verifyPower(loginName, httpreq.getRequestURL());
		return true;
	}

}
