package com.cms.model.dict;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuxin on 2016/4/14.
 */
public class AreaProvince implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String index;
    private List<AreaCity> city;

    public List<AreaCity> getCity() {
        return city;
    }
    public void setCity(List<AreaCity> city) {
        this.city = city;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
}
