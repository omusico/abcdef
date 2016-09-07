package com.lvmama.lvf.common.form.api;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.request.ApiFlowQueryRequest;
import com.lvmama.lvf.common.form.Form;


public class ApiFlowInputForm implements Serializable, Form {

	private static final long serialVersionUID = -2381527539140158716L;

    private ApiFlowQueryRequest request= new ApiFlowQueryRequest();
    
	private Pagination pagination = new Pagination();

	public ApiFlowQueryRequest getRequest() {
		return request;
	}

	public InterfaceKey getInterfaceKey() {
		return request.getInterfaceKey();
	}

	public void setInterfaceKey(InterfaceKey interfaceKey) {
		request.setInterfaceKey(interfaceKey);
	}

	public void setRequest(ApiFlowQueryRequest request) {
		this.request = request;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getStartTime() {
		return request.getStartTime();
	}

	public void setStartTime(String startTime) {
		request.setStartTime(startTime);
	}

	public String getEndTime() {
		return request.getEndTime();
	}

	public void setEndTime(String endTime) {
		request.setEndTime(endTime);
	}

	public Long getId() {
		return request.getId();
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public String getTraceNo() {
		return request.getTraceNo();
	}

	public void setTraceNo(String traceNo) {
		request.setTraceNo(traceNo);
	}

	public RequestResponse getRequestResponse() {
		return request.getRequestResponse();
	}

	public void setRequestResponse(RequestResponse requestResponse) {
		request.setRequestResponse(requestResponse);
	}

	public String getMessage() {
		return request.getMessage();
	}

	public void setMessage(String message) {
		request.setMessage(message);
	}
	
	public Boolean getQueryByDay() {
		return request.getQueryByDay();
	}
	
	public void setQueryByDay(Boolean queryByDay) {
		request.setQueryByDay(queryByDay);
	}
	
}