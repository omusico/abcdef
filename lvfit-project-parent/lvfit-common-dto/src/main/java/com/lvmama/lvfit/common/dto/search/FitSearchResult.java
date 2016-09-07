package com.lvmama.lvfit.common.dto.search;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
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
	
	//机票搜索结果
	private List<FlightSearchResult<FlightSearchFlightInfoDto>> flightSearchResult;
	
	//区分去程和返程
	private Map<String,List<FlightSearchFlightInfoDto>> distinctFlightMap = new HashMap<String,List<FlightSearchFlightInfoDto>>();
	
	//酒店搜索结果
	private List<HotelSearchResult<HotelSearchHotelDto>> hotelSearchResult;
	
	//门票搜索结果
	private List<SpotSearchResult<SpotSearchSpotDto>> spotSearchResult;
	
	//可用保险
	private InsuranceSearchResult<InsuranceDto> insuranceResult;
	
	//机票保险搜索结果
	private List<InsuranceInfoDto> flightInsuranceResult;

	//查询条件带回去
	private FitSearchRequest searchRequest;
	
	//默认推荐酒店id
	private String recomHotelId;
	
	public List<FlightSearchResult<FlightSearchFlightInfoDto>> getFlightSearchResult() {
		return flightSearchResult;
	}
	public void setFlightSearchResult(
			List<FlightSearchResult<FlightSearchFlightInfoDto>> flightSearchResult) {
		this.flightSearchResult = flightSearchResult;
	}
	public List<HotelSearchResult<HotelSearchHotelDto>> getHotelSearchResult() {
		return hotelSearchResult;
	}
	public void setHotelSearchResult(
			List<HotelSearchResult<HotelSearchHotelDto>> hotelSearchResult) {
		this.hotelSearchResult = hotelSearchResult;
	}
	public List<SpotSearchResult<SpotSearchSpotDto>> getSpotSearchResult() {
		return spotSearchResult;
	}
	public void setSpotSearchResult(
			List<SpotSearchResult<SpotSearchSpotDto>> spotSearchResult) {
		this.spotSearchResult = spotSearchResult;
	}
	public final InsuranceSearchResult<InsuranceDto> getInsuranceResult() {
		return insuranceResult;
	}
	public final void setInsuranceResult(InsuranceSearchResult<InsuranceDto> insuranceResult) {
		this.insuranceResult = insuranceResult;
	}
	public FitSearchRequest getSearchRequest() {
		return searchRequest;
	}
	public void setSearchRequest(FitSearchRequest searchRequest) {
		this.searchRequest = searchRequest;
	}
	public Map<String, List<FlightSearchFlightInfoDto>> getDistinctFlightMap() {
		return distinctFlightMap;
	}
	public void setDistinctFlightMap(
			Map<String, List<FlightSearchFlightInfoDto>> distinctFlightMap) {
		this.distinctFlightMap = distinctFlightMap;
	}
    public List<InsuranceInfoDto> getFlightInsuranceResult() {
        return flightInsuranceResult;
    }
    public void setFlightInsuranceResult(List<InsuranceInfoDto> flightInsuranceResult) {
        this.flightInsuranceResult = flightInsuranceResult;
    }
	public String getRecomHotelId() {
		return recomHotelId;
	}
	public void setRecomHotelId(String recomHotelId) {
		this.recomHotelId = recomHotelId;
	}
}
