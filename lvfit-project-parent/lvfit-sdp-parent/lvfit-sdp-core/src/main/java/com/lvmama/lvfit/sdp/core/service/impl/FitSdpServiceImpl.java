package com.lvmama.lvfit.sdp.core.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.enums.SuppSaleType;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.solr.json.base.select.SolrFacetField;
import com.lvmama.lvf.common.solr.json.base.select.SolrFacetFields;
import com.lvmama.lvf.common.task.Task;
import com.lvmama.lvf.common.task.TaskContext;
import com.lvmama.lvf.common.task.TaskMainGroup;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.aspect.exception.ExceptionPoint;
import com.lvmama.lvfit.common.calculate.FitSdpCalculateUtils;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.enums.FitBusinessType;
import com.lvmama.lvfit.common.dto.enums.SortRuleType;
import com.lvmama.lvfit.common.dto.enums.TimeSegment;
import com.lvmama.lvfit.common.dto.enums.TrafficTripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelGroupDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceProductDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpInstalmentDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightFacetType;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.SearchResultUtil;
import com.lvmama.lvfit.common.dto.search.flight.result.CharterFlightFilterUtil;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.flight.result.MockUtil;
import com.lvmama.lvfit.sdp.core.service.FitSdpService;
import com.lvmama.lvfit.sdp.shopping.FitSdpShoppingService;

@Service
public class FitSdpServiceImpl implements FitSdpService {

	public static final Logger logger=Logger.getLogger(FitSdpServiceImpl.class);

	@Autowired
	private FitAggregateClient fitAggregateClient;

	@Autowired
	private FitBusinessClient fitBusinessClient;

	@Autowired
	private FitSdpShoppingService fitSdpShoppingService;

	@Autowired
	private FitSdpCalculateUtils fitSdpCalculateUtils;

	@Autowired
	private FitSearchClient fitSearchClient;

	@Override
	public FitSdpProductBasicInfoDto searchProductBasicInfo(Long productId) {
		FitSdpProductBasicInfoDto basicInfo = fitAggregateClient.searchProductBasicInfo(productId);
		// 处理城市组信息
		BaseSingleResultDto<FitSdpProductBasicInfoDto> dbBasicInfo = fitBusinessClient.getSdpProductBasicInfoByProductId(productId);
		if(dbBasicInfo.getResult()==null){
			throw new ExceptionWrapper(FitExceptionCode.GET_NO_SDP_PRODUCT,productId);
		}
		List<FitSdpCityGroupDto> cityGroupsDtos = dbBasicInfo.getResult().getCityGroups();
		basicInfo.setCityGroups(cityGroupsDtos);
		basicInfo.setPackagedCategoryId(dbBasicInfo.getResult().getPackagedCategoryId());
		basicInfo.setMuiltDpartureFlag(dbBasicInfo.getResult().getMuiltDpartureFlag());
		// 初始化城市组相关信息
		try {
			this.initCityGroupInfo(basicInfo);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return basicInfo;
	}
	
	@Override
	public FitSdpProductBasicInfoDto searchProductBasicInfoPreview(Long productId) {
		FitSdpProductBasicInfoDto basicInfo = fitAggregateClient.searchProductBasicInfo(productId);
		// 处理城市组信息
		BaseSingleResultDto<FitSdpProductBasicInfoDto> dbBasicInfo = fitBusinessClient.getSdpProductBasicInfoByProductId(productId);
		if(dbBasicInfo.getResult()!=null){
			List<FitSdpCityGroupDto> cityGroupsDtos = dbBasicInfo.getResult().getCityGroups();
			basicInfo.setCityGroups(cityGroupsDtos);
			basicInfo.setPackagedCategoryId(dbBasicInfo.getResult().getPackagedCategoryId());
			basicInfo.setMuiltDpartureFlag(dbBasicInfo.getResult().getMuiltDpartureFlag());
			// 初始化城市组相关信息
			try {
				this.initCityGroupInfo(basicInfo);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return basicInfo;
	}

	@ExceptionPoint(FitBusinessExceptionType.FIT_SDP_SEARCH_PRODUCT_E)
    private void initCityGroupInfo(FitSdpProductBasicInfoDto basicInfo) {

        Map<Long, BigDecimal> startPriceMap = this.searchCalendarInfoByProductId(basicInfo.getProductId());
        if(startPriceMap.isEmpty()){
        	throw new ExceptionWrapper(FitExceptionCode.GET_NO_SDP_START_PRICE,basicInfo.getProductId());
        }
        try {
			logger.error("startPriceMap【"+JSONMapper.getInstance().writeValueAsString(startPriceMap)+"】");
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
        List<FitSdpCityGroupDto> cityGroupsDtos =   basicInfo.getCityGroups();
        List<FitSdpCityGroupDto> usefulcCityGroupDtos = new ArrayList<FitSdpCityGroupDto>();
        for (FitSdpCityGroupDto cityGroupDto : cityGroupsDtos) {
			if(startPriceMap.containsKey(cityGroupDto.getDepartureCityDistrictId())){
				usefulcCityGroupDtos.add(cityGroupDto);
			}
		}
        basicInfo.setCityGroups(usefulcCityGroupDtos);
    }

	@Override
	@ExceptionPoint(FitBusinessExceptionType.FIT_SDP_SEARCH_CALENDAR_INFO_E)
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchCalendarInfo(
		FitSdpProductCalendarRequest calendarRequest) {
		FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> result = new FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto>();

		String depCityCode = calendarRequest.getDepartureCityCode();
		Long depDistrictId = VSTDistrictCityEnum.getDistrictId(depCityCode);
		Map<Long, List<FitSdpProductCalendarDto>> allCityCalendarInfoMap = fitSdpCalculateUtils.getAllCityCalendarInfoFromCache(calendarRequest.getProductId());
		List<FitSdpProductCalendarDto> calendarInfo = allCityCalendarInfoMap.get(depDistrictId);
        if(CollectionUtils.isEmpty(calendarInfo)){
			throw new ExceptionWrapper(FitExceptionCode.GET_NO_FLIGHT_CALENDAR, calendarRequest.getProductId(), calendarRequest.getDepartureCityCode(),
					calendarRequest.getArrivalCityCode());
		}
		result.setResults(calendarInfo);
		result.setStartPrice(fitSdpCalculateUtils.getStartingPrice(calendarInfo));

		try {
			String categoryCode = "";
			if (calendarRequest.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.getCategoryId().toString())) {
				categoryCode = BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.name();
			}
			if (calendarRequest.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_group.getCategoryId().toString())) {
				categoryCode = BizEnum.BIZ_CATEGORY_TYPE.category_route_group.name();
			}
			if (StringUtils.isNotBlank(categoryCode)) {
				List<FitSdpInstalmentDto> instalmentInfo = fitSearchClient
					.getInstalmentInfo(calendarRequest.getProductId().toString(), categoryCode);
				result.setInstalments(instalmentInfo);
			}
		} catch (Exception e) {
			logger.error("产品ID: " + calendarRequest.getProductId() + "获取分期价规则失败！", e);
		}
		return result;
	}  
	   
//	@Override
//	@ExceptionPoint(FitBusinessExceptionType.FIT_SDP_SEARCH_GOODS_E)
//	public FitSdpGoodsDto searchGoodsInfo(FitSdpGoodsRequest goodsRequest) {
//
//		Object[] vars = new Object[] { goodsRequest.getProductId(),
//				goodsRequest.getBizCategoryId(),
//				DateUtils.formatDate(goodsRequest.getDepartDate()),
//				goodsRequest.getDepCityCode(), goodsRequest.getArvCityCode() };
//		List<FitSdpProductTrafficRulesDto> trafficRules = fitBusinessClient
//				.getProductTrafficRulesByProductId(goodsRequest.getProductId());
//		Map<String, FitSdpProductTrafficRulesDto> trafficRuleMap = new HashMap<String, FitSdpProductTrafficRulesDto>();
//		if (CollectionUtils.isNotEmpty(trafficRules)) {
//			for (FitSdpProductTrafficRulesDto trafficRulesDto : trafficRules) {
//				trafficRuleMap.put(
//						trafficRulesDto.getTrafficTripeType().name(),
//						trafficRulesDto);
//			}
//		}else{
//			logger.info("异常：没有找到交通规则..."+goodsRequest.getProductId());
//		}
//
//		FlightSearchResult<FlightSearchFlightInfoDto> goFlightSearchResult2 = MockUtil.createFromJsonFile("d:\\new_flight.txt", new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>(){});
//		List<FlightSearchFlightInfoDto> charterFlightInfos = this
//				.handleCharterFlightResult(goFlightSearchResult2,
//						trafficRuleMap.get(TrafficTripeType.GO_WAY.name()),
//						trafficRuleMap.get(TrafficTripeType.BACK_WAY.name()),
//						goodsRequest);
//
//		FlightSearchResult<FlightSearchFlightInfoDto> r = MockUtil.createFromJsonFile("d:\\new_flight.txt", new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>(){});
//		FlightSearchResult<FlightSearchFlightInfoDto> r2 = MockUtil.createFromJsonFile("d:\\new_flight.txt", new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>(){});
//		List<FlightSearchFlightInfoDto> goFlightInfo = this.handleFlightSearchResult(r, trafficRuleMap.get(TrafficTripeType.GO_WAY.name()), goodsRequest);
//
//		List<FlightSearchFlightInfoDto> backFlightInfo = this.handleFlightSearchResult(r2, trafficRuleMap.get(TrafficTripeType.BACK_WAY.name()), goodsRequest);
//		
//		FitSdpGoodsDto goods = null;
//		goods = new FitSdpGoodsDto();
//		//设置查询航班的规则map
//		goods.setTrafficRuleMap(trafficRuleMap);
//		// 设置包机信息.
//		goods.setCharterFlightInfos(charterFlightInfos);
//		
//		goods.setDepFlightInfos(goFlightInfo);
//		goods.setDepfacetMap(r.getFacetMap());
//
//		goods.setArvFlightInfos(backFlightInfo);
//		goods.setArvfacetMap(r2.getFacetMap()); 
//		
//		// 将商品信息放入缓存，用于算价，更换航班，更换酒店套餐
//		this.putInfoToCache4CalculatePrice(goodsRequest, goods);
//		return goods;
//	}
	 
	@Override
	@ExceptionPoint(FitBusinessExceptionType.FIT_SDP_SEARCH_GOODS_E)
	public FitSdpGoodsDto searchGoodsInfo(FitSdpGoodsRequest goodsRequest) {

		Object[] vars = new Object[]{goodsRequest.getProductId(),goodsRequest.getBizCategoryId(),
				DateUtils.formatDate(goodsRequest.getDepartDate()),goodsRequest.getDepCityCode(),goodsRequest.getArvCityCode()};
		List<FitSdpProductTrafficRulesDto> trafficRules = fitBusinessClient.getProductTrafficRulesByProductId(goodsRequest.getProductId());
		Map<String,FitSdpProductTrafficRulesDto> trafficRuleMap = new HashMap<String, FitSdpProductTrafficRulesDto>();
		if(CollectionUtils.isNotEmpty(trafficRules)){
			for (FitSdpProductTrafficRulesDto trafficRulesDto : trafficRules) {
				trafficRuleMap.put(trafficRulesDto.getTrafficTripeType().name(), trafficRulesDto);
			}
		}
		// 机票查询请求和VST商品的请求信息
		Map<String, Object> reqMap = getQueryRequestMap(goodsRequest, trafficRules);
		System.out.println("查询返程："+MockUtil.toJsonStr(reqMap.get(FitBusinessType.FIT_SDP_BACK_FLIGHT_QUERY.name())));
		System.out.println("查询去程："+MockUtil.toJsonStr(reqMap.get(FitBusinessType.FIT_SDP_GO_FLIGHT_QUERY.name())));
		final String mainTraceId = TraceContext.getTraceId();
	    TaskMainGroup<Boolean> mainGroup = new TaskMainGroup<Boolean>();
	    final TaskContext context = new TaskContext();

		for (Map.Entry<String, Object> entry : reqMap.entrySet()) {
			final String key = entry.getKey();
			final Object request = entry.getValue();
			mainGroup.addTask(new Task<Boolean>() {
				@Override
				public Boolean execute(TaskContext taskContext) {
					TraceContext.setTraceId(mainTraceId);
					try {
						// 机票查询
						if (request instanceof FlightQueryRequest) {
							context.put(key, fitAggregateClient.searchFlightInfo((FlightQueryRequest) request));
						}
						// 商品查询
						if (request instanceof FitSdpGoodsRequest) {
							context.put(key, fitAggregateClient.searchProductGoodsInfo((FitSdpGoodsRequest) request));
						}
					}catch (Exception e){
						context.put(FitBusinessType.valueOf(key).getBusinessExceptionType().name(), e);
					}
					return true;
				}
			});
		}
	    mainGroup.putContext(context).getResult(reqMap.keySet().size());
		Set<String> allContextKeys = context.keySet();
		for (String key : allContextKeys) {
			if (key.endsWith(FitBusinessExceptionType._E.name())) {
				Exception curException = (Exception)context.get(FitBusinessExceptionType.valueOf(key).name());
				throw new RuntimeException(curException);
			}
		}
		List<FlightSearchFlightInfoDto> goFlightInfo = null;
		List<FlightSearchFlightInfoDto> backFlightInfo = null;
		 
		
		BaseSingleResultDto<FitSdpGoodsDto> goodsResult = null;
		FlightSearchResult<FlightSearchFlightInfoDto> allGoFlights = (FlightSearchResult<FlightSearchFlightInfoDto>)context.get(FitBusinessType.FIT_SDP_GO_FLIGHT_QUERY.name());
		
		FlightSearchResult<FlightSearchFlightInfoDto> goFlightSearchResult = new FlightSearchResult<FlightSearchFlightInfoDto>();
		List<FlightSearchFlightInfoDto> allGoList = new ArrayList<FlightSearchFlightInfoDto>();
		allGoList.addAll(allGoFlights.getResults());
		goFlightSearchResult.setResults(allGoList);
		goFlightSearchResult.setFacetMap(allGoFlights.getFacetMap());
		
		goFlightInfo = this.handleFlightSearchResult(goFlightSearchResult, trafficRuleMap.get(TrafficTripeType.GO_WAY.name()), goodsRequest);

		FlightSearchResult<FlightSearchFlightInfoDto> backFlightSearchResult = (FlightSearchResult<FlightSearchFlightInfoDto>) context.get(FitBusinessType.FIT_SDP_BACK_FLIGHT_QUERY.name());
		backFlightInfo = this.handleFlightSearchResult(backFlightSearchResult, trafficRuleMap.get(TrafficTripeType.BACK_WAY.name()), goodsRequest);
		
		//包机信息.
		FlightSearchResult<FlightSearchFlightInfoDto> goFlightSearchResult2 = new FlightSearchResult<FlightSearchFlightInfoDto>();
		List<FlightSearchFlightInfoDto> allCharsetList = new ArrayList<FlightSearchFlightInfoDto>();
		allCharsetList.addAll(allGoFlights.getResults());
		goFlightSearchResult2.setResults(allCharsetList);
		goFlightSearchResult2.setFacetMap(allGoFlights.getFacetMap()); 
		List<FlightSearchFlightInfoDto> charterFlightInfos =  this.handleCharterFlightResult(goFlightSearchResult2, trafficRuleMap.get(TrafficTripeType.GO_WAY.name())
				, trafficRuleMap.get(TrafficTripeType.BACK_WAY.name()),goodsRequest); 
		
		FitSdpGoodsDto goods = null;
		Object goodsInfoObject = context.get(FitBusinessType.FIT_SDP_SEARCH_GOODS.name());
		if (goodsInfoObject != null) {
			goodsResult = (BaseSingleResultDto<FitSdpGoodsDto>) goodsInfoObject;
		}
		goods = goodsResult.getResult(); 

		if(null==goods){
			throw new ExceptionWrapper(FitExceptionCode.GET_NO_SDP_GOODS,goodsRequest.getProductId());
		}

		/*if(goodsRequest.getBizCategoryId()== BizEnum.BIZ_CATEGORY_TYPE.category_route_group.getCategoryId() &&null==goods.getLocalTrip()){
			throw new ExceptionWrapper(FitExceptionCode.GET_NO_SDP_LOCAL_TRIP,vars);
		}

		if(goodsRequest.getBizCategoryId()==BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.getCategoryId()&&CollectionUtils.isEmpty(goods.getHotelCombo())){
			throw new ExceptionWrapper(FitExceptionCode.GET_NO_SDP_HOTEL_COMBO, vars);
		}*/

		//如果没有包机信息，又没有普通的去程或者返程，就抛错.
		if(CollectionUtils.isEmpty(charterFlightInfos)){
			if(CollectionUtils.isEmpty(goFlightInfo)){
				throw new ExceptionWrapper(FitExceptionCode.GET_NO_SDP_DEP_FLIGHT, vars);
			}
	
			if(CollectionUtils.isEmpty(backFlightInfo)){
				throw new ExceptionWrapper(FitExceptionCode.GET_NO_SDP_ARR_FLIGHT, vars);
			}
		}

		goods.setDepFlightInfos(goFlightInfo);
		goods.setDepfacetMap(goFlightSearchResult.getFacetMap());

		goods.setArvFlightInfos(backFlightInfo);
		goods.setArvfacetMap(backFlightSearchResult.getFacetMap());

		//设置包机信息.
		goods.setCharterFlightInfos(charterFlightInfos);
        // 处理保险数据，按推荐级别排序，默认选中国内游意外险
        goods.setInsProducts(genSortedInsurance(goods));
        
        //设置查询航班的规则map
        goods.setTrafficRuleMap(trafficRuleMap);
        // 将商品信息放入缓存，用于算价，更换航班，更换酒店套餐
        this.putInfoToCache4CalculatePrice(goodsRequest, goods);
  		return goods;
	}

	private List<FlightSearchFlightInfoDto> handleFlightSearchResult(FlightSearchResult<FlightSearchFlightInfoDto> flightResult,
		FitSdpProductTrafficRulesDto trafficRule, FitSdpGoodsRequest goodsRequest) {
		List<FlightSearchFlightInfoDto> flightInfo = flightResult.getResults();
		if (flightResult == null || CollectionUtils.isEmpty(flightInfo)) {
			return null;
		}
		//剔除是包机切位的航班信息.
		CharterFlightFilterUtil.filterCharterFlight(flightInfo,true);		 
		//根据交通规则过滤航班
		this.filterFlightByTrafficRules(flightInfo, trafficRule);
		//如果有乘客是儿童，过滤没有儿童舱位的航班或者舱位
		if(goodsRequest.getChildQuantity().intValue() > 0){
			this.filterNoChildFlight(flightInfo);
		}
		// 过滤库存不足的航班
		this.filterUnderStockFlight(goodsRequest, flightInfo);
		// 按后台设置的排序规则排序
		this.sortByTrafficRule(flightInfo, trafficRule);
		// 计算差价
		this.calculateDiffPrice(flightInfo, goodsRequest.getAdultQuantity(), goodsRequest.getChildQuantity(), goodsRequest.getQuantity());
		// 设置过滤key
		this.setFilterKey(flightInfo);
		// 设置隔夜航班
		this.setOverNightFlightFlag(flightInfo);
		// 过滤筛选条件
		this.filterFacet(flightInfo, flightResult.getFacetMap());

		return flightInfo;
	}

	/**
	 * 根据计算出来的map设置去程的返回日期为返程的出发日期.
	 * 返程的“返回日期”不管，设置为空.
	 * @param reqMap
	 */
	private void setBackDate(Map<String, Object> reqMap){
		//如果map里面有数据.
		if(reqMap.size()>1){
			FlightQueryRequest goReq = (FlightQueryRequest)reqMap.get(FitBusinessType.FIT_SDP_GO_FLIGHT_QUERY.name());
			FlightQueryRequest backReq = (FlightQueryRequest)reqMap.get(FitBusinessType.FIT_SDP_BACK_FLIGHT_QUERY.name());
			goReq.setBackDate(backReq.getDepartureDate());
		}
	}
	
	private Map<String, Object> getQueryRequestMap(FitSdpGoodsRequest goodsRequest, List<FitSdpProductTrafficRulesDto> trafficRules) {
		Map<String, Object> reqMap = new HashMap<String, Object>();
		for (FitSdpProductTrafficRulesDto trafficRule : trafficRules) {
			FlightQueryRequest queryReq = this.getFlightQueryRequest(goodsRequest, trafficRule);
			if (trafficRule.getTrafficTripeType().equals(TrafficTripeType.GO_WAY)) {
				reqMap.put(FitBusinessType.FIT_SDP_GO_FLIGHT_QUERY.name(),  queryReq);
			}
			if (trafficRule.getTrafficTripeType().equals(TrafficTripeType.BACK_WAY)) {
				reqMap.put(FitBusinessType.FIT_SDP_BACK_FLIGHT_QUERY.name(),  queryReq);
			}
		}
		
		//根据计算出来的map设置去程的返回日期为返程的出发日期.
		setBackDate(reqMap);
		
		reqMap.put(FitBusinessType.FIT_SDP_SEARCH_GOODS.name(), goodsRequest);
		return reqMap;
	}

	private void setOverNightFlightFlag(List<FlightSearchFlightInfoDto> searchFlightInfoDtos) {
        for (FlightSearchFlightInfoDto flightInfoDto : searchFlightInfoDtos) {
            String depDateStr = flightInfoDto.getDepartureDate();
            String arrivalTime = flightInfoDto.getArrivalTime();
            Date arvDateD = DateUtils.parseDate(arrivalTime, "yyyy-MM-dd HH:mm:ss");
            String arvDateStr = DateUtils.formatDate(arvDateD, "yyyy-MM-dd");
            if (depDateStr.equals(arvDateStr)) {
                flightInfoDto.setHighLightFlag(false);
            } else {
                flightInfoDto.setHighLightFlag(true);
            }
        }
    }

	/**
	 * 过滤筛选项
	 * @param flightInfos
	 * @param facetMap
	 */
	private  void filterFacet(List<FlightSearchFlightInfoDto> flightInfos,Map<FlightFacetType, SolrFacetFields> facetMap){

		Set<String> departureTimeSegments = new HashSet<String>();
		Set<String> carrierNameCodes = new HashSet<String>();
		Set<String> seatClassTypes = new HashSet<String>();
		for (FlightSearchFlightInfoDto searchFlightInfoDto : flightInfos) {
			departureTimeSegments.add(searchFlightInfoDto.getDepartureTimeSegmentKey());
			carrierNameCodes.add(searchFlightInfoDto.getCarrierNameCodeKey());
			seatClassTypes.addAll(searchFlightInfoDto.getSeatClassTypeKey());
		}

		for (Entry<FlightFacetType, SolrFacetFields> entry : facetMap.entrySet()) {
			Set<String> filterKeys = new HashSet<String>();
			if(entry.getKey()==FlightFacetType.departureTimeSegment){
				filterKeys = departureTimeSegments;
			}
			if(entry.getKey()==FlightFacetType.carrierNameCode){
				filterKeys = carrierNameCodes;
			}
			if(entry.getKey()==FlightFacetType.seatClassType){
				filterKeys = seatClassTypes;
			}
			List<SolrFacetField> fields = entry.getValue().getFields();
			Map<String,SolrFacetField> solrFacetFieldMap = new HashMap<String, SolrFacetField>();
			for (SolrFacetField solrFacetField : fields) {
				solrFacetFieldMap.put(solrFacetField.getFieldValue(), solrFacetField);
			 }
			List<SolrFacetField> facetFields = new ArrayList<SolrFacetField>();
			for (String key : filterKeys) {
				facetFields.add(solrFacetFieldMap.get(key));
			}
			 entry.getValue().setFields(facetFields);
		}

	}

    private void filterUnderStockFlight(FitSdpGoodsRequest goodsRequest,List<FlightSearchFlightInfoDto> searchFlightInfoDtos) {

       List<FlightSearchFlightInfoDto> noUsefulFlightInfos= new ArrayList<FlightSearchFlightInfoDto>();
       FitSearchRequest fitSearchRequest = new FitSearchRequest();
       FitPassengerRequest fitPassengerRequest = new FitPassengerRequest();

       long adultCount = goodsRequest.getAdultQuantity() * goodsRequest.getQuantity();
       long childCount = goodsRequest.getChildQuantity() * goodsRequest.getQuantity();
       fitPassengerRequest.setAdultCount((int)adultCount);
       fitPassengerRequest.setChildCount((int)childCount);
       fitSearchRequest.setFitPassengerRequest(fitPassengerRequest);

       for(FlightSearchFlightInfoDto flightInfoDto:searchFlightInfoDtos){
           flightInfoDto = SearchResultUtil.isAvailableSeat(flightInfoDto, fitSearchRequest);
           if(CollectionUtils.isEmpty(flightInfoDto.getSeats())){//这里的舱位列表已经进行过处理，没有库存的舱位已经去除
        	   noUsefulFlightInfos.add(flightInfoDto);
           }
       }
       searchFlightInfoDtos.removeAll(noUsefulFlightInfos);
    }

	private List<FitSdpInsuranceProductDto> genSortedInsurance(FitSdpGoodsDto goods) {
        List<FitSdpInsuranceDto> insuranceDtos = goods.getAdditional().getInsuranceDto();
        List<FitSdpInsuranceProductDto> insProducts = new ArrayList<FitSdpInsuranceProductDto>();
        if (CollectionUtils.isNotEmpty(insuranceDtos)) {
            Map<String, List<FitSdpInsuranceDto>> map = new HashMap<String, List<FitSdpInsuranceDto>>();
            for (FitSdpInsuranceDto insurance : insuranceDtos) {
                String productId = insurance.getProductId().toString();
                if (!map.containsKey(productId)) {
                    map.put(productId, new ArrayList<FitSdpInsuranceDto>());
                }
                List<FitSdpInsuranceDto> list = map.get(productId);
                list.add(insurance);
            }
            // 产品内的商品按推荐级别由低到高排列
            for (String key : map.keySet()) {
                List<FitSdpInsuranceDto> insurances = map.get(key);
                Collections.sort(insurances, new Comparator<FitSdpInsuranceDto>() {
                    @Override
                    public int compare(FitSdpInsuranceDto o1, FitSdpInsuranceDto o2) {
                        return o2.getBranchRecommendLvl() - o1.getBranchRecommendLvl();
                    }
                });
                FitSdpInsuranceProductDto insProduct = new FitSdpInsuranceProductDto();
                insProduct.setProductId(insurances.get(0).getProductId());
                insProduct.setProductName(insurances.get(0).getProductName());
                insProduct.setProductType(insurances.get(0).getProductType());
                insProduct.setProRecommendLvl(insurances.get(0).getProRecommendLvl());
                insProduct.setInsBranches(insurances);
                insProducts.add(insProduct);
            }
            Collections.sort(insProducts, new Comparator<FitSdpInsuranceProductDto>() {
                @Override
                public int compare(FitSdpInsuranceProductDto o1, FitSdpInsuranceProductDto o2) {
                    return o2.getProRecommendLvl() - o1.getProRecommendLvl();
                }
            });
        }
        return insProducts;
    }

	/**
	 * 根据交通规则过滤航班
	 * @param searchFlightInfoDtos
	 * @param trafficRule
	 */
	private void filterFlightByTrafficRules(List<FlightSearchFlightInfoDto> searchFlightInfoDtos,FitSdpProductTrafficRulesDto trafficRule) {

		List<FlightSearchFlightInfoDto> noUsefulFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
		if((StringUtils.isNotBlank(trafficRule.getDepBegTime())&&StringUtils.isNotBlank(trafficRule.getDepEndTime()))
			||StringUtils.isNotBlank(trafficRule.getArrBegTime())&&StringUtils.isNotBlank(trafficRule.getArrEndTime())){
			for (FlightSearchFlightInfoDto searchFlightInfoDto : searchFlightInfoDtos) {
				 if(StringUtils.isNotBlank(trafficRule.getDepBegTime())&&StringUtils.isNotBlank(trafficRule.getDepEndTime())){
					  Date curFlightdepartureTime = DateUtils.parseDate(searchFlightInfoDto.getDepartureTime(),DateUtils.YYYY_MM_DD_HH_MM);
					  Date trafficRuleDepBeg = DateUtils.parseDate(searchFlightInfoDto.getDepartureDate()+" "+trafficRule.getDepBegTime(),DateUtils.YYYY_MM_DD_HH_MM);
					  Date trafficRuleDepEnd = DateUtils.parseDate(searchFlightInfoDto.getDepartureDate()+" "+trafficRule.getDepEndTime(),DateUtils.YYYY_MM_DD_HH_MM);
					  if(curFlightdepartureTime.compareTo(trafficRuleDepBeg)>=0&&curFlightdepartureTime.compareTo(trafficRuleDepEnd)<=0){
						  continue;
					  }
			    }else if(StringUtils.isNotBlank(trafficRule.getArrBegTime())&&StringUtils.isNotBlank(trafficRule.getArrEndTime())){
					  Date curFlightArrEndTime = DateUtils.parseDate(searchFlightInfoDto.getArrivalTime(),DateUtils.YYYY_MM_DD_HH_MM);
					  Date trafficRuleArrBeg = DateUtils.parseDate(searchFlightInfoDto.getDepartureDate()+" "+trafficRule.getArrBegTime(),DateUtils.YYYY_MM_DD_HH_MM);
					  Date trafficRuleArrEnd = DateUtils.parseDate(searchFlightInfoDto.getDepartureDate()+" "+trafficRule.getArrEndTime(),DateUtils.YYYY_MM_DD_HH_MM);
					  if(curFlightArrEndTime.compareTo(trafficRuleArrBeg)>=0&&curFlightArrEndTime.compareTo(trafficRuleArrEnd)<=0){
						  continue;
					  }
				 }
				 noUsefulFlightInfoDtos.add(searchFlightInfoDto);
			}
			searchFlightInfoDtos.removeAll(noUsefulFlightInfoDtos);
		}
	}
 
	/**
	 * 设置一个分组下面的全部的房型的房差价
	 * @param
	 */
	private void setRoomDiffPrice(FitSdpHotelGroupDto g){
		BigDecimal leastPrice = g.getLeastPrice();
		if(leastPrice!=null){
			LinkedList<FitSdpHotelDto> hts = g.getHotels();
			for(FitSdpHotelDto h:hts){ 
				LinkedList<FitSdpHotelRoomtypeDto> rts = h.getFangXinList();
				for(FitSdpHotelRoomtypeDto r:rts){
					if(r.getPrice()!=null)
						r.setDiffPrice(r.getPrice().multiply(new BigDecimal(r.getRoomCount())).subtract(leastPrice));
				}
			} 
		}
	} 
	
	/**
	 * 设置默认选择的酒店房型--每个分组里面的第一个酒店下面的第一个房型..
	 * 以及计算房差价.
	 * @param hotelGroups
	 */
	private void setSelectedRoomtypes(FitSdpShoppingDto shoppingDto,List<FitSdpHotelGroupDto> hotelGroups){
		List<FitSdpHotelRoomtypeDto> selectedRoomtypes = new ArrayList<FitSdpHotelRoomtypeDto>();
		List<FitSdpHotelRoomtypeDto> allRoomtypes = new ArrayList<FitSdpHotelRoomtypeDto>();
		for(FitSdpHotelGroupDto g:hotelGroups){
			//计算当前分组中的最小的价格.
			BigDecimal leastPrice = new BigDecimal(Integer.MAX_VALUE);
			LinkedList<FitSdpHotelDto> hts = g.getHotels(); 
			for(int i=0,j=hts.size();i<j;i++){
				FitSdpHotelDto _h = hts.get(i); 
				LinkedList<FitSdpHotelRoomtypeDto> rts = _h.getFangXinList();
				//如果是第一个酒店
				if(i==0){
					_h.setIsBeSelected("Y");
					//默认选择第一个酒店下面的第一个房型
					for(int ii=0,jj=rts.size();ii<jj;ii++){
						FitSdpHotelRoomtypeDto _r = rts.get(ii); 
						if(ii==0){ 
							_r.setIsBeSelected("Y"); 
							selectedRoomtypes.add(_r); 
							BigDecimal price = _r.getPrice();
							if(price==null){
								logger.info("房间价格为空，有异常："+_r.getDetailId()+","+_r.getRoomId()+",h:"+_h.getHotelId()+",g:"+_h.getGroupId());
								continue;
							}
							//当前组最低房价就是当前选择的房间的价格*房间间数.
							leastPrice = price.multiply(new BigDecimal(_r.getRoomCount())); 
						}else{
							_r.setIsBeSelected("N");
						}
						
						allRoomtypes.add(_r);
					}
				}
				//否则全部设置为不选中.
				else{
					_h.setIsBeSelected("N");
					for(int ii=0,jj=rts.size();ii<jj;ii++){
						FitSdpHotelRoomtypeDto _r = rts.get(ii);
						_r.setIsBeSelected("N"); 
						allRoomtypes.add(_r);
					} 
				}
			} 
			//设置当前分组的房最低价.
			g.setLeastPrice(leastPrice);
			//设置分组下面的各个房间的价差.
			setRoomDiffPrice(g);
		}
		shoppingDto.setAllRoomtypes(allRoomtypes);
		shoppingDto.setSelectedRoomtypes(selectedRoomtypes);
	}
	 
	private void putInfoToCache4CalculatePrice(FitSdpGoodsRequest goodsRequest,
            FitSdpGoodsDto searchGoodsInfo) {
        // --机票--
        FitSdpShoppingDto shoppingDto = new FitSdpShoppingDto();
        //选择的航班信息.先添加去程，再添加返程.
        List<FlightSearchFlightInfoDto> list = new ArrayList<FlightSearchFlightInfoDto>();
        if (CollectionUtils.isNotEmpty(searchGoodsInfo.getDepFlightInfos())) {
            shoppingDto.setDepFlightInfos(searchGoodsInfo.getDepFlightInfos()); 
        }
        if (CollectionUtils.isNotEmpty(searchGoodsInfo.getArvFlightInfos())) {
            shoppingDto.setArvFlightInfos(searchGoodsInfo.getArvFlightInfos()); 
        }
        //包机信息.
        if (CollectionUtils.isNotEmpty(searchGoodsInfo.getCharterFlightInfos())) {
            shoppingDto.setCharterFlightInfos(searchGoodsInfo.getCharterFlightInfos()); 
        } 
        shoppingDto.setSelectedFlightInfos(CharterFlightFilterUtil.setSumFlights(searchGoodsInfo,goodsRequest));  
        
//        // --酒店信息--
//        if (CollectionUtils.isNotEmpty(searchGoodsInfo.getHotelInfos())) {
//        	//第一次设置默认的最低价的基准是0.之后如果修改了基准价格，这里就会变化。
//        	setSelectedRoomtypes(shoppingDto,searchGoodsInfo.getHotelInfos()); 
//        	
//            shoppingDto.setHotelGroups(searchGoodsInfo.getHotelInfos()); 
//            
//        }
//        
//        // --酒店套餐信息--
//        if (CollectionUtils.isNotEmpty(searchGoodsInfo.getHotelCombo())) {
//            shoppingDto.setSelectedHotelComboGoods(searchGoodsInfo.getHotelCombo().get(0));
//            for (int i = 0; i < searchGoodsInfo.getHotelCombo().size(); i++) {
//                if (i == 0) {
//                    searchGoodsInfo.getHotelCombo().get(i).setIsBeSelected("Y");
//                } else {
//                    searchGoodsInfo.getHotelCombo().get(i).setIsBeSelected("N");
//                }
//            }
//            shoppingDto.setHotelCombos(searchGoodsInfo.getHotelCombo());
//        }
//        // --当地游及房差信息--
//        if (searchGoodsInfo.getLocalTrip() != null) {
//            shoppingDto.setSelectLocalTripPrduct(searchGoodsInfo.getLocalTrip());
//            FitSdpRoomDiff roomDiff = searchGoodsInfo.getAdditional().getRoomDiff();
//            if (goodsRequest.getAdultQuantity() % 2 == 0) {
//                roomDiff.setCount(0);
//            } else {
//                roomDiff.setCount(1);
//            }
//            shoppingDto.setSelectRoomDiffs(roomDiff);
//        }
        // 成人数和儿童数
        FitSdpProductBasicInfoDto  basicInfoDto =  fitAggregateClient.searchProductBasicInfo(goodsRequest.getProductId());
        if(null!=basicInfoDto){
        	 FitSdpShoppingRequest shoppingReq = new FitSdpShoppingRequest();
             shoppingReq.setQuantity(goodsRequest.getQuantity());
             FitPassengerRequest passengerReq = new FitPassengerRequest();
             passengerReq.setAdultCount(goodsRequest.getAdultQuantity().intValue());
             passengerReq.setChildCount(goodsRequest.getChildQuantity().intValue());
             // 产品id
			shoppingReq.setProductId(String.valueOf(goodsRequest.getProductId()));
            shoppingReq.setBookingSource(goodsRequest.getBookingSource());
            shoppingReq.setCategoryId(String.valueOf(basicInfoDto.getBizCategoryId()));
            shoppingReq.setLineRouteId(String.valueOf(basicInfoDto.getLineRouteId()));
            shoppingReq.setProductName(basicInfoDto.getProductName());
            shoppingReq.setVisitDate(DateUtils.formatDate(goodsRequest.getDepartDate()));
            shoppingReq.setDepCityCode(goodsRequest.getDepCityCode());
        	shoppingReq.setArrCityCode(goodsRequest.getArvCityCode());
        	shoppingReq.setRouteNum(basicInfoDto.getRouteNum());
        	shoppingReq.setStayNum(basicInfoDto.getStayNum());
    	    shoppingReq.setFitPassengerRequest(passengerReq);
            shoppingDto.setFitSdpShoppingRequest(shoppingReq);
        }

//        // 其他票
//        List<FitSdpOtherTicketDto> otherTickets = new ArrayList<FitSdpOtherTicketDto>();
//		if(null!=searchGoodsInfo.getAdditional().getOtherTicketDto()){
//			otherTickets.addAll(searchGoodsInfo.getAdditional().getOtherTicketDto());
//		}
//        shoppingDto.setOtherTickets(otherTickets);
//        // 保险
//        List<FitSdpInsuranceDto> insurances = new ArrayList<FitSdpInsuranceDto>();
//		if(null!=searchGoodsInfo.getAdditional().getInsuranceDto()){
//			insurances.addAll(searchGoodsInfo.getAdditional().getInsuranceDto());
//		}
//        shoppingDto.setInsurances(insurances);
//        // 默认选择第一个保险，将其保存到购物车
//        List<FitSdpInsuranceProductDto> insProducts = searchGoodsInfo.getInsProducts();
//        if (CollectionUtils.isNotEmpty(insurances)) {
//            FitSdpInsuranceProductDto insProductDto = insProducts.get(0);
//            FitSdpInsuranceDto insurance = insProductDto.getInsBranches().get(0);
//            List<FitSdpSelectInsuranceDto> selectInsurances = new ArrayList<FitSdpSelectInsuranceDto>();
//            FitSdpSelectInsuranceDto selectInsurance = new FitSdpSelectInsuranceDto();
//            selectInsurance.setProductName(insurance.getProductName());
//            selectInsurance.setSuppGoodsId(insurance.getSuppGoodsId());
//            selectInsurance.setBranchName(insurance.getBranchName());
//            selectInsurance.setGoodsName(insurance.getGoodsName());
//            selectInsurance.setBranchDesc(insurance.getBranchDesc());
//
//            Long quantity = goodsRequest.getQuantity() == null ? 1L : goodsRequest.getQuantity();
//            Long count = (goodsRequest.getAdultQuantity() + goodsRequest.getChildQuantity()) * quantity;
//            selectInsurance.setSelectCount(count);
//            selectInsurance.setPrice(insurance.getPrice());
//            selectInsurances.add(selectInsurance);
//            shoppingDto.setSelectInsurances(selectInsurances);
//        }
        fitSdpShoppingService.putShoppingCache(goodsRequest.getShoppingUuid(), shoppingDto); 
    } 
 
	/**
	 * 如果有儿童过滤掉没有儿童舱位的航班以及舱位
	 * @param flightInfoDtos
	 */
	private void filterNoChildFlight(List<FlightSearchFlightInfoDto> flightInfoDtos) {

	    List<FlightSearchFlightInfoDto> noUsefulFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
	    for (FlightSearchFlightInfoDto searchFlightInfoDto : flightInfoDtos) {
	    	Map<String,FlightSearchSeatDto> childrenSeats = searchFlightInfoDto.getChildrenSeats();
	    	List<FlightSearchSeatDto> usefulSeats = new ArrayList<FlightSearchSeatDto>();
	    	if(null !=searchFlightInfoDto.getSeats()&&CollectionUtils.isNotEmpty(searchFlightInfoDto.getSeats())&&MapUtils.isNotEmpty(childrenSeats)){
	    		for (FlightSearchSeatDto seatDto : searchFlightInfoDto.getSeats()) {
					if(childrenSeats.containsKey(seatDto.getSeatClassCode())&&childrenSeats.get(seatDto.getSeatClassCode())!=null){
						usefulSeats.add(seatDto);
					}
				}
		    	if(CollectionUtils.isNotEmpty(usefulSeats)){
		    		searchFlightInfoDto.setSeats(usefulSeats);
		    	}else{
		    		noUsefulFlightInfoDtos.add(searchFlightInfoDto);
		    	}
	    	}
		}
	    flightInfoDtos.removeAll(noUsefulFlightInfoDtos);
   }

	/**
	 * 生成筛选条件key，用户更换航班页面的点击相应条件后，筛选相应航班
	 */
	private void setFilterKey(List<FlightSearchFlightInfoDto> flightInfos) {
	    if (CollectionUtils.isEmpty(flightInfos) || CollectionUtils.isEmpty(flightInfos.get(0).getSeats())) {
            return;
        }
	    for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
	        String carrierCode = flightInfo.getCarrierCode();
	        String departureTimeStr = flightInfo.getDepartureTime();
	        Date departureTimeStrDate = DateUtils.parseDate(departureTimeStr, DateUtils.YYYY_MM_DD_HH_MM_SS);
	        String departureSegment = TimeSegment.getTimeSegment(departureTimeStrDate).name();
	        String seatClassType = flightInfo.getSeats().get(0).getSeatClassType();
	        flightInfo.setFilterKey(carrierCode + "|" + departureSegment + "|" + seatClassType);
	    }
	}

	/**
	 * 计算差价
	 */
	private void calculateDiffPrice(List<FlightSearchFlightInfoDto> flightInfos, Long adultQuantity, Long childQuantity, Long quantity) {
	    if (CollectionUtils.isEmpty(flightInfos)
	            || CollectionUtils.isEmpty(flightInfos.get(0).getSeats())) {
	        return;
	    }
	    BigDecimal iniAdultPrice = flightInfos.get(0).getSeats().get(0).getSalesPrice();
	    BigDecimal iniChildPrice = flightInfos.get(0).getSeats().get(0).getChildrenPrice();
	    // 基准价=成人数*成人价+儿童数*儿童价
	    BigDecimal basePrice = iniAdultPrice.multiply(BigDecimal.valueOf(adultQuantity)).add(iniChildPrice.multiply(BigDecimal.valueOf(childQuantity)));
	    for (FlightSearchFlightInfoDto searchFlight : flightInfos) {
	        for (FlightSearchSeatDto seat : searchFlight.getSeats()) {
	            BigDecimal curPrice = seat.getSalesPrice().multiply(BigDecimal.valueOf(adultQuantity)).add(seat.getChildrenPrice().multiply(BigDecimal.valueOf(childQuantity)));
	            seat.setDifferentPrice( (curPrice.subtract(basePrice)).multiply(BigDecimal.valueOf(quantity)) );
	        }
	    }
	}

    /**
     * 1. 将航班按舱位价格由低到高排序
     * 2. 取每个航班的最低价舱位，将航班按排序规则进行排序（起飞时间|价格）
     */
    private void sortByTrafficRule(List<FlightSearchFlightInfoDto> flightInfos,
            FitSdpProductTrafficRulesDto trafficRulesDto) {
        if (CollectionUtils.isNotEmpty(flightInfos)) {
            for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
                List<FlightSearchSeatDto> seats = flightInfo.getSeats();
                if (CollectionUtils.isNotEmpty(seats)) {
                    Collections.sort(flightInfo.getSeats(), new Comparator<FlightSearchSeatDto>() {
                        @Override
                        public int compare(FlightSearchSeatDto o1, FlightSearchSeatDto o2) {
                            return o1.getSalesPrice().compareTo(o2.getSalesParPrice());
                        }
                    });
                }
                List<FlightSearchSeatDto> lastSeats = new ArrayList<FlightSearchSeatDto>();
                lastSeats.add(seats.get(0));
                flightInfo.setSeats(lastSeats);
            }
            if (trafficRulesDto.getSortRuleType() == SortRuleType.SORT_BY_PRICE_ASC) {
                Collections.sort(flightInfos, new Comparator<FlightSearchFlightInfoDto>() {
                    @Override
                    public int compare(FlightSearchFlightInfoDto o1, FlightSearchFlightInfoDto o2) {
                        return o1.getSeats().get(0).getSalesPrice()
                                .compareTo(o2.getSeats().get(0).getSalesPrice());
                    }
                });
            }

            if (trafficRulesDto.getSortRuleType() == SortRuleType.SORT_BY_DEPTIME_ASC) {
                Collections.sort(flightInfos, new Comparator<FlightSearchFlightInfoDto>() {
                    @Override
                    public int compare(FlightSearchFlightInfoDto o1, FlightSearchFlightInfoDto o2) {
                        return DateUtils
                                .parseDate(o1.getDepartureTime(), DateUtils.YYYY_MM_DD_HH_MM_SS)
                                .compareTo(DateUtils.parseDate(o2.getDepartureTime(),
                                        DateUtils.YYYY_MM_DD_HH_MM_SS));
                    }
                });
            }
        }
    }
 
    //查询机票的类型.
    private SuppSaleType[] buildSuppSaleType(){
    	SuppSaleType[] saleTypes= new SuppSaleType[2];
		saleTypes[0] = SuppSaleType.NORMAL;
		saleTypes[1] = SuppSaleType.DomesticProduct;
		//saleTypes[2] = SuppSaleType.GWPolicy;
		return saleTypes;
    }
    
	/**
	 * 构造机票查询请求参数
	 * @param goodsRequest
	 * @return
	 */
    private FlightQueryRequest getFlightQueryRequest(FitSdpGoodsRequest goodsRequest, FitSdpProductTrafficRulesDto trafficRule) {
		FlightQueryRequest flightReq = new FlightQueryRequest();
		// 根据交通规则设置去程时间和返程时间
		Date selectDate = goodsRequest.getDepartDate();
		Date depDate = DateUtils.getDateAfterDateDays(selectDate, trafficRule.getRouteDayNum() - 1);

		flightReq.setDepartureDate(depDate);
		flightReq.setFacet(true);
		
		flightReq.setBookingSource(BookingSource.valueOf(goodsRequest.getBookingSource().getParentSource().name()));
		if (trafficRule.getTrafficTripeType().equals(TrafficTripeType.GO_WAY)) {
			flightReq.setDepartureAirportCode(goodsRequest.getDepCityCode()); 
			flightReq.setArrivalAirportCode(goodsRequest.getArvCityCode()); 
			flightReq.setSaleType(buildSuppSaleType()); 
		}
		if (trafficRule.getTrafficTripeType().equals(TrafficTripeType.BACK_WAY)) { 
			flightReq.setDepartureAirportCode(goodsRequest.getArvCityCode());
			flightReq.setArrivalAirportCode(goodsRequest.getDepCityCode());
			SuppSaleType[] saleTypes= new SuppSaleType[1];
			saleTypes[0] = SuppSaleType.NORMAL;
			flightReq.setSaleType(saleTypes); 
		}
        return flightReq;
    }

	@Override
	public Map<Long, BigDecimal> searchCalendarInfoByProductId(Long productId) {
		Map<Long, List<FitSdpProductCalendarDto>> allCityCalendarInfo = fitSdpCalculateUtils.getAllCityCalendarInfoFromCache(productId);
		Map<Long, BigDecimal> startPriceMap = new HashMap<Long, BigDecimal>();
		for (Long key : allCityCalendarInfo.keySet()) {
			startPriceMap.put(key, fitSdpCalculateUtils.getStartingPrice(allCityCalendarInfo.get(key)));
		}
		return startPriceMap;
	}

	@Override
	public FitSdpProductBasicInfoDto searchProductInfoOnly(Long productId) {
		FitSdpProductBasicInfoDto basicInfo = fitAggregateClient.searchProductInfoOnly(productId); 
		return basicInfo;
	}
	
	
	
	/**
	 * 处理数据得到里面的包机的相关有效航班信息.
	 * @param flightResult
	 * @param trafficRule
	 * @param goodsRequest
	 * @return
	 */
	private List<FlightSearchFlightInfoDto> handleCharterFlightResult(FlightSearchResult<FlightSearchFlightInfoDto> flightResult,
			FitSdpProductTrafficRulesDto goRule,FitSdpProductTrafficRulesDto backRule,FitSdpGoodsRequest goodsRequest) {
			List<FlightSearchFlightInfoDto> flightInfo = flightResult.getResults();
			if (flightResult == null || CollectionUtils.isEmpty(flightInfo)) {
				return null;
			}
			//剔除不是包机切位的航班信息.
			CharterFlightFilterUtil.filterCharterFlight(flightInfo,false);		 
			//根据交通规则过滤航班
			CharterFlightFilterUtil.filterFlightByTrafficRules(flightInfo, goRule,backRule);
			//如果有乘客是儿童，过滤没有儿童舱位的航班或者舱位----包机没有儿童价格。
//			if(goodsRequest.getChildQuantity().intValue() > 0){
//				CharterFlightFilterUtil.filterNoChildFlight(flightInfo);
//			}
			// 过滤库存不足的航班
			CharterFlightFilterUtil.filterUnderStockFlight(goodsRequest, flightInfo);
			// 组装对应的返程航班-政策id-舱位的映射关系list.
			flightInfo = CharterFlightFilterUtil.setNewFlightDtoes(flightInfo); 
			// 按后台设置的排序规则排序
			CharterFlightFilterUtil.sortByTrafficRule(flightInfo, goRule,backRule);
			// 计算差价
			CharterFlightFilterUtil.calculateDiffPrice(flightInfo, goodsRequest.getAdultQuantity(), goodsRequest.getChildQuantity(), goodsRequest.getQuantity());
			// 设置过滤key--没有过滤的界面设置。
			//this.setFilterKey(flightInfo);
			// 设置隔夜航班
			CharterFlightFilterUtil.setOverNightFlightFlag(flightInfo);
			// 过滤筛选条件---没有条件过滤
			//this.filterFacet(flightInfo, flightResult.getFacetMap());

			return flightInfo;
		}
}
