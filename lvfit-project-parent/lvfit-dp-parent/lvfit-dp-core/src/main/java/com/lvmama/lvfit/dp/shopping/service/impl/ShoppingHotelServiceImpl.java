/**
 * Project Name:lvfit-dp-core
 * File Name:ShoppingHotelServiceImpl.java
 * Package Name:com.lvmama.lvfit.dp.shopping.service.impl
 * Date:2015-12-11下午2:42:18
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.dp.shopping.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.dto.request.ChangeHotelRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.dp.shopping.service.ShoppingHotelService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;

/**
 * ClassName:ShoppingHotelServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-11 下午2:42:18 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class ShoppingHotelServiceImpl implements ShoppingHotelService {
		
	private static Logger logger = LoggerFactory.getLogger(ShoppingHotelServiceImpl.class);
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Autowired
	FitAggregateClient fitAggregateClient;

	@Override
	public BaseSingleResultDto<FitShoppingDto> changeHotel(ChangeHotelRequest request) {
		
		try{
			FitShoppingDto shoppingDto = shoppingService.changedHotel(request);
			BaseSingleResultDto<FitShoppingDto> result = new BaseSingleResultDto<FitShoppingDto>();
			result.setResult(shoppingDto);
			result.setStatus(ResultStatus.SUCCESS);
			return result;
			} catch(ExceptionWrapper ew){
				throw ew;
			}
	}
	
	/**
	 * 更换酒店之后，根据酒店id再进行查询景点门票信息 
	 * @param request
	 * @param shoppingDto
	 */
	private void querySpotByHotelId(ChangeHotelRequest request,FitShoppingDto shoppingDto) {
		SpotSearchResult<SpotSearchSpotDto> spotResult = new SpotSearchResult<SpotSearchSpotDto>();
		try{
			String shoppingId = request.getShoppingUUID();
			SpotQueryRequest spotQueryRequest = shoppingDto.getSearchRequest().getSpotQueryRequests().get(0);
			spotQueryRequest.setHotelId(request.getHotelId());
			spotResult = fitAggregateClient.searchSpot(spotQueryRequest);
			shoppingDto.setSpots(spotResult.getResults());
			shoppingService.putShoppingCache(shoppingId,shoppingDto);
		} catch(Exception e){
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper exceptionWrapper = (ExceptionWrapper)e;
				throw exceptionWrapper;
			}else{
				logger.error("查询景点门票信息异常",e);
				throw new ExceptionWrapper(ExceptionCode.UNDEF_ERROR);
			}
		}
	}
	
}
