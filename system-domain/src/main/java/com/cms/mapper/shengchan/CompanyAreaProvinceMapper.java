package com.cms.mapper.shengchan;

import com.cms.model.shengchang.CompanyAreaProvince;

public interface CompanyAreaProvinceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_province
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String aapid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_province
     *
     * @mbggenerated
     */
    int insert(CompanyAreaProvince record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_province
     *
     * @mbggenerated
     */
    int insertSelective(CompanyAreaProvince record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_province
     *
     * @mbggenerated
     */
    CompanyAreaProvince selectByPrimaryKey(String aapid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_province
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CompanyAreaProvince record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_province
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CompanyAreaProvince record);
}