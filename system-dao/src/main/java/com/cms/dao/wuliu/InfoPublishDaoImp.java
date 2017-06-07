package com.cms.dao.wuliu;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.wuliu.InfoPublishMapper;
import com.cms.model.util.Grid;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.HuoyuanBean;

@Component
public class InfoPublishDaoImp implements InfoPublishDao {
	@Autowired
	private InfoPublishMapper infoPublishMapper;

    /**
     * 新增货源
     * @param bean
     * @throws Exception
     */
	public void addHuoyuan(HuoyuanBean bean)throws Exception {
		this.infoPublishMapper.addHuoyuan(bean);
	}

    /**
     * 新增车源
     * @param bean
     * @throws Exception
     */
	public void addCheyuan(CheyuanBean bean) {
        this.infoPublishMapper.addCheyuan(bean);
	}

    /**
     * 获取历史记录
     * @param map
     * @return
     */
	public Grid getHistoryList(Map map) {
		Grid grid = new Grid();
        List list = this.infoPublishMapper.getHistoryList(map);
		grid.setRows(list);
		grid.setTotal(list.size());
		return grid;
	}

    /**
     * 重新发布
     * @param map
     * @throws Exception
     */
	public void updateRePublish(Map map) throws Exception {
		this.infoPublishMapper.updateRePublish(map);
	}

    /**
     * 车源货源关系操作
     * @param map
     * @throws Exception
     */
    public void updateconfirm(Map map) throws Exception {
        this.infoPublishMapper.updateconfirm(map);
    }

    /**
     * 获取确认信息列
     * @param map
     * @return
     */
    public List<Map> showRelationList(Map map) {
        return  this.infoPublishMapper.showRelationList(map);
    }

    /**
     * 货源中写入车源id
     * @param map
     */
    public void updateHuoyuanCheyuanId(Map map) {
        this.infoPublishMapper.updateHuoyuanCheyuanId(map);
    }

    /**
     * 车源中写入货源id
     * @param map
     */
    public void updateCheyuanHuoyuanId(Map map) {
        this.infoPublishMapper.updateCheyuanHuoyuanId(map);
    }

    /**
     * 删除信息
     * @param map
     */
    public void delInfo(Map map) throws Exception {
        this.infoPublishMapper.delInfo(map);
    }

    /**
     * 保存常用地址
     * @param map
     */
    public void saveAddress(Map map) {
        this.infoPublishMapper.saveAddress(map);
    }

    /**
     * 获取地址
     * @param map
     * @return
     */
    public List<Map> getUserAddress(Map map) {
        return this.infoPublishMapper.getUserAddress(map);
    }

    /**
     * 删除地址
     * @param map
     * @throws Exception
     */
    public void deleteAdd(Map map) throws Exception {
        this.infoPublishMapper.deleteAdd(map);
    }

    public void updatePlatformLogistics(Map map) throws Exception {
        this.infoPublishMapper.updatePlatformLogistics(map);
    }

    public Map getMainLine(Map map) {
        return this.infoPublishMapper.getMainLine(map);
    }

    public Integer getLastCheyuanCot(Map map) {
        return this.infoPublishMapper.getLastCheyuanCot(map);
    }
    
    public Integer getLastCheyuanCot2(Map map) {
        return this.infoPublishMapper.getLastCheyuanCot2(map);
    }
}
