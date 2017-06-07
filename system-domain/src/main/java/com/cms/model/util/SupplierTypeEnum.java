package com.cms.model.util;

public enum SupplierTypeEnum {
	//1 表示供应商关系
	//2 表示供应商类型
	hezuo("合作中",0,1),
	zijian("自荐",1,1),
	guanzhu("关注",2,1),
	shengchanshang("生产商",0,2),
	maoyishang("贸易商",1,2)
	;
	private String name;
	private Integer code;
    private int teamId;
    
	private SupplierTypeEnum(String name, Integer code, int teamId) {
		this.name = name;
		this.code = code;
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	
}
