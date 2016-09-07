/**
 * 
 */
package com.lvmama.lvf.common.dto.order.pay;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.enums.RefundType;
import com.lvmama.lvf.common.dto.enums.RefundmentType;
import com.lvmama.lvf.common.dto.status.OpSource;

/**
 * 支付信息
 * @author lven
 *
 */

public class FlightOrderRefundInfoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8722984870002027940L;

	/** 订单号 */
	private String orderNo;
	
	/** 订单id */
	private String orderId;
	
	/** 发起退款的人 */
	private String operatorName;
	
	/** 订单用户id */
	private String orderUserId;
	
	/** 退款金额 */
	private BigDecimal amount;
	
	/** 退款类型 */
	private RefundType refundType;

	/** 退款方式类型 */
	private RefundmentType refundmentType;
	
	/** 业务类型 */
	private String bizType;
	
	/** 回调通知地址（支付成功通知、退款通知），不参与签名 */
	private String lvmamaRefundSuccessUrl;
	
	/**md5安全吗 */
	private String signature;
	
	/**操作来源*/
	private OpSource opSource;

	/**退款人ID(退款账户ID) */
	private String refunderId;
	
	/** 退款人名称 (退款账户人的名字)*/
	private String refunderName;
	
	/** 退款银行编码 */
	private String refundBankCode;
	
	private String refundRemark;
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
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


	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public OpSource getOpSource() {
		return opSource;
	}

	public void setOpSource(OpSource opSource) {
		this.opSource = opSource;
	}

	public String getLvmamaRefundSuccessUrl() {
		return lvmamaRefundSuccessUrl;
	}

	public void setLvmamaRefundSuccessUrl(String lvmamaRefundSuccessUrl) {
		this.lvmamaRefundSuccessUrl = lvmamaRefundSuccessUrl;
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

	public String getRefundBankCode() {
		return refundBankCode;
	}

	public void setRefundBankCode(String refundBankCode) {
		this.refundBankCode = refundBankCode;
	}

	public String getRefundRemark() {
		return refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
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

}
