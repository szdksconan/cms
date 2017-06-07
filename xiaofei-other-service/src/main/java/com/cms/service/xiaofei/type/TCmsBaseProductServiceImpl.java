package com.cms.service.xiaofei.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.type.TCmsBaseProductDao;
import com.cms.iservice.xiaofei.type.TCmsBaseProductService;
import com.cms.model.elasticsearch.cm.PageProduce;
import com.cms.model.xiaofei.type.TCmsBaseProduct;

public class TCmsBaseProductServiceImpl implements TCmsBaseProductService {
	@Autowired
	private TCmsBaseProductDao tCmsBaseProductDao;

	public List<Map<String, Object>> getProductLevelById() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		TCmsBaseProduct cmsBaseProduct = tCmsBaseProductDao.getProductLevel1ById();
		List<Map<String, Object>> list1 = this.tCmsBaseProductDao.getProductLevel2ById(cmsBaseProduct.getId());
		list.addAll(list1);
		return list;
	}

	public List<Map<String, Object>> getProductCodeOrderAsc(@Param("code")String code,@Param("codes")String codes) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		if(code!=null&&codes!=null){
			List<Map<String, Object>> list2 = this.tCmsBaseProductDao.getProductCodeOrderAsc(code, codes);
			list.addAll(list2);
		}
		return list;
	}

	public List<Map<String, Object>> getProduct2LevelById(String id) {
		// TODO Auto-generated method stub
		return this.tCmsBaseProductDao.getProduct2LevelById(id);
	}

	public List<Map<String, Object>> getProduct3LevelById(String id) {
		// TODO Auto-generated method stub
		return this.tCmsBaseProductDao.getProduct3LevelById(id);
	}
	public List<Map<String, Object>> industry(String industryId, Integer start, Integer pagesize,Integer type){
		
		
		
		return this.tCmsBaseProductDao.industry(industryId,start,pagesize, type);
		
	}

	/**
	 * 查询单位
	 * 作者： 郑泽
	 * 日期：2016年6月6日
	 * @return
	 */
	public List<Map<String, Object>> selectGetUnit() {
		// TODO Auto-generated method stub
		return this.tCmsBaseProductDao.selectGetUnit();
	}
}
