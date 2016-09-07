package com.lvmama.lvfit.common.dto.sdp.product;

/**
 * Created by leizhengwei
 * 2016/7/20
 * 14:08
 */
public enum FitSdpLineTraffic{

    TRAIN("火车","1"),
    SHIP("邮轮","2"),
    FLIGHT("飞机","3"),
    BUS("大巴","4"),
    CATEGORY_TRAFFIC("大交通","5"),
    CATEGORY_TRAFFIC_AEROPLANE("飞机","6"),
    CATEGORY_TRAFFIC_AERO_OTHER("飞机","7"),
    CATEGORY_TRAFFIC_TRAIN("火车","8"),
    CATEGORY_TRAFFIC_TRAIN_OTHER("火车","9"),
    CATEGORY_TRAFFIC_BUS("大巴","10"),
    CATEGORY_TRAFFIC_BUS_OTHER("大巴","11"),
    CATEGORY_TRAFFIC_SHIP("邮轮","12"),
    CATEGORY_TRAFFIC_SHIP_OTHER("邮轮","13");
    private String cnName;
    private String code;

    FitSdpLineTraffic(String cnName,String code){
        this.cnName=cnName;
        this.code = code;
    }
    public String getCnName() {
        return cnName;
    }
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

}