/**
 * Project Name:lvfit-online-base
 * File Name:BookingCalController.java
 * Package Name:com.lvmama.lvfit.online.booking.controller
 * Date:2015-11-19下午6:37:34
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.online.shopping;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.request.CalculateProductPriceRequest;
import com.lvmama.lvfit.common.dto.request.CalculateSalesProductPriceRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;
import com.lvmama.lvfit.common.form.shopping.CalculateProductPriceRequestForm;
import com.lvmama.lvfit.online.shopping.form.CalucateAmountRequestForm;

/**
 * ClassName:BookingCalController <br/>
 * Function: 预定价格计算. <br/>
 * Date: 2015-11-19 下午6:37:34 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public interface ShoppingCalucatorController<I extends Form, R extends BaseResponseDto<? extends Form>> {
	/**
	 * 
	 * calucatePrice:计算产品价格(进入产品选择页面或更换舱位或更换房间时调用). <br/>
	 * 
	 * @author liuweiguo
	 * @param model
	 * @param input
	 * @return
	 * @since JDK 1.6
	 */
	public BaseSingleResultDto<FitShoppingAmountDto> calucateAmount(Model model,CalucateAmountRequestForm form,HttpServletRequest request);
	
	public float calulateProductPrice(CalculateProductPriceRequestForm reqForm);
	
	public float calulateSalesPrice(CalculateSalesProductPriceRequest req);

}
