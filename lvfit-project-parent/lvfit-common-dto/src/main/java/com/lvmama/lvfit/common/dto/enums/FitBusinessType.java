package com.lvmama.lvfit.common.dto.enums;

/**
 * 机+酒业务类型ENUM<br>
 * <b>FLI_HOTEL_Q_H</b>("机票和酒店查询-酒店查询"),<br>
 * <b>FLI_HOTEL_Q_T</b>("机票和酒店查询-去程机票查询"),<br>
 * <b>FLI_HOTEL_Q_R</b>("机票和酒店查询-返程机票查询"),<br>
 * <b>CHG_FLI</b>("换航班"),<br>
 * <b>CHG_HOTEL</b>("换酒店"),<br>
 * <b>CALCULATE_FLI_PRICE</b>("计算机票价格"),<br>
 * <b>CALCULATE_HOTEL_PRICE</b>("计算酒店价格");<br>
 * @author lizongze
 *
 */
public enum FitBusinessType {
    FIT_Q("机票和酒店查询",FitBusinessExceptionType.FIT_Q_E),
    FIT_Q_H("机票和酒店查询-酒店查询",FitBusinessExceptionType.FIT_Q_H_E),
    FIT_Q_T("机票和酒店查询-去程机票查询",FitBusinessExceptionType.FIT_Q_T_E),
    FIT_Q_R("机票和酒店查询-返程机票查询",FitBusinessExceptionType.FIT_Q_R_E),
    FIT_Q_S("机票和酒店查询-景点查询",FitBusinessExceptionType.FIT_Q_S_E),
    FIT_QUERY_INSURANCE("机票和酒店查询-保险查询",FitBusinessExceptionType.FIT_QUERY_INSURANCE_E),
    FIT_QUERY_FLIGHT_INSURANCE("机票和酒店查询-航空意外险查询", FitBusinessExceptionType.FIT_QUERY_FLIGHT_INSURANCE_E),
    CHG_FLI("换航班",FitBusinessExceptionType.CHG_FLI_E),
    CHG_HOTEL("换酒店",FitBusinessExceptionType.CHG_HOTEL_E),
    CALCULATE_FLI_PRICE("计算机票价格",FitBusinessExceptionType.CALCULATE_FLI_PRICE_E),
    CALCULATE_HOTEL_PRICE("计算酒店价格",FitBusinessExceptionType.CALCULATE_HOTEL_PRICE_E),
    CALCULATE_SPOT_TICKET_PRICE("计算景点门票价格",FitBusinessExceptionType.CALCULATE_SPOT_TICKET_PRICE_E),
    CALCULATE_INSURANCE_PRICE("计算保险价格",FitBusinessExceptionType.CALCULATE_SPOT_TICKET_PRICE_E),
    BOOKING("预订",FitBusinessExceptionType.BOOKING_E),
    FIT_SDP_CALCULATE_FLI_PRICE("sdp-计算机票价格",FitBusinessExceptionType.FIT_SDP_CALCULATE_FLI_PRICE_E),
    FIT_SDP_BOOKING("sdp-预订",FitBusinessExceptionType.FIT_SDP_BOOKING_E),
    FIT_SDP_GO_FLIGHT_QUERY("交通+地接-去程机票查询", FitBusinessExceptionType.FIT_SDP_GO_FLIGHT_QUERY_E),
    FIT_SDP_BACK_FLIGHT_QUERY("交通+地接-返程机票查询", FitBusinessExceptionType.FIT_SDP_BACK_FLIGHT_QUERY_E),
    FIT_SDP_SEARCH_GOODS("交通+地接-VST商品查询", FitBusinessExceptionType.FIT_SDP_SEARCH_GOODS_E);

    private String cnName;
    
    private FitBusinessExceptionType businessExceptionType;

    private FitBusinessType(String cnName,FitBusinessExceptionType businessExceptionType) {
        this.cnName = cnName;
        this.businessExceptionType = businessExceptionType;
    }

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public FitBusinessExceptionType getBusinessExceptionType() {
		return businessExceptionType;
	}

	public void setBusinessExceptionType(
			FitBusinessExceptionType businessExceptionType) {
		this.businessExceptionType = businessExceptionType;
	}
    
	
}


