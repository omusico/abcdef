package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.order.FlightOrderImportDto;
import com.lvmama.lvf.common.dto.order.status.GenerateStatus;
import com.lvmama.lvf.common.form.Form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class FlightOrderImportResultForm implements Serializable, Form {

	private static final long serialVersionUID = 4025806226942617469L;

	private FlightOrderImportDto flightOrderImportDto = new FlightOrderImportDto();

	private String statusCnName;

	public FlightOrderImportResultForm(FlightOrderImportDto dto) {
		super();
		this.flightOrderImportDto = dto;
		this.statusCnName = dto.getStatus().getCnName();
	}

	public FlightOrderImportDto getFlightOrderImportDto() {
		return flightOrderImportDto;
	}

	public void setFlightOrderImportDto(FlightOrderImportDto flightOrderImportDto) {
		this.flightOrderImportDto = flightOrderImportDto;
	}

	public void setCompanyName(String companyName) {
		flightOrderImportDto.setCompanyName(companyName);
	}

	public Long getRecordId() {
		return flightOrderImportDto.getRecordId();
	}

	public void setRecordId(Long recordId) {
		flightOrderImportDto.setRecordId(recordId);
	}

	public Long getOrderId() {
		return flightOrderImportDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderImportDto.setOrderId(orderId);
	}

	public String getOrderNo() {
		return flightOrderImportDto.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		flightOrderImportDto.setOrderNo(orderNo);
	}

	public String getPnr() {
		return flightOrderImportDto.getPnr();
	}

	public void setPnr(String pnr) {
		flightOrderImportDto.setPnr(pnr);
	}

	public BigDecimal getTicketAmount() {
		return flightOrderImportDto.getTicketAmount();
	}

	public void setTicketAmount(BigDecimal ticketAmount) {
		flightOrderImportDto.setTicketAmount(ticketAmount);
	}

	public BigDecimal getAirportTaxAmount() {
		return flightOrderImportDto.getAirportTaxAmount();
	}

	public void setAirportTaxAmount(BigDecimal airportTaxAmount) {
		flightOrderImportDto.setAirportTaxAmount(airportTaxAmount);
	}

	public BigDecimal getFuelTaxAmount() {
		return flightOrderImportDto.getFuelTaxAmount();
	}

	public void setFuelTaxAmount(BigDecimal fuelTaxAmount) {
		flightOrderImportDto.setFuelTaxAmount(fuelTaxAmount);
	}

	public BigDecimal getSaleAmount() {
		return flightOrderImportDto.getSaleAmount();
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		flightOrderImportDto.setSaleAmount(saleAmount);
	}

	public BigDecimal getSettleAmount() {
		return flightOrderImportDto.getSettleAmount();
	}

	public void setSettleAmount(BigDecimal settleAmount) {
		flightOrderImportDto.setSettleAmount(settleAmount);
	}

	public String getSuppCode() {
		return flightOrderImportDto.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		flightOrderImportDto.setSuppCode(suppCode);
	}

	public String getContactName() {
		return flightOrderImportDto.getContactName();
	}

	public void setContactName(String contactName) {
		flightOrderImportDto.setContactName(contactName);
	}

	public String getContactCellphone() {
		return flightOrderImportDto.getContactCellphone();
	}

	public void setContactCellphone(String contactCellphone) {
		flightOrderImportDto.setContactCellphone(contactCellphone);
	}

	public BigDecimal getDalayInsuranceAmount() {
		return flightOrderImportDto.getDalayInsuranceAmount();
	}

	public void setDalayInsuranceAmount(BigDecimal dalayInsuranceAmount) {
		flightOrderImportDto.setDalayInsuranceAmount(dalayInsuranceAmount);
	}

	public String getDalayInsuranceSupp() {
		return flightOrderImportDto.getDalayInsuranceSupp();
	}

	public void setDalayInsuranceSupp(String dalayInsuranceSupp) {
		flightOrderImportDto.setDalayInsuranceSupp(dalayInsuranceSupp);
	}

	public String getDalayInsuranceCode() {
		return flightOrderImportDto.getDalayInsuranceCode();
	}

	public void setDalayInsuranceCode(String dalayInsuranceCode) {
		flightOrderImportDto.setDalayInsuranceCode(dalayInsuranceCode);
	}

	public BigDecimal getAccidentInsuranceAmount() {
		return flightOrderImportDto.getAccidentInsuranceAmount();
	}

	public void setAccidentInsuranceAmount(BigDecimal accidentInsuranceAmount) {
		flightOrderImportDto.setAccidentInsuranceAmount(accidentInsuranceAmount);
	}

	public String getAccidentInsuranceSupp() {
		return flightOrderImportDto.getAccidentInsuranceSupp();
	}

	public void setAccidentInsuranceSupp(String accidentInsuranceSupp) {
		flightOrderImportDto.setAccidentInsuranceSupp(accidentInsuranceSupp);
	}

	public String getAccidentInsuranceCode() {
		return flightOrderImportDto.getAccidentInsuranceCode();
	}

	public void setAccidentInsuranceCode(String accidentInsuranceCode) {
		flightOrderImportDto.setAccidentInsuranceCode(accidentInsuranceCode);
	}

	public String getExpressAddress() {
		return flightOrderImportDto.getExpressAddress();
	}

	public void setExpressAddress(String expressAddress) {
		flightOrderImportDto.setExpressAddress(expressAddress);
	}

	public String getExpressRecipient() {
		return flightOrderImportDto.getExpressRecipient();
	}

	public void setExpressRecipient(String expressRecipient) {
		flightOrderImportDto.setExpressRecipient(expressRecipient);
	}

	public String getExpressTelephone() {
		return flightOrderImportDto.getExpressTelephone();
	}

	public void setExpressTelephone(String expressTelephone) {
		flightOrderImportDto.setExpressTelephone(expressTelephone);
	}

	public BigDecimal getExpressAmount() {
		return flightOrderImportDto.getExpressAmount();
	}

	public void setExpressAmount(BigDecimal expressAmount) {
		flightOrderImportDto.setExpressAmount(expressAmount);
	}

	public GenerateStatus getStatus() {
		return flightOrderImportDto.getStatus();
	}

	public void setStatus(GenerateStatus status) {
		flightOrderImportDto.setStatus(status);
	}

	public String getAccountName() {
		return flightOrderImportDto.getAccountName();
	}

	public void setAccountName(String accountName) {
		flightOrderImportDto.setAccountName(accountName);
	}

	public String getCompanyName() {
		return flightOrderImportDto.getCompanyName();
	}

	public Long getId() {
		return flightOrderImportDto.getId();
	}

	public void setId(Long id) {
		flightOrderImportDto.setId(id);
	}

	public Date getCreateTime() {
		return flightOrderImportDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderImportDto.setCreateTime(createTime);
	}

	public String getStatusCnName() {
		return statusCnName;
	}

	public void setStatusCnName(String statusCnName) {
		this.statusCnName = statusCnName;
	}

}
