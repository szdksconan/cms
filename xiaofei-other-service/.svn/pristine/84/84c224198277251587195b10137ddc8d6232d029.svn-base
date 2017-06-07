package com.cms.service.xiaofei.logon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.logon.CmsXLogonDao;
import com.cms.iservice.xiaofei.logon.CmsXLogonService;
import com.cms.model.xiaofei.logon.CmsXSysUser;
import com.cms.service.common.redis.RedisUtil;

public class CmsXLogonServiceImpl implements CmsXLogonService {

	@Autowired
	private CmsXLogonDao cld;
	
	public List<Map<String, Object>> ifinfo(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		return cld.ifinfo(sysuser);
	}

	public Integer login(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		
		return cld.login(sysuser);
	}

	public CmsXSysUser logoninfo(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		CmsXSysUser list=cld.logoninfo(sysuser);
		System.out.println("**************");
		System.out.println(list == null);
		System.out.println("**************");
		if(list!=null){
			/*RedisUtil.hset("ComXiaofeiLoginUserList", list.getUid()+"", sysuser);
			CmsXSysUser user = (CmsXSysUser)RedisUtil.hget("ComXiaofeiLoginUserList", list.getUid()+"");*/
			//System.out.println("user:uname="+user.getUname());
			
			System.out.println("list2---------------"+list.getUid());
		}
		//System.out.println("list2---------------"+list.getUid());
		
		return list;
	}

	/*public List<Map<String, Object>> testing(CmsXSysUser sysuser) {
		// TODO Auto-generated method stub
		return cld.testing(sysuser);
	}*/

	public Integer updatepwd(CmsXSysUser sysuser,String newpwd) {
		// TODO Auto-generated method stub
		String uid=cld.testing(sysuser).get("uid").toString();
		cld.updatepwd(uid,newpwd);
		
		return cld.updatepwd(uid,newpwd);
	}

	public CmsXSysUser CheckLogin(String name) {
		// TODO Auto-generated method stub
		
		System.out.println("-------------------CheckLogin="+name);
		
		
		CmsXSysUser list = (CmsXSysUser) RedisUtil.hget("ComXiaofeiLoginUserList", name);
		return list;
		
	}
	
	public  Cookie getCookie(HttpServletRequest request, String key) {
		if (key != null) {
			HashMap<String, Cookie> hm = new HashMap<String, Cookie>();
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					hm.put(cookie.getName(), cookie);
				}
			}
			return hm.get(key);
		} else {
			return null;
		}
	}
	
	

}
