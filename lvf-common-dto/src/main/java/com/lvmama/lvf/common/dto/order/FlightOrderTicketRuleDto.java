package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.AllowLowPrice;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.enums.SeatSpecType;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.DateRange;
import com.lvmama.lvf.common.dto.md.FlightOfficeDto;

/**
 * 订单客规主信息
 * 
 * @author majun
 * @date 2015-3-25
 */
public class FlightOrderTicketRuleDto extends AEEntity implements Serializable {
    private static final long serialVersionUID = -1661137859909971814L;

    /** 承运人信息 */
    private Carrier carrier;

    /** 等级舱位枚举 */
    private AllowLowPrice allowLowPrice;

    /** 乘客类型枚举 */
    private PassengerType passengerType;

    /** 时间 */
    private DateRange departureDateRange;
    private DateRange refundTicketDateRange;

    /** PNR配置组及城市信息 */
    private FlightOfficeDto flightOffice;

    /** 票退改签规则 */
    private FlightOrderTicketAllowRuleDto flightOrderTicketAllowRule;

    /** 航线类型 */
    private RouteType routeType;

    /** 舱位类型 */
    private SeatSpecType seatSpecType;

    /** 服务级别 */
    private String seatLevel;
    
    /** 退票规则信息 */
    private FlightOrderTicketRTRuleDto flightOrderTicketRTRule;

    /** 废票规则信息 */
    private FlightOrderTicketVTRuleDto flightOrderTicketVTRule;

    /** 签转规则信息 */
    private FlightOrderTicketMTRuleDto flightOrderTicketMTRule;

    /** 更改规则信息 */
    private FlightOrderTicketCTRuleDto flightOrderTicketCTRule;
    
    /** 票备注信息 */
    private FlightOrderTicketRemarkDto flightOrderTicketRemark;

    /** 订单航班组合明细主键 */
    private Long combinationDetailId;
    
    ////////////携程改签适用////////////
    /** 改签ID */
    private String suppChangeNo;

    /** 退票ID */
    private String suppRefundNo;

    public FlightOrderTicketRemarkDto getFlightOrderTicketRemark() {
        return flightOrderTicketRemark;
    }

    public void setFlightOrderTicketRemark(FlightOrderTicketRemarkDto flightOrderTicketRemark) {
        this.flightOrderTicketRemark = flightOrderTicketRemark;
    }

    public String getSeatLevel() {
        return seatLevel;
    }

    public void setSeatLevel(String seatLevel) {
        this.seatLevel = seatLevel;
    }

    public SeatSpecType getSeatSpecType() {
        return seatSpecType;
    }

    public void setSeatSpecType(SeatSpecType seatSpecType) {
        this.seatSpecType = seatSpecType;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public AllowLowPrice getAllowLowPrice() {
        return allowLowPrice;
    }

    public void setAllowLowPrice(AllowLowPrice allowLowPrice) {
        this.allowLowPrice = allowLowPrice;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public DateRange getDepartureDateRange() {
        return departureDateRange;
    }

    public void setDepartureDateRange(DateRange departureDateRange) {
        this.departureDateRange = departureDateRange;
    }

    public DateRange getRefundTicketDateRange() {
        return refundTicketDateRange;
    }

    public void setRefundTicketDateRange(DateRange refundTicketDateRange) {
        this.refundTicketDateRange = refundTicketDateRange;
    }

    public FlightOfficeDto getFlightOffice() {
        return flightOffice;
    }

    public void setFlightOffice(FlightOfficeDto flightOffice) {
        this.flightOffice = flightOffice;
    }

    public FlightOrderTicketAllowRuleDto getFlightOrderTicketAllowRule() {
        return flightOrderTicketAllowRule;
    }

    public void setFlightOrderTicketAllowRule(
            FlightOrderTicketAllowRuleDto flightOrderTicketAllowRule) {
        this.flightOrderTicketAllowRule = flightOrderTicketAllowRule;
    }

    public FlightOrderTicketRTRuleDto getFlightOrderTicketRTRule() {
        return flightOrderTicketRTRule;
    }

    public void setFlightOrderTicketRTRule(FlightOrderTicketRTRuleDto flightOrderTicketRTRule) {
        this.flightOrderTicketRTRule = flightOrderTicketRTRule;
    }

    public FlightOrderTicketVTRuleDto getFlightOrderTicketVTRule() {
        return flightOrderTicketVTRule;
    }

    public void setFlightOrderTicketVTRule(FlightOrderTicketVTRuleDto flightOrderTicketVTRule) {
        this.flightOrderTicketVTRule = flightOrderTicketVTRule;
    }

    public FlightOrderTicketMTRuleDto getFlightOrderTicketMTRule() {
        return flightOrderTicketMTRule;
    }

    public void setFlightOrderTicketMTRule(FlightOrderTicketMTRuleDto flightOrderTicketMTRule) {
        this.flightOrderTicketMTRule = flightOrderTicketMTRule;
    }

    public FlightOrderTicketCTRuleDto getFlightOrderTicketCTRule() {
        return flightOrderTicketCTRule;
    }

    public void setFlightOrderTicketCTRule(FlightOrderTicketCTRuleDto flightOrderTicketCTRule) {
        this.flightOrderTicketCTRule = flightOrderTicketCTRule;
    }

    public Long getCombinationDetailId() {
        return combinationDetailId;
    }

    public void setCombinationDetailId(Long combinationDetailId) {
        this.combinationDetailId = combinationDetailId;
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

    @Override
    @JsonIgnore
    public String getSequence() {
        return "S_FORD_TICKET_RULE";
    }

}
