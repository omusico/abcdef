package com.lvmama.lvfit.offline.order.controller;

import javax.servlet.http.HttpServletResponse;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;


/**
 * 订单相关 controller
 * @author wanghuihui
 * @date:2016年1月4日 下午2:46:35
 * @param <I>
 * @param <R>
 */
public interface OrderReportController <I extends Form, R extends BaseResponseDto<? extends Form>>{

	void orderAllExportCsv(FitOrderQueryRequest fitOrderQueryRequest,HttpServletResponse response);

}
