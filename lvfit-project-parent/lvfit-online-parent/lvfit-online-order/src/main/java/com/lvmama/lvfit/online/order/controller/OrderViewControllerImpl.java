/**
 * Project Name:lvfit-online-order
 * File Name:OrderViewControllerImpl.java
 * Package Name:com.lvmama.lvfit.online.order.controller
 * Date:2015-12-15下午2:19:01
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.online.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.dto.order.FitOrderDetail;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.form.order.FitOrderDetailResultForm;
import com.lvmama.lvfit.online.base.BaseController;

/**
 * ClassName:OrderViewControllerImpl <br/>
 * Function: 订单详情. <br/>
 * Date:     2015-12-15 下午2:19:01 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("order")
public class OrderViewControllerImpl extends BaseController implements OrderViewController{
	private static final Logger logger=LoggerFactory.getLogger(OrderViewControllerImpl.class);
	@Autowired
	private FitBusinessClient businessClient;
	/**
	 * 机酒订单详情.
	 */
	@Override
	@RequestMapping(value = "/viewDetail", method = RequestMethod.GET)
	public String orderView(Model model,Long orderId,HttpServletRequest request) {
		try {
			//初始化头部参数信息
			super.initModelData(model, request);
		} catch (Exception e) {
			logger.error("获取头部信息异常：", e);
		}
		try {
		    FitOrderMainDto fitOrderMainDto = businessClient.queryOrderMainByVstOrderMainNo(orderId);
		    FitOrderDetailResultForm resultForm = new FitOrderDetailResultForm();
		    if (fitOrderMainDto.getFitOrderNo() != null) {
		        resultForm = FitOrderDetailResultForm.convertFitOrderMainDtoToResultForm(fitOrderMainDto);
		    }
			model.addAttribute("result", resultForm);
			//机票信息
			model.addAttribute("flights", resultForm.getFlights());
			model.addAttribute("ticketNos", resultForm.getTicketNosMap());
			//酒店信息
			model.addAttribute("hotelInfo", resultForm.getHotels());
			//景点门票信息
			model.addAttribute("spotTickets", resultForm.getSpotTickets());
			//保险信息
			model.addAttribute("insurances", resultForm.getInsurances());
			//航意险信息
			model.addAttribute("flightInsurances", resultForm.getFlightInsuranceDtos());
			
		} catch (Exception e) {
			logger.error("获取详情信息异常：" + orderId, e);
		}
		return "order/fh-order-detail";
	}
}

