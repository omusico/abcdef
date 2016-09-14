/**
 * Project Name:lvfit-dp-core
 * File Name:ShoppingWiewServiceImpl.java
 * Package Name:com.lvmama.lvfit.dp.shopping.service.impl
 * Date:2015-12-11下午2:42:57
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.dp.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOperDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProduct;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProductBranch;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceSuppGoods;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedFlightInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDbDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingFlightDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingHotelDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingSpotTicketDto;
import com.lvmama.lvfit.common.utils.HotelUtils;
import com.lvmama.lvfit.dp.service.FitDpService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingViewService;

/**
 * ClassName:ShoppingWiewServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-11 下午2:42:57 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class ShoppingViewServiceImpl implements ShoppingViewService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ShoppingService shoppingService;

	/**
	 * 
	 * TODO 从缓存中加载购物车数据.
	 * 
	 * @see com.lvmama.lvfit.dp.shopping.service.ShoppingViewService#getShoppingByShoppingUUID(java.lang.String)
	 */
	@Override
	public BaseSingleResultDto<FitShoppingDto> getShoppingByShoppingUUID(String shoppingUUID) {
		
		FitShoppingDto fitShoppingDto = shoppingService.getFitShopping(shoppingUUID);

		BaseSingleResultDto<FitShoppingDto> result = new BaseSingleResultDto<FitShoppingDto>();
		result.setStatus(ResultStatus.SUCCESS);
		result.setResult(fitShoppingDto);
		return result;
	}
}
