package com.lvmama.lvf.cat.utils;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 异常包装
 * @author majun
 * @date   2015-1-24
 */
@XmlRootElement
public class ExceptionWrapper extends RuntimeException implements Serializable 
{
	private static final long serialVersionUID = 3602466884170287419L;
	
	/** 异常编码枚举 */
	private ExceptionCode exceptionCode;
	
	/** 错误消息 */
	private String errMessage;
	
	/** 堆栈信息 */
	private String fullStackTrace;
	
	/** 原始错误信息 */
    private String originErrMsg;
	
	public ExceptionWrapper() {
		super();
	}
	public ExceptionWrapper(String fullStackTrace) {
		super();
		this.fullStackTrace = fullStackTrace;
	}
	
	public ExceptionWrapper(ExceptionCode exceptionCode, Object... vars) {
		super();
		this.exceptionCode = exceptionCode;
		this.errMessage = exceptionCode.errMessage(vars);
	}
	
	public ExceptionWrapper(String originErrMsg, ExceptionCode exceptionCode, Object... vars) {
        super();
        this.originErrMsg = originErrMsg;
        this.exceptionCode = exceptionCode;
        this.errMessage = exceptionCode.errMessage(vars);
    }
	
	public ExceptionCode getExceptionCode() {
		return exceptionCode;
	}
	
	public void setExceptionCode(ExceptionCode exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
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
	
	public void printErrMessage() {
		System.err.println(this.errMessage);
	}
	
}
