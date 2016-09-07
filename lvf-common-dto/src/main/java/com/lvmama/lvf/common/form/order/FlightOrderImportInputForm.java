package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.order.status.GenerateStatus;
import com.lvmama.lvf.common.dto.request.FlightOrderImportRequest;
import com.lvmama.lvf.common.form.Form;

import java.io.Serializable;
import java.math.BigDecimal;

public class FlightOrderImportInputForm implements Serializable,Form {

	private static final long serialVersionUID = -1065827543638202979L;

	private FlightOrderImportRequest request = new FlightOrderImportRequest();

	private Pagination pagination = new Pagination();

	public FlightOrderImportRequest getRequest() {
		return request;
	}

	public void setRequest(FlightOrderImportRequest request) {
		this.request = request;
	}

	public Long getRecordId() {
		return request.getRecordId();
	}

	public Long getId() {
		return request.getId();
	}

	public BigDecimal getExpressAmount() {
		return request.getExpressAmount();
	}

	public String getSuppCode() {
		return request.getSuppCode();
	}

	public String getDalayInsuranceSupp() {
		return request.getDalayInsuranceSupp();
	}

	public void setCompanyName(String companyName) {
		request.setCompanyName(companyName);
	}

	public void setRecordId(Long recordId) {
		request.setRecordId(recordId);
	}

	public String getExpressAddress() {
		return request.getExpressAddress();
	}

	public void setSettleAmount(BigDecimal settleAmount) {
		request.setSettleAmount(settleAmount);
	}

	public void setTicketAmount(BigDecimal ticketAmount) {
		request.setTicketAmount(ticketAmount);
	}

	public void setDalayInsuranceCode(String dalayInsuranceCode) {
		request.setDalayInsuranceCode(dalayInsuranceCode);
	}

	public String getOrderNo() {
		return request.getOrderNo();
	}

	public void setExpressTelephone(String expressTelephone) {
		request.setExpressTelephone(expressTelephone);
	}

	public void setExpressAmount(BigDecimal expressAmount) {
		request.setExpressAmount(expressAmount);
	}

	public String getExpressTelephone() {
		return request.getExpressTelephone();
	}

	public String getPnr() {
		return request.getPnr();
	}

	public BigDecimal getSettleAmount() {
		return request.getSettleAmount();
	}

	public String getCompanyName() {
		return request.getCompanyName();
	}

	public String getAccidentInsuranceCode() {
		return request.getAccidentInsuranceCode();
	}

	public String getExpressRecipient() {
		return request.getExpressRecipient();
	}

	public BigDecimal getTicketAmount() {
		return request.getTicketAmount();
	}

	public void setDalayInsuranceSupp(String dalayInsuranceSupp) {
		request.setDalayInsuranceSupp(dalayInsuranceSupp);
	}

	public BigDecimal getAccidentInsuranceAmount() {
		return request.getAccidentInsuranceAmount();
	}

	public String getAccidentInsuranceSupp() {
		return request.getAccidentInsuranceSupp();
	}

	public BigDecimal getFuelTaxAmount() {
		return request.getFuelTaxAmount();
	}

	public void setId(Long id) {
		request.setId(id);
	}

	public Long getOrderId() {
		return request.getOrderId();
	}

	public String getDalayInsuranceCode() {
		return request.getDalayInsuranceCode();
	}

	public void setOrderNo(String orderNo) {
		request.setOrderNo(orderNo);
	}

	public void setAccidentInsuranceCode(String accidentInsuranceCode) {
		request.setAccidentInsuranceCode(accidentInsuranceCode);
	}

	public void setAccidentInsuranceAmount(BigDecimal accidentInsuranceAmount) {
		request.setAccidentInsuranceAmount(accidentInsuranceAmount);
	}

	public void setPnr(String pnr) {
		request.setPnr(pnr);
	}

	public void setAirportTaxAmount(BigDecimal airportTaxAmount) {
		request.setAirportTaxAmount(airportTaxAmount);
	}

	public void setFuelTaxAmount(BigDecimal fuelTaxAmount) {
		request.setFuelTaxAmount(fuelTaxAmount);
	}

	public void setOrderId(Long orderId) {
		request.setOrderId(orderId);
	}

	public void setContactName(String contactName) {
		request.setContactName(contactName);
	}

	public void setExpressRecipient(String expressRecipient) {
		request.setExpressRecipient(expressRecipient);
	}

	public void setSuppCode(String suppCode) {
		request.setSuppCode(suppCode);
	}

	public String getAccountName() {
		return request.getAccountName();
	}

	public BigDecimal getDalayInsuranceAmount() {
		return request.getDalayInsuranceAmount();
	}

	public void setAccidentInsuranceSupp(String accidentInsuranceSupp) {
		request.setAccidentInsuranceSupp(accidentInsuranceSupp);
	}

	public void setDalayInsuranceAmount(BigDecimal dalayInsuranceAmount) {
		request.setDalayInsuranceAmount(dalayInsuranceAmount);
	}

	public void setExpressAddress(String expressAddress) {
		request.setExpressAddress(expressAddress);
	}

	public void setContactCellphone(String contactCellphone) {
		request.setContactCellphone(contactCellphone);
	}

	public String getContactCellphone() {
		return request.getContactCellphone();
	}

	public void setAccountName(String accountName) {
		request.setAccountName(accountName);
	}

	public GenerateStatus getStatus() {
		return request.getStatus();
	}

	public BigDecimal getAirportTaxAmount() {
		return request.getAirportTaxAmount();
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		request.setSaleAmount(saleAmount);
	}

	public void setStatus(GenerateStatus status) {
		request.setStatus(status);
	}

	public BigDecimal getSaleAmount() {
		return request.getSaleAmount();
	}

	public String getContactName() {
		return request.getContactName();
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
}
