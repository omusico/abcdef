package com.lvmama.lvfit.openapi.app.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.dto.app.*;
import com.lvmama.lvfit.common.dto.enums.TrafficTripeType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvfit.common.client.FitSdpClient;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpRoomDiff;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpUpdateShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;

@Service
public class FitAppSdpBookingServiceImpl implements FitAppSdpBookingService {
	
	private static final Logger logger = LoggerFactory.getLogger(FitAppDpBookingService.class);

	@Autowired
	private FitSdpClient fitSdpClient;

	@Autowired
	private FitBusinessClient fitBusinessClient;

	@Override
	public FitAppOrderDto booking(FitAppBookingRequest appBookingRequest) {

		FitOrderBookingRequest fitOrderBookingRequest = this.createByAppBookingRequest(appBookingRequest);
		BaseSingleResultDto<FitOrderMainDto> resultDto = fitSdpClient.booking(fitOrderBookingRequest);
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
		fitOrderBookingRequest.setProductId(Long.valueOf(appShoppingRequest.getProductId()));
		fitOrderBookingRequest.setCategoryId(appShoppingRequest.getCategoryId());
		fitOrderBookingRequest.setLineRouteId(appShoppingRequest.getLineRouteId());
		fitOrderBookingRequest.setBookingSource(appShoppingRequest.getBookingSource());
		fitOrderBookingRequest.setAdultQuantity(appShoppingRequest.getAdultCount());
		fitOrderBookingRequest.setChildQuantity(fitOrderBookingRequest.getChildQuantity());
		fitOrderBookingRequest.setProductName(appShoppingRequest.getProductName());
		
		fitOrderBookingRequest.setFitOrderCustomerDto(appBookingRequest.getFitOrderCustomerDto());
		fitOrderBookingRequest.setFitOrderContacterDto(appBookingRequest.getFitOrderContacterDto());
		fitOrderBookingRequest.setFitOrderPassengerDtos(appBookingRequest.getFitOrderPassengerDtos());
		fitOrderBookingRequest.setFitOrderExpressDto(appBookingRequest.getFitOrderExpressDto());
		FitOrderAmountDto fitOrderAmountDto = new FitOrderAmountDto();
		fitOrderAmountDto.setTotalSalesAmount(appBookingRequest.getTotalPrice());
		fitOrderBookingRequest.setFitOrderAmountDto(fitOrderAmountDto);
		FitSdpShoppingDto	sdpShoppingDto =fitSdpClient.getShoppingByUUID(appBookingRequest.getAppShoppingRequest().getShoppingUuid());
		if (null == sdpShoppingDto) {
			 throw new ExceptionWrapper(FitExceptionCode.GET_NO_CACHE_SHOPPING);
        }
		Map<String, List<FitAppGoodsInfo>> map = appBookingRequest.getAppShoppingRequest().getSelectGoodsInfo();
		sdpShoppingDto.setSelectInsurances(null);//默认不选择保险，app端
        for(Map.Entry<String,List<FitAppGoodsInfo>> entry : map.entrySet()){
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
						
						selectedHotelComboGoods.setQuantity(Long.valueOf(appGoodsInfo.getCount()));
						selectedHotelComboGoods.setStartDayStr(appGoodsInfo.getVisitDate());
						sdpShoppingDto.setSelectedHotelComboGoods(selectedHotelComboGoods);
					}else{
						throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH,entry.getValue().get(0).getGoodsId(),entry.getValue().get(0).getPrice(),
	             	    selectedHotelComboGoods.getSuppGoodsId(),selectedHotelComboGoods.getPrice());
					}
				}else{
					throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
				}
			}
			else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.OTHER_TICKETS){
				List<FitSdpSelectOtherTicketDto> selectOtherTickets  = new ArrayList<FitSdpSelectOtherTicketDto>();

				for(int i=0;null!=entry.getValue() && i<entry.getValue().size();i++){
					FitAppGoodsInfo appGoodsInfo = entry.getValue().get(i);
					
					for(FitSdpOtherTicketDto sdpOtherTicketDto : sdpShoppingDto.getOtherTickets()){
						if(appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(sdpOtherTicketDto.getSuppGoodsId().toString())){
							if(appGoodsInfo.getPrice().compareTo(sdpOtherTicketDto.getDefaultSelectPrice())==0){
								FitSdpSelectOtherTicketDto selectOtherTicketDto = new FitSdpSelectOtherTicketDto();
								try {
									BeanUtils.copyProperties(selectOtherTicketDto,sdpOtherTicketDto);
								}catch (Exception e) {
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
				sdpShoppingDto.setSelectOtherTickets(selectOtherTickets);
			}
			else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.INLAND_INSURANCE){
				List<FitSdpSelectInsuranceDto> selectInsuranceDtos = new ArrayList<FitSdpSelectInsuranceDto>();
				for(int i=0;i<entry.getValue().size();i++){
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
								 selectInsurance.setPrice(appGoodsInfo.getPrice());
								 selectInsurance.setSelectCount(Long.valueOf(appGoodsInfo.getCount()));

								 selectInsuranceDtos.add(selectInsurance);
								 break;
							 }else{
								 throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
										 appGoodsInfo.getPrice(),sdpIndurance.getSuppGoodsId(),sdpIndurance.getPrice());
							 }
						 }
					}
					if(selectInsuranceDtos.size() != i+1){
						throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
					}
				}
				sdpShoppingDto.setSelectInsurances(selectInsuranceDtos);
			}
			else if(FitAppGoodsType.valueOf(entry.getKey())==FitAppGoodsType.LOCAL_TRIP){
				FitSdpLocalTripProductDto localTripDto = sdpShoppingDto.getSelectLocalTripPrduct();
				FitSdpLocalTripProductDto selectLocalTripDto = new FitSdpLocalTripProductDto();
				FitAppGoodsInfo appGoodsInfo = entry.getValue().get(0);
				if(localTripDto!=null && appGoodsInfo.getGoodsId()!=null && appGoodsInfo.getGoodsId().equals(localTripDto.getSuppGoodsId().toString())){
					if( localTripDto.getPrice().compareTo(appGoodsInfo.getPrice())==0){
						try {
							BeanUtils.copyProperties(selectLocalTripDto,localTripDto);
						}  catch (Exception e) {
							logger.error(e.getMessage());
						}
						sdpShoppingDto.setSelectLocalTripPrduct(selectLocalTripDto);
					}else{
						throw new ExceptionWrapper(FitExceptionCode.SDP_AMOUNT_NOT_MATCH, appGoodsInfo.getGoodsId(),
	            				appGoodsInfo.getPrice(),selectLocalTripDto.getSuppGoodsId(),selectLocalTripDto.getPrice());
					}
				}else{
					throw new ExceptionWrapper(FitExceptionCode.APP_GOODS_NO_MATCH,appGoodsInfo.getGoodsId());
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
				sdpShoppingDto.setSelectedRoomtypes(selectedFitSdpHotelRooms);
			}
			
        }

		//组装机票数据
		Map<String, FitAppTrafficInfoDto> selectTrafficInfoMap = appBookingRequest.getAppShoppingRequest().getSelectTrafficInfo();
		List<FlightSearchFlightInfoDto> searchFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
		List<FlightSearchFlightInfoDto> selectFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
		String depCityCode = null;
		String arrCityCode = null;
		for(Map.Entry<String,FitAppTrafficInfoDto> entry : selectTrafficInfoMap.entrySet()){
			if(TrafficTripeType.GO_WAY==TrafficTripeType.valueOf(entry.getKey())){
				searchFlightInfoDtos = sdpShoppingDto.getDepFlightInfos();
				depCityCode = searchFlightInfoDtos.get(0).getDepartureCityCode();
				arrCityCode = searchFlightInfoDtos.get(0).getArrivalCityCode();
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
								if(TrafficTripeType.GO_WAY==TrafficTripeType.valueOf(entry.getKey())){
									searchFightInfoDto.setBackOrTo(FlightTripType.DEPARTURE.name());
								}else{
									searchFightInfoDto.setBackOrTo(FlightTripType.RETURN.name());
								}
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

		sdpShoppingDto.setSelectedFlightInfos(selectFlightInfoDtos);
		FitSdpShoppingRequest fitSdpShoppingRequest = new FitSdpShoppingRequest();
		FitPassengerRequest fitPassengerRequest = new FitPassengerRequest();
		Integer adultCount = appBookingRequest.getAppShoppingRequest().getAdultCount();
		Integer childCount = appBookingRequest.getAppShoppingRequest().getChildCount();
		fitPassengerRequest.setAdultCount(adultCount);
		fitPassengerRequest.setChildCount(childCount);
		fitSdpShoppingRequest.setFitPassengerRequest(fitPassengerRequest);
		fitSdpShoppingRequest.setQuantity(Long.valueOf(appBookingRequest.getAppShoppingRequest().getQuantity()));

		fitSdpShoppingRequest.setProductId(appBookingRequest.getAppShoppingRequest().getProductId());
		fitSdpShoppingRequest.setCategoryId(appBookingRequest.getAppShoppingRequest().getCategoryId().toString());
		fitSdpShoppingRequest.setLineRouteId(appBookingRequest.getAppShoppingRequest().getLineRouteId().toString());
		fitSdpShoppingRequest.setProductName(appBookingRequest.getAppShoppingRequest().getProductName());
        fitSdpShoppingRequest.setDistributionChannel(appBookingRequest.getAppShoppingRequest().getDistributionChannel());
		fitSdpShoppingRequest.setDistributorCode(appBookingRequest.getAppShoppingRequest().getDistributorCode());
		fitSdpShoppingRequest.setVisitDate(appBookingRequest.getVisitTime());
		fitSdpShoppingRequest.setDepCityCode(depCityCode);
		fitSdpShoppingRequest.setArrCityCode(arrCityCode);
		fitSdpShoppingRequest.setBookingSource(appBookingRequest.getAppShoppingRequest().getBookingSource());

		BaseSingleResultDto<FitSdpProductBasicInfoDto> resultDto = fitBusinessClient.getSdpProductBasicInfoByProductId(Long.valueOf(fitSdpShoppingRequest.getProductId()));
        if(resultDto.getResult()!=null){
			fitSdpShoppingRequest.setRouteNum(resultDto.getResult().getRouteNum());
			fitSdpShoppingRequest.setStayNum(resultDto.getResult().getStayNum());
		}
		sdpShoppingDto.setFitSdpShoppingRequest(fitSdpShoppingRequest);
		
        FitSdpUpdateShoppingRequest req = new FitSdpUpdateShoppingRequest();
        req.setShoppingUuid(appBookingRequest.getAppShoppingRequest().getShoppingUuid());
        req.setShoppingDto(sdpShoppingDto);
        //保存shoppingDto到缓存
        fitSdpClient.saveShoppingToCache(req);

		return  fitOrderBookingRequest;
	}
	
	
	
}
