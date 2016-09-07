package com.lvmama.lvfit.aggregate.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.aggregate.resource.spot.SpotService;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;



/**
 * 查询景点信息 Resource
 * @author leizhengwei
 *
 */
@Component
@Path("")
public class SpotSearchResource {
	
	@Autowired
	private SpotService spotService;

	 
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(AggregateClientPath.Path.SPOT_SEARCH)
	public Response searchSpot(SpotQueryRequest spotQueryRequest){
		 
		 SpotSearchResult<SpotSearchSpotDto> spotSearchResult =  spotService.searchSpot(spotQueryRequest);
		 return Response.ok(spotSearchResult).build();
	}
	 

}
