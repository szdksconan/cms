package com.cms.dao.xiaofei.logon;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.xiaofei.logon.CmsXLogonMapper;
import com.cms.model.xiaofei.logon.CmsXSysUser;
@Component
public class CmsXLogonDaoImpl implements CmsXLogonDao{

	@Autowired
	CmsXLogonMapper cxm;
	public List<Map<String, Object>> ifinfo(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		return cxm.ifinfo(sysuser);
	}
	public Integer login(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		return cxm.insertSelective(sysuser);
	}
	public CmsXSysUser logoninfo(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		return cxm.logoninfo(sysuser);
	}
	public Map<String, Object> testing(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		return cxm.testing(sysuser);
	}
	public Integer updatePWD(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		return cxm.updateByPrimaryKeySelective(sysuser);
	}
	public Integer updatePhone(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		return cxm.updateByPrimaryKeySelective(sysuser);
	}
	
	public Integer updatepwd(String uid, String newpwd) {
		// TODO Auto-generated method stub
		return cxm.updatepwd(uid,newpwd);
	}

}
