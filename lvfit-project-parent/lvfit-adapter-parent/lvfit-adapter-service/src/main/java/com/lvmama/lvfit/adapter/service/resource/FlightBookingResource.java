package com.lvmama.lvfit.adapter.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.adapter.flight.adapter.FlightBookingAdapter;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.adapter.request.FlightBookingRequest;

@Component
@Path("")
public class FlightBookingResource {

    @Autowired
    private FlightBookingAdapter flightBookingAdapter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(VstClientPath.Path.FLIGHT_BOOKING)
    public Response flightBooking(FlightBookingRequest request) {
        return Response.ok(flightBookingAdapter.booking(request)).build();
    }

}
