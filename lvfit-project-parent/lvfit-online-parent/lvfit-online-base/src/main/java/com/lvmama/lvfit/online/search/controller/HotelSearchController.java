package com.lvmama.lvfit.online.search.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;

public interface HotelSearchController<I extends Form
,R extends BaseResponseDto<? extends Form>> {
	/**
	 * 页面点击“更换酒店”按钮
	 */
	String viewAllHotels(Model model, @PathVariable("uuid")String uuid, HttpServletRequest request);
}
