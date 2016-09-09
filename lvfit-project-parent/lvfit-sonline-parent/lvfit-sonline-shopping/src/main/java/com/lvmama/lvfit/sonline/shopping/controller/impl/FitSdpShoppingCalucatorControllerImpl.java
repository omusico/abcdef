package com.lvmama.lvfit.sonline.shopping.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.client.FitSdpClient;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountRequest;
import com.lvmama.lvfit.sonline.shopping.FitSdpShoppingCalucatorController;
import com.lvmama.lvfit.sonline.shopping.form.FitSdpCalucateAmountRequestForm;


@SuppressWarnings("rawtypes")
@Controller
public class FitSdpShoppingCalucatorControllerImpl implements FitSdpShoppingCalucatorController {

	@Autowired
	private FitSdpClient fitSdpClient;
	
	@Override
	@RequestMapping(value="calucateAmount",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public BaseSingleResultDto<FitSdpShoppingAmountDto> calucateAmount(FitSdpCalucateAmountRequestForm form) {
	    FitSdpCalculateAmountRequest amountRequest = new FitSdpCalculateAmountRequest();
	    amountRequest.setShoppingUUID(form.getShoppingUUID());
		amountRequest.setBookingSource(BookingSource.FIT_SDP_FRONT); 
		return fitSdpClient.calculateAmount(amountRequest);
	}
}
