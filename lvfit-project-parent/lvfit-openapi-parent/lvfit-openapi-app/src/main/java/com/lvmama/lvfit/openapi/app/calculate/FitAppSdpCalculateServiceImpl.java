package com.lvmama.lvfit.openapi.app.calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitSdpAppClient;
import com.lvmama.lvfit.common.client.FitSdpClient;
import com.lvmama.lvfit.common.dto.enums.TrafficTripeType;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsInfo;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsType;
import com.lvmama.lvfit.common.dto.app.FitAppShoppingRequest;
import com.lvmama.lvfit.common.dto.app.FitAppTrafficInfoDto;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpRoomDiff;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;

@Service
public class FitAppSdpCalculateServiceImpl implements FitAppSdpCalculateService {
	
	@Autowired
	private FitSdpClient fitSdpClient;
	
	private static Logger logger = LoggerFactory.getLogger(FitSdpAppClient.class);
	
	@Override
	public BaseSingleResultDto<FitSdpShoppingAmountDto> calculateAmount(FitAppShoppingRequest request) {


		FitSdpCalculateAmountDetailRequest calculateAmountDetailRequest = this.createByAppRequest(request);
		return fitSdpClient.calculateAmountByDetail(calculateAmountDetailRequest);
	}


	private FitSdpCalculateAmountDetailRequest createByAppRequest(FitAppShoppingRequest request) {

		FitSdpCalculateAmountDetailRequest calculateAmountDetailRequest = new FitSdpCalculateAmountDetailRequest();
		//FitAppShoppingRequest适配为FitSdpCalculateAmountDetailRequest
		
	    FitSdpShoppingDto sdpShoppingDto = fitSdpClient.getShoppingByUUID(request.getShoppingUuid());
		if (null == sdpShoppingDto) {
	            throw new ExceptionWrapper(FitExceptionCode.GET_NO_CACHE_SHOPPING);
        }
		//人数和份数信息
		calculateAmountDetailRequest.setPeopleCount(request.getAdultCount()+request.getChildCount());
		calculateAmountDetailRequest.setQuantity(request.getQuantity());
		calculateAmountDetailRequest.setProductId(request.getProductId());
		
		
		Map<String, List<FitAppGoodsInfo>> map =request.getSelectGoodsInfo();
		
		for(Map.Entry<String,List<FitAppGoodsInfo>> entry : map.entrySet()){
			//酒店套餐
			if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.HOTEL_COMBO){
				FitSdpHotelComboGoodsDto selectedHotelComboGoods = new FitSdpHotelComboGoodsDto();
				try {
					BeanUtils.copyProperties(selectedHotelComboGoods,sdpShoppingDto.getHotelCombos().get(0));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				FitAppGoodsInfo appGoodsInfo = entry.getValue().get(0);
				if(entry.getValue().get(0).getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(selectedHotelComboGoods.getSuppGoodsId().toString())){
					if(appGoodsInfo.getPrice().compareTo(selectedHotelComboGoods.getPrice())==0){
						selectedHotelComboGoods.setPrice( appGoodsInfo.getPrice());
						selectedHotelComboGoods.setQuantity(Long.valueOf(appGoodsInfo.getCount()));
						selectedHotelComboGoods.setStartDayStr(appGoodsInfo.getVisitDate());
						calculateAmountDetailRequest.setSelectedHotelComboGoods(selectedHotelComboGoods);
					}else{
						  throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH,appGoodsInfo.getGoodsId(),appGoodsInfo.getPrice(),
	                 	    selectedHotelComboGoods.getSuppGoodsId(),selectedHotelComboGoods.getPrice());
					}
				}else{
					throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
				}
			}
			else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.OTHER_TICKETS){
				List<FitSdpSelectOtherTicketDto> selectOtherTickets  = new ArrayList<FitSdpSelectOtherTicketDto>();
				for(int i=0;entry.getValue()!=null && i<entry.getValue().size();i++){
					FitAppGoodsInfo appGoodsInfo = entry.getValue().get(i);
					
					for(FitSdpOtherTicketDto sdpOtherTicketDto : sdpShoppingDto.getOtherTickets()){
						if(appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(sdpOtherTicketDto.getSuppGoodsId().toString())){
		                	if(appGoodsInfo.getPrice().compareTo(sdpOtherTicketDto.getDefaultSelectPrice())==0){
		                		FitSdpSelectOtherTicketDto selectOtherTicketDto = new FitSdpSelectOtherTicketDto();
		                		try {
		                			BeanUtils.copyProperties(selectOtherTicketDto,sdpOtherTicketDto);
		                		} catch(Exception e) {
		                			throw new RuntimeException(e);
		                		}
		                		selectOtherTicketDto.setSelectPrice(appGoodsInfo.getPrice());
		                		selectOtherTicketDto.setSelectCount(Long.valueOf(appGoodsInfo.getCount()));
		                		selectOtherTicketDto.setSelectDate(appGoodsInfo.getVisitDate());
		                		selectOtherTickets.add(selectOtherTicketDto);
		                		break;
		                	}else{
		                		throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
		                				appGoodsInfo.getPrice(),sdpOtherTicketDto.getSuppGoodsId(),sdpOtherTicketDto.getDefaultSelectPrice());
		                	}
						}
                	}
					if(selectOtherTickets.size() != (i+1)){
						throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
					}
                }
                calculateAmountDetailRequest.setSelectOtherTickets(selectOtherTickets);
			}
			else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.INLAND_INSURANCE){
				List<FitSdpSelectInsuranceDto> fitOrderInsuranceDtos = new ArrayList<FitSdpSelectInsuranceDto>();
				for(int i=0;entry.getValue()!=null && i<entry.getValue().size();i++){
					FitAppGoodsInfo appGoodsInfo = entry.getValue().get(i);
					
					for(FitSdpInsuranceDto sdpIndurance : sdpShoppingDto.getInsurances()){
						if(appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(sdpIndurance.getSuppGoodsId().toString())){
							if(appGoodsInfo.getPrice().compareTo(sdpIndurance.getPrice())==0){
								FitSdpSelectInsuranceDto selectInsurance = new FitSdpSelectInsuranceDto();
								selectInsurance.setProductName(sdpIndurance.getProductName());
								selectInsurance.setSuppGoodsId(sdpIndurance.getSuppGoodsId());
								selectInsurance.setBranchName(sdpIndurance.getBranchName());
								selectInsurance.setGoodsName(sdpIndurance.getGoodsName());
								selectInsurance.setBranchDesc(sdpIndurance.getBranchDesc());
								selectInsurance.setPrice(entry.getValue().get(i).getPrice());
								selectInsurance.setSelectCount(Long.valueOf(entry.getValue().get(i).getCount()));
								
								fitOrderInsuranceDtos.add(selectInsurance);
								break;
							 }else{
								 throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
										 appGoodsInfo.getPrice(),sdpIndurance.getSuppGoodsId(),sdpIndurance.getPrice());
							 }
						 }
					}
					if(fitOrderInsuranceDtos.size() != i+1){
						throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
					}
				}
				calculateAmountDetailRequest.setSelectInsurances(fitOrderInsuranceDtos);
			}
			else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.LOCAL_TRIP){
				FitSdpLocalTripProductDto localTripDto = sdpShoppingDto.getSelectLocalTripPrduct();
				FitSdpLocalTripProductDto selectLocalTripDto = new FitSdpLocalTripProductDto();
				FitAppGoodsInfo appGoodsInfo = entry.getValue().get(0);
				if(localTripDto!=null){
					if(appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(localTripDto.getSuppGoodsId().toString())){
						
						int adultCount = sdpShoppingDto.getFitSdpShoppingRequest().getFitPassengerRequest().getAdultCount();
						int childCount = sdpShoppingDto.getFitSdpShoppingRequest().getFitPassengerRequest().getChildCount();
						int requestPeopleCount = request.getAdultCount()+request.getChildCount();
						
						if((appGoodsInfo.getPrice().compareTo(localTripDto.getPrice())!=0)){
							throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
									appGoodsInfo.getPrice(),localTripDto.getSuppGoodsId(),localTripDto.getPrice());
							
						}else if(requestPeopleCount != adultCount + childCount){
							throw new ExceptionWrapper(FitExceptionCode.APP_PEOPLE_COUNT_NO_MATCH, request.getAdultCount(),
									request.getChildCount(),adultCount,childCount);
						}else{
							try {
								BeanUtils.copyProperties(selectLocalTripDto,localTripDto);
							}  catch (Exception e) {
								throw new RuntimeException(e);
							}
							calculateAmountDetailRequest.setSelectLocalTripPrduct(selectLocalTripDto);
						}
					}else{
						throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
					}
				}
			}
			else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.ROOM_DIFF){
				if(map.containsKey(FitAppGoodsType.LOCAL_TRIP.name())){
					FitSdpRoomDiff diff = sdpShoppingDto.getSelectRoomDiffs();
					if(diff!=null){
						if(diff.getRoomDiffPrice().compareTo(entry.getValue().get(0).getPrice())==0){
							FitSdpRoomDiff selectRoomDiffs = new FitSdpRoomDiff();
							selectRoomDiffs.setRoomDiffPrice(entry.getValue().get(0).getPrice());
							selectRoomDiffs.setCount(entry.getValue().get(0).getCount());
							sdpShoppingDto.setSelectRoomDiffs(selectRoomDiffs);
							calculateAmountDetailRequest.setSelectRoomDiff(selectRoomDiffs);
						}else{
							throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, entry.getValue().get(0).getGoodsId(),
									entry.getValue().get(0).getPrice(),"",diff.getRoomDiffPrice());
						}
					}
				}
			}
			else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.HOTEL){
				List<FitSdpHotelRoomtypeDto> selectedFitSdpHotelRooms = new ArrayList<FitSdpHotelRoomtypeDto>();
				
				for(int i=0;entry.getValue()!=null && i<entry.getValue().size();i++){
					FitAppGoodsInfo appGoodsInfo = entry.getValue().get(i);
					if(sdpShoppingDto.getAllRoomtypes()!=null){
						for(FitSdpHotelRoomtypeDto allRoomTypeDto : sdpShoppingDto.getAllRoomtypes()){
							if(appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(allRoomTypeDto.getGoodsId().toString())){
								if(StringUtils.isNotEmpty(appGoodsInfo.getVisitDate()) && appGoodsInfo.getVisitDate().equals(allRoomTypeDto.getCheckIn())){
									if(appGoodsInfo.getPrice().compareTo(allRoomTypeDto.getPrice())==0){
										FitSdpHotelRoomtypeDto selectHotelRoomtypeDto = new FitSdpHotelRoomtypeDto();
										try {
				                			BeanUtils.copyProperties(selectHotelRoomtypeDto,allRoomTypeDto);
				                		} catch(Exception e) {
				                			throw new RuntimeException(e);
				                		}
										selectHotelRoomtypeDto.setPrice(appGoodsInfo.getPrice());
										selectHotelRoomtypeDto.setRoomCount(appGoodsInfo.getCount());
										selectedFitSdpHotelRooms.add(selectHotelRoomtypeDto);
										break;
									}else{
										 throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
												 appGoodsInfo.getPrice(),allRoomTypeDto.getGoodsId().toString(),allRoomTypeDto.getPrice());
									}
								}
							}
						}
						if(selectedFitSdpHotelRooms.size() != (i+1)){
							throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
						}
					}
				}
				calculateAmountDetailRequest.setSelectedFitSdpHotelRooms(selectedFitSdpHotelRooms);
			}
		}
		Map<String, FitAppTrafficInfoDto> selectTrafficInfoMap = request.getSelectTrafficInfo();
		List<FlightSearchFlightInfoDto> searchFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
		List<FlightSearchFlightInfoDto> selectFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
		for(Map.Entry<String,FitAppTrafficInfoDto> entry : selectTrafficInfoMap.entrySet()){
			if(TrafficTripeType.GO_WAY==TrafficTripeType.valueOf(entry.getKey())){
				searchFlightInfoDtos = sdpShoppingDto.getDepFlightInfos();
			}
			else if(TrafficTripeType.BACK_WAY==TrafficTripeType.valueOf(entry.getKey())){
				searchFlightInfoDtos = sdpShoppingDto.getArvFlightInfos();
			}
			if(searchFlightInfoDtos!=null){
				boolean flightExsitFlag = false;
				for(FlightSearchFlightInfoDto searchFightInfoDto : searchFlightInfoDtos){
					if(entry.getValue().getFlightNo().equals(searchFightInfoDto.getFlightNo())&& entry.getValue().getDepDate().equals(searchFightInfoDto.getDepartureDate())){
						for (FlightSearchSeatDto searchSeatDto : searchFightInfoDto.getSeats()) {
							if(entry.getValue().getSeatCode().equals(searchSeatDto.getSeatClassCode())){
								searchFightInfoDto.getSeats().set(0, searchSeatDto);
								selectFlightInfoDtos.add(searchFightInfoDto);
								flightExsitFlag = true;
								break;
							}
						}
						break;
					}
				}
				if(!flightExsitFlag){
					throw new ExceptionWrapper(FitExceptionCode.APP_FLIGHT_NO_MATCH,entry.getValue().getFlightNo());
				}
			}
		}
		calculateAmountDetailRequest.setFlightRequestMap(request.getRequestMap(selectFlightInfoDtos,request.getBookingSource()));
		try {
			logger.info("calculateAmountDetailRequest="+JSONMapper.getInstance().writeValueAsString(calculateAmountDetailRequest));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return calculateAmountDetailRequest;
	}


}
