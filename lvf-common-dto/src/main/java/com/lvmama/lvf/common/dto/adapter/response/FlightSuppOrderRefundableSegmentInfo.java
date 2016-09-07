package com.lvmama.lvf.common.dto.adapter.response;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderPassengerDto;

public class FlightSuppOrderRefundableSegmentInfo {
	private FlightOrderSuppOrderPassengerDto flightOrderSuppOrderPassenger;
	//个人是否可退
	private Boolean refundable;
	//个人不可退原因
	private String unrefunableReason;
	//航段序号
	private Long sequence;
	//退票费率
	private BigDecimal refundRate;
	//退票费用
	private BigDecimal refundFee;
	//是否能计算出退票费          这个字段是false的话 就代表无法计算的是不能通过退票申请接口提交申请哦，
	//只能人工客服在qq群里问一下退票手续费在申请啦 这类情况极少
	private boolean refundFeeAvailable;
	//是否紧急
	private boolean isUrgent;
	
	public FlightOrderSuppOrderPassengerDto getFlightOrderSuppOrderPassenger() {
		return flightOrderSuppOrderPassenger;
	}
	public void setFlightOrderSuppOrderPassenger(
			FlightOrderSuppOrderPassengerDto flightOrderSuppOrderPassenger) {
		this.flightOrderSuppOrderPassenger = flightOrderSuppOrderPassenger;
	}
	public Boolean getRefundable() {
		return refundable;
	}
	public void setRefundable(Boolean refundable) {
		this.refundable = refundable;
	}
	public String getUnrefunableReason() {
		return unrefunableReason;
	}
	public void setUnrefunableReason(String unrefunableReason) {
		this.unrefunableReason = unrefunableReason;
	}
	public Long getSequence() {
		return sequence;
	}
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	public BigDecimal getRefundRate() {
		return refundRate;
	}
	public void setRefundRate(BigDecimal refundRate) {
		this.refundRate = refundRate;
	}
	public BigDecimal getRefundFee() {
		return refundFee;
	}
	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}
	public boolean isRefundFeeAvailable() {
		return refundFeeAvailable;
	}
	public void setRefundFeeAvailable(boolean refundFeeAvailable) {
		this.refundFeeAvailable = refundFeeAvailable;
	}
	public boolean isUrgent() {
		return isUrgent;
	}
	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	
}
