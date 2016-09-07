package com.lvmama.lvf.common.dto.booking;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.enums.PassengerType;

public class BookingPassengerTypeAndAmountDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PassengerType passengerType;
	private Integer passengerCount = 0;
	private BigDecimal totalParpriceAmount = BigDecimal.ZERO;
	private BigDecimal totalAirportFeeAmount = BigDecimal.ZERO;
	private BigDecimal totalFuelsurTaxAmount = BigDecimal.ZERO;
	private BigDecimal totalOrderDiscountAmount = BigDecimal.ZERO;
	private BigDecimal totalInsuranceAmount = BigDecimal.ZERO;
	private BigDecimal totalPlusAmount = BigDecimal.ZERO;
	private BigDecimal singleOrderDiscountAmount = BigDecimal.ZERO;
	private BigDecimal singleParpriceAmout = BigDecimal.ZERO;
	private BigDecimal singleAirportFeeAmount = BigDecimal.ZERO;
	private BigDecimal singleFuelsurTaxAmount = BigDecimal.ZERO;
	private BigDecimal singleInsuranceAmount = BigDecimal.ZERO;
	public PassengerType getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
	public Integer getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}
	public BigDecimal getTotalParpriceAmount() {
		return totalParpriceAmount;
	}
	public void setTotalParpriceAmount(BigDecimal totalParpriceAmount) {
		this.totalParpriceAmount = totalParpriceAmount;
	}
	public BigDecimal getTotalAirportFeeAmount() {
		return totalAirportFeeAmount;
	}
	public void setTotalAirportFeeAmount(BigDecimal totalAirportFeeAmount) {
		this.totalAirportFeeAmount = totalAirportFeeAmount;
	}
	public BigDecimal getTotalFuelsurTaxAmount() {
		return totalFuelsurTaxAmount;
	}
	public void setTotalFuelsurTaxAmount(BigDecimal totalFuelsurTaxAmount) {
		this.totalFuelsurTaxAmount = totalFuelsurTaxAmount;
	}
	public BigDecimal getTotalInsuranceAmount() {
		return totalInsuranceAmount;
	}
	public void setTotalInsuranceAmount(BigDecimal totalInsuranceAmount) {
		this.totalInsuranceAmount = totalInsuranceAmount;
	}
	public BigDecimal getSingleParpriceAmout() {
		return singleParpriceAmout;
	}
	public void setSingleParpriceAmout(BigDecimal singleParpriceAmout) {
		this.singleParpriceAmout = singleParpriceAmout;
	}
	public BigDecimal getSingleAirportFeeAmount() {
		return singleAirportFeeAmount;
	}
	public void setSingleAirportFeeAmount(BigDecimal singleAirportFeeAmount) {
		this.singleAirportFeeAmount = singleAirportFeeAmount;
	}
	public BigDecimal getSingleFuelsurTaxAmount() {
		return singleFuelsurTaxAmount;
	}
	public void setSingleFuelsurTaxAmount(BigDecimal singleFuelsurTaxAmount) {
		this.singleFuelsurTaxAmount = singleFuelsurTaxAmount;
	}
	public BigDecimal getSingleInsuranceAmount() {
		return singleInsuranceAmount;
	}
	public void setSingleInsuranceAmount(BigDecimal singleInsuranceAmount) {
		this.singleInsuranceAmount = singleInsuranceAmount;
	}
	public BigDecimal getTotalOrderDiscountAmount() {
		return totalOrderDiscountAmount;
	}
	public void setTotalOrderDiscountAmount(BigDecimal totalOrderDiscountAmount) {
		this.totalOrderDiscountAmount = totalOrderDiscountAmount;
	}
	public BigDecimal getTotalPlusAmount() {
		return totalPlusAmount;
	}
	public void setTotalPlusAmount(BigDecimal totalPlusAmount) {
		this.totalPlusAmount = totalPlusAmount;
	}
	public BigDecimal getSingleOrderDiscountAmount() {
		return singleOrderDiscountAmount;
	}
	public void setSingleOrderDiscountAmount(BigDecimal singleOrderDiscountAmount) {
		this.singleOrderDiscountAmount = singleOrderDiscountAmount;
	}
	
}
