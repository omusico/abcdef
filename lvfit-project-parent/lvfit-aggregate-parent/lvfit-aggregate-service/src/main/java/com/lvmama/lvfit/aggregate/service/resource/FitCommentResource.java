package com.lvmama.lvfit.aggregate.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.aggregate.hotel.service.FitCommentService;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;


/**
 * 查询点评信息
 * zengzhimin
 * @date 2015-12-06
 */

@Component
@Path("")
public class FitCommentResource {
	
	@Autowired
	private FitCommentService fitCommentService;
	
	
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(AggregateClientPath.Path.COMMENT_QUERY)
	public Response  getCommentPage( FitCommentRequest request){
		 
		 FitCommentDto  fitCommentDto=  fitCommentService.getCommentPage(request);
		 return Response.ok(fitCommentDto).build();
		
	}
	 
	 

}
