package com.lvmama.lvfit.offline.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryListDto;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;
import com.lvmama.lvfit.common.form.order.FitOrderOpLogForm;
import com.lvmama.lvfit.common.form.order.FitOrderQueryListForm;

/**
 * 订单相关 controller
 * @author wanghuihui
 * @date:2016年1月4日 下午2:46:35
 * @param <I>
 * @param <R>
 */
public interface OrderController {
	/**
	 *  跳转到订单查询页
	 * @author wanghuihui
	 * @date:2016年1月4日 下午2:49:24
	 * @param model
	 * @param request
	 * @param response
	 * @param i
	 * @return
	 */
	public String toOrderQuery(Model model,HttpServletRequest request, HttpServletResponse response);
	
	/**
	 *  订单查询
	 * @author wanghuihui
	 * @date:2016年1月4日 下午2:49:24
	 * @param model
	 * @param request
	 * @param response
	 * @param i
	 * @return
	 */
	public BaseResultDto<FitOrderQueryListForm> OrderQuery(HttpServletRequest request, FitOrderQueryRequest fitOrderQueryRequest);
	
	/**
	 * 跳转到订单详情页
	 * @author wanghuihui
	 * @date:2016年1月4日 下午2:56:01
	 * @param model
	 * @param request
	 * @param response
	 * @param inputForm
	 * @return
	 */
	String toOrderDetail(Model model, Long vstOrderId, Long mainOrderId,
			 FitOrderQueryRequest fitOrderQueryRequest);
	
	/**
	 *  订单详情 日志列表
	 * @author wanghuihui
	 * @date:2016年1月18日 下午2:02:55
	 * @param model
	 * @param mainOrderId
	 * @return
	 */
	BaseResultDto<FitOrderOpLogForm> toOrderLog(Model model,
			FitOrderQueryRequest fitOrderQueryRequest);
	
	/**
	 *  跳转到订单日志列表
	 * @author wanghuihui
	 * @date:2016年1月18日 下午3:10:29
	 * @return
	 */
	String toOrderLog(Model model, Long mainOrderId);


	/**查询机票回调信息列表.
	 * @param model
	 * @return
	 */
	String suppFlightCallBack(Model model);

}
