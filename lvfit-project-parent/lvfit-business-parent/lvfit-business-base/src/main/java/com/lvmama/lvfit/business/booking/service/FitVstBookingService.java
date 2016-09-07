package com.lvmama.lvfit.business.booking.service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

/**
 * VST预定
 * @author qihuisong
 */
public interface FitVstBookingService {

    /**
     * 下vst订单--酒店订单会由vst下下去
     * @param fitOrderMainDto
     * @return
     */
    FitOrderMainDto vstBooking(FitOrderMainDto fitOrderMainDto);
    
    /**
     * 触发vst订单资源审核callback
     * @param fitOrderBookingRequest
     * @return
     */
    BaseSingleResultDto<FitOrderDto> auditCallBack(FitOrderBookingRequest fitOrderBookingRequest);

}
