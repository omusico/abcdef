/**
 * Project Name:lvfit-aggregate-service
 * File Name:FitHotelDetailResource.java
 * Package Name:com.lvmama.lvfit.aggregate.service.resource
 * Date:2015-12-6下午8:56:01
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.aggregate.service.resource;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.aggregate.hotel.service.FitHotelDetailService;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;

/**
 * ClassName:FitHotelDetailResource <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-6 下午8:56:01 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */

@Component
@Path("")
public class FitHotelDetailResource {
	@Autowired
	private FitHotelDetailService fitHotelDetailService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(AggregateClientPath.Path.HOTEL_DETAIL)
	public Response  getCommentPage(FitHotelRequest request) throws JsonParseException, JsonMappingException, IOException{
		 FitHotelDto  fitHotelDto=  fitHotelDetailService.getHotelDetail(request);
		 return Response.ok(fitHotelDto).build();
		
	}
	 
}

