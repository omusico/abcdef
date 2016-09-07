package com.lvmama.lvf.common.dto.calculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.md.InsuranceClass;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.order.FlightOrderDiscountDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;

public class AmountCalculatorDetailDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5634579799135906082L;
	
	private FlightTicketPriceDto flightTicketPriceDto = new FlightTicketPriceDto();
	
	private List<InsurancesAmountDto>  orderInsuranceAmounts = new ArrayList<InsurancesAmountDto>();
	private List<InsurancesAmountDto>  orderInsurancePrices = new ArrayList<InsurancesAmountDto>();
	
	private String flag;

	public FlightTicketPriceDto getFlightTicketPriceDto() {
		return flightTicketPriceDto;
	}

	public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
		this.flightTicketPriceDto = flightTicketPriceDto;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<InsurancesAmountDto> getOrderInsuranceAmounts() {
		return orderInsuranceAmounts;
	}

	public void setOrderInsuranceAmounts(
			List<InsurancesAmountDto> orderInsuranceAmounts) {
		this.orderInsuranceAmounts = orderInsuranceAmounts;
	}

	public List<InsurancesAmountDto> getOrderInsurancePrices() {
		return orderInsurancePrices;
	}

	public void setOrderInsurancePrices(
			List<InsurancesAmountDto> orderInsurancePrices) {
		this.orderInsurancePrices = orderInsurancePrices;
	}


	public void setDiscountDto(FlightOrderDiscountDto discountDto) {
		flightTicketPriceDto.setDiscountDto(discountDto);
	}

	public void setActive(boolean active) {
		flightTicketPriceDto.setActive(active);
	}

	public Boolean getActive() {
		return flightTicketPriceDto.getActive();
	}

	public ActiveStatus getActiveStatus() {
		return flightTicketPriceDto.getActiveStatus();
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		flightTicketPriceDto.setActiveStatus(activeStatus);
	}

	public BigDecimal getProfitAmount() {
		return flightTicketPriceDto.getProfitAmount();
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		flightTicketPriceDto.setProfitAmount(profitAmount);
	}

	public BigDecimal getyParPrice() {
		return flightTicketPriceDto.getyParPrice();
	}

	public void setyParPrice(BigDecimal yParPrice) {
		flightTicketPriceDto.setyParPrice(yParPrice);
	}

	public PriceFormula getPromotionFormula() {
		return flightTicketPriceDto.getPromotionFormula();
	}

	public void setPromotionFormula(PriceFormula promotionFormula) {
		flightTicketPriceDto.setPromotionFormula(promotionFormula);
	}

	public BigDecimal getYParPrice() {
		return flightTicketPriceDto.getYParPrice();
	}

	public void setYParPrice(BigDecimal yParPrice) {
		flightTicketPriceDto.setYParPrice(yParPrice);
	}

	public BigDecimal getParPrice() {
		return flightTicketPriceDto.getParPrice();
	}

	public void setParPrice(BigDecimal parPrice) {
		flightTicketPriceDto.setParPrice(parPrice);
	}

	public BigDecimal getFuelsurTax() {
		return flightTicketPriceDto.getFuelsurTax();
	}

	public void setFuelsurTax(BigDecimal fuelsurTax) {
		flightTicketPriceDto.setFuelsurTax(fuelsurTax);
	}

	public BigDecimal getAirportFee() {
		return flightTicketPriceDto.getAirportFee();
	}

	public void setAirportFee(BigDecimal airportFee) {
		flightTicketPriceDto.setAirportFee(airportFee);
	}

	public BigDecimal getTotalParPrice() {
		return flightTicketPriceDto.getTotalParPrice();
	}

	public void setTotalParPrice(BigDecimal totalParPrice) {
		flightTicketPriceDto.setTotalParPrice(totalParPrice);
	}

	public BigDecimal getSalesPrice() {
		return flightTicketPriceDto.getSalesPrice();
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		flightTicketPriceDto.setSalesPrice(salesPrice);
	}

	public BigDecimal getSettlePrice() {
		return flightTicketPriceDto.getSettlePrice();
	}

	public void setSettlePrice(BigDecimal settlePrice) {
		flightTicketPriceDto.setSettlePrice(settlePrice);
	}

	public BigDecimal getDiscount() {
		return flightTicketPriceDto.getDiscount();
	}

	public void setDiscount(BigDecimal discount) {
		flightTicketPriceDto.setDiscount(discount);
	}

	public BigDecimal getPromotion() {
		return flightTicketPriceDto.getPromotion();
	}

	public void setPromotion(BigDecimal promotion) {
		flightTicketPriceDto.setPromotion(promotion);
	}

	public PriceFormula getProfit() {
		return flightTicketPriceDto.getProfit();
	}

	public void setProfit(PriceFormula profit) {
		flightTicketPriceDto.setProfit(profit);
	}

	public PassengerType getPassengerType() {
		return flightTicketPriceDto.getPassengerType();
	}

	public void setPassengerType(PassengerType passengerType) {
		flightTicketPriceDto.setPassengerType(passengerType);
	}
	
	

}
