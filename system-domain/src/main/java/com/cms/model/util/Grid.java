package com.cms.model.util;

import java.util.ArrayList;
import java.util.List;

public class Grid<T> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer total = 0;
	private List<T> rows = new ArrayList();
	
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
