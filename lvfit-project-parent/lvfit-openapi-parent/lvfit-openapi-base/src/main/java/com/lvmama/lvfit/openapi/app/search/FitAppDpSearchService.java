package com.lvmama.lvfit.openapi.app.search;

import com.lvmama.lvfit.common.dto.app.*;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;

import java.util.Map;

public interface FitAppDpSearchService {


	/**
	 * 获取机酒城市信息（包含所有城市信息以及热门城市信息）
	 * @return
     */
	FitAppFlightCityDto searchFlightCityInfo();

    /**
	 *查询商品接口
	 * @return
     */
	FitAppGoodsDto searchGoodsInfo(FitAppSearchRequest appSearchRequest);

	/**
	 * 查询所有航班信息
     * @return
     */
	Map<String,FlightSearchResult<FlightSearchFlightInfoDto>> getAllFlightInfos(FitAppFlightRequest request);


	/**
	 * 更换酒店接口
	 * @param
	 * @return
     */
	HotelSearchResult<HotelSearchHotelDto> changeHotelInfo(FitAppHotelRequest request);


}
