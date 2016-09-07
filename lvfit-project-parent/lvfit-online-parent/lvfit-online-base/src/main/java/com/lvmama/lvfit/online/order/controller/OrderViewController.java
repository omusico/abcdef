/**
 * Project Name:lvfit-online-base
 * File Name:OrderViewController.java
 * Package Name:com.lvmama.lvfit.online.order.controller
 * Date:2015-11-19下午3:48:48
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.online.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;

/**
 * ClassName:OrderViewController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-11-19 下午3:48:48 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public interface OrderViewController<I extends Form, R extends BaseResponseDto<? extends Form>> {

	/**
	 * 
	 * orderView
	 * 机酒动态订单详情,用于会员中心==>订单列表点击查看订单详情
	 * 
	 * @author liuweiguo
	 * @param model
	 * @param input 
	 * @return
	 * @since JDK 1.6
	 */
	public String orderView(Model model,Long orderId,HttpServletRequest request);
}
