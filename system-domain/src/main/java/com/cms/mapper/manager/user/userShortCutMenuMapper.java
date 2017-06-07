package com.cms.mapper.manager.user;

import java.util.List;

import com.cms.model.manager.userShortcutMenuBean;

public interface userShortCutMenuMapper {
	public List<userShortcutMenuBean> treeGrid(Long userId);
	
	public void delete(Long id);
	
	public void add(userShortcutMenuBean bean);
	
}
