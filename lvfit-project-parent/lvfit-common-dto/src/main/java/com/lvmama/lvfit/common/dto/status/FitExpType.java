package com.lvmama.lvfit.common.dto.status;

/**
 * 机+酒异常类型ENUM<br>
 * <b>CALL</b>("接口调用异常"),<br>
 * <b>BUSINESS</b>("业务异常"),<br>
 * <b>PROGRAM</b>("程序异常");<br>
 * @author lizongze
 *
 */
public enum FitExpType {
    CALL("接口调用异常"),
    BUSINESS("业务异常"),
    PROGRAM("程序异常");

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    private FitExpType(String cnName) {
        this.cnName = cnName;
    }
}
