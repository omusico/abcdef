package com.lvmama.lvfit.common.dto.calculator;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.md.PriceFormula;
import com.lvmama.lvfit.common.dto.request.FlightTicketRequest;

public class FlightSimpleInfoDto {

	public FlightTicketRequest flightTicketRequest = new FlightTicketRequest();
	
	public FlightTicketRequest getFlightTicketRequest() {
		return flightTicketRequest;
	}

	public void setFlightTicketRequest(FlightTicketRequest flightTicketRequest) {
		this.flightTicketRequest = flightTicketRequest;
	}

	public String getFlightNo() {
		return flightTicketRequest.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightTicketRequest.setFlightNo(flightNo);
	}

	public BookingSource getBookingSource() {
		return flightTicketRequest.getBookingSource();
	}

	public void setBookingSource(BookingSource bookingSource) {
		flightTicketRequest.setBookingSource(bookingSource);
	}

	

	public BigDecimal getProfitAmount() {
		return flightTicketRequest.getProfitAmount();
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		flightTicketRequest.setProfitAmount(profitAmount);
	}

	public BigDecimal getyParPrice() {
		return flightTicketRequest.getyParPrice();
	}

	public void setyParPrice(BigDecimal yParPrice) {
		flightTicketRequest.setyParPrice(yParPrice);
	}

	public PriceFormula getPromotionFormula() {
		return flightTicketRequest.getPromotionFormula();
	}

	public void setPromotionFormula(PriceFormula promotionFormula) {
		flightTicketRequest.setPromotionFormula(promotionFormula);
	}

	public BigDecimal getYParPrice() {
		return flightTicketRequest.getYParPrice();
	}

	public void setYParPrice(BigDecimal yParPrice) {
		flightTicketRequest.setYParPrice(yParPrice);
	}

	public BigDecimal getParPrice() {
		return flightTicketRequest.getParPrice();
	}

	public void setParPrice(BigDecimal parPrice) {
		flightTicketRequest.setParPrice(parPrice);
	}

	public BigDecimal getFuelsurTax() {
		return flightTicketRequest.getFuelsurTax();
	}

	public void setFuelsurTax(BigDecimal fuelsurTax) {
		flightTicketRequest.setFuelsurTax(fuelsurTax);
	}

	public BigDecimal getAirportFee() {
		return flightTicketRequest.getAirportFee();
	}

	public void setAirportFee(BigDecimal airportFee) {
		flightTicketRequest.setAirportFee(airportFee);
	}

	public BigDecimal getTotalParPrice() {
		return flightTicketRequest.getTotalParPrice();
	}

	public void setTotalParPrice(BigDecimal totalParPrice) {
		flightTicketRequest.setTotalParPrice(totalParPrice);
	}

	public BigDecimal getSalesPrice() {
		return flightTicketRequest.getSalesPrice();
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		flightTicketRequest.setSalesPrice(salesPrice);
	}

	public BigDecimal getSettlePrice() {
		return flightTicketRequest.getSettlePrice();
	}

	public void setSettlePrice(BigDecimal settlePrice) {
		flightTicketRequest.setSettlePrice(settlePrice);
	}

	public BigDecimal getDiscount() {
		return flightTicketRequest.getDiscount();
	}

	public void setDiscount(BigDecimal discount) {
		flightTicketRequest.setDiscount(discount);
	}

	public BigDecimal getPromotion() {
		return flightTicketRequest.getPromotion();
	}

	public void setPromotion(BigDecimal promotion) {
		flightTicketRequest.setPromotion(promotion);
	}

	public PriceFormula getProfit() {
		return flightTicketRequest.getProfit();
	}

	public void setProfit(PriceFormula profit) {
		flightTicketRequest.setProfit(profit);
	}

	public String getCarrierCode() {
		return flightTicketRequest.getCarrierCode();
	}

	public void setCarrierCode(String carrierCode) {
		flightTicketRequest.setCarrierCode(carrierCode);
	}

	public String getSeatClassCode() {
		return flightTicketRequest.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		flightTicketRequest.setSeatClassCode(seatClassCode);
	}

	public String getDepartureAirportCode() {
		return flightTicketRequest.getDepartureAirportCode();
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		flightTicketRequest.setDepartureAirportCode(departureAirportCode);
	}

	public String getArrivalAirportCode() {
		return flightTicketRequest.getArrivalAirportCode();
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		flightTicketRequest.setArrivalAirportCode(arrivalAirportCode);
	}

	public Date getDepartureDate() {
		return flightTicketRequest.getDepartureDate();
	}

	public void setDepartureDate(Date departureDate) {
		flightTicketRequest.setDepartureDate(departureDate);
	}

	public Long getPolicyId() {
		return flightTicketRequest.getPolicyId();
	}

	public void setPolicyId(Long policyId) {
		flightTicketRequest.setPolicyId(policyId);
	}

	public FlightTicketPriceDto getFlightTicketPriceDto() {
		return flightTicketRequest.getFlightTicketPriceDto();
	}

	public void setFlightTicketPriceDto(
			FlightTicketPriceDto flightTicketPriceDto) {
		flightTicketRequest.setFlightTicketPriceDto(flightTicketPriceDto);
	}

//	public BigDecimal getProfitFormula() {
//		return flightTicketRequest.getProfitFormula();
//	}
//
//	public void setProfitFormula(BigDecimal profitFormula) {
//		flightTicketRequest.setProfitFormula(profitFormula);
//	}

//	public BigDecimal getyParPrice() {
//		return flightTicketRequest.getyParPrice();
//	}
//
//	public void setyParPrice(BigDecimal yParPrice) {
//		flightTicketRequest.setyParPrice(yParPrice);
//	}

//	public PriceFormula getPromotionFormula() {
//		return flightTicketRequest.getPromotionFormula();
//	}
//
//	public void setPromotionFormula(PriceFormula promotionFormula) {
//		flightTicketRequest.setPromotionFormula(promotionFormula);
//	}

//	public BigDecimal getYParPrice() {
//		return flightTicketRequest.getYParPrice();
//	}
//
//	public void setYParPrice(BigDecimal yParPrice) {
//		flightTicketRequest.setYParPrice(yParPrice);
//	}

//	public BigDecimal getParPrice() {
//		return flightTicketRequest.getParPrice();
//	}
//
//	public void setParPrice(BigDecimal parPrice) {
//		flightTicketRequest.setParPrice(parPrice);
//	}

//	public BigDecimal getFuelsurTax() {
//		return flightTicketRequest.getFuelsurTax();
//	}
//
//	public void setFuelsurTax(BigDecimal fuelsurTax) {
//		flightTicketRequest.setFuelsurTax(fuelsurTax);
//	}

//	public BigDecimal getAirportFee() {
//		return flightTicketRequest.getAirportFee();
//	}
//
//	public void setAirportFee(BigDecimal airportFee) {
//		flightTicketRequest.setAirportFee(airportFee);
//	}

//	public BigDecimal getTotalParPrice() {
//		return flightTicketRequest.getTotalParPrice();
//	}
//
//	public void setTotalParPrice(BigDecimal totalParPrice) {
//		flightTicketRequest.setTotalParPrice(totalParPrice);
//	}

//	public BigDecimal getSalesPrice() {
//		return flightTicketRequest.getSalesPrice();
//	}
//
//	public void setSalesPrice(BigDecimal salesPrice) {
//		flightTicketRequest.setSalesPrice(salesPrice);
//	}

//	public BigDecimal getSettlePrice() {
//		return flightTicketRequest.getSettlePrice();
//	}
//
//	public void setSettlePrice(BigDecimal settlePrice) {
//		flightTicketRequest.setSettlePrice(settlePrice);
//	}

//	public BigDecimal getDiscount() {
//		return flightTicketRequest.getDiscount();
//	}
//
//	public void setDiscount(BigDecimal discount) {
//		flightTicketRequest.setDiscount(discount);
//	}

//	public BigDecimal getPromotion() {
//		return flightTicketRequest.getPromotion();
//	}
//
//	public void setPromotion(BigDecimal promotion) {
//		flightTicketRequest.setPromotion(promotion);
//	}
//
//	public PriceFormula getProfit() {
//		return flightTicketRequest.getProfit();
//	}
//
//	public void setProfit(PriceFormula profit) {
//		flightTicketRequest.setProfit(profit);
//	}

	public PassengerType getPassengerType() {
		return flightTicketRequest.getPassengerType();
	}

	public void setPassengerType(PassengerType passengerType) {
		flightTicketRequest.setPassengerType(passengerType);
	}

	public Long getPricePolicyId() {
		return flightTicketRequest.getPricePolicyId();
	}

	public void setPricePolicyId(Long pricePolicyId) {
		flightTicketRequest.setPricePolicyId(pricePolicyId);
	}
	
	
	
}
