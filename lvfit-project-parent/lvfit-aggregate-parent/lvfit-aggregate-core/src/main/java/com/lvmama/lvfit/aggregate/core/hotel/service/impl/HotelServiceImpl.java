package com.lvmama.lvfit.aggregate.core.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.aggregate.resource.hotel.service.HotelService;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private FitSearchClient fitSearchClient;

	@Override
	public HotelSearchResult<HotelSearchHotelDto> searchHotel(HotelQueryRequest hotelQueryRequest) {
		// TODO Auto-generated method stub
		String sessionID =  "125205";
		HotelSearchResult<HotelSearchHotelDto> result = fitSearchClient.searchHotel(hotelQueryRequest, sessionID);
		
		return result;
	}
	
}