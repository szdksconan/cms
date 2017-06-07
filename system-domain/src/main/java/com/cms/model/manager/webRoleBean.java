package com.cms.model.manager;

public class webRoleBean implements java.io.Serializable {

	
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;

	private String id;
	private String name;        //角色名称
	private Integer seq;        //排序号
	private Integer isDefault;  //是否默认 0默认 1非默认
	private Integer status;     //状态
	private String description; //备注
	
	private String accessIds;

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

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public String getAccessIds() {
		return accessIds;
	}

	public void setAccessIds(String accessIds) {
		this.accessIds = accessIds;
	}
}
