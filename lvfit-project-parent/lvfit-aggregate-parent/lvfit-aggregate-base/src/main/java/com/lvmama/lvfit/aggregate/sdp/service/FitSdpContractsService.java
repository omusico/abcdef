package com.lvmama.lvfit.aggregate.sdp.service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

public interface FitSdpContractsService {
	/**
	 * 获取合同信息
	 * @param bookingRequest
	 * @return
	 */
	public BaseSingleResultDto<String> getContractsHtml(FitOrderBookingRequest bookingRequest);
}
