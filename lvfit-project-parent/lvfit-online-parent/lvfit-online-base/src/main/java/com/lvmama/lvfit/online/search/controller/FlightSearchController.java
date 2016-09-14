package com.lvmama.lvfit.online.search.controller;

import javax.servlet.http.HttpServletRequest;

import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeFlightRequest;
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
	 * @return
	 */
	String searchFlightList(Model model, ChangeFlightRequest request, HttpServletRequest servletRequest);
}
