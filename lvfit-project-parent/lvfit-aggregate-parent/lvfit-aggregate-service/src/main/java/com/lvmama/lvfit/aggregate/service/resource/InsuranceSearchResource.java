package com.lvmama.lvfit.aggregate.service.resource;

import java.io.IOException;
import java.util.List;

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

import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.aggregate.resource.insurance.service.InsuranceService;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;


/**
 * 查询保险
 * yueyufan
 * @date 2015-12-03
 */

@Component
@Path("")
public class InsuranceSearchResource {
	
	@Autowired
	InsuranceService insuranceService;
	
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(AggregateClientPath.Path.INSURANCE_SEARCH)
	public Response searchInsuranceFromVst(InsuranceQueryRequest request){
		 InsuranceSearchResult<InsuranceDto> insuranceResult =  insuranceService.searchInsuranceFromVst(request);
		 return Response.ok(insuranceResult).build();
		
	}
	 
}
