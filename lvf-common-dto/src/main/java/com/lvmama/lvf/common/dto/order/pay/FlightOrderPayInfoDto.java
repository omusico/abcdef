/**
 * 
 */
package com.lvmama.lvf.common.dto.order.pay;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.enums.PaySource;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.request.FlightOrderPayInfoRequest;
import com.lvmama.lvf.common.dto.status.OpSource;

/**
 * 支付信息
 * 
 * @author lven
 *
 */

public class FlightOrderPayInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8722984870002027940L;

	/** 订单号 */
	private String orderNo;

	/** 订单主id */
	private String objectMainId;

	/** 订单id */
	private String objectId;

	/** 订单类型 */
	private String objectType;

	/** 支付金额 */
	private BigDecimal amount;

	/** 支付方式 */
	private PaymentType paymentType;
	
	/** 支付方式 原始值*/
	private String paymentTypeStr;

	/** 支付类型 */
	private PayType payType;

	/** 业务类型 */
	private String bizType;

	/** 回调通知地址（支付成功通知、退款通知），不参与签名 */
	private String lvmamaPaymentSuccessUrl;

	/** md5安全吗 */
	private String signature;

	/** 操作来源 */
	private OpSource opSource;

	/** 支付人ID */
	private String payerId;

	/** 支付人名称 */
	private String payerName;

	/** 支付银行编码 */
	private String paymentBankCode;
	
	/** 支付备注 */
	private String payRemark;
	
	/** 支付来源 */
	private PaySource paySource;
	

	public PaySource getPaySource() {
		return paySource;
	}

	public void setPaySource(PaySource paySource) {
		this.paySource = paySource;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
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

	public String getLvmamaPaymentSuccessUrl() {
		return lvmamaPaymentSuccessUrl;
	}

	public void setLvmamaPaymentSuccessUrl(String lvmamaPaymentSuccessUrl) {
		this.lvmamaPaymentSuccessUrl = lvmamaPaymentSuccessUrl;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public OpSource getOpSource() {
		return opSource;
	}

	public void setOpSource(OpSource opSource) {
		this.opSource = opSource;
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

	public String getPaymentBankCode() {
		return paymentBankCode;
	}

	public void setPaymentBankCode(String paymentBankCode) {
		this.paymentBankCode = paymentBankCode;
	}

	public String getObjectMainId() {
		return objectMainId;
	}

	public void setObjectMainId(String objectMainId) {
		this.objectMainId = objectMainId;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public String getPayRemark() {
		return payRemark;
	}

	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}
	
	public String getPaymentTypeStr() {
		return paymentTypeStr;
	}

	public void setPaymentTypeStr(String paymentTypeStr) {
		this.paymentTypeStr = paymentTypeStr;
	}

	public void copyFromPayRequest(FlightOrderPayInfoRequest flightOrderPayInfoRequest) {
		this.setObjectType(flightOrderPayInfoRequest.getObjectType());
		this.setPaymentType(flightOrderPayInfoRequest.getPaymentType());
		this.setPaymentTypeStr(flightOrderPayInfoRequest.getPaymentTypeStr());
		if(null!=flightOrderPayInfoRequest && flightOrderPayInfoRequest.getPaymentType()!=null){
			this.setPayType(flightOrderPayInfoRequest.getPaymentType().getPayType());
		}
		this.setBizType(flightOrderPayInfoRequest.getBizType());
		this.setOrderNo(flightOrderPayInfoRequest.getOrderNo());
		this.setOpSource(flightOrderPayInfoRequest.getOpSource());
		this.setPayerId(flightOrderPayInfoRequest.getPayerId());
		this.setPayerName(flightOrderPayInfoRequest.getPayerName());
		this.setSignature(flightOrderPayInfoRequest.getSignature());
        this.setPaySource(flightOrderPayInfoRequest.getPaySource());
	}

	@Override
	public String toString() {
		return "FlightOrderPayInfoDto [orderNo=" + orderNo + ", objectMainId=" + objectMainId + ", objectId=" + objectId + ", objectType=" + objectType + ", amount=" + amount + ", paymentType="
				+ paymentType + ", payType=" + payType + ", bizType=" + bizType + ", lvmamaPaymentSuccessUrl=" + lvmamaPaymentSuccessUrl + ", signature=" + signature + ", opSource=" + opSource
				+ ", payerId=" + payerId + ", payerName=" + payerName + ", paymentBankCode=" + paymentBankCode + ", payRemark=" + payRemark + ", paySource=" + paySource + ", paymentTypeStr=" + paymentTypeStr+ "]";
	}


}
