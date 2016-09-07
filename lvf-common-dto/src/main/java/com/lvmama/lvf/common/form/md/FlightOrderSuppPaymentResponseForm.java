package com.lvmama.lvf.common.form.md;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvf.common.dto.enums.TradeType;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppPaymentDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class FlightOrderSuppPaymentResponseForm implements Serializable, Form {

	private static final long serialVersionUID = 1L;
	
	private FlightOrderSuppPaymentDto flightOrderSuppPaymentDto = new FlightOrderSuppPaymentDto();
	
	private String tradeChannelName;//交易渠道名字
	
	private String tradeTypeName;//交易类型名字
	
	private String orderTime;//处理过后的入账时间
	
	public FlightOrderSuppPaymentResponseForm(
			FlightOrderSuppPaymentDto flightOrderSuppPaymentDto) {
		super();
		this.flightOrderSuppPaymentDto = flightOrderSuppPaymentDto;
		if(this.flightOrderSuppPaymentDto!=null){
            if (this.flightOrderSuppPaymentDto.getTradeTime() != null) {
                this.orderTime = DateUtils.formatCnHmDate(this.flightOrderSuppPaymentDto.getTradeTime());
            }
		}
	}
	
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

	public String getTradeChannelName() {
		if(this.getTradeChannel()!=null)
			return getTradeChannel().getCnName();
		return tradeChannelName;
	}

	public void setTradeChannelName(String tradeChannelName) {
		this.tradeChannelName = tradeChannelName;
	}

	public String getTradeTypeName() {
		if(this.getTradeType()!=null) 
			return this.getTradeType().getCnName();
		return this.tradeTypeName;
	}

	public void setTradeTypeName(String tradeTypeName) {
		this.tradeTypeName = tradeTypeName;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
}
