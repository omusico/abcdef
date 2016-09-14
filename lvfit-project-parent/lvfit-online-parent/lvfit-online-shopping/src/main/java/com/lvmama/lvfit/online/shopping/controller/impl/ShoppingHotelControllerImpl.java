package com.lvmama.lvfit.online.shopping.controller.impl;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.request.ChangeHotelRequest;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.online.exception.BaseExceptionHandler;
import com.lvmama.lvfit.online.shopping.ShoppingHotelController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("shopping")
public class ShoppingHotelControllerImpl extends BaseExceptionHandler implements ShoppingHotelController{
	private static final Logger logger=LoggerFactory.getLogger(ShoppingHotelControllerImpl.class);
	@Autowired
	private FitDpClient fitDpClient;

	@Override
	@RequestMapping(value="/changePlan",method={RequestMethod.GET,RequestMethod.POST})
	public String changePlan(Model model, ChangeHotelRequest request) {
		BaseSingleResultDto<List<HotelSearchHotelDto>> resultDto = fitDpClient.changeHotel(request);
		model.addAttribute("hotel", resultDto.getResult().get(0));
		return "hotel/hotelInfo";
	}

	@Override
	@RequestMapping(value="/changeHotel",method={RequestMethod.GET,RequestMethod.POST})
	public String changeHotel(Model model, ChangeHotelRequest request) {
		BaseSingleResultDto<List<HotelSearchHotelDto>> resultDto = fitDpClient.changeHotel(request);
		model.addAttribute("hotelLists", resultDto.getResult());
		return "hotel/hotel_list";
	}
}
