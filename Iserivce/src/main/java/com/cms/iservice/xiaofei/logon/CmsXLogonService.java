package com.cms.iservice.xiaofei.logon;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cms.model.xiaofei.logon.CmsXSysUser;

public interface CmsXLogonService {
	List<Map<String,Object>> ifinfo(CmsXSysUser sysuser);  /*判断注册信息 是否存在*/
	Integer login(CmsXSysUser sysuser);		/*注册*/
	CmsXSysUser logoninfo(CmsXSysUser sysuser);		/*登录*/
	//List<Map<String,Object>> testing(CmsXSysUser sysuser);		/*验证密保或短信*/
	Integer updatepwd(CmsXSysUser sysuser,String newpwd);		/*修改密码*/
	CmsXSysUser CheckLogin(String name);
}
