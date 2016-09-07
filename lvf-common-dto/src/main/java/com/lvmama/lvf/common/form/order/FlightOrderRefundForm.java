package com.lvmama.lvf.common.form.order;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.PaySource;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;
import com.lvmama.lvf.common.dto.request.FlightOrderRefundRequest;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.form.Form;

/**
 * 订单退款 RequestForm
 * 
 * @author zzs
 * 
 */
public class FlightOrderRefundForm implements Form {

	private FlightOrderRefundRequest request = new FlightOrderRefundRequest();

	private Pagination pagination = new Pagination();

	public FlightOrderRefundDto getFlightOrderRefundDto() {
		return request.getFlightOrderRefundDto();
	}

	public void setFlightOrderRefundDto(FlightOrderRefundDto flightOrderRefundDto) {
		request.setFlightOrderRefundDto(flightOrderRefundDto);
	}

	public void setCreateTime(Date createTime) {
		request.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return request.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		request.setUpdateTime(updateTime);
	}

	public Long getOrderId() {
		return request.getOrderId();
	}

	public void setOrderId(Long orderId) {
		request.setOrderId(orderId);
	}

	public String getRefundSerialNumber() {
		return request.getRefundSerialNumber();
	}

	public void setRefundSerialNumber(String refundSerialNumber) {
		request.setRefundSerialNumber(refundSerialNumber);
	}

	public String getRefundBankCode() {
		return request.getRefundBankCode();
	}

	public void setRefundBankCode(String refundBankCode) {
		request.setRefundBankCode(refundBankCode);
	}

	public BigDecimal getRefundAmount() {
		return request.getRefundAmount();
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		request.setRefundAmount(refundAmount);
	}

	public Date getRefundApplyTime() {
		return request.getRefundApplyTime();
	}

	public void setRefundApplyTime(Date refundApplyTime) {
		request.setRefundApplyTime(refundApplyTime);
	}

	public void setRefundTime(Date refundTime) {
		request.setRefundTime(refundTime);
	}

	public String getRefunderId() {
		return request.getRefunderId();
	}

	public void setRefunderId(String refunderId) {
		request.setRefunderId(refunderId);
	}

	public String getRefunderName() {
		return request.getRefunderName();
	}

	public void setRefunderName(String refunderName) {
		request.setRefunderName(refunderName);
	}

	public String getRefundNo() {
		return request.getRefundNo();
	}

	public void setRefundNo(String refundNo) {
		request.setRefundNo(refundNo);
	}

	public Long getOrderMainId() {
		return request.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		request.setOrderMainId(orderMainId);
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return request.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		request.setFlightOrderNo(flightOrderNo);
	}

	public void setRefundStatus(ResultStatus refundStatus) {
		request.setRefundStatus(refundStatus);
	}

	// public void copyFromOfflineRefundRequest(FlightOrderOfflineRefundRequest
	// refundRequest, FlightOrderRefundDto refundDto) {
	// request.copyFromOfflineRefundRequest(refundRequest, refundDto);
	// }

	public String getRefundRemark() {
		return request.getRefundRemark();
	}

	public void setRefundRemark(String refundRemark) {
		request.setRefundRemark(refundRemark);
	}

	public FlightOrderRefundRequest getRequest() {
		return request;
	}

	public void setRequest(FlightOrderRefundRequest request) {
		this.request = request;
	}

	public PayType getRefundType() {
		return request.getRefundType();
	}

	public void setRefundType(PayType refundType) {
		request.setRefundType(refundType);
	}

	public void setRefundmentType(PaymentType refundmentType) {
		request.setRefundmentType(refundmentType);
	}

	public String getRefundIds() {
		return request.getRefundIds();
	}

	public void setRefundIds(String refundIds) {
		request.setRefundIds(refundIds);
	}

	public String getCreateStartDate() {
		return request.getCreateStartDate();
	}

	public void setCreateStartDate(String createStartDate) {
		request.setCreateStartDate(createStartDate);
	}

	public String getCreateEndDate() {
		return request.getCreateEndDate();
	}

	public void setCreateEndDate(String createEndDate) {
		request.setCreateEndDate(createEndDate);
	}

	public String getRefundedStartDate() {
		return request.getRefundedStartDate();
	}

	public void setRefundedStartDate(String refundedStartDate) {
		request.setRefundedStartDate(refundedStartDate);
	}

	public String getRefundedEndDate() {
		return request.getRefundedEndDate();
	}

	public void setRefundedEndDate(String refundedEndDate) {
		request.setRefundedEndDate(refundedEndDate);
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

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setOrderCallbackStatus(ResultStatus orderCallbackStatus) {
		request.setOrderCallbackStatus(orderCallbackStatus);
	}

	public Long getId() {
		return request.getId();
	}

	public void setId(Long id) {
		request.setId(id);
	}

	public Date getRefundTime() {
		return request.getRefundTime();
	}

	public ResultStatus getRefundStatus() {
		return request.getRefundStatus();
	}

	public ResultStatus getOrderCallbackStatus() {
		return request.getOrderCallbackStatus();
	}

	public PaymentType getRefundmentType() {
		return request.getRefundmentType();
	}

	public PaySource getPaySource() {
		return request.getPaySource();
	}

	public Date getCreateTime() {
		return request.getCreateTime();
	}
}
