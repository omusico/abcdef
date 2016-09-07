package com.lvmama.lvfit.dp.hotel.service.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.dp.hotel.service.HotelDetailDpService;

@Service
public class HotelDetailDpServiceImpl implements HotelDetailDpService {
	@Autowired
	private FitAggregateClient fitAggregateClient;
	
	@Override
	public FitHotelDto getHotelDetail(FitHotelRequest request) throws JsonParseException, JsonMappingException, IOException {
		FitHotelDto fitHotelDto = fitAggregateClient.getHotelDetail(request);
		return fitHotelDto;
	}

}
