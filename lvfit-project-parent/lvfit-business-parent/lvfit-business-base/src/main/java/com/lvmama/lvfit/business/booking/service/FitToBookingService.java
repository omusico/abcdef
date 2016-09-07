package com.lvmama.lvfit.business.booking.service;

import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

/**
 * 进入订单填写页
 * @author qihuisong
 */
public interface FitToBookingService {

    /**
     * 重新预定
     */
    void toBooking(FitOrderBookingRequest fitOrderBookingRequest);

}
