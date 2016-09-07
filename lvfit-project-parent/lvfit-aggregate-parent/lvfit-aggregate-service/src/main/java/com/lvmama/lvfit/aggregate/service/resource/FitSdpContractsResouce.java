package com.lvmama.lvfit.aggregate.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.aggregate.sdp.service.FitSdpContractsService;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;

@Component
@Path("")
public class FitSdpContractsResouce {
	 
	@Autowired
	 private FitSdpContractsService fitSdpContractsService;
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(AggregateClientPath.Path.CONTRACTS)
	public Response getContracts(FitOrderBookingRequest req){
		 BaseSingleResultDto<String> contractHtml = new BaseSingleResultDto<String>();
		 contractHtml = fitSdpContractsService.getContractsHtml(req);
		 return Response.ok(contractHtml).build();
		
	}
}
