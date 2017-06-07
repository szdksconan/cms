package com.cms.model.util;

public class PageFilter implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer page=1;// 当前页
    private Integer pageNumber=1;//当前页
	private Integer rows=10;// 每页显示记录数
    private Integer pageSize=10;//每页显示记录数
	private String sort="id";// 排序字段
	private String order="asc";// asc/desc

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
        this.pageNumber = this.page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
        this.pageSize = this.rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        this.page=this.pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        this.rows = this.pageSize;
    }

    public String getOrderString(){
		if(page == 0){
			return " order by "+sort+" "+order+" limit 0,"+rows;
		}
		else{
			return " order by "+sort+" "+order+" limit "+((page-1)*rows)+","+rows;
		}
		
	}
	
	public String getLimit(){
		if(page == 0){
			return " limit 0,"+rows;
		}
		else{
			return " limit "+((page-1)*rows)+","+rows;
		}
	}
}
