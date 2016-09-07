package com.lvmama.lvfit.dp.booking.service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

/**
 * 预定
 * @author qihuisong
 */
public interface FitBookingService {

    /**
	//booking 根据前端传回的Booking报文
	 * +shoppingCartId补全资源信息，组装一个完整的booking报文所需的信息
	 * 传给business-booking
     * 去预定
     * @param fitBookingDto
     * @return
     */
    BaseSingleResultDto<FitOrderMainDto> booking(FitOrderBookingRequest fitOrderBookingRequest);

    /**
     * 下单前，校验价格
     */
    void checkOrderTotalSalesAmount(FitOrderBookingRequest fitOrderBookingRequest);

}
