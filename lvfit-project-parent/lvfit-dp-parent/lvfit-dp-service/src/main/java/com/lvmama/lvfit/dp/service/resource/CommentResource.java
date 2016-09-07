package com.lvmama.lvfit.dp.service.resource;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.common.client.path.DpClientPath;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.dp.comment.service.CommentService;

@Component
@Path("")
public class CommentResource {
	
	@Autowired
	private CommentService commentService;
    
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(DpClientPath.Path.QUERY_COMMENT_PAGE)
	public Response  queryHotelCommentPageList(
			FitCommentRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		 FitCommentDto fitCommentDto = commentService.getCommentPage(request);
		  return Response.ok(fitCommentDto).build();
	 }
}
