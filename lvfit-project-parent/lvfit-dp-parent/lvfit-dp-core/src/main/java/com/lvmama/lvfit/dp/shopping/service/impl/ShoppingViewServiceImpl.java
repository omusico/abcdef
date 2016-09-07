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

	@Autowired
	private FitBusinessClient fitBusinessClient;
	@Autowired
	private FitSearchClient fitSearchClient;
	
	@Autowired
	private FitDpClient fitDpClient;
	
	@Autowired
	private FitDpService fitDpService;
	
	@Autowired
	private FitAggregateClient fitAggregateClient;
	
	
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
		
		if (fitShoppingDto == null) {
			//根据shopping重新load一次数据放缓存
			putShoppingInfo(shoppingUUID);
			fitShoppingDto = shoppingService.getFitShopping(shoppingUUID);
			if(fitShoppingDto == null){
				result.setErrorMessage("购物车没有加载到缓存数据");
				result.setStatus(ResultStatus.FAIL);
				logger.error("购物车没有加载到缓存数据");
				throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
			}			
		}
		result.setStatus(ResultStatus.SUCCESS);
		result.setResult(fitShoppingDto);
		return result;
	}

	@Override
	public BaseSingleResultDto putShoppingInfo(
			String shoppingUUID) {
		 BaseSingleResultDto baseSingleResultDto = new BaseSingleResultDto();
		FitShoppingDto fitShoppingDto = shoppingService.getFitShopping(shoppingUUID);
		if(fitShoppingDto == null){
			logger.error(shoppingUUID+"购物车数据已过期!");
			fitShoppingDto = new FitShoppingDto();
		}
		Boolean result = false;
		ShoppingDbDto shoppingDbDto = fitBusinessClient.loadShoppingDbInfoByUuId(shoppingUUID);
		
		List<ShoppingHotelDto> shoppingHotels = shoppingDbDto.convertShoppingHotelDtos();
		List<ShoppingFlightDto> shoppingFlights = shoppingDbDto.convertShoppingFlightDtos();
		List<ShoppingSpotTicketDto> shoppingSpots = shoppingDbDto.convertShoppingSpotsDtos();
		List<ShoppingInsuranceDto> shoppingInsuranceDtos = shoppingDbDto.convertShoppingInsuranceDtos();
		List<FlightInsuranceDto> shoppingFlightInsuranceDtos = shoppingDbDto.convertShoppingFlightInsuranceDtos();
		//筛选出来的航班
		 List<FlightSearchFlightInfoDto> checkFlights = new ArrayList<FlightSearchFlightInfoDto>();
		 List<HotelSearchHotelDto> checkHotels  = new ArrayList<HotelSearchHotelDto>();
		 
		try{
			//下单用户信息
			if(shoppingDbDto.convertShoppingDetailDto()!=null){
				ShoppingDetailDto detailDto = shoppingDbDto.convertShoppingDetailDto();
				fitShoppingDto.setCustomer(FitOrderCustomerDto.convertCustomerDto(detailDto));
				fitShoppingDto.setOper(FitOrderOperDto.convertOperDto(detailDto));
				fitShoppingDto.setContacter(FitOrderContacterDto.convertContacterDto(detailDto));
			}
			//乘客信息
			if(!CollectionUtils.isEmpty(shoppingDbDto.getShoppingPassengers())){
				fitShoppingDto.setPassenger(FitOrderPassengerDto.convertPassengerDtos(shoppingDbDto.getShoppingPassengers()));
			}
			FitSearchRequest fitSearchRequest = null;	
			//搜索条件
			if(shoppingDbDto.convertShoppingDetailDto()!=null){
				String searchCondition = shoppingDbDto.convertShoppingDetailDto().getSearchCondition();
				 fitSearchRequest = JSONMapper.getInstance().readValue(searchCondition,new TypeReference<FitSearchRequest>() {
				});
				 fitShoppingDto.setSearchRequest(fitSearchRequest);
			}			
			FitSearchRequest fitSearchRequestOther = new FitSearchRequest();//用于重新请求接口
			fitSearchRequestOther = fitSearchRequest;
			List<HotelQueryRequest> searchList = fitSearchRequest.getHotelSearchRequests();
			if(null != fitSearchRequest){
				HotelQueryRequest hotelQueryRequest = new HotelQueryRequest();
				if(!CollectionUtils.isEmpty(searchList) && !CollectionUtils.isEmpty(shoppingHotels)){
					BeanUtils.copyProperties(searchList.get(0), hotelQueryRequest);
					hotelQueryRequest.setKeywords(String.valueOf(shoppingHotels.get(0).getHotelId()));
				}
				
				//搜索酒店
				 HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = fitSearchClient.searchHotel(hotelQueryRequest,fitSearchRequest.getShoppingId());
				 List<HotelSearchResult<HotelSearchHotelDto>> hotelSearchResults = new ArrayList<HotelSearchResult<HotelSearchHotelDto>>();
				
				 //判断酒店是否可以预定
				 if(!CollectionUtils.isEmpty(hotelSearchResult.getResults())){
					 hotelSearchResults.add(hotelSearchResult);
					 List<HotelSearchResult<HotelSearchHotelDto>> listHotelResults =  fitDpService.getDefaultHotelInfo(hotelSearchResults, fitSearchRequest);
					  if(!CollectionUtils.isEmpty(listHotelResults)){
						for(HotelSearchResult<HotelSearchHotelDto> hotelSearch:listHotelResults){
							for(HotelSearchHotelDto hotelSearchHotelDto:hotelSearch.getResults()){
								checkHotels.add(hotelSearchHotelDto);
							}
						}
						//筛选酒店(只有一个酒店了)
						checkHotels = selectCheckRooms(checkHotels,shoppingDbDto.getShoppingHotels(),fitSearchRequest);
						
						//查看航班信息
						FitSearchResult fitSearchResult =	fitDpClient.queryToBackFlights(fitSearchRequestOther);					
						 List<FlightSearchResult<FlightSearchFlightInfoDto>> searchInfoDtos = fitSearchResult.getFlightSearchResult();
						 for(FlightSearchResult<FlightSearchFlightInfoDto> flightSearchResult:searchInfoDtos){
							 List<FlightSearchFlightInfoDto>  flightInfoDtos = flightSearchResult.getResults();		 
							 for(FlightSearchFlightInfoDto flightSearchFlightInfoDto:flightInfoDtos){
								 Boolean flag = false;
								 for(ShoppingFlightDto shoppingFlightDto: shoppingFlights){
									 if(flightSearchFlightInfoDto.getFlightNo().equals(shoppingFlightDto.getFlightNo())){
										 //筛选舱位
										 List<FlightSearchSeatDto> flightSeats = flightSearchFlightInfoDto.getSeats();
										 for(FlightSearchSeatDto flightSearchSeatDto:flightSeats){
											 if(flightSearchSeatDto.getSeatClassCode().equals(shoppingFlightDto.getSeatClassCode())){
												 flightSearchSeatDto.setSelectFlag(true);
												 flag = true;
											 }
										 }									 
									 }
								 }
								 if(flag){//说明找到了之前已选的舱位
									 checkFlights.add(flightSearchFlightInfoDto);
								 }
							 }
						 }
						 
						 fitShoppingDto.setFlightInfos(checkFlights); 
						 fitShoppingDto.setHotels(checkHotels);
						 
					}
				 }
				 //门票信息
				 if(!CollectionUtils.isEmpty(fitSearchRequest.getSpotQueryRequests())){
					 SpotQueryRequest spotQueryRequest = fitSearchRequest.getSpotQueryRequests().get(0);
					 SpotSearchResult<SpotSearchSpotDto> spotResutl=  fitSearchClient.searchSpot(spotQueryRequest);
					 //选中的门票信息
					 List<FitShoppingSelectedTicketDto> selectTicketInfo = new ArrayList<FitShoppingSelectedTicketDto>();
					 if(null != spotResutl ){
						 List<SpotSearchSpotDto> spots = spotResutl.getResults();
						 for(ShoppingSpotTicketDto spotTicket:shoppingSpots){
							 for (SpotSearchSpotDto searchSpot : spots) {
								if(String.valueOf(spotTicket.getSpotId()).equals(searchSpot.getProductId())){
									List<SpotSearchTicketDto> spotTickets = searchSpot.getSpotTickets();
									for(SpotSearchTicketDto ticketDto:spotTickets){
										 if(String.valueOf(spotTicket.getTicketId()).equals(ticketDto.getSuppGoodsId())){
											 FitShoppingSelectedTicketDto selectTicket = new FitShoppingSelectedTicketDto();
											 selectTicket.setProductId(String.valueOf(spotTicket.getSpotId()));
											 selectTicket.setSpotName(spotTicket.getSpotName());
											 selectTicket.setSuppGoodsId(String.valueOf(spotTicket.getTicketId()));
											 selectTicket.setTicketCount(spotTicket.getTicketCount());
											 selectTicket.setTicketName(spotTicket.getTicketName());
											 selectTicket.setTicketPrice(spotTicket.getTicketPrice());
											 selectTicket.setTicketDate(spotTicket.getVisitDate());
											 selectTicket.setTicketSpec(spotTicket.getTicketSpec());
											 selectTicketInfo.add(selectTicket);
										 }
									 }
								}
							}
						 }
						 fitShoppingDto.setSpots(spots);
						 fitShoppingDto.setSelectTicketInfo(selectTicketInfo);
					 }
					 
				 }
				 //保险信息
				 if(null != fitSearchRequest.getInsuranceQueryRequest()){
					 InsuranceQueryRequest insuranceQueryRequest = fitSearchRequest.getInsuranceQueryRequest();
					 InsuranceSearchResult<InsuranceDto> insuranceResult = fitSearchClient.searchInsuranceFromVst(insuranceQueryRequest);
					 //选中的保险信息
					 List<FitShoppingSelectedInsuranceDto> selectInsuranceInfo = new ArrayList<FitShoppingSelectedInsuranceDto>();
					 if(null != insuranceResult){
						 List<InsuranceDto> results = insuranceResult.getResults();
						 this.convertInsurance(shoppingInsuranceDtos, selectInsuranceInfo, results);
						 fitShoppingDto.setInsurances(results);
						 fitShoppingDto.setSelectInsuranceInfo(selectInsuranceInfo);
					 }
				 }
				 //航空意外险信息
				 List<InsuranceInfoDto> searchFlightInsurance = fitAggregateClient.searchFlightInsurance();
				 //选中的保险信息
				 List<FlightInsuranceDto> selectFlightInsuranceInfo = new ArrayList<FlightInsuranceDto>();
				 /*if(null != insuranceResult){
					 List<InsuranceDto> results = insuranceResult.getResults();
					 this.convertInsurance(shoppingInsuranceDtos, selectInsuranceInfo, results);
					 fitShoppingDto.setInsurances(results);
					 fitShoppingDto.setSelectInsuranceInfo(selectInsuranceInfo);
				 }*/
				 if(null != searchFlightInsurance){
					 for (InsuranceInfoDto flightInsurance : searchFlightInsurance) {
						for (FlightInsuranceDto shoppingFlightInsuranceDto : shoppingFlightInsuranceDtos) {
							if(flightInsurance.getId()==shoppingFlightInsuranceDto.getInsuranceId()){
								FlightInsuranceDto selectFlightInsurance = new FlightInsuranceDto();
								selectFlightInsurance.setInsuranceCount(shoppingFlightInsuranceDto.getInsuranceCount());
								selectFlightInsurance.setSuppName(shoppingFlightInsuranceDto.getSuppName());
								selectFlightInsurance.setInsuranceDesc(shoppingFlightInsuranceDto.getInsuranceDesc());
								selectFlightInsurance.setInsuranceId(shoppingFlightInsuranceDto.getInsuranceId());
								selectFlightInsurance.setInsuranceName(shoppingFlightInsuranceDto.getInsuranceName());
								selectFlightInsurance.setPtype(shoppingFlightInsuranceDto.getPtype());
								selectFlightInsuranceInfo.add(selectFlightInsurance);
							}
						}
					}
					 fitShoppingDto.setFlightInsuranceInfos(searchFlightInsurance);
					 fitShoppingDto.setSelectFlightInsInfo(selectFlightInsuranceInfo);
				 }
			}
			
			 //缓存失效不可用重新查询航班跟酒店
			 if(CollectionUtils.isEmpty(checkFlights) || CollectionUtils.isEmpty(checkHotels)){
				 fitSearchRequest.setShoppingId(shoppingUUID);
				 fitDpClient.getFlightAndHotel(fitSearchRequest);
				 BaseSingleResultDto<FitShoppingDto> fitShopping = fitDpClient.getShoppingByUUID(shoppingUUID);
				 FitShoppingDto fitShoppingDTo = fitShopping.getResult();
				 if(fitShoppingDTo!=null){
					 fitShoppingDto.setFlightInfos(fitShoppingDTo.getFlightInfos());
					 fitShoppingDto.setHotels(fitShoppingDTo.getHotels());
					 fitShoppingDto.setSpots(fitShoppingDTo.getSpots());
				 }
			 }			 
			 result =  shoppingService.putShoppingCache(shoppingUUID, fitShoppingDto);
			
		}catch(Exception e){
			baseSingleResultDto.setStatus(ResultStatus.FAIL);
			baseSingleResultDto.setErrorMessage(shoppingUUID+"的购物车信息重新加载出现异常");
			baseSingleResultDto.setErrCode("fail");
			logger.error(shoppingUUID+"的购物车信息重新加载出现异常",e);
		}
		
		if(result){
			baseSingleResultDto.setStatus(ResultStatus.SUCCESS);
			baseSingleResultDto.setErrorMessage(shoppingUUID+"的购物车信息重新load完成");
			baseSingleResultDto.setErrCode("success");
		}
		
		return baseSingleResultDto;
	}

	private List<HotelSearchHotelDto> selectCheckRooms(List<HotelSearchHotelDto> checkHotels,
			List<ShoppingHotelDto> shoppingHotels,FitSearchRequest fitSearchRequest) {
		List<HotelSearchHotelDto> list = new ArrayList<HotelSearchHotelDto>();
		if(!CollectionUtils.isEmpty(checkHotels) && !CollectionUtils.isEmpty(shoppingHotels)){
			
			for(HotelSearchHotelDto hotelSearchHotelDto:checkHotels){
				for(ShoppingHotelDto shoppingHotelDto:shoppingHotels){
					if(!hotelSearchHotelDto.getProductId().equals(shoppingHotelDto.getHotelId().toString())){
						continue;
					}
					List<HotelSearchRoomDto> rooms =	hotelSearchHotelDto.getRooms();
					for(HotelSearchRoomDto hotelSearchRoomDto:rooms){
						if(shoppingHotelDto.getRoomId().equals(hotelSearchRoomDto.getBranchId())){
							hotelSearchRoomDto.setSelectedFlag(true);
						}
						hotelSearchRoomDto.setRoomCounts(shoppingHotelDto.getRoomCount());
						List<HotelSearchPlanDto> plans = hotelSearchRoomDto.getPlans();
						for(HotelSearchPlanDto hotelSearchPlanDto:plans){
							if(!hotelSearchPlanDto.getSuppGoodsId().equals(shoppingHotelDto.getPlanId().toString())){
								continue;
							}
							hotelSearchPlanDto.setSelectedFlag(true);
							list.add(hotelSearchHotelDto);
						}
					}
				}
			}
		}
		//如果重新调用接口取的信息，完全和数据库里存的不一样，说明数据库里的信息已经不符合搜索条件了，则按照初期进入产品选择页的方式，设置默认选中地房间
		//将默认选择第一个酒店的第一个房间的第一个plan
		if(CollectionUtils.isEmpty(list)){
			int roomcounts = 1;
			if(fitSearchRequest != null){
				FitPassengerRequest passengerRequest  = fitSearchRequest.getFitPassengerRequest();
				if(passengerRequest != null){
					roomcounts = HotelUtils.getMinRoomCount(passengerRequest.getAdultCount(), passengerRequest.getChildCount());
				}
			}
			if(!CollectionUtils.isEmpty(checkHotels)){
				HotelSearchHotelDto  hotelDto= checkHotels.get(0);
				for(HotelSearchRoomDto room :hotelDto.getRooms()){
					room.setRoomCounts(roomcounts);
				}
				if(!CollectionUtils.isEmpty(hotelDto.getRooms())){
					hotelDto.getRooms().get(0).setSelectedFlag(true);
				}
				if(!CollectionUtils.isEmpty(hotelDto.getRooms().get(0).getPlans())){
					hotelDto.getRooms().get(0).getPlans().get(0).setSelectedFlag(true);
				}
				list.add(hotelDto);
			}
		}
		return list;
	}
	
	@Override
	public BaseSingleResultDto<FitSearchRequest> getShoppingRequestByShoppingUUID(String shoppingUUID){

		
		FitSearchRequest fitSearchRequest = shoppingService.getFitSearchRequest(shoppingUUID);
		
		BaseSingleResultDto<FitSearchRequest> result = new BaseSingleResultDto<FitSearchRequest>();
		result.setStatus(ResultStatus.SUCCESS);
		result.setResult(fitSearchRequest);
		return result;
	}

	/**
	 * @param shoppingInsuranceDtos
	 * @param selectInsuranceInfo
	 * @param results
	 */
	private void convertInsurance(
			List<ShoppingInsuranceDto> shoppingInsuranceDtos,
			List<FitShoppingSelectedInsuranceDto> selectInsuranceInfo,
			List<InsuranceDto> results) {
		for(ShoppingInsuranceDto insurance:shoppingInsuranceDtos){
			 for (InsuranceDto insuranceDto : results) {
					 List<InsuranceProdProduct> insuranceProductList = insuranceDto.getInsuranceProductList();
						 for (InsuranceProdProduct insuranceProdProduct : insuranceProductList) {
							if(insurance.getInsuranceId().equals(String.valueOf(insuranceProdProduct.getProductId()))){
								List<InsuranceProdProductBranch> insuranceProductBranchList = insuranceProdProduct.getInsuranceProductBranchList();
								if(!CollectionUtils.isEmpty(insuranceProductBranchList)){
									for (InsuranceProdProductBranch insuranceProdProductBranch : insuranceProductBranchList) {
										if(insurance.getInsuranceBranchId().equals(String.valueOf(insuranceProdProductBranch.getBranchId()))){
											List<InsuranceSuppGoods> insuranceSuppGoodList = insuranceProdProductBranch.getInsuranceSuppGoodList();
											if(!CollectionUtils.isEmpty(insuranceSuppGoodList)){
												for (InsuranceSuppGoods insuranceSuppGoods : insuranceSuppGoodList) {
													if(insurance.getInsuranceSuppGoodsId().equals(String.valueOf(insuranceSuppGoods.getSuppGoodsId()))){
														FitShoppingSelectedInsuranceDto selelctInsurance = new FitShoppingSelectedInsuranceDto();
														selelctInsurance.setProductId(insurance.getInsuranceId());
														selelctInsurance.setProductName(insurance.getInsuranceName());
														selelctInsurance.setProductType(insurance.getInsuranceType());
														selelctInsurance.setBranchId(insurance.getInsuranceBranchId());
														selelctInsurance.setBranchName(insurance.getInsuranceBranchName());
														selelctInsurance.setSuppGoodsId(insurance.getInsuranceSuppGoodsId());
														selelctInsurance.setSuppGoodsName(insurance.getInsuranceSuppGoodsName());
														selelctInsurance.setInsuranceCount(insurance.getInsuranceCount());
														selelctInsurance.setInsurancePrice(insurance.getInsurancePrice());
														selelctInsurance.setUseDays(insurance.getUseDays());
														selelctInsurance.setVisitDate(insurance.getVisitDate());
														selelctInsurance.setInsuranceDetail(insurance.getInsuranceDetail());
														selectInsuranceInfo.add(selelctInsurance);
													}
												}
											}
										}
									}
								}
							}
						}
			}
		 }
	}
}
