package com.lvmama.lvfit.online.shopping.controller.impl;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.request.FitFilterFlightRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.online.exception.BaseExceptionHandler;
import com.lvmama.lvfit.online.shopping.ShoppingFlightController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("shopping")
public class ShoppingFlightControllerImpl extends BaseExceptionHandler implements ShoppingFlightController{
	@Autowired
	private FitDpClient fitDpClient;

	@RequestMapping(value="/changeFlight" , method={RequestMethod.POST})
	public String changeFlight(Model model, ChangeFlightRequest request) {
		List<FlightSearchFlightInfoDto> flightInfos = fitDpClient.changeFlight(request);
		model.addAttribute("req", request);
		model.addAttribute("flightInfos", flightInfos);
		return "flight/change_flight_list";
	}

	@RequestMapping(value="/changeSeat" , method={RequestMethod.POST})
	public String changeSeat(Model model, ChangeFlightRequest request) {
		List<FlightSearchFlightInfoDto> flightInfos = fitDpClient.changeFlight(request);
		if (request.getFlightType().equals(FlightTripType.DEPARTURE.name())) {
			model.addAttribute("toFlight", flightInfos.get(0));
			return "flight/to_flight";
		}
		if (request.getFlightType().equals(FlightTripType.RETURN.name())) {
			model.addAttribute("backFlight", flightInfos.get(0));
			return "flight/back_flight";
		}
		return "error";
	}

	@RequestMapping(value="/filterFlight" , method={RequestMethod.POST})
	public String filterFlight(Model model, FitFilterFlightRequest request) {
		List<FlightSearchFlightInfoDto> flightInfos = fitDpClient.getFlightInfos(request);
		model.addAttribute("sortField", request.getSortField());
		model.addAttribute("sortType", request.getSortType());
		model.addAttribute("flightInfos", flightInfos);
		return "flight/change_flight_list";
	}
}
