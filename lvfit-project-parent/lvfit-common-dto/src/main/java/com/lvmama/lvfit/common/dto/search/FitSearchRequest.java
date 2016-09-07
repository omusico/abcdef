package com.lvmama.lvfit.common.dto.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;

public class FitSearchRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5388774510727443668L;
	// 机票搜索条件列表
	private List<FlightQueryRequest> flightSearchRequests = new ArrayList<FlightQueryRequest>();
	// 酒店搜索条件列表
	private List<HotelQueryRequest> hotelSearchRequests = new ArrayList<HotelQueryRequest>();
	//景点搜索条件列表
	private List<SpotQueryRequest> spotQueryRequests = new ArrayList<SpotQueryRequest>();
	//保险搜索条件列表
	private InsuranceQueryRequest insuranceQueryRequest ;
	// 人数
	private FitPassengerRequest fitPassengerRequest;
	// 来源
	private BookingSource bookingSource = BookingSource.DEFAULT;
	
	
	//标识去程返程,此字段用于标识航班是去程还是返程，当为to是，为去程，为back时，为返程
	private String backOrto;
	
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
	
	public List<FlightQueryRequest> getFlightSearchRequests() {
		return flightSearchRequests;
	}
	public void setFlightSearchRequests(
			List<FlightQueryRequest> flightSearchRequests) {
		this.flightSearchRequests = flightSearchRequests;
	}
	public List<HotelQueryRequest> getHotelSearchRequests() {
		return hotelSearchRequests;
	}
	public void setHotelSearchRequests(List<HotelQueryRequest> hotelSearchRequests) {
		this.hotelSearchRequests = hotelSearchRequests;
	}
	public List<SpotQueryRequest> getSpotQueryRequests() {
		return spotQueryRequests;
	}

	public void setSpotQueryRequests(List<SpotQueryRequest> spotQueryRequests) {
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
	public String getBackOrto() {
		return backOrto;
	}
	public void setBackOrto(String backOrto) {
		this.backOrto = backOrto;
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
