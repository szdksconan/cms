package com.cms.service.userCenter;


import org.springframework.beans.factory.annotation.Autowired;
import com.cms.dao.userCenter.CheckRegisterDao;
import com.cms.iservice.userCenter.CheckRegisterService;
import com.cms.model.userCenter.SysUser;

public class CheckRegisterServiceImpl implements CheckRegisterService{
	@Autowired
	private CheckRegisterDao checkRegisterDao;
	public int checkRegister(String uname) {
		// TODO Auto-generated method stub
		return this.checkRegisterDao.checkRegister(uname);
	}
	public void addSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		 this.checkRegisterDao.addSysUser(sysUser);
	}
	public void insertRegister(SysUser sysUser) {
		// TODO Auto-generated method stub
		this.checkRegisterDao.insertRegister(sysUser);
	}
	
	
	
	
}
