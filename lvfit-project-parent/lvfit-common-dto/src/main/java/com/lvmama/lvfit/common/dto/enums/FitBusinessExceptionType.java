package com.lvmama.lvfit.common.dto.enums;

public enum FitBusinessExceptionType {
	
	_E("异常后缀"),
    FIT_Q_E("机票和酒店查询"),
    FIT_Q_H_E("机票和酒店查询-酒店查询"),
    FIT_Q_T_E("机票和酒店查询-去程机票查询"),
    FIT_Q_R_E("机票和酒店查询-返程机票查询"),
    FIT_Q_S_E("机票和酒店查询-景点查询"),
    FIT_QUERY_INSURANCE_E("机票和酒店查询-保险查询"),
    FIT_QUERY_FLIGHT_INSURANCE_E("机票和酒店查询-航空意外险查询"),
    CHG_FLI_E("换航班"),
    CHG_HOTEL_E("换酒店"),
    CALCULATE_FLI_PRICE_E("计算机票价格"),
    CALCULATE_HOTEL_PRICE_E("计算酒店价格"),
    CALCULATE_SPOT_TICKET_PRICE_E("计算景点门票价格"),
    BOOKING_E("预订"),
    RECORD_BOOKING_LOG_NO_LOGIN("用户点击预订下一步按钮前记录用户请求信息"),
    FLIGHT_CALLBACK_BOOKING("vst侧回调机票下单"),
    FIT_SDP_SEARCH_PRODUCT_E("sdp-产品查询"),
    FIT_SDP_SEARCH_CALENDAR_INFO_E("sdp-低价日历查询"),
    FIT_SDP_SEARCH_GOODS_E("sdp-商品查询"),
    FIT_SDP_CALCULATE_FLI_PRICE_E("sdp-计算机票价格"),
    FIT_SDP_BOOKING_E("sdp-预订"),
    FIT_SDP_GO_FLIGHT_QUERY_E("交通+地接-去程机票查询"),
    FIT_SDP_BACK_FLIGHT_QUERY_E("交通+地接-返程机票查询");

	private String cnName;
	
	private FitBusinessExceptionType(String cnName) {
	        this.cnName = cnName;
	}
    
	public String getCnName() {
		return cnName;
	}
	
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
    
 }
