package com.lvmama.lvf.common.form.config;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.request.ApiFlowQueryRequest;
import com.lvmama.lvf.common.dto.request.TaskConfigQueryRequest;
import com.lvmama.lvf.common.form.Form;


public class TaskConfigInputForm implements Serializable, Form {



    /**
	 * 
	 */
	private static final long serialVersionUID = -1000619518461594589L;

	private TaskConfigQueryRequest request= new TaskConfigQueryRequest();
    
	private Pagination pagination = new Pagination();

	public TaskConfigQueryRequest getRequest() {
		return request;
	}

	public void setRequest(TaskConfigQueryRequest request) {
		this.request = request;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getDepCityCode() {
		return request.getDepCityCode();
	}

	public void setDepCityCode(String depCityCode) {
		request.setDepCityCode(depCityCode);
	}

	public String getArrCityCode() {
		return request.getArrCityCode();
	}

	public void setArrCityCode(String arrCityCode) {
		request.setArrCityCode(arrCityCode);
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

	
	
}