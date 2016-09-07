package com.lvmama.lvfit.dp.service.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvfit.common.client.path.DpClientPath;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;
import com.lvmama.lvfit.dp.booking.service.FitBookingService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingViewService;

@Component
@Path("")
public class BookingResource {

    @Autowired
    private FitBookingService fitBookingService;
    
    @Autowired
    private ShoppingViewService shoppingViewService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(DpClientPath.Path.BOOKING)
    public Response booking(FitOrderBookingRequest fit) {
        return Response.ok(fitBookingService.booking(fit)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(DpClientPath.Path.RECORD_BOOKING_LOG_NO_LOGIN)
    public Response recordBookingLogNoLogin(String shoppingUUID) {
    	
    	BaseSingleResultDto<FitShoppingDto> resultDto =  shoppingViewService.getShoppingByShoppingUUID(shoppingUUID);
    	if(resultDto.getStatus()==ResultStatus.SUCCESS){
    		FitShoppingDto shoppingDto = resultDto.getResult();
    		FitOpLogTraceContext.setFitOpLog(shoppingDto.getSearchRequest(), null, TraceContext.getTraceId(), FitBusinessExceptionType.RECORD_BOOKING_LOG_NO_LOGIN);
    	}
        return Response.ok(ResultStatus.SUCCESS.name()).build();
    }


}
