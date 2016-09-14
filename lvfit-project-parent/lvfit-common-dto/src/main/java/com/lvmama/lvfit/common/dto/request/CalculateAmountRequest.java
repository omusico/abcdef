/**
 * Project Name:lvfit-common-dto
 * File Name:CalculateAmountRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.request
 * Date:2015-12-13下午6:05:15
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.calculator.BookingDetailDto;
import com.lvmama.lvfit.common.dto.calculator.FlightSimpleInfoDto;
import com.lvmama.lvfit.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitBusinessType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.price.FitFlightTicketPriceDto;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;

/**
 * ClassName:CalculateAmountRequest <br/>
 * Function: 算价服务请求参数. <br/>
 * Date: 2015-12-13 下午6:05:15 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class CalculateAmountRequest implements Serializable {
	
	private static Logger logger = LoggerFactory.getLogger(CalculateAmountRequest.class);
	
	private static final long serialVersionUID = -7417011050731027622L;
	
	public CalculateAmountRequest() {
		super();
	}
	
	private String shoppingUUID;
	
	private BookingSource bookingSource;
	
	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}
	
	public BookingSource getBookingSource() {
		return bookingSource;
	}
	

	public String getShoppingUUID() {
		return shoppingUUID;
	}
	
	public void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}
	
    /**
     * 构造算价请求Map
     * @param selectShoppingDto
     * @return
     */
    @JsonIgnore
	public Map<String, Object> getRequestMap(FitShoppingDto selectShoppingDto,BookingSource bookingSource) {
    	
    	Map<String, Object> requestMap = new HashMap<String, Object>();

    	List<FlightSearchFlightInfoDto> selectSearchFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
		selectSearchFlightInfoDtos.add(selectShoppingDto.getToFlightInfos().getResults().get(0));
		selectSearchFlightInfoDtos.add(selectShoppingDto.getBackFlightInfos().getResults().get(0));

    	FitBaseSearchRequest searchRequest = selectShoppingDto.getSearchRequest();
    	searchRequest.setBookingSource(bookingSource);
		AmountCalculatorRequest flightPriceRequest = this.getFlightPriceRequest(selectSearchFlightInfoDtos, searchRequest);
		if(flightPriceRequest!=null){
			requestMap.put(FitBusinessType.CALCULATE_FLI_PRICE.name(),flightPriceRequest);
		}
		FitHotelPriceRequest  hotelPriceRequest = this.getHotelPriceRequest(selectShoppingDto);
		if(hotelPriceRequest!=null){
			requestMap.put(FitBusinessType.CALCULATE_HOTEL_PRICE.name(),hotelPriceRequest);
		}
		FitSpotTicketPriceRequest  spotTicketPriceRequest = this.getSpotTicketPriceRequest(selectShoppingDto);
		if(spotTicketPriceRequest!=null){
			requestMap.put(FitBusinessType.CALCULATE_SPOT_TICKET_PRICE.name(),spotTicketPriceRequest);
		}
		FitInsurancePriceRequest fitInsurancePriceRequest = this.getFitInsurancePriceRequest(selectShoppingDto);
		if (fitInsurancePriceRequest != null) {
		    requestMap.put(FitBusinessType.CALCULATE_INSURANCE_PRICE.name(), fitInsurancePriceRequest);
		}
		
		return requestMap;
		
	}

    /**
	 * 	构造机票价格计算请求对象
	 * @param
	 * @return
	 */
	@JsonIgnore
	public AmountCalculatorRequest getFlightPriceRequest(List<FlightSearchFlightInfoDto> selectSearchFlightInfoDtos, FitBaseSearchRequest searchRequest) {

		List<BookingDetailDto> amountDetailDtos = new ArrayList<BookingDetailDto>();
		int adultCount = searchRequest.getAdultsCount();
		int childCount = searchRequest.getChildCount();
		List<BookingDetailDto> passengerDetailDtos = new ArrayList<BookingDetailDto>();
		
		//按照乘客数和航段来构造最小单元请求对象
		for (int i = 0; i < adultCount; i++) {
			BookingDetailDto dto = new BookingDetailDto();
			dto.setPassengerType(PassengerType.ADULT);
			passengerDetailDtos.add(dto);
		}
		for (int i = 0; i < childCount; i++) {
			BookingDetailDto dto = new BookingDetailDto();
			dto.setPassengerType(PassengerType.CHILDREN);
			passengerDetailDtos.add(dto);
		}
		for (FlightSearchFlightInfoDto selectSearchFlightInfoDto : selectSearchFlightInfoDtos) {
			for (BookingDetailDto passengerDetailDto : passengerDetailDtos) {
				BookingDetailDto amountDetailDto = new BookingDetailDto();
				FlightSimpleInfoDto flightSimpleInfoDto = new FlightSimpleInfoDto();
				flightSimpleInfoDto.setDepartureDate(DateUtils.parseDate(selectSearchFlightInfoDto.getDepartureDate(), DateUtils.YYYY_MM_DD));
				flightSimpleInfoDto.setFlightNo(selectSearchFlightInfoDto.getFlightNo());
				FlightSearchSeatDto selectSearchSeatDto = selectSearchFlightInfoDto.getSeats().get(0);
				flightSimpleInfoDto.setPolicyId(selectSearchSeatDto.getPolicyId());
				//flightSimpleInfoDto.setPricePolicyId(selectSearchSeatDto.getPricePolicyId());
				flightSimpleInfoDto.setPricePolicyId(null);
				flightSimpleInfoDto.setSeatClassCode(selectSearchSeatDto.getSeatClassCode());
				flightSimpleInfoDto.setDepartureAirportCode(selectSearchFlightInfoDto.getDepartureAirportCode());
				flightSimpleInfoDto.setArrivalAirportCode(selectSearchFlightInfoDto.getArrivalAirportCode());
				FlightTicketPriceDto flightTicketPriceDto = new FlightTicketPriceDto();
				FitFlightTicketPriceDto fitFlightTicketPriceDto = new FitFlightTicketPriceDto(); 
				if(passengerDetailDto.getPassengerType()==PassengerType.CHILDREN){
					fitFlightTicketPriceDto=selectSearchFlightInfoDto.getChildrenSeats().get(selectSearchSeatDto.getSeatClassType()).getFlightTicketPriceDto();
				}else{
					fitFlightTicketPriceDto = selectSearchSeatDto.getFlightTicketPriceDto();
				}
				try {
					BeanUtils.copyProperties(flightTicketPriceDto, fitFlightTicketPriceDto);
				} catch (Exception e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
				flightSimpleInfoDto.setFlightTicketPriceDto(flightTicketPriceDto);
				amountDetailDto.setFlightSimpleInfo(flightSimpleInfoDto);
				amountDetailDto.setPassengerType(passengerDetailDto.getPassengerType());
				amountDetailDtos.add(amountDetailDto);
			}
		}
		if(CollectionUtils.isNotEmpty(amountDetailDtos)){
			AmountCalculatorRequest flightPriceRequest = new AmountCalculatorRequest();
			flightPriceRequest.setBookingSource(BookingSource.valueOf(searchRequest.getBookingSource().getParentSource().name()));
			flightPriceRequest.setPassengerDetailDtos(amountDetailDtos);
			return flightPriceRequest;
		}
		return null;
	}
	
	/**
	 * 构造酒店价格计算请求对象
	 * @param selectShoppingDto
	 * @return
	 */
	@JsonIgnore
	public FitHotelPriceRequest getHotelPriceRequest(FitShoppingDto selectShoppingDto) {
		
		FitHotelPriceRequest hotelPriceRequest = new FitHotelPriceRequest();
		FitBaseSearchRequest searchRequest = selectShoppingDto.getSearchRequest();

		Date checkInDate = DateUtils.parseDate(searchRequest.getCheckInTime());
		Date checkOutDate = DateUtils.parseDate(searchRequest.getCheckOutTime());
		if(CollectionUtils.isNotEmpty(selectShoppingDto.getHotels().getResults())){
			BigDecimal roomCount =  BigDecimal.ONE;
			List<HotelSearchRoomDto> roomDtos = selectShoppingDto.getHotels().getResults().get(0).getRooms();
			HotelSearchPlanDto selectSearchPlanDto = roomDtos.get(0).getPlans().get(0);
			if(CollectionUtils.isNotEmpty(roomDtos)){
				for(HotelSearchRoomDto roomDto: roomDtos){
					if(roomDto.getSelectedFlag()){
						if(roomDto.getRoomCounts()!=null){
							roomCount = new BigDecimal(roomDto.getRoomCounts());
						}
						selectSearchPlanDto = roomDto.getPlans().get(0);
						break;
					}
				}
			}
			Long planId = Long.valueOf(selectSearchPlanDto.getSuppGoodsId());
			hotelPriceRequest.setPricePlanId(planId);
			hotelPriceRequest.setStartDate(checkInDate);
			hotelPriceRequest.setEndDate(checkOutDate);
			hotelPriceRequest.setRoomCount(roomCount);
			return hotelPriceRequest;
		}
		return null;
	}
	
	/**
	 * 构造门票价格计算请求对象
	 * @param selectShoppingDto
	 * @return
	 */
	@JsonIgnore
	public FitSpotTicketPriceRequest getSpotTicketPriceRequest(FitShoppingDto selectShoppingDto) {
		
		 FitSpotTicketPriceRequest spotTicketPriceRequest = null;
		 List<FitShoppingSelectedTicketDto> selectTicketInfoDtos = selectShoppingDto.getSelectTicketInfo();
		 if(CollectionUtils.isNotEmpty(selectTicketInfoDtos)){
			 spotTicketPriceRequest = new FitSpotTicketPriceRequest();
			 spotTicketPriceRequest.setSelectTicketInfos(selectTicketInfoDtos);
		 }
	
		return spotTicketPriceRequest;
	}
	
	/**
     * 构造保险价格计算请求对象
     * @param selectShoppingDto
     * @return
     */
	@JsonIgnore
    private FitInsurancePriceRequest getFitInsurancePriceRequest(FitShoppingDto selectShoppingDto) {
        FitInsurancePriceRequest fitInsurancePriceRequest = null;
        List<FitShoppingSelectedInsuranceDto> selInsuranceDtos = selectShoppingDto.getSelectInsuranceInfo();
        if(CollectionUtils.isNotEmpty(selInsuranceDtos)){
            fitInsurancePriceRequest = new FitInsurancePriceRequest();
            fitInsurancePriceRequest.setSelectInsuranceInfos(selInsuranceDtos);
        }
        return fitInsurancePriceRequest;
    }

}
