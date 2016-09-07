package com.lvmama.lvfit.sdp.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.common.client.path.SdpClientPath;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.sdp.booking.service.FitSdpBookingService;


@Component
@Path("")
public class FitSdpBookingResource {

	@Autowired
	private FitSdpBookingService fitSdpBookingService;

	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(SdpClientPath.Path.BOOKING)
	 public Response booking(FitOrderBookingRequest bookingRequest) {
		return Response.ok(fitSdpBookingService.booking(bookingRequest)).build();
	 }
	 
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(SdpClientPath.Path.BOOKING_BY_DETAIL)
	 public Response bookingByDetail(FitOrderBookingRequest bookingRequest) {
		return Response.ok(fitSdpBookingService.bookingByDetail(bookingRequest)).build();
	 }
}
