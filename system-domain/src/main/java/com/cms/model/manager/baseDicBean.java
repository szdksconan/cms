package com.cms.model.manager;

import java.io.Serializable;

public class baseDicBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Long pid;

    private String dicno;

    private String tag;
    
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getDicno() {
        return dicno;
    }

    public void setDicno(String dicno) {
        this.dicno = dicno == null ? null : dicno.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    
}