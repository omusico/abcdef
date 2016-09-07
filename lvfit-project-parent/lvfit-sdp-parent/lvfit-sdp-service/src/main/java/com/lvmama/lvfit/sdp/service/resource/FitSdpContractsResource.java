package com.lvmama.lvfit.sdp.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.client.path.SdpClientPath;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.sdp.core.service.FitSdpContractsService;

@Component
@Path("")
public class FitSdpContractsResource {
	
	@Autowired
	private FitSdpContractsService fitSdpContractsService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SdpClientPath.Path.CONTRACTS)
	public Response getContractsHtml(FitOrderBookingRequest bookingRequest) {
		BaseSingleResultDto<String> contractsHtml = new BaseSingleResultDto<String>();
		contractsHtml = fitSdpContractsService.getContractsHtml(bookingRequest);
		return Response.ok(contractsHtml).build();
	}
}
