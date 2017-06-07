package com.cms.mapper.xiaofei.logon;

import java.util.List;
import java.util.Map;

import com.cms.model.xiaofei.logon.CmsXSysUser;

public interface CmsXLogonMapper {
	List<Map<String,Object>>ifinfo(CmsXSysUser sysuser);
	Integer insertSelective(CmsXSysUser sysuser);
	Integer updateByPrimaryKeySelective(CmsXSysUser sysuser);
	CmsXSysUser logoninfo(CmsXSysUser sysuser);
	Map<String, Object> testing(CmsXSysUser sysuser);
	Integer updatepwd(String uid, String newpwd);
}
