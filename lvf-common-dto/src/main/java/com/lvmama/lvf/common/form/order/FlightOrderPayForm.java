package com.lvmama.lvf.common.form.order;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.request.FlightOrderOfflinePayRequest;
import com.lvmama.lvf.common.dto.status.OpSource;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.form.Form;

/**
 * 订单支付 RequestForm
 * 
 * @author zzs
 * 
 */
public class FlightOrderPayForm implements Form {

	private FlightOrderOfflinePayRequest offlinePayRequest = new FlightOrderOfflinePayRequest();

	private Pagination pagination=new Pagination();
	
	public FlightOrderOfflinePayRequest getOfflinePayRequest() {
		return offlinePayRequest;
	}

	public void setOfflinePayRequest(
			FlightOrderOfflinePayRequest offlinePayRequest) {
		this.offlinePayRequest = offlinePayRequest;
	}

	public Long getId() {
		return offlinePayRequest.getId();
	}

	public Long getOrderId() {
		return offlinePayRequest.getOrderId();
	}

	public void setOrderId(Long orderId) {
		offlinePayRequest.setOrderId(orderId);
	}

	public Long getOrderMainId() {
		return offlinePayRequest.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		offlinePayRequest.setOrderMainId(orderMainId);
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return offlinePayRequest.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		offlinePayRequest.setFlightOrderNo(flightOrderNo);
	}

	public PayType getPayType() {
		return offlinePayRequest.getPayType();
	}

	public void setPayType(PayType payType) {
		offlinePayRequest.setPayType(payType);
	}

	public PaymentType getPaymentType() {
		return offlinePayRequest.getPaymentType();
	}

	public void setPaymentType(PaymentType paymentType) {
		offlinePayRequest.setPaymentType(paymentType);
	}

	public String getPayerId() {
		return offlinePayRequest.getPayerId();
	}

	public void setPayerId(String payerId) {
		offlinePayRequest.setPayerId(payerId);
	}

	public String getPayerName() {
		return offlinePayRequest.getPayerName();
	}

	public void setPayerName(String payerName) {
		offlinePayRequest.setPayerName(payerName);
	}

	public BigDecimal getAmount() {
		return offlinePayRequest.getAmount();
	}

	public void setAmount(BigDecimal amount) {
		offlinePayRequest.setAmount(amount);
	}

	public String getBizType() {
		return offlinePayRequest.getBizType();
	}

	public void setBizType(String bizType) {
		offlinePayRequest.setBizType(bizType);
	}

	public OpSource getOpSource() {
		return offlinePayRequest.getOpSource();
	}

	public void setOpSource(OpSource opSource) {
		offlinePayRequest.setOpSource(opSource);
	}

	public String getPaymentNo() {
		return offlinePayRequest.getPaymentNo();
	}

	public void setPaymentNo(String paymentNo) {
		offlinePayRequest.setPaymentNo(paymentNo);
	}

	public BigDecimal getPayedAmount() {
		return offlinePayRequest.getPayedAmount();
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		offlinePayRequest.setPayedAmount(payedAmount);
	}

	public ResultStatus getPaymentStatus() {
		return offlinePayRequest.getPaymentStatus();
	}

	public void setPaymentStatus(ResultStatus paymentStatus) {
		offlinePayRequest.setPaymentStatus(paymentStatus);
	}

	public String getPaySource() {
		return offlinePayRequest.getPaySource();
	}

	public void setPaySource(String paySource) {
		offlinePayRequest.setPaySource(paySource);
	}

	public String getPaymentSerialNumber() {
		return offlinePayRequest.getPaymentSerialNumber();
	}

	public void setPaymentSerialNumber(String paymentSerialNumber) {
		offlinePayRequest.setPaymentSerialNumber(paymentSerialNumber);
	}

	public String getPaymentBankCode() {
		return offlinePayRequest.getPaymentBankCode();
	}

	public void setPaymentBankCode(String paymentBankCode) {
		offlinePayRequest.setPaymentBankCode(paymentBankCode);
	}

	public ResultStatus getOrderCallbackStatus() {
		return offlinePayRequest.getOrderCallbackStatus();
	}

	public void setOrderCallbackStatus(ResultStatus orderCallbackStatus) {
		offlinePayRequest.setOrderCallbackStatus(orderCallbackStatus);
	}

	public String getPayRemark() {
		return offlinePayRequest.getPayRemark();
	}

	public void setPayRemark(String payRemark) {
		offlinePayRequest.setPayRemark(payRemark);
	}

	public String getCreateStartDate() {
		return offlinePayRequest.getCreateStartDate();
	}

	public void setCreateStartDate(String createStartDate) {
		offlinePayRequest.setCreateStartDate(createStartDate);
	}

	public String getCreateEndDate() {
		return offlinePayRequest.getCreateEndDate();
	}

	public void setCreateEndDate(String createEndDate) {
		offlinePayRequest.setCreateEndDate(createEndDate);
	}

	public String getPayedStartDate() {
		return offlinePayRequest.getPayedStartDate();
	}

	public void setPayedStartDate(String payedStartDate) {
		offlinePayRequest.setPayedStartDate(payedStartDate);
	}

	public String getPayedEndDate() {
		return offlinePayRequest.getPayedEndDate();
	}

	public void setPayedEndDate(String payedEndDate) {
		offlinePayRequest.setPayedEndDate(payedEndDate);
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

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
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

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}
}
