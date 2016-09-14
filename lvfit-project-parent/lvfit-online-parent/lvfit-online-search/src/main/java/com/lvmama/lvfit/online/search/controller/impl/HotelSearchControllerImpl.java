package com.lvmama.lvfit.online.search.controller.impl;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;
import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import com.lvmama.lvfit.common.dto.request.FitFilterHotelRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelFacetType;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.online.base.BaseController;
import com.lvmama.lvfit.online.search.controller.HotelSearchController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("search")
public class HotelSearchControllerImpl extends BaseController implements HotelSearchController {

	
	private static final Logger logger = LoggerFactory.getLogger(HotelSearchControllerImpl.class);

	@Autowired
	private FitDpClient dpClient;

	@Value("getHotelFromRecommended")
	private String hotelFromRecommended;

	@RequestMapping(value = "/hotelList/{uuid}", method = { RequestMethod.GET})
	public String viewAllHotels(Model model, @PathVariable("uuid")String uuid, HttpServletRequest request) {
		// 初始化头部参数信息
		super.initModelData(model, request);
		
		if(StringUtils.isEmpty(uuid)){
			return "error";
		}
		// 获取缓存中数据
		BaseSingleResultDto<FitShoppingDto> baseDto = dpClient.getShoppingByUUID(uuid);
		FitShoppingDto fitShoppingDto  = baseDto.getResult();
		HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = fitShoppingDto.getHotels();
		FitBaseSearchRequest searchRequest = fitShoppingDto.getSearchRequest();

		// 更换酒店页面标题
		Date checkInDate = DateUtils.parseDate(searchRequest.getCheckInTime(), DateUtils.YYYY_MM_DD);
		Date checkOutDate = DateUtils.parseDate(searchRequest.getCheckOutTime(), DateUtils.YYYY_MM_DD);
		int days = DateUtils.getDateDiffByDay(checkOutDate, checkInDate);

		model.addAttribute("cityName", searchRequest.getCityName());
		model.addAttribute("checkInDate", searchRequest.getCheckInTime());
		model.addAttribute("checkOutDate", searchRequest.getCheckOutTime());
		model.addAttribute("dayDiff", days);

		Map<String, Object> facetMap = (Map<String, Object>)hotelSearchResult.getFacetMap().get(HotelFacetType.selectMap);
		Map<String, Object> landmarkMap = (Map<String, Object>)facetMap.get("landmarkMap");
			// 地标
		if(MapUtils.isNotEmpty(landmarkMap)) {
			Map<String, Object> businesses = (Map<String, Object>)landmarkMap.get("商圈");
			Map<String, Object> landmark = (Map<String, Object>)landmarkMap.get("地标");
			Map<String, Object> trainStation = (Map<String, Object>)landmarkMap.get("火车站");
			Map<String, Object> longBusStation = (Map<String, Object>)landmarkMap.get("长途汽车站");
			Map<String, Object> airPorts = (Map<String, Object>)landmarkMap.get("飞机场");
			Map<String, Object> spots = (Map<String, Object>)landmarkMap.get("景点/景区");
			Map<String, Object> metroStation = (Map<String, Object>)landmarkMap.get("地铁");
			if (MapUtils.isNotEmpty(businesses)) {
				model.addAttribute("businesses", businesses.get("商圈"));
			}
			if (MapUtils.isNotEmpty(landmark)) {
				model.addAttribute("landmark", landmark.get("地标"));
			}
			if (MapUtils.isNotEmpty(trainStation)) {
				model.addAttribute("trainStation", trainStation.get("火车站"));
			}
			if (MapUtils.isNotEmpty(longBusStation)) {
				model.addAttribute("longBusStation", longBusStation.get("长途汽车站"));
			}
			if (MapUtils.isNotEmpty(airPorts)) {
				model.addAttribute("airPorts", airPorts.get("飞机场"));
			}
			if (MapUtils.isNotEmpty(spots)) {
				model.addAttribute("spots", spots.get("景点/景区"));
			}
			if (MapUtils.isNotEmpty(metroStation)) {
				model.addAttribute("metroStation", metroStation);
			}
			model.addAttribute("landmarkMap", landmarkMap);
		}

		// 酒店星级
		model.addAttribute("hotelStar", facetMap.get("hotelStar"));
		// 默认显示的酒店名称
		model.addAttribute("hotelBrand", facetMap.get("defalutHotelBrand"));
		// 点击更多酒店时返回的数据
		model.addAttribute("moreHotelBrand", facetMap.get("moreHotelBrand"));
		// 酒店设施
		model.addAttribute("hotelFacilities", facetMap.get("hotelFacilities"));
		model.addAttribute("selectedMap", facetMap.get("selectMap"));
		// 酒店主题
		model.addAttribute("hotelSubject", facetMap.get("hotelSubject"));
		// 是否查询到数据(false：查询到不需要进行二次查询;true：没有查询到需要进行二次查询)
		model.addAttribute("secondQuery", facetMap.get("secondQuery"));
		Pagination pagination = hotelSearchResult.getPagination();
		// 获取分页数据（总条数、页数、当前页数）
		model.addAttribute("pagination", pagination);

		if (CollectionUtils.isNotEmpty(hotelSearchResult.getResults())) {
			model.addAttribute("hotelLists", hotelSearchResult.getResults());
			// 在页面上保存选中的酒店信息，用于筛选和排序后默认酒店的选择和差价计算
			HotelSearchHotelDto hotelDto = hotelSearchResult.getResults().get(0);
			int roomCounts = hotelDto.getRooms().get(0).getRoomCounts();
			BigDecimal price = hotelDto.getRooms().get(0).getPlans().get(0).getPrice();
			model.addAttribute("hotelBasePrice", price.multiply(BigDecimal.valueOf(roomCounts)));
			model.addAttribute("selHotelId", hotelDto.getProductId());
			model.addAttribute("selHotelRoomId", hotelDto.getRooms().get(0).getBranchId());
			model.addAttribute("selHotelPlanId", hotelDto.getRooms().get(0).getPlans().get(0).getSuppGoodsId());
		}
		model.addAttribute("req", searchRequest);

		return "hotel/change-hotel";
	}


	@RequestMapping(value="/searchHotels",method={RequestMethod.GET,RequestMethod.POST})
	public String searchHotel(Model model, FitFilterHotelRequest request) {
		request.setHotelFromRecommendedOnly(Boolean.valueOf(
			CustomizedPropertyPlaceholderConfigurer.getContextProperty(hotelFromRecommended)+""));
		request.setQueryId(UUID.randomUUID().toString());
		try {
			HotelSearchResult<HotelSearchHotelDto> hotelResult = dpClient.getHotelInfos(request.getHotelRequest());
			List<HotelSearchHotelDto> hotelList = hotelResult.getResults();

			// 将选中的酒店规格放在list首位
			topSelectHotel(request, hotelList);
			// 计算酒店差价
			for (HotelSearchHotelDto hotel : hotelList) {
				for (HotelSearchRoomDto room : hotel.getRooms()) {
					for (HotelSearchPlanDto plan : room.getPlans()) {
						BigDecimal totalPrice = plan.getPrice().multiply(BigDecimal.valueOf(room.getRoomCounts()));
						plan.setPriceDifferences(totalPrice.subtract(BigDecimal.valueOf(request.getHotelBasePrice())));
					}
				}
			}

			model.addAttribute("hotelLists", hotelList);
			model.addAttribute("pagination", hotelResult.getPagination());
			model.addAttribute("hotelBasePrice", request.getHotelBasePrice());
			model.addAttribute("selHotelId", request.getSelHotelId());
			model.addAttribute("selHotelRoomId", request.getSelHotelRoomId());
			model.addAttribute("selHotelPlanId", request.getSelHotelPlanId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hotel/hotel_list";
	}

	private void topSelectHotel(FitFilterHotelRequest request,
		List<HotelSearchHotelDto> hotelList) {
		HotelSearchHotelDto selectHotelDto = null;
		for (int i = 0; i < hotelList.size(); i++) {
            if (request.getSelHotelId().equals(hotelList.get(i).getProductId())) {
                selectHotelDto = hotelList.get(i);
                hotelList.remove(i);
                break;
            }
        }
		if (selectHotelDto != null) {
            HotelSearchRoomDto selectRoom = null;
            for (int j = 0; j < selectHotelDto.getRooms().size(); j++) {
                HotelSearchRoomDto room = selectHotelDto.getRooms().get(j);
                if (request.getSelHotelRoomId().equals(room.getBranchId())) {
                    selectRoom = room;
                    selectHotelDto.getRooms().remove(j);
                    break;
                }
            }
            if (selectRoom != null) {
                HotelSearchPlanDto selectPlan = null;
                for (int k = 0; k < selectRoom.getPlans().size(); k++) {
                    HotelSearchPlanDto plan = selectRoom.getPlans().get(k);
                    if (request.getSelHotelPlanId().equals(plan.getSuppGoodsId())) {
                        selectPlan = plan;
                        selectRoom.getPlans().remove(k);
                        break;
                    }
                }
                if (selectPlan != null) {
                    selectRoom.getPlans().add(0, selectPlan);
                    selectHotelDto.getRooms().add(0, selectRoom);
                    hotelList.add(0, selectHotelDto);
                }
            }
        }
	}
}
