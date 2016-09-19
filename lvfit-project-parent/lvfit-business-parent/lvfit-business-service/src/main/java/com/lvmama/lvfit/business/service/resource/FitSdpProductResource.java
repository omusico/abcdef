package com.lvmama.lvfit.business.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.sdpproduct.service.FitSdpProductService;
import com.lvmama.lvfit.common.client.path.BussinessClientPath;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequest;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackRequest;

@Component
@Path("")
public class FitSdpProductResource {


	@Autowired
    private FitSdpProductService fitSdpProductService;
	
	
	/**
	 * 根据产品Id获取自主打包产品信息
	 * @param productId
	 * @return
	 */
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_SDP_PRODUCT_BASICI_NFO_BY_PRODUCT_ID)
	public Response getSdpProductBasicInfoByProductId(@PathParam("productId")Long productId) {
		FitSdpProductBasicInfoDto productBasicInfoDto = fitSdpProductService.getProductBasicInfoByProductId(productId);
		BaseSingleResultDto<FitSdpProductBasicInfoDto> resultDto = new BaseSingleResultDto<FitSdpProductBasicInfoDto>();
		if(productBasicInfoDto!=null){
			resultDto.setResult(productBasicInfoDto);
		}
		return Response.ok(resultDto).build();
	}
	
	/**
	 * 新增或者修改自主打包产品信息
	 * @param productBasicInfoDto
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.SAVE_OR_UPDATE_SDP_PRODUCT_BASICI_NFO)
	public Response saveOrUpdateProductBasicInfo(FitSdpProductBasicInfoDto productBasicInfoDto) {
		productBasicInfoDto = fitSdpProductService.saveOrUpdateProductBasicInfo(productBasicInfoDto);
		return Response.ok(productBasicInfoDto).build();
	}
	
	/**
	 * 自主打包产品信息查询列表
	 * @param productBasicInfoDto
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BACK_SDP_PRODUCT_BASIC_INFO_QUERY_LIST)
	public Response SdpProductBasicInfoQueryList(String jsonRequest){
		ObjectMapper objectMapper = JSONMapper.getInstance();
		try {
			BaseQueryDto<FitSdpProductBasicInfoRequest> baseQueryDto = objectMapper.readValue(jsonRequest,
					new TypeReference<BaseQueryDto<FitSdpProductBasicInfoRequest>>(){});
			List<FitSdpProductBasicInfoDto> basicInfoDtos=	fitSdpProductService.getProductBasicInfosByCondition(baseQueryDto);
			int records = fitSdpProductService.countProductInfoList(baseQueryDto);
			
			Pagination pagination = baseQueryDto.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<FitSdpProductBasicInfoDto> baseResultDto = new BaseResultDto<FitSdpProductBasicInfoDto>(pagination,basicInfoDtos);
			String jsonResult = objectMapper.writeValueAsString(baseResultDto);
			return Response.ok(jsonResult).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据产品Id获取自主打包交通规则
	 * @param productId
	 * @return
	 */
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_SDP_PRODUCT_TRAFFIC_RULES_BY_PRODUCT_ID)
	public Response getProductTrafficRulesByProductId(@PathParam("productId")Long productId) {
		List<FitSdpProductTrafficRulesDto> TrafficRulesDtos =  null;
		TrafficRulesDtos =	fitSdpProductService.getProductTrafficRulesByProductId(productId);
		return Response.ok(TrafficRulesDtos).build();
	}
	
	/**
	 * 新增或者修改自主打包产品交通规则
	 * @param productTrafficRulesDtos
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.SAVE_OR_UPDATE_SDP_PRODUCT_TRAFFIC_RULES)
	public Response saveOrUpdateProductTrafficRules(List<FitSdpProductTrafficRulesDto> productTrafficRulesDtos) {
		fitSdpProductService.saveOrUpdateProductTrafficRules(productTrafficRulesDtos);
		/*if (CollectionUtils.isNotEmpty(productTrafficRulesDtos)) {
		    fitSdpProductService.updateSdpProductSearchIndex(productTrafficRulesDtos.get(0).getProductId());
		}*/
		return Response.ok("Success").build();
	}
	
	/**
	 * 根据产品Id获取自主打包加价规则
	 * @param productId
	 * @return
	 */
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_SDP_PRODUCT_FEE_RULES_BY_PRODUCT_ID)
	public Response getProductFeeRulesByProductId(@PathParam("productId")Long productId) {
		List<FitSdpProductFeeRulesDto> feeRulesDtos =  null;
		feeRulesDtos =	fitSdpProductService.getProductFeeRulesByProductId(productId);
		return Response.ok(feeRulesDtos).build();
	}
	
	/**
	 * 新增或者修改自主打包加价规则
	 * @param feeRulesDtos
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.SAVE_OR_UPDATE_SDP_PRODUCT_FEE_RULES)
	public Response saveOrUpdateProductFeeRules(List<FitSdpProductFeeRulesDto> feeRulesDtos) {
		fitSdpProductService.saveOrUpdateProductTFeeRules(feeRulesDtos);
		/*if (CollectionUtils.isNotEmpty(feeRulesDtos)) {
		    fitSdpProductService.updateSdpProductSearchIndex(feeRulesDtos.get(0).getProductId());
		}*/
		return Response.ok("Success").build();
	}
	
	/**
	 * 根据产品Id获取自主打包城市组信息
	 * @param productId
	 * @return
	 */
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_SDP_PRODUCT_CITY_GROUP_BY_PRODUCT_ID)
	public Response getProductCityGroupByProductId(Long productId) {
		List<FitSdpCityGroupDto> cityGroupDtos =  null;
		cityGroupDtos =	fitSdpProductService.getProductCityGroupByProductId(productId);
		return Response.ok(cityGroupDtos).build();
	}
	
	/**
	 * 根据Id获取自主打包城市组信息
	 * @param productId
	 * @return
	 */
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_SDP_PRODUCT_CITY_GROUP_BY_ID)
	public Response getProductCityGroupById(@PathParam("id")Long id) {
		FitSdpCityGroupDto cityGroupDtos =  null;
		cityGroupDtos =	fitSdpProductService.getProductCityGroupById(id);
		return Response.ok(cityGroupDtos).build();
	}
	
	/**
	 * 根据产品Id获取已选择的自主打包城市组信息
	 * @param productId
	 * @return
	 */
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_SDP_PRODUCT_SELECT_CITY_GROUP_BY_PRODUCT_ID)
	public Response getSelectProductCityGroupByProductId(@PathParam("productId")Long productId) {
		List<FitSdpCityGroupDto> cityGroupDtos =  null;
		cityGroupDtos =	fitSdpProductService.getSelectCityGroupByProductId(productId);
		return Response.ok(cityGroupDtos).build();
	}
	
	/**
	 * 新增或者修改自主打包城市组信息
	 * @param feeRulesDtos
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.SAVE_OR_UPDATE_SDP_PRODUCT_CITY_GROUP)
	public Response saveOrUpdateProductCityGroup(List<FitSdpCityGroupDto> cityGroupDtos) {
		fitSdpProductService.saveOrUpdateProductCityGroup(cityGroupDtos);
		return Response.ok(ResultStatus.SUCCESS).build();
	}
	
	/**
	 * 更新自主打包城市使用标志
	 * @param feeRulesDtos
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.UPDATE_CITY_USE_FLAG_BATCH)
	public Response updateCityUseFlagBatch(List<FitSdpCityGroupDto> cityGroupDtos) {
		fitSdpProductService.updateCityUseFlagBatch(cityGroupDtos);
		/*if (CollectionUtils.isNotEmpty(cityGroupDtos)) {
		    fitSdpProductService.updateSdpProductSearchIndex(cityGroupDtos.get(0).getProductId());
		}*/
		return Response.ok(ResultStatus.SUCCESS).build();
	}
	
	/**
	 * 单条更新自主打包城市组
	 * @param feeRulesDtos
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.UPDATE_ONE_CITY_GROUP)
	public Response updateCityGroup(FitSdpCityGroupDto cityGroupDto) {
		fitSdpProductService.saveEditProductCityGroup(cityGroupDto);
		return Response.ok(ResultStatus.SUCCESS).build();
	}
	
	/**
	 * 根据产品Id删除自主打包产品交通规则
	 * @param productTrafficRulesDtos
	 * @return
	 */
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.DELETE_SDP_PRODUCT_INFO_BY_PRODUCT_ID)
	public Response deleteProductInfoByProductId(@PathParam("productId")Long productId) {
		fitSdpProductService.deleteProductByProductId(productId);
		return Response.ok(ResultStatus.SUCCESS).build();
	}
	
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.QUERY_SDP_PRODUCT_REPORT)
	public Response querySdpProductReportCsv(BaseQueryDto<FitSdpProductBasicInfoRequest> baseQueryDto){
		try{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			List<String> flightOrderListResultDtos = fitSdpProductService.querySdpProductReport(baseQueryDto);
			String jsonResult = objectMapper.writeValueAsString(flightOrderListResultDtos); 
			return Response.ok(jsonResult).build();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BACK_SDP_PRODUCT_SEARCH_INDEX_QUERY_LIST)
	public Response querySdpProductIdIndex(BaseQueryDto<Long> baseQuery){
		try{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			List<FitSdpProductSearchIndexDto> flightOrderListResultDtos = fitSdpProductService.querySdpProductSearchIndex(baseQuery);
			int records = fitSdpProductService.countSdpProductSearchIndex(baseQuery);
			Pagination pagination = baseQuery.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<FitSdpProductSearchIndexDto> baseResultDto = new BaseResultDto<FitSdpProductSearchIndexDto>(pagination,flightOrderListResultDtos);
			String jsonResult = objectMapper.writeValueAsString(baseResultDto);
			return Response.ok(jsonResult).build();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BACK_SDP_PRODUCT_ALL_SYN_INFO)
	public Response querySdpProductSynMsgInfo(BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery){
		try{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			List<FitSdpProductSyncMsgDto> synMsgDtos = fitSdpProductService.querySdpProductSynMsgInfo(baseQuery);
			int records = fitSdpProductService.countSdpProductSynMsg(baseQuery);
			Pagination pagination = baseQuery.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<FitSdpProductSyncMsgDto> baseResultDto = new BaseResultDto<FitSdpProductSyncMsgDto>(pagination,synMsgDtos);
			String jsonResult = objectMapper.writeValueAsString(baseResultDto);
			return Response.ok(jsonResult).build();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BACK_SDP_PRODUCT_INDEX_TRAFFIC)
	public Response querySdpProductIndexTrafficList(BaseQueryDto<Long> baseQuery){
		try{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			List<FitSdpProductSearchIndexTraffic> indexTrafficDtos = fitSdpProductService.querySdpProductIndexTrafficList(baseQuery);
			int records = fitSdpProductService.countSdpProductIndexTraffic(baseQuery);
			Pagination pagination = baseQuery.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<FitSdpProductSearchIndexTraffic> baseResultDto = new BaseResultDto<FitSdpProductSearchIndexTraffic>(pagination,indexTrafficDtos);
			String jsonResult = objectMapper.writeValueAsString(baseResultDto);
			return Response.ok(jsonResult).build();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BACK_SDP_PRODUCT_DEPART_CITY)
	public Response querySdpProductDepartCityList(BaseQueryDto<FitSdpCityGroupDto> baseQueryDto){
		try{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			List<FitSdpCityGroupDto> cityGroupDtos = fitSdpProductService.getProductCityGroupByDto(baseQueryDto);
			int records = fitSdpProductService.countSdpProductDepartCityRecords(baseQueryDto);
			Pagination pagination = baseQueryDto.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<FitSdpCityGroupDto> baseResultDto = new BaseResultDto<FitSdpCityGroupDto>(pagination,cityGroupDtos);
			String jsonResult = objectMapper.writeValueAsString(baseResultDto);
 
			return Response.ok(jsonResult).build();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BACK_SUPP_ORDER_FLIGHT_CALL_BACK)
	public Response querySuppOrderFlightCallBack(BaseQueryDto<FitSuppOrderForFlightCallBackRequest> baseQuery){
		try{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			List<FitSuppOrderForFlightCallBackDto> sofDtos = fitSdpProductService.queryFitSuppOrderFlightCallBack(baseQuery);
			int records = fitSdpProductService.countSuppOrderForFlightCallBackRecords(baseQuery);
			Pagination pagination = baseQuery.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<FitSuppOrderForFlightCallBackDto> baseResultDto = new BaseResultDto<FitSuppOrderForFlightCallBackDto>(pagination,sofDtos);
			String jsonResult = objectMapper.writeValueAsString(baseResultDto);
			return Response.ok(jsonResult).build();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据Id获取产品交通索引
	 * @param productId
	 * @return
	 */
	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_SDP_PRODUCT_TRAFFIC_INDEX_BY_ID)
	public Response getProductTrafficIndexById(@PathParam("id")Long id) {
		FitSdpProductSearchIndexTraffic trafficIndexDto =  null;
		trafficIndexDto =	fitSdpProductService.queryTrafficIndexById(id);
		return Response.ok(trafficIndexDto).build();
	}
	
	/**
	 * 根据Id获取产品交通索引
	 * @param productId
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.UPDATE_SDP_PRODUCT_TRAFFIC_INDEX)
	public Response updateOneTrafficIndex(FitSdpProductSearchIndexTraffic dto) {
		fitSdpProductService.updateOneTrafficIndex(dto);
		return Response.ok(ResultStatus.SUCCESS).build();
	}
	
	/**
	 * 根据Id获取产品交通索引
	 * @param productId
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GET_FLIGHT_CALL_BACK_BY_VST_NO)
	public Response getFlightCallBackByVstMainNo(BaseQueryDto<FitFliBookingCallBackRequest> baseQuery) {
		List<FitFliBookingCallBackRequest> flightCallBack = fitSdpProductService.getFlightCallBackByVstMainNo(baseQuery);
		return Response.ok(flightCallBack).build();
	}
	
	
}
