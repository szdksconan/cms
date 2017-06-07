package com.cms.model.manager;

public class departmentBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String iconCls;
	private Long pid; //父级ID
	private String pname;//父级名称
	
	private Long id;
	private String code;    //编码
	private String name;    //部门名称
	private String icon = "icon_folder";    //默认图标
	private Integer seq;    //排序号
	private Integer status; //状态 0启用 1停用
	private String createTime;//创建时间
	private String description; //描述
	private Long subcompanyId;
	private String subcompanyName;
	
	public Long getSubcompanyId() {
		return subcompanyId;
	}

	public void setSubcompanyId(Long subcompanyId) {
		this.subcompanyId = subcompanyId;
	}

	public String getSubcompanyName() {
		return subcompanyName;
	}

	public void setSubcompanyName(String subcompanyName) {
		this.subcompanyName = subcompanyName;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
