package com.lvmama.lvfit.adapter.vst.service;

import com.lvmama.lvfit.common.dto.hotel.FitHotelTimePrice;
import com.lvmama.lvfit.common.dto.request.FitHotelPriceRequest;

public interface HotelPriceService {

	/**
	 * 查询商品时间价格信息
	 * @param parameters
	 * @return
	 */
	public FitHotelTimePrice findTimePriceBySpecDate(FitHotelPriceRequest request);
	
}
