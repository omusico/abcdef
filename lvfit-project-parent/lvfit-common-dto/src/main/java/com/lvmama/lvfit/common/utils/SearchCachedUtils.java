package com.lvmama.lvfit.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lvmama.lvf.common.utils.MemcachedUtil;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

/**
 * 用于生成shoppingUUid,获取缓存中的信息
 * */
public class SearchCachedUtils {

	/**
	 * 
	 * @return
	 */
	public static String generateShoppingUUID(){
		String uuid = UUID.randomUUID().toString().replace("-","");
		return uuid;
	}
	
	/**
	 * 
	 * 在UUId上拼接后缀
	 */
	public static String generateShoppingUUID(String Suffix){
		String uuid = UUID.randomUUID().toString().replace("-","");
		uuid = uuid+Suffix;
		return uuid;
	}
	

	/**
	 * 
	 * 此方法用于获取缓存中，当前被选中的酒店的pan,之间的关系为，
	 * 一个酒店下面有多个房间，一个房间下面有多个plan,当前选中地数据结构为，一个酒店的一个房间的一个plan
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static List<HotelSearchHotelDto> getSelectedHotels(String shoppingUUID){
		
		
		FitShoppingDto shoppoingDto = (FitShoppingDto)MemcachedUtil.getInstance().get(shoppingUUID);
		if(shoppoingDto != null){
			List<HotelSearchHotelDto> selectedHotels = new ArrayList<HotelSearchHotelDto>();
			HotelSearchHotelDto hotelSearchHotelDto = new HotelSearchHotelDto();
			List<HotelSearchHotelDto> hotels = shoppoingDto.getHotels();
			for (HotelSearchHotelDto hotelDto:hotels){
				List<HotelSearchRoomDto> rooms = hotelDto.getRooms();
				List<HotelSearchRoomDto> selectedRooms = new ArrayList<HotelSearchRoomDto>();
				for(HotelSearchRoomDto room:rooms){
					List<HotelSearchPlanDto> plans = room.getPlans();
					List<HotelSearchPlanDto> selectedPlans = new ArrayList<HotelSearchPlanDto>();
					for(HotelSearchPlanDto plan:plans){
						if(plan.getSelectedFlag()){
							hotelSearchHotelDto = hotelDto;
							selectedPlans.add(plan);
							room.setPlans(selectedPlans);
							room.setSelectedFlag(true);
							selectedRooms.add(room);
							hotelSearchHotelDto.setRooms(selectedRooms);
							selectedHotels.add(hotelSearchHotelDto);
						}
					}
				}
			}
			return selectedHotels;
		}
		return null;//没有数据
	}
	
	/**
	 * 
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static List<FlightSearchFlightInfoDto> getSelectedFlights(String shoppingUUID){
		List<FlightSearchFlightInfoDto> flightInfos = new ArrayList<FlightSearchFlightInfoDto>();
		FitShoppingDto shoppoingDto = (FitShoppingDto)MemcachedUtil.getInstance().get(shoppingUUID);
		if(shoppoingDto != null){
			flightInfos = shoppoingDto.getFlightInfos();
			for(FlightSearchFlightInfoDto flightDto:flightInfos){
				List<FlightSearchSeatDto> selected = new ArrayList<FlightSearchSeatDto>();
				List<FlightSearchSeatDto> seats = flightDto.getSeats();
				for(FlightSearchSeatDto seat:seats){
					if(seat.getSelectFlag()){//被选中
						selected.add(seat);
					}
					break;
				}
				flightDto.setSeats(selected);
			}		
		}
		
		return flightInfos;
	}
	
	public static void main(String[] args){
		List<FlightSearchFlightInfoDto> flightInfos = new ArrayList<FlightSearchFlightInfoDto>();
		FlightSearchFlightInfoDto flightInfo1 = new FlightSearchFlightInfoDto();
		FlightSearchFlightInfoDto flightInfo2 = new FlightSearchFlightInfoDto();
		flightInfos.add(flightInfo1);
		flightInfos.add(flightInfo2);
		List<FlightSearchSeatDto>  seats1 = new ArrayList<FlightSearchSeatDto>();
		for (int i = 0;i <10;i++){
			FlightSearchSeatDto seatDto = new FlightSearchSeatDto();
			if (i ==6){
				seatDto.setSelectFlag(true);
				seatDto.setSeatId(Long.valueOf(i));
			} else {
				seatDto.setSelectFlag(true);
				seatDto.setSeatId(Long.valueOf(i));
			}
			seats1.add(seatDto);
		}
		flightInfo1.setArrivalAirportCode("a");
		flightInfo1.setFlightId(11l);
		flightInfo1.setSeats(seats1);
		
		List<FlightSearchSeatDto>  seats2 = new ArrayList<FlightSearchSeatDto>();
		for (int i = 0;i <10;i++){
			FlightSearchSeatDto seatDto = new FlightSearchSeatDto();
			if (i ==6){
				seatDto.setSelectFlag(true);
				seatDto.setSeatId(Long.valueOf(i));
			} else {
				seatDto.setSelectFlag(true);
				seatDto.setSeatId(Long.valueOf(i));
			}
			seats2.add(seatDto);
		}
		flightInfo2.setArrivalAirportCode("a");
		flightInfo2.setFlightId(10l);
		flightInfo2.setSeats(seats2);
		flightInfos.add(flightInfo1);
		flightInfos.add(flightInfo2);
	}

}
