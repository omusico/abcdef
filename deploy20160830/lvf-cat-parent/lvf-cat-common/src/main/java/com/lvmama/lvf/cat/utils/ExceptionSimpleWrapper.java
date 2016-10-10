package com.lvmama.lvf.cat.utils;

import java.io.Serializable;

/**
 * Created by leizhengwei
 * 2016/9/23
 * 14:38
 */
public class ExceptionSimpleWrapper implements Serializable {


    public ExceptionSimpleWrapper(ExceptionWrapper ew) {
        this.exceptionCode = ew.getExceptionCode();
        this.errMessage = ew.getErrMessage();
        this.fullStackTrace = ew.getFullStackTrace();
        this.originErrMsg = ew.getOriginErrMsg();
    }

    /** 异常编码枚举 */
    private ExceptionCode exceptionCode;

    /** 错误消息 */
    private String errMessage;

    /** 堆栈信息 */
    private String fullStackTrace;

    /** 原始错误信息 */
    private String originErrMsg;

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getFullStackTrace() {
        return fullStackTrace;
    }

    public void setFullStackTrace(String fullStackTrace) {
        this.fullStackTrace = fullStackTrace;
    }

    public String getOriginErrMsg() {
        return originErrMsg;
    }

    public void setOriginErrMsg(String originErrMsg) {
        this.originErrMsg = originErrMsg;
    }
}
