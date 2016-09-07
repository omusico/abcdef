package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.BaseAuditRequest;
import com.lvmama.lvf.common.dto.adapter.response.FlightSuppOrderChangeInfoDto;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.DirectType;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.flight.FlightAirportFeeDto;
import com.lvmama.lvf.common.dto.flight.FlightFuelsurTaxDto;
import com.lvmama.lvf.common.dto.flight.FlightStopInfoDto;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.order.FlightOrderDiscountDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 可改签后搜索可改签结果ResponseForm
 * 
 * @author yuanweihong
 * @date 2015-10-1
 */
public class TicketSuppCTMTResponseForm extends BaseAuditRequest implements Serializable, Form {

    private static final long serialVersionUID = -3084590400914622200L;
    
    private FlightSuppOrderChangeInfoDto flightSuppOrderChangeInfoDto = new FlightSuppOrderChangeInfoDto();
    
    /** 操作类型 */
    private String operateType;
    
    /** 出发日期 */
    private String departureDateStr;
    
    /** 出发时间 */
    private String departureTimeStr;
    
    /** 到达时间 */
    private String arrivalTimeStr;
    
    /** 餐食 */
    private String mealTypeStr;
    
    /** 航程 */
    private String flightSegments;

    public TicketSuppCTMTResponseForm() {
        super();
    }

    public TicketSuppCTMTResponseForm(FlightSuppOrderChangeInfoDto flightSuppOrderChangeInfoDto) {
        super();
        this.flightSuppOrderChangeInfoDto = flightSuppOrderChangeInfoDto;
        if (this.flightSuppOrderChangeInfoDto != null) {
            this.operateType = "选择";
            if (this.flightSuppOrderChangeInfoDto.getDepartureTime() != null) {
                this.departureDateStr = DateUtils.formatDate(this.flightSuppOrderChangeInfoDto.getDepartureTime());
            }
            if (this.flightSuppOrderChangeInfoDto.getDepartureTime() != null) {
                this.departureTimeStr = DateUtils.formatCnHmDate(this.flightSuppOrderChangeInfoDto.getDepartureTime());
            }
            if (this.flightSuppOrderChangeInfoDto.getArrivalTime() != null) {
                this.arrivalTimeStr = DateUtils.formatCnHmDate(this.flightSuppOrderChangeInfoDto.getArrivalTime());
            }
            if (this.flightSuppOrderChangeInfoDto.getMealType() != null) {
                this.mealTypeStr = this.flightSuppOrderChangeInfoDto.getMealType().getCnName();
            }
            
            if (this.flightSuppOrderChangeInfoDto.getDepartureCityCode() != null && this.flightSuppOrderChangeInfoDto.getArrivalAirportCode() != null) {
                this.flightSegments = this.flightSuppOrderChangeInfoDto.getDepartureCityCode() + "-" + this.flightSuppOrderChangeInfoDto.getArrivalAirportCode();
            }
            
        }
    }

    public FlightSuppOrderChangeInfoDto getFlightSuppOrderChangeInfoDto() {
        return flightSuppOrderChangeInfoDto;
    }

    public void setFlightSuppOrderChangeInfoDto(
            FlightSuppOrderChangeInfoDto flightSuppOrderChangeInfoDto) {
        this.flightSuppOrderChangeInfoDto = flightSuppOrderChangeInfoDto;
    }

    public String getCarrierName() {
        return flightSuppOrderChangeInfoDto.getCarrierName();
    }

    public void setCarrierName(String carrierName) {
        flightSuppOrderChangeInfoDto.setCarrierName(carrierName);
    }

    public String getCarrierCode() {
        return flightSuppOrderChangeInfoDto.getCarrierCode();
    }

    public void setCarrierCode(String carrierCode) {
        flightSuppOrderChangeInfoDto.setCarrierCode(carrierCode);
    }

    public String getFlightNo() {
        return flightSuppOrderChangeInfoDto.getFlightNo();
    }

    public void setFlightNo(String flightNo) {
        flightSuppOrderChangeInfoDto.setFlightNo(flightNo);
    }

    public Airplane getAirplane() {
        return flightSuppOrderChangeInfoDto.getAirplane();
    }

    public void setAirplane(Airplane airplane) {
        flightSuppOrderChangeInfoDto.setAirplane(airplane);
    }

    public String getDepartureDate() {
        return flightSuppOrderChangeInfoDto.getDepartureDate();
    }

    public void setDepartureDate(String departureDate) {
        flightSuppOrderChangeInfoDto.setDepartureDate(departureDate);
    }

    public Date getDepartureTime() {
        return flightSuppOrderChangeInfoDto.getDepartureTime();
    }

    public void setDepartureTime(Date departureTime) {
        flightSuppOrderChangeInfoDto.setDepartureTime(departureTime);
    }

    public Date getArrivalTime() {
        return flightSuppOrderChangeInfoDto.getArrivalTime();
    }

    public void setArrivalTime(Date arrivalTime) {
        flightSuppOrderChangeInfoDto.setArrivalTime(arrivalTime);
    }

    public Integer getStopCount() {
        return flightSuppOrderChangeInfoDto.getStopCount();
    }

    public void setStopCount(Integer stopCount) {
        flightSuppOrderChangeInfoDto.setStopCount(stopCount);
    }

    public DirectType getDirectType() {
        return flightSuppOrderChangeInfoDto.getDirectType();
    }

    public void setDirectType(DirectType directType) {
        flightSuppOrderChangeInfoDto.setDirectType(directType);
    }

    public FlightStopInfoDto getFlightStopInfo() {
        return flightSuppOrderChangeInfoDto.getFlightStopInfo();
    }

    public void setFlightStopInfo(FlightStopInfoDto flightStopInfo) {
        flightSuppOrderChangeInfoDto.setFlightStopInfo(flightStopInfo);
    }

    public String getDepartureAirportCode() {
        return flightSuppOrderChangeInfoDto.getDepartureAirportCode();
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        flightSuppOrderChangeInfoDto.setDepartureAirportCode(departureAirportCode);
    }

    public String getDepartureCityCode() {
        return flightSuppOrderChangeInfoDto.getDepartureCityCode();
    }

    public void setDepartureCityCode(String departureCityCode) {
        flightSuppOrderChangeInfoDto.setDepartureCityCode(departureCityCode);
    }

    public String getArrivalAirportName() {
        return flightSuppOrderChangeInfoDto.getArrivalAirportName();
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        flightSuppOrderChangeInfoDto.setArrivalAirportName(arrivalAirportName);
    }

    public String getArrivalAirportCode() {
        return flightSuppOrderChangeInfoDto.getArrivalAirportCode();
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        flightSuppOrderChangeInfoDto.setArrivalAirportCode(arrivalAirportCode);
    }

    public String getArrivalTerminalBuilding() {
        return flightSuppOrderChangeInfoDto.getArrivalTerminalBuilding();
    }

    public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
        flightSuppOrderChangeInfoDto.setArrivalTerminalBuilding(arrivalTerminalBuilding);
    }

    public String getArrivalCityCode() {
        return flightSuppOrderChangeInfoDto.getArrivalCityCode();
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        flightSuppOrderChangeInfoDto.setArrivalCityCode(arrivalCityCode);
    }

    public String getArrivalCityName() {
        return flightSuppOrderChangeInfoDto.getArrivalCityName();
    }

    public void setArrivalCityName(String arrivalCityName) {
        flightSuppOrderChangeInfoDto.setArrivalCityName(arrivalCityName);
    }

    public MealType getMealType() {
        return flightSuppOrderChangeInfoDto.getMealType();
    }

    public void setMealType(MealType mealType) {
        flightSuppOrderChangeInfoDto.setMealType(mealType);
    }

    public BigDecimal getyParPrice() {
        return flightSuppOrderChangeInfoDto.getyParPrice();
    }

    public void setyParPrice(BigDecimal yParPrice) {
        flightSuppOrderChangeInfoDto.setyParPrice(yParPrice);
    }



    public int hashCode() {
        return flightSuppOrderChangeInfoDto.hashCode();
    }

    public List<FlightAirportFeeDto> getFees() {
        return flightSuppOrderChangeInfoDto.getFees();
    }

    public void setFees(List<FlightAirportFeeDto> fees) {
        flightSuppOrderChangeInfoDto.setFees(fees);
    }

    public List<FlightFuelsurTaxDto> getTaxs() {
        return flightSuppOrderChangeInfoDto.getTaxs();
    }

    public void setTaxs(List<FlightFuelsurTaxDto> taxs) {
        flightSuppOrderChangeInfoDto.setTaxs(taxs);
    }

    public String getDepartureCityName() {
        return flightSuppOrderChangeInfoDto.getDepartureCityName();
    }

    public void setDepartureCityName(String departureCityName) {
        flightSuppOrderChangeInfoDto.setDepartureCityName(departureCityName);
    }

    public String getSeatClassType() {
        return flightSuppOrderChangeInfoDto.getSeatClassType();
    }

    public void setSeatClassType(String seatClassType) {
        flightSuppOrderChangeInfoDto.setSeatClassType(seatClassType);
    }

    public String getSeatClassTypeName() {
        return flightSuppOrderChangeInfoDto.getSeatClassTypeName();
    }

    public void setSeatClassTypeName(String seatClassTypeName) {
        flightSuppOrderChangeInfoDto.setSeatClassTypeName(seatClassTypeName);
    }

    public String getSeatClassCode() {
        return flightSuppOrderChangeInfoDto.getSeatClassCode();
    }

    public void setSeatClassCode(String seatClassCode) {
        flightSuppOrderChangeInfoDto.setSeatClassCode(seatClassCode);
    }

    public String getSeatClassName() {
        return flightSuppOrderChangeInfoDto.getSeatClassName();
    }

    public void setSeatClassName(String seatClassName) {
        flightSuppOrderChangeInfoDto.setSeatClassName(seatClassName);
    }

    public String getSeatClassDesc() {
        return flightSuppOrderChangeInfoDto.getSeatClassDesc();
    }

    public void setSeatClassDesc(String seatClassDesc) {
        flightSuppOrderChangeInfoDto.setSeatClassDesc(seatClassDesc);
    }

    public FlightTicketPriceDto getFlightTicketPriceDto() {
        return flightSuppOrderChangeInfoDto.getFlightTicketPriceDto();
    }

    public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
        flightSuppOrderChangeInfoDto.setFlightTicketPriceDto(flightTicketPriceDto);
    }

    public String getSuppCode() {
        return flightSuppOrderChangeInfoDto.getSuppCode();
    }

    public void setSuppCode(String suppCode) {
        flightSuppOrderChangeInfoDto.setSuppCode(suppCode);
    }

    public InventoryStatus getInventoryStatus() {
        return flightSuppOrderChangeInfoDto.getInventoryStatus();
    }

    public void setInventoryStatus(InventoryStatus inventoryStatus) {
        flightSuppOrderChangeInfoDto.setInventoryStatus(inventoryStatus);
    }

    public Integer getInventoryCount() {
        return flightSuppOrderChangeInfoDto.getInventoryCount();
    }

    public void setInventoryCount(Integer inventoryCount) {
        flightSuppOrderChangeInfoDto.setInventoryCount(inventoryCount);
    }

    public String getRtRuleDesc() {
        return flightSuppOrderChangeInfoDto.getRtRuleDesc();
    }

    public void setRtRuleDesc(String rtRuleDesc) {
        flightSuppOrderChangeInfoDto.setRtRuleDesc(rtRuleDesc);
    }

    public String getMtRuleDesc() {
        return flightSuppOrderChangeInfoDto.getMtRuleDesc();
    }

    public void setMtRuleDesc(String mtRuleDesc) {
        flightSuppOrderChangeInfoDto.setMtRuleDesc(mtRuleDesc);
    }

    public String getCtRuleDesc() {
        return flightSuppOrderChangeInfoDto.getCtRuleDesc();
    }

    public void setCtRuleDesc(String ctRuleDesc) {
        flightSuppOrderChangeInfoDto.setCtRuleDesc(ctRuleDesc);
    }

    public String getSuppChangeNo() {
        return flightSuppOrderChangeInfoDto.getSuppChangeNo();
    }

    public void setSuppChangeNo(String suppChangeNo) {
        flightSuppOrderChangeInfoDto.setSuppChangeNo(suppChangeNo);
    }

    public String getSuppRefundNo() {
        return flightSuppOrderChangeInfoDto.getSuppRefundNo();
    }

    public void setSuppRefundNo(String suppRefundNo) {
        flightSuppOrderChangeInfoDto.setSuppRefundNo(suppRefundNo);
    }

    public BigDecimal getCdChangeFee() {
        return flightSuppOrderChangeInfoDto.getCdChangeFee();
    }

    public void setCdChangeFee(BigDecimal cdChangeFee) {
        flightSuppOrderChangeInfoDto.setCdChangeFee(cdChangeFee);
    }

    public BigDecimal getUpgradeFee() {
        return flightSuppOrderChangeInfoDto.getUpgradeFee();
    }

    public void setUpgradeFee(BigDecimal upgradeFee) {
        flightSuppOrderChangeInfoDto.setUpgradeFee(upgradeFee);
    }

    public String getSuppPolicyNo() {
        return flightSuppOrderChangeInfoDto.getSuppPolicyNo();
    }

    public void setSuppPolicyNo(String suppPolicyNo) {
        flightSuppOrderChangeInfoDto.setSuppPolicyNo(suppPolicyNo);
    }

    public BigDecimal getTotalSettlePrice() {
        return flightSuppOrderChangeInfoDto.getTotalSettlePrice();
    }

    public void setTotalSettlePrice(BigDecimal totalSettlePrice) {
        flightSuppOrderChangeInfoDto.setTotalSettlePrice(totalSettlePrice);
    }

    public BigDecimal getSalesParPrice() {
        return flightSuppOrderChangeInfoDto.getSalesParPrice();
    }

    public void setSalesParPrice(BigDecimal salesParPrice) {
        flightSuppOrderChangeInfoDto.setSalesParPrice(salesParPrice);
    }

    public BigDecimal getChildrenFuelsurTax() {
        return flightSuppOrderChangeInfoDto.getChildrenFuelsurTax();
    }

    public void setChildrenFuelsurTax(BigDecimal childrenFuelsurTax) {
        flightSuppOrderChangeInfoDto.setChildrenFuelsurTax(childrenFuelsurTax);
    }

    public BigDecimal getChildrenAirportFee() {
        return flightSuppOrderChangeInfoDto.getChildrenAirportFee();
    }

    public void setChildrenAirportFee(BigDecimal childrenAirportFee) {
        flightSuppOrderChangeInfoDto.setChildrenAirportFee(childrenAirportFee);
    }

    public FlightOrderDiscountDto getDiscountDto() {
        return flightSuppOrderChangeInfoDto.getDiscountDto();
    }

    public void setDiscountDto(FlightOrderDiscountDto discountDto) {
        flightSuppOrderChangeInfoDto.setDiscountDto(discountDto);
    }

    public ActiveStatus getActiveStatus() {
        return flightSuppOrderChangeInfoDto.getActiveStatus();
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        flightSuppOrderChangeInfoDto.setActiveStatus(activeStatus);
    }

    public BigDecimal getProfitAmount() {
        return flightSuppOrderChangeInfoDto.getProfitAmount();
    }

    public void setProfitAmount(BigDecimal profitAmount) {
        flightSuppOrderChangeInfoDto.setProfitAmount(profitAmount);
    }

    public PriceFormula getPromotionFormula() {
        return flightSuppOrderChangeInfoDto.getPromotionFormula();
    }

    public void setPromotionFormula(PriceFormula promotionFormula) {
        flightSuppOrderChangeInfoDto.setPromotionFormula(promotionFormula);
    }

    public BigDecimal getYParPrice() {
        return flightSuppOrderChangeInfoDto.getYParPrice();
    }

    public void setYParPrice(BigDecimal yParPrice) {
        flightSuppOrderChangeInfoDto.setYParPrice(yParPrice);
    }

    public BigDecimal getParPrice() {
        return flightSuppOrderChangeInfoDto.getParPrice();
    }

    public void setParPrice(BigDecimal parPrice) {
        flightSuppOrderChangeInfoDto.setParPrice(parPrice);
    }

    public BigDecimal getFuelsurTax() {
        return flightSuppOrderChangeInfoDto.getFuelsurTax();
    }

    public void setFuelsurTax(BigDecimal fuelsurTax) {
        flightSuppOrderChangeInfoDto.setFuelsurTax(fuelsurTax);
    }

    public BigDecimal getAirportFee() {
        return flightSuppOrderChangeInfoDto.getAirportFee();
    }

    public void setAirportFee(BigDecimal airportFee) {
        flightSuppOrderChangeInfoDto.setAirportFee(airportFee);
    }

    public BigDecimal getTotalParPrice() {
        return flightSuppOrderChangeInfoDto.getTotalParPrice();
    }

    public void setTotalParPrice(BigDecimal totalParPrice) {
        flightSuppOrderChangeInfoDto.setTotalParPrice(totalParPrice);
    }

    public BigDecimal getSalesPrice() {
        return flightSuppOrderChangeInfoDto.getSalesPrice();
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        flightSuppOrderChangeInfoDto.setSalesPrice(salesPrice);
    }

    public BigDecimal getSettlePrice() {
        return flightSuppOrderChangeInfoDto.getSettlePrice();
    }

    public void setSettlePrice(BigDecimal settlePrice) {
        flightSuppOrderChangeInfoDto.setSettlePrice(settlePrice);
    }

    public BigDecimal getDiscount() {
        return flightSuppOrderChangeInfoDto.getDiscount();
    }

    public void setDiscount(BigDecimal discount) {
        flightSuppOrderChangeInfoDto.setDiscount(discount);
    }

    public BigDecimal getPromotion() {
        return flightSuppOrderChangeInfoDto.getPromotion();
    }

    public void setPromotion(BigDecimal promotion) {
        flightSuppOrderChangeInfoDto.setPromotion(promotion);
    }

    public PriceFormula getProfit() {
        return flightSuppOrderChangeInfoDto.getProfit();
    }

    public void setProfit(PriceFormula profit) {
        flightSuppOrderChangeInfoDto.setProfit(profit);
    }

    public PassengerType getPassengerType() {
        return flightSuppOrderChangeInfoDto.getPassengerType();
    }

    public void setPassengerType(PassengerType passengerType) {
        flightSuppOrderChangeInfoDto.setPassengerType(passengerType);
    }

    public BigDecimal getOriginalSalesPrice() {
        return flightSuppOrderChangeInfoDto.getOriginalSalesPrice();
    }

    public void setOriginalSalesPrice(BigDecimal originalSalesPrice) {
        flightSuppOrderChangeInfoDto.setOriginalSalesPrice(originalSalesPrice);
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getDepartureTimeStr() {
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public String getArrivalTimeStr() {
        return arrivalTimeStr;
    }

    public void setArrivalTimeStr(String arrivalTimeStr) {
        this.arrivalTimeStr = arrivalTimeStr;
    }

    public String getMealTypeStr() {
        return mealTypeStr;
    }

    public void setMealTypeStr(String mealTypeStr) {
        this.mealTypeStr = mealTypeStr;
    }

    public String getFlightSegments() {
        return flightSegments;
    }

    public void setFlightSegments(String flightSegments) {
        this.flightSegments = flightSegments;
    }

    public String getDepartureDateStr() {
        return departureDateStr;
    }

    public void setDepartureDateStr(String departureDateStr) {
        this.departureDateStr = departureDateStr;
    }

    
}
