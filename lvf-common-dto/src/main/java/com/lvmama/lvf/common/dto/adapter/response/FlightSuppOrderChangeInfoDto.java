package com.lvmama.lvf.common.dto.adapter.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

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

/**
 * 国内机票可改航班查询信息列表
 * 
 * @author yuanweihong
 * @date 2015-9-23
 */
@XmlRootElement
public class FlightSuppOrderChangeInfoDto implements Serializable {

    private static final long serialVersionUID = 7968518518010547399L;

    /** 航空公司名称 */
    private String carrierName;

    /** 航空公司名称 */
    private String carrierCode;

    /** 航班号 */
    private String flightNo;

    /** 机型信息 */
    private Airplane airplane;

    /** 出发日期 */
    private String departureDate;

    /** 出发时间 */
    private Date departureTime;

    /** 到达时间 */
    private Date arrivalTime;

    // /** 飞行时长（HH:mm） */
    // private String flyTime;
    //
    // /** 飞行时长（单位：分钟数） */
    // private Integer flyTimeMins;

    /** 经停次数 */
    private Integer stopCount;

    /** 是否是直飞 */
    private DirectType directType;

    /** 航班经停主信息 */
    private FlightStopInfoDto flightStopInfo;

    // /** 经停城市 */
    // private String stopCity;
    //
    // /** 经停机场 */
    // private String stopAirport;
    //
    // /** 经停时长（单位：分钟数） */
    // private Integer stopTimeMins;

    // /** 出发机场名称 */
    // private String departureAirportName;

    /** 出发机场Code */
    private String departureAirportCode;

    // /** 出发机场航站楼 */
    // private String departureTermainalBuilding;

    /** 出发城市Code */
    private String departureCityCode;

     /** 出发城市名称 */
     private String departureCityName;

    /** 到达机场名称 */
    private String arrivalAirportName;

    /** 到达机场Code */
    private String arrivalAirportCode;

    /** 到达机场航站楼 */
    private String arrivalTerminalBuilding;

    /** 到达城市Code */
    private String arrivalCityCode;

    /** 到达城市名称 */
    private String arrivalCityName;

    /** 餐食类型 */
    private MealType mealType;

    /** Y舱票面价 */
    private BigDecimal yParPrice;

    /**机场费信息*/
    private List<FlightAirportFeeDto> fees = new ArrayList<FlightAirportFeeDto>();
    
    /**燃油费信息 */
    private List<FlightFuelsurTaxDto> taxs = new ArrayList<FlightFuelsurTaxDto>();

    /** 舱位类型 */
    private String seatClassType;

    /** 舱位类型 */
    private String seatClassTypeName;

    /** 舱位Code */
    private String seatClassCode;

    /** 舱位名称 */
    private String seatClassName;

    /** 舱位描述 */
    private String seatClassDesc;

    /** 价格信息 */
    private FlightTicketPriceDto flightTicketPriceDto = new FlightTicketPriceDto();

    /** 供应商编码 */
    private String suppCode;

    /** 库存状态 */
    private InventoryStatus inventoryStatus;

    /** 库存数量 */
    private Integer InventoryCount;

    /** 客规描述(退) */
    private String rtRuleDesc;

    /** 客规描述(改) */
    private String mtRuleDesc;

    /** 客规描述(签) */
    private String ctRuleDesc;

    /** 改签ID */
    private String suppChangeNo;

    /** 退票ID */
    private String suppRefundNo;

    /** 改期费 */
    private BigDecimal cdChangeFee;

    /** 升舱费 */
    private BigDecimal upgradeFee;

    /** 供应商政策NO */
    private String suppPolicyNo;

    /** 改签总费用 */
    private BigDecimal totalSettlePrice;

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
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

    public Integer getStopCount() {
        return stopCount;
    }

    public void setStopCount(Integer stopCount) {
        this.stopCount = stopCount;
    }

    public DirectType getDirectType() {
        return directType;
    }

    public void setDirectType(DirectType directType) {
        this.directType = directType;
    }

    public FlightStopInfoDto getFlightStopInfo() {
        return flightStopInfo;
    }

    public void setFlightStopInfo(FlightStopInfoDto flightStopInfo) {
        this.flightStopInfo = flightStopInfo;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getArrivalTerminalBuilding() {
        return arrivalTerminalBuilding;
    }

    public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
        this.arrivalTerminalBuilding = arrivalTerminalBuilding;
    }

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode;
    }

    public String getArrivalCityName() {
        return arrivalCityName;
    }

    public void setArrivalCityName(String arrivalCityName) {
        this.arrivalCityName = arrivalCityName;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public BigDecimal getyParPrice() {
        return yParPrice;
    }

    public void setyParPrice(BigDecimal yParPrice) {
        this.yParPrice = yParPrice;
    }

    public List<FlightAirportFeeDto> getFees() {
        return fees;
    }

    public void setFees(List<FlightAirportFeeDto> fees) {
        this.fees = fees;
    }

    public List<FlightFuelsurTaxDto> getTaxs() {
        return taxs;
    }

    public void setTaxs(List<FlightFuelsurTaxDto> taxs) {
        this.taxs = taxs;
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

    public FlightTicketPriceDto getFlightTicketPriceDto() {
        return flightTicketPriceDto;
    }

    public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
        this.flightTicketPriceDto = flightTicketPriceDto;
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

    public String getRtRuleDesc() {
        return rtRuleDesc;
    }

    public void setRtRuleDesc(String rtRuleDesc) {
        this.rtRuleDesc = rtRuleDesc;
    }

    public String getMtRuleDesc() {
        return mtRuleDesc;
    }

    public void setMtRuleDesc(String mtRuleDesc) {
        this.mtRuleDesc = mtRuleDesc;
    }

    public String getCtRuleDesc() {
        return ctRuleDesc;
    }

    public void setCtRuleDesc(String ctRuleDesc) {
        this.ctRuleDesc = ctRuleDesc;
    }

    public String getSuppChangeNo() {
        return suppChangeNo;
    }

    public void setSuppChangeNo(String suppChangeNo) {
        this.suppChangeNo = suppChangeNo;
    }

    public String getSuppRefundNo() {
        return suppRefundNo;
    }

    public void setSuppRefundNo(String suppRefundNo) {
        this.suppRefundNo = suppRefundNo;
    }

    public BigDecimal getCdChangeFee() {
        return cdChangeFee;
    }

    public void setCdChangeFee(BigDecimal cdChangeFee) {
        this.cdChangeFee = cdChangeFee;
    }

    public BigDecimal getUpgradeFee() {
        return upgradeFee;
    }

    public void setUpgradeFee(BigDecimal upgradeFee) {
        this.upgradeFee = upgradeFee;
    }

    public String getSuppPolicyNo() {
        return suppPolicyNo;
    }

    public void setSuppPolicyNo(String suppPolicyNo) {
        this.suppPolicyNo = suppPolicyNo;
    }

    public BigDecimal getTotalSettlePrice() {
        return totalSettlePrice;
    }

    public void setTotalSettlePrice(BigDecimal totalSettlePrice) {
        this.totalSettlePrice = totalSettlePrice;
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

    public String getDepartureCityName() {
        return departureCityName;
    }

    public void setDepartureCityName(String departureCityName) {
        this.departureCityName = departureCityName;
    }

}
