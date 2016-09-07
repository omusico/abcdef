package com.lvmama.lvf.common.dto.order.pay;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.request.FlightOrderRefundRequest;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;

/**
 * 退款信息
 * 
 * @author lven
 * 
 */
public class FlightOrderRefundDto extends Entity implements Serializable {

	private static final long serialVersionUID = -8092830558535665909L;

	/** 主订单主键 */
	private Long orderMainId;

	/** 子订单主键 */
	private Long orderId;

	/** 订单号信息 */
	private FlightOrderNoDto flightOrderNo;

	/** 退款单号 传给vst支付系统 */
	private String refundNo;

	/** 退款流水号 */
	private String refundSerialNumber;

	/** 退款类型 */
	private PayType refundType;

	/** 退款方式类型 */
	private PaymentType refundmentType;

	/** 退款银行编码 */
	private String refundBankCode;

	/** 退款金额 */
	private BigDecimal refundAmount;

	/** 退款状态 */
	private ResultStatus refundStatus;

	/** 退款申请时间 */
	private Date refundApplyTime;

	/** 退款完成时间 */
	private Date refundTime;

	/** 退款人ID */
	private String refunderId;

	/** 退款人名称 */
	private String refunderName;

	/** 订单回调成功失败状态 */
	private ResultStatus orderCallbackStatus;
	
	/** 同步主站退款流水号标志 */
	private String isSync;
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_REFUND";
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getRefundSerialNumber() {
		return refundSerialNumber;
	}

	public void setRefundSerialNumber(String refundSerialNumber) {
		this.refundSerialNumber = refundSerialNumber;
	}

	public String getRefundBankCode() {
		return refundBankCode;
	}

	public void setRefundBankCode(String refundBankCode) {
		this.refundBankCode = refundBankCode;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Date getRefundApplyTime() {
		return refundApplyTime;
	}

	public void setRefundApplyTime(Date refundApplyTime) {
		this.refundApplyTime = refundApplyTime;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public String getRefunderId() {
		return refunderId;
	}

	public void setRefunderId(String refunderId) {
		this.refunderId = refunderId;
	}

	public String getRefunderName() {
		return refunderName;
	}

	public void setRefunderName(String refunderName) {
		this.refunderName = refunderName;
	}

	public String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderNo;
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		this.flightOrderNo = flightOrderNo;
	}

	public ResultStatus getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(ResultStatus refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getIsSync() {
		return isSync;
	}

	public void setIsSync(String isSync) {
		this.isSync = isSync;
	}

	public void copyFrom(FlightOrderPaymentDto paymentDto) {
		this.setRefundNo(paymentDto.getPaymentNo());
		this.setRefundmentType(paymentDto.getPaymentType());
		this.setRefundType(this.getRefundmentType().getPayType());
		this.setRefundBankCode(paymentDto.getPaymentBankCode());
		this.setRefunderId(paymentDto.getPayerId());
		this.setRefunderName(paymentDto.getPayerName());
		this.setRefundStatus(ResultStatus.APPLY);
		this.setRefundApplyTime(new Date());

	}

	public ResultStatus getOrderCallbackStatus() {
		return orderCallbackStatus;
	}

	public void setOrderCallbackStatus(ResultStatus orderCallbackStatus) {
		this.orderCallbackStatus = orderCallbackStatus;
	}

	/**
	 * 退款回调时，回填的数据
	 * 
	 * @param refundRequest
	 * @return
	 */
	public FlightOrderRefundDto buildRefundDtoCallBackBy(FlightOrderRefundRequest refundRequest, FlightOrderRefundDto refundDto) {
		if (StringUtil.isNotEmptyString(refundRequest.getRefundSerialNumber())) {
			this.setRefundSerialNumber(refundRequest.getRefundSerialNumber());
		}
		this.setRefundStatus(refundRequest.getRefundStatus());
		this.setRefundTime(new Date());
		this.setRefundmentType(refundDto.getRefundmentType());
		this.setRefundType(refundDto.getRefundmentType().getPayType());
		this.setOrderCallbackStatus(refundRequest.getRefundStatus());
		return this;
	}

	public PayType getRefundType() {
		return refundType;
	}

	public void setRefundType(PayType refundType) {
		this.refundType = refundType;
	}

	public PaymentType getRefundmentType() {
		return refundmentType;
	}

	public void setRefundmentType(PaymentType refundmentType) {
		this.refundmentType = refundmentType;
	}

	@Override
	public String toString() {
		return "FlightOrderRefundDto [orderMainId=" + orderMainId + ", orderId=" + orderId + ", flightOrderNo=" + flightOrderNo + ", refundNo=" + refundNo + ", refundSerialNumber="
				+ refundSerialNumber + ", refundType=" + refundType + ", refundmentType=" + refundmentType + ", refundBankCode=" + refundBankCode + ", refundAmount=" + refundAmount
				+ ", refundStatus=" + refundStatus + ", refundApplyTime=" + refundApplyTime + ", refundTime=" + refundTime + ", refunderId=" + refunderId + ", refunderName=" + refunderName
				+ ", orderCallbackStatus=" + orderCallbackStatus + "]";
	}

	public String buildExportInfoByCVS() {
		StringBuffer paymentBuffer = new StringBuffer();
		paymentBuffer.append("\t").append(this.getRefundNo()).append(",");
		paymentBuffer.append("正常退款,");// 退款类型
		if (this.getRefundSerialNumber() != null) {
			paymentBuffer.append(this.getRefundSerialNumber()).append(",");
		} else {
			paymentBuffer.append(",");
		}

		paymentBuffer.append(",");// 网关流水号
		if (this.getRefundmentType() != null) {
			paymentBuffer.append(this.getRefundmentType().getCnName()).append(",");
		} else {
			paymentBuffer.append(",");
		}

		paymentBuffer.append(this.getRefundAmount()).append(",");
		if (this.getRefundStatus() != null) {
			paymentBuffer.append(this.getRefundStatus().getCnName()).append(",");
		} else {
			paymentBuffer.append(",");
		}

		if (this.getOrderCallbackStatus() != null) {
			paymentBuffer.append(this.getOrderCallbackStatus().getCnName()).append(",");
		} else {
			paymentBuffer.append(",");
		}
		if(this.getRefundTime()!=null){
			paymentBuffer.append("\t").append(DateUtils.formatCnHmDate(this.getRefundTime())).append(",");
		}else{
			paymentBuffer.append(",");
		}
		
		paymentBuffer.append(",");// 对账流水号
		if(this.getFlightOrderNo()!=null){
			paymentBuffer.append("\t").append(this.getFlightOrderNo().getOrderNo()).append(",");
		}else{
			paymentBuffer.append(",");
		}
		paymentBuffer.append(",");// VST订单号
		paymentBuffer.append(",");// VST退款ID
		if(this.getCreateTime()!=null){
			paymentBuffer.append("\t").append(DateUtils.formatCnHmDate(this.getCreateTime())).append(",");
		}else{
			paymentBuffer.append(",");
		}
		return paymentBuffer.toString();
	}

}
