package com.cms.service.xiaofei.collect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXProduceCollectDao;
import com.cms.iservice.xiaofei.CmsXProduceCollectService;
import com.cms.model.xiaofei.CmsXProduceCollect;
import com.cms.model.xiaofei.DataList;

public class CmsXProduceCollectServiceImpl implements CmsXProduceCollectService {
	@Autowired
	private CmsXProduceCollectDao cmsXProduceCollectDao;

	/**
	 * 添加商品到收藏
	 */
	public void addGoodsToCollect(CmsXProduceCollect cmsXProduceCollect) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uId", cmsXProduceCollect.getUserId());
		map.put("pId", cmsXProduceCollect.getProductId());
		Integer list = this.cmsXProduceCollectDao.selectAllUIdAndPIdGetInfo(map);
		if(list.equals(0)){
			this.cmsXProduceCollectDao.addGoodsToCollect(cmsXProduceCollect);
		}
	}

	/**
	 * 根据产品Id查询收藏数量
	 */
	public Integer selectAllCollectionNumber(@Param("pId")String pId) {
		// TODO Auto-generated method stub
		return this.cmsXProduceCollectDao.selectAllCollectionNumber(pId);
	}

	/**
	 * 根据用户ID查看收藏的产品
	 */
	public DataList selectAllCollectionUserGetById(String uId, Integer page, Integer pageSize) {
		DataList data = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uId", uId);
		map.put("page", page);
		map.put("pageSize", pageSize);
		data.setListData(this.cmsXProduceCollectDao.selectAllCollectionUserGetById(map));
		data.setSize(this.cmsXProduceCollectDao.selectAllCollectionUserGetByIdSize(map));
		return data;
	}

	/**
	 * 根据收藏Id删除对应的记录
	 */
	public boolean deleteUserAndCollectionAProduce(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return this.cmsXProduceCollectDao.deleteUserAndCollectionAProduce(map);
	}

	/**
	 * 根据收藏Id取消对应的收藏记录
	 */
	public boolean updateUserAndCollectionAProduce(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("state", 0);
		return this.cmsXProduceCollectDao.updateUserAndCollectionAProduce(map);
	}

}
