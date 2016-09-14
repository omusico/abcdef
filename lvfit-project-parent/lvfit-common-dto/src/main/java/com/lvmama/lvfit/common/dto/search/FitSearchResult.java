package com.lvmama.lvfit.common.dto.search;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;


public class FitSearchResult implements Serializable,Form{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1813842723984560591L;
	
	//区分去程和返程
	private Map<String, FlightSearchResult<FlightSearchFlightInfoDto>> distinctFlightMap = new HashMap<String, FlightSearchResult<FlightSearchFlightInfoDto>>();
	
	//酒店搜索结果
	private HotelSearchResult<HotelSearchHotelDto> hotelSearchResult;
	
	//门票搜索结果
	private List<SpotSearchSpotDto> spotSearchResult;
	
	//可用保险
	private List<InsuranceDto> insuranceResult;
	
	//机票保险搜索结果
	private List<InsuranceInfoDto> flightInsuranceResult;

	public HotelSearchResult<HotelSearchHotelDto> getHotelSearchResult() {
		return hotelSearchResult;
	}
	public void setHotelSearchResult(
			HotelSearchResult<HotelSearchHotelDto> hotelSearchResult) {
		this.hotelSearchResult = hotelSearchResult;
	}
	public List<SpotSearchSpotDto> getSpotSearchResult() {
		return spotSearchResult;
	}
	public void setSpotSearchResult(
			List<SpotSearchSpotDto> spotSearchResult) {
		this.spotSearchResult = spotSearchResult;
	}
	public final List<InsuranceDto> getInsuranceResult() {
		return insuranceResult;
	}
	public final void setInsuranceResult(List<InsuranceDto> insuranceResult) {
		this.insuranceResult = insuranceResult;
	}
    public List<InsuranceInfoDto> getFlightInsuranceResult() {
        return flightInsuranceResult;
    }
    public void setFlightInsuranceResult(List<InsuranceInfoDto> flightInsuranceResult) {
        this.flightInsuranceResult = flightInsuranceResult;
    }

	public Map<String, FlightSearchResult<FlightSearchFlightInfoDto>> getDistinctFlightMap() {
		return distinctFlightMap;
	}

	public void setDistinctFlightMap(
		Map<String, FlightSearchResult<FlightSearchFlightInfoDto>> distinctFlightMap) {
		this.distinctFlightMap = distinctFlightMap;
	}
}
