package com.lvmama.lvfit.business.booking.service;

import java.util.List;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvfit.common.dto.booking.FitFliCallBackResponseVSTDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;

/**
 * 机票单品预定
 * @author qihuisong
 */
public interface FitFlightBookingService {

    /**
     * 下机票订单
     * @param fitOrderMainDto
     * @return
     */
    FitOrderMainDto flightBooking(FitOrderMainDto fitOrderMainDto);
    
    
    /**
     * VST测回调机票下单(快速响应vst方法)
     * @param vstOrderNoMap
     * @return
     */
    BaseResponseDto<FitFliCallBackResponseVSTDto> flightCallBackBooking(List<FitFliBookingCallBackRequest> callBackRequests);
    
    
    /**
     * VST测回调机票下单实际异步方法
     * @param callBackRequests
     */
    void fitFlightBookingAsync(List<FitFliBookingCallBackRequest> callBackRequests);

}
