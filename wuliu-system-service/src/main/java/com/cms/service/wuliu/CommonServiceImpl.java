package com.cms.service.wuliu;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.dao.wuliu.CommonDao;
import com.cms.iservice.wuliu.CommonService;
import com.cms.model.wuliu.AreaBean;
import com.cms.model.wuliu.CityBean;
import com.cms.model.wuliu.ProvinceBean;

public class CommonServiceImpl implements CommonService {
	private static Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
	@Autowired
	private CommonDao commonDao;

	public List<ProvinceBean> getProvince(ProvinceBean bean) {
		return this.commonDao.getProvince(bean);
	}

	public List<Map> getArea(AreaBean bean) {
		return this.commonDao.getArea(bean);
	}

	public List<Map> getCity(CityBean bean) {
		return this.commonDao.getCity(bean);
	}

	public List<Map> getGoodsDicInfoList(String pid) {
		return this.commonDao.getGoodsDicInfoList(pid);
	}

	public List<Map> getCarList(JSONObject obj) {
		Map map = (Map) JSON.parse(obj.toString());
		return this.commonDao.getCarList(map);
	}

    /**
     * 定时任务：更新信息过期状态
     */
    public void update_task() {
        this.commonDao.update_task();
    }

    public List<Map> getQuoteList() {
        return this.commonDao.getQuoteList();
    }

    public List<Map> getWeightList() {
        return this.commonDao.getWeightList();
    }
}
