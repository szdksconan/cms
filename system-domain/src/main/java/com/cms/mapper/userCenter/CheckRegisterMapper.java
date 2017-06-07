package com.cms.mapper.userCenter;

import com.cms.model.userCenter.SysUser;

public interface CheckRegisterMapper {
	public int checkRegister(String uname);

	public void addSysUser(SysUser sysUser);

	public void insertRegister(SysUser sysUser);

}
