package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.AllowLowPrice;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.enums.SeatSpecType;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.DateRange;
import com.lvmama.lvf.common.dto.md.FlightOfficeDto;

public class FlightTicketRuleDto extends AEEntity implements Serializable {

	private static final long serialVersionUID = -1661137859909971814L;

	/** 承运人信息 */
	private Carrier carrier;

	/** 等级舱位枚举 */
	private AllowLowPrice allowLowPrice;

	/** 关联政策ID */
	private Long refPolicyId;
	// private FlightTripType flightTripType;

	/** 乘客类型枚举 */
	private PassengerType passengerType;

	/** 时间 */
	private DateRange departureDateRange;
	private DateRange refundTicketDateRange;

	/** PNR配置组及城市信息 */
	private FlightOfficeDto flightOffice;

	/** 票退改签规则 */
	private FlightTicketAllowRuleDto flightTicketAllowRule;

	/** 航线类型 */
	private RouteType routeType;

	/** 舱位类型 */
	private SeatSpecType seatSpecType;

	/** 服务级别 */
	private String seatLevel;
	
	/** 退票规则信息 */
	private FlightTicketRTRuleDto flightTicketRTRule;
	
	/** 废票规则信息 */
	private FlightTicketVTRuleDto flightTicketVTRule;
	
	/** 签转规则信息 */
	private FlightTicketMTRuleDto flightTicketMTRule;
	
	/** 更改规则信息 */
	private FlightTicketCTRuleDto flightTicketCTRule;

	/** 票备注信息 */
	private FlightTicketRemarkDto flightTicketRemark;
	
	////////////携程改签适用////////////
    /** 改签ID */
    private String suppChangeNo;

    /** 退票ID */
    private String suppRefundNo;
    
    /** 产品来源 */
    private String productSourceNum;
    
    /** 是否能退 */
    private String nonRef;
    
    /** 是否能改 */
    private String nonRer;

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

	public Long getRefPolicyId() {
		return refPolicyId;
	}

	public void setRefPolicyId(Long refPolicyId) {
		this.refPolicyId = refPolicyId;
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

	public FlightTicketAllowRuleDto getFlightTicketAllowRule() {
		return flightTicketAllowRule;
	}

	public void setFlightTicketAllowRule(
			FlightTicketAllowRuleDto flightTicketAllowRule) {
		this.flightTicketAllowRule = flightTicketAllowRule;
	}

	public FlightTicketRTRuleDto getFlightTicketRTRule() {
		return flightTicketRTRule;
	}

	public void setFlightTicketRTRule(FlightTicketRTRuleDto flightTicketRTRule) {
		this.flightTicketRTRule = flightTicketRTRule;
	}

	public FlightTicketVTRuleDto getFlightTicketVTRule() {
		return flightTicketVTRule;
	}

	public void setFlightTicketVTRule(FlightTicketVTRuleDto flightTicketVTRule) {
		this.flightTicketVTRule = flightTicketVTRule;
	}

	public FlightTicketMTRuleDto getFlightTicketMTRule() {
		return flightTicketMTRule;
	}

	public void setFlightTicketMTRule(FlightTicketMTRuleDto flightTicketMTRule) {
		this.flightTicketMTRule = flightTicketMTRule;
	}

	public FlightTicketCTRuleDto getFlightTicketCTRule() {
		return flightTicketCTRule;
	}

	public void setFlightTicketCTRule(FlightTicketCTRuleDto flightTicketCTRule) {
		this.flightTicketCTRule = flightTicketCTRule;
	}

	public FlightTicketRemarkDto getFlightTicketRemark() {
		return flightTicketRemark;
	}

	public void setFlightTicketRemark(FlightTicketRemarkDto flightTicketRemark) {
		this.flightTicketRemark = flightTicketRemark;
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

	public String getProductSourceNum() {
		return productSourceNum;
	}

	public void setProductSourceNum(String productSourceNum) {
		this.productSourceNum = productSourceNum;
	}

	public String getNonRef() {
		return nonRef;
	}

	public void setNonRef(String nonRef) {
		this.nonRef = nonRef;
	}

	public String getNonRer() {
		return nonRer;
	}

	public void setNonRer(String nonRer) {
		this.nonRer = nonRer;
	}


}
