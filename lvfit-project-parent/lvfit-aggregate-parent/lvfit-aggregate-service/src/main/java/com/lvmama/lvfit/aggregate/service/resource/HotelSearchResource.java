package com.lvmama.lvfit.aggregate.service.resource;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.aggregate.resource.flight.service.FlightService;
import com.lvmama.lvfit.aggregate.resource.hotel.service.HotelService;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;


/**
 * 查询航班信息
 * yueyufan
 * @date 2015-11-28
 */

@Component
@Path("")
public class HotelSearchResource {
	
	@Autowired
	HotelService hotelService;

	 
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(AggregateClientPath.Path.HOTEL_SEARCH)
	public Response searchHotelInfo(HotelQueryRequest hotelQueryRequest){
		 
		 HotelSearchResult hotelSearchResult =  hotelService.searchHotel(hotelQueryRequest);
		
		 return Response.ok(hotelSearchResult).build();
		
	}
	 
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException{
		HotelQueryRequest hotelQueryRequest = new HotelQueryRequest();
		hotelQueryRequest.setCityCode("U9");
		hotelQueryRequest.setDepartureDate("C20151220");
		hotelQueryRequest.setReturnDate("O20151226");
		hotelQueryRequest.setKeywords("上海");
		
	System.out.println(AggregateClientPath.Path.HOTEL_SEARCH);
	
}
}
