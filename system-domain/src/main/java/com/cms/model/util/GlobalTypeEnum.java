package com.cms.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxin on 2016/4/4.
 */
public enum GlobalTypeEnum {
    IMG("文件类型-图片",101,1),
    TXT("文件类型-文本",102, 1),
    DOC("文件类型-文档",103, 1),

    HOLD("暂存",201, 2),//产品状态
    NORMALSELL("正常销售",202, 2),//产品状态

    JINGXIAO("经销",301, 3),//销售类型
    DAIXIAO("代销",302, 3),//销售类型

    XFHK("先款后货",401, 4),//付款方式
    HDFK("货到付款",402, 4),//付款方式

    UNSHELVE("下架",501, 5),//产品状态
    DEL("删除",502, 5),//产品状态

    WZQY("外资企业",601, 6),//企业性质
    GYQY("国有企业",602, 6),//企业性质
    HZQY("合资企业",603, 6),//企业性质
    MYQY("私营企业",604, 6),//企业性质
    HEZUOQY("合作企业",605, 6),//企业性质
    DZQY("独资企业",606, 6),//企业性质
    JTQY("集体企业",607, 6),//企业性质
    GTGSH("个体工商户",608, 6),//企业性质
    QT("其他",609, 6),//企业性质

    XSX("销售型",701, 7),//经营模式
    SCDGX("生产代工型",702, 7),//经营模式
    SJX("设计型",703, 7),//经营模式
    XSSJX("销售设计型",704, 7),//经营模式
    SCXSX("生产销售型",705, 7),//经营模式
    SJSCX("设计生产型",706, 7),//经营模式
    SJSCXSX("设计生产销售型",707, 7),//经营模式
    XXFWX("信息服务型",708, 7),//经营模式

    YX("优秀",801, 8),//诚信等级
    LH("良好",802, 8),//诚信等级
    ZD("中等",803, 8),//诚信等级
    BX("不限",804, 8),//诚信等级
     
    CQXQ("长期需求",34, 9),//需求类型
    NDXQ("年度需求",35, 9),//需求类型
    BNXQ("半年需求",36, 9),//需求类型
    JDXQ("季度需求",37, 9),//需求类型
    YDXQ("月度需求",38, 9),//需求类型
    LSXQ("临时需求",39, 9),//需求类型
    
    LXR1("李峰",40, 10),//联系人信息
    LXR2("刘鑫",41, 10),//联系人信息
    LXR3("周涵",42, 10),//联系人信息
    LXR4("韦天宇",43, 10),//联系人信息
    
    CP("成品",44,11),//物资类型
    BCP("半成品",45,11),//物资类型
    YCL("原材料",46,11),//物资类型
    PTJ("配套件",47,11),//物资类型



    ;

    private String name;
    private int code;
    private int teamId;

    private GlobalTypeEnum(String name, int code, int teamId) {
        this.name = name;
        this.code = code;
        this.teamId=teamId;
    }

    public static List getListByTeamId(int teamId){
        List list = new ArrayList();
        for (GlobalTypeEnum e:GlobalTypeEnum.values()){
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
        for (GlobalTypeEnum e : GlobalTypeEnum.values()) {
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
