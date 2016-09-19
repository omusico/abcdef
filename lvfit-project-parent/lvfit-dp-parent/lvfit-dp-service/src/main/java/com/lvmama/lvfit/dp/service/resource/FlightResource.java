package com.lvmama.lvfit.dp.service.resource;

import java.io.IOException;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lvmama.lvfit.common.dto.app.FitAppFlightRequest;
import com.lvmama.lvfit.common.dto.request.FitFilterFlightRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.DpClientPath;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.dp.service.FitDpService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;



/**
 * 更换航班的搜索
 *
 * @author zhoubinbin
 * @date 2015年12月8日
 */
@Component
@Path("")
public class FlightResource {
	
	private static Logger logger = LoggerFactory.getLogger(FlightResource.class);	

	
	@Autowired
	private FitDpService fitDpService;


	/**
	 * 获取航班信息
	 * */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.GET_FLIGHT_INFOS)
	public Response getAllFlightInfos(FitAppFlightRequest request) {
		Map<String, FlightSearchResult<FlightSearchFlightInfoDto>> allFlightInfos = fitDpService
			.getAllFlightInfos(request.getTripeType(), request.getDepartureDate(),
				request.getReturnDate(), request.getDepCityCode(), request.getArvCityCode(),
				request.getBookingSource());
		return Response.ok(allFlightInfos).build();
	}

	/**
	 * 获取航班信息
	 * */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.GET_FLIGHT_INFOS_BY_CONDITION)
	public Response getFilteredFlightInfos(FitFilterFlightRequest request) {
		return Response.ok(fitDpService.getFlightInfos(request)).build();
	}
}
