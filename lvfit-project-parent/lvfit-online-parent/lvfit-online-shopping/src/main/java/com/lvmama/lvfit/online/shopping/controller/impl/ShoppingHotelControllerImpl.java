package com.lvmama.lvfit.online.shopping.controller.impl;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.request.ChangeHotelRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.online.exception.BaseExceptionHandler;
import com.lvmama.lvfit.online.shopping.ShoppingHotelController;
import com.lvmama.lvfit.online.shopping.form.ChangeHotelRequestForm;


@Controller
@RequestMapping("shopping")
public class ShoppingHotelControllerImpl extends BaseExceptionHandler implements ShoppingHotelController{
	private static final Logger logger=LoggerFactory.getLogger(ShoppingHotelControllerImpl.class);
	@Autowired
	private FitDpClient fitDpClient;
	@Override

	@RequestMapping(value="/changehotel",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public BaseResponseDto changeHotel(Model model, ChangeHotelRequestForm form) {
		
		ChangeHotelRequest changeHotelRequest = new ChangeHotelRequest();
		BaseResponseDto baseResponseDto = new BaseResponseDto();
		try {
			BeanUtils.copyProperties(changeHotelRequest, form);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		BaseSingleResultDto<FitShoppingDto> dto = fitDpClient.changeHotel(changeHotelRequest);
		if(dto.getIsSuccess()){
			baseResponseDto.setStatus(ResultStatus.SUCCESS);
		}else{
			baseResponseDto.setStatus(ResultStatus.FAIL);
		}
		return baseResponseDto;
	}

	
	
}
