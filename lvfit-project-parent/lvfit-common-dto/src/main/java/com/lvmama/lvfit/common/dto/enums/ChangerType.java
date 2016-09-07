package com.lvmama.lvfit.common.dto.enums;

public enum ChangerType {

    CD("改期"), 
    UG("升舱"), 
    CD_UG("改期+升舱");

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    private ChangerType(String cnName) {
        this.cnName = cnName;
    }

}
