package com.lvmama.lvfit.online.search.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.type.TypeReference;
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
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelForm;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.utils.HotelUtils;
import com.lvmama.lvfit.online.base.BaseController;
import com.lvmama.lvfit.online.search.controller.HotelSearchController;


@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("search")
public class HotelSearchControllerImpl extends BaseController implements HotelSearchController {

	
	private static final Logger logger = LoggerFactory.getLogger(HotelSearchControllerImpl.class);

	@Autowired
	private FitDpClient dpClient;
	
	/**
	 * 用户点击预订下一步前预定前记录用户请求信息
	 * @param model
	 * @param request
	 * @param shopingUUID
	 */
	@RequestMapping("/hotel/check/recordBookingLogNoLogin")
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
			logger.error("点击更换酒店后获取机票及酒店信息异常",e);
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
	
	
	
	@Override
	@RequestMapping(value = "/hotels/{uuid}/{l}/{r}/{f}/{b}/{s}/{p}", method = { RequestMethod.GET,RequestMethod.POST })
	public String queryHotels(Model model
			,@PathVariable("uuid")String uuid
			,@PathVariable("l")String l
			,@PathVariable("r")String r
			,@PathVariable("f")String f
			,@PathVariable("b")String b
			,@PathVariable("s")String s
			,@PathVariable("p")String p
			,HttpServletRequest request
			) {
		return queryHotels(model,uuid,l,r,f,b,s,p,null,request);
	}

	@SuppressWarnings("unchecked")
	@Override
	@RequestMapping(value = "/hotels/{uuid}/{l}/{r}/{f}/{b}/{s}/{p}/{queryId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String queryHotels(Model model
			,@PathVariable("uuid")String uuid
			,@PathVariable("l")String l
			,@PathVariable("r")String r
			,@PathVariable("f")String f
			,@PathVariable("b")String b
			,@PathVariable("s")String s
			,@PathVariable("p")String p
			,@PathVariable("queryId")String queryId
			,HttpServletRequest request) {
		
		//1. 初始化头部参数信息
		super.initModelData(model, request);
		
		if(StringUtils.isEmpty(uuid)){
			return "error";
		}
		String pageType = request.getParameter("pageType");
		//2. 获取缓存中数据
		FitShoppingDto fitShoppingDto = null;
		BaseSingleResultDto<FitShoppingDto> baseDto;
		try {
			baseDto = dpClient.getShoppingByUUID(uuid);
			if (baseDto != null && null != baseDto.getResult()){
				fitShoppingDto  = baseDto.getResult();
			}else{
				throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
			}
		} catch (Exception e) {
			logger.error("点击更换酒店后获取机票及酒店信息异常",e);
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper e1 = (ExceptionWrapper)e;
				model.addAttribute("errorMsgOutTime",e1.getErrMessage());
				model.addAttribute("shoppingUuid",uuid);
			}
			if(null !=pageType && pageType.equals("select")){
				return "fh-select";
			}
			return "fh-select-hotel";
		}
		//3. 组装查询酒店的参数
		FitSearchRequest fsr = fitShoppingDto.getSearchRequest();
		HotelQueryRequest hqr = fsr.getHotelSearchRequests().get(0);
		StringBuffer url = new StringBuffer("/search/hotels/");
		assembleQueryRequest(model, uuid, l, r, f, b, s, p, queryId, hqr,url);
		
		//根据酒店名称搜索酒店
		String keywords = request.getParameter("keywords");
		hqr.setKeywords(keywords);
		model.addAttribute("keywords", keywords);
		
		//更换酒店页面标题
		Long days = DateUtils.getDateDiffByDay(hqr.getReturnDate(), hqr.getDepartureDate());
		String rzcs = VSTDistrictCityEnum.getCnName(hqr.getCityCode());
		model.addAttribute("rzcs", rzcs);
		model.addAttribute("rzrq", hqr.getDepartureDate());
		model.addAttribute("fcrq", hqr.getReturnDate());
		model.addAttribute("rzfw", days);
		//缓存中选中的酒店
		HotelSearchHotelDto selectHotelCach = new HotelSearchHotelDto();
		try {
			selectHotelCach = JSONMapper.getInstance().readValue(JSONMapper.getInstance().writeValueAsString(fitShoppingDto.getHotels().get(0)),
					new TypeReference<HotelSearchHotelDto>() {});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//4. 调用更换酒店的接口
		try {
			FitSearchResult results = dpClient.queryHotels(fsr);
			if(null == results){
				return "fh-select-hotel";
			}
			List<HotelSearchResult<HotelSearchHotelDto>> hotelSearchResult = results.getHotelSearchResult();
			if(CollectionUtils.isEmpty(hotelSearchResult)){
				return "fh-select-hotel";
			}
			
			List<HotelSearchHotelDto> result = hotelSearchResult.get(0).getResults();
			// 从缓存中获取筛选条件的map
			//Map<HotelFacetType, Object> facetMap = hotelSearchResult.get(0).getFacetMap();
			//Map<String, Object> selectMap = (Map<String, Object>) facetMap.get(HotelFacetType.selectMap);
			
			Map<String, Object> selectMap = new HashMap<String, Object>();
			
			try {
				selectMap = dpClient.getHotelCondition(uuid);
			} catch (Exception e) {
				logger.error("获取酒店筛选条件出错");
			}
			Map<String, Object> landmarkMap = (Map<String, Object>)selectMap.get("landmarkMap");
			// 地标
			Map<String, Object> sq = new HashMap<String, Object>();
			Map<String, Object> db = new HashMap<String, Object>();
			Map<String, Object> hcz = new HashMap<String, Object>();
			Map<String, Object> ctqccz = new HashMap<String, Object>();
			Map<String, Object> fjc = new HashMap<String, Object>();
			Map<String, Object> jq = new HashMap<String, Object>();
			Map<String, Object> dt = new HashMap<String, Object>();
			if(MapUtils.isNotEmpty(landmarkMap)){
				sq = (Map<String, Object>)landmarkMap.get("商圈");
				db = (Map<String, Object>)landmarkMap.get("地标");
				hcz = (Map<String, Object>)landmarkMap.get("火车站");
				ctqccz = (Map<String, Object>)landmarkMap.get("长途汽车站");
				fjc = (Map<String, Object>)landmarkMap.get("飞机场");
				jq = (Map<String, Object>)landmarkMap.get("景点/景区");
				dt = (Map<String, Object>)landmarkMap.get("地铁");
				model.addAttribute("landmark", db!=null?db.get("地标"):"");
				model.addAttribute("trainStation", hcz!=null?hcz.get("火车站"):"");
				model.addAttribute("metroStation", dt!=null?dt:"");
				model.addAttribute("longBusStation", ctqccz!=null?ctqccz.get("长途汽车站"):"");
				model.addAttribute("spots", jq!=null?jq.get("景点/景区"):"");
				model.addAttribute("airPorts", fjc!=null?fjc.get("飞机场"):"");
				model.addAttribute("businesses", sq!=null?sq.get("商圈"):"");
				model.addAttribute("landmarkMap", landmarkMap);
			}
			
			// 酒店星级
			model.addAttribute("hotelStar", selectMap.get("hotelStar"));
			// 默认显示的酒店名称
			model.addAttribute("hotelBrand",selectMap.get("defalutHotelBrand"));
			// 点击更多酒店时返回的数据
			model.addAttribute("moreHotelBrand",selectMap.get("moreHotelBrand"));
			// 酒店设施
			model.addAttribute("hotelFacilities",selectMap.get("hotelFacilities"));
			model.addAttribute("selectedMap", selectMap.get("selectMap"));
			// 酒店主题
			model.addAttribute("hotelSubject",selectMap.get("hotelSubject"));
			// 是否查询到数据(false：查询到不需要进行二次查询;true：没有查询到需要进行二次查询)
			model.addAttribute("secondQuery", selectMap.get("secondQuery"));
			Pagination pagination = new Pagination();
			pagination = hotelSearchResult.get(0).getPagination();
			//pagination.setRecords(0);
			// 获取分页数据（总条数、页数、当前页数）
			model.addAttribute("pagination", pagination);
			//将url传入前台
			model.addAttribute("url", url.toString().equals("&")?"":url.toString());

			//将shoppinguuid放入model用于选择酒店时的跳转
			model.addAttribute("uuid", uuid);
			model.addAttribute("L", l);
			model.addAttribute("R", r);
			model.addAttribute("F", f);
			model.addAttribute("B", b);
			model.addAttribute("S", s);
			model.addAttribute("P", p);
			
			model.addAttribute("baseAmount", fitShoppingDto.getHotelBasePrice());
			//查询id
			model.addAttribute("queryId", queryId);
			if(CollectionUtils.isEmpty(result)){
				return "fh-select-hotel";
			}
			//获取选中的酒店以及机票的相关信息
			HotelSearchHotelDto selectedHotel = null;
			List<HotelSearchHotelDto> hotels = fitShoppingDto.getSelectedInfo().getHotels();
			if(CollectionUtils.isEmpty(hotels)){
				FitSearchResult queryHotels = dpClient.queryHotels(fsr);
				selectedHotel = queryHotels.getHotelSearchResult().get(0).getResults().get(0);
			}else{
				selectedHotel = selectHotelCach;
			}
			HotelSearchRoomDto roomDto = selectedHotel.getRooms().get(0);
			Integer roomCounts = 1;
			String hotelId = selectedHotel.getProductId();
			String roomId = roomDto.getBranchId();
			String planId = roomDto.getPlans().get(0).getSuppGoodsId();
			String hotelName = selectedHotel.getProductName();
			roomCounts = roomDto.getRoomCounts();
			model.addAttribute("selectedRoomId", roomId);
			model.addAttribute("selectedPlanId", planId);
			model.addAttribute("selectedHotelId", hotelId);
			model.addAttribute("roomCounts", roomCounts);
			model.addAttribute("hotelName", hotelName);
			
			FlightQueryRequest fqr = new FlightQueryRequest();
			fqr = fsr.getFlightSearchRequests().get(0);
			String departureCityName = VSTDistrictCityEnum.getCnName(fqr.getDepartureCityCode());
			String arrivalCityName = VSTDistrictCityEnum.getCnName(fqr.getArrivalCityCode());
			
			model.addAttribute("departureCityName", departureCityName);
			model.addAttribute("arrivalCityName", arrivalCityName);
			
			//成人、儿童数--用于判断推荐房间数
			FitPassengerRequest fitPassengerRequest = new FitPassengerRequest();
			fitPassengerRequest = fsr.getFitPassengerRequest();
			model.addAttribute("adultCount", fitPassengerRequest.getAdultCount());
			model.addAttribute("childCount", fitPassengerRequest.getChildCount());
			
			//获取默认推荐的酒店
			List<HotelSearchHotelDto> recommendedHotels = new ArrayList<HotelSearchHotelDto>();
			if(hqr.getParams().equals("P1")&&null==hqr.getKeywords()){
				recommendedHotels = fitShoppingDto.getRecommendedHotels();
			}
			if(!result.contains(selectHotelCach)&&!recommendedHotels.contains(selectHotelCach)&&hqr.getParams().equals("P1")&&null==hqr.getKeywords()){
				result.add(selectHotelCach);
			}
			result.removeAll(recommendedHotels);
			
			List<HotelSearchHotelForm> hotelFormsFromVst = new ArrayList<HotelSearchHotelForm>();
			//4.1 Form 代理Dto
			hotelDtoChangeToHotelForlm(days, result, hotelFormsFromVst,selectedHotel,recommendedHotels,p);
			//4.2 算取酒店房间差价
			getPriceDifferences(roomCounts, planId,roomId, hotelFormsFromVst,fitShoppingDto.getHotelBasePrice(),fitPassengerRequest.getAdultCount(),fitPassengerRequest.getChildCount());
			//4.3 算取差价后将酒店列表放入到页面中
			model.addAttribute("hotelLists", hotelFormsFromVst);
			//pagination.setRecords(hotelFormsFromVst.size());
			
			// 获取分页数据（总条数、页数、当前页数）
			model.addAttribute("pagination", pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "fh-select-hotel";
	}
	
	/**
	 * @param settlementPrice
	 * @param roomCounts
	 * @param planId
	 * @param roomId
	 * @param hotelFormsFromVst
	 */
	private void getPriceDifferences(Integer roomCounts, String planId, String roomId,
			List<HotelSearchHotelForm> hotelFormsFromVst,BigDecimal hotelBasePrice,int adultNum,int childNum) {
		//算取差价
		for (HotelSearchHotelForm hotelSearchHotelForm2 : hotelFormsFromVst) {
			for (HotelSearchRoomDto room : hotelSearchHotelForm2.getRooms()) {
				
				if(room.getBranchId().equals(roomId)){
					room.setSelectedFlag(Boolean.TRUE);
				}
				
				List<HotelSearchPlanDto> plans = room.getPlans();
				if(CollectionUtils.isNotEmpty(plans)){
					for (HotelSearchPlanDto plan : plans) {
						//取每日价格做差价计算
						List<FitHotelPlanPriceDto> dayPriceList =plan.getDayPrice();
						BigDecimal planSettlementPrice = new BigDecimal(0);
						BigDecimal planSalesPrice = new BigDecimal(0);
						if(CollectionUtils.isNotEmpty(dayPriceList)){
							Integer inventoryCount = null;//商品库存
							List<Integer> inventoryCounts = new ArrayList<Integer>();//该商品所有天的库存集合
							
							for (FitHotelPlanPriceDto fitHotelPlanPriceDto : dayPriceList) {
								planSettlementPrice = planSettlementPrice.add(fitHotelPlanPriceDto.getSettlePrice());
								planSalesPrice = planSalesPrice.add(fitHotelPlanPriceDto.getSalesPrice());
								if("Y".equals(fitHotelPlanPriceDto.getStockFlag())){//只查保留房的库存
									inventoryCount = fitHotelPlanPriceDto.getInventoryCount();
									inventoryCounts.add(inventoryCount);
								}
							}
							plan.setSettlementPrice(planSettlementPrice);
							plan.setPrice(planSalesPrice);
							//plan.setPriceDifferences(planSettlementPrice.multiply(new BigDecimal(roomCounts)).subtract(hotelBasePrice));
							plan.setMinRoomCounts(HotelUtils.getMinRoomCount(adultNum, childNum));
							int newRoomCount = roomCounts<plan.getMaxQuantity()?roomCounts:plan.getMinRoomCounts();
							if(plan.getSuppGoodsId().equals(planId)){
								plan.setSelectedFlag(Boolean.TRUE);
								plan.setPriceDifferences(planSalesPrice.multiply(new BigDecimal(roomCounts)).subtract(hotelBasePrice));
							}else{
								plan.setPriceDifferences(planSalesPrice.multiply(new BigDecimal(newRoomCount)).subtract(hotelBasePrice));
							}
							//设置前台房间数上限     成人数<最大订购量?成人数:最大订购量
							int maxRoomCount = adultNum<plan.getMaxQuantity()?adultNum:plan.getMaxQuantity();
							if(CollectionUtils.isNotEmpty(inventoryCounts)){
								Collections.sort(inventoryCounts);
								plan.setMaxRoomCounts(maxRoomCount>inventoryCounts.get(0)?inventoryCounts.get(0):maxRoomCount);
							}else{
								plan.setMaxRoomCounts(maxRoomCount);
							}
							
//							logger.info(plan.getGoodsName()+"最小房间数="+plan.getMinRoomCounts()+";最大房间数:"+plan.getMaxRoomCounts());
						}else{
							logger.error("未能获取到商品时间价格，ProductId="+plan.getProductId()+";goodsId="+plan.getSuppGoodsId()+";goodsName="+plan.getGoodsName());
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * @param days
	 * @param results
	 * @param hotelFormsFromVst
	 */
	private void hotelDtoChangeToHotelForlm(Long days,List<HotelSearchHotelDto> results,List<HotelSearchHotelForm> hotelFormsFromVst,HotelSearchHotelDto selectedHotel,List<HotelSearchHotelDto> recommendedHotels,String pageNumber) {
		int index = 1;
		if(pageNumber.equals("1")&&CollectionUtils.isNotEmpty(recommendedHotels)){//将默认推荐的酒店放在第一页
			for (HotelSearchHotelDto hotelSearchHotelDto : recommendedHotels) {
				List<HotelSearchRoomDto> roomList = new ArrayList<HotelSearchRoomDto>();
				if(hotelSearchHotelDto.getProductId().equals(selectedHotel.getProductId())){
					//对选中的酒店中选中的plan进行置顶操作
					handleSelectedHotel(days, hotelFormsFromVst, selectedHotel,
							hotelSearchHotelDto, roomList);
					continue;
				}
				if(CollectionUtils.isNotEmpty(hotelSearchHotelDto.getRooms())){
					for (HotelSearchRoomDto hotelSearchRoomDto : hotelSearchHotelDto.getRooms()) {
						filterHotel(days, roomList, hotelSearchRoomDto);
					}
					if(CollectionUtils.isNotEmpty(roomList)){
						hotelSearchHotelDto.setRooms(roomList);
						hotelFormsFromVst.add(new HotelSearchHotelForm(hotelSearchHotelDto));
					}
				}
				if(index<recommendedHotels.size()){
					index++;
				}
			}
		}
		if(CollectionUtils.isNotEmpty(results)){
			for (HotelSearchHotelDto hotelSearchHotelDto : results) {
				List<HotelSearchRoomDto> roomList = new ArrayList<HotelSearchRoomDto>();
				//已选酒店只有在默认条件下才置顶显示---第一页、驴妈妈推荐排序
				/*if(hotelSearchHotelDto.getProductId().equals(selectedHotel.getProductId())){
					handleSelectedHotel(days, hotelFormsFromVst, selectedHotel,
							hotelSearchHotelDto, roomList);
					continue;
				}*/
				//产品房型为空为空不显示改产品
				if(CollectionUtils.isNotEmpty(hotelSearchHotelDto.getRooms())){
					for (HotelSearchRoomDto hotelSearchRoomDto : hotelSearchHotelDto.getRooms()) {
						filterHotel(days, roomList, hotelSearchRoomDto);
					}
					if(CollectionUtils.isNotEmpty(roomList)){
						hotelSearchHotelDto.setRooms(roomList);
						hotelFormsFromVst.add(new HotelSearchHotelForm(hotelSearchHotelDto));
					}
				}
			}
			
		}
	}

	/**
	 * 
	 * @param days
	 * @param hotelFormsFromVst
	 * @param selectedHotel
	 * @param hotelSearchHotelDto
	 * @param roomList
	 */
	private void handleSelectedHotel(Long days,List<HotelSearchHotelForm> hotelFormsFromVst,HotelSearchHotelDto selectedHotel,HotelSearchHotelDto hotelSearchHotelDto,
			List<HotelSearchRoomDto> roomList) {
		if(CollectionUtils.isNotEmpty(hotelSearchHotelDto.getRooms())){
			for (HotelSearchRoomDto hotelSearchRoomDto : hotelSearchHotelDto.getRooms()) {
				//房型下商品为空不显示改房型
				filterHotel(days, roomList, hotelSearchRoomDto);
			}
			if(CollectionUtils.isNotEmpty(roomList)){
				hotelSearchHotelDto.setRooms(roomList);
				HotelSearchHotelForm selectedHotelForm = stickiePlan(new HotelSearchHotelForm(hotelSearchHotelDto),selectedHotel);
				hotelFormsFromVst.add(0,selectedHotelForm);
			}
		}
	}
	
	/**
	 * @param days
	 * @param roomList
	 * @param hotelSearchRoomDto
	 */
	private void filterHotel(Long days, List<HotelSearchRoomDto> roomList,
			HotelSearchRoomDto hotelSearchRoomDto) {
		if(CollectionUtils.isNotEmpty(hotelSearchRoomDto.getPlans())){
			List<HotelSearchPlanDto> planList = new ArrayList<HotelSearchPlanDto>();
			for (HotelSearchPlanDto hotelSearchPlanDto : hotelSearchRoomDto.getPlans()) {
				if(CollectionUtils.isNotEmpty(hotelSearchPlanDto.getDayPrice())&&hotelSearchPlanDto.getDayPrice().size()==days){
					planList.add(hotelSearchPlanDto);
				}
			}
			if(CollectionUtils.isNotEmpty(planList)){
				hotelSearchRoomDto.setPlans(planList);
				roomList.add(hotelSearchRoomDto);
			}
		}
	}	
	
	
	/**
	 * 将选中的plan进行置顶操作
	 * @param hotelSearchHotelForm
	 * @param selectedHotel 
	 * @return
	 */
	private HotelSearchHotelForm stickiePlan(HotelSearchHotelForm hotelSearchHotelForm, HotelSearchHotelDto selectedHotel) {
		// 默认显示的房间
		List<HotelSearchRoomDto> rooms = hotelSearchHotelForm.getRooms();
		List<HotelSearchPlanDto> plans = new ArrayList<HotelSearchPlanDto>();
		List<HotelSearchRoomDto> newrooms = new ArrayList<HotelSearchRoomDto>();
		List<HotelSearchPlanDto> newplans = new ArrayList<HotelSearchPlanDto>();
		HotelSearchRoomDto selectedRoom = selectedHotel.getRooms().get(0); 
		for(HotelSearchRoomDto room :rooms){
			if(room.getBranchId().equals(selectedRoom.getBranchId())){
				room.setSelectedFlag(Boolean.TRUE);
				newrooms.add(0,room);//将选中的房间放在最上面显示
				plans = room.getPlans();
				for(HotelSearchPlanDto plan:plans){
					if(plan.getSuppGoodsId().equals(selectedRoom.getPlans().get(0).getSuppGoodsId())){
						plan.setSelectedFlag(Boolean.TRUE);
						newplans.add(0, plan);//将选中的plan放在最上面显示
					} else {
						plan.setSelectedFlag(Boolean.FALSE);
						newplans.add(plan);
					}
				}
			} else {
				room.setSelectedFlag(Boolean.FALSE);
				for (HotelSearchPlanDto hotelSearchPlanDto : room.getPlans()) {
					hotelSearchPlanDto.setSelectedFlag(Boolean.FALSE);
				}
				newrooms.add(room);
			}
		}
		for(HotelSearchRoomDto room :newrooms){
			if(room.getSelectedFlag()){
				room.setPlans(newplans);
			}
		}
		hotelSearchHotelForm.setRooms(newrooms);
		return hotelSearchHotelForm;
	}	
	
	/**
	 * @param model
	 * @param uuid
	 * @param l
	 * @param r
	 * @param f
	 * @param b
	 * @param s
	 * @param p
	 * @param queryId
	 * @param hqr
	 */
	private void assembleQueryRequest(Model model, String uuid, String l,
			String r, String f, String b, String s, String p, String queryId,
			HotelQueryRequest hqr,StringBuffer url) {
		url.append(uuid);
		//拼接筛选、排序、分页等条件
		StringBuffer paramStr = new StringBuffer();
		// 获取酒店商圈的筛选条件
		if(!"ALL".equals(l)){
			setConditions(model, url, paramStr, l.replace("-",","),"L");
		}else{
			url.append("/ALL");
		}
		// 获取酒店星级的筛选条件
		if(!"ALL".equals(r)){
			setConditions(model, url, paramStr, r.replace("-",","),"R");
		}else{
			url.append("/ALL");
		}
		// 获取酒店设施的筛选条件
		if(!"ALL".equals(f)){
			setConditions(model, url, paramStr, f.replace("-",","),"F");
		}else{
			url.append("/ALL");
		}
		// 获取酒店品牌的筛选条件
		if(!"ALL".equals(b)){
			setConditions(model, url, paramStr, b.replace("-",","),"B");
		}else{
			url.append("/ALL");
		}
		//排序的类型
		if(!"ALL".equals(s)){
			setConditions(model, url, paramStr,s.replace("-",","),"S");
		}else{
			//跟产品选择页保持一致，默认按照好评率排序
			url.append("/ALL");
		}
		//分页的页码
		if (StringUtils.isNumeric(p)){
			paramStr.append( "P" + p);
		}
		//查询id
		if(StringUtils.isEmpty(queryId)){
			queryId = UUID.randomUUID().toString().replaceAll("-", "");
		}
		
		hqr.setParams(paramStr.toString());
		//查询id
		hqr.setQueryId(queryId);
		
		//更换酒店时，将默认推荐推荐的酒店的id
		if(!hqr.getHotelFromRecommendedOnly()){
			hqr.setKeywords(null);//应产品要求，现在只查对应城市的的对应酒店,二期改回
		}
	}
	
	/**
	 * @param model
	 * @param url
	 * @param paramStr
	 * @param jdxj
	 * @return
	 */
	private void setConditions(Model model, StringBuffer url,StringBuffer paramStr, String jdxj,String kinds) {
		if (!"".equals(jdxj)&&null!=jdxj) {
			jdxj = kinds+jdxj;
			paramStr.append(jdxj);
			//url.append(kinds+"=");
			url.append("/");
			url.append(jdxj.replaceAll(kinds, ""));
			//url.append("&");
			//将选中的酒店星级放入前台，方便下次进行筛选
			model.addAttribute(kinds, jdxj.replaceAll(kinds, ""));
		}
	}
}
