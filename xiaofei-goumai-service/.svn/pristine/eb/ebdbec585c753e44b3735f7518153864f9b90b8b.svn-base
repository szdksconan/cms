package com.cms.service.xiaofei.shoppingcart;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXStoreCollectionDao;
import com.cms.iservice.xiaofei.CmsXStoreCollectionService;
import com.cms.model.xiaofei.CmsXStoreCollection;
import com.cms.model.xiaofei.DataList;

public class CmsXStoreCollectionServiceImpl implements CmsXStoreCollectionService {
	
	@Autowired
	private CmsXStoreCollectionDao cmsXStoreCollectionDao;

	/**
	 * 添加店铺收藏 
	 */
	public void addCmsXStoreCollection(CmsXStoreCollection collection) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uId", collection.getUserId());
		map.put("stId", collection.getStoreId());
		Integer list = this.cmsXStoreCollectionDao.selectAllUIdAndPIdGetInfo(map);
		if(list.equals(0)){
			this.cmsXStoreCollectionDao.addCmsXStoreCollection(collection);
		}
	}

	/**
	 * 根据用户Id查询用户收藏的店铺信息
	 */
	public DataList selectUserAndGetByIdStoreCollection(String uId, Integer page, Integer pageSize) {
		DataList data = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uId", uId);
		map.put("page", page);
		map.put("pageSize", pageSize);
		data.setListData(this.cmsXStoreCollectionDao.selectUserAndGetByIdStoreCollection(map));
		data.setSize(this.cmsXStoreCollectionDao.selectUserAndGetByIdStoreCollectionSize(map));
		return data;
	}

	/**
	 * 根据收藏Id删除对应的记录
	 */
	public boolean deleteUserStoreAndCollectionAProduce(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return this.cmsXStoreCollectionDao.deleteUserStoreAndCollectionAProduce(map);
	}

	/**
	 * 根据收藏Id取消对应的收藏记录
	 */
	public boolean updateUserStoreAndCollectionAProduce(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("state", 0);
		return this.cmsXStoreCollectionDao.updateUserStoreAndCollectionAProduce(map);
	}

}
