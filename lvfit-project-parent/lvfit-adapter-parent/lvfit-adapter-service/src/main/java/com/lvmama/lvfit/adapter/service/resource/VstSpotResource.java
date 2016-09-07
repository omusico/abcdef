package com.lvmama.lvfit.adapter.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.adapter.search.adapter.SpotSearchAdapter;
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;



@Component
@Path("")
public class VstSpotResource {
	
	
	private static final Logger logger = LoggerFactory.getLogger(VstSpotResource.class);
	
	@Autowired
	private SpotSearchAdapter spotSearchAdapter;
	
	
	/**
	 * 调用主站搜索接口获取景点数据
	 * @param spotQueryRequest
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SearchClientPath.Path.SPOT_LIST_SEARCH)
	public Response searchSpot(SpotQueryRequest spotQueryRequest) {
		//http://localhost:8091/spot/search,{"hotelId":"7758","distance":10.0,"size":5,"sortNum":27}
		SpotSearchResult<SpotSearchSpotDto> searchSpot = new SpotSearchResult<SpotSearchSpotDto>();
		try {
			searchSpot = spotSearchAdapter.searchSpot(spotQueryRequest);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new RuntimeException(e);
		}
		return Response.ok(searchSpot).build();
	}
	
}
