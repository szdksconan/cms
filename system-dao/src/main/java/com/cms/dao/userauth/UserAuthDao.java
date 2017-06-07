package com.cms.dao.userauth;

import com.cms.model.User;
import com.cms.model.UserAuth;
import com.cms.model.UserTicket;

public interface UserAuthDao {
	
	/**
	 * 得到用户
	 */
	public User getUser(User u);
	
	/**
	 * 用户名密码验证
	 */
	public Integer verifyUserAuth(UserAuth ua);
	
	/**
	 * 得到用户票据
	 * @param ut
	 * @return
	 */
	public UserTicket getUserTicket(UserTicket ut);
	
	/**
	 * 保存用户票据
	 * @param ut
	 */
	public void saveUserTicket(UserTicket ut)throws Exception;
	
	/**
	 * 删除用户票据
	 * @param loginName
	 */
	public void deleteUserTicket(UserTicket ut)throws Exception;
}
