package com.lvmama.lvfit.common.dto.calculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.md.PriceFormula;

/**
 * 订单金额信息
 * @author majun
 * @date 2015-1-19
 */
public class FlightOrderAmountDto implements Serializable {

	private static final long serialVersionUID = -4461827873155492118L;

	/** 订单票面总金额 */
	private BigDecimal orderTotalAmount = BigDecimal.ZERO;

	/** 订单总销售金额 */
	private BigDecimal orderTotalSalesAmount = BigDecimal.ZERO;
	
	/** 订单原始总销售金额 */
	private BigDecimal orderOriginalTotalSalesAmount = BigDecimal.ZERO;
	
	/** 机票结算金额 */
	private BigDecimal orderTotalSettleAmount = BigDecimal.ZERO;

	/** 订单总票面价 */
	private BigDecimal orderTicketAmount = BigDecimal.ZERO;

	/** 订单总机建费 */
	private BigDecimal orderAirportTaxAmount = BigDecimal.ZERO;

	/** 订单总燃油费 */
	private BigDecimal orderFuelTaxAmount = BigDecimal.ZERO;

	/** 订单保险金额 */
	private BigDecimal orderInsuranceAmount = BigDecimal.ZERO;

	/** 订单快递费 */
	private BigDecimal orderExpressAmount = BigDecimal.ZERO;

	/** 订单附加费 */
	private BigDecimal orderPlusAmount = BigDecimal.ZERO;

	/** 订单预付费 */
	private BigDecimal orderPrepaidAmount = BigDecimal.ZERO;

	/** 订单已支付金额 */
	private BigDecimal orderPayedAmount = BigDecimal.ZERO;

	/** 订单折扣总金额 */
	private BigDecimal orderDiscountTotalAmount = BigDecimal.ZERO;

	/** 订单利润 */
	private BigDecimal orderProfitAmount = BigDecimal.ZERO;

	/** 订单利润计算规则 */
	private PriceFormula profitFormula = new PriceFormula();

	/** 订单折扣信息列表 */
	private List<FlightOrderDiscountDto> flightOrderDiscounts = new ArrayList<FlightOrderDiscountDto>();
	
	/** 订单退废票金额信息 */
	private FlightOrderRTVTAmountDto orderRTVTAmount = new FlightOrderRTVTAmountDto();
	
	/** 订单改签金额信息 */
	private FlightOrderCTMTAmountDto orderCTMTAmount = new FlightOrderCTMTAmountDto();

	public BigDecimal getOrderTotalSettleAmount() {
		return orderTotalSettleAmount;
	}

	public void setOrderTotalSettleAmount(BigDecimal orderTotalSettleAmount) {
		this.orderTotalSettleAmount = orderTotalSettleAmount;
	}

	public BigDecimal getOrderTotalSalesAmount() {
		return orderTotalSalesAmount;
	}

	public void setOrderTotalSalesAmount(BigDecimal orderTotalSalesAmount) {
		this.orderTotalSalesAmount = orderTotalSalesAmount;
	}
	
	public BigDecimal getOrderOriginalTotalSalesAmount() {
		return orderOriginalTotalSalesAmount;
	}

	public void setOrderOriginalTotalSalesAmount(
			BigDecimal orderOriginalTotalSalesAmount) {
		this.orderOriginalTotalSalesAmount = orderOriginalTotalSalesAmount;
	}

	public BigDecimal getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	public BigDecimal getOrderTicketAmount() {
		return orderTicketAmount;
	}

	public void setOrderTicketAmount(BigDecimal orderTicketAmount) {
		this.orderTicketAmount = orderTicketAmount;
	}

	public BigDecimal getOrderAirportTaxAmount() {
		return orderAirportTaxAmount;
	}

	public void setOrderAirportTaxAmount(BigDecimal orderAirportTaxAmount) {
		this.orderAirportTaxAmount = orderAirportTaxAmount;
	}

	public BigDecimal getOrderFuelTaxAmount() {
		return orderFuelTaxAmount;
	}

	public void setOrderFuelTaxAmount(BigDecimal orderFuelTaxAmount) {
		this.orderFuelTaxAmount = orderFuelTaxAmount;
	}

	public BigDecimal getOrderInsuranceAmount() {
		return orderInsuranceAmount;
	}

	public void setOrderInsuranceAmount(BigDecimal orderInsuranceAmount) {
		this.orderInsuranceAmount = orderInsuranceAmount;
	}

	public BigDecimal getOrderExpressAmount() {
		return orderExpressAmount;
	}

	public void setOrderExpressAmount(BigDecimal orderExpressAmount) {
		this.orderExpressAmount = orderExpressAmount;
	}

	public BigDecimal getOrderPlusAmount() {
		return orderPlusAmount;
	}

	public void setOrderPlusAmount(BigDecimal orderPlusAmount) {
		this.orderPlusAmount = orderPlusAmount;
	}

	public BigDecimal getOrderPrepaidAmount() {
		return orderPrepaidAmount;
	}

	public void setOrderPrepaidAmount(BigDecimal orderPrepaidAmount) {
		this.orderPrepaidAmount = orderPrepaidAmount;
	}

	public BigDecimal getOrderDiscountTotalAmount() {
		return orderDiscountTotalAmount;
	}

	public void setOrderDiscountTotalAmount(BigDecimal orderDiscountTotalAmount) {
		this.orderDiscountTotalAmount = orderDiscountTotalAmount;
	}

	public BigDecimal getOrderProfitAmount() {
		return orderProfitAmount;
	}

	public void setOrderProfitAmount(BigDecimal orderProfitAmount) {
		this.orderProfitAmount = orderProfitAmount;
	}

	public PriceFormula getProfitFormula() {
		return profitFormula;
	}

	public void setProfitFormula(PriceFormula profitFormula) {
		this.profitFormula = profitFormula;
	}

	public List<FlightOrderDiscountDto> getFlightOrderDiscounts() {
		return flightOrderDiscounts;
	}

	public void setFlightOrderDiscounts(
			List<FlightOrderDiscountDto> flightOrderDiscounts) {
		this.flightOrderDiscounts = flightOrderDiscounts;
	}

	public BigDecimal getOrderPayedAmount() {
		return orderPayedAmount;
	}

	public void setOrderPayedAmount(BigDecimal orderPayedAmount) {
		this.orderPayedAmount = orderPayedAmount;
	}

	public FlightOrderRTVTAmountDto getOrderRTVTAmount() {
		return orderRTVTAmount;
	}

	public void setOrderRTVTAmount(FlightOrderRTVTAmountDto orderRTVTAmount) {
		this.orderRTVTAmount = orderRTVTAmount;
	}
	
	public void setOrderRefundedAmount(BigDecimal orderRefundedAmount) {
		orderRTVTAmount.setOrderRefundedAmount(orderRefundedAmount);
	}

	public BigDecimal getOrderRefundedAmount() {
		return orderRTVTAmount.getOrderRefundedAmount();
	}

	public FlightOrderCTMTAmountDto getOrderCTMTAmount() {
		return orderCTMTAmount;
	}

	public void setOrderCTMTAmount(FlightOrderCTMTAmountDto orderCTMTAmount) {
		this.orderCTMTAmount = orderCTMTAmount;
	}
}
