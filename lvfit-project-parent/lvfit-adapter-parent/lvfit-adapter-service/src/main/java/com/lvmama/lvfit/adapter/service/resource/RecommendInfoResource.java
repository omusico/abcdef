package com.lvmama.lvfit.adapter.service.resource;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.adapter.search.adapter.RecommendInfoAdapter;
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.recommend.FitRecommendInfo;

@Component
@Path("")
public class RecommendInfoResource {

    @Autowired
    private RecommendInfoAdapter recommendInfoAdapter;
    
    @GET
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SearchClientPath.Path.RECOMMEND_INFO_SEARCH)
    public Response searchRecommendInfo(@PathParam("fromPlaceId") Long fromPlaceId) {
        Map<String, List<FitRecommendInfo>> map = recommendInfoAdapter.getRecommendInfoMap(fromPlaceId);
        return Response.ok(map).build();
    }
}
