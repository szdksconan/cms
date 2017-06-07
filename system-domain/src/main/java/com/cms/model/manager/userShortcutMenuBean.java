package com.cms.model.manager;

public class userShortcutMenuBean implements java.io.Serializable {


	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
	private Long id;
	private Long userId; // 用户id
	private Long accessMenuId; //菜单id
	private String accessMenuName;//菜单名称
	private String accessMenuUrl;//快捷菜单访问地址
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getAccessMenuId() {
		return accessMenuId;
	}
	public void setAccessMenuId(Long accessMenuId) {
		this.accessMenuId = accessMenuId;
	}
	public String getAccessMenuName() {
		return accessMenuName;
	}
	public void setAccessMenuName(String accessMenuName) {
		this.accessMenuName = accessMenuName;
	}
	public String getAccessMenuUrl() {
		return accessMenuUrl;
	}
	public void setAccessMenuUrl(String accessMenuUrl) {
		this.accessMenuUrl = accessMenuUrl;
	}
	
}
