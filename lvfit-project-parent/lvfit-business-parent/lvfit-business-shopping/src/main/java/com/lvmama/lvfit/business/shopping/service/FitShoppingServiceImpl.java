package com.lvmama.lvfit.business.shopping.service;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingFlightInsuranceRepository;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingFlightRepository;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingHotelRepository;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingInsuranceRepository;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingPassengerRepository;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingRepository;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingSpotRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOperDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.request.FitShoppingListRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
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
import com.lvmama.lvfit.common.dto.shopping.ShoppingPassengerDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingSpotTicketDto;

@Service
public class FitShoppingServiceImpl implements FitShoppingService{

	
	private Logger logger = LoggerFactory.getLogger(FitShoppingServiceImpl.class);
	@Autowired
	private ShoppingFlightRepository shoppingFlightRepository;
	@Autowired
	private ShoppingHotelRepository shoppingHotelRepository;
	@Autowired
	private ShoppingSpotRepository shoppingSpotRepository;
	@Autowired
	private ShoppingPassengerRepository shoppingPassengerRepository;
	@Autowired	
	private ShoppingRepository  shoppingRepository;
	@Autowired	
	private ShoppingInsuranceRepository  shoppingInsuranceRepository;
	@Autowired
	private ShoppingFlightInsuranceRepository shoppingFlightInsuranceRepository;
	/**
	 * 
	 * saveShopping:添加或更新购物车. <br/>
	 *
	 * @author zengzhimin
	 * @param dto
	 * @since JDK 1.6
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public BaseSingleResultDto saveOrUpdateShopping(FitShoppingDto dto) {
		BaseSingleResultDto resultDto = new BaseSingleResultDto();
		try{
			//购物车基本信息
			this.saveShoppingInfo(dto);
			//乘客信息
			this.savePassengerInfo(dto);
		    //航班
		    this.saveShoppingFlightInfo(dto);
		    //酒店
		   this.saveShoppingHotelInfo(dto);		 
		    //门票
		   this.saveShoppingTicketInfo(dto);
		    //保险
		   this.saveShoppingInsuranceInfo(dto);
		   //航空意外险
		   this.saveShoppingFlightInsuranceInfo(dto);
		   
		   resultDto.setStatus(ResultStatus.SUCCESS);
		   resultDto.setErrCode("success");
		   resultDto.setMessage(dto.getShoppingUuid()+"购物车信息落地成功");
		   logger.info(dto.getShoppingUuid()+"购物车信息落地成功");
		    
		}catch(Exception e){
		  e.printStackTrace();
		  logger.error("预定shopping信息 保存数据异常"+e.getMessage());
		  resultDto.setStatus(ResultStatus.FAIL);
		  resultDto.setErrCode("errer");
	      resultDto.setMessage(dto.getShoppingUuid()+"购物车信息落地有异常");
		}
		return resultDto;
	}

	private void saveShoppingFlightInsuranceInfo(FitShoppingDto dto) {
	   Long versionNo = System.currentTimeMillis();
	   if(CollectionUtils.isNotEmpty(dto.getSelectFlightInsInfo())){
		    for (FlightInsuranceDto selectedInsuranceDto : dto.getSelectFlightInsInfo()) {
		    	selectedInsuranceDto.setVersionNo(versionNo);
		    	selectedInsuranceDto.setShoppingUuid(dto.getShoppingUuid());
		    	shoppingFlightInsuranceRepository.save(selectedInsuranceDto);
			}
	   }
	}

	private void saveShoppingInsuranceInfo(FitShoppingDto dto) {
		List<ShoppingInsuranceDto> insuranceDtosToDb = new ArrayList<ShoppingInsuranceDto>();
		   Long versionNo = System.currentTimeMillis();
		   List<FitShoppingSelectedInsuranceDto> selectInsuranceInfo = dto.getSelectInsuranceInfo();
		   if(CollectionUtils.isNotEmpty(selectInsuranceInfo)){
			    for (FitShoppingSelectedInsuranceDto selectedInsuranceDto : selectInsuranceInfo) {
			    	ShoppingInsuranceDto shoppingInsuranceDto = new ShoppingInsuranceDto();
			    	shoppingInsuranceDto.setVersionNo(versionNo);
			    	shoppingInsuranceDto.setShoppingUuid(dto.getShoppingUuid());
			    	shoppingInsuranceDto.setInsuranceId(selectedInsuranceDto.getProductId());
			    	shoppingInsuranceDto.setInsuranceName(selectedInsuranceDto.getProductName());
			    	shoppingInsuranceDto.setInsuranceType(selectedInsuranceDto.getProductType());
			    	shoppingInsuranceDto.setInsuranceBranchId(selectedInsuranceDto.getBranchId());
			    	shoppingInsuranceDto.setInsuranceBranchName(selectedInsuranceDto.getBranchName());
			    	shoppingInsuranceDto.setInsuranceSuppGoodsId(selectedInsuranceDto.getSuppGoodsId());
			    	shoppingInsuranceDto.setInsuranceSuppGoodsName(selectedInsuranceDto.getSuppGoodsName());
			    	shoppingInsuranceDto.setInsuranceCount(selectedInsuranceDto.getInsuranceCount());
			    	shoppingInsuranceDto.setInsurancePrice(selectedInsuranceDto.getInsurancePrice());
			    	shoppingInsuranceDto.setUseDays(selectedInsuranceDto.getUseDays());
			    	shoppingInsuranceDto.setVisitDate(selectedInsuranceDto.getVisitDate());
			    	shoppingInsuranceDto.setInsuranceDetail(selectedInsuranceDto.getInsuranceDetail());
		    		insuranceDtosToDb.add(shoppingInsuranceDto);
				}
			    for(ShoppingInsuranceDto insuranceToDb:insuranceDtosToDb){
			    	shoppingInsuranceRepository.save(insuranceToDb);
			    }
		   }
	}

	private void saveShoppingTicketInfo(FitShoppingDto dto) {
		List<ShoppingSpotTicketDto> spotTicketDtosToDb = new ArrayList<ShoppingSpotTicketDto>();
		   Long versionNo = System.currentTimeMillis();
		   List<FitShoppingSelectedTicketDto> selectTicketInfos = dto.getSelectTicketInfo();
		   if(CollectionUtils.isNotEmpty(selectTicketInfos)){
			    for (FitShoppingSelectedTicketDto selectedTicketDto : selectTicketInfos) {
			    	ShoppingSpotTicketDto shoppingSpotDto = new ShoppingSpotTicketDto();
					shoppingSpotDto.setVersionNo(versionNo);
		    		shoppingSpotDto.setShoppingUuid(dto.getShoppingUuid());
		    		shoppingSpotDto.setSpotId(selectedTicketDto.getProductId());
		    		shoppingSpotDto.setSpotName(selectedTicketDto.getSpotName());
		    		shoppingSpotDto.setTicketCount(selectedTicketDto.getTicketCount());//数量
		    		shoppingSpotDto.setTicketId(selectedTicketDto.getSuppGoodsId());
		    		shoppingSpotDto.setTicketName(selectedTicketDto.getTicketName());
		    		shoppingSpotDto.setTicketSpec(selectedTicketDto.getTicketSpec());//门票种类
		    		shoppingSpotDto.setVisitDate(selectedTicketDto.getTicketDate());//游玩日期
		    		shoppingSpotDto.setTicketPrice(selectedTicketDto.getTicketPrice());
		    		spotTicketDtosToDb.add(shoppingSpotDto);
				}
		   }
		    
		    for(ShoppingSpotTicketDto spotTicketToDb:spotTicketDtosToDb){
		    	shoppingSpotRepository.save(spotTicketToDb);
		    }
	}

	private void saveShoppingFlightInfo(FitShoppingDto dto) {
		
		Long versionNo = System.currentTimeMillis();
		List<FlightSearchFlightInfoDto> flights =dto.getFlightInfos();
		List<ShoppingFlightDto> flightList = new ArrayList<ShoppingFlightDto>();
		if(CollectionUtils.isNotEmpty(flights)){
			for(FlightSearchFlightInfoDto flight:flights){
		    	ShoppingFlightDto flightDto = new ShoppingFlightDto();
		    	flightDto.setVersionNo(versionNo);
		    	flightDto.setArrivalAirportCode(flight.getArrivalAirportCode());
		    	flightDto.setArrivalCityName(flight.getArrivalCityName());
		    	flightDto.setArrivalTime(flight.getArrivalTime());
		    	flightDto.setDepartureAirportCode(flight.getDepartureAirportCode());
		    	flightDto.setDepartureCityName(flight.getDepartureCityName());
		    	flightDto.setDepartureDate(flight.getDepartureDate());
		    	flightDto.setDepartureTime(flight.getDepartureTime());
		    	flightDto.setFlightNo(flight.getFlightNo());
		    	if(flight.getFlyTimeMins()!=null){
		    		flightDto.setFlyTimeMins(flight.getFlyTimeMins().toString());
		    	}
		    	//flightDto.setBackOrto(flight.getBackOrto());
		    	List<FlightSearchSeatDto> seatlist = flight.getSeats();
		    	FlightSearchSeatDto seatDto =null;
		    	if(!CollectionUtils.isEmpty(seatlist)){
		    		//获取选择的航班
			    	for(FlightSearchSeatDto flightdto:seatlist){
			    		if(flightdto.getSelectFlag()){
			    			seatDto = flightdto;
			    			//目前一个航班只能选择一种舱位
			    			break;
			    		}
			    	}
			    	if(seatDto!=null){
			    		flightDto.setSeatClassCode(seatDto.getSeatClassCode());
				    	flightDto.setSeatClassName(seatDto.getSeatClassName());
			    	}
		    	}
		    	
		    	flightDto.setShoppingUuid(dto.getShoppingUuid());
		    	flightList.add(flightDto);
		   }
			for(ShoppingFlightDto shoppingFlightDto:flightList){
				 shoppingFlightRepository.save(shoppingFlightDto);
			}
		}
	}

	private void saveShoppingHotelInfo(FitShoppingDto dto) {

		Long versionNo = System.currentTimeMillis();
		    List<HotelSearchHotelDto> hotels =  dto.getHotels().getResults();
		    List<ShoppingHotelDto> hotelList = new ArrayList<ShoppingHotelDto>();
		    ShoppingHotelDto shoppingHotelDto = new ShoppingHotelDto();
		    shoppingHotelDto.setVersionNo(versionNo);
		    if(CollectionUtils.isNotEmpty(hotels)){
		    	for(HotelSearchHotelDto hotelDto:hotels) {
		    		FitBaseSearchRequest searchRequest = dto.getSearchRequest();

					shoppingHotelDto.setCheckinTime(searchRequest.getDepartureTime());
					shoppingHotelDto.setCheckoutTime(searchRequest.getReturnTime());

			    	if(hotelDto.getProductId()!=null){
				    	shoppingHotelDto.setHotelId(Long.valueOf(hotelDto.getProductId()));
			    	}
			    	shoppingHotelDto.setHotelName(hotelDto.getProductName());
			    	List<HotelSearchRoomDto> rooms = hotelDto.getRooms();
			    	if(!CollectionUtils.isEmpty(rooms)){
			    		for(HotelSearchRoomDto roomDto:rooms){
			    			if(roomDto.getSelectedFlag()){
			    				shoppingHotelDto.setRoomId(roomDto.getBranchId());
			    				shoppingHotelDto.setRoomName(roomDto.getBranchName());
			    				shoppingHotelDto.setRoomCount(roomDto.getRoomCounts());
			    				List<HotelSearchPlanDto> planDto = roomDto.getPlans();
			    				if(!CollectionUtils.isEmpty(planDto)){
			    					for(HotelSearchPlanDto plan:planDto){
				    					if(plan.getSelectedFlag()){			    						
				    						shoppingHotelDto.setPlanId(Long.valueOf(plan.getSuppGoodsId()));			    						
				    						shoppingHotelDto.setPlanName(plan.getGoodsName());
				    						//目前酒店只能选择一个商品 
				    						break;
				    					}
				    				}
			    				}			    				
			    			}
			    		}
			    	}		    			    	
			    	shoppingHotelDto.setShoppingUuid(dto.getShoppingUuid());
			    	hotelList.add(shoppingHotelDto);
			    }
		    	for(ShoppingHotelDto shoppingHotel:hotelList){
		    		 shoppingHotelRepository.save(shoppingHotel);
		    	}
		    	
		    }
	}

	private void saveShoppingInfo(FitShoppingDto dto) throws Exception {
		
		//操作人
		FitOrderOperDto operDto = dto.getOper();
		//搜索条件
		FitBaseSearchRequest fitSearchRequest =  dto.getSearchRequest();
		//联系人
		FitOrderContacterDto contacterDto = dto.getContacter();
		//下单用户信息
		FitOrderCustomerDto  customerDto = dto.getCustomer();
		//下单详情
		ShoppingDetailDto shoppingDetailDto = new ShoppingDetailDto();	
		shoppingDetailDto.setShoppingUuid(dto.getShoppingUuid());
		if(contacterDto!=null){
			shoppingDetailDto.setContacterEmail(contacterDto.getEmail());
		    shoppingDetailDto.setContacterMobile(contacterDto.getMobile());
		    shoppingDetailDto.setContacterName(contacterDto.getName());
		}
		if(customerDto!=null){
			shoppingDetailDto.setCustomeNo(customerDto.getCustomerCode());
		    shoppingDetailDto.setCustomerId(customerDto.getCustomerId());
		    shoppingDetailDto.setCustomerName(customerDto.getCustomerName());
		}
		if(operDto!=null){
			shoppingDetailDto.setOperId(operDto.getOperId());
		    shoppingDetailDto.setOperName(operDto.getOperName());
		    shoppingDetailDto.setOperIp(operDto.getOperIp());
		}	
		if(fitSearchRequest!=null){
			shoppingDetailDto.setSearchCondition(JSONMapper.getInstance().writeValueAsString(fitSearchRequest));
		}
		shoppingRepository.save(shoppingDetailDto);
	}

	private void savePassengerInfo(FitShoppingDto dto) {

		Long versionNo = System.currentTimeMillis();
		List<FitOrderPassengerDto> passengers = dto.getPassenger();
		List<ShoppingPassengerDto> passengerList = new ArrayList<ShoppingPassengerDto>();
		if(CollectionUtils.isNotEmpty(passengers)){
			 for(FitOrderPassengerDto passengerDto :passengers){
		    	 ShoppingPassengerDto shoppingPassengerDto = new ShoppingPassengerDto();
		    	 shoppingPassengerDto.setVersionNo(versionNo);
		    	 shoppingPassengerDto.setShoppingUuid(dto.getShoppingUuid());
		    	 shoppingPassengerDto.setIdCardType(passengerDto.getPassengerIDCardType().toString());
		    	 shoppingPassengerDto.setIdCardNo(passengerDto.getPassengerIDCardNo());
		    	 shoppingPassengerDto.setPassengerName(passengerDto.getPassengerName());
		    	 shoppingPassengerDto.setTelephone(passengerDto.getMobile());
		    	 shoppingPassengerDto.setPassengerType(passengerDto.getPassengerType().toString());
		    	 shoppingPassengerDto.setPassengerBirthday(passengerDto.getPassengerBirthday());
		    	 passengerList.add(shoppingPassengerDto);
		    }
			shoppingPassengerRepository.deletesUpdate(passengerList);
		}
	}

	public ShoppingDbDto loadShoppingDbInfoByUuId(String shoppingUuId){
		
		ShoppingDbDto dto = new  ShoppingDbDto();
		try{
			List<ShoppingFlightDto> flightList = shoppingFlightRepository.getListByCode(shoppingUuId);
			List<ShoppingHotelDto> hotelList = shoppingHotelRepository.getListByCode(shoppingUuId);
			List<ShoppingPassengerDto> passengerList = shoppingPassengerRepository.getListByCode(shoppingUuId);
			List<ShoppingDetailDto> shoppingDto = shoppingRepository.getListByCode(shoppingUuId);
			List<ShoppingSpotTicketDto> spotTickeList = shoppingSpotRepository.getLatestListByCode(shoppingUuId);
			List<ShoppingInsuranceDto> insuranceList = shoppingInsuranceRepository.getLatestListByCode(shoppingUuId);
			List<FlightInsuranceDto> flightInsuranceList = shoppingFlightInsuranceRepository.getLatestListByCode(shoppingUuId);
			if(CollectionUtils.isNotEmpty(flightList)){
				dto.setShoppingFlight(flightList);
			}else{
				flightList = shoppingFlightRepository.getAllByShoppinguuid(shoppingUuId);
				dto.setShoppingFlight(flightList);
			}
			if(CollectionUtils.isNotEmpty(hotelList)){
				dto.setShoppingHotels(hotelList);
			}else{
				hotelList = shoppingHotelRepository.getAllByShoppinguuid(shoppingUuId);
				dto.setShoppingHotels(hotelList);
			}
			if(CollectionUtils.isNotEmpty(passengerList)){
				dto.setShoppingPassengers(passengerList);
			}else{
				passengerList = shoppingPassengerRepository.getAllByShoppinguuid(shoppingUuId);
				dto.setShoppingPassengers(passengerList);
			}
			if(CollectionUtils.isNotEmpty(spotTickeList)){
				dto.setShoppingSpots(spotTickeList);
			}
			if(CollectionUtils.isNotEmpty(insuranceList)){
				dto.setShoppingInsurances(insuranceList);
			}
			if(CollectionUtils.isNotEmpty(flightInsuranceList)){
				dto.setShoppingFlightInsurances(flightInsuranceList);
			}
			if(shoppingDto!= null){
				dto.setShoppingDetails(shoppingDto);
			}
		}catch(Exception e){
			logger.error("从数据库加载shoppingDbDto数据异常"+e.getMessage());
		}	
		return dto;
	}

	@Override
	public List<ShoppingDetailDto> queryShoppingList(
			BaseQueryDto<FitShoppingListRequest> baseQueryDto) {
		return shoppingRepository.query(baseQueryDto);
	}

	@Override
	public int countShoppingListRecords(
			BaseQueryDto<FitShoppingListRequest> baseQueryDto) {
		return shoppingRepository.count(baseQueryDto);
	}
	
    @Override
    public ShoppingDetailDto getShoppingInfoByUuid(String shoppingUuId){
        try{
            List<ShoppingDetailDto> shoppingDto = shoppingRepository.getListByCode(shoppingUuId);
            if (!CollectionUtils.isEmpty(shoppingDto)) {
                return shoppingDto.get(0);
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.error("从数据库加载shoppingDbDto数据异常"+e.getMessage());
        }   
        return null;
    }
    
    @Override
    public int updShoppingInfo(ShoppingDetailDto dtlDto) {
        return shoppingRepository.update(dtlDto);
    }
}
