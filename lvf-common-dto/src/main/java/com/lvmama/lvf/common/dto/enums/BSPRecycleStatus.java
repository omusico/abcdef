package com.lvmama.lvf.common.dto.enums;


public enum BSPRecycleStatus {

    ALL("全部"),
    RECYCLED("已回收"),
    UNRECYCLED("未回收");

    private String cnName;

    private BSPRecycleStatus(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }
}
