package com.lvmama.lvfit.openapi.app.calculate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.utils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsInfo;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsType;
import com.lvmama.lvfit.common.dto.app.FitAppShoppingRequest;
import com.lvmama.lvfit.common.dto.app.FitAppTrafficInfoDto;
import com.lvmama.lvfit.common.dto.calculator.request.CalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.TrafficTripeType;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.price.FitTicketAddTimePriceDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.openapi.app.search.FitAppDpSearchService;

/**
 * Created by leizhengwei
 * 2016/8/12
 * 16:22
 */
@Service
public class FitAppDpCalculateServiceImpl implements FitAppDpCalculateService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private FitDpClient dpClient;
	
	@Autowired
	private FitAppDpSearchService fitAppDpSearchService;
	
    @Override
    public BaseSingleResultDto<FitShoppingAmountDto> calculateAmount(FitAppShoppingRequest request) {
    	CalculateAmountDetailRequest calculateAmountRequest = this.createByAppRequest(request);
    	
        return dpClient.calculateAmountByDetail(calculateAmountRequest);
    }
    
    private CalculateAmountDetailRequest createByAppRequest(FitAppShoppingRequest request){
    	CalculateAmountDetailRequest calculateAmountRequest = new CalculateAmountDetailRequest();
    	
		BaseSingleResultDto<FitShoppingDto>  baseSingleResultDto = dpClient.getShoppingByUUID(request.getShoppingUuid());
		FitShoppingDto shoppingDto = null;
		if(baseSingleResultDto!=null){
			shoppingDto = baseSingleResultDto.getResult();
		}
		if(shoppingDto==null){
			throw new ExceptionWrapper(FitExceptionCode.GET_NO_CACHE_SHOPPING);
		}
		//相关参数
		shoppingDto.getSearchRequest().setBookingSource(request.getBookingSource());
		shoppingDto.getSearchRequest().setAdultsCount(request.getAdultCount());;
		shoppingDto.getSearchRequest().setChildCount(request.getChildCount());
				
		Map<String, List<FitAppGoodsInfo>> map =request.getSelectGoodsInfo();
		
		for(Map.Entry<String,List<FitAppGoodsInfo>> entry : map.entrySet()){
			//酒店
    		if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.HOTEL){
    			FitAppGoodsInfo appGoodsInfo = entry.getValue().get(0);

    			HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = shoppingDto.getHotels();

				HotelSearchHotelDto selectHotel = new HotelSearchHotelDto();
				HotelSearchRoomDto selectRoom = new HotelSearchRoomDto();
				HotelSearchPlanDto selectPlan = new HotelSearchPlanDto();
				for (HotelSearchHotelDto hotel : hotelSearchResult.getResults()) {
					for (HotelSearchRoomDto roomDto : hotel.getRooms()) {
						for (HotelSearchPlanDto plan : roomDto.getPlans()) {
							if (plan.getSuppGoodsId().equals(appGoodsInfo.getGoodsId())) {
								try {
									BeanUtils.copyProperties(selectPlan, plan);
									BeanUtils.copyProperties(selectRoom, roomDto);
									BeanUtils.copyProperties(selectHotel, hotel);
									selectPlan.setRoomCounts(appGoodsInfo.getCount());
								} catch (Exception e) {
									logger.error(e.getMessage(), e);
								}
							}
						}
					}
				}
				List<HotelSearchPlanDto> planDtoList = new ArrayList<HotelSearchPlanDto>();
				planDtoList.add(selectPlan);
				selectRoom.setPlans(planDtoList);

				List<HotelSearchRoomDto> roomDtoList = new ArrayList<HotelSearchRoomDto>();
				roomDtoList.add(selectRoom);

				selectHotel.setRooms(roomDtoList);
				List<HotelSearchHotelDto> hotelDtoList = new ArrayList<HotelSearchHotelDto>();
				hotelDtoList.add(selectHotel);
				hotelSearchResult.setResults(hotelDtoList);
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
    			for(int i = 0; entry.getValue() != null && i<entry.getValue().size(); i++){
					FitAppGoodsInfo appGoodsInfo = entry.getValue().get(i);
					if(shoppingDto.getInsurances()!=null) {
						for (InsuranceDto suppGoods : shoppingDto.getInsurances()) {
							if(appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(String.valueOf(suppGoods.getSuppGoodsId()))){
								if(appGoodsInfo.getPrice().floatValue() == suppGoods.getPrice().floatValue()) {
									FitShoppingSelectedInsuranceDto selectInsurance = new FitShoppingSelectedInsuranceDto();
									selectInsurance.setProductId(suppGoods.getProductId().toString());
									selectInsurance.setProductName(suppGoods.getProductName());
									selectInsurance.setInsuranceCount(appGoodsInfo.getCount());
									selectInsurance.setInsurancePrice(appGoodsInfo.getPrice());
									selectInsurance.setSuppGoodsId(String.valueOf(suppGoods.getSuppGoodsId()));
									selectInsurance.setBranchId(String.valueOf(suppGoods.getBranchId()));
									selectInsurance.setBranchName(suppGoods.getBranchName());
									selectInsurance.setSuppGoodsName(suppGoods.getGoodsName());
									selectInsurances.add(selectInsurance);
									break;
								} else {
									throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
																 appGoodsInfo.getPrice(),suppGoods.getSuppGoodsId(),suppGoods.getPrice());
								}
							}
						}
					}
					if(selectInsurances.size() != i+1){
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
		
		Map<String, FitAppTrafficInfoDto> selectTrafficInfoMap = request.getSelectTrafficInfo();
		
		for(Map.Entry<String,FitAppTrafficInfoDto> entry : selectTrafficInfoMap.entrySet()){
			if(entry.getValue()!=null) {
				FlightSearchFlightInfoDto flightDto = entry.getValue().getSearchFlightInfoDto();
				if(flightDto!=null) {
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
		
		calculateAmountRequest.setFitShoppingDto(shoppingDto); 
		calculateAmountRequest.setBookingSource(request.getBookingSource());
		
    	return calculateAmountRequest;
    }

}
