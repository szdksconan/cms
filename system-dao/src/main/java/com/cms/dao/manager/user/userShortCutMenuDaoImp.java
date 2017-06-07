package com.cms.dao.manager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.manager.user.userShortCutMenuMapper;
import com.cms.model.manager.userShortcutMenuBean;

@Component

public class userShortCutMenuDaoImp implements userShortCutMenuDao {
	
	@Autowired
	private userShortCutMenuMapper userShortCutMenuMapper;

	public List<userShortcutMenuBean> treeGrid(Long userId) {
	
		return this.userShortCutMenuMapper.treeGrid(userId);
	}

	public void delete(Long id) {
		
		this.userShortCutMenuMapper.delete(id);
		
	}

	public void add(userShortcutMenuBean bean) {
		
		this.userShortCutMenuMapper.add(bean);
		
	}

}
