package com.cms.service.sso;


import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cms.iservice.sso.DealUserInfoOnLogin;
import com.cms.model.User;

public class CheckLoginFilter extends HttpServlet implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 446680333887545884L;
	private String[] includeList; 
	private String[] noProtectedList;
	private String cookieName;
	private String redirectPath;
	private String mainPage;
	
	public FilterConfig config;
	
	public static boolean isContains(String container, String[] regx) {
		boolean result = false;

		for (int i = 0; i < regx.length; i++) {
			if (container.indexOf(regx[i]) != -1) {
				return true;
			}
		}
		return result;
	}

	public void setFilterConfig(FilterConfig config) {
		this.config = config;
	}

	public FilterConfig getFilterConfig() {
		return config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
		
		//String protectedPath = config.getInitParameter("protectedPath");
		//String[] includeList = protectedPath.split(";");

		//String noProtectedPath = config.getInitParameter("noProtectedPath");
		//String[] noProtectedList = noProtectedPath.split(";");
		
		//String cookieName = config.getInitParameter("cookieName");
		//String redirectPath = config.getInitParameter("redirectPath");
		//String mainPage = config.getInitParameter("mainPage");

		//从session中得到用户信息
		User loginUser = (User)httpreq.getSession().getAttribute("sso:loginUser");
		
		if (loginUser == null || "".equals(loginUser)) {
			if (!isContains(httpreq.getRequestURI(), includeList)) {
				chain.doFilter(request, response);
				return;
			}
			
			//认证白名单
			if (isContains(httpreq.getRequestURI(), noProtectedList)) {
				chain.doFilter(request, response);
				return;
			}
			
			//单点登录认证
			Map<String,Object> ln = null;
			try {
				//返回用户基本信息、用户权限列表
				ln = SsoClientFilter.ssoFilter(request, response, cookieName, redirectPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//将用户基本信息、用户权限列表存入session
			if (ln!=null){
				loginUser = (User)ln.get("loginUser");
				
				if (loginUser!=null ||
						"SUCCESS".equals(ln.get("message"))){
					httpreq.getSession().setAttribute("sso:loginUser", loginUser);
					
					//调用相关系统的接口类，将用户相关业务信息存储到session或redis中的
					WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
					DealUserInfoOnLogin dealUserInfoOnLogin = (DealUserInfoOnLogin)context.getBean("dealUserInfoOnLogin");
					dealUserInfoOnLogin.dealUserInfo(loginUser.getLoginName());
					chain.doFilter(request, response);
				}else{
					wrapper.sendRedirect(mainPage);
				}
			}
		} else {
			//判断路径权限
			Boolean havePower = SsoClientFilter.verifyPower(request, loginUser.getLoginName());
			if (havePower)
				chain.doFilter(request, response);
			else
				wrapper.sendRedirect(mainPage);
		}
	}

	public void destroy() {
		this.config = null;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//通过web.xml配置加载参数
		this.config = filterConfig;
		
		//通过properties文件加载参数
		Properties prop = new Properties(); 
		//this.getClass().getResource("/")+
		
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("META-INF/spring/config.properties"); 
        try { 
            prop.load(in); 
            String protectedPath = prop.getProperty("web.protectedPath").trim(); 
            includeList = protectedPath.split(";");
            String noProtectedPath = prop.getProperty("web.noProtectedPath").trim(); 
    		noProtectedList = noProtectedPath.split(";");
    		
    		cookieName = prop.getProperty("web.cookieName").trim(); 
    		redirectPath = prop.getProperty("web.loginPath").trim(); 
    		mainPage = prop.getProperty("web.homePage").trim(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
	}

}