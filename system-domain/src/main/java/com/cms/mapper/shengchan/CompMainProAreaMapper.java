package com.cms.mapper.shengchan;

import com.cms.model.shengchang.CompMainProArea;

public interface CompMainProAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comp_main_pro_area
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comp_main_pro_area
     *
     * @mbggenerated
     */
    int insert(CompMainProArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comp_main_pro_area
     *
     * @mbggenerated
     */
    int insertSelective(CompMainProArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comp_main_pro_area
     *
     * @mbggenerated
     */
    CompMainProArea selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comp_main_pro_area
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CompMainProArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comp_main_pro_area
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CompMainProArea record);
}