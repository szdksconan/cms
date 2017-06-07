package com.cms.service.sso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.userauth.UserAuthDao;
import com.cms.iservice.sso.SsoAuthService;
import com.cms.model.User;
import com.cms.model.UserTicket;
import com.cms.service.common.redis.RedisUtil;
import com.cms.service.common.secure.AesTools;

public class SsoAuthServiceImpl implements SsoAuthService {
	
	private static Logger logger = LoggerFactory.getLogger(SsoAuthServiceImpl.class);

	@Autowired
	private UserAuthDao userAuthDao;
	private String ssoKey;

	public String getSsoKey() {
		return ssoKey;
	}

	public void setSsoKey(String ssoKey) {
		this.ssoKey = ssoKey;
	}

	/**
	 * 作者：曹俊
	 * 日期：2015/12/09
	 * 方法说明：认证用户登陆
	 * 参数说明：toPath 访问地址
	 * 返回值：用户ID，消息（SUCCESS 成功,NO_PERMISSION 无权限, ERROR 用户名密码错误, DB_ERROR 数据库操作异常）
	 */
	public Map<String, Object> userLoginAuth(String loginName, String password, String toPath) {

		ResultSet rs = null;
		String msg = null;
		Map<String, Object> result = new HashMap<String, Object>();
		
		//验证用户信息是否合法：用户验证
		if (loginName!=null && !"".equals(loginName) &&
				password!=null && !"".equals(password)){
			
			User u = null;
			try {
				u = this.getUser(loginName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info("用户名密码验证时发生错误:{}",e.getMessage());
				e.printStackTrace();
				result.put("msg", "ERROR");	
				return result;
			}			
			
			if (u!=null && password.equals(u.getPassword())){ //验证用户密码是否正确
				result.put("loginName", u.getLoginName()); //后期需要调整
								
				Set<Object> ual = null;
				try {
					ual = this.getUserAuthList(loginName);
				} catch (RuntimeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				if(ual!=null && toPath!=null && !"".equals(toPath)){
					//如果用户有效,用户权限验证（是否有此路径的权限）
					if (ual.contains(toPath)){
						result.put("msg", "SUCCESS");	
					}else{
						result.put("msg", "NO_PERMISSION");
					}
				}else{
					result.put("msg", "SUCCESS");
				}
			}else{
				result.put("msg", "ERROR");
			}
		}else{
			result.put("msg", "ERROR");
		}
		
		//返回认证结果：1、认证失败，提示用户名密码错误或无权限，2、返回成功SUCCESS
		return result;
	}

	/**
	 * @author Administrator
	 * @category 验证cookie
	 * @param 
	 * @return 用户ID，消息（SUCCESS 成功,FAIL 失败, TIMEOUT session超时)
	 * @throws Exception 
	 */
	public Map<String, Object> userAuth(String cookieValue, String toPath) throws Exception {
		/**
		 * 验证cookie值是否合法，用户是否登陆
		 * 1、解密cookieValue
		 * 2、提取用户名、ticket
		 * 3、验证用户名、ticket是否在此登记
		 * 4、返回结果
		 */
		
		String result = "FAIL";
		if (cookieValue==null || "".equals(cookieValue))
			return null;
		Map<String,Object> m = new HashMap<String,Object>();
		//1、解密cookieValue
		String dsb = null;
		try {
			logger.debug("解密---------------------content:"+cookieValue);
			dsb = AesTools.aesDecrypt(cookieValue, this.ssoKey);
			logger.debug("解密后---------------------content:"+dsb);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		//String dsb = new String(dcb);
		
		//2、提取用户名、ticket、最后一次访问的时间戳
		String[] cvs = new String[2];
		cvs[0] = dsb.substring(0, dsb.indexOf("$#%"));
		cvs[1] = dsb.substring(dsb.indexOf("$#%")+3);
		if (cvs[0]==null || "".equals(cvs[0]) ||
				cvs[1]==null || "".equals(cvs[1]))
			return null;
		
		//3、验证用户名、ticket是否在此登记过
		String loginName = cvs[1];
		try {
			/*
			UserTicket ut = new UserTicket();
			ut.setLoginName(loginName);
			ut = userAuthDao.getUserTicket(ut);
			*/
			String ticket = (String)RedisUtil.get("ticket|"+loginName);
			if (ticket!=null && !"".equals(ticket) &&
					cvs[0].equals(ticket)){
				/* 等到余波接口实现后再加上权限控制
				//判断是否有权限访问此页面
				Set<Object> ual = null;
				try {
					ual = this.getUserAuthList(loginName);
				} catch (RuntimeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				if(ual!=null && toPath!=null && !"".equals(toPath)){
					//如果用户有效,用户权限验证（是否有此路径的权限）
					if (ual.contains(toPath)){
						result = "SUCCESS";
					}else{
						result = "NO_PERMISSION";
					}
				}else{
					result = "SUCCESS";
				}
				*/				
				result = "SUCCESS";
				loginName = cvs[1];
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}
		
		m.put("message", result);
		User u = this.getUser(loginName);
		m.put("loginUser", u);
		
		return m;
	}

	/**
	 * @category 退出
	 */
	public String Logout(String loginName) {
		//删除 用户ticket信息
		if (loginName==null || "".equals(loginName))
			return "FAIL";
		
		UserTicket ut = new UserTicket();
		ut.setLoginName(loginName);
		try {
			userAuthDao.deleteUserTicket(ut);
			return "SUCCESS";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL";
		}
	}

	/**
	 * @category 生成cookie票据，并存储cookie
	 */
	public String newCookie(String loginName)throws Exception {
		// 生成cookie票据
		String ticket = UUID.randomUUID().toString();
		logger.debug("加密---------------------content:"+ticket +"$#%" + loginName);
		String hext = AesTools.aesEncrypt(ticket +"$#%" + loginName, this.ssoKey);
		logger.debug("加密后---------------------after:"+hext);
		//将票据存储到session
		try {
			addTicket(loginName, ticket);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return hext;
	}
	
	/**
	 * 保存ticket
	 * @param loginName
	 * @param cookieValue
	 * @throws SQLException
	 */
	public void addTicket(String loginName, String ticket) throws RuntimeException{
		if (loginName!=null && !"".equals(loginName) &&
				ticket!=null && !"".equals(ticket)){
			try {
				RedisUtil.set("ticket|"+loginName, ticket);
			} catch (Exception e) {
				logger.debug("存储用户票据时出错："+loginName);
				throw new RuntimeException(e);
			}
			/*
			UserTicket ut = new UserTicket();
			ut.setLoginName(loginName);
			ut.setTicketValue(ticket);
			try {
				userAuthDao.deleteUserTicket(ut);
				//ut.setCreateTime(new Date(System.currentTimeMillis()));
				userAuthDao.saveUserTicket(ut);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}else{
			//throw new Exception("需要保存的数据无效");
		}
	}
		
	public Boolean verifyUserAuthFromRedis(String loginName, String toPath) throws SQLException{
		if (loginName==null || "".equals(loginName) ||
				toPath==null || "".equals(toPath))
			return false;
		
		String end = toPath.substring(toPath.length()-1,1);
		if ("/".equals(end))
			toPath = toPath.substring(0, toPath.length()-1);
		//如果用户有效,用户权限验证（是否有该toPath的权限）
		String key = toPath+"#$%"+loginName;
		try {
			Object o = RedisUtil.get(key);
			if (o!=null)
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("用户权限验证失败", e);
			e.printStackTrace();
		}
		
		return false;
	}
	
	public User getUser(String loginName)throws RuntimeException{
		if (loginName==null || "".equals(loginName))
			return null;
		User u = null;
		try {
			u = (User)RedisUtil.get("userinfo|"+loginName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.debug("从redis中查询用户出错："+loginName);
			throw new RuntimeException(e);
		}
		
		if (u==null){
			u = new User();
			u.setLoginName(loginName); //需要调整
			
			try {
				u = userAuthDao.getUser(u);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.debug("从数据库中查询用户出错："+loginName);
				e.printStackTrace();
				throw new RuntimeException(e);
			}		
			
			//从数据库中查出用户信息后更新到redis
			if (u!=null){
				try {
					RedisUtil.set("userinfo|"+u.getLoginName(), u);
				} catch (RuntimeException e) {
					e.printStackTrace();
					logger.debug("userinfo save Redis fail!");
					throw new RuntimeException(e);
				}
			}
		}
		
		return u;
	}
	
	public Set<Object> getUserAuthList(String loginName)throws RuntimeException{
		if (loginName==null || "".equals(loginName))
			return null;
		Set<Object> ual = null;
		try {
			ual = (Set<Object>)RedisUtil.get("userauthlist|"+loginName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.debug("从redis中查询用户出错："+loginName);
			throw new RuntimeException(e);
		}
		
		//如果缓存没有，从数据库查询
		if (ual==null){
			/*
			ual = new UserAuth();
			u.setLoginName(loginName); //需要调整
			
			try {
				u = userAuthDao.getUser(u);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.debug("从数据库中查询用户出错："+loginName);
				e.printStackTrace();
				throw new RuntimeException(e);
			}	
			*/
			//从数据库中查出用户权限信息后更新到redis
			if (ual!=null){
				try {
					RedisUtil.set("userauthlist|"+loginName, ual);
				} catch (RuntimeException e) {
					e.printStackTrace();
					logger.debug("userauthlist save Redis fail!");
					throw new RuntimeException(e);
				}
			}
		}
		
		return ual;
	}
}
