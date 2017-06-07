package com.cms.dao.userCenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.userCenter.SysUserMapper;
import com.cms.model.userCenter.SysUser;
@Component
public class SysUserDaoImpl implements SysUserDao {
	@Autowired
	private SysUserMapper mapper;
	public void add(SysUser user) {
		mapper.add(user);

	}
	public void update(SysUser user) {
		mapper.update(user);
		// TODO Auto-generated method stub
		
	}
	public SysUser findById(long uid) {
		return mapper.findById(uid);
	}
	public List findByName(SysUser user) {
		return mapper.findByName(user);
	}
	public List findByNameAndPwd(SysUser user) {
		return mapper.findByNameAndPwd(user);
	}
	


}
