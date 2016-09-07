/**
 * Project Name:lvfit-aggregate-core
 * File Name:FitHotelDetailServiceImpl.java
 * Package Name:com.lvmama.lvfit.aggregate.core.hotel.service.impl
 * Date:2015-12-6下午2:08:06
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.aggregate.core.hotel.service.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.aggregate.hotel.service.FitHotelDetailService;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;

/**
 * ClassName:FitHotelDetailServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-6 下午2:08:06 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class FitHotelDetailServiceImpl implements FitHotelDetailService{
	@Autowired
    private FitVstClient fitVstClient;
	
	@Override
	public FitHotelDto getHotelDetail(FitHotelRequest request) throws JsonParseException, JsonMappingException, IOException {
		 FitHotelDto product = fitVstClient.getProdHotelDetail(request);
		return product;
	}

}

