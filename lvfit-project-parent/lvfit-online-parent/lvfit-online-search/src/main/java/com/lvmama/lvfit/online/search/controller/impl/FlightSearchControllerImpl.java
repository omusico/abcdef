package com.lvmama.lvfit.online.search.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.TimeSegment;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeFlightRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
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
	 *
	 * 1.选中的置顶，但是不符合过滤条件则不出现
	 * 2.过滤项和搜索同时有效
	 *
	 * 查询
	 * @param model
	 * @return
	 */
	@Override
	@RequestMapping(value="/flightList" , method={RequestMethod.GET})
	public String searchFlightList(Model model, ChangeFlightRequest request, HttpServletRequest servletRequest) {

		//初始化头部参数信息
		super.initModelData(model, servletRequest);

		BaseSingleResultDto<FitShoppingDto> baseResult = dpClient.getShoppingByUUID(request.getShoppingUUID());
		FitShoppingDto fitShoppingDto = baseResult.getResult();

		FlightSearchResult<FlightSearchFlightInfoDto> flightInfos = new FlightSearchResult<FlightSearchFlightInfoDto>();
		if (request.getFlightType().equals(FlightTripType.DEPARTURE.name())) {
			flightInfos = fitShoppingDto.getToFlightInfos();
		}
		if (request.getFlightType().equals(FlightTripType.RETURN.name())) {
			flightInfos = fitShoppingDto.getBackFlightInfos();
		}

		Map<FlightFacetType, SolrFacetFields> facetMap = flightInfos.getFacetMap();

		List<SolrFacetField> departureTimeSegment = facetMap.get(FlightFacetType.departureTimeSegment).getFields();
		Collections.sort(departureTimeSegment, new Comparator<SolrFacetField>() {
			@Override
			public int compare(SolrFacetField o1, SolrFacetField o2) {
				return o1.getFieldDesc().compareTo(o2.getFieldDesc());
			}
		});

		List<SolrFacetField> arrivalTimeSegment = facetMap.get(FlightFacetType.arrivalTimeSegment).getFields();
		Collections.sort(arrivalTimeSegment, new Comparator<SolrFacetField>() {
			@Override
			public int compare(SolrFacetField o1, SolrFacetField o2) {
				return o1.getFieldDesc().compareTo(o2.getFieldDesc());
			}
		});

		model.addAttribute("req", request);
		model.addAttribute("departureTimeSegment", departureTimeSegment);
		model.addAttribute("arrivalTimeSegment", arrivalTimeSegment);
		model.addAttribute("carrierNameCode", facetMap.get(FlightFacetType.carrierNameCode).getFields());
		model.addAttribute("departureAirportNameCode", facetMap.get(FlightFacetType.departureAirportNameCode).getFields());
		model.addAttribute("arrivalAirportNameCode", facetMap.get(FlightFacetType.arrivalAirportNameCode).getFields());

		model.addAttribute("flightInfos", flightInfos.getResults());
		model.addAttribute("flightCount", flightInfos.getResults().size());
		model.addAttribute("pagination", flightInfos.getPagination());

		return "flight/change-flight";
	}
}
