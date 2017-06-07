package com.cms.model.manager;


public class menuBean implements java.io.Serializable {

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;

	private Long pid;
	private Long id;
	private String pname;
	private String name; // 名称
	private String url; // 菜单路径
	private String icon; // 图标
	private Integer seq; // 排序号
	private Integer accessType; // 资源类型, 1菜单 2按钮
	private Integer status; // 状态
	private String description; //描述
    private String createTime;//创建时间

    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public Integer getAccessType() {
		return accessType;
	}
	public void setAccessType(Integer accessType) {
		this.accessType = accessType;
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
}