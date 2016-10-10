package com.lvmama.lvf.cat.utils;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;


/**
 * 异常编码枚举
 * @author majun
 * @date   2015-1-24
 */
public class ExceptionCode implements Serializable{
    

    public ExceptionCode(String code, String messageFmt) {
        this.code = code;
        this.messageFmt = messageFmt;
    }

    /** 编码 */
    private String code;
    
    /** 消息格式字符串 */
    @JsonIgnore
    private String messageFmt;
    
    public ExceptionCode() {
		super();
	}

	public String errMessage(Object... vars){
        return String.format(this.messageFmt,vars);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessageFmt() {
        return messageFmt;
    }

    public void setMessageFmt(String messageFmt) {
        this.messageFmt = messageFmt;
    }
    

}
