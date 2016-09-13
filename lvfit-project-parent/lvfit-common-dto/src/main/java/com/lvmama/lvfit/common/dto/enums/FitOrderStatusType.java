package com.lvmama.lvfit.common.dto.enums;

public enum FitOrderStatusType {
    /** VST订单 */
    VST_ORDER_STATUS("VST订单"),
    /** 机票去程订单状态 */
    DEP_FLI_ORDER_STATUS("机票去程订单状态"), 
    /** 机票返程订单状态 */
    ARV_FLI_ORDER_STATUS("机票返程订单状态");
    
    String cnName;
    
    private FitOrderStatusType(String cnName) {
        this.cnName = cnName;
    }
    
    public String getCnName() {
        return this.cnName;
    }
}
