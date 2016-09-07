package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.dto.enums.SeatSpecType;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.md.SeatClass;
import com.lvmama.lvf.common.dto.status.ActiveStatus;

/**
 * 航班舱位信息
 * @author majun
 * @date   2015-1-24
 */
@XmlRootElement
public class FlightSeatDto extends AEEntity implements Serializable 
{
	private static final long serialVersionUID = -8109632037176356771L;
	
	/** 航班信息 */
	@FkId
	private FlightInfoDto flightInfo;
	
	/** 舱位基本信息(编码、名称) */
	private SeatClass seatClass;
	
	/** 舱位类型 */
	private SeatClassType seatClassType;
	
	/** 舱位特殊类型 */
	private SeatSpecType seatSpecType; 
	
	/** 描述信息 */
	private String desc;
	
	/**折扣信息**/
	private String seatPricesDiscount;
	
	/** 票价信息  */
	private FlightTicketPriceDto flightTicketPriceDto = new FlightTicketPriceDto();

	public BigDecimal getChildrenFuelsurTax() {
		return flightTicketPriceDto.getChildrenFuelsurTax();
	}

	public void setChildrenFuelsurTax(BigDecimal childrenFuelsurTax) {
		flightTicketPriceDto.setChildrenFuelsurTax(childrenFuelsurTax);
	}

	public BigDecimal getChildrenAirportFee() {
		return flightTicketPriceDto.getChildrenAirportFee();
	}

	public void setChildrenAirportFee(BigDecimal childrenAirportFee) {
		flightTicketPriceDto.setChildrenAirportFee(childrenAirportFee);
	}

	public FlightInfoDto getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightInfoDto flightInfo) {
		this.flightInfo = flightInfo;
	}

	public SeatClass getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
	}

	public SeatClassType getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(SeatClassType seatClassType) {
		this.seatClassType = seatClassType;
	}



	public SeatSpecType getSeatSpecType() {
		return seatSpecType;
	}

	public void setSeatSpecType(SeatSpecType seatSpecType) {
		this.seatSpecType = seatSpecType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public FlightTicketPriceDto getFlightTicketPriceDto() {
		return flightTicketPriceDto;
	}

	public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
		this.flightTicketPriceDto = flightTicketPriceDto;
	}

	public void setActive(boolean active) {
		flightTicketPriceDto.setActive(active);
	}

	public Boolean getActive() {
		return flightTicketPriceDto.getActive();
	}
	
	
	public void setSeatPricesDiscount(String seatPricesDiscount) {
		this.seatPricesDiscount = seatPricesDiscount;
	}

	public String getSeatPricesDiscount(){
		String seatPricesDiscount = "";
		if(null != flightTicketPriceDto.getDiscount()){
			BigDecimal priceDiscount  = flightTicketPriceDto.getDiscount().multiply(new BigDecimal(10));
			double f1 = priceDiscount.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
			seatPricesDiscount = "("+f1+"折)";
		}
		return seatPricesDiscount;
   }

	@JsonIgnore
	@Override
	public String getSequence() 
	{
		return "S_FFLI_SEAT";
	}

	public BigDecimal getSubsidy() {
		return flightTicketPriceDto.getSubsidy();
	}

	public void setSubsidy(BigDecimal subsidy) {
		flightTicketPriceDto.setSubsidy(subsidy);
	}
	
}
