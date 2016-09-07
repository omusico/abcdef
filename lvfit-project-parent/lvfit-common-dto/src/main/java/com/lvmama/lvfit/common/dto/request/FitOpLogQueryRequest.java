package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;

/**
 * 操作日志请求request
 * 
 * @author lizongze
 *
 */
public class FitOpLogQueryRequest implements Serializable, Dto {

    private static final long serialVersionUID = -5629482895440223654L;
    private String traceId;
    private FitBusinessExceptionType fitBusinessExceptionType;
    private Date selectTimeStart;
    private Date selectTimeEnd;
    
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

	@Override
    public Long getId() {
        return null;
    }

    public Date getSelectTimeStart() {
        return selectTimeStart;
    }

    public void setSelectTimeStart(Date selectTimeStart) {
        this.selectTimeStart = selectTimeStart;
    }

    public Date getSelectTimeEnd() {
        return selectTimeEnd;
    }

    public void setSelectTimeEnd(Date selectTimeEnd) {
        this.selectTimeEnd = selectTimeEnd;
    }

}
