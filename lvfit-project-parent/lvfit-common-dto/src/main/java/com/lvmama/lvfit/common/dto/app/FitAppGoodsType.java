package com.lvmama.lvfit.common.dto.app;

/**
 * Created by leizhengwei
 * 2016/7/14
 * 0:35
 */
public enum  FitAppGoodsType {
	
    FLIGHT("机票"),
    HOTEL("酒店"),
    HOTEL_COMBO("酒店套餐"),
    LOCAL_TRIP("当地游"),
    ROOM_DIFF("房差"),
    OTHER_TICKETS("其他票"),
    TICKET("门票"),
    INSURANCE("保险"),
    INLAND_INSURANCE("国内游保险"),
    FLIGHT_INSURANCE("航意险");

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    private FitAppGoodsType (String cnName) {
        this.cnName = cnName;
    }
}
