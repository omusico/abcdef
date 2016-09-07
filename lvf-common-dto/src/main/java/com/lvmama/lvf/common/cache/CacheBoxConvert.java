package com.lvmama.lvf.common.cache;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;

import com.lvmama.lvf.common.dto.adapter.response.SuppResponse;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.flight.FlightDayPriceAllInOneDto;
import com.lvmama.lvf.common.dto.search.FlightSearchResult;
import com.lvmama.lvf.common.dto.search.result.FlightSearchFlightInfoDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchTicketRuleDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchTicketRuleSimpleDto;
import com.lvmama.lvf.common.utils.JSONMapper;

public enum CacheBoxConvert {
	
	FlightSearchResult(new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {
	}),
	FlightSearchTicketRule(new TypeReference<FlightSearchTicketRuleDto>() {
	}),
	FlightSearchTicketRuleSimple(new TypeReference<FlightSearchTicketRuleSimpleDto>() {
	}),
	FlightDayPriceAllInOne(new TypeReference<List<FlightDayPriceAllInOneDto>>() {
	}),
	SuppResponsePata(new TypeReference<SuppResponse<List<FlightTicketPriceDto>>>() {
	});
	
	public TypeReference type;
	
	private CacheBoxConvert(TypeReference type) {
		this.type = type;
	}
	
	public <T> T convertTo(String json){
		try{
    		return JSONMapper
    				.getInstance()
    				.readValue(
    						json,type
    				);
		}catch(Exception ex){
			return null;
		}
	};
	
	public String convertFrom(Object obj){
		try{
    		return JSONMapper.getInstance().writeValueAsString(obj);
		}catch(Exception ex){
			return null;
		}
	};
	
}
