package com.cms.dao.userCenter;

import java.util.List;

import com.cms.model.userCenter.SysUser;

public interface SysUserDao {
	/**
	 * 新增
	 * @param user
	 */
	public void add(SysUser user);
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void update(SysUser user);
	/**
	 * 根据uid查询用户信息
	 * @param uid
	 * @return
	 */
	public SysUser findById(long uid);
	/**
	 * 根据name查询用户信息
	 * @param name
	 * @return
	 */
	public List findByName(SysUser user);
	/**
	 * 根据name和password查询用户信息
	 * @param name
	 * @param password
	 * @return
	 */
	public List findByNameAndPwd(SysUser user);
	


}
