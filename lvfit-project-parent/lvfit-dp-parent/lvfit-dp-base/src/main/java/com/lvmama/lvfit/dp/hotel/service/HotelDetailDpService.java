package com.lvmama.lvfit.dp.hotel.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;

public interface HotelDetailDpService {
	/**
	 * 酒店详情DP服务
	 * @author wanghuihui
	 * @date:2015年12月6日 下午4:41:39
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	FitHotelDto getHotelDetail(FitHotelRequest request) throws JsonParseException, JsonMappingException, IOException; 
}
