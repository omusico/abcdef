package com.lvmama.lvf.common.dto.search;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.form.Form;
/**
 * 航班记录查询结果FORMBEAN
 * @author lizongze
 *
 */
public class FlightSearchRecordResultForm implements Serializable,Form{

	private static final long serialVersionUID = 7069995127378137488L;

	private FlightSearchRecordIndex flightSearchRecordIndex;

	public FlightSearchRecordResultForm() {}
	
	public FlightSearchRecordResultForm(FlightSearchRecordIndex recordIndex) {
		this.flightSearchRecordIndex = recordIndex;
	}
	
	public FlightSearchRecordIndex getFlightSearchRecordIndex() {
		return flightSearchRecordIndex;
	}

	public String getIndexId() {
		return flightSearchRecordIndex.getIndexId();
	}

	public String getSelectDate() {
		return flightSearchRecordIndex.getSelectDate();
	}

	public Long getSelectTime() {
		return flightSearchRecordIndex.getSelectTime();
	}

	public String getDepartureCityCode() {
		return flightSearchRecordIndex.getDepartureCityCode();
	}

	public Boolean getIsFlightSearch() {
		return flightSearchRecordIndex.getIsFlightSearch();
	}

	public String getArrivalCityCode() {
		return flightSearchRecordIndex.getArrivalCityCode();
	}

	public String getDepartureDate() {
		return flightSearchRecordIndex.getDepartureDate();
	}

	public ResultStatus getResultStatus() {
		return flightSearchRecordIndex.getResultStatus();
	}

	public Long getUsedTime() {
		return flightSearchRecordIndex.getUsedTime();
	}

	public Integer getReturnCount() {
		return flightSearchRecordIndex.getReturnCount();
	}

	public BookingSource getBookingSource() {
		return flightSearchRecordIndex.getBookingSource();
	}

	public String getCustomerId() {
		return flightSearchRecordIndex.getCustomerId();
	}

	public Boolean getIsHitCache() {
		return flightSearchRecordIndex.getIsHitCache();
	}

	public String getCustomerCode() {
		return flightSearchRecordIndex.getCustomerCode();
	}

	public String getCustomerName() {
		return flightSearchRecordIndex.getCustomerName();
	}

	public String getCustomerIp() {
		return flightSearchRecordIndex.getCustomerIp();
	}
	
	

	public void setFlightSearchRecordIndex(
			FlightSearchRecordIndex flightSearchRecordIndex) {
		this.flightSearchRecordIndex = flightSearchRecordIndex;
	}
	
}
