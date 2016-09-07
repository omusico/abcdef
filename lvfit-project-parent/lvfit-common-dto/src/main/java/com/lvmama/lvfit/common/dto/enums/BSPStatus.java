package com.lvmama.lvfit.common.dto.enums;


public enum BSPStatus {

    ALL("全部"),
    UNUSED("未使用"),
    USED("已使用"),
    /*FROZEN("已冻结"),*/
    INVALID("已作废"),
/*    MANUAL_DEL("手工销号"),
    AUTO_DEL("自动销号"),*/
    PRINTED("已打印");

    private String cnName;

    private BSPStatus(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }
}
