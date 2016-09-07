package com.lvmama.lvfit.adapter.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.adapter.vst.adapter.CommHeaderServiceAdapter;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.request.CommHeaderRequest;

@Component
@Path("")
public class CommHeaderResource {
	
	private static final Logger logger = LoggerFactory.getLogger(CommHeaderResource.class);
	
	 @Autowired
	 private CommHeaderServiceAdapter commHeaderServiceAdapter;
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(VstClientPath.Path.GET_COMM_HEADER)
    public Response getCommHeaderText(CommHeaderRequest commHeaderRequest)  {
        return Response.ok(commHeaderServiceAdapter.getCommHead(commHeaderRequest)).build();
    }

	
}
