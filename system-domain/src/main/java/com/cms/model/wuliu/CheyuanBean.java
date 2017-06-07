package com.cms.model.wuliu;

import com.cms.model.util.GlobalConstant;
import com.cms.service.common.secure.AesTools;

import java.io.Serializable;

/**
 * 车源bean
 * @author 刘鑫
 *
 */
public class CheyuanBean implements Serializable,Comparable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userId;
	private String carId;
	private String info;
	private String createTime;
	private String invalidTime;
	private String state;
	private String createUser;
	private String tel;
	private String telCipher;
	private String tel1;
	private String tel1Cipher;
	private String tel2;
	private String tel2Cipher;
	private String linkMan;
	private String linkManCipher;
	private Integer invalidNum;
	private String carImg;
	private String startName;
	private String endName;
	private String way;
	private Long beginProvinceId;
    private Long beginCityId;
    private Long beginAreaId;
    private Long endProvinceId;
    private Long endCityId;
    private Long endAreaId;
    private String beginProvinceName;
    private String beginCityName;
    private String beginAreaName;
    private String endProvinceName;
    private String endCityName;
    private String endAreaName;
    private String carNo;
    private String carOwner;
    private Double length;
    private Double weight;
    private Double volume;
    private Double offer;
    private String car_axle_id;
    private String car_container_id;
    private String car_axle_name;
    private String car_container_name;
    private Boolean isHall = true;
    private String startWay;
    private String endWay;
    private Integer provinceAreaId;
    private Long quoteRegionId;
    private Long weightRegionId;
    private String carTrafficTypeId;
    private String carTrafficTypeName;
    private Integer trafficType=0;
    private String carTypeId;
    private String carTypeName;
    private Integer listType;
    private String companyName;
    private String trafficTypeName;
    private Long vaServiceID;

    public Long getVaServiceID() {
        return vaServiceID;
    }
    public void setVaServiceID(Long vaServiceID) {
        this.vaServiceID = vaServiceID;
    }
    public String getTelCipher() {
        return telCipher;
    }
    public void setTelCipher(String telCipher) {
        this.telCipher = telCipher;
    }
    public String getTel1Cipher() {
        return tel1Cipher;
    }
    public void setTel1Cipher(String tel1Cipher) {
        this.tel1Cipher = tel1Cipher;
    }
    public String getTel2Cipher() {
        return tel2Cipher;
    }
    public void setTel2Cipher(String tel2Cipher) {
        this.tel2Cipher = tel2Cipher;
    }
    public String getLinkManCipher() {
        return linkManCipher;
    }
    public void setLinkManCipher(String linkManCipher) {
        this.linkManCipher = linkManCipher;
    }
    public String getTrafficTypeName() {
        return trafficTypeName;
    }
    public void setTrafficTypeName(String trafficTypeName) {
        this.trafficTypeName = trafficTypeName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Integer getListType() {
        return listType;
    }
    public void setListType(Integer listType) {
        this.listType = listType;
    }
    public String getCarTrafficTypeId() {
        return carTrafficTypeId;
    }
    public void setCarTrafficTypeId(String carTrafficTypeId) {
        this.carTrafficTypeId = carTrafficTypeId;
    }
    public String getCarTrafficTypeName() {
        return carTrafficTypeName;
    }
    public void setCarTrafficTypeName(String carTrafficTypeName) {
        this.carTrafficTypeName = carTrafficTypeName;
    }
    public Integer getTrafficType() {
        return trafficType;
    }
    public void setTrafficType(Integer trafficType) {
        this.trafficType = trafficType;
    }
    public String getCarTypeId() {
        return carTypeId;
    }
    public void setCarTypeId(String carTypeId) {
        this.carTypeId = carTypeId;
    }
    public String getCarTypeName() {
        return carTypeName;
    }
    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }
    public String getCar_axle_name() {
        return car_axle_name;
    }
    public void setCar_axle_name(String car_axle_name) {
        this.car_axle_name = car_axle_name;
    }
    public String getCar_container_name() {
        return car_container_name;
    }
    public void setCar_container_name(String car_container_name) {
        this.car_container_name = car_container_name;
    }
    public Long getWeightRegionId() {
        return weightRegionId;
    }
    public void setWeightRegionId(Long weightRegionId) {
        this.weightRegionId = weightRegionId;
    }
    public Long getQuoteRegionId() {
        return quoteRegionId;
    }
    public void setQuoteRegionId(Long quoteRegionId) {
        this.quoteRegionId = quoteRegionId;
    }
    public Integer getProvinceAreaId() {
        return provinceAreaId;
    }
    public void setProvinceAreaId(Integer provinceAreaId) {
        this.provinceAreaId = provinceAreaId;
    }
    public String getStartWay() {
        return startWay;
    }
    public void setStartWay(String startWay) {
        this.startWay = startWay;
    }
    public String getEndWay() {
        return endWay;
    }
    public void setEndWay(String endWay) {
        this.endWay = endWay;
    }
    public Boolean getIsHall() {
        return isHall;
    }
    public void setIsHall(Boolean isHall) {
        this.isHall = isHall;
    }
    public String getCar_axle_id() {
        return car_axle_id;
    }
    public void setCar_axle_id(String car_axle_id) {
        this.car_axle_id = car_axle_id;
    }
    public String getCar_container_id() {
        return car_container_id;
    }
    public void setCar_container_id(String car_container_id) {
        this.car_container_id = car_container_id;
    }
    public Double getOffer() {
		return offer;
	}
	public void setOffer(Double offer) {
		this.offer = offer;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public Long getBeginProvinceId() {
		return beginProvinceId;
	}
	public void setBeginProvinceId(Long beginProvinceId) {
		this.beginProvinceId = beginProvinceId;
	}
	public Long getBeginCityId() {
		return beginCityId;
	}
	public void setBeginCityId(Long beginCityId) {
		this.beginCityId = beginCityId;
	}
	public Long getBeginAreaId() {
		return beginAreaId;
	}
	public void setBeginAreaId(Long beginAreaId) {
		this.beginAreaId = beginAreaId;
	}
	public Long getEndProvinceId() {
		return endProvinceId;
	}
	public void setEndProvinceId(Long endProvinceId) {
		this.endProvinceId = endProvinceId;
	}
	public Long getEndCityId() {
		return endCityId;
	}
	public void setEndCityId(Long endCityId) {
		this.endCityId = endCityId;
	}
	public Long getEndAreaId() {
		return endAreaId;
	}
	public void setEndAreaId(Long endAreaId) {
		this.endAreaId = endAreaId;
	}
	public String getBeginProvinceName() {
		return beginProvinceName;
	}
	public void setBeginProvinceName(String beginProvinceName) {
		this.beginProvinceName = beginProvinceName;
	}
	public String getBeginCityName() {
		return beginCityName;
	}
	public void setBeginCityName(String beginCityName) {
		this.beginCityName = beginCityName;
	}
	public String getBeginAreaName() {
		return beginAreaName;
	}
	public void setBeginAreaName(String beginAreaName) {
		this.beginAreaName = beginAreaName;
	}
	public String getEndProvinceName() {
		return endProvinceName;
	}
	public void setEndProvinceName(String endProvinceName) {
		this.endProvinceName = endProvinceName;
	}
	public String getEndCityName() {
		return endCityName;
	}
	public void setEndCityName(String endCityName) {
		this.endCityName = endCityName;
	}
	public String getEndAreaName() {
		return endAreaName;
	}
	public void setEndAreaName(String endAreaName) {
		this.endAreaName = endAreaName;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getStartName() {
		return startName;
	}
	public void setStartName(String startName) {
		this.startName = startName;
	}
	public String getEndName() {
		return endName;
	}
	public void setEndName(String endName) {
		this.endName = endName;
	}
	public String getCarImg() {
		return carImg;
	}
	public void setCarImg(String carImg) {
		this.carImg = carImg;
	}
	public Integer getInvalidNum() {
		return invalidNum;
	}
	public void setInvalidNum(Integer invalidNum) {
		this.invalidNum = invalidNum;
	}
	public String getLinkMan() {
        if (linkMan!=null && !"".equals(linkMan)){
            try {
                String str = AesTools.aesDecrypt(linkMan, GlobalConstant.CHPPKEY);
                return str;
            }catch (Exception e){
                return linkMan;
            }
        }else {
            return linkMan;
        }
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getInvalidTime() {
		return invalidTime;
	}
	public void setInvalidTime(String invalidTime) {
		this.invalidTime = invalidTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getTel() {
        if (tel!=null && !"".equals(tel)){
            try {
                String str = AesTools.aesDecrypt(tel,GlobalConstant.CHPPKEY);
                return str;
            }catch (Exception e){
                return tel;
            }
        }else {
            return tel;
        }
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel1() {
        if (tel1!=null && !"".equals(tel1)){
            try {
                String str = AesTools.aesDecrypt(tel1,GlobalConstant.CHPPKEY);
                return str;
            }catch (Exception e){
                return tel1;
            }
        }else {
            return tel1;
        }
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
        if (tel2!=null && !"".equals(tel2)){
            try {
                String str = AesTools.aesDecrypt(tel2,GlobalConstant.CHPPKEY);
                return str;
            }catch (Exception e){
                return tel2;
            }
        }else {
            return tel2;
        }
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

    private Integer orderNum;
    public Integer getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public int compareTo(Object o) {
        CheyuanBean bean = (CheyuanBean) o;
        if (this.orderNum==null || bean.orderNum==null){
            return 0;
        }
        if (this.id.equals(bean.id)){
            return 0;
        }
        return this.orderNum-bean.orderNum;
    }

    public boolean equals(Object o){
        if (o instanceof CheyuanBean){
            CheyuanBean bean = (CheyuanBean) o;
            return id.equals(bean.getId());
        }
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }
}
