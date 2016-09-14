package com.lvmama.lvfit.dp.service;

import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import com.lvmama.lvfit.common.dto.request.FitFilterFlightRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

import java.util.List;
import java.util.Map;


public interface FitDpService {
	
	//查询，调用各个资源聚合服务，筛选后，重新算价，组装返回信息
	FitShoppingDto search(FitBaseSearchRequest request);

	List<HotelSearchHotelDto> hotelSearch(HotelQueryRequest hotelQueryRequest);
	
	/**
	 * 检索门票信息
	 * 
	 * */
	SpotSearchResult<SpotSearchSpotDto> searchSpotTicket(SpotQueryRequest spotQueryRequest);

	/**
	 * 查询航班信息
	 * @param tripeType
	 * @param departureDate
	 * @param returnDate
	 * @param depCityCode
	 * @param arvCityCode
	 * @param bookingSource
     * @return
     */
	Map<String,FlightSearchResult<FlightSearchFlightInfoDto>> getAllFlightInfos(TripeType tripeType,
		String departureDate, String returnDate, String depCityCode, String arvCityCode, BookingSource bookingSource);

	/**
	 * 查询酒店列表信息（新）
	 * @param request
	 * @return
     */
	HotelSearchResult<HotelSearchHotelDto> searchHotelInfos(FitAppHotelRequest request);

	/**
	 * 根据筛选条件对航班信息进行筛选
	 */
	List<FlightSearchFlightInfoDto> getFlightInfos(FitFilterFlightRequest request);
}
