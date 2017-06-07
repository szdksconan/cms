package com.cms.dao.userCenter;

import com.cms.model.userCenter.SysUser;

public interface CheckRegisterDao {
	
public int checkRegister(String uname);
void addSysUser(SysUser sysUser);
void insertRegister(SysUser sysUser);
}
