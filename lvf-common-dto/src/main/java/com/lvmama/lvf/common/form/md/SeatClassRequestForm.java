package com.lvmama.lvf.common.form.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.SeatClassStatus;
import com.lvmama.lvf.common.dto.md.SeatClass;
import com.lvmama.lvf.common.dto.request.SeatClassRequest;
import com.lvmama.lvf.common.form.Form;

public class SeatClassRequestForm implements Serializable, Form {

	private static final long serialVersionUID = 5979131828882014945L;

	private SeatClassRequest request= new SeatClassRequest();
    
	private Pagination pagination = new Pagination();

	public SeatClassRequest getRequest() {
		return request;
	}

	public void setRequest(SeatClassRequest request) {
		this.request = request;
	}
	
	public SeatClass getSeatClass() {
		return request.getSeatClass();
	}

	public void setSeatClass(SeatClass airport) {
		request.setSeatClass(airport);
	}

	public String getName() {
		return request.getName();
	}
	
	public void setName(String name) {
		request.setName(name);
	}
	
	public String getCode() {
		return request.getCode();
	}
	
	public void setCode(String code) {
		request.setCode(code);
	}
	
	public String getCarrierCode() {
		return request.getCarrierCode();
	}
	
	public void setCarrierCode(String carrierCode) {
		request.setCarrierCode(carrierCode);
	}
	public SeatClassStatus getSeatClassStatus() {
		return request.getSeatClassStatus();
	}
	
	public void setSeatClassStatus(SeatClassStatus SeatClassStatus) {
		request.setSeatClassStatus(SeatClassStatus);
	}
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
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