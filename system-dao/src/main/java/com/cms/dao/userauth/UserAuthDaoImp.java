package com.cms.dao.userauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.UserAuthMapper;
import com.cms.mapper.UserMapper;
import com.cms.mapper.UserTicketMapper;
import com.cms.model.User;
import com.cms.model.UserAuth;
import com.cms.model.UserTicket;

@Component
public class UserAuthDaoImp implements UserAuthDao {
	
	private static Logger logger = LoggerFactory.getLogger(UserAuthDaoImp.class);
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserAuthMapper userAuthMapper;
	@Autowired
	private UserTicketMapper userTicketMapper;
	
	public User getUser(User u) {
		if (u == null || 
				u.getId()==null && u.getLoginName()==null)
			return null;
		else
			return userMapper.getUser(u);
	}

	public Integer verifyUserAuth(UserAuth ua) {
		if (ua==null || 
				ua.getUserId()==null || ua.getSystemId()==null)
			return 0;
		else
			return userAuthMapper.verifyUserAuth(ua);
	}

	public UserTicket getUserTicket(UserTicket ut) {
		if (ut==null)
			return null;
		else if (ut.getId()==null &&
				(ut.getLoginName()==null || "".equals(ut.getLoginName())))
			return null;
		else
			return userTicketMapper.getUserTicket(ut);
	}

	public void saveUserTicket(UserTicket ut)throws Exception {
		if(ut==null || ut.getLoginName()==null || ut.getTicketValue()==null)
			throw new Exception("需要存储的数据无效");
		else{
			try {
				userTicketMapper.saveUserTicket(ut);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
		}			
	}

	public void deleteUserTicket(UserTicket ut)throws Exception {
		if (ut==null)
			throw new Exception("需要删除的对象为空");
		else if (ut.getId()==null &&
				(ut.getLoginName()==null || "".equals(ut.getLoginName())) &&
				ut.getCreateTime()==null)
			throw new Exception("需要删除的数据无效");
		else{
			try {
				userTicketMapper.deleteUserTicket(ut);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
		}	
	}

}
