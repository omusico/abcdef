package com.lvmama.lvfit.common.dto.enums;

public enum ProductResource {

    FLIGHT("大系统机票"),
    VST("动态打包");

    private String cnName;

    public String getCnName() {
        return cnName;
    }
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
    private ProductResource(String cnName) {
        this.cnName = cnName;
    }
}
