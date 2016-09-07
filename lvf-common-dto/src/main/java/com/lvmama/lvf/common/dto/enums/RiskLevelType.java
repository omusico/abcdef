package com.lvmama.lvf.common.dto.enums;

/**
 * 风控名单等级<br>
 * 
 * @author yuanweihong
 * @date 2015-9-1
 */
public enum RiskLevelType {
    WHITE("白名单"), 
    GRAY("灰名单"), 
    BLACK("黑名单");

    private String cnName;

    private RiskLevelType(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
}
