package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.PaySource;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPaymentDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;

@XmlRootElement
public class FlightOrderPayRequest implements Serializable {
	
	private static final long serialVersionUID = 8844732353045696173L;
	
	private FlightOrderPaymentDto flightOrderPaymentDto = new FlightOrderPaymentDto();
	
	/** 支付备注 */
	private String payRemark;
	
	
	
	public Integer getSyncCount() {
		return flightOrderPaymentDto.getSyncCount();
	}

	public void setSyncCount(Integer syncCount) {
		flightOrderPaymentDto.setSyncCount(syncCount);
	}

	public FlightOrderPaymentDto getFlightOrderPaymentDto() {
		return flightOrderPaymentDto;
	}

	public void setFlightOrderPaymentDto(FlightOrderPaymentDto flightOrderPaymentDto) {
		this.flightOrderPaymentDto = flightOrderPaymentDto;
	}

	public PersistenceType getPtype() {
		return flightOrderPaymentDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		flightOrderPaymentDto.setPtype(ptype);
	}

	public Long getId() {
		return flightOrderPaymentDto.getId();
	}

	public void setId(Long id) {
		flightOrderPaymentDto.setId(id);
	}

	public Date getCreateTime() {
		return flightOrderPaymentDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderPaymentDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderPaymentDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderPaymentDto.setUpdateTime(updateTime);
	}

	public Long getOrderMainId() {
		return flightOrderPaymentDto.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightOrderPaymentDto.setOrderMainId(orderMainId);
	}

	public String getPaymentSerialNumber() {
		return flightOrderPaymentDto.getPaymentSerialNumber();
	}

	public void setPaymentSerialNumber(String paymentSerialNumber) {
		flightOrderPaymentDto.setPaymentSerialNumber(paymentSerialNumber);
	}

	public String getPaymentBankCode() {
		return flightOrderPaymentDto.getPaymentBankCode();
	}

	public void setPaymentBankCode(String paymentBankCode) {
		flightOrderPaymentDto.setPaymentBankCode(paymentBankCode);
	}

	public BigDecimal getPayedAmount() {
		return flightOrderPaymentDto.getPayedAmount();
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		flightOrderPaymentDto.setPayedAmount(payedAmount);
	}

	public ResultStatus getResultStatus() {
		return flightOrderPaymentDto.getPaymentStatus();
	}

	public void setResultStatus(ResultStatus resultStatus) {
		flightOrderPaymentDto.setPaymentStatus(resultStatus);
	}

	public Date getPayApplyTime() {
		return flightOrderPaymentDto.getPayApplyTime();
	}

	public void setPayApplyTime(Date payApplyTime) {
		flightOrderPaymentDto.setPayApplyTime(payApplyTime);
	}

	public Date getPayedTime() {
		return flightOrderPaymentDto.getPayedTime();
	}

	public void setPayedTime(Date payedTime) {
		flightOrderPaymentDto.setPayedTime(payedTime);
	}

	public String getPayerId() {
		return flightOrderPaymentDto.getPayerId();
	}

	public void setPayerId(String payerId) {
		flightOrderPaymentDto.setPayerId(payerId);
	}

	public String getPayerName() {
		return flightOrderPaymentDto.getPayerName();
	}

	public void setPayerName(String payerName) {
		flightOrderPaymentDto.setPayerName(payerName);
	}

	public Long getOrderId() {
		return flightOrderPaymentDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderPaymentDto.setOrderId(orderId);
	}

	public String getPaymentNo() {
		return flightOrderPaymentDto.getPaymentNo();
	}

	public void setPaymentNo(String paymentNo) {
		flightOrderPaymentDto.setPaymentNo(paymentNo);
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderPaymentDto.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		flightOrderPaymentDto.setFlightOrderNo(flightOrderNo);
	}
	
	public ResultStatus getOrderCallbackStatus() {
		return flightOrderPaymentDto.getOrderCallbackStatus();
	}

	public void setOrderCallbackStatus(ResultStatus orderCallbackStatus) {
		flightOrderPaymentDto.setOrderCallbackStatus(orderCallbackStatus);
	}

	public ResultStatus getPaymentStatus() {
		return flightOrderPaymentDto.getPaymentStatus();
	}

	public void setPaymentStatus(ResultStatus resultStatus) {
		flightOrderPaymentDto.setPaymentStatus(resultStatus);
	}

	public PayType getPayType() {
		return flightOrderPaymentDto.getPayType();
	}

	public void setPayType(PayType payType) {
		flightOrderPaymentDto.setPayType(payType);
	}

	public PaymentType getPaymentType() {
		return flightOrderPaymentDto.getPaymentType();
	}

	public void setPaymentType(PaymentType paymentType) {
		flightOrderPaymentDto.setPaymentType(paymentType);
	}
	
	public String getPayRemark() {
		return payRemark;
	}

	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}

	public String getPaymentTypeStr() {
		return flightOrderPaymentDto.getPaymentTypeStr();
	}

	public void setPaymentTypeStr(String paymentTypeStr) {
		flightOrderPaymentDto.setPaymentTypeStr(paymentTypeStr);
	}

	@Autowired
	public void copyOrderPayCallBackRequest(FlightOrderOfflinePayRequest request){
		this.setPaymentNo(request.getPaymentNo());
		this.setPaymentSerialNumber(request.getPaymentSerialNumber());
		this.setPayRemark(request.getPayRemark());
		this.setPayType(request.getPaymentType().getPayType());
		this.setPaymentType(request.getPaymentType());
		this.setPaymentTypeStr(request.getPaymentType().name());
		this.setPaymentStatus(ResultStatus.SUCCESS);
		this.setPaySource(PaySource.LVF_CENTER);
	}

	public PaySource getPaySource() {
		return flightOrderPaymentDto.getPaySource();
	}

	public void setPaySource(PaySource paySource) {
		flightOrderPaymentDto.setPaySource(paySource);
	}
	
	@Override
	public String toString() {
		return flightOrderPaymentDto.toString();
	}
}
