package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;

@XmlRootElement
public class ApiFlowQueryRequest implements Serializable, Dto {

	private static final long serialVersionUID = 3507816492741350784L;
	/********************前台搜索参数***********************/

	private String startTime;//起始日期

	private String endTime;//截至日期

	private InterfaceKey interfaceKey;

	private RequestResponse requestResponse =RequestResponse.RE;

	private String traceNo;

	private String message;

	private int rows;
	
	private Boolean queryByDay = Boolean.FALSE;

	public Boolean getQueryByDay() {
		return queryByDay;
	}
	public void setQueryByDay(Boolean queryByDay) {
		this.queryByDay = queryByDay;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public InterfaceKey getInterfaceKey() {
		return interfaceKey;
	}
	public void setInterfaceKey(InterfaceKey interfaceKey) {
		this.interfaceKey = interfaceKey;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public RequestResponse getRequestResponse() {
		return requestResponse;
	}
	public void setRequestResponse(RequestResponse requestResponse) {
		this.requestResponse = requestResponse;
	}

}

