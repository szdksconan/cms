package com.cms.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxin on 2016/4/4.
 */
public enum GlobalOrderTypeEnum {
    ZBD("招标单",6,1),//单据编号
    DD("订单",7,1),//单据编号
    TBD("投标单",8,1),//单据编号
    ZC("暂存",101,2),//单据状态
    FB("发布",102,2),//单据状态
    ZBZC("暂存",201,2),//招标状态
    ZBFB("发布",202,2),//招标状态
    TBZC("暂存",201,2),//投标状态
    TBFB("发布",202,2),//投标状态
    WCJY("完成交易",201,3),//交易状态
    JYZ("交易中",202,3),//交易状态
    YKP("已开票",301,4),//已开票
    WKP("未开票",302,4),//未开票
    ;

    private String name;
    private int code;
    private int teamId;

    private GlobalOrderTypeEnum(String name, int code, int teamId) {
        this.name = name;
        this.code = code;
        this.teamId=teamId;
    }

    public static List getListByTeamId(int teamId){
        List list = new ArrayList();
        for (GlobalOrderTypeEnum e:GlobalOrderTypeEnum.values()){
            if (e.getTeamId()==teamId){
                Map map = new HashMap();
                map.put("code",e.code);
                map.put("name",e.name);
                list.add(map);
            }
        }
        return list;
    }
    public static String getName(int index) {
        for (GlobalOrderTypeEnum e : GlobalOrderTypeEnum.values()) {
            if (e.getCode() == index) {
                return e.name;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public int getTeamId() {
        return teamId;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
