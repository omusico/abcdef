package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvf.common.dto.enums.TradeType;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppPaymentDto;

public class FlightOrderSuppPaymentRequest implements Serializable, Dto {
	
	private FlightOrderSuppPaymentDto flightOrderSuppPaymentDto = new FlightOrderSuppPaymentDto();

	private String tradeTimeBeginTime;
	
	private String tradeTimeEndTime;
	
	public FlightOrderSuppPaymentDto getFlightOrderSuppPaymentDto() {
		return flightOrderSuppPaymentDto;
	}
	public void setFlightOrderSuppPaymentDto(
			FlightOrderSuppPaymentDto flightOrderSuppPaymentDto) {
		this.flightOrderSuppPaymentDto = flightOrderSuppPaymentDto;
	}
	
	public String getSuppOrderNo() {
		return flightOrderSuppPaymentDto.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		flightOrderSuppPaymentDto.setSuppOrderNo(suppOrderNo);
	}

	public String getSuppCode() {
		return flightOrderSuppPaymentDto.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		flightOrderSuppPaymentDto.setSuppCode(suppCode);
	}

	public String getSuppTradeAccount() {
		return flightOrderSuppPaymentDto.getSuppTradeAccount();
	}

	public void setSuppTradeAccount(String suppTradeAccount) {
		flightOrderSuppPaymentDto.setSuppTradeAccount(suppTradeAccount);
	}

	public PaymentType getTradeChannel() {
		return flightOrderSuppPaymentDto.getTradeChannel();
	}

	public void setTradeChannel(PaymentType tradeChannel) {
		flightOrderSuppPaymentDto.setTradeChannel(tradeChannel);
	}

	public TradeType getTradeType() {
		  return flightOrderSuppPaymentDto.getTradeType();
	}

	public void setTradeType(TradeType tradeType) {
		flightOrderSuppPaymentDto.setTradeType(tradeType);
	}

	public BigDecimal getTradeAmount() {
		return flightOrderSuppPaymentDto.getTradeAmount();
	}

	public void setTradeAmount(BigDecimal tradeAmount) {
		flightOrderSuppPaymentDto.setTradeAmount(tradeAmount);
	}

	public String getTradeNo() {
		return flightOrderSuppPaymentDto.getTradeNo();
	}

	public void setTradeNo(String tradeNo) {
		flightOrderSuppPaymentDto.setTradeNo(tradeNo);
	}

	public String getTradeSerialNo() {
		return flightOrderSuppPaymentDto.getTradeSerialNo();
	}

	public void setTradeSerialNo(String tradeSerialNo) {
		flightOrderSuppPaymentDto.setTradeSerialNo(tradeSerialNo);
	}

	public Date getTradeTime() {
		return flightOrderSuppPaymentDto.getTradeTime();
	}

	public void setTradeTime(Date tradeTime) {
		flightOrderSuppPaymentDto.setTradeTime(tradeTime);
	}

	public Product getProductType() {
		return flightOrderSuppPaymentDto.getProductType();
	}

	public void setProductType(Product productType) {
		flightOrderSuppPaymentDto.setProductType(productType);
	}
	
	@Override
	public Long getId() {
		return flightOrderSuppPaymentDto.getId();
	}
	public String getTradeTimeBeginTime() {
		return tradeTimeBeginTime;
	}
	public void setTradeTimeBeginTime(String tradeTimeBeginTime) {
		this.tradeTimeBeginTime = tradeTimeBeginTime;
	}
	public String getTradeTimeEndTime() {
		return tradeTimeEndTime;
	}
	public void setTradeTimeEndTime(String tradeTimeEndTime) {
		this.tradeTimeEndTime = tradeTimeEndTime;
	}
	
}
