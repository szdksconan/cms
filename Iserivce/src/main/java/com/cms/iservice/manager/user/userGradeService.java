package com.cms.iservice.manager.user;


import com.cms.model.manager.userBean;
import com.cms.model.manager.userGradeBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;

public interface userGradeService {
	
	public Grid dataGrid(PageFilter ph);
	
	public void add(userGradeBean bean)throws Exception;
	
	public void edit(userGradeBean bean)throws Exception;
	
	public void delete(Long id)throws Exception;
	
	public userGradeBean get(Long id);
	
	public userBean getUserInfo(userBean bean);
	
	public Grid dataGrid(userBean userBean, PageFilter ph);

	public void add(userBean userBean)throws Exception;

	public void deleteuser(Long id)throws Exception;

	public userBean getuser(Long id);
	
	public void update(userBean userBean)throws Exception;
	
	public void editUserPwd(SessionInfo sessionInfo, String oldPwd, String pwd)throws Exception;
}
