package com.lvmama.lvfit.common.dto.search.flight;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.type.TypeReference;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.enums.SeatClassType;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;

public class SearchResultUtil implements Serializable{

	private static final long serialVersionUID = -3093651592910076406L;

    public static final String LOW_SEAT_KEY = "LowSeat";

    public static final String SUPER_SEAT_KEY = "superSeat";
    
    


	public static Map<String,FlightSearchSeatDto> getLowSeats(List<FlightSearchSeatDto> seats){
		
		List<FlightSearchSeatDto> FSeats = new ArrayList<FlightSearchSeatDto>();
		List<FlightSearchSeatDto> CSeats = new ArrayList<FlightSearchSeatDto>();
		List<FlightSearchSeatDto> YSeats = new ArrayList<FlightSearchSeatDto>();
		Map<String,FlightSearchSeatDto> seatMap = new HashMap<String, FlightSearchSeatDto>();
		for(FlightSearchSeatDto dto : seats){
			if(SeatClassType.F.name().equalsIgnoreCase(dto.getSeatClassType())){
				FSeats.add(dto);
				continue;
			}
			
			if(SeatClassType.C.name().equalsIgnoreCase(dto.getSeatClassType())){
				CSeats.add(dto);
				continue;
			}

			if(SeatClassType.Y.name().equalsIgnoreCase(dto.getSeatClassType())){
				YSeats.add(dto);
			}
		}
		
		List<FlightSearchSeatDto> LowSeat = getLowSeat(FSeats, CSeats, YSeats);
		if(CollectionUtils.isNotEmpty(LowSeat)){
			seatMap.put(LOW_SEAT_KEY, getSalPrice(LowSeat.get(0)));
		}
		
		if(FSeats.size()>0){
			seatMap.put(SUPER_SEAT_KEY, getSalPrice(FSeats.get(0)));
		}
		
		return seatMap;
	}
	
	private static List<FlightSearchSeatDto> getLowSeat(List<FlightSearchSeatDto> F,List<FlightSearchSeatDto> C,List<FlightSearchSeatDto> Y){
		if(Y.size()>0){
			sort(Y);
			return Y;
		}
		if(C.size()>0){
			sort(C);
			return C;
		}
		if(F.size()>0){
			sort(F);
			return F;
		}
		return null;
	}
	
	private static List<FlightSearchSeatDto> sort(List<FlightSearchSeatDto> seats){
		Collections.sort(seats,new Comparator<FlightSearchSeatDto>(){
			@Override
			public int compare(FlightSearchSeatDto o1, FlightSearchSeatDto o2) {
				return o1.getFlightTicketPriceDto().getParPrice().compareTo(o2.getFlightTicketPriceDto().getParPrice());
			}});
		return seats;
	}
	
	
	public static List<FlightSearchSeatDto> sortBySalePrice(FlightSearchFlightInfoDto searchFlightDto){
		List<FlightSearchSeatDto> seats = searchFlightDto.getSeats();
		Collections.sort(seats, new Comparator<FlightSearchSeatDto>() {
			@Override
			public int compare(FlightSearchSeatDto c1,
					FlightSearchSeatDto c2) {
				if (c1.getSalesPrice().compareTo(c2.getSalesPrice()) > 0) {
					return 1;
				} else if(c1.getSalesPrice().compareTo(c2.getSalesPrice())==0 
						&& c1.getSeatClassCode().equals("Y") 
						&& !c2.getSeatClassCode().equals("Y")){
					return 1;
				}else if(c1.getSalesPrice().compareTo(c2.getSalesPrice())==0 
						&& !c1.getSeatClassCode().equals("Y") 
						&& c2.getSeatClassCode().equals("Y")){
					return 1;
				}else{
					return -1;
				}
			}
		});
		return seats;
	}
	
	public static List<FlightSearchSeatDto> getYCFLowPriceSeats(FlightSearchFlightInfoDto searchFlightDto){
		List<FlightSearchSeatDto> yCFSeats = new ArrayList<FlightSearchSeatDto>();
		List<FlightSearchSeatDto> ySeats = new ArrayList<FlightSearchSeatDto>();
		List<FlightSearchSeatDto> cSeats = new ArrayList<FlightSearchSeatDto>();
		List<FlightSearchSeatDto> fSeats = new ArrayList<FlightSearchSeatDto>();
		for(FlightSearchSeatDto dto : searchFlightDto.getSeats()){
			if(SeatClassType.F.name().equalsIgnoreCase(dto.getSeatClassType())){
				fSeats.add(dto);
				continue;
			}
			
			if(SeatClassType.C.name().equalsIgnoreCase(dto.getSeatClassType())){
				cSeats.add(dto);
				continue;
			}

			if(SeatClassType.Y.name().equalsIgnoreCase(dto.getSeatClassType())){
				ySeats.add(dto);
			}
		}
		if(ySeats.size() != 0){
			yCFSeats.add(SearchResultUtil.getLowestPriceSeat(ySeats));
		}
		if(cSeats.size() != 0){
			yCFSeats.add(SearchResultUtil.getLowestPriceSeat(cSeats));
		}
		if(fSeats.size() != 0){
			yCFSeats.add(SearchResultUtil.getLowestPriceSeat(fSeats));
		}
		return yCFSeats;
	}
	
	
	public static FlightSearchSeatDto getLowestPriceSeat(List<FlightSearchSeatDto> seats){
		int i = 0;
		FlightSearchSeatDto seatDto = null;
		for(FlightSearchSeatDto seat : seats){
			if(i == 0){
				seatDto = seat;
			}else{
				if(seatDto.getSalesPrice().compareTo(seat.getSalesPrice())>0){
					seatDto = seat;
				}
			}
			i++;
		}
		return seatDto;
	}
	
	private static FlightSearchSeatDto getSalPrice(FlightSearchSeatDto seatDto){
		
		BigDecimal salesPrice = seatDto.getSalesPrice();
		BigDecimal fuelsurTax = seatDto.getFuelsurTax();
		BigDecimal airportFee = seatDto.getAirportFee();
		BigDecimal fuelsurTaxAndAirportFee = fuelsurTax.add(airportFee);
		salesPrice = salesPrice.subtract(fuelsurTaxAndAirportFee);
		seatDto.setSalesPrice(salesPrice);
		return seatDto;
	}
	
	/**
	 * 判断是否是有效舱位
	 * 分有儿童和没有儿童两种情况
	 * 如果有儿童，要首先判断是否可卖儿童票，然后再判断对应的库存是否足够
	 * 如果没有儿童，就直接判断库存是否大于等于人数
	 * 判断方式：seatClassType 为"Y"时，有seatClassCode也为Y的舱位  才可以卖儿童票，同理F-F,C-C
	 * */
	public static FlightSearchFlightInfoDto isAvailableSeat(FlightSearchFlightInfoDto flightSearchFlightInfoDto, int adultCount, int childCount){
		List<FlightSearchSeatDto> yCFSeats = new ArrayList<FlightSearchSeatDto>();
		List<FlightSearchSeatDto> ySeats = new ArrayList<FlightSearchSeatDto>();
		List<FlightSearchSeatDto> cSeats = new ArrayList<FlightSearchSeatDto>();
		List<FlightSearchSeatDto> fSeats = new ArrayList<FlightSearchSeatDto>();
		Map<String,FlightSearchSeatDto> childrenSeats = flightSearchFlightInfoDto.getChildrenSeats();
		for(FlightSearchSeatDto dto : flightSearchFlightInfoDto.getSeats()){
			if(SeatClassType.Y.name().equalsIgnoreCase(dto.getSeatClassType())){
				ySeats.add(dto);
			}
			if(SeatClassType.C.name().equalsIgnoreCase(dto.getSeatClassType())){
				cSeats.add(dto);
				continue;
			}
	
			if(SeatClassType.F.name().equalsIgnoreCase(dto.getSeatClassType())){
				fSeats.add(dto);
				continue;
			}
			
		}
		
		if (childCount == 0){//没有儿童
			for (FlightSearchSeatDto seatDto:ySeats){
				if(seatDto.getInventoryCount() >= adultCount){
					yCFSeats.add(seatDto);
				}
			}
			for (FlightSearchSeatDto seatDto:cSeats){
				if(seatDto.getInventoryCount() >= adultCount){
					yCFSeats.add(seatDto);
				}
			}
			for (FlightSearchSeatDto seatDto:fSeats){
				if(seatDto.getInventoryCount() >= adultCount){
					yCFSeats.add(seatDto);
				}
			}
		} else {//有儿童   
			/**
			 * 判断逻辑：先到childseats里根据当前seat的code去get数据，如果能得到数据，则说明可以卖儿童票，然后根据该舱位的库存和儿童数进行比较，
			 * 如果足够则视为有效舱位，否则无效
			 * */
			if(null != childrenSeats){
				for (FlightSearchSeatDto seatDto:ySeats){
					if(null != childrenSeats.get(seatDto.getSeatClassCode())){
						if(seatDto.getSeatClassCode().equals(childrenSeats.get(seatDto.getSeatClassCode()).getSeatClassCode())){//成人也选择基础舱位
							if(seatDto.getInventoryCount() >= (adultCount + childCount)){
								yCFSeats.add(seatDto);
								seatDto.setChildrenPrice(childrenSeats.get(seatDto.getSeatClassCode()).getSalesPrice());
							}
						} else {
							if(null != childrenSeats.get(seatDto.getSeatClassCode()) && 
									childrenSeats.get(seatDto.getSeatClassCode()).getInventoryCount() >= childCount){
								if(seatDto.getInventoryCount() >= adultCount){
									seatDto.setChildrenPrice(childrenSeats.get(seatDto.getSeatClassCode()).getSalesPrice());
									yCFSeats.add(seatDto);
								}
							}
						}
					
					}
				}
				for (FlightSearchSeatDto seatDto:cSeats){
					if(null != childrenSeats.get(seatDto.getSeatClassCode())){
						if(seatDto.getSeatClassCode().equals(childrenSeats.get(seatDto.getSeatClassCode()).getSeatClassCode())){//成人也选择基础舱位
							if(seatDto.getInventoryCount() >= (adultCount + childCount)){
								yCFSeats.add(seatDto);
								seatDto.setChildrenPrice(childrenSeats.get(seatDto.getSeatClassCode()).getSalesPrice());
							}
						} else {
							if(null != childrenSeats.get(seatDto.getSeatClassCode()) && 
									childrenSeats.get(seatDto.getSeatClassCode()).getInventoryCount() >= childCount){
								if(seatDto.getInventoryCount() >= adultCount){
									seatDto.setChildrenPrice(childrenSeats.get(seatDto.getSeatClassCode()).getSalesPrice());
									yCFSeats.add(seatDto);
								}
							}
						}
					}	
				}
			for (FlightSearchSeatDto seatDto:fSeats){
				if(null != childrenSeats.get(seatDto.getSeatClassCode())){
					if(seatDto.getSeatClassCode().equals(childrenSeats.get(seatDto.getSeatClassCode()).getSeatClassCode())){//成人也选择基础舱位
						if(seatDto.getInventoryCount() >= (adultCount + childCount)){
							seatDto.setChildrenPrice(childrenSeats.get(seatDto.getSeatClassCode()).getSalesPrice());
							yCFSeats.add(seatDto);
						}
					} else {
						if(null != childrenSeats.get(seatDto.getSeatClassCode()) && 
								childrenSeats.get(seatDto.getSeatClassCode()).getInventoryCount() >= childCount){
							if(seatDto.getInventoryCount() >= adultCount){
								seatDto.setChildrenPrice(childrenSeats.get(seatDto.getSeatClassCode()).getSalesPrice());
								yCFSeats.add(seatDto);
							}
						}
					}
				}
				
			}
			}
	}
		flightSearchFlightInfoDto.setSeats(yCFSeats);
		return flightSearchFlightInfoDto;
	}
	
	public static void main(String[] args) {
		String str = "{\"status\":\"SUCCESS\",\"results\":[{\"carrierName\":\"中国国航\",\"carrierCode\":\"CA\",\"flightId\":917,\"flightNo\":\"CA8904\",\"airplane\":{\"createTime\":1431952377975,\"updateTime\":1431952377975,\"minSeats\":0,\"maxSeats\":0,\"airplaneCompany\":{\"createTime\":1431952377975,\"updateTime\":1431952377975,\"isForeign\":true}},\"departureDate\":\"2015-06-30\",\"departureTime\":\"2015-06-30 11:55:00\",\"arrivalTime\":\"2015-06-30 13:15:00\",\"flyTimeMins\":79,\"stopCount\":0,\"directType\":\"DIRECT\",\"departureAirportName\":\"首都国际机场\",\"departureAirportCode\":\"PEK\",\"departureTermainalBuilding\":\"T3\",\"departureCityName\":\"北京市\",\"arrivalAirportName\":\"大连国际机场\",\"arrivalAirportCode\":\"DLC\",\"arrivalTerminalBuilding\":\"T1\",\"arrivalCityName\":\"大连市\",\"mealType\":\"NONE\",\"fuelsurTaxs\":{\"CHILDREN\":0,\"ADULT\":0},\"airportFees\":{\"CHILDREN\":0,\"ADULT\":50},\"seats\":[{\"seatId\":7174,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"B\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":640,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":690,\"salesPrice\":84.0,\"settlePrice\":44.0,\"discount\":0.9,\"promotion\":586.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":640,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":8,\"promotion\":586.0,\"salesPrice\":84.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":690,\"settlePrice\":44.0,\"discount\":0.9},{\"seatId\":6246,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"A\",\"seatClassName\":\"公务舱免折、常旅客免票\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":780,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":830,\"salesPrice\":94.0,\"settlePrice\":54.0,\"discount\":1.1,\"promotion\":716.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":780,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":2,\"promotion\":716.0,\"salesPrice\":94.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":830,\"settlePrice\":54.0,\"discount\":1.1},{\"seatId\":6010,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"F\",\"seatClassName\":\"头等舱\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":2840,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":2890,\"salesPrice\":234.0,\"settlePrice\":194.0,\"discount\":4.0,\"promotion\":2636.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":2840,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":2636.0,\"salesPrice\":234.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":2890,\"settlePrice\":194.0,\"discount\":4.0},{\"seatId\":6009,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"Y\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":710,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":760,\"salesPrice\":89.0,\"settlePrice\":49.0,\"discount\":1.0,\"promotion\":651.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":710,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":651.0,\"salesPrice\":89.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":760,\"settlePrice\":49.0,\"discount\":1.0}]},{\"carrierName\":\"中国国航\",\"carrierCode\":\"CA\",\"flightId\":915,\"flightNo\":\"CA953\",\"airplane\":{\"createTime\":1431952377974,\"updateTime\":1431952377974,\"name\":\"波音737-800\",\"code\":\"738\",\"airplaneType\":\"中型飞机\",\"minSeats\":150,\"maxSeats\":187,\"airplaneCompany\":{\"createTime\":1431952377974,\"updateTime\":1431952377974,\"isForeign\":true}},\"departureDate\":\"2015-06-30\",\"departureTime\":\"2015-06-30 08:55:00\",\"arrivalTime\":\"2015-06-30 10:20:00\",\"flyTimeMins\":85,\"stopCount\":0,\"directType\":\"DIRECT\",\"departureAirportName\":\"首都国际机场\",\"departureAirportCode\":\"PEK\",\"departureTermainalBuilding\":\"T3\",\"departureCityName\":\"北京市\",\"arrivalAirportName\":\"大连国际机场\",\"arrivalAirportCode\":\"DLC\",\"arrivalTerminalBuilding\":\"T1\",\"arrivalCityName\":\"大连市\",\"mealType\":\"NONE\",\"fuelsurTaxs\":{\"CHILDREN\":0,\"ADULT\":0},\"airportFees\":{\"CHILDREN\":0,\"ADULT\":50},\"seats\":[{\"seatId\":6005,\"seatClassType\":\"C\",\"seatClassTypeName\":\"公务舱\",\"seatClassCode\":\"C\",\"seatClassName\":\"经济舱\",\"seatClassDesc\":\"公务舱\",\"flightTicketPriceDto\":{\"parPrice\":2740,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":2790,\"salesPrice\":227.0,\"settlePrice\":187.0,\"discount\":3.86,\"promotion\":2543.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":2740,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":8,\"promotion\":2543.0,\"salesPrice\":227.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":2790,\"settlePrice\":187.0,\"discount\":3.86},{\"seatId\":6004,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"Y\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":710,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":760,\"salesPrice\":89.0,\"settlePrice\":49.0,\"discount\":1.0,\"promotion\":651.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":710,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":651.0,\"salesPrice\":89.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":760,\"settlePrice\":49.0,\"discount\":1.0}]},{\"carrierName\":\"中国国航\",\"carrierCode\":\"CA\",\"flightId\":921,\"flightNo\":\"CA8902\",\"airplane\":{\"createTime\":1431952377976,\"updateTime\":1431952377976,\"code\":\"73D\",\"airplaneType\":\"小型飞机\",\"minSeats\":203,\"maxSeats\":290,\"airplaneCompany\":{\"createTime\":1431952377976,\"updateTime\":1431952377976,\"isForeign\":true}},\"departureDate\":\"2015-06-30\",\"departureTime\":\"2015-06-30 22:35:00\",\"arrivalTime\":\"2015-06-30 23:55:00\",\"flyTimeMins\":79,\"stopCount\":0,\"directType\":\"DIRECT\",\"departureAirportName\":\"首都国际机场\",\"departureAirportCode\":\"PEK\",\"departureTermainalBuilding\":\"T3\",\"departureCityName\":\"北京市\",\"arrivalAirportName\":\"大连国际机场\",\"arrivalAirportCode\":\"DLC\",\"arrivalTerminalBuilding\":\"T1\",\"arrivalCityName\":\"大连市\",\"mealType\":\"NONE\",\"fuelsurTaxs\":{\"CHILDREN\":0,\"ADULT\":0},\"airportFees\":{\"CHILDREN\":0,\"ADULT\":50},\"seats\":[{\"seatId\":6018,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"Y\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":710,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":760,\"salesPrice\":89.0,\"settlePrice\":49.0,\"discount\":1.0,\"promotion\":651.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":710,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":651.0,\"salesPrice\":89.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":760,\"settlePrice\":49.0,\"discount\":1.0},{\"seatId\":6020,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"F\",\"seatClassName\":\"头等舱\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":2840,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":2890,\"salesPrice\":234.0,\"settlePrice\":194.0,\"discount\":4.0,\"promotion\":2636.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":2840,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":8,\"promotion\":2636.0,\"salesPrice\":234.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":2890,\"settlePrice\":194.0,\"discount\":4.0},{\"seatId\":6019,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"A\",\"seatClassName\":\"公务舱免折、常旅客免票\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":780,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":830,\"salesPrice\":94.0,\"settlePrice\":54.0,\"discount\":1.1,\"promotion\":716.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":780,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":2,\"promotion\":716.0,\"salesPrice\":94.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":830,\"settlePrice\":54.0,\"discount\":1.1},{\"seatId\":7181,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"B\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":640,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":690,\"salesPrice\":84.0,\"settlePrice\":44.0,\"discount\":0.9,\"promotion\":586.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":640,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":586.0,\"salesPrice\":84.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":690,\"settlePrice\":44.0,\"discount\":0.9}]},{\"carrierName\":\"海南航空\",\"carrierCode\":\"HU\",\"flightId\":920,\"flightNo\":\"HU7183\",\"airplane\":{\"createTime\":1431952377976,\"updateTime\":1431952377976,\"name\":\"波音737-800\",\"code\":\"738\",\"airplaneType\":\"中型飞机\",\"minSeats\":150,\"maxSeats\":187,\"airplaneCompany\":{\"createTime\":1431952377976,\"updateTime\":1431952377976,\"isForeign\":true}},\"departureDate\":\"2015-06-30\",\"departureTime\":\"2015-06-30 22:05:00\",\"arrivalTime\":\"2015-06-30 23:30:00\",\"flyTimeMins\":85,\"stopCount\":0,\"directType\":\"DIRECT\",\"departureAirportName\":\"首都国际机场\",\"departureAirportCode\":\"PEK\",\"departureTermainalBuilding\":\"T1\",\"departureCityName\":\"北京市\",\"arrivalAirportName\":\"大连国际机场\",\"arrivalAirportCode\":\"DLC\",\"arrivalTerminalBuilding\":\"T1\",\"arrivalCityName\":\"大连市\",\"mealType\":\"NONE\",\"fuelsurTaxs\":{\"CHILDREN\":0,\"ADULT\":0},\"airportFees\":{\"CHILDREN\":0,\"ADULT\":50},\"seats\":[{\"seatId\":6017,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"F\",\"seatClassName\":\"头等舱\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":3200,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":3250,\"salesPrice\":2472.0,\"settlePrice\":2432.0,\"discount\":4.51,\"promotion\":758.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":3,\"suppPolicyId\":87932790,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":3200,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":8,\"promotion\":758.0,\"salesPrice\":2472.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":3250,\"settlePrice\":2432.0,\"discount\":4.51},{\"seatId\":6016,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"Y\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":710,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":760,\"salesPrice\":580.0,\"settlePrice\":540.0,\"discount\":1.0,\"promotion\":160.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":3,\"suppPolicyId\":87932790,\"active\":true,\"parPrice\":710,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":160.0,\"salesPrice\":580.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":760,\"settlePrice\":540.0,\"discount\":1.0},{\"seatId\":6247,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"B\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":640,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":690,\"salesPrice\":527.0,\"settlePrice\":487.0,\"discount\":0.9,\"promotion\":143.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":3,\"suppPolicyId\":87932790,\"active\":true,\"parPrice\":640,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":143.0,\"salesPrice\":527.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":690,\"settlePrice\":487.0,\"discount\":0.9},{\"seatId\":7157,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"K\",\"seatClassName\":\"经济舱80折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":570,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":620,\"salesPrice\":474.0,\"settlePrice\":434.0,\"discount\":0.8,\"promotion\":126.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":3,\"suppPolicyId\":87932790,\"active\":true,\"parPrice\":570,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":126.0,\"salesPrice\":474.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":620,\"settlePrice\":434.0,\"discount\":0.8},{\"seatId\":7158,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"H\",\"seatClassName\":\"经济舱85折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":600,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":650,\"salesPrice\":496.0,\"settlePrice\":456.0,\"discount\":0.85,\"promotion\":134.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":3,\"suppPolicyId\":87932790,\"active\":true,\"parPrice\":600,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":134.0,\"salesPrice\":496.0,\"profit\":{\"scale\":24,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":650,\"settlePrice\":456.0,\"discount\":0.85}]},{\"carrierName\":\"中国国航\",\"carrierCode\":\"CA\",\"flightId\":919,\"flightNo\":\"CA8908\",\"airplane\":{\"createTime\":1431952377975,\"updateTime\":1431952377975,\"code\":\"73D\",\"airplaneType\":\"小型飞机\",\"minSeats\":203,\"maxSeats\":290,\"airplaneCompany\":{\"createTime\":1431952377975,\"updateTime\":1431952377975,\"isForeign\":true}},\"departureDate\":\"2015-06-30\",\"departureTime\":\"2015-06-30 21:30:00\",\"arrivalTime\":\"2015-06-30 22:55:00\",\"flyTimeMins\":85,\"stopCount\":0,\"directType\":\"DIRECT\",\"departureAirportName\":\"首都国际机场\",\"departureAirportCode\":\"PEK\",\"departureTermainalBuilding\":\"T3\",\"departureCityName\":\"北京市\",\"arrivalAirportName\":\"大连国际机场\",\"arrivalAirportCode\":\"DLC\",\"arrivalTerminalBuilding\":\"T1\",\"arrivalCityName\":\"大连市\",\"mealType\":\"NONE\",\"fuelsurTaxs\":{\"CHILDREN\":0,\"ADULT\":0},\"airportFees\":{\"CHILDREN\":0,\"ADULT\":50},\"seats\":[{\"seatId\":6014,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"A\",\"seatClassName\":\"公务舱免折、常旅客免票\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":780,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":830,\"salesPrice\":94.0,\"settlePrice\":54.0,\"discount\":1.1,\"promotion\":716.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":780,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":2,\"promotion\":716.0,\"salesPrice\":94.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":830,\"settlePrice\":54.0,\"discount\":1.1},{\"seatId\":6013,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"Y\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":710,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":760,\"salesPrice\":89.0,\"settlePrice\":49.0,\"discount\":1.0,\"promotion\":651.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":710,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":651.0,\"salesPrice\":89.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":760,\"settlePrice\":49.0,\"discount\":1.0},{\"seatId\":6015,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"F\",\"seatClassName\":\"头等舱\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":2840,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":2890,\"salesPrice\":234.0,\"settlePrice\":194.0,\"discount\":4.0,\"promotion\":2636.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":2840,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":7,\"promotion\":2636.0,\"salesPrice\":234.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":2890,\"settlePrice\":194.0,\"discount\":4.0},{\"seatId\":7175,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"B\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":640,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":690,\"salesPrice\":84.0,\"settlePrice\":44.0,\"discount\":0.9,\"promotion\":586.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":640,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":586.0,\"salesPrice\":84.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":690,\"settlePrice\":44.0,\"discount\":0.9}]},{\"carrierName\":\"中国国航\",\"carrierCode\":\"CA\",\"flightId\":916,\"flightNo\":\"CA1605\",\"airplane\":{\"createTime\":1431952377974,\"updateTime\":1431952377974,\"minSeats\":0,\"maxSeats\":0,\"airplaneCompany\":{\"createTime\":1431952377974,\"updateTime\":1431952377974,\"isForeign\":true}},\"departureDate\":\"2015-06-30\",\"departureTime\":\"2015-06-30 10:40:00\",\"arrivalTime\":\"2015-06-30 11:55:00\",\"flyTimeMins\":75,\"stopCount\":0,\"directType\":\"DIRECT\",\"departureAirportName\":\"首都国际机场\",\"departureAirportCode\":\"PEK\",\"departureTermainalBuilding\":\"T3\",\"departureCityName\":\"北京市\",\"arrivalAirportName\":\"大连国际机场\",\"arrivalAirportCode\":\"DLC\",\"arrivalTerminalBuilding\":\"T1\",\"arrivalCityName\":\"大连市\",\"mealType\":\"NONE\",\"fuelsurTaxs\":{\"CHILDREN\":0,\"ADULT\":0},\"airportFees\":{\"CHILDREN\":0,\"ADULT\":50},\"seats\":[{\"seatId\":7162,\"seatClassType\":\"C\",\"seatClassTypeName\":\"公务舱\",\"seatClassCode\":\"Z\",\"seatClassName\":\"代码共享留座专用舱\",\"seatClassDesc\":\"公务舱\",\"flightTicketPriceDto\":{\"parPrice\":2130,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":2180,\"salesPrice\":185.0,\"settlePrice\":145.0,\"discount\":3.0,\"promotion\":1975.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":2130,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":4,\"promotion\":1975.0,\"salesPrice\":185.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":2180,\"settlePrice\":145.0,\"discount\":3.0},{\"seatId\":6006,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"Y\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":710,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":760,\"salesPrice\":89.0,\"settlePrice\":49.0,\"discount\":1.0,\"promotion\":651.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":710,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":651.0,\"salesPrice\":89.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":760,\"settlePrice\":49.0,\"discount\":1.0},{\"seatId\":7194,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"B\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":640,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":690,\"salesPrice\":84.0,\"settlePrice\":44.0,\"discount\":0.9,\"promotion\":586.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":640,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":586.0,\"salesPrice\":84.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":690,\"settlePrice\":44.0,\"discount\":0.9},{\"seatId\":6008,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"F\",\"seatClassName\":\"头等舱\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":2840,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":2890,\"salesPrice\":234.0,\"settlePrice\":194.0,\"discount\":4.0,\"promotion\":2636.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":2840,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":2636.0,\"salesPrice\":234.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":2890,\"settlePrice\":194.0,\"discount\":4.0},{\"seatId\":6007,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"A\",\"seatClassName\":\"公务舱免折、常旅客免票\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":780,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":830,\"salesPrice\":94.0,\"settlePrice\":54.0,\"discount\":1.1,\"promotion\":716.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":780,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":1,\"promotion\":716.0,\"salesPrice\":94.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":830,\"settlePrice\":54.0,\"discount\":1.1}]},{\"carrierName\":\"中国国航\",\"carrierCode\":\"CA\",\"flightId\":918,\"flightNo\":\"CA8906\",\"airplane\":{\"createTime\":1431952377975,\"updateTime\":1431952377975,\"code\":\"73D\",\"airplaneType\":\"小型飞机\",\"minSeats\":203,\"maxSeats\":290,\"airplaneCompany\":{\"createTime\":1431952377975,\"updateTime\":1431952377975,\"isForeign\":true}},\"departureDate\":\"2015-06-30\",\"departureTime\":\"2015-06-30 16:45:00\",\"arrivalTime\":\"2015-06-30 18:10:00\",\"flyTimeMins\":85,\"stopCount\":0,\"directType\":\"DIRECT\",\"departureAirportName\":\"首都国际机场\",\"departureAirportCode\":\"PEK\",\"departureTermainalBuilding\":\"T3\",\"departureCityName\":\"北京市\",\"arrivalAirportName\":\"大连国际机场\",\"arrivalAirportCode\":\"DLC\",\"arrivalTerminalBuilding\":\"T1\",\"arrivalCityName\":\"大连市\",\"mealType\":\"NONE\",\"fuelsurTaxs\":{\"CHILDREN\":0,\"ADULT\":0},\"airportFees\":{\"CHILDREN\":0,\"ADULT\":50},\"seats\":[{\"seatId\":6012,\"seatClassType\":\"F\",\"seatClassTypeName\":\"头等舱\",\"seatClassCode\":\"F\",\"seatClassName\":\"头等舱\",\"seatClassDesc\":\"头等舱\",\"flightTicketPriceDto\":{\"parPrice\":2840,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":2890,\"salesPrice\":234.0,\"settlePrice\":194.0,\"discount\":4.0,\"promotion\":2636.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"inventoryStatus\":\"A\",\"active\":true,\"parPrice\":2840,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":8,\"promotion\":2636.0,\"salesPrice\":234.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":2890,\"settlePrice\":194.0,\"discount\":4.0},{\"seatId\":6011,\"seatClassType\":\"Y\",\"seatClassTypeName\":\"经济舱\",\"seatClassCode\":\"Y\",\"seatClassName\":\"经济舱9折\",\"seatClassDesc\":\"经济舱\",\"flightTicketPriceDto\":{\"parPrice\":710,\"fuelsurTax\":0,\"airportFee\":50,\"totalParPrice\":760,\"salesPrice\":89.0,\"settlePrice\":49.0,\"discount\":1.0,\"promotion\":651.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0},\"policyId\":2,\"suppPolicyId\":87932854,\"active\":true,\"parPrice\":710,\"airportFee\":50,\"fuelsurTax\":0,\"inventoryCount\":10,\"promotion\":651.0,\"salesPrice\":89.0,\"profit\":{\"scale\":56.3,\"fixed\":0},\"profitAmount\":-10.0,\"activeStatus\":{\"activeStatus\":\"ACTIVE\",\"active\":true},\"totalParPrice\":760,\"settlePrice\":49.0,\"discount\":1.0}]}],\"pagination\":{\"page\":1,\"rows\":10,\"records\":0,\"total\":1,\"search\":false},\"facetMap\":{\"arrivalAirportCode\":{\"fieldName\":\"arrivalAirportCode\",\"fields\":[{\"fieldValue\":\"DLC\",\"count\":26}]},\"directType\":{\"fieldName\":\"directType\",\"fields\":[{\"fieldValue\":\"DIRECT\",\"fieldDesc\":\"直飞\",\"count\":26}]},\"seatClassType\":{\"fieldName\":\"seatClassType\",\"fields\":[{\"fieldValue\":\"Y\",\"fieldDesc\":\"经济舱\",\"count\":14},{\"fieldValue\":\"F\",\"fieldDesc\":\"头等舱\",\"count\":10},{\"fieldValue\":\"C\",\"fieldDesc\":\"公务舱\",\"count\":2}]},\"departureAirportCode\":{\"fieldName\":\"departureAirportCode\",\"fields\":[{\"fieldValue\":\"PEK\",\"count\":26}]},\"departureTimeSegment\":{\"fieldName\":\"departureTimeSegment\",\"fields\":[{\"fieldValue\":\"NIGHT\",\"fieldDesc\":\"晚上,18:00-24:00\",\"count\":13},{\"fieldValue\":\"MORNING\",\"fieldDesc\":\"上午,06:00-11:59\",\"count\":11},{\"fieldValue\":\"NOON\",\"fieldDesc\":\"下午,12:00-17:59\",\"count\":2}]},\"carrierNameCode\":{\"fieldName\":\"carrierNameCode\",\"fields\":[{\"fieldValue\":\"CA,中国国航\",\"fieldDesc\":\"中国国航\",\"count\":21},{\"fieldValue\":\"HU,海南航空\",\"fieldDesc\":\"海南航空\",\"count\":5}]},\"seatLevel\":{\"fieldName\":\"seatLevel\",\"fields\":[]},\"arrivalTimeSegment\":{\"fieldName\":\"arrivalTimeSegment\",\"fields\":[{\"fieldValue\":\"NIGHT\",\"fieldDesc\":\"晚上,18:00-24:00\",\"count\":15},{\"fieldValue\":\"MORNING\",\"fieldDesc\":\"上午,06:00-11:59\",\"count\":7},{\"fieldValue\":\"NOON\",\"fieldDesc\":\"下午,12:00-17:59\",\"count\":4}]}},\"isSuccess\":true,\"isFail\":false}";
		try{
		FlightSearchResult<FlightSearchFlightInfoDto> flights = JSONMapper.getInstance().readValue(str, new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {
		});
		
		System.out.println(flights.getResults().get(0).getSeats());
		
		List<FlightSearchSeatDto> seats = SearchResultUtil.getYCFLowPriceSeats(flights.getResults().get(0));
		
		
		
		System.out.println(JSONMapper.getInstance().writeValueAsString(seats));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}
}
