package com.lvmama.lvfit.dp.service.resource;

import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.DpClientPath;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.dp.service.FitDpService;
import com.lvmama.lvfit.solrClient.extend.FitMainSearchSolrClient;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * 机票及酒店搜索 yueyufan
 * 
 * @date 2015-11-26
 */

@Component
@Path("")
public class FlightHotelResultResource {
    
    private static Logger logger = LoggerFactory.getLogger(FlightHotelResultResource.class);

    @Autowired
    FitDpService fitDpService;
    
    @Autowired
    FitMainSearchSolrClient fitMainSearchSolrClient;
    
    
    /**
	  * 用于获取产品选择页默认加载的信息
	  * 
	  * */
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(DpClientPath.Path.GET_SHOPPING_RESULT)
	public Response searchShoppingResult(FitBaseSearchRequest request) {
		 return Response.ok(fitDpService.search(request)).build();
	}
}
