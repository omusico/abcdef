package com.lvmama.lvf.common.form.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.AirPlaneRequest;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.StringUtil;

public class AirPlaneRequestForm implements Serializable, Form {

	private static final long serialVersionUID = -4323355199754673693L;

	private AirPlaneRequest request= new AirPlaneRequest();
    
	private Pagination pagination = new Pagination();

	public AirPlaneRequest getRequest() {
		return request;
	}

	public void setRequest(AirPlaneRequest request) {
		this.request = request;
	}
	
	public String getName() {
		return request.getName();
	}

	public void setName(String name) {
		if(StringUtil.isNotEmptyString(name)){
			request.setName(name.trim());
		}
	}
	
	public String getCode() {
		return request.getCode();
	}

	public void setCode(String code) {
		if(StringUtil.isNotEmptyString(code)){
			request.setCode(code.trim());
		}
	}
	
	public String getSimpleName() {
		return request.getSimpleName();
	}

	public void setSimpleName(String simpleName) {
		if(StringUtil.isNotEmptyString(simpleName)){
			request.setSimpleName(simpleName.trim());
		}
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