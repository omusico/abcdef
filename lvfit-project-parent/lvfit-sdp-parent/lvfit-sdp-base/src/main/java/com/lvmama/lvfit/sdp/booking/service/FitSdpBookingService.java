package com.lvmama.lvfit.sdp.booking.service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

/**
 * 交通自主打包预订Service
 * @author leizhengwei
 *
 */
public interface FitSdpBookingService {

	
	 /**
	  * 根据前端传回的fitOrderBookingRequest报文+shoppingCartId补全资源信息，组装一个完整的booking报文所需的信息传给business-booking去预定
	  * @param bookingRequest
	  * @return
	  */
	 BaseSingleResultDto<FitOrderMainDto> booking(FitOrderBookingRequest bookingRequest);

	/**根据前端传回的fitOrderBookingRequest报文,组装一个完整的booking报文所需的信息传给business-booking去预定
	 * @param bookingRequest
	 * @return
	 */
	 BaseSingleResultDto<FitOrderMainDto> bookingByDetail(FitOrderBookingRequest bookingRequest);
	
}
