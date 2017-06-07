package com.cms.iservice.userCenter;

import com.cms.model.userCenter.SysUser;

public interface CheckRegisterService {
	public int checkRegister(String uname);//查询会员名的个数，如果大于1会员名存在。
	void addSysUser(SysUser sysUser);//录入个人用户基本信息.
	
	void insertRegister(SysUser sysUser);//录入个人用户注册信息

}
