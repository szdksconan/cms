package com.cms.model.wuliu;

import com.cms.model.util.GlobalConstant;
import com.cms.service.common.secure.AesTools;

import java.io.Serializable;

public class HuoyuanBean implements Serializable,Comparable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String goodsName;
    private String goodsType;
    private String goodsTypeName;
    private String userId;
    private Long beginProvinceId;
    private Long beginCityId;
    private Long beginAreaId;
    private Long endProvinceId;
    private Long endCityId;
    private Long endAreaId;
    private String companyName;
    private Double weight = Double.valueOf(0);
    private Double volume = Double.valueOf(0);
    private String createTime;
    private String invalidTime;
    private String state;
    private String tel="";
    private String telCipher="";
    private String tel1="";
    private String tel1Cipher="";
    private String tel2="";
    private String tel2Cipher="";
    private String goodsImg;
    private String info;
    private Integer invalidNum;
    private String linkMan;
    private String linkManCipher;
    private Double offer;
    private String garden;
    private String beginProvinceName;
    private String beginCityName;
    private String beginAreaName;
    private String endProvinceName;
    private String endCityName;
    private String endAreaName;
    private String way;
    private String companyGarden;
    private Boolean isHall = true;
    private String packageType;
    private String packageTypeName;
    private String startWay;
    private String endWay;
    private Integer provinceAreaId;
    private Long quoteRegionId;
    private Long weightRegionId;
    private Integer listType;
    private String consigneeMan;
    private String consigneeManCipher;
    private String consigneeAdd;
    private String consigneeAddCipher;
    private String consigneeTel="";
    private String consigneeTelCipher="";
    private String consigneeTel1="";
    private String consigneeTel1Cipher="";
    private String consigneeTel2="";
    private String consigneeTel2Cipher="";
    private Long vaServiceID;
    private Integer numbers;

    public Integer getNumbers() {
        return numbers;
    }
    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
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
    public String getConsigneeManCipher() {
        return consigneeManCipher;
    }
    public void setConsigneeManCipher(String consigneeManCipher) {
        this.consigneeManCipher = consigneeManCipher;
    }
    public String getConsigneeAddCipher() {
        return consigneeAddCipher;
    }
    public void setConsigneeAddCipher(String consigneeAddCipher) {
        this.consigneeAddCipher = consigneeAddCipher;
    }
    public String getConsigneeTelCipher() {
        return consigneeTelCipher;
    }
    public void setConsigneeTelCipher(String consigneeTelCipher) {
        this.consigneeTelCipher = consigneeTelCipher;
    }
    public String getConsigneeTel1Cipher() {
        return consigneeTel1Cipher;
    }
    public void setConsigneeTel1Cipher(String consigneeTel1Cipher) {
        this.consigneeTel1Cipher = consigneeTel1Cipher;
    }
    public String getConsigneeTel2Cipher() {
        return consigneeTel2Cipher;
    }
    public void setConsigneeTel2Cipher(String consigneeTel2Cipher) {
        this.consigneeTel2Cipher = consigneeTel2Cipher;
    }
    public String getConsigneeMan() {
        if (consigneeMan!=null && !"".equals(consigneeMan)){
            try {
                String str = AesTools.aesDecrypt(consigneeMan,GlobalConstant.CHPPKEY);
                return str;
            }catch (Exception e){
                return consigneeMan;
            }
        }else {
            return consigneeMan;
        }
    }
    public void setConsigneeMan(String consigneeMan) {
        this.consigneeMan = consigneeMan;
    }
    public String getConsigneeAdd() {
        if (consigneeAdd!=null && !"".equals(consigneeAdd)){
            try {
                String str = AesTools.aesDecrypt(consigneeAdd,GlobalConstant.CHPPKEY);
                return str;
            }catch (Exception e){
                return consigneeAdd;
            }
        }else {
            return consigneeAdd;
        }
    }
    public void setConsigneeAdd(String consigneeAdd) {
        this.consigneeAdd = consigneeAdd;
    }
    public String getConsigneeTel() {
        if (consigneeTel!=null && !"".equals(consigneeTel)){
            try {
                String str = AesTools.aesDecrypt(consigneeTel,GlobalConstant.CHPPKEY);
                return str;
            }catch (Exception e){
                return consigneeTel;
            }
        }else {
            return consigneeTel;
        }
    }
    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }
    public String getConsigneeTel1() {
        if (consigneeTel1!=null && !"".equals(consigneeTel1)){
            try {
                String str = AesTools.aesDecrypt(consigneeTel1,GlobalConstant.CHPPKEY);
                return str;
            }catch (Exception e){
                return consigneeTel1;
            }
        }else {
            return consigneeTel1;
        }
    }
    public void setConsigneeTel1(String consigneeTel1) {
        this.consigneeTel1 = consigneeTel1;
    }
    public String getConsigneeTel2() {
        if (consigneeTel2!=null && !"".equals(consigneeTel2)){
            try {
                String str = AesTools.aesDecrypt(consigneeTel2,GlobalConstant.CHPPKEY);
                return str;
            }catch (Exception e){
                return consigneeTel2;
            }
        }else {
            return consigneeTel2;
        }
    }
    public void setConsigneeTel2(String consigneeTel2) {
        this.consigneeTel2 = consigneeTel2;
    }
    public Integer getListType() {
        return listType;
    }
    public void setListType(Integer listType) {
        this.listType = listType;
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
    public String getEndWay() {
        return endWay;
    }
    public void setEndWay(String endWay) {
        this.endWay = endWay;
    }
    public String getStartWay() {
        return startWay;
    }
    public void setStartWay(String startWay) {
        this.startWay = startWay;
    }
    public String getPackageType() {
        return packageType;
    }
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
    public String getPackageTypeName() {
        return packageTypeName;
    }
    public void setPackageTypeName(String packageTypeName) {
        this.packageTypeName = packageTypeName;
    }
    public Boolean getIsHall() {
        return isHall;
    }
    public void setIsHall(Boolean isHall) {
        this.isHall = isHall;
    }
    public String getGoodsTypeName() {
        return goodsTypeName;
    }
    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }
    public String getCompanyGarden() {
        return companyGarden;
    }
    public void setCompanyGarden(String companyGarden) {
        this.companyGarden = companyGarden;
    }
    public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
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
	public String getGarden() {
		return garden;
	}
	public void setGarden(String garden) {
		this.garden = garden;
	}
	public Double getOffer() {
		return offer;
	}
	public void setOffer(Double offer) {
		this.offer = offer;
	}
	public String getLinkMan() {
        if (linkMan!=null && !"".equals(linkMan)){
            try {
                String str = AesTools.aesDecrypt(linkMan,GlobalConstant.CHPPKEY);
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
	public Integer getInvalidNum() {
		return invalidNum;
	}
	public void setInvalidNum(Integer invalidNum) {
		this.invalidNum = invalidNum;
	}
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }
    public String getGoodsType() {
        return goodsType;
    }
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
    	if (weight==0 && getVolume()!=null && getVolume()!=0){
    		this.weight = getVolume()/3.5;
    	}else {
    		this.weight = weight;
    	}
    }
    public Double getVolume() {
        return volume;
    }
    public void setVolume(Double volume) {
        this.volume = volume;
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
        this.state = state == null ? null : state.trim();
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
        this.tel = tel == null ? null : tel.trim();
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
        this.tel1 = tel1 == null ? null : tel1.trim();
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
        this.tel2 = tel2 == null ? null : tel2.trim();
    }
    public String getGoodsImg() {
        return goodsImg;
    }
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    private Integer orderNum;
    public Integer getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public int compareTo(Object o) {
        HuoyuanBean bean = (HuoyuanBean) o;
        if (this.orderNum==null || bean.orderNum==null){
            return 0;
        }
        if (this.id.equals(bean.id)){
            return 0;
        }
        return this.orderNum-bean.orderNum;
    }

    public boolean equals(Object o){
        if (o instanceof HuoyuanBean){
            HuoyuanBean bean = (HuoyuanBean) o;
            return id.equals(bean.getId());
        }
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }
}