package com.cms.dao.userCenter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserSingelInfo;

public interface SysUserSingelInfoDao {
	/**
	 * 添加个人用户信息
	 * @param sysUserSingelInfo
	 */
	void insert(SysUserSingelInfo sysUserSingelInfo);
	/**
	 * 
	 * @param pid 个人用户信息的pid
	 */
	void delete(Long pid);
	/**
	 * 
	 * @param sysUserSingelInfo 个人用户信息对象
	 */
	void update(SysUserSingelInfo sysUserSingelInfo);
	/**
	 * 
	 * @param pid 个人用户对象的pid
	 * @return 返回一个用户对象
	 */
	Map<String,Object>  get(Long uid);
	/**
	 * 获得所有的个人用户对象信息
	 * @return 返回所有的用户对象信息
	 */
	List<SysUserSingelInfo> getAll();
	/**
	 * 对用户登录之后的基本信息进行修改
	 * @param sysUser 系统用户对象
	 */
	void updateBasicInfoPer(SysUser sysUser);
	/**
	 * 对用户的密码进行修改
	 * @param uid 用户id
	 * @param updatePhone 用户的电话号码
	 */
	void updatePhone(SysUser sysUser);
	/**
	 * 根据系统用户id 获得用户信息
	 * @param uid
	 * @return
	 */
	Map<String,Object> getSysUser(Long uid);
	/**
	 * 修改登录用户的邮箱
	 * @param sysUser
	 */
	void updateEmail(SysUser sysUser);
	/**
	 * 
	 * @param uid
	 */
	void updateImgPath(JSONObject obj);
	
}
