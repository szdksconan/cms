package com.cms.iservice.sso;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface SsoAuthService {
	/**
	 * 作者：曹俊
	 * 日期：2015/12/09
	 * 方法说明：认证用户登陆
	 * 参数说明：toPath 访问地址
	 * 返回值：用户ID，消息（SUCCESS 成功,NO_PERMISSION 无权限, ERROR 用户名密码错误, DB_ERROR 数据库操作异常）
	 */
	public Map<String, Object> userLoginAuth(String loginName, String password, String toPath);

	/**
	 * 作者：曹俊
	 * 日期：2015/12/09
	 * 方法说明：认证用户票据是否合法
	 * 参数说明：toPath 访问地址，用于判断用户是否有权访问此地址
	 * 返回值：用户ID，消息（SUCCESS 成功,FAIL 失败)
	 */
	public Map<String, Object> userAuth(String cookieValue, String toPath) throws Exception;
	
	/**
	 * 作者：曹俊
	 * 日期：2015/12/09
	 * 方法说明：登出处理
	 * 参数说明：
	 * 返回值：用户ID，消息（SUCCESS 成功,NO_PERMISSION 无权限, ERROR 用户名密码错误, DB_ERROR 数据库操作异常）
	 */
	public String Logout(String loginName);
	
	/**
	 * 作者：曹俊
	 * 日期：2015/12/09
	 * 方法说明：生成新的cookie并保存到后台，用于后期cookie校验
	 * 参数说明：
	 * 返回值：用户ID，消息（SUCCESS 成功,NO_PERMISSION 无权限, ERROR 用户名密码错误, DB_ERROR 数据库操作异常）
	 */
	public String newCookie(String loginName)throws Exception;
	
}
