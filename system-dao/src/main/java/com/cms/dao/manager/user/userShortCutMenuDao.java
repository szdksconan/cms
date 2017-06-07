package com.cms.dao.manager.user;

import java.util.List;

import com.cms.model.manager.userShortcutMenuBean;

public interface userShortCutMenuDao {
	public List<userShortcutMenuBean> treeGrid(Long userId);
	
	public void delete(Long id);
	
	public void add(userShortcutMenuBean bean);
	
}
