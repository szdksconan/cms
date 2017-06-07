package com.cms.dao.wuliu;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.wuliu.CommonMapper;
import com.cms.model.wuliu.AreaBean;
import com.cms.model.wuliu.CityBean;
import com.cms.model.wuliu.ProvinceBean;

@Component
public class CommonDaoImp implements CommonDao {
	private static Logger logger = LoggerFactory.getLogger(CommonDaoImp.class);
	@Autowired
	private CommonMapper commonMapper;

	public List<ProvinceBean> getProvince(ProvinceBean bean) {
		return this.commonMapper.getProvince(bean);
	}

	public List<Map> getArea(AreaBean bean) {
		return this.commonMapper.getArea(bean);
	}

	public List<Map> getCity(CityBean bean) {
		return this.commonMapper.getCity(bean);
	}

	public List<Map> getGoodsDicInfoList(String pid) {
		return this.commonMapper.getGoodsDicInfoList(pid);
	}

	public List<Map> getCarList(Map map) {
		return this.commonMapper.getCarList(map);
	}

    public void update_task() {
        this.commonMapper.update_taskhuoyuan();
        this.commonMapper.update_taskcheyuan();
    }

    public List<Map> getQuoteList() {
        return this.commonMapper.getQuoteList();
    }

    public List<Map> getWeightList() {
        return this.commonMapper.getWeightList();
    }

}
