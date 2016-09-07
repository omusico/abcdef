package com.lvmama.lvfit.common.dto.enums;


public enum BSPInventoryStatus {

	ALL("全部"),
    STORAGE("已入库"),
    CANCELLED("已取消");

    private String cnName;

    private BSPInventoryStatus(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }
}
