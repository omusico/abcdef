package com.lvmama.lvfit.common.dto.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.request.FlightBackQueryRequest;
import com.lvmama.lvfit.common.dto.request.FlightToQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;

public class FitSearchRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5388774510727443668L;
	// 去程机票请求
	private FlightToQueryRequest flightToQueryRequest;
	// 返程机票请求
	private FlightBackQueryRequest flightBackQueryRequest;
	// 酒店搜索条件列表
	private HotelQueryRequest hotelSearchRequests;
	//景点搜索条件列表
	private SpotQueryRequest spotQueryRequests;
	//保险搜索条件列表
	private InsuranceQueryRequest insuranceQueryRequest ;
	// 人数
	private FitPassengerRequest fitPassengerRequest;
	// 来源
	private BookingSource bookingSource = BookingSource.DEFAULT;
	
	//shoppingId
	private String shoppingId;


	//以下两个字段，用于重新回到产品选择页时，重新load原始搜索条件中的form
	//目的地
	private String arrivalCityName;
	//出发地
	private String departureCityName;

	//旅行类型
	private String tripType;
	
	//请求key
	private String requestKey;
	
	public static String createUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}

	public FlightToQueryRequest getFlightToQueryRequest() {
		return flightToQueryRequest;
	}

	public void setFlightToQueryRequest(FlightToQueryRequest flightToQueryRequest) {
		this.flightToQueryRequest = flightToQueryRequest;
	}

	public FlightBackQueryRequest getFlightBackQueryRequest() {
		return flightBackQueryRequest;
	}

	public void setFlightBackQueryRequest(FlightBackQueryRequest flightBackQueryRequest) {
		this.flightBackQueryRequest = flightBackQueryRequest;
	}

	public HotelQueryRequest getHotelSearchRequests() {
		return hotelSearchRequests;
	}
	public void setHotelSearchRequests(HotelQueryRequest hotelSearchRequests) {
		this.hotelSearchRequests = hotelSearchRequests;
	}
	public SpotQueryRequest getSpotQueryRequests() {
		return spotQueryRequests;
	}

	public void setSpotQueryRequests(SpotQueryRequest spotQueryRequests) {
		this.spotQueryRequests = spotQueryRequests;
	}

	public final InsuranceQueryRequest getInsuranceQueryRequest() {
		return insuranceQueryRequest;
	}

	public final void setInsuranceQueryRequest(
			InsuranceQueryRequest insuranceQueryRequest) {
		this.insuranceQueryRequest = insuranceQueryRequest;
	}

	public FitPassengerRequest getFitPassengerRequest() {
		return fitPassengerRequest;
	}
	public void setFitPassengerRequest(FitPassengerRequest fitPassengerRequest) {
		this.fitPassengerRequest = fitPassengerRequest;
	}
	public BookingSource getBookingSource() {
		return bookingSource;
	}
	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}
	public String getShoppingId() {
		return shoppingId;
	}
	public void setShoppingId(String shoppingId) {
		this.shoppingId = shoppingId;
	}
	public String getArrivalCityName() {
		return arrivalCityName;
	}
	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
	}
	public String getDepartureCityName() {
		return departureCityName;
	}
	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

}
