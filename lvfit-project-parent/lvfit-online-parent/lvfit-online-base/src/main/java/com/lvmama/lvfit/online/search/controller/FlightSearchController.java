package com.lvmama.lvfit.online.search.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;

public interface FlightSearchController<I extends Form
,R extends BaseResponseDto<? extends Form>> {
	
	/**
	 * 页面点击“更换航班”按钮  
	 * 
	 * @param model
	 * @param input
	 * @return
	 */
	public String flight(Model model
			,@PathVariable("uuid")String uuid
			,@PathVariable("method")String method
			,@PathVariable("init")Boolean init
			,@PathVariable("carriers")String carriers
			,@PathVariable("departureTimeSegments")String departureTimeSegments
			,@PathVariable("arrivalTimeSegments")String arrivalTimeSegments
			,String deptAirports
			,String arriveAirports
			,final @PathVariable("sortByDepartureTimeDate")Boolean sortByDepartureTimeDate
			,final @PathVariable("sortByDiffPrice")Boolean sortByDiffPrice
			,final @PathVariable("asc")String asc,HttpServletRequest request);
}
