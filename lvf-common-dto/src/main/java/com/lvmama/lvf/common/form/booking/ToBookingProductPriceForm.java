package com.lvmama.lvf.common.form.booking;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.form.Form;

public class ToBookingProductPriceForm implements Form{
	private PassengerType passengerType;
	private BigDecimal parPrice;
	private BigDecimal feeAmount;
	private BigDecimal taxAmount;
	private BigDecimal promotion;
	private BigDecimal salePrice;
	private Long policyId;
	private Long pricePolicyId;
	private String suppPolicyNo;
	private String suppName;
	private String suppCode;
	private String policySource; //政策来源，用于包机切位政策
	public PassengerType getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
	public BigDecimal getParPrice() {
		return parPrice;
	}
	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}
	public BigDecimal getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(BigDecimal feeAmount) {
		this.feeAmount = feeAmount;
	}
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
	public BigDecimal getPromotion() {
		return promotion;
	}
	public void setPromotion(BigDecimal promotion) {
		this.promotion = promotion;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getSuppPolicyNo() {
        return suppPolicyNo;
    }
    public void setSuppPolicyNo(String suppPolicyNo) {
        this.suppPolicyNo = suppPolicyNo;
    }
    public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public Long getPricePolicyId() {
		return pricePolicyId;
	}
	public void setPricePolicyId(Long pricePolicyId) {
		this.pricePolicyId = pricePolicyId;
	}
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	public String getPolicySource() {
		return policySource;
	}
	public void setPolicySource(String policySource) {
		this.policySource = policySource;
	}
}
