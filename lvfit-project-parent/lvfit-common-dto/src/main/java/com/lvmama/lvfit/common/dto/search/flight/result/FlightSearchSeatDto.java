package com.lvmama.lvfit.common.dto.search.flight.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvfit.common.dto.enums.InventoryStatus;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.md.PriceFormula;
import com.lvmama.lvfit.common.dto.price.FitFlightTicketPriceDto;

/**
 * 舱位信息
 * @author lven
 * @date   2015-3-11
 */
public class FlightSearchSeatDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6474451898158491235L;

	/**舱位Id */
	private Long seatId;

	/**舱位类型 */
	private String seatClassType;
	
	/**舱位类型 */
	private String seatClassTypeName;
	
	/**舱位Code */
	private String seatClassCode;
    
	/**舱位名称 */
	private String seatClassName;
	
	/**舱位描述 */
	private String seatClassDesc;
	/**是否选中**/
	private Boolean selectFlag = false;
	/**
	 * 价格信息
	 */
	private FitFlightTicketPriceDto flightTicketPriceDto = new FitFlightTicketPriceDto();
	
    /**内部政策Id */
	private Long policyId;
	
	/**供应商政策Id */
	private String suppPolicyId;
	
	/**运价政策Id */
	private Long pricePolicyId;
	
	/**供应商编码 */
	private String suppCode;
	
	/**库存状态 */
	private InventoryStatus inventoryStatus;
	
	/**库存数量*/
	private Integer InventoryCount;
	
	/**客规*/
	private List<FlightSearchTicketRuleDto> ticketRules;
	
	/**简单客规*/
	private List<FlightSearchTicketRuleSimpleDto> ticketRuleSimples;
	
	/**儿童舱价格*/
	private BigDecimal childrenPrice = new BigDecimal(0);;
	
	//舱位差价 
	private BigDecimal differentPrice;
	
	
	public BigDecimal getDifferentPrice() {
		return differentPrice;
	}

	public void setDifferentPrice(BigDecimal differentPrice) {
		this.differentPrice = differentPrice;
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
	
	public BigDecimal getSalesParPrice() {
		return flightTicketPriceDto.getSalesParPrice();
	}

	public void setSalesParPrice(BigDecimal salesParPrice) {
		flightTicketPriceDto.setSalesParPrice(salesParPrice);
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

	
	
	public FitFlightTicketPriceDto getFlightTicketPriceDto() {
		return flightTicketPriceDto;
	}

	public void setFlightTicketPriceDto(FitFlightTicketPriceDto flightTicketPriceDto) {
		this.flightTicketPriceDto = flightTicketPriceDto;
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public String getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(String seatClassType) {
		this.seatClassType = seatClassType;
	}
	
	public String getSeatClassTypeName() {
		return seatClassTypeName;
	}

	public void setSeatClassTypeName(String seatClassTypeName) {
		this.seatClassTypeName = seatClassTypeName;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

	public String getSeatClassName() {
		return seatClassName;
	}

	public void setSeatClassName(String seatClassName) {
		this.seatClassName = seatClassName;
	}

	public String getSeatClassDesc() {
		return seatClassDesc;
	}

	public void setSeatClassDesc(String seatClassDesc) {
		this.seatClassDesc = seatClassDesc;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	} 
	
	public String getSuppPolicyId() {
		return suppPolicyId;
	}

	public void setSuppPolicyId(String suppPolicyId) {
		this.suppPolicyId = suppPolicyId;
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

	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public Integer getInventoryCount() {
		return InventoryCount;
	}

	public void setInventoryCount(Integer inventoryCount) {
		InventoryCount = inventoryCount;
	}

	public List<FlightSearchTicketRuleDto> getTicketRules() {
		return ticketRules;
	}

	public void setTicketRules(List<FlightSearchTicketRuleDto> ticketRules) {
		this.ticketRules = ticketRules;
	}

	public List<FlightSearchTicketRuleSimpleDto> getTicketRuleSimples() {
		return ticketRuleSimples;
	}

	public void setTicketRuleSimples(
			List<FlightSearchTicketRuleSimpleDto> ticketRuleSimples) {
		this.ticketRuleSimples = ticketRuleSimples;
	}

	public Boolean getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(Boolean selectFlag) {
		this.selectFlag = selectFlag;
	}

	public BigDecimal getChildrenPrice() {
		return childrenPrice;
	}

	public void setChildrenPrice(BigDecimal childrenPrice) {
		this.childrenPrice = childrenPrice;
	}

	
}
