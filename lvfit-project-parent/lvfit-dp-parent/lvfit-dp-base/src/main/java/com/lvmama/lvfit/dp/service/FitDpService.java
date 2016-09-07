package com.lvmama.lvfit.dp.service;

import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.TripeType;
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
	String search(FitSearchRequest request);
	
	//searchFlight 更换机票  调用资源聚合服务，筛选后，重新算价，组装返回信息
	FitSearchResult flightChangeSearch(String uuid,String method);
	
	//searchHotel  更换酒店  调用资源聚合服务，筛选后，重新算价，组装返回信息
	
	FitSearchResult hotelChangeSearch(FitSearchRequest request);

	/**
	 * 获取往返的航班列表
	 * */
	FitSearchResult queryToBackFlights(FitSearchRequest request);

	/**
	 * 过滤得到可售的酒店信息
	 * @param hotelList
	 * @param request
	 * @return
	 */
	List<HotelSearchResult<HotelSearchHotelDto>> getDefaultHotelInfo(List<HotelSearchResult<HotelSearchHotelDto>> hotelList,FitSearchRequest request);
	
	FitShoppingDto getShoppingResult(FitSearchRequest request);
	List<HotelSearchHotelDto> hotelSearch(HotelQueryRequest hotelQueryRequest);
	
	/**
	 * 检索门票信息
	 * 
	 * */
	SpotSearchResult<SpotSearchSpotDto> searchSpotTicket(SpotQueryRequest spotQueryRequest);
	
	FlightSearchResult<FlightSearchFlightInfoDto> handleFlights(FlightSearchResult<FlightSearchFlightInfoDto> searchResult);

	Map<String,FlightSearchResult<FlightSearchFlightInfoDto>> getAllFlightInfos(TripeType tripeType,
		String departureDate, String returnDate, String depCityCode, String arvCityCode, BookingSource bookingSource);

	/**
	 * 查询酒店列表信息
	 * @param request
	 * @return
     */
	HotelSearchResult<HotelSearchHotelDto> searchHotelInfos(FitAppHotelRequest request);
}
