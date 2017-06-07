package com.cms.iservice.manager.login;


import java.util.List;

import com.cms.model.manager.Tree;
import com.cms.model.manager.userBean;
import com.cms.model.manager.userShortcutMenuBean;
import com.cms.model.util.SessionInfo;

public interface loginService {
	public userBean login(userBean bean)throws Exception;
	
	public List<userShortcutMenuBean> treeGrid(Long userId);

	public void add(userShortcutMenuBean bean)throws Exception;

	public void delete(Long id)throws Exception;

	public List<Tree> userMenuTree(SessionInfo sessionInfo);
}
