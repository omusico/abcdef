package com.lvmama.lvf.common.form.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.request.CarrierRequest;
import com.lvmama.lvf.common.form.Form;

public class CarrierRequestForm implements Serializable,Form{

	private static final long serialVersionUID = -1903310279154739874L;
	
	private CarrierRequest carrierRequest = new CarrierRequest();
	
	private Pagination pagination = new Pagination();

	public CarrierRequest getCarrierRequest() {
		return carrierRequest;
	}

	public void setCarrierRequest(CarrierRequest carrierRequest) {
		this.carrierRequest = carrierRequest;
	}
	
	public Carrier getCarrier() {
		return carrierRequest.getCarrier();
	}

	public void setCarrier(Carrier carrier) {
		carrierRequest.setCarrier(carrier);
	}
	
	public String getUniversalCondition() {
		return carrierRequest.getUniversalCondition();
	}

	public void setUniversalCondition(String universalCondition) {
		carrierRequest.setUniversalCondition(universalCondition);
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
