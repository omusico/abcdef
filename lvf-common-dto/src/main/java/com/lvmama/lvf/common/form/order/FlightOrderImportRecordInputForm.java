package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.order.status.GenerateStatus;
import com.lvmama.lvf.common.dto.request.FlightOrderImportRecordRequest;
import com.lvmama.lvf.common.form.Form;

import java.io.Serializable;

public class FlightOrderImportRecordInputForm implements Serializable, Form {

	private static final long serialVersionUID = 4402584097753948519L;

	private FlightOrderImportRecordRequest request = new FlightOrderImportRecordRequest();

	private Pagination pagination = new Pagination();

	public FlightOrderImportRecordRequest getRequest() {
		return request;
	}

	public void setRequest(FlightOrderImportRecordRequest request) {
		this.request = request;
	}

	public String getFileName() {
		return request.getFileName();
	}

	public void setCompanyName(String companyName) {
		request.setCompanyName(companyName);
	}

	public void setFileName(String fileName) {
		request.setFileName(fileName);
	}

	public void setStatus(GenerateStatus status) {
		request.setStatus(status);
	}

	public void setId(Long id) {
		request.setId(id);
	}

	public String getCompanyName() {
		return request.getCompanyName();
	}

	public void setAccountName(String accountName) {
		request.setAccountName(accountName);
	}

	public Long getId() {
		return request.getId();
	}

	public String getRecordDesc() {
		return request.getRecordDesc();
	}

	public GenerateStatus getStatus() {
		return request.getStatus();
	}

	public void setRecordDesc(String recordDesc) {
		request.setRecordDesc(recordDesc);
	}

	public String getAccountName() {
		return request.getAccountName();
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public String getQueryBegTime() {
		return request.getQueryBegTime();
	}

	public void setQueryBegTime(String queryBegTime) {
		request.setQueryBegTime(queryBegTime);
	}

	public String getQueryEndTime() {
		return request.getQueryEndTime();
	}

	public void setQueryEndTime(String queryEndTime) {
		request.setQueryEndTime(queryEndTime);
	}
}
