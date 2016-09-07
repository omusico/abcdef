package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;
import com.lvmama.lvf.common.solr.json.base.criteria.annotation.SolrField;
import com.lvmama.lvf.common.solr.json.base.criteria.enums.SolrQueryTYPE;
import com.lvmama.lvf.common.utils.DateUtils;

public class FlightDailyLowestPriceRequest implements Serializable {
	
	private static final long serialVersionUID = 3676510002714970739L;
	
	private FlightQueryRequest flightQueryRequest;

	public FlightDailyLowestPriceRequest() {
		super();
	}
	
	public FlightDailyLowestPriceRequest(FlightQueryRequest flightQueryRequest) {
		super();
		this.flightQueryRequest = flightQueryRequest;
	}

	@SolrField(name = "departureCityCode", type=SolrQueryTYPE.EQ)
	public String getDepartureCityCode(){
		return flightQueryRequest.getDepartureCityCode();
	}

	@SolrField(name = "arrivalCityCode", type=SolrQueryTYPE.EQ)
	public String getArrivalCityCode() {
		return flightQueryRequest.getArrivalCityCode();
	}
	
	@SolrField(name = "departureDate", type=SolrQueryTYPE.EQ)
	public String getDepartureDate(){
		return DateUtils.formatDate(flightQueryRequest.getDepartureDate());
	}
	
}
