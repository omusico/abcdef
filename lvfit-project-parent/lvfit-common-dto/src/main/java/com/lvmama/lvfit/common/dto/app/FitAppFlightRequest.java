package com.lvmama.lvfit.common.dto.app;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.TripeType;

import java.io.Serializable;
import java.util.Date;

/**
 * 更换航班查询独享
 */
public class FitAppFlightRequest implements Serializable{

	private static final long serialVersionUID = 2562363814071499389L;

	/**出发日期YYYY-MM-DD*/
	private String departureDate;
	/**返程日期YYYY-MM-DD*/
	private String returnDate;
	/**出发城市code*/
	private String depCityCode;
	/**到达城市code*/
	private String arvCityCode;
	/**bookingsource*/
	private BookingSource bookingSource;
	/**航程类型*/
    private TripeType tripeType;
	/**成人数*/
	private int adultCount;
	/**儿童数*/
	private int childCount;

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getDepCityCode() {
		return depCityCode;
	}

	public void setDepCityCode(String depCityCode) {
		this.depCityCode = depCityCode;
	}

	public String getArvCityCode() {
		return arvCityCode;
	}

	public void setArvCityCode(String arvCityCode) {
		this.arvCityCode = arvCityCode;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public TripeType getTripeType() {
		return tripeType;
	}

	public void setTripeType(TripeType tripeType) {
		this.tripeType = tripeType;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
}






