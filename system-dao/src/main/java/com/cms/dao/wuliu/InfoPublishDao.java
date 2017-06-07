package com.cms.dao.wuliu;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.model.util.Grid;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.HuoyuanBean;

public interface InfoPublishDao {
    /**
     * 新增货源
     * @param bean
     * @throws Exception
     */
	public void addHuoyuan(HuoyuanBean bean)throws Exception;

    /**
     * 新增车源
     * @param bean
     * @throws Exception
     */
	public void addCheyuan(CheyuanBean bean);

    /**
     * 获取历史记录
     * @param map
     * @return
     */
	public Grid getHistoryList(Map map);

    /**
     * 重新发布
     * @param map
     * @throws Exception
     */
	public void updateRePublish(Map map)throws Exception;

    /**
     * 车源货源关系操作
     * @param map
     * @throws Exception
     */
    public void updateconfirm(Map map)throws Exception;

    /**
     * 获取确认信息列
     * @param map
     * @return
     */
    public List<Map> showRelationList(Map map);

    /**
     * 货源中写入车源id
     * @param map
     */
    public void updateHuoyuanCheyuanId(Map map);

    /**
     * 车源中写入货源id
     * @param map
     */
    public void updateCheyuanHuoyuanId(Map map);

    /**
     * 删除信息
     * @param map
     */
    public void delInfo(Map map)throws Exception;

    /**
     * 保存常用地址
     * @param map
     */
    public void saveAddress(Map map);

    /**
     * 获取地址
     * @param map
     * @return
     */
    public List<Map> getUserAddress(Map map);

    /**
     * 删除地址
     * @param map
     * @throws Exception
     */
    public void deleteAdd(Map map)throws Exception;

    /**
     * 货源推送到物流平台
     * @param map
     * @throws Exception
     */
    public void updatePlatformLogistics(Map map)throws Exception;

    /**
     * 获取主要路线
     * @return
     */
    public Map getMainLine(Map map);

    /**
     * 获取最近车辆所属车源
     * @param map
     * @return
     */
    public Integer getLastCheyuanCot(Map map);
    
    /**
     * 得到车辆的发布信息记录跳水
     */
    public Integer getLastCheyuanCot2(Map map);
}
