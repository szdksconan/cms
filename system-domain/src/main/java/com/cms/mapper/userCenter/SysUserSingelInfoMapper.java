package com.cms.mapper.userCenter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserSingelInfo;

public interface SysUserSingelInfoMapper {
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
	 *  对个人用户的基本信息进行修改
	 * @param sysUser
	 */
	void updateBasicInfoPer(SysUser sysUser);
	/**
	 *  对用户的电话号码进行修改
	 * @param sysUser
	 */
	void updatePhone(SysUser sysUser);
	/**
	 *  获得系统用户信息
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
	 *  修改图片的路径
	 * @param uid
	 */
	void updateImgPath(JSONObject obj);
}





