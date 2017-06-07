package com.cms.iservice.userCenter;

import java.util.List;

import com.cms.model.userCenter.SysUser;

public interface SysUserService {
	/**
	 * 企业注册第1步
	 * @param user
	 */
	public void addUserOne(SysUser user);
	/**
	 * 企业注册第2步
	 * @param user
	 * @return
	 */
	public void addUserTwo(SysUser user);
	/**
	 * 更加name查询用户表
	 * @param name
	 * @return
	 */
	public List getByName(SysUser user);
	/**
	 * 根据name和password检查用户信息
	 * @param name
	 * @param password
	 * @return
	 */
	public List loginCheck(SysUser user);

}
