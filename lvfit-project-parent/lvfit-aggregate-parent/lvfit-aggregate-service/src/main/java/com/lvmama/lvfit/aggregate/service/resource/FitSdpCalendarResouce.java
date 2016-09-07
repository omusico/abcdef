package com.lvmama.lvfit.aggregate.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.aggregate.sdp.service.FitSdpCalendarService;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductGroupQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;

@Component
@Path("")
public class FitSdpCalendarResouce {
	 
	@Autowired
	 private FitSdpCalendarService productCalendarService;
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(AggregateClientPath.Path.PRODUCT_CALENDAR_SEARCH)
	public Response findProdGroupDateByParam(FitSdpProductGroupQueryRequest fitProductGroupQueryRequest){
		 
		 FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> productCalendarResutl = productCalendarService.findProdGroupDateByParam(fitProductGroupQueryRequest);
		 return Response.ok(productCalendarResutl).build();
		
	}
}
