package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvf.common.dto.enums.TradeType;

/**
 * 供应商支付信息对象
 * 
 * @author jiacheng
 * @date 2015-11-27
 */
@XmlRootElement
public class FlightOrderSuppPaymentDto extends Entity implements Serializable 
{

	private static final long serialVersionUID = 7538349481085022379L;

	/** 产品类型 */
	private Product productType;
	
	/** 供应商订单编号 */
	private String suppOrderNo;
	
	/** 供应商Code */
	private String suppCode;

	/** 供应商账户名 */
	private String suppTradeAccount;
	
	/** 交易渠道 */
	private PaymentType tradeChannel;
	
	/** 交易类型 */
	private TradeType tradeType;

    /** 交易金额 */
    private BigDecimal tradeAmount;
    
    /** 交易号 */
	private String tradeNo;
	
	/** 流水号 */
	private String tradeSerialNo;
	
	/** 入账时间 */
	private Date tradeTime;
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_SUPP_PAYMENT";
	}

	public String getSuppOrderNo() {
		return suppOrderNo;
	}

	public void setSuppOrderNo(String suppOrderNo) {
		this.suppOrderNo = suppOrderNo;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getSuppTradeAccount() {
		return suppTradeAccount;
	}

	public void setSuppTradeAccount(String suppTradeAccount) {
		this.suppTradeAccount = suppTradeAccount;
	}

	public PaymentType getTradeChannel() {
		return tradeChannel;
	}

	public void setTradeChannel(PaymentType tradeChannel) {
		this.tradeChannel = tradeChannel;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getTradeSerialNo() {
		return tradeSerialNo;
	}

	public void setTradeSerialNo(String tradeSerialNo) {
		this.tradeSerialNo = tradeSerialNo;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Product getProductType() {
		return productType;
	}

	public void setProductType(Product productType) {
		this.productType = productType;
	}
}