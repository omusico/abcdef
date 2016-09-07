package com.lvmama.lvfit.online.shopping.controller.impl;

import org.apache.commons.lang3.exception.ExceptionUtils;
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
import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.online.exception.BaseExceptionHandler;
import com.lvmama.lvfit.online.shopping.ShoppingFlightController;
import com.lvmama.lvfit.online.shopping.form.ChangeFlightRequestForm;


@Controller
@RequestMapping("shopping")
public class ShoppingFlightControllerImpl extends BaseExceptionHandler implements ShoppingFlightController{
	private static final Logger logger=LoggerFactory.getLogger(ShoppingFlightControllerImpl.class);
	@Autowired
	private FitDpClient fitDpClient;
	
	@Override
	@ResponseBody
	@RequestMapping(value="/changeflight",method={RequestMethod.GET,RequestMethod.POST})
	public BaseResponseDto  changeFlight(Model model, ChangeFlightRequestForm form) {
		
		ChangeFlightRequest request = new ChangeFlightRequest();
		BaseResponseDto baseResponseDto = new BaseResponseDto();
		try {
			BeanUtils.copyProperties(request, form);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		BaseSingleResultDto<FitShoppingDto> dto = fitDpClient.changeFlight(request);
		if(dto.getIsSuccess()){
			baseResponseDto.setStatus(ResultStatus.SUCCESS);
		}else{
			baseResponseDto.setStatus(ResultStatus.FAIL);
		}
		return baseResponseDto;
	}

}
