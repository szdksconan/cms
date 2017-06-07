package com.cms.dao.xiaofei.logon;

import java.util.List;
import java.util.Map;

import com.cms.model.xiaofei.logon.CmsXSysUser;

public interface CmsXLogonDao  {
	
	List<Map<String,Object>>ifinfo (CmsXSysUser sysuser);		/* 判断注册信息是否存在*/
	Integer login(CmsXSysUser sysuser);			/*注册*/
	CmsXSysUser logoninfo(CmsXSysUser sysuser);		/*验证登录信息*/
	Map<String, Object> testing(CmsXSysUser sysuser);
	Integer updatePWD(CmsXSysUser sysuser);		/*改密码*/
	Integer updatePhone(CmsXSysUser sysuser);	/*登录phone*/
	
	Integer updatepwd(String uid,String newpwd); 		/*修改密码*/
	

}
