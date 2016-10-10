package com.lvmama.lvfit.business.service.resource;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lvmama.lvfit.common.dto.enums.SymbolType;
import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.config.service.FitConRecomHotelService;
import com.lvmama.lvfit.common.client.path.BussinessClientPath;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelRequestForm;

/**
 * @author lutianyu
 * @date   2016年1月6日
 */
@Component
@Path("")
public class FitConRecomHotelResource {
	private static final Logger logger = LoggerFactory.getLogger(FitConRecomHotelResource.class);
	@Autowired
	private FitConRecomHotelService fitConRecomHotelService;

	/**
	 * 获取推荐酒店
	 */
	@GET
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_RECOMMEND_HOTELS_ALL)
	public Response getFitConRecomHotels(String jsonRequest) throws Exception {
		BaseResultDto<FitConRecomHotelDto> baseResult = new BaseResultDto<FitConRecomHotelDto>();
		
		BaseQueryDto<FitConRecomHotelDto> baseQueryDto = JSONMapper.getInstance().readValue(jsonRequest, 
				new TypeReference<BaseQueryDto<FitConRecomHotelDto>>(){});
		
		List<FitConRecomHotelDto> fitConRecomHotels = fitConRecomHotelService.getFitConRecomHotels(baseQueryDto);
		if(CollectionUtils.isNotEmpty(fitConRecomHotels)){
			baseResult.setResults(fitConRecomHotels);
		}
		Integer count = fitConRecomHotelService.count(baseQueryDto);
		
		Pagination pagination = baseQueryDto.getPagination();
		pagination.setRecords(count);
		pagination.countRecords(count);
		
		baseResult.setPagination(pagination);
		String jsonResult = JSONMapper.getInstance().writeValueAsString(baseResult);
		return Response.ok(jsonResult).build();
	}
	/**
	 * 导入推荐酒店
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BATCH_RECOMMEND_HOTELS_ALL)
	public Response importAllRecomHotel(FitConRecomHotelRequestForm fitConRecomHotelRequestForm){
		try {
			fitConRecomHotelService.importAllRecomHotel(fitConRecomHotelRequestForm);
			return Response.ok(true).build();
		} catch (Exception e) {
			logger.error("批量导入任务配置失败", e);
		}
		return null;
	}
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.SAVE_RECOMMEND_HOTEL)
	public Response saveRecomHotel(FitConRecomHotelDto dto){
		try {
			Boolean flag = fitConRecomHotelService.saveRecomHotel(dto);
			return Response.ok(flag).build();
		} catch (Exception e) {
			logger.error("新增默认酒店数据失败", e);
		}
		return null;
	}
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.UPDATE_RECOMMEND_HOTEL)
	public Response updateRecomHotel(FitConRecomHotelDto dto){
		try {
			Boolean flag = fitConRecomHotelService.updateRecomHotel(dto);
			return Response.ok(flag).build();
		} catch (Exception e) {
			logger.error("更改默认酒店数据失败", e);
		}
		return null;
	}
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_RECOMMEND_HOTEL)
	public Response getRecomHotel(Long id){
		try {
			FitConRecomHotelDto dto = fitConRecomHotelService.getRecomHotel(id);
			return Response.ok(dto).build();
		} catch (Exception e) {
			logger.error("更改默认酒店数据失败", e);
		}
		return null;
	}
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.DELETE_RECOMMEND_HOTEL)
	public Response deleteRecomHotel(Long id){
		try {
			Boolean flag = fitConRecomHotelService.deleteRecomHotel(id);
			return Response.ok(flag).build();
		} catch (Exception e) {
			logger.error("删除默认酒店数据失败", e);
		}
		return null;
	}
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_ALL_RECOM_HOTEL)
	public Response getAllRecomHotel(){
		List<FitConRecomHotelDto> results = fitConRecomHotelService.getAllRecomHotel();
		Collections.sort(results, new Comparator<FitConRecomHotelDto>() {
			@Override public int compare(FitConRecomHotelDto o1, FitConRecomHotelDto o2) {
				if (o1.getIsDefault().equals(SymbolType.Y)) {
					return -1;
				}
				if (o2.getIsDefault().equals(SymbolType.Y)) {
					return 1;
				}
				return 0;
			}
		});
		return Response.ok(results).build();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.SET_DEFAULT_HOTEL)
	public Response setDefaultHotel(@PathParam("id")Long id,@PathParam("districtCityId")Long districtCityId){
		BaseSingleResultDto<Integer> baseSingleResult = fitConRecomHotelService.setDefaultHotel(id, districtCityId);
		return Response.ok(baseSingleResult).build();
	}
}
