package com.lvmama.lvf.common.form.md;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.request.FlightOrderSuppPaymentRequest;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppPaymentDto;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderSuppPaymentRequestForm implements Serializable, Form {
	
	private static final long serialVersionUID = 1L;
	
	private FlightOrderSuppPaymentRequest flightOrderSuppPaymentRequest = new FlightOrderSuppPaymentRequest();
	
	private List<FlightOrderSuppPaymentDto> suppPayDtoList;
	
	private Pagination pagination = new Pagination();
	
	public FlightOrderSuppPaymentRequest getFlightOrderSuppPaymentRequest() {
		return flightOrderSuppPaymentRequest;
	}

	public void setFlightOrderSuppPaymentRequest(
			FlightOrderSuppPaymentRequest flightOrderSuppPaymentRequest) {
		this.flightOrderSuppPaymentRequest = flightOrderSuppPaymentRequest;
	}
	public String getSuppOrderNo() {
		return flightOrderSuppPaymentRequest.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		flightOrderSuppPaymentRequest.setSuppOrderNo(suppOrderNo);
	}
	public String getSuppCode() {
		return flightOrderSuppPaymentRequest.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		flightOrderSuppPaymentRequest.setSuppCode(suppCode);
	}
	public PaymentType getTradeChannel() {
		return flightOrderSuppPaymentRequest.getTradeChannel();
	}

	public void setTradeChannel(PaymentType tradeChannel) {
		flightOrderSuppPaymentRequest.setTradeChannel(tradeChannel);
	}
	public Date getTradeTime() {
		return flightOrderSuppPaymentRequest.getTradeTime();
	}

	public void setTradeTime(Date tradeTime) {
		flightOrderSuppPaymentRequest.setTradeTime(tradeTime);
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public boolean equals(Object obj) {
		return pagination.equals(obj);
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
	
	public String getTradeTimeBeginTime() {
		return flightOrderSuppPaymentRequest.getTradeTimeBeginTime();
	}
	public void setTradeTimeBeginTime(String tradeTimeBeginTime) {
		flightOrderSuppPaymentRequest.setTradeTimeBeginTime(tradeTimeBeginTime);
	}
	public String getTradeTimeEndTime() {
		return flightOrderSuppPaymentRequest.getTradeTimeEndTime();
	}
	public void setTradeTimeEndTime(String tradeTimeEndTime) {
		flightOrderSuppPaymentRequest.setTradeTimeEndTime(tradeTimeEndTime);
	}

	public List<FlightOrderSuppPaymentDto> getSuppPayDtoList() {
		return suppPayDtoList;
	}

	public void setSuppPayDtoList(List<FlightOrderSuppPaymentDto> suppPayDtoList) {
		this.suppPayDtoList = suppPayDtoList;
	}
}
