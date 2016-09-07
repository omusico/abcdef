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

import org.springframework.ui.Model;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.form.booking.ToBookingInputForm;

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
public interface ToBookingController<I extends Form, R extends BaseResponseDto<? extends Form>> {
	
	/**
	 * 
	 * showBooking:加载预定页. <br/>  
	 * 传入shoppingUUID，根据shoppingUUID数据加载订单填写页
	 *
	 * @author liuweiguo
	 * @return
	 * @since JDK 1.6
	 */
	public String toBooking(Model model,HttpServletRequest request,ToBookingInputForm input,String shopingUUID,String userId);
	/**
	 *  判断是否登陆
	 * @author wanghuihui
	 * @date:2015年12月20日 下午11:22:46
	 * @param model
	 * @param request
	 * @return
	 */
	Map<String, Object> toBookingLogin(Model model, HttpServletRequest request);
	
	/**
	 * 用户点击预订下一步前预定前记录用户请求信息
	 * @param request
	 * @param shopingUUID
	 * @return 
	 */
	Map<String, Object> recordBookingLogNoLogin(HttpServletRequest request, String shopingUUID);

}
