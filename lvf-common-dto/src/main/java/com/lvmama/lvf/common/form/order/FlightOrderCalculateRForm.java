package com.lvmama.lvf.common.form.order;

import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.dto.calculator.AmountCalculatorDetailDto;
import com.lvmama.lvf.common.dto.calculator.AmountCalculatorDto;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDiscountDto;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderCalculateRForm implements Form{
	
	private AmountCalculatorDto amountCalculatorDto;
	
	public FlightOrderCalculateRForm() {
		super();
	}

	public FlightOrderCalculateRForm(AmountCalculatorDto amountCalculatorDto) {
		super();
		this.amountCalculatorDto = amountCalculatorDto;
	}

	public AmountCalculatorDto getAmountCalculatorDto() {
		return amountCalculatorDto;
	}

	public void setAmountCalculatorDto(AmountCalculatorDto amountCalculatorDto) {
		this.amountCalculatorDto = amountCalculatorDto;
	}

	

	public FlightOrderAmountDto getFlightOrderAmountDto() {
		return amountCalculatorDto.getFlightOrderAmountDto();
	}

	public void setFlightOrderAmountDto(
			FlightOrderAmountDto flightOrderAmountDto) {
		amountCalculatorDto.setFlightOrderAmountDto(flightOrderAmountDto);
	}

	public List<FlightOrderDiscountDto> getDiscounts() {
		return amountCalculatorDto.getDiscounts();
	}

	public void setDiscounts(List<FlightOrderDiscountDto> discounts) {
		amountCalculatorDto.setDiscounts(discounts);
	}

	public BigDecimal getOrderTotalAmount() {
		return amountCalculatorDto.getOrderTotalAmount();
	}

	public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
		amountCalculatorDto.setOrderTotalAmount(orderTotalAmount);
	}

	public BigDecimal getOrderTicketAmount() {
		return amountCalculatorDto.getOrderTicketAmount();
	}

	public void setOrderTicketAmount(BigDecimal orderTicketAmount) {
		amountCalculatorDto.setOrderTicketAmount(orderTicketAmount);
	}

	public BigDecimal getOrderAirportTaxAmount() {
		return amountCalculatorDto.getOrderAirportTaxAmount();
	}

	public void setOrderAirportTaxAmount(BigDecimal orderAirportTaxAmount) {
		amountCalculatorDto.setOrderAirportTaxAmount(orderAirportTaxAmount);
	}

	public BigDecimal getOrderFuelTaxAmount() {
		return amountCalculatorDto.getOrderFuelTaxAmount();
	}

	public void setOrderFuelTaxAmount(BigDecimal orderFuelTaxAmount) {
		amountCalculatorDto.setOrderFuelTaxAmount(orderFuelTaxAmount);
	}

	public BigDecimal getOrderInsuranceAmount() {
		return amountCalculatorDto.getOrderInsuranceAmount();
	}

	public void setOrderInsuranceAmount(BigDecimal orderInsuranceAmount) {
		amountCalculatorDto.setOrderInsuranceAmount(orderInsuranceAmount);
	}

	public BigDecimal getOrderPlusAmount() {
		return amountCalculatorDto.getOrderPlusAmount();
	}

	public void setOrderPlusAmount(BigDecimal orderPlusAmount) {
		amountCalculatorDto.setOrderPlusAmount(orderPlusAmount);
	}

	public BigDecimal getOrderPrepaidAmount() {
		return amountCalculatorDto.getOrderPrepaidAmount();
	}

	public void setOrderPrepaidAmount(BigDecimal orderPrepaidAmount) {
		amountCalculatorDto.setOrderPrepaidAmount(orderPrepaidAmount);
	}

	public BigDecimal getOrderPayedAmount() {
		return amountCalculatorDto.getOrderPayedAmount();
	}

	public void setOrderPayedAmount(BigDecimal orderPayedAmount) {
		amountCalculatorDto.setOrderPayedAmount(orderPayedAmount);
	}

	public BigDecimal getOrderDiscountTotalAmount() {
		return amountCalculatorDto.getOrderDiscountTotalAmount();
	}

	public void setOrderDiscountTotalAmount(BigDecimal orderDiscountTotalAmount) {
		amountCalculatorDto
				.setOrderDiscountTotalAmount(orderDiscountTotalAmount);
	}

	public BigDecimal getOrderProfitAmount() {
		return amountCalculatorDto.getOrderProfitAmount();
	}

	public void setOrderProfitAmount(BigDecimal orderProfitAmount) {
		amountCalculatorDto.setOrderProfitAmount(orderProfitAmount);
	}

	public PriceFormula getProfitFormula() {
		return amountCalculatorDto.getProfitFormula();
	}

	public void setProfitFormula(PriceFormula profitFormula) {
		amountCalculatorDto.setProfitFormula(profitFormula);
	}

	public List<FlightOrderDiscountDto> getFlightOrderDiscounts() {
		return amountCalculatorDto.getFlightOrderDiscounts();
	}

	public void setFlightOrderDiscounts(
			List<FlightOrderDiscountDto> flightOrderDiscounts) {
		amountCalculatorDto.setFlightOrderDiscounts(flightOrderDiscounts);
	}

	public BigDecimal getOrderExpressAmount() {
		return amountCalculatorDto.getOrderExpressAmount();
	}

	public void setOrderExpressAmount(BigDecimal orderExpressAmount) {
		amountCalculatorDto.setOrderExpressAmount(orderExpressAmount);
	}

	public List<AmountCalculatorDetailDto> getCalculatorDetailDtos() {
		return amountCalculatorDto.getCalculatorDetailDtos();
	}

	public void setCalculatorDetailDtos(List<AmountCalculatorDetailDto> calculatorDetailDtos) {
		amountCalculatorDto.setCalculatorDetailDtos(calculatorDetailDtos);
	}

	
	
	
}
