package com.lvmama.lvfit.dp.shopping.service.impl;

import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.MemcachedUtil;
import com.lvmama.lvfit.common.cache.CacheBox;
import com.lvmama.lvfit.common.cache.CacheBoxConvert;
import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.request.ChangeHotelRequest;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;
import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
public class ShoppingServiceImpl implements ShoppingService {

	private static Logger logger = LoggerFactory.getLogger(ShoppingServiceImpl.class);	
	
	/**
	 * 购物车缓存时间
	 */
	@Value("lvfit.shopping.cacheTime")
	private String cacheExpireTime;
	
	private Long getCacheExpireTime(){
		return Long.valueOf((String)CustomizedPropertyPlaceholderConfigurer.getContextProperty(cacheExpireTime));
	}
	
	@Override
	public FitSearchRequest getFitSearchRequest(String shoppingUUID) {
		
		CacheBox box = MemcachedUtil.getInstance().get(shoppingUUID);
		if(null==box){
			return null;
		}
		FitShoppingDto shoppingDto =  CacheBoxConvert.ShoppingDtoResult.convertTo(box.getJson());
		return shoppingDto.getSearchRequest();
	}
	
	@Override
	public FitShoppingDto getFitShopping(String shoppingUUID) {
		
		CacheBox box = MemcachedUtil.getInstance().get(shoppingUUID);
		
		if(null==box){
			return null;
		}
		if(System.currentTimeMillis()>box.getExpireTime()){
			//尝试重新查询并给出新的结果集,暂不实现,因为shopping查询的异步功能尚未做好;
			//return new FitShoppingDto();
			return null;
		}

		return CacheBoxConvert.ShoppingDtoResult.convertTo(box.getJson());
	}

	@Override
	public boolean putShoppingCache(String shoppingUUID, FitShoppingDto dto) {

		CacheBox box = new CacheBox();
		box.setKey(shoppingUUID);
		box.setJson(CacheBoxConvert.ShoppingDtoResult.convertFrom(dto));
		box.setExpireTime(System.currentTimeMillis()+getCacheExpireTime());
		
		return put2Cache(shoppingUUID, box);
		
	}

	private boolean put2Cache(String shoppingUUID, CacheBox box){
		
		if(null==box
				||!box.valid()){
			return false;
		}
		try{
			logger.error("key:"+box.getKey());
			logger.error("size:"+box.getJson().length());
		}catch(Exception ex){
		}
		
		if(null!=MemcachedUtil.getInstance().get(shoppingUUID)){
			return MemcachedUtil.getInstance().replace(shoppingUUID,MemcachedUtil.ONE_HOUR,box);
		}else{
			return MemcachedUtil.getInstance().set(shoppingUUID,MemcachedUtil.ONE_HOUR,box);
		}
	}
	
	private FlightSearchFlightInfoDto getSelected(ChangeFlightRequest request,List<FlightSearchFlightInfoDto> infos) {
		
		FlightSearchFlightInfoDto selectedFlightInfoDto = null;
		
		if(CollectionUtils.isEmpty(infos)){
			return null;
		}
		
		for (FlightSearchFlightInfoDto flightInfoDto : infos){
			List<FlightSearchSeatDto> seats = flightInfoDto.getSeats();
			if(CollectionUtils.isEmpty(seats)){
				continue;
			}
			for (FlightSearchSeatDto seat : seats) {
				if (flightInfoDto.getFlightNo().equals(request.getFlightNo())
						&&seat.getSeatClassCode().equals(request.getSeatCode())) {
					seat.setSelectFlag(true);
				}else{
					seat.setSelectFlag(false);
				}
			}
			
			if (flightInfoDto.getFlightNo().equals(request.getFlightNo())){
				selectedFlightInfoDto = flightInfoDto;
			}
		}
		
		return selectedFlightInfoDto;
	}	
	
	private HotelSearchHotelDto getSelected(ChangeHotelRequest request,List<HotelSearchHotelDto> listDto) {
		
		if(CollectionUtils.isEmpty(listDto)){
			return null;
		}
		
		HotelSearchHotelDto selectedHotelDto = null;
		
		for (HotelSearchHotelDto hotelDto : listDto) {
				
			List<HotelSearchRoomDto> rooms = hotelDto.getRooms();
			
			if(CollectionUtils.isEmpty(rooms)){
				continue;
			}

			for (HotelSearchRoomDto roomDto : rooms) {
				
				if (request.getHotelId().equals(hotelDto.getProductId())&&
						request.getRoomId().equals(roomDto.getBranchId())) {
					roomDto.setSelectedFlag(true);
				}else{
					roomDto.setSelectedFlag(false);
				}
				
				roomDto.setRoomCounts(request.getRoomCount());
				
				List<HotelSearchPlanDto> plans = roomDto.getPlans();
				
				if(CollectionUtils.isEmpty(plans)){
					continue;
				}
				
				for (HotelSearchPlanDto plan : plans) {
					if(request.getHotelId().equals(hotelDto.getProductId())
							&&request.getRoomId().equals(roomDto.getBranchId())
							&&plan.getSuppGoodsId().equals(request.getPlanId())) {
						plan.setSelectedFlag(true);
					}else{
						plan.setSelectedFlag(false);
					}
				}
			}
			
			if(request.getHotelId().equals(hotelDto.getProductId())){
				selectedHotelDto = hotelDto;
			}
		}
		
		return selectedHotelDto;
	}	
	

	@Override
	public FitShoppingDto changedFlight(ChangeFlightRequest request){
		
		FitShoppingDto shoppingDto =  getFitShopping(request.getShoppingUUID());
		if(null == shoppingDto){
			throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
		}
		
		List<FlightSearchFlightInfoDto> infos =  null;
		try{
			infos =  getFlightSearchResult(request.getShoppingUUID())
					.getFlightSearchResult().get(0).getResults();
		}catch(Exception ex){
		}
		
		FlightSearchFlightInfoDto changedFlightDto = getSelected(request,infos);
		
		if(null==changedFlightDto){
			changedFlightDto=getSelected(request,shoppingDto.sameSegment(request.getFlightNo()));
		}
		
		if(null==changedFlightDto){
			return shoppingDto;
		}
		
		shoppingDto.changeFlight(changedFlightDto);
		infos = shoppingDto.getFlightInfos();
		//更仓位后，重新设置机票基准价 
		FitSearchRequest searchRequest = shoppingDto.getSearchRequest();
		FitPassengerRequest fitPassengerRequest = searchRequest.getFitPassengerRequest();
		int adultCount = fitPassengerRequest.getAdultCount();
		int childCount = fitPassengerRequest.getChildCount();
		BigDecimal toFlightBasePrice = new BigDecimal(0);
    	BigDecimal backFlightBasePrice = new BigDecimal(0);
    	FlightSearchFlightInfoDto flightSearchFlightInfoDto = new FlightSearchFlightInfoDto();
    	if("to".equalsIgnoreCase(request.getFlightType())){
    		flightSearchFlightInfoDto = infos.get(0);
    		toFlightBasePrice = this.getNewBasePrice(flightSearchFlightInfoDto,adultCount,childCount);
    		shoppingDto.setToFlightBasePrice(toFlightBasePrice);
    	}else{
    		flightSearchFlightInfoDto = infos.get(1);
    		backFlightBasePrice = this.getNewBasePrice(flightSearchFlightInfoDto,adultCount,childCount);
    		shoppingDto.setBackFlightBasePrice(backFlightBasePrice);
    	}
    	
		
		putShoppingCache(request.getShoppingUUID(),shoppingDto);
		return shoppingDto;
	}

	/**
	 * 更换仓位后，设置新的机票基准价
	 * @param flightSearchFlightInfoDto
	 * @param childCount 
	 * @param adultCount 
	 * @return
	 */
	private BigDecimal getNewBasePrice(FlightSearchFlightInfoDto flightSearchFlightInfoDto, int adultCount, int childCount) {
		BigDecimal flightBasePrice = new BigDecimal(0);
		
		List<FlightSearchSeatDto> seats = flightSearchFlightInfoDto.getSeats();
		for (FlightSearchSeatDto seat : seats) {
			Boolean selectFlag = seat.getSelectFlag();
			if(selectFlag){
				flightBasePrice = seat.getSalesPrice().multiply(new BigDecimal(adultCount)).add(seat.getChildrenPrice().multiply(new BigDecimal(childCount)));
			}
		}
		return flightBasePrice;
	}

	@Override
	public FitShoppingDto changedHotel(ChangeHotelRequest request) {
		
		List<HotelSearchHotelDto> infos =  this.getHotelSearchResult(request.getShoppingUUID());
		
		FitShoppingDto shoppingDto =  this.getFitShopping(request.getShoppingUUID());
		
		if(null == shoppingDto){
			throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
		}  
		
		HotelSearchHotelDto changedHotelDto = this.getSelected(request,infos);
		
		if(null==changedHotelDto){
			changedHotelDto=this.getSelected(request,shoppingDto.getHotels());
		}
		
		if(null==changedHotelDto){
			return shoppingDto;
		}
		
		shoppingDto.changeHotel(changedHotelDto);
		
		//设置新的酒店基准价，用来前台计算差价
		BigDecimal hotelBasePrice = BigDecimal.valueOf(0);
		hotelBasePrice = this.getBaseHotelPrice(changedHotelDto,request);
		shoppingDto.setHotelBasePrice(hotelBasePrice);
		
		this.putShoppingCache(request.getShoppingUUID(),shoppingDto);
		
		return shoppingDto;
		
	}

	private BigDecimal getBaseHotelPrice(HotelSearchHotelDto changedHotelDto, ChangeHotelRequest request) {
		BigDecimal hotelBasePrice = BigDecimal.valueOf(0);
		int roomCount = request.getRoomCount();
		List<HotelSearchRoomDto> rooms = changedHotelDto.getRooms();
        for(HotelSearchRoomDto room :rooms){
            if (room.getSelectedFlag()){//选中的房间
                List<HotelSearchPlanDto> plans = room.getPlans();
                roomCount = room.getRoomCounts();
                for(HotelSearchPlanDto plan :plans){
                    if(plan.getSelectedFlag()){//选中的plan
                        for(FitHotelPlanPriceDto priceDto:plan.getDayPrice()){
                            hotelBasePrice = hotelBasePrice.add(priceDto.getSalesPrice());//销售价取销售价的字段
                        }
                        hotelBasePrice = hotelBasePrice.multiply(new BigDecimal(roomCount));
                    } 
                }
            }
        }
		return hotelBasePrice;
	}

	@Override
	public boolean putFlightSearchResult(String shoppingUUID,FitSearchResult infos) {

		CacheBox box = new CacheBox();
		box.setKey(shoppingUUID);
		box.setJson(CacheBoxConvert.FlightSearchInfosResult.convertFrom(infos));
		box.setExpireTime(System.currentTimeMillis()+getCacheExpireTime());
		
		return put2Cache(getFlightCacheKey(shoppingUUID),box);
	}
	
	@Override
	public FitSearchResult getFlightSearchResult(String shoppingUUID){
		
		CacheBox box = MemcachedUtil.getInstance().get(getFlightCacheKey(shoppingUUID));
		if(null==box){
			return null;
		}
		if(System.currentTimeMillis()>box.getExpireTime()){
			//尝试重新查询并给出新的结果集,暂不实现;
			return null;
		}
		return CacheBoxConvert.FlightSearchInfosResult.convertTo(box.getJson());
	}
	
	@Override
	public boolean putHotelSearchResult(String shoppingUUID,List<HotelSearchHotelDto> infos) {
		
		CacheBox box = new CacheBox();
		box.setKey(shoppingUUID);
		box.setJson(CacheBoxConvert.HotelSearchInfosResult.convertFrom(infos));
		box.setExpireTime(System.currentTimeMillis()+getCacheExpireTime());
		
		return put2Cache(getHotelCacheKey(shoppingUUID),box);
	}
	
	@Override
	public List<HotelSearchHotelDto> getHotelSearchResult(String shoppingUUID){
		
		CacheBox box = MemcachedUtil.getInstance().get(getHotelCacheKey(shoppingUUID));
		if(null==box){
			return null;
		}
		if(System.currentTimeMillis()>box.getExpireTime()){
			//尝试重新查询并给出新的结果集,暂不实现;
			return null;
		}
		return CacheBoxConvert.HotelSearchInfosResult.convertTo(box.getJson());
	}
	
	@JsonIgnore
	private String getFlightCacheKey(String shoppingUUID){
		return shoppingUUID+"_flight";
	}

	@JsonIgnore
	private String getHotelCacheKey(String shoppingUUID){
		return shoppingUUID+"_hotel";
	}

	@Override
	public Map<String, Object> getHotelCondition(String shoppingUUID) {
		CacheBox box = MemcachedUtil.getInstance().get(getHotelConditionCacheKey(shoppingUUID));
		if(null==box){
			return null;
		}
		if(System.currentTimeMillis()>box.getExpireTime()){
			//尝试重新查询并给出新的结果集,暂不实现;
			return null;
		}
		return CacheBoxConvert.HotelCondition.convertTo(box.getJson());
	}

	@Override
	public boolean putHotelCondition(String shoppingUUID,Map<String, Object> conditionMap) {
		CacheBox box = new CacheBox();
		box.setKey(shoppingUUID);
		box.setJson(CacheBoxConvert.HotelCondition.convertFrom(conditionMap));
		box.setExpireTime(System.currentTimeMillis()+getCacheExpireTime());
		
		return put2Cache(getHotelConditionCacheKey(shoppingUUID),box);
	}
	
	@JsonIgnore
	private String getHotelConditionCacheKey(String shoppingUUID){
		return shoppingUUID+"_hotelCondition";
	}
}
