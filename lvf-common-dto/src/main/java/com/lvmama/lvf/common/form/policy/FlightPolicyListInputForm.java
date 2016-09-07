package com.lvmama.lvf.common.form.policy;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.request.FlightPolicyListRequest;
import com.lvmama.lvf.common.dto.supp.Supp;
import com.lvmama.lvf.common.form.Form;

public class FlightPolicyListInputForm implements Form{

	private FlightPolicyListRequest request = new FlightPolicyListRequest();
	
	private Pagination pagination = new Pagination();

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public FlightPolicyListRequest getRequest() {
		return request;
	}

	public void setRequest(FlightPolicyListRequest request) {
		this.request = request;
	}

	public Supp getSupp() {
		return request.getSupp();
	}

	public void setSupp(Supp supp) {
		request.setSupp(supp);
	}

	public Carrier getCarrier() {
		return request.getCarrier();
	}

	public void setCarrier(Carrier carrier) {
		request.setCarrier(carrier);
	}

	public String getDepartureAirport() {
		return request.getDepartureAirport();
	}

	public void setDepartureAirport(String departureAirport) {
		request.setDepartureAirport(departureAirport);
	}

	public String getArrivalAirport() {
		return request.getArrivalAirport();
	}

	public void setArrivalAirport(String arrivalAirport) {
		request.setArrivalAirport(arrivalAirport);
	}

	public String getStartUpdateTime() {
		return request.getStartUpdateTime();
	}

	public void setStartUpdateTime(String startUpdateTime) {
		request.setStartUpdateTime(startUpdateTime);
	}

	public String getEndUpdateTime() {
		return request.getEndUpdateTime();
	}

	public void setEndUpdateTime(String endUpdateTime) {
		request.setEndUpdateTime(endUpdateTime);
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
