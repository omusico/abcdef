package com.lvmama.lvfit.common.dto.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOperDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;


public class FitShoppingDto extends Entity {
	
	private static final long serialVersionUID = 6813726881716295793L;
	
	/**查询条件*/
	private FitSearchRequest searchRequest;
	/**下单用户信息**/
	private FitOrderCustomerDto customer;
	
	private FitOrderOperDto oper;
	/**购买人信息**/
	private FitOrderContacterDto contacter;
	/**乘客信息**/
	private List<FitOrderPassengerDto> passenger = new ArrayList<FitOrderPassengerDto>();
	/**航班搜索信息**/
	private List<FlightSearchFlightInfoDto> flightInfos  = new ArrayList<FlightSearchFlightInfoDto>();
	/**选择酒店信息**/
	private List<HotelSearchHotelDto> hotels  = new ArrayList<HotelSearchHotelDto>();
	/**机票保险信息（作为机票的一部分存在）**/
	private List<InsuranceInfoDto> flightInsuranceInfos  = new ArrayList<InsuranceInfoDto>();
	/**景点门票信息**/
	private List<SpotSearchSpotDto> spots = new ArrayList<SpotSearchSpotDto>();
	/**景点门票信息**/
	private List<InsuranceDto> insurances = new ArrayList<InsuranceDto>();
	/**价格信息**/	
	private FitOrderAmountDto amount;
	
	private String ShoppingUuid;
	
	/**去程航班基准价**/
	private BigDecimal toFlightBasePrice;
	
	/**返程航班基准价**/
	private BigDecimal backFlightBasePrice;
	
	/**酒店基准价**/
	private BigDecimal hotelBasePrice;
	
	/**航班个数,包含去程和方程航班的个数*/
	private List<Integer> flightCounts;
	
	/**酒店个数*/
	private int hotelCounts;
	
	/**默认推荐的酒店*/
	private List<HotelSearchHotelDto> recommendedHotels  = new ArrayList<HotelSearchHotelDto>();
	
	/**选择的门票信息*/
	private List<FitShoppingSelectedTicketDto> selectTicketInfo = new ArrayList<FitShoppingSelectedTicketDto>();
	
	/**选择的保险信息*/
	private List<FitShoppingSelectedInsuranceDto> selectInsuranceInfo = new ArrayList<FitShoppingSelectedInsuranceDto>();
	
	/**选择的机票保险信息*/
	private List<FlightInsuranceDto> selectFlightInsInfo = new ArrayList<FlightInsuranceDto>();

	private String requestKey;
	// 当从缓存中删除航意险后，避免初始化时，页面重新加载航意险。
	private boolean fliInsDelFlag = false;
	
	//筛选选中酒店、航班等信息
	@JsonIgnore
	public FitShoppingDto getSelectedInfo() {
		
		FitShoppingDto selectedShopping = new FitShoppingDto();
		//检索条件
		selectedShopping.setSearchRequest(this.getSearchRequest());
		//已选酒店信息
		List<HotelSearchHotelDto> selectedHotelList = selectedShopping.getHotels();
		for (HotelSearchHotelDto hotelDto : this.getHotels()) {
			List<HotelSearchRoomDto> selectedRoomList = new ArrayList<HotelSearchRoomDto>();
			for (HotelSearchRoomDto room : hotelDto.getRooms()) {
				if (room.getSelectedFlag()) {
					List<HotelSearchPlanDto> selectedPlanList = new ArrayList<HotelSearchPlanDto>();
					for (HotelSearchPlanDto plan : room.getPlans()) {
						if (plan.getSelectedFlag()) {
							plan.setBreakfast(plan.getDayPrice().get(0).getBreakfast());
							selectedPlanList.add(plan);
							break;
						}
					}
					room.setPlans(selectedPlanList);
					selectedRoomList.add(room);
					break;
				}
			}
			hotelDto.setRooms(selectedRoomList);
			selectedHotelList.add(hotelDto);
		}

		//已选机票信息
		List<FlightSearchFlightInfoDto> selectedFlightList = selectedShopping.getFlightInfos();
		for (FlightSearchFlightInfoDto flightDto : this.getFlightInfos()) {
			List<FlightSearchSeatDto> selectedSeatList = new ArrayList<FlightSearchSeatDto>();
			for (FlightSearchSeatDto seat : flightDto.getSeats()) {
				if (seat.getSelectFlag()) {
					selectedSeatList.add(seat);
				}
			}
			flightDto.setSeats(selectedSeatList);
			String ddepartureDate = flightDto.getDepartureTime().substring(0, 10);
			String darrivalDate = flightDto.getArrivalTime().substring(0, 10);
			if(!ddepartureDate.equals(darrivalDate)){
				flightDto.setHighLightFlag(true);
			}
			selectedFlightList.add(flightDto);
		}

		//初始化航程
		for(int i = 0; i < selectedShopping.getFlightInfos().size();i++){
			if(i==0){
				selectedShopping.getFlightInfos().get(i).setBackOrTo(FlightTripType.DEPARTURE.name());
			}else{
				selectedShopping.getFlightInfos().get(i).setBackOrTo(FlightTripType.RETURN.name());
			}
		}
		
		//已选门票信息
		selectedShopping.setSelectTicketInfo(this.getSelectTicketInfo());
		//已选保险信息
		selectedShopping.setSelectInsuranceInfo(this.getSelectInsuranceInfo());
		//航意险信息
		selectedShopping.setSelectFlightInsInfo(this.getSelectFlightInsInfo());
		
		return selectedShopping;
	}

	public List<FlightSearchFlightInfoDto> sameSegment(String flightNo){
		List<FlightSearchFlightInfoDto> selectedFlightList = new ArrayList<FlightSearchFlightInfoDto>();
		for(FlightSearchFlightInfoDto flightDto : this.getFlightInfos()){
			if(flightNo.equals(flightDto.getFlightNo())){
				selectedFlightList.add(flightDto);
			}
		}
		return selectedFlightList;
	}

	private boolean compile(FlightSearchFlightInfoDto orgin, FlightSearchFlightInfoDto target) {
		return orgin.getDepartureCityName().equals(target.getDepartureCityName()) 
				&& orgin.getArrivalCityName().equals(orgin.getArrivalCityName())
				&& orgin.getDepartureDate().equals(target.getDepartureDate());
	}
	
	public void changeFlight(FlightSearchFlightInfoDto changedFlightDto){
		List<FlightSearchFlightInfoDto> newInfos = new ArrayList<FlightSearchFlightInfoDto>();
		for (FlightSearchFlightInfoDto flight:flightInfos){
			boolean isEquals = compile(flight,changedFlightDto);
			if (!isEquals) {
				newInfos.add(flight);
			}else{
				newInfos.add(changedFlightDto);
			}
		}
		flightInfos=newInfos;
//		sortFlightInfoByTime();
	}

//	public void sortFlightInfoByTime(){
//		Collections.sort(flightInfos,new Comparator<FlightSearchFlightInfoDto>(){
//			public int compare(FlightSearchFlightInfoDto dto1,FlightSearchFlightInfoDto dto2) {
//				return dto1.getDepartureTime().compareTo(dto2.getDepartureTime());
//			}
//		});
//		
//	}

	public void changeHotel(HotelSearchHotelDto changedHotel) {
		this.hotels.clear();
		this.hotels.add(changedHotel);
	}

	public FitOrderCustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(FitOrderCustomerDto customer) {
		this.customer = customer;
	}
	public FitOrderOperDto getOper() {
		return oper;
	}
	public void setOper(FitOrderOperDto oper) {
		this.oper = oper;
	}
	public FitOrderContacterDto getContacter() {
		return contacter;
	}
	public void setContacter(FitOrderContacterDto contacter) {
		this.contacter = contacter;
	}
	public List<FitOrderPassengerDto> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<FitOrderPassengerDto> passenger) {
		this.passenger = passenger;
	}
	public List<FlightSearchFlightInfoDto> getFlightInfos() {
		return flightInfos;
	}
	public void setFlightInfos(List<FlightSearchFlightInfoDto> flightInfos) {
		this.flightInfos = flightInfos;
	}
	public List<HotelSearchHotelDto> getHotels() {
		return hotels;
	}
	public void setHotels(List<HotelSearchHotelDto> hotels) {
		this.hotels = hotels;
	}

	public List<InsuranceInfoDto> getFlightInsuranceInfos() {
		return flightInsuranceInfos;
	}

	public void setFlightInsuranceInfos(List<InsuranceInfoDto> flightInsuranceInfos) {
		this.flightInsuranceInfos = flightInsuranceInfos;
	}

	public List<SpotSearchSpotDto> getSpots() {
		return spots;
	}
	public void setSpots(List<SpotSearchSpotDto> spots) {
		this.spots = spots;
	}
	public FitOrderAmountDto getAmount() {
		return amount;
	}
	public void setAmount(FitOrderAmountDto amount) {
		this.amount = amount;
	}
	public String getShoppingUuid() {
		return ShoppingUuid;
	}
	public void setShoppingUuid(String shoppingUuid) {
		ShoppingUuid = shoppingUuid;
	}
	public FitSearchRequest getSearchRequest() {
		return searchRequest;
	}
	public void setSearchRequest(FitSearchRequest searchRequest) {
		this.searchRequest = searchRequest;
	}

	public BigDecimal getToFlightBasePrice() {
		return toFlightBasePrice;
	}

	public void setToFlightBasePrice(BigDecimal toFlightBasePrice) {
		this.toFlightBasePrice = toFlightBasePrice;
	}

	public BigDecimal getBackFlightBasePrice() {
		return backFlightBasePrice;
	}

	public void setBackFlightBasePrice(BigDecimal backFlightBasePrice) {
		this.backFlightBasePrice = backFlightBasePrice;
	}

	public BigDecimal getHotelBasePrice() {
		return hotelBasePrice;
	}

	public void setHotelBasePrice(BigDecimal hotelBasePrice) {
		this.hotelBasePrice = hotelBasePrice;
	}


	public List<Integer> getFlightCounts() {
		return flightCounts;
	}


	public void setFlightCounts(List<Integer> flightCounts) {
		this.flightCounts = flightCounts;
	}


	public int getHotelCounts() {
		return hotelCounts;
	}


	public void setHotelCounts(int hotelCounts) {
		this.hotelCounts = hotelCounts;
	}

	public List<HotelSearchHotelDto> getRecommendedHotels() {
		return recommendedHotels;
	}

	public void setRecommendedHotels(List<HotelSearchHotelDto> recommendedHotels) {
		this.recommendedHotels = recommendedHotels;
	}

    public List<FitShoppingSelectedTicketDto> getSelectTicketInfo() {
        return selectTicketInfo;
    }

    public void setSelectTicketInfo(List<FitShoppingSelectedTicketDto> selectTicketInfo) {
        this.selectTicketInfo = selectTicketInfo;
    }

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

	public final List<InsuranceDto> getInsurances() {
		return insurances;
	}
	
	public final void setInsurances(List<InsuranceDto> insurances) {
		this.insurances = insurances;
	}

	public final List<FitShoppingSelectedInsuranceDto> getSelectInsuranceInfo() {
		return selectInsuranceInfo;
	}

	public final void setSelectInsuranceInfo(
			List<FitShoppingSelectedInsuranceDto> selectInsuranceInfo) {
		this.selectInsuranceInfo = selectInsuranceInfo;
	}

    public List<FlightInsuranceDto> getSelectFlightInsInfo() {
        return selectFlightInsInfo;
    }

    public void setSelectFlightInsInfo(List<FlightInsuranceDto> selectFlightInsInfo) {
        this.selectFlightInsInfo = selectFlightInsInfo;
    }

    public boolean getFliInsDelFlag() {
        return fliInsDelFlag;
    }

    public void setFliInsDelFlag(boolean fliInsDelFlag) {
        this.fliInsDelFlag = fliInsDelFlag;
    }
}
