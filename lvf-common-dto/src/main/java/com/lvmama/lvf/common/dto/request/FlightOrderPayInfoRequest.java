package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.lvmama.lvf.common.dto.enums.PaySource;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPayInfoDto;
import com.lvmama.lvf.common.dto.status.OpSource;

/**
 * 
 * 支付信息请求
 * @author lven
 *
 */
public class FlightOrderPayInfoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2376462460103573333L;

	private FlightOrderPayInfoDto flightOrderPayInfoDto = new FlightOrderPayInfoDto();
	
	public void setFlightOrderPayInfoDto(FlightOrderPayInfoDto flightOrderPayInfoDto) {
		this.flightOrderPayInfoDto = flightOrderPayInfoDto;
	}

	public String getOrderNo() {
		return flightOrderPayInfoDto.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		flightOrderPayInfoDto.setOrderNo(orderNo);
	}

	public OpSource getOpSource() {
		return flightOrderPayInfoDto.getOpSource();
	}

	public void setOpSource(OpSource opSource) {
		flightOrderPayInfoDto.setOpSource(opSource);
	}

	public String getPayerId() {
		return flightOrderPayInfoDto.getPayerId();
	}

	public void setPayerId(String payerId) {
		flightOrderPayInfoDto.setPayerId(payerId);
	}

	public String getPayerName() {
		return flightOrderPayInfoDto.getPayerName();
	}

	public void setPayerName(String payerName) {
		flightOrderPayInfoDto.setPayerName(payerName);
	}

	public String getObjectMainId() {
		return flightOrderPayInfoDto.getObjectMainId();
	}

	public void setObjectMainId(String objectMainId) {
		flightOrderPayInfoDto.setObjectMainId(objectMainId);
	}
	
	public String getObjectId() {
		return flightOrderPayInfoDto.getObjectId();
	}

	public void setObjectId(String objectId) {
		flightOrderPayInfoDto.setObjectId(objectId);
	}

	public String getObjectType() {
		return flightOrderPayInfoDto.getObjectType();
	}

	public void setObjectType(String objectType) {
		flightOrderPayInfoDto.setObjectType(objectType);
	}

	public BigDecimal getAmount() {
		return flightOrderPayInfoDto.getAmount();
	}

	public void setAmount(BigDecimal amount) {
		flightOrderPayInfoDto.setAmount(amount);
	}

	public String getBizType() {
		return flightOrderPayInfoDto.getBizType();
	}

	public void setBizType(String bizType) {
		flightOrderPayInfoDto.setBizType(bizType);
	}

	public String getLvmamaPaymentSuccessUrl() {
		return flightOrderPayInfoDto.getLvmamaPaymentSuccessUrl();
	}

	public void setLvmamaPaymentSuccessUrl(String lvmamaPaymentSuccessUrl) {
		flightOrderPayInfoDto
				.setLvmamaPaymentSuccessUrl(lvmamaPaymentSuccessUrl);
	}

	public String getSignature() {
		return flightOrderPayInfoDto.getSignature();
	}

	public void setSignature(String signature) {
		flightOrderPayInfoDto.setSignature(signature);
	}

	public String getPaymentBankCode() {
		return flightOrderPayInfoDto.getPaymentBankCode();
	}

	public void setPaymentBankCode(String paymentBankCode) {
		flightOrderPayInfoDto.setPaymentBankCode(paymentBankCode);
	}

	public PaymentType getPaymentType() {
		return flightOrderPayInfoDto.getPaymentType();
	}

	public void setPaymentType(PaymentType paymentType) {
		flightOrderPayInfoDto.setPaymentType(paymentType);
	}

	public String getPaymentTypeStr() {
		return flightOrderPayInfoDto.getPaymentTypeStr();
	}

	public void setPaymentTypeStr(String paymentTypeStr) {
		flightOrderPayInfoDto.setPaymentTypeStr(paymentTypeStr);
	}
	
	public PayType getPayType() {
		return flightOrderPayInfoDto.getPayType();
	}

	public void setPayType(PayType payType) {
		flightOrderPayInfoDto.setPayType(payType);
	}
	
	public String getPayRemark() {
		return flightOrderPayInfoDto.getPayRemark();
	}

	public void setPayRemark(String payRemark) {
		flightOrderPayInfoDto.setPayRemark(payRemark);
	}

	public FlightOrderPayInfoDto getFlightOrderPayInfoDto() {
		return flightOrderPayInfoDto;
	}

	
	public PaySource getPaySource() {
		return flightOrderPayInfoDto.getPaySource();
	}

	public void setPaySource(PaySource paySource) {
		flightOrderPayInfoDto.setPaySource(paySource);
	}

	
	@Autowired
	public void copyOrderPayRequest(FlightOrderOfflinePayRequest request){
		//transfer from UI
		this.setObjectId(request.getOrderId()==null?null:request.getOrderId().toString());
		this.setObjectMainId(request.getOrderMainId()==null?null:request.getOrderMainId().toString());
		if(request.getFlightOrderNo() != null){
			this.setOrderNo(request.getFlightOrderNo().getOrderNo());
		}
	    this.setPayerId(request.getPayerId());
	    this.setPayerName(request.getPayerName());
	    
	    //default
		this.setOpSource(OpSource.BACK);
		this.setPaySource(PaySource.LVF_CENTER);
	}


	@Override
	public String toString() {
		return flightOrderPayInfoDto.toString();
	}
}
