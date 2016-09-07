package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.FlightChangeType;
import com.lvmama.lvf.common.dto.request.FlightOrderFlightChangeInfoRequest;
import com.lvmama.lvf.common.form.Form;

import java.io.Serializable;
import java.util.Date;


public class FlightOrderFlightChangeInfoInputForm implements Serializable, Form {

	private static final long serialVersionUID = 6318198382750681320L;

	private FlightOrderFlightChangeInfoRequest request = new FlightOrderFlightChangeInfoRequest();

	private Pagination pagination = new Pagination();

	public FlightOrderFlightChangeInfoRequest getRequest() {
		return request;
	}

	public void setRequest(FlightOrderFlightChangeInfoRequest request) {
		this.request = request;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setSuppOrderNo(String suppOrderNo) {
		request.setSuppOrderNo(suppOrderNo);
	}

	public String getSuppOrderNo() {
		return request.getSuppOrderNo();
	}

	public Long getId() {
		return request.getId();
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public String getSord() {
		return pagination.getSord();
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public FlightChangeType getFlightChangeType() {
		return request.getFlightChangeType();
	}


	public void setOriginFlightNo(String originFlightNo) {
		request.setOriginFlightNo(originFlightNo);
	}

	public String getOriginFlightNo() {
		return request.getOriginFlightNo();
	}

	public void setFlightChangeType(FlightChangeType flightChangeType) {
		request.setFlightChangeType(flightChangeType);
	}

	public void setFlightChangePNR(String flightChangePNR) {
		request.setFlightChangePNR(flightChangePNR);
	}

	public String getOriginDepartureAirport() {
		return request.getOriginDepartureAirport();
	}

	public void setOriginDepartureAirport(String originDepartureAirport) {
		request.setOriginDepartureAirport(originDepartureAirport);
	}

	public String getFlightChangePNR() {
		return request.getFlightChangePNR();
	}

	public String getOriginDepQueryEndTime() {
		return request.getOriginDepQueryEndTime();
	}

	public void setOriginDepQueryEndTime(String originDepQueryEndTime) {
		request.setOriginDepQueryEndTime(originDepQueryEndTime);
	}

	public void setOriginDepQueryBegTime(String originDepQueryBegTime) {
		request.setOriginDepQueryBegTime(originDepQueryBegTime);
	}

	public String getOriginDepQueryBegTime() {
		return request.getOriginDepQueryBegTime();
	}
}