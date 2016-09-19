package com.lvmama.lvfit.dp.service.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.client.path.DpClientPath;
import com.lvmama.lvfit.common.dto.config.FitConRecomHotelConfig;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.dp.hotel.service.HotelDetailDpService;
import com.lvmama.lvfit.dp.service.FitDpService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;

/**
 * 更换酒店的搜索
 * yueyufan
 * @date 2015-11-26
 */

@Component
@Path("")
public class HotelResource {
	private static Logger logger = Logger.getLogger(HotelResource.class);
	@Autowired
	FitDpService fitDpService;
	
	@Autowired
	HotelDetailDpService hotelDetailDpService;
	
	@Autowired
	ShoppingService shoppingService;
	
	@Autowired
	FitBusinessClient fitBusinessClient;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.GET_HOTEL_DETAIL)
	public Response  queryHotelCommentPageList(FitHotelRequest request) 
			throws JsonGenerationException, JsonMappingException, IOException{
		  FitHotelDto fitHotelDto = hotelDetailDpService.getHotelDetail(request);
		  return Response.ok(fitHotelDto).build();
	 }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.GET_RECOM_HOTEL_BY_DISTRICT_ID)
	public Response getRecommendHotelsByDistrictId(Long districtId) {
		List<FitConRecomHotelDto> list = FitConRecomHotelConfig.dbMaps.get(districtId);
		return Response.ok(list).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.GET_HOTEL_INFOS)
	public Response searchHotelInfos(FitAppHotelRequest request) {
		return Response.ok(fitDpService.searchHotelInfos(request)).build();
	}
}
