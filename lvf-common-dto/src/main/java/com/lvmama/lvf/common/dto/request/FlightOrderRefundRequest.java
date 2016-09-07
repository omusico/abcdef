package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.PaySource;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;

@XmlRootElement
public class FlightOrderRefundRequest implements Serializable, Dto {

	private static final long serialVersionUID = 8733191929560580768L;

	private FlightOrderRefundDto flightOrderRefundDto = new FlightOrderRefundDto();

	private String refundRemark;

	private String refundIds;

	/** 支付来源 */
	private PaySource paySource;
	
	/** 创建开始时间 */
	private String createStartDate;
	/** 创建结束时间 */
	private String createEndDate;
	/** 已退款开始时间 */
	private String refundedStartDate;
	/** 已退款完成时间 */
	private String refundedEndDate;
	

	public FlightOrderRefundDto getFlightOrderRefundDto() {
		return flightOrderRefundDto;
	}

	public void setFlightOrderRefundDto(FlightOrderRefundDto flightOrderRefundDto) {
		this.flightOrderRefundDto = flightOrderRefundDto;
	}

	public PersistenceType getPtype() {
		return flightOrderRefundDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		flightOrderRefundDto.setPtype(ptype);
	}

	public Long getId() {
		return flightOrderRefundDto.getId();
	}

	public void setId(Long id) {
		flightOrderRefundDto.setId(id);
	}

	public Date getCreateTime() {
		return flightOrderRefundDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderRefundDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderRefundDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderRefundDto.setUpdateTime(updateTime);
	}

	public Long getOrderId() {
		return flightOrderRefundDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderRefundDto.setOrderId(orderId);
	}

	public String getRefundSerialNumber() {
		return flightOrderRefundDto.getRefundSerialNumber();
	}

	public void setRefundSerialNumber(String refundSerialNumber) {
		flightOrderRefundDto.setRefundSerialNumber(refundSerialNumber);
	}

	public String getRefundBankCode() {
		return flightOrderRefundDto.getRefundBankCode();
	}

	public void setRefundBankCode(String refundBankCode) {
		flightOrderRefundDto.setRefundBankCode(refundBankCode);
	}

	public BigDecimal getRefundAmount() {
		return flightOrderRefundDto.getRefundAmount();
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		flightOrderRefundDto.setRefundAmount(refundAmount);
	}

	public Date getRefundApplyTime() {
		return flightOrderRefundDto.getRefundApplyTime();
	}

	public void setRefundApplyTime(Date refundApplyTime) {
		flightOrderRefundDto.setRefundApplyTime(refundApplyTime);
	}

	public Date getRefundTime() {
		return flightOrderRefundDto.getRefundTime();
	}

	public void setRefundTime(Date refundTime) {
		flightOrderRefundDto.setRefundTime(refundTime);
	}

	public String getRefunderId() {
		return flightOrderRefundDto.getRefunderId();
	}

	public void setRefunderId(String refunderId) {
		flightOrderRefundDto.setRefunderId(refunderId);
	}

	public String getRefunderName() {
		return flightOrderRefundDto.getRefunderName();
	}

	public void setRefunderName(String refunderName) {
		flightOrderRefundDto.setRefunderName(refunderName);
	}

	public String getRefundNo() {
		return flightOrderRefundDto.getRefundNo();
	}

	public void setRefundNo(String refundNo) {
		flightOrderRefundDto.setRefundNo(refundNo);
	}

	public Long getOrderMainId() {
		return flightOrderRefundDto.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightOrderRefundDto.setOrderMainId(orderMainId);
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderRefundDto.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		flightOrderRefundDto.setFlightOrderNo(flightOrderNo);
	}

	public ResultStatus getRefundStatus() {
		return flightOrderRefundDto.getRefundStatus();
	}

	public void setRefundStatus(ResultStatus refundStatus) {
		flightOrderRefundDto.setRefundStatus(refundStatus);
	}

	public String getRefundRemark() {
		return refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	public ResultStatus getOrderCallbackStatus() {
		return flightOrderRefundDto.getOrderCallbackStatus();
	}

	public void setOrderCallbackStatus(ResultStatus orderCallbackStatus) {
		flightOrderRefundDto.setOrderCallbackStatus(orderCallbackStatus);
	}

	public PayType getRefundType() {
		return flightOrderRefundDto.getRefundType();
	}

	public void setRefundType(PayType refundType) {
		flightOrderRefundDto.setRefundType(refundType);
	}

	public PaymentType getRefundmentType() {
		return flightOrderRefundDto.getRefundmentType();
	}

	public void setRefundmentType(PaymentType refundmentType) {
		flightOrderRefundDto.setRefundmentType(refundmentType);
	}

	public String getRefundIds() {
		return refundIds;
	}

	public void setRefundIds(String refundIds) {
		this.refundIds = refundIds;
	}

	public PaySource getPaySource() {
		return paySource;
	}

	public void setPaySource(PaySource paySource) {
		this.paySource = paySource;
	}

	@Override
	public String toString() {
		return "FlightOrderRefundRequest [refundRemark=" + refundRemark + ", refundIds=" + refundIds + ", paySource=" + paySource + "]" + flightOrderRefundDto.toString();
	}

	public String getCreateStartDate() {
		return createStartDate;
	}

	public void setCreateStartDate(String createStartDate) {
		this.createStartDate = createStartDate;
	}

	public String getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(String createEndDate) {
		this.createEndDate = createEndDate;
	}

	public String getRefundedStartDate() {
		return refundedStartDate;
	}

	public void setRefundedStartDate(String refundedStartDate) {
		this.refundedStartDate = refundedStartDate;
	}

	public String getRefundedEndDate() {
		return refundedEndDate;
	}

	public void setRefundedEndDate(String refundedEndDate) {
		this.refundedEndDate = refundedEndDate;
	}

}
