package com.cms.service.wuliu;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.dao.wuliu.CarOnlineDao;
import com.cms.iservice.common.GlobalIdService;
import com.cms.service.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.wuliu.InfoPublishDao;
import com.cms.iservice.wuliu.InfoPublishService;
import com.cms.model.util.Grid;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.HuoyuanBean;

public class InfoPublishServiceImpl implements InfoPublishService {
	@Autowired
	private InfoPublishDao infoPublishDao;
    @Autowired
    private CarOnlineDao carOnlineDao;
    @Autowired
    private GlobalIdService globalIdService;
    /**
     * 新增货源
     * @param bean
     * @throws Exception
     */
	public String addHuoyuan(HuoyuanBean bean) throws Exception {
        bean.setId(globalIdService.getGlobalId().toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bean.setCreateTime(df.format(new Date()));
		this.infoPublishDao.addHuoyuan(bean);
        bean.setIsHall(false);
        RedisUtil.hset("chpp", "chpp:hyxx:" + bean.getId(), bean);
        return bean.getId();
	}

    /**
     * 新增车源
     * @param bean
     * @throws Exception
     */
	public String addCheyuan(CheyuanBean bean){
        bean.setId(globalIdService.getGlobalId().toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bean.setCreateTime(df.format(new Date()));
		this.infoPublishDao.addCheyuan(bean);
        JSONObject obj = new JSONObject();
        obj.put("id",bean.getCarId());
        obj.put("tag", 0);
        this.carOnlineDao.updateCarCondition(obj);
        bean.setIsHall(false);
        RedisUtil.hset("chpp","chpp:cyxx:" + bean.getId(), bean);
        return bean.getId();
	}

    /**
     * 获取历史记录
     * @return
     */
	public Grid getHistoryList(HashMap map) {
		return this.infoPublishDao.getHistoryList(map);
	}

    /**
     * 重新发布
     * @throws Exception
     */
	public void updateRePublish(HashMap map) throws Exception {
		this.infoPublishDao.updateRePublish(map);
	}

    /**
     * 车源货源关系操作
     * @throws Exception
     */
    public void updateconfirm(HashMap map) throws Exception {
        this.infoPublishDao.updateconfirm(map);
    }

    /**
     * 获取确认信息列
     * @return
     */
    public List<Map> showRelationList(HashMap map) {
        return  this.infoPublishDao.showRelationList(map);
    }


    /**
     * 车货源关系确认
     */
    public void updateRelation(HashMap map)throws Exception{
        this.infoPublishDao.updateconfirm(map);
        this.infoPublishDao.updateHuoyuanCheyuanId(map);
        this.infoPublishDao.updateCheyuanHuoyuanId(map);
        map.put("id",map.get("carId"));
        map.put("tag",1);
        this.carOnlineDao.updateCarCondition((JSONObject) JSONObject.toJSON(map));
    }

    /**
     * 删除信息
     */
    public void delInfo(HashMap map) throws Exception {
        this.infoPublishDao.delInfo(map);
    }

    /**
     * 保存常用地址
     */
    public void saveAddress(JSONObject obj)throws Exception {
        Map map = (Map) JSON.parse(obj.toJSONString());
        map.put("id",this.globalIdService.getGlobalId());
        this.infoPublishDao.saveAddress(map);
    }

    /**
     * 获取常用地址
     * @return
     */
    public List<Map> getUserAddress(JSONObject obj) {
        Map map = (Map) JSON.parse(obj.toJSONString());
        return this.infoPublishDao.getUserAddress(map);
    }

    /**
     * 删除地址
     * @throws Exception
     */
    public void deleteAdd(JSONObject obj) throws Exception {
        Map map = (Map) JSON.parse(obj.toJSONString());
        this.infoPublishDao.deleteAdd(map);
    }

    public void updatePlatformLogistics(String id) throws Exception {
        Map map = new HashMap();
        map.put("id",Long.parseLong(id));
        this.infoPublishDao.updatePlatformLogistics(map);
    }

    public Map getMainLine(HashMap map) {
        return this.infoPublishDao.getMainLine(map);
    }

    public Integer getLastCheyuanCot(HashMap map) {
        return this.infoPublishDao.getLastCheyuanCot(map);
    }
    
    public Integer getLastCheyuanCot2(HashMap map) {
        return this.infoPublishDao.getLastCheyuanCot2(map);
    }
}
