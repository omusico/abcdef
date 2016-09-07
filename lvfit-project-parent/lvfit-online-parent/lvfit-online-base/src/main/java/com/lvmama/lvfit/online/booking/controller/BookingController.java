/**
 * Project Name:lvfit-online-base
 * File Name:ToBookingController.java
 * Package Name:com.lvmama.lvfit.online.booking.controller
 * Date:2015-11-19下午3:53:13
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.online.booking.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.form.booking.BookingInputForm;

import org.springframework.ui.Model;

/**
 * ClassName:ToBookingController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-11-19 下午3:53:13 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public interface BookingController<I extends Form, R extends BaseResponseDto<? extends Form>> {
	
	/**
	 * showBooking:加载预定页. <br/>
	 * 数据格式校验
	 * 传入shoppingUUID+联系人和乘客信息，组装下单报文到DP的booking服务
	 */
	public Map<String, Object> booking(Model model,HttpServletRequest request, HttpServletResponse response, I i);
	
	/**
	 * bookingFail:下单失败. <br/>
	 * 传入shoppingUUID还原购物车信息
	 */
	public  Map<String, Object> bookingFail(Model model, HttpServletRequest request,
			HttpServletResponse response, BookingInputForm inputForm);
	
}
