package com.cms.service.userCenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.userCenter.SysUserDao;
import com.cms.iservice.userCenter.SysUserService;
import com.cms.model.userCenter.SysUser;

public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;
	/**
	 * 企业注册第1步
	 */
	public void addUserOne(SysUser user) {
		sysUserDao.add(user);
	}
	/**
	 * 企业注册第2步
	 */
	public void addUserTwo(SysUser user) {
		
		sysUserDao.update(user);
	}
	/**
	 * 根据name查询用户表
	 */
	public List getByName(SysUser user) {
		return sysUserDao.findByName(user);
	}
	/**
	 * 根据name和password查询用户信息
	 */
	public List loginCheck(SysUser user) {
		return sysUserDao.findByNameAndPwd(user);
	}
	


}
