package com.cms.dao.manager.baseInfo;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.AreaBean;
import com.cms.mapper.manager.baseInfo.areaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class areaDalImp implements areaDao{
    @Autowired
    private areaMapper areaMapper;

    public AreaBean getInfo(AreaBean bean) {
        return this.areaMapper.getInfo(bean);
    }

    public List<AreaBean> dataGrid(JSONObject obj) {
        return this.areaMapper.dataGrid(obj);
    }

    public int dataGridCot(JSONObject obj) {
        return this.areaMapper.dataGridCot(obj);
    }

    public void add(AreaBean areaBean) {
        this.areaMapper.add(areaBean);
    }

    public void delete(JSONObject obj) {
        this.areaMapper.delete(obj);
    }

    public AreaBean get(String obj) {
        return this.areaMapper.get(obj);
    }

    public void edit(AreaBean areaBean) {
        this.areaMapper.edit(areaBean);
    }

    public List<AreaBean> selectAreaJson(JSONObject obj) {
        return this.areaMapper.selectAreaJson(obj);
    }
}
