package com.lvmama.lvfit.openapi.app.booking;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.app.FitAppBookingRequest;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsInfo;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsType;
import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;
import com.lvmama.lvfit.common.dto.app.FitAppOrderDto;
import com.lvmama.lvfit.common.dto.app.FitAppOrderItemDto;
import com.lvmama.lvfit.common.dto.app.FitAppShoppingRequest;
import com.lvmama.lvfit.common.dto.app.FitAppTrafficInfoDto;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.TrafficTripeType;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.price.FitTicketAddTimePriceDto;
import com.lvmama.lvfit.common.dto.request.FitDpUpdateShoppingRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.openapi.app.search.FitAppDpSearchService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by leizhengwei
 * 2016/8/12
 * 16:22
 */
@Service
public class FitAppDpBookingServiceImpl implements FitAppDpBookingService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private FitDpClient dpClient;
	
	@Autowired
	private FitAppDpSearchService fitAppDpSearchService;
	
    @Override
    public FitAppOrderDto booking(FitAppBookingRequest appBookingRequest) {
    	FitOrderBookingRequest fitOrderBookingRequest = this.createByAppBookingRequest(appBookingRequest);
    	BaseSingleResultDto<FitOrderMainDto>  resultDto = dpClient.booking(fitOrderBookingRequest);
    	FitSuppMainOrderDto suppMainOrderDto = resultDto.getResult().getFitSuppMainOrderDto();
    	FitAppOrderDto appOrderDto = new FitAppOrderDto();
    	appOrderDto.setOrderId(suppMainOrderDto.getVstMainOrderNo());
		appOrderDto.setMainOrderStatusDto(suppMainOrderDto.getFitSuppMainOrderStatus());
		appOrderDto.setOughtAmount(suppMainOrderDto.getOrderAmount().getTotalAmount());
		appOrderDto.setCreateTime(suppMainOrderDto.getCreateTime());
		
		List<FitSuppOrderDto> fitSuppOrderDtos = suppMainOrderDto.getFitSuppOrderDtos();
		List<FitAppOrderItemDto> appOrderItemDtos = new ArrayList<FitAppOrderItemDto>();
		for (FitSuppOrderDto fitSuppOrderDto : fitSuppOrderDtos) {
			FitAppOrderItemDto appOrderItemDto = new FitAppOrderItemDto();
			appOrderItemDto.setCategoryId(fitSuppOrderDto.getCategoryId());
			appOrderItemDto.setOrderItemId(fitSuppOrderDto.getVstOrderNo());
			appOrderItemDto.setSuppGoodsId(fitSuppOrderDto.getSuppGoodsId());
			appOrderItemDto.setSuppOrderStatusDto(fitSuppOrderDto.getFitSuppOrderStatusDto());
			appOrderItemDtos.add(appOrderItemDto);
		}
		appOrderDto.setOrderItemList(appOrderItemDtos);
		return appOrderDto;
    }
    
    private FitOrderBookingRequest createByAppBookingRequest(FitAppBookingRequest appBookingRequest) {
    	FitOrderBookingRequest fitOrderBookingRequest = new FitOrderBookingRequest();
    	//将FitAppBookingRequest适配为fitOrderBookingRequest，服务端同样需修改
	    FitAppShoppingRequest appShoppingRequest = appBookingRequest.getAppShoppingRequest();
		fitOrderBookingRequest.setShoppingUuid(appShoppingRequest.getShoppingUuid());

		fitOrderBookingRequest.setBookingSource(appShoppingRequest.getBookingSource());
		fitOrderBookingRequest.setAdultQuantity(appShoppingRequest.getAdultCount());
		fitOrderBookingRequest.setChildQuantity(fitOrderBookingRequest.getChildQuantity());
		fitOrderBookingRequest.setProductName(appShoppingRequest.getProductName());
		
		fitOrderBookingRequest.setDistributionChannel(appShoppingRequest.getDistributionChannel());
		fitOrderBookingRequest.setDistributorCode(appShoppingRequest.getDistributorCode());
		
		fitOrderBookingRequest.setFitOrderCustomerDto(appBookingRequest.getFitOrderCustomerDto());
		fitOrderBookingRequest.setFitOrderContacterDto(appBookingRequest.getFitOrderContacterDto());
		fitOrderBookingRequest.setFitOrderPassengerDtos(appBookingRequest.getFitOrderPassengerDtos());
		fitOrderBookingRequest.setFitOrderExpressDto(appBookingRequest.getFitOrderExpressDto());
		FitOrderAmountDto fitOrderAmountDto = new FitOrderAmountDto();
		fitOrderAmountDto.setTotalSalesAmount(appBookingRequest.getTotalPrice());
		fitOrderBookingRequest.setFitOrderAmountDto(fitOrderAmountDto);
		BaseSingleResultDto<FitShoppingDto>  baseSingleResultDto = dpClient.getShoppingByUUID(appShoppingRequest.getShoppingUuid());
		FitShoppingDto shoppingDto = null;
		if(baseSingleResultDto!=null){
			shoppingDto = baseSingleResultDto.getResult();
		}
		if(shoppingDto==null){
			throw new ExceptionWrapper(FitExceptionCode.GET_NO_CACHE_SHOPPING);
		}
		//清空已选信息
		shoppingDto.getHotels().getResults().clear();
		shoppingDto.getFlightInfos().clear();
		shoppingDto.getSelectInsuranceInfo().clear();
		shoppingDto.getSelectTicketInfo().clear();
		shoppingDto.getSelectFlightInsInfo().clear();
		
		Map<String, List<FitAppGoodsInfo>> map = appBookingRequest.getAppShoppingRequest().getSelectGoodsInfo();
		
		for(Map.Entry<String,List<FitAppGoodsInfo>> entry : map.entrySet()){
			//酒店
    		if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.HOTEL){
    			FitAppGoodsInfo appGoodsInfo = entry.getValue().get(0);

    			FitAppHotelRequest request = new FitAppHotelRequest();
    			request.setAdultCount(appShoppingRequest.getAdultCount());
    			request.setChildCount(appShoppingRequest.getChildCount());
    			request.setDepartureDate(appGoodsInfo.getVisitDate());
    			request.setReturnDate(appGoodsInfo.getAppHotelRequest().getReturnDate());
    			request.setKeywords(appGoodsInfo.getAppHotelRequest().getKeywords());
    			request.setHotelFromRecommendedOnly(false);
    			request.setParams("P1");
    			request.setCityCode(appGoodsInfo.getAppHotelRequest().getCityCode());
    			HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = fitAppDpSearchService.changeHotelInfo(request);
    			List<HotelSearchHotelDto> hotels = new ArrayList<HotelSearchHotelDto>();
    			if(CollectionUtils.isNotEmpty(hotelSearchResult.getResults())){
					boolean isBreak = false;
					HotelSearchHotelDto selectHotelDto = hotelSearchResult.getResults().get(0);
					HotelSearchRoomDto firstRoom = new HotelSearchRoomDto();
					HotelSearchPlanDto firstPlan = new HotelSearchPlanDto();
					HotelSearchRoomDto needRemove = new HotelSearchRoomDto();
					for (HotelSearchRoomDto room : selectHotelDto.getRooms()) {
						for (HotelSearchPlanDto plan : room.getPlans()) {
							if(StringUtils.isNotBlank(appGoodsInfo.getGoodsId()) && appGoodsInfo.getGoodsId().equals(plan.getSuppGoodsId())){
								try {
									BeanUtils.copyProperties(firstPlan,plan);
									firstPlan.setSelectedFlag(true);
									BeanUtils.copyProperties(firstRoom,room);
									firstRoom.setSelectedFlag(true);
									firstPlan.setRoomCounts(appGoodsInfo.getCount());
									List<HotelSearchPlanDto> selectPlans = new ArrayList<HotelSearchPlanDto>();
									selectPlans.add(firstPlan);
									firstRoom.setPlans(selectPlans);
									needRemove = room;
									isBreak = true;
									break;
								} catch (Exception e) {
									logger.error(e.getMessage(),e);
								}
							}
						}
						if(isBreak){
							break;
						}
					}
					selectHotelDto.getRooms().remove(needRemove);
					if (CollectionUtils.isNotEmpty(selectHotelDto.getRooms())){
						for (HotelSearchRoomDto searchRoomDto : selectHotelDto.getRooms()){
							searchRoomDto.setSelectedFlag(false);
							if(CollectionUtils.isNotEmpty(searchRoomDto.getPlans())){
								for (HotelSearchPlanDto searchPlanDto : searchRoomDto.getPlans()){
									searchPlanDto.setSelectedFlag(false);
								}
							}
						}
					}
					List<HotelSearchRoomDto> lastRooms = new ArrayList<HotelSearchRoomDto>();
					lastRooms.add(firstRoom);
					lastRooms.addAll(selectHotelDto.getRooms());
					selectHotelDto.setRooms(lastRooms);
					hotels.add(selectHotelDto);
				}else{
    				throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH, appGoodsInfo.getGoodsId());
    			}
    			shoppingDto.setHotels(hotelSearchResult);
    		}
    		//门票
    		else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.TICKET){
    			List<FitShoppingSelectedTicketDto> selectTickets = new ArrayList<FitShoppingSelectedTicketDto>();
    			for(int i=0;entry.getValue()!=null && i<entry.getValue().size();i++){
    				FitAppGoodsInfo appGoodsInfo = entry.getValue().get(i);
    				boolean returnFlag = false;
    				if(shoppingDto.getSpots()!=null){
	    				for(int j=0; j<shoppingDto.getSpots().size() && (!returnFlag) ;j++){
	    					SpotSearchSpotDto spot = shoppingDto.getSpots().get(j);
	    					if(spot.getSpotTickets() != null){
    							for(SpotSearchTicketDto ticket : spot.getSpotTickets()){
	    							//Good 遍历start
			    					if(appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(ticket.getSuppGoodsId())){
			    							Date date = null;
			    							if(appGoodsInfo.getVisitDate()!=null){
			    								date = DateUtils.parseDate(appGoodsInfo.getVisitDate(), DateUtils.YYYY_MM_DD);
			    							}else{
			    								throw new ExceptionWrapper(FitExceptionCode.APP_TIME_NO_MATCH, appGoodsInfo.getGoodsId(),
			    			                			appGoodsInfo.getVisitDate());
			    							}
			    							if(ticket.getDayTimePriceDtos()!=null){
			    								for(FitTicketAddTimePriceDto dayPrice :ticket.getDayTimePriceDtos()){
			    									if(date.equals(dayPrice.getSpecDate())){
			    										if(dayPrice.getPrice()!=null && appGoodsInfo.getPrice().compareTo(dayPrice.getPrice())==0){
			    											
			    											FitShoppingSelectedTicketDto  selectTicket = new FitShoppingSelectedTicketDto();
			    			    							selectTicket.setProductId(ticket.getProductId());
			    			    							selectTicket.setSpotName(spot.getProductName());
			    			    							selectTicket.setSuppGoodsId(appGoodsInfo.getGoodsId());
			    			    							selectTicket.setTicketCount(appGoodsInfo.getCount());
			    			    							selectTicket.setTicketDate(date);
			    			    							selectTicket.setTicketName(ticket.getGoodsName());
			    			    							selectTicket.setTicketPrice(appGoodsInfo.getPrice());
			    			    							selectTickets.add(selectTicket);
			    			    							returnFlag =true;
			    											break;
			    										}else{
			    			    							throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
			    			    									appGoodsInfo.getPrice(),ticket.getSuppGoodsId(),dayPrice.getPrice());
			    			    						}
			    									}
			    								}
			    							}else{
    			    							throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
    			    									appGoodsInfo.getPrice(),ticket.getSuppGoodsId(),"");
    			    						}
				    					}
				    					
		    						}
			    					// Good 遍历end
	    					}
	    				}
    				}
    				if(selectTickets.size() != (i+1)){
						throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
					}
    			}
    			shoppingDto.setSelectTicketInfo(selectTickets);
    		}
    		//保险
    		else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.INSURANCE){
    			List<FitShoppingSelectedInsuranceDto> selectInsurances = new ArrayList<FitShoppingSelectedInsuranceDto>();
    			for(int i=0;entry.getValue()!=null && i<entry.getValue().size();i++){
					FitAppGoodsInfo appGoodsInfo = entry.getValue().get(i);

					FitShoppingSelectedInsuranceDto selectInsurance = null;
					for (InsuranceDto suppGoods : shoppingDto.getInsurances()) {
						if(appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(String.valueOf(suppGoods.getSuppGoodsId()))){
							if(appGoodsInfo.getPrice().floatValue() == suppGoods.getPrice().floatValue()) {
								selectInsurance = new FitShoppingSelectedInsuranceDto();
								selectInsurance.setProductId(String.valueOf(suppGoods.getProductId()));
								selectInsurance.setProductName(suppGoods.getProductName());
								selectInsurance.setInsuranceCount(appGoodsInfo.getCount());
								selectInsurance.setInsurancePrice(appGoodsInfo.getPrice());
								selectInsurance.setSuppGoodsId(String.valueOf(suppGoods.getSuppGoodsId()));
								selectInsurance.setBranchId(String.valueOf(suppGoods.getBranchId()));
								selectInsurance.setBranchName(suppGoods.getBranchName());
								selectInsurance.setSuppGoodsName(suppGoods.getGoodsName());
								selectInsurances.add(selectInsurance);
								break;
							}else{
								throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
									appGoodsInfo.getPrice(),suppGoods.getSuppGoodsId(),suppGoods.getPrice());
													}
						}
					}
					if(selectInsurance == null){
						throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
					}
    			}
    			shoppingDto.setSelectInsuranceInfo(selectInsurances);
    		}
    		//航空意外保险
    		else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.FLIGHT_INSURANCE){
    			List<FlightInsuranceDto> selectFlightInsInfo = new ArrayList<FlightInsuranceDto>();

    			for(int i=0;entry.getValue()!=null && i<entry.getValue().size();i++){
					FitAppGoodsInfo appGoodsInfo = entry.getValue().get(i);
					
					if(shoppingDto.getFlightInsuranceInfos()!=null){
						for(InsuranceInfoDto insurance : shoppingDto.getFlightInsuranceInfos()){
							if(appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(String.valueOf(insurance.getId()))){
								if(appGoodsInfo.getPrice().compareTo(insurance.getInsurancePrice())==0){
									FlightInsuranceDto flightInsurance = new FlightInsuranceDto();
									flightInsurance.setInsuranceId(insurance.getId());
									flightInsurance.setInsuranceName(insurance.getInsuranceClass().getName()+insurance.getInsuranceRemark());
									flightInsurance.setSuppName(insurance.getSupp().getName());
									flightInsurance.setInsurancePrice(insurance.getInsurancePrice());
									flightInsurance.setInsuranceCount(appGoodsInfo.getCount());
									flightInsurance.setInsuranceDesc(insurance.getInsuranceDesc());
									flightInsurance.setInsuranceClassCode(insurance.getInsuranceClass().getCode());
									selectFlightInsInfo.add(flightInsurance);
									break;
								}else{
									throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
											 appGoodsInfo.getPrice(),insurance.getId(),insurance.getInsurancePrice());
								}
							}
						}
						if(selectFlightInsInfo.size() != i+1){
							throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
						}
					}
					
    			}
    			shoppingDto.setSelectFlightInsInfo(selectFlightInsInfo);
    		}
		}
		
		Map<String, FitAppTrafficInfoDto> selectTrafficInfoMap = appBookingRequest.getAppShoppingRequest().getSelectTrafficInfo();
		
		List<FlightSearchFlightInfoDto> selectFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
		
		for(Map.Entry<String,FitAppTrafficInfoDto> entry : selectTrafficInfoMap.entrySet()){
			if(entry.getValue()!=null){
				FlightSearchFlightInfoDto flightDto = entry.getValue().getSearchFlightInfoDto();
				if(flightDto!=null){
					List<FlightSearchSeatDto> seats = new ArrayList<FlightSearchSeatDto>();
					for (FlightSearchSeatDto seat : flightDto.getSeats()) {
						if (entry.getValue().getSeatCode().equals(seat.getSeatClassCode())) {
							seats.add(seat);
							break;
						}
					}
					flightDto.setSeats(seats);
					if(seats.size()==0){
						throw new ExceptionWrapper(FitExceptionCode.APP_FLIGHT_NO_MATCH,entry.getValue().getFlightNo());
					}
					if(TrafficTripeType.GO_WAY==TrafficTripeType.valueOf(entry.getKey())) {
						List<FlightSearchFlightInfoDto> toFlightInfoList = shoppingDto.getToFlightInfos().getResults();
						toFlightInfoList.clear();
						toFlightInfoList.add(flightDto);
					} else if(TrafficTripeType.BACK_WAY == TrafficTripeType.valueOf(entry.getKey())) {
						List<FlightSearchFlightInfoDto> backFlightInfoList = shoppingDto.getBackFlightInfos().getResults();
						backFlightInfoList.clear();
						backFlightInfoList.add(flightDto);
					}
				}
			}
		}
		
		FitDpUpdateShoppingRequest shoppingRequest = new FitDpUpdateShoppingRequest();
		shoppingRequest.setShoppingUuid(appBookingRequest.getAppShoppingRequest().getShoppingUuid());
		shoppingRequest.setShoppingDto(shoppingDto);
		//保存shoppingDto到缓存
		dpClient.saveShoppingToCache(shoppingRequest);
		
		return fitOrderBookingRequest;
    	
    }
}
