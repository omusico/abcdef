package com.lvmama.lvfit.common.dto;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.status.FitExpType;

/**
 * 机+酒操作日志类
 * 
 * @author lizongze
 *
 */
public class FitOpLog extends Entity {
	
    private static final long serialVersionUID = 3817646985996470629L;
    
    // 追踪No
    private String traceId;
    // 业务类型
    private FitBusinessExceptionType fitBusinessExceptionType;
    // 异常类型
    private FitExpType fitExpType;
    // 异常描述
    private String detail;
    // 备注
    private String remark;
    // 操作者
    private OperType operType;
    //请求字符串
    private String requestStr;
    //请求字符串
    private String requestStr1;
    //请求字符串
    private String requestStr2;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

	public FitBusinessExceptionType getFitBusinessExceptionType() {
		return fitBusinessExceptionType;
	}

	public void setFitBusinessExceptionType(
			FitBusinessExceptionType fitBusinessExceptionType) {
		this.fitBusinessExceptionType = fitBusinessExceptionType;
	}

	public FitExpType getFitExpType() {
		return fitExpType;
	}

	public void setFitExpType(FitExpType fitExpType) {
		this.fitExpType = fitExpType;
	}

	public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public OperType getOperType() {
        return operType;
    }

    public void setOperType(OperType operType) {
        this.operType = operType;
    }

	public String getRequestStr() {
		return requestStr;
	}

	public void setRequestStr(String requestStr) {
		this.requestStr = requestStr;
	}

	public String getRequestStr1() {
		return requestStr1;
	}

	public void setRequestStr1(String requestStr1) {
		this.requestStr1 = requestStr1;
	}

	public String getRequestStr2() {
		return requestStr2;
	}

	public void setRequestStr2(String requestStr2) {
		this.requestStr2 = requestStr2;
	}
	
}
