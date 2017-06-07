package com.cms.service.manager.basicinfo;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.basicinfo.IndustryDao;
import com.cms.iservice.basicinfo.IndustryService;
import com.cms.model.basicinfo.IndustryEntity;

/**
 * 获取数据调用getIndustrys方法,然后转成json传到前台，其他方法请自行维护
 * @author zby
 */
public class IndustryServiceImp implements IndustryService{
	@Autowired
	private IndustryDao industryDao;

	@Override
	public String saveIndustry(Map<String, Object> map) {
		return industryDao.saveIndustry(map);
	}

	@Override
	public String deleteIndustry(String[] ids) {
		return industryDao.deleteIndustry(ids);
	}

	@Override
	public JSONObject getIndustrys(Map<String, Object> map) {
		JSONObject json = new JSONObject();
		json.put("result", industryDao.getIndustrys(map));
		return json;
	}

	@Override
	public IndustryEntity getIndustryByID(Map<String, Object> map) {
		return industryDao.getIndustryByID(map);
	}

}
