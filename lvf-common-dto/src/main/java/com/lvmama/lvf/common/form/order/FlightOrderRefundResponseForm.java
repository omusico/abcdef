package com.lvmama.lvf.common.form.order;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 订单退款 ResponseForm
 * 
 * @author zzs
 * 
 */

public class FlightOrderRefundResponseForm implements Form {

	private FlightOrderRefundDto flightOrderRefundDto = new FlightOrderRefundDto();

	public FlightOrderRefundResponseForm() {
		super();
	}

	public FlightOrderRefundResponseForm(FlightOrderRefundDto flightOrderRefundDto) {
		super();
		this.flightOrderRefundDto = flightOrderRefundDto;
	}

	public Long getId() {
		return flightOrderRefundDto.getId();
	}

	public void setId(Long id) {
		flightOrderRefundDto.setId(id);
	}

	public String getUuid() {
		return flightOrderRefundDto.getUuid();
	}

	public String getCreateTime() {
		if (null != flightOrderRefundDto.getCreateTime()) {
			return DateUtils.formatCnHmDate(flightOrderRefundDto.getRefundTime());
		}
		return "";
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

	public String getRefundTime() {
		if (flightOrderRefundDto.getRefundTime() != null) {
			return DateUtils.formatCnHmDate(flightOrderRefundDto.getRefundTime());
		}
		return "";
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

	public String getRefundStatus() {
		if (flightOrderRefundDto.getRefundStatus() != null) {
			return flightOrderRefundDto.getRefundStatus().getCnName();
		}
		return "";
	}

	public void setRefundStatus(ResultStatus refundStatus) {
		flightOrderRefundDto.setRefundStatus(refundStatus);
	}

	public FlightOrderRefundDto getFlightOrderRefundDto() {
		return flightOrderRefundDto;
	}

	public void setFlightOrderRefundDto(FlightOrderRefundDto flightOrderRefundDto) {
		this.flightOrderRefundDto = flightOrderRefundDto;
	}

	public PayType getRefundType() {
		return flightOrderRefundDto.getRefundType();
	}

	public void setRefundType(PayType refundType) {
		flightOrderRefundDto.setRefundType(refundType);
	}

	public String getRefundmentType() {
		if (flightOrderRefundDto.getRefundmentType() != null) {
			return flightOrderRefundDto.getRefundmentType().getCnName();
		}
		return "";
	}

	public void setRefundmentType(PaymentType refundmentType) {
		flightOrderRefundDto.setRefundmentType(refundmentType);
	}

	public String getOrderCallbackStatus() {
		if (flightOrderRefundDto.getOrderCallbackStatus() != null) {
			return flightOrderRefundDto.getOrderCallbackStatus().getCnName();
		}
		return "";
	}

	public void setOrderCallbackStatus(ResultStatus orderCallbackStatus) {
		flightOrderRefundDto.setOrderCallbackStatus(orderCallbackStatus);
	}

	/**
	 * 满足一下三个条件才能<重复发起退款>
	 * 1：退款申请状态等于Apply或者等于Fail 
	 * 2：订单退款回调状态等于空 满足以上两条件可申请退款
	 * 3：订单支付回调状态为空
	 * @return
	 */
	public boolean isCanRepeatRefund() {
		if ((ResultStatus.APPLY == getFlightOrderRefundDto().getRefundStatus() || ResultStatus.FAIL == getFlightOrderRefundDto().getRefundStatus())
				&& null == getFlightOrderRefundDto().getOrderCallbackStatus()) {
			return true;
		}
		return false;
	}

}
