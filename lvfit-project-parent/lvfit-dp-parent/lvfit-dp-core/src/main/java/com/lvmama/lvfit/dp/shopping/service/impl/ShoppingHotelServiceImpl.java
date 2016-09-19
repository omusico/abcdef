/**
 * Project Name:lvfit-dp-core
 * File Name:ShoppingHotelServiceImpl.java
 * Package Name:com.lvmama.lvfit.dp.shopping.service.impl
 * Date:2015-12-11下午2:42:18
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.dp.shopping.service.impl;

import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
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

import java.math.BigDecimal;
import java.util.List;

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
	public List<HotelSearchHotelDto> changeHotel(ChangeHotelRequest request) {
		FitShoppingDto shoppingDto = shoppingService.getFitShopping(request.getShoppingUUID());
		List<HotelSearchHotelDto> hotelList = shoppingDto.getHotels().getResults();

		// 根据选择房间设置新的基准价
		BigDecimal hotelBasePrice = BigDecimal.ZERO;
		for (HotelSearchHotelDto hotel : hotelList) {
			for (HotelSearchRoomDto room : hotel.getRooms()) {
				for (HotelSearchPlanDto plan : room.getPlans()) {
					if (request.getHotelId().equals(hotel.getProductId())
						&& request.getRoomId().equals(room.getBranchId())
						&& request.getPlanId().equals(plan.getSuppGoodsId())) {
						plan.setPlanCounts(request.getRoomCount());
						hotelBasePrice = plan.getPrice().multiply(BigDecimal.valueOf(request.getRoomCount()));
						break;
					}
				}
			}
		}
		// 根据基准价设置新的差价
		for (HotelSearchHotelDto hotel : hotelList) {
			for (HotelSearchRoomDto room : hotel.getRooms()) {
				for (HotelSearchPlanDto plan : room.getPlans()) {
					plan.setPriceDifferences(plan.getPrice().multiply(BigDecimal.valueOf(plan.getPlanCounts())).subtract(hotelBasePrice));
				}
			}
		}
		// 将选中的酒店规格放在list首位
		HotelSearchHotelDto selectHotelDto = null;
		for (int i = 0; i < hotelList.size(); i++) {
			if (request.getHotelId().equals(hotelList.get(i).getProductId())) {
				selectHotelDto = hotelList.get(i);
				hotelList.remove(i);
				break;
			}
		}
		if (selectHotelDto != null) {
			HotelSearchRoomDto selectRoom = null;
			for (int j = 0; j < selectHotelDto.getRooms().size(); j++) {
				HotelSearchRoomDto room = selectHotelDto.getRooms().get(j);
				if (request.getRoomId().equals(room.getBranchId())) {
					selectRoom = room;
					selectHotelDto.getRooms().remove(j);
					break;
				}
			}
			if (selectRoom != null) {
				HotelSearchPlanDto selectPlan = null;
				for (int k = 0; k < selectRoom.getPlans().size(); k++) {
					HotelSearchPlanDto plan = selectRoom.getPlans().get(k);
					if (request.getPlanId().equals(plan.getSuppGoodsId())) {
						selectPlan = plan;
						selectRoom.getPlans().remove(k);
						break;
					}
				}
				if (selectPlan != null) {
					selectRoom.getPlans().add(0, selectPlan);
					selectHotelDto.getRooms().add(0, selectRoom);
					hotelList.add(0, selectHotelDto);
				}
			}
		}
		// 更新购物车信息
		shoppingDto.getHotels().setResults(hotelList);
		shoppingDto.setSelectHotel(hotelList.get(0));
		shoppingService.putShoppingCache(request.getShoppingUUID(), shoppingDto);
		return hotelList;
	}
}
