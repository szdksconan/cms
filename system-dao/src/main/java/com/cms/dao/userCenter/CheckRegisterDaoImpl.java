package com.cms.dao.userCenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.userCenter.CheckRegisterMapper;
import com.cms.model.userCenter.SysUser;

@Component
public class CheckRegisterDaoImpl implements CheckRegisterDao {

	@Autowired
	private CheckRegisterMapper checkRegisterMapper;
	public int checkRegister(String uname) {
		// TODO Auto-generated method stub
		return checkRegisterMapper.checkRegister(uname);
	}
	public void addSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		this.checkRegisterMapper.addSysUser(sysUser);
	}
	public void insertRegister(SysUser sysUser) {
		// TODO Auto-generated method stub
		this.checkRegisterMapper.insertRegister(sysUser);
	}
	

	
	
	

}
