package com.lvmama.lvf.common.dto.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.solr.json.base.criteria.annotation.SolrField;
import com.lvmama.lvf.common.solr.json.base.criteria.enums.SolrQueryTYPE;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.EnumAndNameCodeUtils;

@XmlRootElement
public class FlightSearchRecordRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 859720050070032921L;
	
	private FlightSearchRecordIndex flightSearchRecordIndex = new FlightSearchRecordIndex();
	
	private String selectTimeStart;
	
	private String selectTimeEnd;
	
	private String bookingSourceStr;
	
	private List<String> bookingSources;

	public FlightSearchRecordRequest() {
		super();
	}
	
	public FlightSearchRecordRequest(FlightSearchRecordIndex flightSearchRecordIndex) {
		super();
		this.flightSearchRecordIndex = flightSearchRecordIndex;
	}
	
	public String getBookingSourceStr() {
		return bookingSourceStr;
	}

	public void setBookingSourceStr(String bookingSourceStr) {
		this.bookingSourceStr = bookingSourceStr;
	}

	@SolrField(name="departureDate",type=SolrQueryTYPE.EQ)
	public String getDepartureDate() {
		return flightSearchRecordIndex.getDepartureDate();
	}

	@SolrField(name="departureCityCode",type=SolrQueryTYPE.EQ)
	public String getDepartureCityCode() {
		return flightSearchRecordIndex.getDepartureCityCode();
	}

	@SolrField(name="arrivalCityCode",type=SolrQueryTYPE.EQ)
	public String getArrivalCityCode() {
		return flightSearchRecordIndex.getArrivalCityCode();
	}
	
//	@SolrField(name="bookingSource",type=SolrQueryTYPE.EQ)
	public String getBookingSource() {
		return EnumAndNameCodeUtils.getName(flightSearchRecordIndex.getBookingSource());
	}
	
	@SolrField(name="isFlightSearch",type=SolrQueryTYPE.EQ)
	public String getIsFlightSearch() {
		if(null!=flightSearchRecordIndex.getIsFlightSearch()){
			return String.valueOf(flightSearchRecordIndex.getIsFlightSearch());
		}
		return null;
	}

	//@SolrField(name="selectDate",type=SolrQueryTYPE.EQ)
	public String getSelectDate() {
		return flightSearchRecordIndex.getSelectDate();
	}
	
	@SolrField(name="isHitCache",type=SolrQueryTYPE.EQ)
	public String getIsHitCache(){
		if (flightSearchRecordIndex.getIsHitCache() != null) {
			return String.valueOf(flightSearchRecordIndex.getIsHitCache());
		}
		return null;
	}
	
	@SolrField(name="selectTime",type=SolrQueryTYPE.BETWEEN)
	public Long getSelectTimeStartLong(){
		return DateUtils.parseCnHmDate(this.selectTimeStart).getTime();
	}
	
	public String getSelectTimeStart() {
		return selectTimeStart;
	}
	
	@SolrField(name="selectTime",type=SolrQueryTYPE.BETWEEN)
	public Long getSelectTimeEndLong(){
		return DateUtils.parseCnHmDate(this.selectTimeEnd).getTime();
	}
	
	public String getSelectTimeEnd() {
		return selectTimeEnd;
	}
	
	@SolrField(name="bookingSource",type=SolrQueryTYPE.IN)
	public List<String> getBookingSources() {
		List<String> bsList = new ArrayList<String>();
		if(StringUtils.isEmpty(this.bookingSourceStr)){
			for(BookingSource bs : BookingSource.values()){
				bsList.add(bs.name());
			}
		}else{
			bsList = Arrays.asList(this.bookingSourceStr.split(","));
		}
		return bsList;
	}

	public void setBookingSources(List<String> bookingSources) {
		this.bookingSources = bookingSources;
	}
	
	public void setDepartureDate(String departureDate) {
		flightSearchRecordIndex.setDepartureDate(departureDate);
	}
	
	public void setDepartureCityCode(String departureCityCode) {
		flightSearchRecordIndex.setDepartureCityCode(departureCityCode);
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		flightSearchRecordIndex.setArrivalCityCode(arrivalCityCode);
	}

	public void setBookingSource(BookingSource bookingsource) {
		flightSearchRecordIndex.setBookingSource(bookingsource);
	}

	public void setIsFlightSearch(Boolean isFlightSearch) {
		flightSearchRecordIndex.setIsFlightSearch(isFlightSearch);
	}

	public void setSelectDate(String selectDate) {
		flightSearchRecordIndex.setSelectDate(selectDate);
	}

	public void setIsHitCache(Boolean isHitCache){
		flightSearchRecordIndex.setIsHitCache(isHitCache);
	}

	public void setSelectTimeStart(String selectTimeStart) {
		this.selectTimeStart = selectTimeStart;
	}

	public void setSelectTimeEnd(String selectTimeEnd) {
		this.selectTimeEnd = selectTimeEnd;
	}

}
