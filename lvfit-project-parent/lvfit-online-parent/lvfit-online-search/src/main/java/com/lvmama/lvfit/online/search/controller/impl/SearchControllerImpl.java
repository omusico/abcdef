package com.lvmama.lvfit.online.search.controller.impl;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import com.lvmama.lvfit.common.dto.request.FlightBackQueryRequest;
import com.lvmama.lvfit.common.dto.request.FlightToQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpOtherTicketDto;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProduct;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProductBranch;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotForm;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.utils.HotelUtils;
import com.lvmama.lvfit.online.base.BaseController;
import com.lvmama.lvfit.online.base.utils.DateUtil;
import com.lvmama.lvfit.online.search.controller.SearchController;
import com.lvmama.lvfit.online.search.form.SearchConditionForm;
import com.lvmama.lvfit.online.utils.ServletUtil;
import org.apache.commons.collections.CollectionUtils;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("search")
public class SearchControllerImpl extends BaseController implements SearchController{
	
	private static final Logger logger = LoggerFactory.getLogger(SearchControllerImpl.class);

	
	@Autowired
	private FitDpClient dpClient;
	
	/**
	 * 页面点击搜索
	 */
	@Override
	@RequestMapping(value = "", method = { RequestMethod.POST, RequestMethod.GET })
	public String search(Model model, SearchConditionForm input, HttpServletRequest request) {
	
		if (input.isReturnToError()) {
			return "error";
		}

		if(this.getIsBackBooking(request)) {
			model.addAttribute("isBackBooking", "true");
			input.setBookingSource(BookingSource.FIT_BACK);
		}
		super.initModelData(model, request);
		model.addAttribute("shoppingUUID", input.getShoppingUUID());
		model.addAttribute("searchform", input);
		try {
			FitShoppingDto shoppingDto = dpClient.getShoppingResult(input.getRequest());
			if(null != shoppingDto) {
				model = getShoppingInfos(model, shoppingDto);
			}
		} catch (ExceptionWrapper e) {
			model.addAttribute("errorMsg",e.getErrMessage());
			logger.error("获取机票及酒店信息异常",e);
			return "fh-select";
		}
		
		try {
            /** 根据sessionId 获得常用联系人信息 */
            if (ServletUtil.getSession(request, null, "SESSION_FRONT_USER") != null) {
                ServletUtil.putSession(request, null, "SESSION_FRONT_USER", ServletUtil.getSession(request, null, "SESSION_FRONT_USER"));
            }
        } catch (Exception e) {
            logger.error("根据sessionId 获得常用联系人信息",e);
        }
		return "fh-select";
	}

	@RequestMapping(value = "/backToShopping", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchByShoppingUUID(Model model, HttpServletRequest request) {

		if (this.getIsBackBooking(request).booleanValue()) {
			model.addAttribute("isBackBooking", "true");
		}

		super.initModelData(model, request);
		String shoppingUUID = request.getParameter("shoppingUUID");
		model.addAttribute("shoppingUUID", shoppingUUID);

		FitShoppingDto shoppingDto;
		BaseSingleResultDto<FitShoppingDto> baseDto;

		baseDto = dpClient.getShoppingByUUID(shoppingUUID);
		shoppingDto = baseDto.getResult();

		if (shoppingDto != null) {
			FitBaseSearchRequest searchRequest = shoppingDto.getSearchRequest();
			model.addAttribute("searchform", searchRequest);
			getShoppingInfos(model, shoppingDto);
		}
		return "fh-select";
	}

	public Model getShoppingInfos(Model model, FitShoppingDto shoppingDto){
		FitBaseSearchRequest searchRequest = shoppingDto.getSearchRequest();
		Long days = DateUtils.getDateDiffByDay(searchRequest.getCheckOutTime(), searchRequest.getCheckInTime());

		List<InsuranceInfoDto> flightInsuranceInfos = shoppingDto.getFlightInsuranceInfos();
		model.addAttribute("flightInsuranceInfos", flightInsuranceInfos);

		//---------处理门票数据---------
		List<SpotSearchSpotDto> spotDtos = shoppingDto.getSpots();
		List<SpotSearchSpotForm> spotForm = new ArrayList<SpotSearchSpotForm>();
		if(CollectionUtils.isNotEmpty(spotDtos)){
			for (SpotSearchSpotDto spotDto : spotDtos) {
				spotForm.add(new SpotSearchSpotForm(spotDto));
			}
		}
		
		//---------处理保险数据---------
		List<InsuranceDto> insurances = shoppingDto.getInsurances();
		if (CollectionUtils.isNotEmpty(insurances)) {
			Map<String, List<InsuranceDto>> maps = new HashMap<String, List<InsuranceDto>>();
			for (InsuranceDto insuranceDto : insurances) {
				String productId = insuranceDto.getProductId().toString();
				if (!maps.containsKey(productId)) {
					maps.put(productId, new ArrayList<InsuranceDto>());
				}
				List<InsuranceDto> list = maps.get(productId);
				list.add(insuranceDto);
			}
			model.addAttribute("insuranceMap", maps); //保险信息
		}
		
		model.addAttribute("toFlight", shoppingDto.getToFlightInfos().getResults().get(0));
		if (searchRequest.getTripType().equals(TripeType.WF.name())) {
			model.addAttribute("backFlight", shoppingDto.getBackFlightInfos().getResults().get(0));
		}
		if (shoppingDto.getHotels() != null && CollectionUtils.isNotEmpty(shoppingDto.getHotels().getResults())) {
			model.addAttribute("hotel", shoppingDto.getHotels().getResults().get(0));
		}
		model.addAttribute("stayDays", days);

		model.addAttribute("tripType", searchRequest.getTripType()); //单程|往返
        model.addAttribute("spots", spotForm); //景点信息
        
		return model;
	}
}
