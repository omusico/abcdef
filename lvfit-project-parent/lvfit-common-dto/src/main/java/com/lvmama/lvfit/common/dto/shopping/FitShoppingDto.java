package com.lvmama.lvfit.common.dto.shopping;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOperDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


public class FitShoppingDto extends Entity {
	
	private static final long serialVersionUID = 6813726881716295793L;

	private String ShoppingUuid;
	/**查询条件*/
	private FitBaseSearchRequest request;
	/**下单用户信息**/
	private FitOrderCustomerDto customer;
	
	private FitOrderOperDto oper;
	/**购买人信息**/
	private FitOrderContacterDto contacter;
	/**乘客信息**/
	private List<FitOrderPassengerDto> passenger = new ArrayList<FitOrderPassengerDto>();
	/**去程航班搜索信息**/
	private FlightSearchResult<FlightSearchFlightInfoDto> toFlightInfos = new FlightSearchResult<FlightSearchFlightInfoDto>();
	/**返程航班搜索信息**/
	private FlightSearchResult<FlightSearchFlightInfoDto> backFlightInfos = new FlightSearchResult<FlightSearchFlightInfoDto>();
	/**选择酒店信息**/
	private HotelSearchResult<HotelSearchHotelDto> hotels  = new HotelSearchResult<HotelSearchHotelDto>();
	/**机票保险信息（作为机票的一部分存在）**/
	private List<InsuranceInfoDto> flightInsuranceInfos  = new ArrayList<InsuranceInfoDto>();
	/**景点门票信息**/
	private List<SpotSearchSpotDto> spots = new ArrayList<SpotSearchSpotDto>();
	/**保险信息**/
	private List<InsuranceDto> insurances = new ArrayList<InsuranceDto>();
	/**价格信息**/
	private FitOrderAmountDto amount;


	/**选择的去程机票信息*/
	private FlightSearchFlightInfoDto selectToFlight;
	/**选择的返程机票信息*/
	private FlightSearchFlightInfoDto selectBackFlight;
	/**选择的酒店信息*/
	private HotelSearchHotelDto selectHotel = new HotelSearchHotelDto();
	/**选择的门票信息*/
	private List<FitShoppingSelectedTicketDto> selectTicketInfo = new ArrayList<FitShoppingSelectedTicketDto>();
	/**选择的保险信息*/
	private List<FitShoppingSelectedInsuranceDto> selectInsuranceInfo = new ArrayList<FitShoppingSelectedInsuranceDto>();
	/**选择的机票保险信息*/
	private List<FlightInsuranceDto> selectFlightInsInfo = new ArrayList<FlightInsuranceDto>();

	private String requestKey;
	// 当从缓存中删除航意险后，避免初始化时，页面重新加载航意险。
	private boolean fliInsDelFlag = false;


	public String getShoppingUuid() {
		return ShoppingUuid;
	}

	public void setShoppingUuid(String shoppingUuid) {
		ShoppingUuid = shoppingUuid;
	}

	public FitBaseSearchRequest getSearchRequest() {
		return request;
	}

	public void setSearchRequest(FitBaseSearchRequest request) {
		this.request = request;
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

	public FlightSearchResult<FlightSearchFlightInfoDto> getToFlightInfos() {
		return toFlightInfos;
	}

	public void setToFlightInfos(FlightSearchResult<FlightSearchFlightInfoDto> toFlightInfos) {
		this.toFlightInfos = toFlightInfos;
	}

	public FlightSearchResult<FlightSearchFlightInfoDto> getBackFlightInfos() {
		return backFlightInfos;
	}

	public void setBackFlightInfos(FlightSearchResult<FlightSearchFlightInfoDto> backFlightInfos) {
		this.backFlightInfos = backFlightInfos;
	}

	public HotelSearchResult<HotelSearchHotelDto> getHotels() {
		return hotels;
	}

	public void setHotels(HotelSearchResult<HotelSearchHotelDto> hotels) {
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

	public List<InsuranceDto> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<InsuranceDto> insurances) {
		this.insurances = insurances;
	}

	public FitOrderAmountDto getAmount() {
		return amount;
	}

	public void setAmount(FitOrderAmountDto amount) {
		this.amount = amount;
	}

	public List<FitShoppingSelectedTicketDto> getSelectTicketInfo() {
		return selectTicketInfo;
	}

	public void setSelectTicketInfo(List<FitShoppingSelectedTicketDto> selectTicketInfo) {
		this.selectTicketInfo = selectTicketInfo;
	}

	public List<FitShoppingSelectedInsuranceDto> getSelectInsuranceInfo() {
		return selectInsuranceInfo;
	}

	public void setSelectInsuranceInfo(List<FitShoppingSelectedInsuranceDto> selectInsuranceInfo) {
		this.selectInsuranceInfo = selectInsuranceInfo;
	}

	public List<FlightInsuranceDto> getSelectFlightInsInfo() {
		return selectFlightInsInfo;
	}

	public void setSelectFlightInsInfo(List<FlightInsuranceDto> selectFlightInsInfo) {
		this.selectFlightInsInfo = selectFlightInsInfo;
	}

	public String getRequestKey() {
		return requestKey;
	}

	public void setRequestKey(String requestKey) {
		this.requestKey = requestKey;
	}

	public boolean isFliInsDelFlag() {
		return fliInsDelFlag;
	}

	public void setFliInsDelFlag(boolean fliInsDelFlag) {
		this.fliInsDelFlag = fliInsDelFlag;
	}

	public FlightSearchFlightInfoDto getSelectToFlight() {
		return selectToFlight;
	}

	public void setSelectToFlight(FlightSearchFlightInfoDto selectToFlight) {
		this.selectToFlight = selectToFlight;
	}

	public FlightSearchFlightInfoDto getSelectBackFlight() {
		return selectBackFlight;
	}

	public void setSelectBackFlight(FlightSearchFlightInfoDto selectBackFlight) {
		this.selectBackFlight = selectBackFlight;
	}

	public HotelSearchHotelDto getSelectHotel() {
		return selectHotel;
	}

	public void setSelectHotel(HotelSearchHotelDto selectHotel) {
		this.selectHotel = selectHotel;
	}

	public List<FlightSearchFlightInfoDto> getFlightInfos() {
		List<FlightSearchFlightInfoDto> flightInfoList = new ArrayList<FlightSearchFlightInfoDto>();
		flightInfoList.add(0, selectToFlight);
		if (request.getTripType().equals(TripeType.WF.name())) {
			flightInfoList.add(1, selectBackFlight);
		}
		return flightInfoList;
	}
}
