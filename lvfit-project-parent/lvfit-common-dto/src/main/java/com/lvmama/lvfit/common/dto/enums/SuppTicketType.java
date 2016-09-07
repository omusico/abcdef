package com.lvmama.lvfit.common.dto.enums;

/**
 * 供应商票源
 * 
 * @author yuanweihong
 * @date 2015-9-22
 */
public enum SuppTicketType {
    ONLINE("线上");

    private String cnName;

    private SuppTicketType(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }

}
