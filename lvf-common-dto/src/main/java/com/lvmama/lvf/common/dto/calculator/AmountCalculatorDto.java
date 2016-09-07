package com.lvmama.lvf.common.dto.calculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDiscountDto;

public class AmountCalculatorDto implements Serializable{
	
	public BigDecimal getOrderRefundedAmount() {
		return flightOrderAmountDto.getOrderRefundedAmount();
	}

	public void setOrderRefundedAmount(BigDecimal orderRefundedAmount) {
		flightOrderAmountDto.setOrderRefundedAmount(orderRefundedAmount);
	}

	private static final long serialVersionUID = -7736649169468599713L;

	private FlightOrderAmountDto flightOrderAmountDto = new FlightOrderAmountDto(); 
    
    public BigDecimal getOrderTotalSalesAmount() {
		return flightOrderAmountDto.getOrderTotalSalesAmount();
	}

	public void setOrderTotalSalesAmount(BigDecimal orderTotalSalesAmount) {
		flightOrderAmountDto.setOrderTotalSalesAmount(orderTotalSalesAmount);
	}

	/**乘客订单金额详情 */
    private List<AmountCalculatorDetailDto> calculatorDetailDtos = new ArrayList<AmountCalculatorDetailDto>();
    
    /**
     * 金额扣减详情
     * @return
     */
    private List<FlightOrderDiscountDto> discounts = new ArrayList<FlightOrderDiscountDto>();

	public FlightOrderAmountDto getFlightOrderAmountDto() {
		return flightOrderAmountDto;
	}

	public void setFlightOrderAmountDto(FlightOrderAmountDto flightOrderAmountDto) {
		this.flightOrderAmountDto = flightOrderAmountDto;
	}

	public List<AmountCalculatorDetailDto> getCalculatorDetailDtos() {
		return calculatorDetailDtos;
	}

	public void setCalculatorDetailDtos(
			List<AmountCalculatorDetailDto> calculatorDetailDtos) {
		this.calculatorDetailDtos = calculatorDetailDtos;
	}

	public List<FlightOrderDiscountDto> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<FlightOrderDiscountDto> discounts) {
		this.discounts = discounts;
	}

	public BigDecimal getOrderTotalAmount() {
		return flightOrderAmountDto.getOrderTotalAmount();
	}

	public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
		flightOrderAmountDto.setOrderTotalAmount(orderTotalAmount);
	}

	public BigDecimal getOrderTicketAmount() {
		return flightOrderAmountDto.getOrderTicketAmount();
	}

	public void setOrderTicketAmount(BigDecimal orderTicketAmount) {
		flightOrderAmountDto.setOrderTicketAmount(orderTicketAmount);
	}

	public BigDecimal getOrderAirportTaxAmount() {
		return flightOrderAmountDto.getOrderAirportTaxAmount();
	}

	public void setOrderAirportTaxAmount(BigDecimal orderAirportTaxAmount) {
		flightOrderAmountDto.setOrderAirportTaxAmount(orderAirportTaxAmount);
	}

	public BigDecimal getOrderFuelTaxAmount() {
		return flightOrderAmountDto.getOrderFuelTaxAmount();
	}

	public void setOrderFuelTaxAmount(BigDecimal orderFuelTaxAmount) {
		flightOrderAmountDto.setOrderFuelTaxAmount(orderFuelTaxAmount);
	}

	public BigDecimal getOrderInsuranceAmount() {
		return flightOrderAmountDto.getOrderInsuranceAmount();
	}

	public void setOrderInsuranceAmount(BigDecimal orderInsuranceAmount) {
		flightOrderAmountDto.setOrderInsuranceAmount(orderInsuranceAmount);
	}

	public BigDecimal getOrderExpressAmount() {
		return flightOrderAmountDto.getOrderExpressAmount();
	}

	public void setOrderExpressAmount(BigDecimal orderExpressAmount) {
		flightOrderAmountDto.setOrderExpressAmount(orderExpressAmount);
	}

	public BigDecimal getOrderPlusAmount() {
		return flightOrderAmountDto.getOrderPlusAmount();
	}

	public void setOrderPlusAmount(BigDecimal orderPlusAmount) {
		flightOrderAmountDto.setOrderPlusAmount(orderPlusAmount);
	}

	public BigDecimal getOrderPrepaidAmount() {
		return flightOrderAmountDto.getOrderPrepaidAmount();
	}

	public void setOrderPrepaidAmount(BigDecimal orderPrepaidAmount) {
		flightOrderAmountDto.setOrderPrepaidAmount(orderPrepaidAmount);
	}

	public BigDecimal getOrderPayedAmount() {
		return flightOrderAmountDto.getOrderPayedAmount();
	}

	public void setOrderPayedAmount(BigDecimal orderPayedAmount) {
		flightOrderAmountDto.setOrderPayedAmount(orderPayedAmount);
	}

	public BigDecimal getOrderDiscountTotalAmount() {
		return flightOrderAmountDto.getOrderDiscountTotalAmount();
	}

	public void setOrderDiscountTotalAmount(BigDecimal orderDiscountTotalAmount) {
		flightOrderAmountDto
				.setOrderDiscountTotalAmount(orderDiscountTotalAmount);
	}

	public BigDecimal getOrderProfitAmount() {
		return flightOrderAmountDto.getOrderProfitAmount();
	}

	public void setOrderProfitAmount(BigDecimal orderProfitAmount) {
		flightOrderAmountDto.setOrderProfitAmount(orderProfitAmount);
	}

	public PriceFormula getProfitFormula() {
		return flightOrderAmountDto.getProfitFormula();
	}

	public void setProfitFormula(PriceFormula profitFormula) {
		flightOrderAmountDto.setProfitFormula(profitFormula);
	}

	public List<FlightOrderDiscountDto> getFlightOrderDiscounts() {
		return flightOrderAmountDto.getFlightOrderDiscounts();
	}

	public void setFlightOrderDiscounts(
			List<FlightOrderDiscountDto> flightOrderDiscounts) {
		flightOrderAmountDto.setFlightOrderDiscounts(flightOrderDiscounts);
	}

	public void addAmountCalculatorDetail(
			AmountCalculatorDetailDto amountCalculatorDetailDto) {
		// TODO Auto-generated method stub
		calculatorDetailDtos.add(amountCalculatorDetailDto);
	}
    
    
   
}
