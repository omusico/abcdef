package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.status.OpSource;
import com.lvmama.lvf.common.dto.status.ResultStatus;

/**
 * 
 * 线下支付请求
 * 
 * @author zzs
 * 
 */
public class FlightOrderOfflinePayRequest implements Serializable, Dto {

	private static final long serialVersionUID = -3824108755399142105L;

	/** 子订单主键 */
	private Long orderId;
	/** 主订单主键 */
	private Long orderMainId;
	/** 订单号信息 */
	private FlightOrderNoDto flightOrderNo;
	/** 支付人ID */
	private String payerId;
	/** 支付人名称 */
	private String payerName;
	/** 支付金额 */
	private BigDecimal amount;
	/** 业务类型 */
	private String bizType;
	/** 操作来源 */
	private OpSource opSource;

	/** 支付类型 */
	private PayType payType;
	/** 支付方式类型 */
	private PaymentType paymentType;
	/** 原始支付方式 */
	private String paymentTypeStr;
	/** 支付单号 */
	private String paymentNo;
	/** 支付金额 */
	private BigDecimal payedAmount;
	/** 支付单支付状态 */
	private ResultStatus paymentStatus;
	/** 支付来源 */
	private String paySource;
	/** 支付流水号 */
	private String paymentSerialNumber;
	/** 支付银行编码 */
	private String paymentBankCode;
	/** 订单回调成功失败状态 */
	private ResultStatus orderCallbackStatus;
	/** 支付备注 */
	private String payRemark;

	/** 主订单和子订单关联主键 */
	private String refNo;

	/** 创建开始时间 */
	private String createStartDate;
	/** 创建结束时间 */
	private String createEndDate;
	/** 已支付开始时间 */
	private String payedStartDate;
	/** 已支付完成时间 */
	private String payedEndDate;
	
	/**回调计数*/
	private Integer syncCount;

	@JsonIgnore
	@Override
	public Long getId() {
		return null;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public OpSource getOpSource() {
		return opSource;
	}

	public void setOpSource(OpSource opSource) {
		this.opSource = opSource;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public BigDecimal getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		this.payedAmount = payedAmount;
	}

	public ResultStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(ResultStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaySource() {
		return paySource;
	}

	public void setPaySource(String paySource) {
		this.paySource = paySource;
	}

	public String getPaymentSerialNumber() {
		return paymentSerialNumber;
	}

	public void setPaymentSerialNumber(String paymentSerialNumber) {
		this.paymentSerialNumber = paymentSerialNumber;
	}

	public String getPaymentBankCode() {
		return paymentBankCode;
	}

	public void setPaymentBankCode(String paymentBankCode) {
		this.paymentBankCode = paymentBankCode;
	}

	public ResultStatus getOrderCallbackStatus() {
		return orderCallbackStatus;
	}

	public void setOrderCallbackStatus(ResultStatus orderCallbackStatus) {
		this.orderCallbackStatus = orderCallbackStatus;
	}

	public String getPayRemark() {
		return payRemark;
	}

	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
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

	public String getPayedStartDate() {
		return payedStartDate;
	}

	public void setPayedStartDate(String payedStartDate) {
		this.payedStartDate = payedStartDate;
	}

	public String getPayedEndDate() {
		return payedEndDate;
	}

	public void setPayedEndDate(String payedEndDate) {
		this.payedEndDate = payedEndDate;
	}

	public Integer getSyncCount() {
		return syncCount;
	}

	public void setSyncCount(Integer syncCount) {
		this.syncCount = syncCount;
	}

	public String getPaymentTypeStr() {
		return paymentTypeStr;
	}

	public void setPaymentTypeStr(String paymentTypeStr) {
		this.paymentTypeStr = paymentTypeStr;
	}
}
