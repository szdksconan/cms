package com.cms.dao.maoyi.enterprise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.dao.maoyi.enterprise.UserEnterDao;
import com.cms.mapper.maoyi.UserEnterMapper;

@Repository
public class UserEnterDaoImpl implements UserEnterDao {

	@Autowired
	private UserEnterMapper userEnterMapper;
	//根据用户id拿到企业id
	public Long getEnterId(Long id) {
		return userEnterMapper.getEnterId(id);
	}

}
