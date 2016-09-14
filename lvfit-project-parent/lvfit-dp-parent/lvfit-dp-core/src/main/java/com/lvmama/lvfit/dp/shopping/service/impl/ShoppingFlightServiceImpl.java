/**
 * Project Name:lvfit-dp-core
 * File Name:ShoppingFlightServiceImpl.java
 * Package Name:com.lvmama.lvfit.dp.shopping.service.impl
 * Date:2015-12-11下午2:41:26
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.dp.shopping.service.impl;

import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.dp.shopping.service.ShoppingFlightService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName:ShoppingFlightServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-11 下午2:41:26 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class ShoppingFlightServiceImpl implements ShoppingFlightService {
	
	private static Logger logger = LoggerFactory.getLogger(ShoppingFlightServiceImpl.class);
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Override
	public List<FlightSearchFlightInfoDto> changeFlight(ChangeFlightRequest request) {

		FitShoppingDto fitShoppingDto = shoppingService.getFitShopping(request.getShoppingUUID());

		List<FlightSearchFlightInfoDto> flightInfos = new ArrayList<FlightSearchFlightInfoDto>();
		if (request.getFlightType().equals(FlightTripType.DEPARTURE.name())) {
			flightInfos = fitShoppingDto.getToFlightInfos().getResults();
		}
		if (request.getFlightType().equals(FlightTripType.RETURN.name())) {
			flightInfos = fitShoppingDto.getBackFlightInfos().getResults();
		}

		FitBaseSearchRequest searchRequest = fitShoppingDto.getSearchRequest();
		int adultCount = searchRequest.getAdultsCount();
		int childCount = searchRequest.getChildCount();

		BigDecimal basePrice = BigDecimal.ZERO;
		// 根据选择的航班舱位设置新的基准价
		for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
			for (FlightSearchSeatDto seat : flightInfo.getSeats()) {
				if (seat.getSeatClassCode().equals(request.getSeatCode()) && flightInfo.getFlightNo().equals(request.getFlightNo())) {
					basePrice = seat.getSalesPrice().multiply(BigDecimal.valueOf(adultCount)).add(seat.getChildrenPrice().multiply(BigDecimal.valueOf(childCount)));
					break;
				}
			}
		}
		// 根据新的基准价设置新的差价
		for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
			for (FlightSearchSeatDto seat : flightInfo.getSeats()) {
				BigDecimal price = seat.getSalesPrice().multiply(BigDecimal.valueOf(adultCount)).add(seat.getChildrenPrice().multiply(BigDecimal.valueOf(childCount)));
				seat.setDifferentPrice(price.subtract(basePrice));
			}
		}
		// 根据新的差价对航班进行排序
		for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
			List<FlightSearchSeatDto> seats = flightInfo.getSeats();
			Collections.sort(seats, new Comparator<FlightSearchSeatDto>() {
				@Override
				public int compare(FlightSearchSeatDto o1, FlightSearchSeatDto o2) {
					if (o1.getDifferentPrice().doubleValue() > o2.getDifferentPrice().doubleValue()) {
						return 1;
					}
					if (o1.getDifferentPrice().doubleValue() < o2.getDifferentPrice().doubleValue()) {
						return -1;
					}
					return 0;
				}
			});
			flightInfo.setSeats(seats);
		}
		Collections.sort(flightInfos, new Comparator<FlightSearchFlightInfoDto>() {
			@Override
			public int compare(FlightSearchFlightInfoDto o1, FlightSearchFlightInfoDto o2) {
				if (o1.getSeats().get(0).getDifferentPrice()
					.compareTo(o2.getSeats().get(0).getDifferentPrice()) == 0) {
					DateUtils.parseDate(o1.getDepartureTime()).compareTo(DateUtils.parseDate(o2.getDepartureTime()));
				}
				if (o1.getSeats().get(0).getDifferentPrice().doubleValue() > o2.getSeats().get(0).getDifferentPrice().doubleValue()) {
					return 1;
				}
				if (o1.getSeats().get(0).getDifferentPrice().doubleValue() < o2.getSeats().get(0).getDifferentPrice().doubleValue()) {
					return -1;
				}
				return 0;
			}
		});
		// 将选择的航班和舱位排在首位
		FlightSearchFlightInfoDto selectFlight = null;
		for (int i = 0; i < flightInfos.size(); i++) {
			if (flightInfos.get(i).getFlightNo().equals(request.getFlightNo())) {
				selectFlight = flightInfos.get(i);
				flightInfos.remove(i);
				break;
			}
		}
		if (selectFlight != null) {
			FlightSearchSeatDto selectSeat = null;
			for (int j = 0; j < selectFlight.getSeats().size(); j++) {
				if (selectFlight.getSeats().get(j).getSeatClassCode().equals(request.getSeatCode())) {
					selectSeat = selectFlight.getSeats().get(j);
					selectFlight.getSeats().remove(j);
					break;
				}
			}
			if (selectSeat != null) {
				selectFlight.getSeats().add(0, selectSeat);
			}
			flightInfos.add(0, selectFlight);
		}
		// 更新购物车信息
		if (request.getFlightType().equals(FlightTripType.DEPARTURE.name())) {
			fitShoppingDto.getToFlightInfos().setResults(flightInfos);
			fitShoppingDto.setSelectToFlight(flightInfos.get(0));
		}
		if (request.getFlightType().equals(FlightTripType.RETURN.name())) {
			fitShoppingDto.getBackFlightInfos().setResults(flightInfos);
			fitShoppingDto.setSelectBackFlight(flightInfos.get(0));
		}

		shoppingService.putShoppingCache(request.getShoppingUUID(), fitShoppingDto);
		return flightInfos;
	}
}
