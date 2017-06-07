package com.cms.model.maoyi;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品图片
 * @author My
 *
 */

public class CmsImages implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private String imgId; //id
	private String productId; //产品ID
    private String brandId;//
    private String imgUrl;//文件或图片的地址
    private Integer imgType;//类型（图片，文字，doc，其他）1:缩略图
    private Integer imgOrder;//图片排列顺序，主要是针对从图多图的情况
    private Date imgCreateTime;//图片创建时间
    private Integer imgCreator;//图片创建者
    private Integer imgStatus;//图片状态（启用，停用，禁用）
    private String isMain;
    private String memo;
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getImgType() {
		return imgType;
	}
	public void setImgType(Integer imgType) {
		this.imgType = imgType;
	}
	public Integer getImgOrder() {
		return imgOrder;
	}
	public void setImgOrder(Integer imgOrder) {
		this.imgOrder = imgOrder;
	}
	
	public Date getImgCreateTime() {
		return imgCreateTime;
	}
	public void setImgCreateTime(Date imgCreateTime) {
		this.imgCreateTime = imgCreateTime;
	}
	
	public Integer getImgCreator() {
		return imgCreator;
	}
	public void setImgCreator(Integer imgCreator) {
		this.imgCreator = imgCreator;
	}
	public Integer getImgStatus() {
		return imgStatus;
	}
	public void setImgStatus(Integer imgStatus) {
		this.imgStatus = imgStatus;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

    
}
