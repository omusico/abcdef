package com.lvmama.lvf.common.dto.enums;

public enum ProductSourceType {
    
    GENERAL_POLICY("大系统普通政策"),
    SHAREPRICE_POLICY("共享资源运价政策"),
    SHAREPROFIT_POLICY("共享资源佣金政策"),
    DIRECT_POLICY("直联资源政策");
    
    private String cnName;
    
    public String getCnName() {
        return cnName;
    }
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
    private ProductSourceType(String cnName) {
        this.cnName = cnName;
    }

}
