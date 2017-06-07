package com.cms.model.elasticsearch.cm;

import java.io.Serializable;
import java.util.List;

public class PageProduce implements Serializable {

    private static final long serialVersionUID = 1L;
	private Long totalCount;
	private Integer pageSize;
	private Integer pageNum;
	private List<CmsProduceEs> records;
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public List<CmsProduceEs> getRecords() {
		return records;
	}
	public void setRecords(List<CmsProduceEs> records) {
		this.records = records;
	}
	
}
