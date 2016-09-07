package com.lvmama.lvfit.online.hotel.controller;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.form.hotel.HotelDetailForm;

public interface HotelController <I extends Form, R extends BaseResponseDto<? extends Form>>{
	/**
	 *  点击酒店，查看酒店详情
	 * @author wanghuihui
	 * @date:2015年12月3日 下午4:24:14
	 * @param model
	 * @param hotelDetailForm
	 * @return
	 */
	public FitHotelDto showHotelDetail(Model model,HotelDetailForm hotelDetailForm);

}
