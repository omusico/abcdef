package com.lvmama.lvfit.aggregate.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvfit.aggregate.resource.flight.service.FlightService;
import com.lvmama.lvfit.aggregate.resource.hotel.service.HotelService;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.request.FlightInsuranceRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;


/**
 * 查询航班信息
 * yueyufan
 * @date 2015-11-24
 */

@Component
@Path("")
public class FlightSearchResource {

    @Autowired
    FlightService flightService;


    @Autowired
    HotelService hotelService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(AggregateClientPath.Path.FLIGHT_INFO_SEARCH)
    public Response searchFlightInfo(FlightQueryRequest request) {
        FlightSearchResult<FlightSearchFlightInfoDto> flightSearchResult = flightService.searchFlightInfo(request, true);
        return Response.ok(flightSearchResult).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(AggregateClientPath.Path.FLIGHT_INSURANCE_SEARCH)
    public Response searchFlightInfo() {
        FlightInsuranceRequest req = new FlightInsuranceRequest();
        req.setStatus(Status.VALID);
        List<InsuranceInfoDto> insurances = flightService.viewValidFlightInsurances(req);
        return Response.ok(insurances).build();
    }
}
