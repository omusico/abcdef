package com.lvmama.lvfit.business.booking.service;

import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;

/**
 * @author qihuisong
 */
public interface FitBookingFinService {

	/**
     * 回填
     * @param fitOrderMainDto
     * @return
     */
    FitOrderMainDto finishBooking(FitOrderMainDto fitOrderMainDto);


}
