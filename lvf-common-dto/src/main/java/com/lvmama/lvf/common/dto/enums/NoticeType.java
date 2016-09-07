package com.lvmama.lvf.common.dto.enums;

public enum NoticeType {
    FLIGHT_INDEX_PAGE("机票首页"),
    AIRLINE_LIST_PAGE("航班列表页"),
    SEAT_LIST_PAGE("舱位列表页"),
    ORDER_FILL_PAGE("订单填写页"),
    ORDER_LIST_PAGE("订单列表页"),
    ORDER_DETAIL_PAGE("订单详情页");


    private String cnName;

    NoticeType(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
}
