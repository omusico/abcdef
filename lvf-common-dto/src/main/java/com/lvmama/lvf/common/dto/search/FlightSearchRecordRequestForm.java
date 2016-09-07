package com.lvmama.lvf.common.dto.search;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.BookingSource;

public class FlightSearchRecordRequestForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4529755456302976811L;
	
	
	private FlightSearchRecordRequest flightSearchRecordRequest = new FlightSearchRecordRequest();
	
	private Pagination pagination = new Pagination();
	
	private String isFlightSearchStr;
	
	public String getIsFlightSearchStr() {
		return isFlightSearchStr;
	}

	public void setIsFlightSearchStr(String isFlightSearchStr) {
		this.isFlightSearchStr = isFlightSearchStr;
	}

	public FlightSearchRecordRequest getFlightSearchRecordRequest() {
//		if(StringUtils.isNotBlank(flightSearchRecordRequest.getBookingSourceStr())){
//			flightSearchRecordRequest.setBookingSource(BookingSource.valueOf(flightSearchRecordRequest.getBookingSourceStr()));
//		}
		if(StringUtils.isNotBlank(this.getIsFlightSearchStr())){
			flightSearchRecordRequest.setIsFlightSearch(Boolean.valueOf(this.getIsFlightSearchStr()));
		}
		
		return flightSearchRecordRequest;
	}

	public String getBookingSourceStr() {
		return flightSearchRecordRequest.getBookingSourceStr();
	}

	public void setBookingSourceStr(String bookingSourceStr) {
		flightSearchRecordRequest.setBookingSourceStr(bookingSourceStr);
	}

	public void setFlightSearchRecordRequest(
			FlightSearchRecordRequest flightSearchRecordRequest) {
		this.flightSearchRecordRequest = flightSearchRecordRequest;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getDepartureDate() {
		return flightSearchRecordRequest.getDepartureDate();
	}

	public String getDepartureCityCode() {
		return flightSearchRecordRequest.getDepartureCityCode();
	}

	public String getArrivalCityCode() {
		return flightSearchRecordRequest.getArrivalCityCode();
	}

	public void setDepartureDate(String departureDate) {
		flightSearchRecordRequest.setDepartureDate(departureDate);
	}

	public void setDepartureCityCode(String departureCityCode) {
		flightSearchRecordRequest.setDepartureCityCode(departureCityCode);
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		flightSearchRecordRequest.setArrivalCityCode(arrivalCityCode);
	}
	public String getBookingSource() {
		return flightSearchRecordRequest.getBookingSource();
	}

	public void setBookingSource(BookingSource bookingsource) {
		flightSearchRecordRequest.setBookingSource(bookingsource);
	}

	public String getIsFlightSearch() {
		return flightSearchRecordRequest.getIsFlightSearch();
	}

	public void setIsFlightSearch(Boolean isFlightSearch) {
		flightSearchRecordRequest.setIsFlightSearch(isFlightSearch);
	}

	public String getSelectDate() {
		return flightSearchRecordRequest.getSelectDate();
	}

	public void setSelectDate(String selectDate) {
		flightSearchRecordRequest.setSelectDate(selectDate);
	}

	public void setIsHitCache(Boolean isHitCache){
		flightSearchRecordRequest.setIsHitCache(isHitCache);
	}

	public String getSelectTimeStart() {
		return flightSearchRecordRequest.getSelectTimeStart();
	}

	public String getSelectTimeEnd() {
		return flightSearchRecordRequest.getSelectTimeEnd();
	}

	public void setSelectTimeStart(String selectTimeStart) {
		flightSearchRecordRequest.setSelectTimeStart(selectTimeStart);
	}

	public void setSelectTimeEnd(String selectTimeEnd) {
		flightSearchRecordRequest.setSelectTimeEnd(selectTimeEnd);
	}

	//---------pagination相关-------
	public int getPage() {
        return pagination.getPage();
    }

    public void setPage(int page) {
        pagination.setPage(page);
    }

    public int getRows() {
        return pagination.getRows();
    }

    public void setRows(int rows) {
        pagination.setRows(rows);
    }

    public int getRecords() {
        return pagination.getRecords();
    }

    public void setRecords(int records) {
        pagination.setRecords(records);
    }

    public void countRecords(int records) {
        pagination.countRecords(records);
    }

    public int getTotal() {
        return pagination.getTotal();
    }

    public void setTotal(int total) {
        pagination.setTotal(total);
    }

    public String getSidx() {
        return pagination.getSidx();
    }

    public void setSidx(String sidx) {
        pagination.setSidx(sidx);
    }

    public String getSord() {
        return pagination.getSord();
    }

    public void setSord(String sord) {
        pagination.setSord(sord);
    }

    public int getStartRow() {
        return pagination.getStartRow();
    }

    public int getEndRow() {
        return pagination.getEndRow();
    }

    public boolean isSearch() {
        return pagination.isSearch();
    }

    public void setSearch(boolean search) {
        pagination.setSearch(search);
    }
    //---------pagination相关-------
}
