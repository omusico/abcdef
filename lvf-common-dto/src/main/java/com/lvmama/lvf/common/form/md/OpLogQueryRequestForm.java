package com.lvmama.lvf.common.form.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.OpLogQueryRequest;
import com.lvmama.lvf.common.form.Form;


public class OpLogQueryRequestForm implements Serializable, Form {

	private static final long serialVersionUID = -1889715949485934054L;

	private OpLogQueryRequest request= new OpLogQueryRequest();
    
	private Pagination pagination = new Pagination();

	public OpLogQueryRequest getRequest() {
		return request;
	}

	public void setRequest(OpLogQueryRequest request) {
		this.request = request;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getResult() {
		return request.getResult();
	}
	
	public void setResult(String result) {
		request.setResult(result);
	}
	
	public String getBusinessNo() {
		return request.getBusinessNo();
	}
	
	public void setBusinessNo(String businessNo) {
		request.setBusinessNo(businessNo);
	}
	
	public BusinessType getBusinessType() {
		return request.getBusinessType();
	}
	
	public OperType getOperType() {
		return request.getOperType();
	}

	public void setOperType(OperType operType) {
		request.setOperType(operType);
	}
	
	public void setBusinessType(BusinessType businessType) {
		request.setBusinessType(businessType);
	}
	
	public String getRemark() {
		return request.getRemark();
	}

	public void setRemark(String remark) {
		request.setRemark(remark);
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

}