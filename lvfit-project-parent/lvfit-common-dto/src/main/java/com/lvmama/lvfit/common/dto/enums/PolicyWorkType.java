package com.lvmama.lvfit.common.dto.enums;

public enum PolicyWorkType {

    ONWORKING("在工作时间"), 
    NOONWORKING("不在工作时间");

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    private PolicyWorkType(String cnName) {
        this.cnName = cnName;
    }

}
