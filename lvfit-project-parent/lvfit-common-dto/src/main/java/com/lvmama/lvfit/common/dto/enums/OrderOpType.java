package com.lvmama.lvfit.common.dto.enums;

public enum OrderOpType {

    CREATE_ORDER("创建订单"),
    BOOKING_HOTEL("酒店预订"),
    BOOKING_FLIGHT("机票预订");

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    private OrderOpType(String cnName) {
        this.cnName = cnName;
    }
}
