package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.enums.RefundType;
import com.lvmama.lvf.common.dto.enums.RefundmentType;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundInfoDto;
import com.lvmama.lvf.common.dto.status.OpSource;

/**
 * 
 * 退款信息请求
 * @author lven
 *
 */
public class FlightOrderRefundInfoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5340069086382339632L;
	
	private  FlightOrderRefundInfoDto flightOrderRefundDto = new FlightOrderRefundInfoDto();

	public String getOrderNo() {
		return flightOrderRefundDto.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		flightOrderRefundDto.setOrderNo(orderNo);
	}

	public String getOrderId() {
		return flightOrderRefundDto.getOrderId();
	}

	public void setOrderId(String orderId) {
		flightOrderRefundDto.setOrderId(orderId);
	}

	public String getOperatorName() {
		return flightOrderRefundDto.getOperatorName();
	}

	public void setOperatorName(String operatorName) {
		flightOrderRefundDto.setOperatorName(operatorName);
	}

	public String getOrderUserId() {
		return flightOrderRefundDto.getOrderUserId();
	}

	public void setOrderUserId(String orderUserId) {
		flightOrderRefundDto.setOrderUserId(orderUserId);
	}

	public BigDecimal getAmount() {
		return flightOrderRefundDto.getAmount();
	}

	public void setAmount(BigDecimal amount) {
		flightOrderRefundDto.setAmount(amount);
	}


	public String getBizType() {
		return flightOrderRefundDto.getBizType();
	}

	public void setBizType(String bizType) {
		flightOrderRefundDto.setBizType(bizType);
	}

	public String getSignature() {
		return flightOrderRefundDto.getSignature();
	}

	public void setSignature(String signature) {
		flightOrderRefundDto.setSignature(signature);
	}

	public OpSource getOpSource() {
		return flightOrderRefundDto.getOpSource();
	}

	public void setOpSource(OpSource opSource) {
		flightOrderRefundDto.setOpSource(opSource);
	}
	
	public String getLvmamaRefundSuccessUrl() {
		return flightOrderRefundDto.getLvmamaRefundSuccessUrl();
	}

	public void setLvmamaRefundSuccessUrl(String lvmamaRefundSuccessUrl) {
		flightOrderRefundDto.setLvmamaRefundSuccessUrl(lvmamaRefundSuccessUrl);
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

	public String getRefundBankCode() {
		return flightOrderRefundDto.getRefundBankCode();
	}

	public void setRefundBankCode(String refundBankCode) {
		flightOrderRefundDto.setRefundBankCode(refundBankCode);
	}
	
	public FlightOrderRefundInfoDto getFlightOrderRefundDto() {
		return flightOrderRefundDto;
	}

	public void setFlightOrderRefundDto(FlightOrderRefundInfoDto flightOrderRefundDto) {
		this.flightOrderRefundDto = flightOrderRefundDto;
	}

	public String getRefundRemark() {
		return flightOrderRefundDto.getRefundRemark();
	}

	public void setRefundRemark(String refundRemark) {
		flightOrderRefundDto.setRefundRemark(refundRemark);
	}

	public RefundType getRefundType() {
		return flightOrderRefundDto.getRefundType();
	}

	public void setRefundType(RefundType refundType) {
		flightOrderRefundDto.setRefundType(refundType);
	}

	public RefundmentType getRefundmentType() {
		return flightOrderRefundDto.getRefundmentType();
	}

	public void setRefundmentType(RefundmentType refundmentType) {
		flightOrderRefundDto.setRefundmentType(refundmentType);
	}

	public void copyOfflineRefundRequest(FlightOrderOfflineRefundRequest request){
		this.setOrderId(request.getOrderId()+"");
		this.setOrderUserId(request.getRefunderId());
		this.setAmount(request.getRefundAmount());
		this.setOrderNo(request.getOrderNo());
		this.setOperatorName(request.getRefunderName());
		this.setRefundType(request.getRefundType());
		this.setRefundmentType(request.getRefundmentType());
		this.setRefundBankCode(request.getRefundBankCode());
		this.setRefunderId(request.getRefunderId());
		this.setRefunderName(request.getRefunderName());
		this.setRefundRemark(request.getRefundRemark());
	}
	
	
	
}
