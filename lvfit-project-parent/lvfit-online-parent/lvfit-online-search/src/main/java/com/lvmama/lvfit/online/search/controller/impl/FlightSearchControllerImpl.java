package com.lvmama.lvfit.online.search.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.solr.json.base.select.SolrFacetField;
import com.lvmama.lvf.common.solr.json.base.select.SolrFacetFields;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.FlightFacetType;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.online.base.BaseController;
import com.lvmama.lvfit.online.search.controller.FlightSearchController;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("search")
public class FlightSearchControllerImpl extends BaseController implements FlightSearchController {

	private static final Logger logger = LoggerFactory.getLogger(FlightSearchControllerImpl.class);

	@Autowired
	private FitDpClient dpClient;
	
	
	
	
	
	 /**
	 * 用户点击预订下一步前预定前记录用户请求信息
	 * @param model
	 * @param request
	 * @param shopingUUID
	 */
	@RequestMapping("/flight/check/recordBookingLogNoLogin")
	@ResponseBody
	public Map<String, Object>  recordBookingLogNoLogin(HttpServletRequest request,@RequestParam String shopingUUID) {
		Map<String, Object> map = new HashMap<String, Object>();
		FitShoppingDto fitShoppingDto = null;
		BaseSingleResultDto<FitShoppingDto> baseDto;
		try {
			baseDto = dpClient.getShoppingByUUID(shopingUUID);
			if (baseDto != null && null != baseDto.getResult()){
				fitShoppingDto  = baseDto.getResult();
			}else{
				throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
			}
		} catch (Exception e) {
			logger.error("点击更换航班后获取机票及酒店信息异常",e);
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper e1 = (ExceptionWrapper)e;
				map.put("isSuccess", ResultStatus.FAIL.name());
				map.put("errMessage", e1.getErrMessage());
			}else{
				map.put("isSuccess", ResultStatus.FAIL.name());
				map.put("errMessage", e.getMessage());
			}
			return map;
		}
		
		map.put("isSuccess",ResultStatus.SUCCESS.name());
		return map;
	}
	
	/**
	 * 
	 * 1.选中的置顶，但是不符合过滤条件则不出现
	 * 2.过滤项和搜索同时有效
	 * 
	 * 查询
	 * @param model
	 * @param request
	 * @return
	 */
	@Override
	@RequestMapping(value="/flight/{uuid}/{method}/{init}/{carriers}/{departureTimeSegments}/{arrivalTimeSegments}/{departAirports}/{arriveAirports}/{sortByDepartureTimeDate}/{sortByDiffPrice}/{asc}"
			,method={RequestMethod.GET,RequestMethod.POST})
	public String flight(Model model
			,@PathVariable("uuid")String uuid
			,@PathVariable("method")String method
			,@PathVariable("init")Boolean init
			,@PathVariable("carriers")String carriers
			,@PathVariable("departureTimeSegments")String departureTimeSegments
			,@PathVariable("arrivalTimeSegments")String arrivalTimeSegments
			,@PathVariable("departAirports")String departAirports
			,@PathVariable("arriveAirports")String arriveAirports
			,final @PathVariable("sortByDepartureTimeDate")Boolean sortByDepartureTimeDate
			,final @PathVariable("sortByDiffPrice")Boolean sortByDiffPrice
			,final @PathVariable("asc")String asc,HttpServletRequest request){
		
		//初始化头部参数信息
		super.initModelData(model, request);
		
		String pageType = request.getParameter("pageType");
		if(StringUtils.isEmpty(uuid)){
			return "error";
		}
		try{
			
			/*if(CollectionUtils.isEmpty(dpClient.getShoppingByUUID(uuid).getResult().getFlightInfos())){//缓存过期
				return "redirect:/search/backToShopping?shoppingUUID="+URLEncoder.encode(searchCondition);
			}*/
			FitSearchResult fitSearchResult = null;
			try{
				if(init){
					fitSearchResult = dpClient.queryFlights(uuid,method);
				}else{
					fitSearchResult = dpClient.queryFlights(uuid,method);
				}
			}catch(Exception e){
				// TODO Auto-generated catch block
				logger.error("获取机票信息异常",e);
				if(e instanceof ExceptionWrapper){
					ExceptionWrapper e1 = (ExceptionWrapper)e;
					model.addAttribute("errorMsgOutTime",e1.getErrMessage());
					model.addAttribute("shoppingUuid",uuid);
				}else{
					model.addAttribute("errorMsgOutTime",e.getMessage());
					model.addAttribute("shoppingUuid",uuid);
				}
				if(null !=pageType && pageType.equals("select")){
					return "fh-select";
				}
				if(init){
					return "select-flight";
				}else{
					return "select-flight-search";
				}
			}
			
			FitShoppingDto shoppingDto = new FitShoppingDto();
			BaseSingleResultDto<FitShoppingDto> baseDto;
			try {
				baseDto = dpClient.getShoppingByUUID(uuid);
				if (baseDto != null && null != baseDto.getResult()){
					shoppingDto  = baseDto.getResult();
				} else {
					throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("获取机票及酒店信息异常",e);
				if(e instanceof ExceptionWrapper){
					ExceptionWrapper e1 = (ExceptionWrapper)e;
					model.addAttribute("errorMsgOutTime",e1.getErrMessage());
					model.addAttribute("shoppingUuid",uuid);
				}else{
					model.addAttribute("errorMsgOutTime",e.getMessage());
					model.addAttribute("shoppingUuid",uuid);
				}
				if(null !=pageType && pageType.equals("select")){
					return "fh-select";
				}
				if(init){
					return "select-flight";
				}else{
					return "select-flight-search";
				}
			}
			
			BigDecimal basePrice = new BigDecimal(0);//基准价
			
			List<FlightSearchResult<FlightSearchFlightInfoDto>> flightSearchResults = fitSearchResult.getFlightSearchResult();
			
			if(CollectionUtils.isEmpty(flightSearchResults)){
				if(init){
					return "select-flight";
				}else{
					return "select-flight-search";
				}
			}
			
			FlightSearchResult<FlightSearchFlightInfoDto> result = flightSearchResults.get(0);
				
			List<FlightSearchFlightInfoDto> infos  = result.getResults();
			
			if(CollectionUtils.isEmpty(infos)){
				if(init){
					return "select-flight";
				}else{
					return "select-flight-search";
				}
			}
			
			if(sortByDepartureTimeDate
					||sortByDiffPrice){
				
				Collections.sort(infos,new Comparator<FlightSearchFlightInfoDto>(){
					@Override
					public int compare(FlightSearchFlightInfoDto f1,
							FlightSearchFlightInfoDto f2) {
						String time1 = f1.getDepartureTime();
						String time2 = f2.getDepartureTime();
						if(sortByDepartureTimeDate){
							return "ASC".equals(asc.toUpperCase())?time1.compareTo(time2):-1*time1.compareTo(time2);
						}
						if(sortByDiffPrice){
							BigDecimal price1 = f1.getSeats().get(0).getSalesPrice();
							BigDecimal price2 = f2.getSeats().get(0).getSalesPrice();
							return "ASC".equals(asc.toUpperCase())?price1.compareTo(price2):-1*price1.compareTo(price2);
						}
						return 0;
					}
				});
				
			}
			
			FlightSearchFlightInfoDto selectFlightInfo = null;
			List<HotelSearchHotelDto> hotels = new ArrayList<HotelSearchHotelDto>();
			
			if("to".equals(method)){
				hotels = shoppingDto.getHotels();
				selectFlightInfo = shoppingDto.getFlightInfos().get(0);
				//selectFlightInfo = dpClient.reGetShoppingByShoppingUUID(uuid).getResult().getFlightInfos().get(0);
				//hotels = dpClient.reGetShoppingByShoppingUUID(uuid).getResult().getHotels();
				basePrice = shoppingDto.getToFlightBasePrice();
			}else{
				//selectFlightInfo = dpClient.reGetShoppingByShoppingUUID(uuid).getResult().getFlightInfos().get(1);
				//hotels = dpClient.reGetShoppingByShoppingUUID(uuid).getResult().getHotels();
				hotels = shoppingDto.getHotels();
				selectFlightInfo = shoppingDto.getFlightInfos().get(1);
				basePrice = shoppingDto.getBackFlightBasePrice();
			}
			//获取酒店信息 start
			HotelSearchHotelDto hotelDto = new HotelSearchHotelDto();
			if(CollectionUtils.isNotEmpty(hotels)){
				hotelDto = hotels.get(0);
				if(null != hotelDto){
					model.addAttribute("hotelName", hotelDto.getProductName());
				}
			}
			//获取酒店信息 end
			selectFlightInfo.setBackOrTo(method);
			//原来航班的价格
			/*BigDecimal oldPrice = null;
			List<FlightSearchSeatDto> oldSeats = selectFlightInfo.getSeats();
			for (FlightSearchSeatDto flightSearchSeatDto : oldSeats) {
				if("Y".equals(flightSearchSeatDto.getSeatClassType())){
					BigDecimal adultsPrice = flightSearchSeatDto.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitSearchResult.getSearchRequest().getFitPassengerRequest().getAdultCount()));
					BigDecimal childrenPrice = flightSearchSeatDto.getChildrenPrice().multiply(BigDecimal.valueOf((fitSearchResult.getSearchRequest().getFitPassengerRequest().getChildCount())));
					oldPrice = adultsPrice.add(childrenPrice);
				}
			}*/
			
			
			List<FlightSearchFlightInfoDto> filterInfos = new ArrayList<FlightSearchFlightInfoDto>();
			
			infos.add(0,selectFlightInfo);			
			
			int index = 0;
 			for(FlightSearchFlightInfoDto flightInfo:infos){
				
				if(index!=0
						&&flightInfo.getFlightNo().equals(selectFlightInfo.getFlightNo())){
					continue;
				}
				index++;
				
				if(!"ALL".equals(carriers)
						&&!carriers.contains(flightInfo.getCarrierCode())){
					continue;
				}
				
				if(!"ALL".equals(departureTimeSegments)
						&&!departureTimeSegments.contains(flightInfo.getDepartureTimeSegment())){
					continue;
				}
				
				if(!"ALL".equals(arrivalTimeSegments)
						&&!arrivalTimeSegments.contains(flightInfo.getArrivalTimeSegment())){
					continue;
				}
				if(!"ALL".equals(departAirports)&&!departAirports.contains(flightInfo.getDepartureAirportCode())){
					continue;
				}
				if(!"ALL".equals(arriveAirports)&&!arriveAirports.contains(flightInfo.getArrivalAirportCode())){
					continue;
				}
				

				String departureDate = flightInfo.getDepartureDate();
				String arrivalDate = flightInfo.getArrivalTime().substring(0, flightInfo.getArrivalTime().indexOf(" "));

				flightInfo.setFlyTime(flightInfo.getFlyTime().replace("小时", "h").replace("分钟", "m"));
				
				if (!departureDate.equals(arrivalDate)) {
					flightInfo.setHighLightFlag(true);
				}
				
				filterInfos.add(flightInfo);
			}
			BigDecimal salesPrice = null;
			if(CollectionUtils.isNotEmpty(filterInfos)){
				for (FlightSearchFlightInfoDto fsff : filterInfos) {
					String departureDate = fsff.getDepartureTime().substring(0, 10);
					String arrivalDate = fsff.getArrivalTime().substring(0, 10);
	
					fsff.setDepartureTime(fsff.getDepartureTime().substring(11, 16));
					fsff.setArrivalTime(fsff.getArrivalTime().substring(11, 16));
					fsff.setFlyTime(fsff.getFlyTime().replace("小时", "h").replace("分钟", "m"));
					if (!departureDate.equals(arrivalDate)) {
						fsff.setHighLightFlag(true);
					}
					List<FlightSearchSeatDto> seats = fsff.getSeats();
					for (FlightSearchSeatDto fssd : seats) {
						BigDecimal fadultsPrice = fssd.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitSearchResult.getSearchRequest().getFitPassengerRequest().getAdultCount()));
						BigDecimal fchildrenPrice = fssd.getChildrenPrice().multiply(BigDecimal.valueOf((fitSearchResult.getSearchRequest().getFitPassengerRequest().getChildCount())));
						salesPrice = fadultsPrice.add(fchildrenPrice);
						salesPrice = salesPrice.subtract(basePrice);
						fssd.setDifferentPrice(salesPrice);
					}
				}
				
			}
			
			Map<FlightFacetType, SolrFacetFields> facetMap = fitSearchResult.getFlightSearchResult().get(0).getFacetMap();
			// 航空公司
			List<SolrFacetField> carrierNameFields = null;
			// 起飞时段
			List<SolrFacetField> departureTimeSegmentFields = null;
			// 到达时段
			List<SolrFacetField> arrivalTimeSegmentFields = null;
			// 起飞机场
			List<SolrFacetField> deptAirports = null;
			// 降落机场
			List<SolrFacetField> arriAirports = null;
			//航班名数量
			int nameCountsize =0;
			
			if(!facetMap.isEmpty()){
				carrierNameFields = facetMap.get(FlightFacetType.carrierNameCode).getFields();
				departureTimeSegmentFields = facetMap.get(FlightFacetType.departureTimeSegment).getFields();
				deptAirports = facetMap.get(FlightFacetType.departureAirportNameCode).getFields();
				arriAirports = facetMap.get(FlightFacetType.arrivalAirportNameCode).getFields();
				for (SolrFacetField dtsf : departureTimeSegmentFields) {
					dtsf.setFieldDesc(dtsf.getFieldDesc().replace(",", "(").concat(")"));
				}
				Collections.sort(departureTimeSegmentFields, new Comparator<SolrFacetField>() {

					@Override
					public int compare(SolrFacetField o1, SolrFacetField o2) {
						String fieldDesc1 = o1.getFieldDesc();
						String fieldDesc2 = o2.getFieldDesc();
						if(fieldDesc1.compareTo(fieldDesc2)>0){
							return 1;
						}else if(fieldDesc1.equals(fieldDesc2)){
							return 0;
						}
						return -1;
					}

				});
				arrivalTimeSegmentFields = facetMap.get(FlightFacetType.arrivalTimeSegment).getFields();
				for (SolrFacetField atsf : arrivalTimeSegmentFields) {
					atsf.setFieldDesc(atsf.getFieldDesc().replace(",", "(").concat(")"));
				}
				Collections.sort(arrivalTimeSegmentFields, new Comparator<SolrFacetField>() {

					@Override
					public int compare(SolrFacetField o1, SolrFacetField o2) {
						String fieldDesc1 = o1.getFieldDesc();
						String fieldDesc2 = o2.getFieldDesc();
						if(fieldDesc1.compareTo(fieldDesc2)>0){
							return 1;
						}else if(fieldDesc1.equals(fieldDesc2)){
							return 0;
						}
						return -1;
					}

					
				});
				
				nameCountsize = carrierNameFields.size();
			}
			
			model.addAttribute("fdf", selectFlightInfo);
			//航班数量及航空名数量
			model.addAttribute("size", filterInfos.size());
			model.addAttribute("namesize", nameCountsize);
	
			model.addAttribute("cnf", carrierNameFields);
			model.addAttribute("dtsf", departureTimeSegmentFields);
			model.addAttribute("atsf", arrivalTimeSegmentFields);
			model.addAttribute("deptAirports", deptAirports);
			model.addAttribute("arriAirports", arriAirports);
	
			// 全部航班信息
			model.addAttribute("results", filterInfos);
			
			model.addAttribute("uuid", uuid);
			model.addAttribute("method",method);
			model.addAttribute("init", false);
			model.addAttribute("carriers", carriers);
			model.addAttribute("departureTimeSegments", departureTimeSegments);
			model.addAttribute("arrivalTimeSegments", arrivalTimeSegments);
			model.addAttribute("sortByDepartureTimeDate", String.valueOf(sortByDepartureTimeDate));
			model.addAttribute("sortByDiffPrice", String.valueOf(sortByDiffPrice));
			model.addAttribute("asc", asc);
			
			
		}catch(Exception ex){
			logger.error("获取shopping失败:",ex);
		}
		if(init){
			return "select-flight";
		}else{
			return "select-flight-search";
		}
	}
	
//	/**
//	 * 筛选
//	 * @param model
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value="sort/condition",method={RequestMethod.GET,RequestMethod.POST})
//	public String condition(Model model,HttpServletRequest request){
//		String uuid_flight = request.getParameter("uuidflight");
//		String condition = request.getParameter("condition");
//		String myCondition = request.getParameter("myCondition");
//		String uuid = uuid_flight.substring(0, uuid_flight.indexOf("_"));
//		String method = request.getParameter("method");
//		//获取原来的航班信息
//		FlightSearchFlightInfoDto flightSearchFlightInfoDto = null;
//		//获取请求参数
//		FitSearchRequest searchRequest = null;
//		try {
//			FitShoppingDto fitShoppingDto = dpClient.getShoppingByUUID(uuid).getResult();	
//			searchRequest = fitShoppingDto.getSearchRequest();
//			if("to".equals(method)){
//				fitShoppingDto.getSearchRequest().setBackOrto("to");				
//				flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(0);
//				flightSearchFlightInfoDto.setBackOrTo("to");
//			}else if("back".equals(method)){
//				fitShoppingDto.getSearchRequest().setBackOrto("back");
//				flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(1);
//				flightSearchFlightInfoDto.setBackOrTo("back");
//			}
//			//原来航班的价格
//			BigDecimal oldPrice = null;
//			List<FlightSearchSeatDto> oldSeats = flightSearchFlightInfoDto.getSeats();
//			for (FlightSearchSeatDto flightSearchSeatDto : oldSeats) {
//				if("Y".equals(flightSearchSeatDto.getSeatClassType())){
//					BigDecimal adultsPrice = flightSearchSeatDto.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//					BigDecimal childrenPrice = flightSearchSeatDto.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//					oldPrice = adultsPrice.add(childrenPrice);
//				}
//			}
//			FitSearchResult fitSearchResult = dpClient.queryFlights(searchRequest);
//			
//			//从缓存中拿飞机列表
//			List<FlightSearchFlightInfoDto> results1 = fitSearchResult.getFlightSearchResult().get(0).getResults();
//	       
//			Map<FlightFacetType, SolrFacetFields> facetMap = fitSearchResult.getFlightSearchResult().get(0).getFacetMap();
//			// 航空公司
//			List<SolrFacetField> carrierNameFields = null;
//			// 起飞时段
//			List<SolrFacetField> departureTimeSegmentFields = null;
//			// 到达时段
//			List<SolrFacetField> arrivalTimeSegmentFields = null;
//			//航班名数量
//			int nameCountsize =0;
//			if(!facetMap.isEmpty()){
//				carrierNameFields = facetMap.get(FlightFacetType.carrierNameCode).getFields();
//				departureTimeSegmentFields = facetMap.get(FlightFacetType.departureTimeSegment).getFields();
//				for (SolrFacetField dtsf : departureTimeSegmentFields) {
//					dtsf.setFieldDesc(dtsf.getFieldDesc().replace(",", "(").concat(")"));
//				}
//				arrivalTimeSegmentFields = facetMap.get(FlightFacetType.arrivalTimeSegment).getFields();
//				for (SolrFacetField atsf : arrivalTimeSegmentFields) {
//					atsf.setFieldDesc(atsf.getFieldDesc().replace(",", "(").concat(")"));
//				}
//				nameCountsize = carrierNameFields.size();
//			}
//			//筛选之后的数据
//			List<FlightSearchFlightInfoDto> results = sortByMyCondition(myCondition, results1);
//			//与原来的舱位的差价
//			BigDecimal salesPrice = null;
//			
//			int size = 0 ;
//			
//			if(CollectionUtils.isNotEmpty(results)){
//				for (FlightSearchFlightInfoDto fsff : results) {
//					String departureDate = fsff.getDepartureTime().substring(0, 10);
//					String arrivalDate = fsff.getArrivalTime().substring(0, 10);
//	
//					fsff.setDepartureTime(fsff.getDepartureTime().substring(11, 16));
//					fsff.setArrivalTime(fsff.getArrivalTime().substring(11, 16));
//					fsff.setFlyTime(fsff.getFlyTime().replace("小时", "h").replace("分钟", "m"));
//					if (!departureDate.equals(arrivalDate)) {
//						fsff.setHighLightFlag(true);
//					}
//					List<FlightSearchSeatDto> seats = fsff.getSeats();
//					for (FlightSearchSeatDto fssd : seats) {
//						BigDecimal fadultsPrice = fssd.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//						BigDecimal fchildrenPrice = fssd.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//						salesPrice = fadultsPrice.add(fchildrenPrice);
//						salesPrice = salesPrice.subtract(oldPrice);
//						fssd.setDifferentPrice(salesPrice);
//					}
//				}
//				size = results.size();
//			}
//			
//			
//			model.addAttribute("fdf", flightSearchFlightInfoDto);
//			//航班数量及航空名数量
//			model.addAttribute("size", size);
//			model.addAttribute("namesize", nameCountsize);
//	
//			model.addAttribute("cnf", carrierNameFields);
//			model.addAttribute("dtsf", departureTimeSegmentFields);
//			model.addAttribute("atsf", arrivalTimeSegmentFields);
//	
//			model.addAttribute("uuid", uuid);
//			
//		    model.addAttribute("condition", condition);
//		    model.addAttribute("myCondition", myCondition);
//			// 全部航班信息
//			model.addAttribute("results", results);
//			
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//		return "select-flight";
//	
//	}
//
//	@Override
//	@RequestMapping(value = "/flight", method = { RequestMethod.POST, RequestMethod.GET })
//	public String queryFlights(Model model, HttpServletRequest request) {
//		//拿到的数据
//		FitShoppingDto fitShoppingDto = null;
//		try {
//			String uuid = request.getParameter("uuid");
//			
//			FlightSearchFlightInfoDto flightSearchFlightInfoDto = null;
//			FitSearchRequest fitSearchRequest = null;
//			//原來的飛機票的價格
//			BigDecimal oldPrice = null;
//			
//			BigDecimal flightBasePrice = new BigDecimal(0);
//			
//			if(StringUtils.isNotBlank(uuid)){
//				// 判断是去程还是返程
//				String flightMethod = uuid.substring(uuid.indexOf("_")+1, uuid.length());
//				// 取得缓存中的key
//				uuid = uuid.substring(0, uuid.indexOf("_"));
//				fitShoppingDto = dpClient.getShoppingByUUID(uuid).getResult();
//				fitSearchRequest = fitShoppingDto.getSearchRequest();
//				
//				if ("to".equals(flightMethod)) {
//					// 去程
//					fitSearchRequest.setBackOrto("to");
//					// 获取原先去程对象
//					flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(0);
//					flightSearchFlightInfoDto.setBackOrTo("to");
//					flightBasePrice = fitShoppingDto.getToFlightBasePrice();//获取去程基准价
//				} else if ("back".equals(flightMethod)) {
//					// 返程
//					fitSearchRequest.setBackOrto("back");
//					// 获取原先返程对象
//					flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(1);
//					flightSearchFlightInfoDto.setBackOrTo("back");
//					flightBasePrice = fitShoppingDto.getBackFlightBasePrice();//获取返程基准价
//				}
//				List<FlightSearchSeatDto> oldSeats = flightSearchFlightInfoDto.getSeats();
//				for (FlightSearchSeatDto flightSearchSeatDto : oldSeats) {
//					if("Y".equals(flightSearchSeatDto.getSeatClassType())){
//						BigDecimal adultsPrice = flightSearchSeatDto.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//						BigDecimal childrenPrice = flightSearchSeatDto.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//						oldPrice = adultsPrice.add(childrenPrice);
//					}
//				}
//			}
//			
//			model.addAttribute("oldPrice", oldPrice);
//			// 根据请求信息去查询航班列表
//			FitSearchResult fitSearchResult = dpClient.queryFlights(fitSearchRequest);
//			// 飞机票结果集
//			List<FlightSearchFlightInfoDto> results = fitSearchResult.getFlightSearchResult().get(0).getResults();
//			
//			//将获取到的元素置顶
//			for (ListIterator<FlightSearchFlightInfoDto> iterator = results.listIterator(); iterator.hasNext()!=false;) {
//				FlightSearchFlightInfoDto fsff = iterator.next();
//				if(flightSearchFlightInfoDto.getFlightNo().equals(fsff.getFlightNo())){
//					iterator.remove();
//					
//				}
//			}
//			results.add(0, flightSearchFlightInfoDto);
//			//logger.info("results===="+JSONMapper.getInstance().writeValueAsString(fitSearchResult));
//			Map<FlightFacetType, SolrFacetFields> facetMap = fitSearchResult.getFlightSearchResult().get(0).getFacetMap();
//			// 航空公司
//			List<SolrFacetField> carrierNameFields = null;
//			// 起飞时段
//			List<SolrFacetField> departureTimeSegmentFields = null;
//			// 到达时段
//			List<SolrFacetField> arrivalTimeSegmentFields = null;
//			//航班名数量
//			int nameCountsize =0;
//			if(!facetMap.isEmpty()){
//				carrierNameFields = facetMap.get(FlightFacetType.carrierNameCode).getFields();
//				
//				departureTimeSegmentFields = facetMap.get(FlightFacetType.departureTimeSegment).getFields();
//				for (SolrFacetField dtsf : departureTimeSegmentFields) {
//					dtsf.setFieldDesc(dtsf.getFieldDesc().replace(",", "(").concat(")"));
//				}
//				arrivalTimeSegmentFields = facetMap.get(FlightFacetType.arrivalTimeSegment).getFields();
//				for (SolrFacetField atsf : arrivalTimeSegmentFields) {
//					atsf.setFieldDesc(atsf.getFieldDesc().replace(",", "(").concat(")"));
//				}
//				nameCountsize = carrierNameFields.size();
//			}
//			
//			// 总航班条数
//			int size = results.size();
//			//经济舱与原来的舱位的差价
//			BigDecimal salesPrice = null;
//			//头等舱与原来的舱位的差价
//			//BigDecimal tsalesPrice = null;
//			//公务舱与原来的舱位的差价
//			//BigDecimal gsalesPrice = null;
//			//结果集中的第一个元素
//			//FlightSearchFlightInfoDto firstChangeFlightInfo = null;
//			if(CollectionUtils.isNotEmpty(results)){
//				for (FlightSearchFlightInfoDto fsff : results) {
//					String departureDate = fsff.getDepartureTime().substring(0, 10);
//					String arrivalDate = fsff.getArrivalTime().substring(0, 10);
//	
//					fsff.setDepartureTime(fsff.getDepartureTime().substring(11, 16));
//					fsff.setArrivalTime(fsff.getArrivalTime().substring(11, 16));
//					fsff.setFlyTime(fsff.getFlyTime().replace("小时", "h").replace("分钟", "m"));
//					if (!departureDate.equals(arrivalDate)) {
//						fsff.setHighLightFlag(true);
//					}
//					List<FlightSearchSeatDto> seats = fsff.getSeats();
//					for (FlightSearchSeatDto fssd : seats) {
//	
//						BigDecimal fadultsPrice = fssd.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//						BigDecimal fchildrenPrice = fssd.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//						salesPrice = fadultsPrice.add(fchildrenPrice);
//						salesPrice = salesPrice.subtract(flightBasePrice);
//						fssd.setDifferentPrice(salesPrice);
//	
//						/*if ("Y".equals(fssd.getSeatClassType())) {
//							BigDecimal jsalesAdultsPrice = fssd.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//							BigDecimal jsalesChildrenPrice = fssd.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//							jsalesPrice = jsalesAdultsPrice.add(jsalesChildrenPrice);
//							jsalesPrice = jsalesPrice.subtract(oldPrice);
//							fssd.setDifferentPrice(jsalesPrice);
//						} else if ("C".equals(fssd.getSeatClassType())) {
//							BigDecimal gsalesAdultsPrice = fssd.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//							BigDecimal gsalesChildrenPrice = fssd.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//							gsalesPrice = gsalesAdultsPrice.add(gsalesChildrenPrice);
//							gsalesPrice = gsalesPrice.subtract(oldPrice);
//							fssd.setDifferentPrice(gsalesPrice);
//						} else if ("F".equals(fssd.getSeatClassType())) {
//							BigDecimal tsalesAdultsPrice = fssd.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//							BigDecimal tsalesChildrenPrice = fssd.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//							tsalesPrice = tsalesAdultsPrice.add(tsalesChildrenPrice);
//							tsalesPrice = tsalesPrice.subtract(oldPrice);
//							fssd.setDifferentPrice(tsalesPrice);
//						}	*/					
//					}
//				}
//				
//				//firstChangeFlightInfo = results.get(0);
//				
//			}
//			// 原来对象
//			model.addAttribute("fdf", flightSearchFlightInfoDto);
//			//航班数量及航空名数量
//			model.addAttribute("size", size);
//			model.addAttribute("namesize", nameCountsize);
//	
//			model.addAttribute("cnf", carrierNameFields);
//			model.addAttribute("dtsf", departureTimeSegmentFields);
//			model.addAttribute("atsf", arrivalTimeSegmentFields);
//	
//			model.addAttribute("uuid", uuid);
//			model.addAttribute("request", fitSearchRequest);
//		    
//			//model.addAttribute("fcfi", firstChangeFlightInfo);
//	
//			// 全部航班信息
//			model.addAttribute("results", results);
//	
//		} catch (Exception e) {
//			logger.error("更换航班失败,fitShoppingDto="+fitShoppingDto,e);
//		}
//	
//		return "select-flight";
//	}
//
//	/**
//	 * 根据起飞时间排序
//	 * @param model
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value="sort/time",method={RequestMethod.GET,RequestMethod.POST})
//	public String sortByDepartureTime(Model model,HttpServletRequest request){
//		//uuid
//				String uuid_flight = request.getParameter("uuidflight");
//				//排序状态
//				String status = request.getParameter("timeclass");
//				//去程还是回程
//				String method = request.getParameter("method");
//				//筛选条件
//				String condition = request.getParameter("condition");
//				String myCondition = request.getParameter("myCondition");
//				String uuid = uuid_flight.substring(0, uuid_flight.indexOf("_"));
//				//获取原来的航班信息
//				FlightSearchFlightInfoDto flightSearchFlightInfoDto = null;
//				//获取请求参数
//				FitSearchRequest searchRequest = null;
//				try {
//					FitShoppingDto fitShoppingDto = dpClient.getShoppingByUUID(uuid).getResult();	
//					searchRequest = fitShoppingDto.getSearchRequest();
//					if("to".equals(method)){
//						fitShoppingDto.getSearchRequest().setBackOrto("to");				
//						flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(0);
//						flightSearchFlightInfoDto.setBackOrTo("to");
//					}else if("back".equals(method)){
//						fitShoppingDto.getSearchRequest().setBackOrto("back");
//						flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(1);
//						flightSearchFlightInfoDto.setBackOrTo("back");
//					}	
//					
//					//原来航班的价格
//					BigDecimal oldPrice = null;
//					List<FlightSearchSeatDto> oldSeats = flightSearchFlightInfoDto.getSeats();
//					for (FlightSearchSeatDto flightSearchSeatDto : oldSeats) {
//						if("Y".equals(flightSearchSeatDto.getSeatClassType())){
//							BigDecimal adultsPrice = flightSearchSeatDto.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//							BigDecimal childrenPrice = flightSearchSeatDto.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//							oldPrice = adultsPrice.add(childrenPrice);
//						}
//					}
//					FitSearchResult fitSearchResult = dpClient.queryFlights(searchRequest);
//					//从缓存中拿飞机列表
//					List<FlightSearchFlightInfoDto> results1 = fitSearchResult.getFlightSearchResult().get(0).getResults();
//					
//					//筛选之后的数据
//					List<FlightSearchFlightInfoDto> results = sortByMyCondition(myCondition, results1);
//					
//					
//					
//					if("sort_up".equals(status)){
//						//升序
//						Collections.sort(results,new Comparator<FlightSearchFlightInfoDto>(){
//							@Override
//							public int compare(FlightSearchFlightInfoDto f1,FlightSearchFlightInfoDto f2) {
//								String time1 = f1.getDepartureTime();
//								String time2 = f2.getDepartureTime();
//								if(time1.compareTo(time2)>0){
//									return 1;
//								}else if(time1.equals(time2)){
//									return 0;
//								}else{
//									return -1;
//								}
//							}
//						} );
//					}else if("sort_down".equals(status)){
//						//降序
//						Collections.sort(results,new Comparator<FlightSearchFlightInfoDto>(){
//							@Override
//							public int compare(FlightSearchFlightInfoDto f1,FlightSearchFlightInfoDto f2) {
//								String time1 = f1.getDepartureTime();
//								String time2 = f2.getDepartureTime();
//								if(time1.compareTo(time2)<0){
//									return 1;
//								}else if(time1.equals(time2)){
//									return 0;
//								}else{
//									return -1;
//								}
//							}
//						} );
//					}
//					
//					//将获取到的元素置顶
//					boolean flag = false;
//					for (ListIterator<FlightSearchFlightInfoDto> iterator = results.listIterator(); iterator.hasNext()!=false;) {
//						//判断原来对象是否在结果里
//						FlightSearchFlightInfoDto fsff = iterator.next();
//						if(flightSearchFlightInfoDto.getFlightNo().equals(fsff.getFlightNo())){
//							flag = true;
//							iterator.remove();
//						}
//					}
//					if(flag){
//						results.add(0, flightSearchFlightInfoDto);
//					}
//					
//					int size = results.size();
//					
//					Map<FlightFacetType, SolrFacetFields> facetMap = fitSearchResult.getFlightSearchResult().get(0).getFacetMap();
//					// 航空公司
//					List<SolrFacetField> carrierNameFields = null;
//					// 起飞时段
//					List<SolrFacetField> departureTimeSegmentFields = null;
//					// 到达时段
//					List<SolrFacetField> arrivalTimeSegmentFields = null;
//					//航班名数量
//					int nameCountsize =0;
//					if(!facetMap.isEmpty()){
//						carrierNameFields = facetMap.get(FlightFacetType.carrierNameCode).getFields();
//						departureTimeSegmentFields = facetMap.get(FlightFacetType.departureTimeSegment).getFields();
//						for (SolrFacetField dtsf : departureTimeSegmentFields) {
//							dtsf.setFieldDesc(dtsf.getFieldDesc().replace(",", "(").concat(")"));
//						}
//	
//						arrivalTimeSegmentFields = facetMap.get(FlightFacetType.arrivalTimeSegment).getFields();
//						for (SolrFacetField atsf : arrivalTimeSegmentFields) {
//							atsf.setFieldDesc(atsf.getFieldDesc().replace(",", "(").concat(")"));
//						}
//	
//						nameCountsize = carrierNameFields.size();
//					}
//					//经济舱与原来的舱位的差价
//					BigDecimal salesPrice = null;
//					FlightSearchFlightInfoDto firstChangeFlightInfo = null;
//					if(CollectionUtils.isNotEmpty(results)){
//						for (FlightSearchFlightInfoDto fsff : results) {
//							String departureDate = fsff.getDepartureTime().substring(0, 10);
//							String arrivalDate = fsff.getArrivalTime().substring(0, 10);
//	
//							fsff.setDepartureTime(fsff.getDepartureTime().substring(11, 16));
//							fsff.setArrivalTime(fsff.getArrivalTime().substring(11, 16));
//							fsff.setFlyTime(fsff.getFlyTime().replace("小时", "h").replace("分钟", "m"));
//							if (!departureDate.equals(arrivalDate)) {
//								fsff.setHighLightFlag(true);
//							}
//							List<FlightSearchSeatDto> seats = fsff.getSeats();
//							for (FlightSearchSeatDto fssd : seats) {
//	
//								BigDecimal fadultsPrice = fssd.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//								BigDecimal fchildrenPrice = fssd.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//								salesPrice = fadultsPrice.add(fchildrenPrice);
//								salesPrice = salesPrice.subtract(oldPrice);
//								fssd.setDifferentPrice(salesPrice);
//								/*if ("Y".equals(fssd.getSeatClassType())) {
//									jsalesPrice = fssd.getFlightTicketPriceDto().getSalesPrice();
//									jsalesPrice = jsalesPrice.subtract(oldPrice);
//									fssd.setDifferentPrice(jsalesPrice);
//								} else if ("C".equals(fssd.getSeatClassType())) {
//									gsalesPrice = fssd.getFlightTicketPriceDto().getSalesPrice();
//									gsalesPrice = gsalesPrice.subtract(oldPrice);
//									fssd.setDifferentPrice(gsalesPrice);
//								} else if ("F".equals(fssd.getSeatClassType())) {
//									tsalesPrice = fssd.getFlightTicketPriceDto().getSalesPrice();
//									tsalesPrice = tsalesPrice.subtract(oldPrice);
//									fssd.setDifferentPrice(tsalesPrice);
//								}*/						
//							}
//						}
//						
//						//firstChangeFlightInfo = results.get(0);
//						
//					}
//					
//					
//					
//					model.addAttribute("fdf", flightSearchFlightInfoDto);
//					//航班数量及航空名数量
//					model.addAttribute("size", size);
//					model.addAttribute("namesize", nameCountsize);
//	
//					model.addAttribute("cnf", carrierNameFields);
//					model.addAttribute("dtsf", departureTimeSegmentFields);
//					model.addAttribute("atsf", arrivalTimeSegmentFields);
//	
//					model.addAttribute("uuid", uuid);
//					
//					model.addAttribute("condition", condition);
//					model.addAttribute("myCondition", myCondition);
//					// 全部航班信息
//					model.addAttribute("results", results);
//					
//					model.addAttribute("tstatus", status);
//					return "select-flight";
//						
//				} catch (Exception e) {
//					e.printStackTrace();
//					
//				}
//				return null;
//	}
//
//	/**
//	 * 根据差价排序
//	 * @param model
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value="sort/price",method={RequestMethod.POST,RequestMethod.GET})
//	public String sortByDifferencePrice(Model model,HttpServletRequest request){
//		//uuid
//		String uuid_flight = request.getParameter("uuidflight");
//		//排序状态
//		String status = request.getParameter("priceclass");
//		//去程还是回程
//		String method = request.getParameter("method");
//		//原来筛选的条件
//		String condition = request.getParameter("condition");
//		String myCondition = request.getParameter("myCondition");
//		String uuid = uuid_flight.substring(0, uuid_flight.indexOf("_"));
//		//获取原来的航班信息
//		FlightSearchFlightInfoDto flightSearchFlightInfoDto = null;
//		//获取请求参数
//		FitSearchRequest searchRequest = null;
//		try {
//			FitShoppingDto fitShoppingDto = dpClient.getShoppingByUUID(uuid).getResult();	
//			searchRequest = fitShoppingDto.getSearchRequest();
//			if("to".equals(method)){
//				fitShoppingDto.getSearchRequest().setBackOrto("to");				
//				flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(0);
//				flightSearchFlightInfoDto.setBackOrTo("to");
//			}else if("back".equals(method)){
//				fitShoppingDto.getSearchRequest().setBackOrto("back");
//				flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(1);
//				flightSearchFlightInfoDto.setBackOrTo("back");
//			}	
//			//原来航班的价格
//			BigDecimal oldPrice = null;
//			List<FlightSearchSeatDto> oldSeats = flightSearchFlightInfoDto.getSeats();
//			for (FlightSearchSeatDto flightSearchSeatDto : oldSeats) {
//				if("Y".equals(flightSearchSeatDto.getSeatClassType())){
//					BigDecimal adultsPrice = flightSearchSeatDto.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//					BigDecimal childrenPrice = flightSearchSeatDto.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//					oldPrice = adultsPrice.add(childrenPrice);
//				}
//			}
//	
//			
//			FitSearchResult fitSearchResult = dpClient.queryFlights(searchRequest);
//			//从缓存中拿飞机列表
//			List<FlightSearchFlightInfoDto> results1 = fitSearchResult.getFlightSearchResult().get(0).getResults();
//			
//		
//			//筛选之后的数据
//			List<FlightSearchFlightInfoDto> results = sortByMyCondition(myCondition, results1);
//			
//			
//			if("sort_up".equals(status)){
//				//升序
//				Collections.sort(results,new Comparator<FlightSearchFlightInfoDto>(){
//					@Override
//					public int compare(FlightSearchFlightInfoDto f1,FlightSearchFlightInfoDto f2) {
//						BigDecimal price1 = f1.getSeats().get(0).getSalesPrice();
//						BigDecimal price2 = f2.getSeats().get(0).getSalesPrice();
//						if(price1.compareTo(price2)>0){
//							return 1;
//						}else if(price1.equals(price2)){
//							return 0;
//						}else{
//							return -1;
//						}
//					}
//				} );
//			}else if("sort_down".equals(status)){
//				//降序
//				Collections.sort(results,new Comparator<FlightSearchFlightInfoDto>(){
//					@Override
//					public int compare(FlightSearchFlightInfoDto f1,FlightSearchFlightInfoDto f2) {
//						BigDecimal price1 = f1.getSeats().get(0).getSalesPrice();
//						BigDecimal price2 = f2.getSeats().get(0).getSalesPrice();
//						if(price1.compareTo(price2)<0){
//							return 1;
//						}else if(price1.equals(price2)){
//							return 0;
//						}else{
//							return -1;
//						}
//					}
//				} );
//			}
//			
//			//将获取到的元素置顶
//			boolean flag = false;
//			for (ListIterator<FlightSearchFlightInfoDto> iterator = results.listIterator(); iterator.hasNext()!=false;) {
//				//判断原来对象是否在结果里
//				FlightSearchFlightInfoDto fsff = iterator.next();
//				if(flightSearchFlightInfoDto.getFlightNo().equals(fsff.getFlightNo())){
//					flag = true;
//					iterator.remove();
//				}
//			}
//			if(flag){
//				results.add(0, flightSearchFlightInfoDto);
//			}
//			
//			
//			
//			int size = results.size();
//			
//			Map<FlightFacetType, SolrFacetFields> facetMap = fitSearchResult.getFlightSearchResult().get(0).getFacetMap();
//			// 航空公司
//			List<SolrFacetField> carrierNameFields = null;
//			// 起飞时段
//			List<SolrFacetField> departureTimeSegmentFields = null;
//			// 到达时段
//			List<SolrFacetField> arrivalTimeSegmentFields = null;
//			//航班名数量
//			int nameCountsize =0;
//			if(!facetMap.isEmpty()){
//				carrierNameFields = facetMap.get(FlightFacetType.carrierNameCode).getFields();
//				departureTimeSegmentFields = facetMap.get(FlightFacetType.departureTimeSegment).getFields();
//				for (SolrFacetField dtsf : departureTimeSegmentFields) {
//					dtsf.setFieldDesc(dtsf.getFieldDesc().replace(",", "(").concat(")"));
//				}
//				arrivalTimeSegmentFields = facetMap.get(FlightFacetType.arrivalTimeSegment).getFields();
//				for (SolrFacetField atsf : arrivalTimeSegmentFields) {
//					atsf.setFieldDesc(atsf.getFieldDesc().replace(",", "(").concat(")"));
//				}
//				nameCountsize = carrierNameFields.size();
//			}
//			//经济舱与原来的舱位的差价
//			BigDecimal salesPrice = null;
//			//头等舱与原来的舱位的差价
//			//BigDecimal tsalesPrice = null;
//			//公务舱与原来的舱位的差价
//			//BigDecimal gsalesPrice = null;
//			//结果集中的第一个元素
//			//FlightSearchFlightInfoDto firstChangeFlightInfo = null;
//			if(CollectionUtils.isNotEmpty(results)){
//				for (FlightSearchFlightInfoDto fsff : results) {
//					String departureDate = fsff.getDepartureTime().substring(0, 10);
//					String arrivalDate = fsff.getArrivalTime().substring(0, 10);
//	
//					fsff.setDepartureTime(fsff.getDepartureTime().substring(11, 16));
//					fsff.setArrivalTime(fsff.getArrivalTime().substring(11, 16));
//					fsff.setFlyTime(fsff.getFlyTime().replace("小时", "h").replace("分钟", "m"));
//					if (!departureDate.equals(arrivalDate)) {
//						fsff.setHighLightFlag(true);
//					}
//					List<FlightSearchSeatDto> seats = fsff.getSeats();
//					for (FlightSearchSeatDto fssd : seats) {
//						BigDecimal fadultsPrice = fssd.getFlightTicketPriceDto().getSalesPrice().multiply(BigDecimal.valueOf(fitShoppingDto.getSearchRequest().getFitPassengerRequest().getAdultCount()));
//						BigDecimal fchildrenPrice = fssd.getChildrenPrice().multiply(BigDecimal.valueOf((fitShoppingDto.getSearchRequest().getFitPassengerRequest().getChildCount())));
//						salesPrice = fadultsPrice.add(fchildrenPrice);
//						salesPrice = salesPrice.subtract(oldPrice);
//						fssd.setDifferentPrice(salesPrice);
//						/*if ("Y".equals(fssd.getSeatClassType())) {
//							jsalesPrice = fssd.getFlightTicketPriceDto().getSalesPrice();
//							jsalesPrice = jsalesPrice.subtract(oldPrice);
//							fssd.setDifferentPrice(jsalesPrice);
//						} else if ("C".equals(fssd.getSeatClassType())) {
//							gsalesPrice = fssd.getFlightTicketPriceDto().getSalesPrice();
//							gsalesPrice = gsalesPrice.subtract(oldPrice);
//							fssd.setDifferentPrice(gsalesPrice);
//						} else if ("F".equals(fssd.getSeatClassType())) {
//							tsalesPrice = fssd.getFlightTicketPriceDto().getSalesPrice();
//							tsalesPrice = tsalesPrice.subtract(oldPrice);
//							fssd.setDifferentPrice(tsalesPrice);
//						}*/						
//					}
//				}
//				
//				//firstChangeFlightInfo = results.get(0);
//				
//			}
//			
//			
//			
//			model.addAttribute("fdf", flightSearchFlightInfoDto);
//			//航班数量及航空名数量
//			model.addAttribute("size", size);
//			model.addAttribute("namesize", nameCountsize);
//	
//			model.addAttribute("cnf", carrierNameFields);
//			model.addAttribute("dtsf", departureTimeSegmentFields);
//			model.addAttribute("atsf", arrivalTimeSegmentFields);
//	
//			model.addAttribute("uuid", uuid);
//			
//			model.addAttribute("condition", condition);
//			model.addAttribute("myCondition", myCondition);
//			// 全部航班信息
//			model.addAttribute("results", results);
//			model.addAttribute("pstatus", status);
//			return "select-flight";
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	private List<FlightSearchFlightInfoDto> sortByMyCondition(
//			String myCondition, List<FlightSearchFlightInfoDto> results) {
//		//CopyOnWriteArrayList<FlightSearchFlightInfoDto> results = new CopyOnWriteArrayList<FlightSearchFlightInfoDto>(results1);
//		if(StringUtils.isNotBlank(myCondition)){
//			if(myCondition.contains("/")){
//				String[] myConditions = myCondition.split("/");
//				String myDepartureCondition = "departureTimeSegment:";
//				String myArrivalCondition = "arrivalTimeSegment:";
//				String myNameCondition = "carrierNameCode:";
//				for (String con : myConditions) {
//					if(con.contains("to")){
//						myDepartureCondition += con.substring(3,con.length())+",";
//					}else if(con.contains("off")){
//						myArrivalCondition += con.substring(4,con.length())+",";
//					}else{
//						myNameCondition += con+",";
//					}
//				}
//				
//				String myAllCondition = myDepartureCondition +"@"+myArrivalCondition+"@"+myNameCondition;
//				String[] myConditionGroup = myAllCondition.split("@");
//		       // CopyOnWriteArrayList<FlightSearchFlightInfoDto> tempDtos = new CopyOnWriteArrayList<FlightSearchFlightInfoDto>();
//				List<FlightSearchFlightInfoDto> tempDtos = new ArrayList<FlightSearchFlightInfoDto>();
//		        for (String string : myConditionGroup) {
//					String conditionName = string.substring(0,string.indexOf(":"));
//					String conditionValues =  string.substring(string.indexOf(":")+1).toUpperCase();
//					
//					if(FlightFacetType.valueOf(conditionName)==FlightFacetType.departureTimeSegment){
//						if(StringUtils.isNotBlank(conditionValues)){
//							
//							for (ListIterator<FlightSearchFlightInfoDto> iterator = results.listIterator();iterator.hasNext();) {
//								FlightSearchFlightInfoDto searchInfo = iterator.next();
//								if(conditionValues.contains(TimeSegment.getTimeSegment(DateUtils.parseDate(searchInfo.getDepartureTime(), DateUtils.YYYY_MM_DD_HH_MM_SS)).name())){
//									tempDtos.add(searchInfo);
//								}
//							}
//							results = tempDtos;
//							tempDtos = new ArrayList<FlightSearchFlightInfoDto>();
//						}
//						
//						
//					}
//		    		if(FlightFacetType.valueOf(conditionName)==FlightFacetType.carrierNameCode){
//		    			if(StringUtils.isNotBlank(conditionValues)){
//							for (ListIterator<FlightSearchFlightInfoDto> iterator = results.listIterator();iterator.hasNext();) {
//								FlightSearchFlightInfoDto searchInfo = iterator.next();
//								if(conditionValues.contains(searchInfo.getCarrierCode())){
//									tempDtos.add(searchInfo);
//								}
//							}
//							results = tempDtos;
//							tempDtos = new ArrayList<FlightSearchFlightInfoDto>();
//		    			}
//					}
//		    		if(FlightFacetType.valueOf(conditionName)==FlightFacetType.arrivalTimeSegment){
//		    			if(StringUtils.isNotBlank(conditionValues)){
//							for (ListIterator<FlightSearchFlightInfoDto> iterator = results.listIterator();iterator.hasNext();) {
//								FlightSearchFlightInfoDto searchInfo = iterator.next();
//								if(conditionValues.contains(TimeSegment.getTimeSegment(DateUtils.parseDate(searchInfo.getArrivalTime(), DateUtils.YYYY_MM_DD_HH_MM_SS)).name())){
//									tempDtos.add(searchInfo);
//								}
//							}
//							results = tempDtos;
//							tempDtos = new ArrayList<FlightSearchFlightInfoDto>();
//			    		}
//					}
//				}
//			}
//			
//		}
//		return results;
//	}
	

}
