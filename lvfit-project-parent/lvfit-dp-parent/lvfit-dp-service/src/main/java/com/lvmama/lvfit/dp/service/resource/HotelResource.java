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
	@Path(DpClientPath.Path.GET_HOTEL_LIST_CACHE)
	public Response searchHotelCache(String uuid) throws JsonGenerationException, JsonMappingException, IOException{
		 List<HotelSearchHotelDto> hotels =  shoppingService.getHotelSearchResult(uuid);
		 return Response.ok(hotels).build();
	}
	
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
	
	/**
	 * 每10分钟从数据库里取一次值，更新静态map
	 * @throws Exception 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@Scheduled(initialDelay = 2 * 60 * 1000, fixedDelay = 10 * 60 * 1000)
	//@Scheduled(initialDelay = 30 * 1000, fixedDelay =  60 * 1000)
	public void loadRecommendHotelFromDB() throws JsonGenerationException, JsonMappingException, Exception {
		List<FitConRecomHotelDto> recomHotels = new ArrayList<FitConRecomHotelDto>();
		try {
			recomHotels = fitBusinessClient.getFitConRecomHotelsAll();
			//logger.info("更新得到的默认酒店数据:"+ JSONMapper.getInstance().writeValueAsString(recomHotels));
		} catch (Exception e) {
			logger.error("加载推荐数据失败:",e);
		} 
		//logger.info("默认酒店数据put进map之前"+FitConRecomHotelConfig.dbMaps);
		FitConRecomHotelConfig.putDbMaps(recomHotels);
		//System.out.println("上海："+JSONMapper.getInstance().writeValueAsString(FitConRecomHotelConfig.dbMaps.get(Long.valueOf(9))));
		//System.out.println("黃山："+JSONMapper.getInstance().writeValueAsString(FitConRecomHotelConfig.dbMaps.get(Long.valueOf(88))));
		//logger.info("默认酒店数据put进map成功");
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.GET_HOTEL_INFOS)
	public Response searchHotelInfos(FitAppHotelRequest request) {
		return Response.ok(fitDpService.searchHotelInfos(request)).build();
	}
}
