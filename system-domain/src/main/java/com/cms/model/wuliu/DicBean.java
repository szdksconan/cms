package com.cms.model.wuliu;

import java.io.Serializable;

/**
 * Created by liuxin on 2016/2/25.
 */
public class DicBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String pid;
    private String dicno;
    private String tag;

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
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getDicno() {
        return dicno;
    }
    public void setDicno(String dicno) {
        this.dicno = dicno;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}
