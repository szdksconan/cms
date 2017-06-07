package com.cms.service.xiaofei.logon;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXUserMsgDao;
import com.cms.iservice.xiaofei.CmsXUserMsgService;
import com.cms.model.xiaofei.CmsXUserMsg;
import com.cms.model.xiaofei.DataList;

public class CmsXUserMsgServiceImpl implements CmsXUserMsgService {
	@Autowired
	private CmsXUserMsgDao cmsXUserMsgDao;

	/**
	 * 添加消息信息
	 */
	public boolean addCmsXUserMsgInfo(CmsXUserMsg cmsXUserMsg) {
		if(cmsXUserMsg!=null){
			return this.cmsXUserMsgDao.addCmsXUserMsgInfo(cmsXUserMsg);
		}
		return false;
	}

	/**
	 * 根据用户Id查询未读取的消息
	 */
	public DataList selectUserByIdGetUserMsgAllInfo(String uId, Integer page, Integer pageSize) {
		DataList data = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uId", uId);
		map.put("page", page);
		map.put("pageSize", pageSize);
		data.setListData(this.cmsXUserMsgDao.selectUserByIdGetUserMsgAllInfo(map));
		data.setSize(this.cmsXUserMsgDao.selectUserByIdGetUserMsgAllInfoSize(map));
		return data;
	}

	/**
	 * 根据用户Id查询已读取的消息
	 */
	public DataList selectGetUserByIdGetUserMsgAllInfo(String uId, Integer page, Integer pageSize) {
		DataList data = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uId", uId);
		map.put("page", page);
		map.put("pageSize", pageSize);
		data.setListData(this.cmsXUserMsgDao.selectGetUserByIdGetUserMsgAllInfo(map));
		data.setSize(this.cmsXUserMsgDao.selectGetUserByIdGetUserMsgAllInfoSize(map));
		return data;
	}

}
