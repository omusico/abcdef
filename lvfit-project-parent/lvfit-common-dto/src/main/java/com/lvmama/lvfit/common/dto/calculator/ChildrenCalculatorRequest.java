package com.lvmama.lvfit.common.dto.calculator;

import java.util.Date;

import com.lvmama.lvfit.common.dto.enums.BookingSource;

/**
 * 
 * 
 * @author leizhengwei
 * 2015年8月21日
 */
public class ChildrenCalculatorRequest {

	private BookingSource bookingSource;
	
	private String adultFlightNo;
	
	private String adultSeatCode;
	
	private Long adultPolicyId;
	
	private Date depDate;
	
	private String depCityCode;
	
	private String arrCityCode;
	
	private Long pricePolicyId;
	
	private Long versionNo;

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public String getAdultFlightNo() {
		return adultFlightNo;
	}

	public void setAdultFlightNo(String adultFlightNo) {
		this.adultFlightNo = adultFlightNo;
	}

	public String getAdultSeatCode() {
		return adultSeatCode;
	}

	public void setAdultSeatCode(String adultSeatCode) {
		this.adultSeatCode = adultSeatCode;
	}

	public Long getAdultPolicyId() {
		return adultPolicyId;
	}

	public void setAdultPolicyId(Long adultPolicyId) {
		this.adultPolicyId = adultPolicyId;
	}

	public Date getDepDate() {
		return depDate;
	}

	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}

	public String getDepCityCode() {
		return depCityCode;
	}

	public void setDepCityCode(String depCityCode) {
		this.depCityCode = depCityCode;
	}

	public String getArrCityCode() {
		return arrCityCode;
	}

	public void setArrCityCode(String arrCityCode) {
		this.arrCityCode = arrCityCode;
	}

	public Long getPricePolicyId() {
		return pricePolicyId;
	}

	public void setPricePolicyId(Long pricePolicyId) {
		this.pricePolicyId = pricePolicyId;
	}

	public Long getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}
	
	
	
}
 
