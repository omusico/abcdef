package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.RefundType;
import com.lvmama.lvf.common.dto.enums.RefundmentType;
import com.lvmama.lvf.common.dto.status.ResultStatus;

/**
 * 
 * 线下退款请求
 * 
 * @author zzs
 * 
 */
public class FlightOrderOfflineRefundRequest implements Serializable, Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5458407590642756009L;

	/** 主订单主键 */
	private Long orderMainId;

	/** 子订单主键 */
	private Long orderId;

	/** 订单号信息 */
	private String orderNo;

	/** 退款单号 传给vst支付系统 */
	private String refundNo;

	/** 退款流水号 */
	private String refundSerialNumber;

	/** 退款类型 */
	private RefundType refundType;

	/** 退款方式类型 */
	private RefundmentType refundmentType;

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

	/** 退款备注 */
	private String refundRemark;

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}

	public String getRefundSerialNumber() {
		return refundSerialNumber;
	}

	public void setRefundSerialNumber(String refundSerialNumber) {
		this.refundSerialNumber = refundSerialNumber;
	}

	public RefundType getRefundType() {
		return refundType;
	}

	public void setRefundType(RefundType refundType) {
		this.refundType = refundType;
	}

	public RefundmentType getRefundmentType() {
		return refundmentType;
	}

	public void setRefundmentType(RefundmentType refundmentType) {
		this.refundmentType = refundmentType;
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

	public String getRefundRemark() {
		return refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public ResultStatus getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(ResultStatus refundStatus) {
		this.refundStatus = refundStatus;
	}
	
	@JsonIgnore
	@Override
	public Long getId() {
		return null;
	}
}
