package com.lvmama.lvf.common.dto.order.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.FlightTicketType;
import com.lvmama.lvf.common.dto.enums.NeedSwitchPNR;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.PolicyType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.enums.SeatSpecType;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.policy.FlightPolicyArrivalRuleDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicyDepartureRuleDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicyRemarkDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicyRuleDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicySuppDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;

public class FlightBookingVerifyDeatilPolicyDto {

	/** 供应商政策基本信息 */
	private FlightPolicySuppDto flightPolicySupp;

	/** 承运人信息 */
	private Carrier carrier;

	/** 是否更换PNR信息 */
	private NeedSwitchPNR needSwitchPNR;

	/** 航程类型信息 */
	private List<RouteType> routeTypes = new ArrayList<RouteType>();

	/** 政策枚举类型 */
	private PolicyType flightPolicyType;

	/** 政策备注信息 */
	private FlightPolicyRemarkDto flightPolicyRemark;

	/** 成人结算价 */ 
	private BigDecimal adultSettlePrice;

	/** 政策返点 */
	private PriceFormula priceFormula;

	/** 政策类型 */
	private FlightTicketType ticketType;

	/** 舱位类型 */
	private SeatSpecType seatSpecType;

	/** 价格信息 */
	private FlightTicketPriceDto flightTicketPriceDto = new FlightTicketPriceDto();

	/** 政策规则基本信息 */
	private FlightPolicyRuleDto flightPolicyRule;

	/** 政策有效期 */
	private FlightPolicyDepartureRuleDto flightPolicyDepartureRule;

	/** 政策出票有效期 */
	private FlightPolicyArrivalRuleDto flightPolicyArrivalRule;

	public FlightPolicySuppDto getFlightPolicySupp() {
		return flightPolicySupp;
	}

	public void setFlightPolicySupp(FlightPolicySuppDto flightPolicySupp) {
		this.flightPolicySupp = flightPolicySupp;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public NeedSwitchPNR getNeedSwitchPNR() {
		return needSwitchPNR;
	}

	public void setNeedSwitchPNR(NeedSwitchPNR needSwitchPNR) {
		this.needSwitchPNR = needSwitchPNR;
	}

	public List<RouteType> getRouteTypes() {
		return routeTypes;
	}

	public void setRouteTypes(List<RouteType> routeTypes) {
		this.routeTypes = routeTypes;
	}

	public PolicyType getFlightPolicyType() {
		return flightPolicyType;
	}

	public void setFlightPolicyType(PolicyType flightPolicyType) {
		this.flightPolicyType = flightPolicyType;
	}

	public FlightPolicyRemarkDto getFlightPolicyRemark() {
		return flightPolicyRemark;
	}

	public void setFlightPolicyRemark(FlightPolicyRemarkDto flightPolicyRemark) {
		this.flightPolicyRemark = flightPolicyRemark;
	}

	public BigDecimal getAdultSettlePrice() {
		return adultSettlePrice;
	}

	public void setAdultSettlePrice(BigDecimal adultSettlePrice) {
		this.adultSettlePrice = adultSettlePrice;
	}

	public PriceFormula getPriceFormula() {
		return priceFormula;
	}

	public void setPriceFormula(PriceFormula priceFormula) {
		this.priceFormula = priceFormula;
	}

	public FlightTicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(FlightTicketType ticketType) {
		this.ticketType = ticketType;
	}

	public SeatSpecType getSeatSpecType() {
		return seatSpecType;
	}

	public void setSeatSpecType(SeatSpecType seatSpecType) {
		this.seatSpecType = seatSpecType;
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

	@JsonIgnore
	public BigDecimal getProfitAmount() {
		return flightTicketPriceDto.getProfitAmount();
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

	public FlightPolicyRuleDto getFlightPolicyRule() {
		return flightPolicyRule;
	}

	public void setFlightPolicyRule(FlightPolicyRuleDto flightPolicyRule) {
		this.flightPolicyRule = flightPolicyRule;
	}

	public FlightPolicyDepartureRuleDto getFlightPolicyDepartureRule() {
		return flightPolicyDepartureRule;
	}

	public void setFlightPolicyDepartureRule(
			FlightPolicyDepartureRuleDto flightPolicyDepartureRule) {
		this.flightPolicyDepartureRule = flightPolicyDepartureRule;
	}

	public FlightPolicyArrivalRuleDto getFlightPolicyArrivalRule() {
		return flightPolicyArrivalRule;
	}

	public void setFlightPolicyArrivalRule(
			FlightPolicyArrivalRuleDto flightPolicyArrivalRule) {
		this.flightPolicyArrivalRule = flightPolicyArrivalRule;
	}

	
}
