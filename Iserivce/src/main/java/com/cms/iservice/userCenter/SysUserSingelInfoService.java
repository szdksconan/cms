package com.cms.iservice.userCenter;

import java.util.List;
import java.util.Map;

import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserSingelInfo;

public interface SysUserSingelInfoService {
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
	 * @param uid登录用户的id
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
	 *  修改登录用户绑定的手机号
	 * @param uid
	 * @param updatePhone
	 * @param safeCode
	 */
	void updatePhone(SysUser sysUser);
	/**
	 *  使用验证手机验证码
	 * @param safeCode
	 */
	void checkCode(String safeCode);
	/**
	 *  根据系统用户的id获得需要的 用户信息
	 * @param uid
	 */
	Map<String,Object> getSysUser(Long uid);
	
	/**
	 * 修改登陆用户的邮箱
	 * @param sysUser
	 */
	void updateEmail(SysUser sysUser);
	/**
	 * 保存上传头像的id值
	 * @param uid
	 */
	void updateImgPath(String profileImage,Long uid);
}
