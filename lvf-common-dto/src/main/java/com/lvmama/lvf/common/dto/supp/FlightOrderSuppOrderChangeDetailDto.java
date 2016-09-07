package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.md.Airport;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.order.FlightOrderDiscountDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;

/**
 * 供应商订单改签详细基本信息
 * 
 * @author yuanweihong
 * @date 2015-9-24
 */
public class FlightOrderSuppOrderChangeDetailDto extends Entity implements Serializable {

    private static final long serialVersionUID = 2910018216291376789L;

    /** 乘客 */
    private String passengerName;

    /** 票号 */
    private String ticketNo;

    /** 航段List */
    private List<String> flightSegments;

    /** 航班号 */
    private String flightNo;
    
    /** 出发时间 */
    private Date departureTime;

    /** 到达时间 */
    private Date arrivalTime;
    
    /**出发机场 */
    private Airport departureAirport;
    
    /**到达机场 */
    private Airport arrivalAirport;

    /** 机型信息 */
    private Airplane airplane;
    
    /** 价格信息 */
    private FlightTicketPriceDto flightTicketPriceDto = new FlightTicketPriceDto();
    
    /** 承运人信息 */
    private Carrier carrier;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public List<String> getFlightSegments() {
        return flightSegments;
    }

    public void setFlightSegments(List<String> flightSegments) {
        this.flightSegments = flightSegments;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public FlightTicketPriceDto getFlightTicketPriceDto() {
        return flightTicketPriceDto;
    }

    public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
        this.flightTicketPriceDto = flightTicketPriceDto;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public BigDecimal getSalesParPrice() {
        return flightTicketPriceDto.getSalesParPrice();
    }

    public void setSalesParPrice(BigDecimal salesParPrice) {
        flightTicketPriceDto.setSalesParPrice(salesParPrice);
    }

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

    public FlightOrderDiscountDto getDiscountDto() {
        return flightTicketPriceDto.getDiscountDto();
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

    public BigDecimal getOriginalSalesPrice() {
        return flightTicketPriceDto.getOriginalSalesPrice();
    }

    public void setOriginalSalesPrice(BigDecimal originalSalesPrice) {
        flightTicketPriceDto.setOriginalSalesPrice(originalSalesPrice);
    }

    public Integer getInventoryCount() {
        return flightTicketPriceDto.getInventoryCount();
    }

    public void setInventoryCount(Integer inventoryCount) {
        flightTicketPriceDto.setInventoryCount(inventoryCount);
    }
    
    
    
}
