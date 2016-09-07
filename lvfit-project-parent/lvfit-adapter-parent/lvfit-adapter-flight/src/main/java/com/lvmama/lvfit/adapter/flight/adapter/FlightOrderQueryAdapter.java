package com.lvmama.lvfit.adapter.flight.adapter;

import com.lvmama.lvfit.common.dto.adapter.request.FlightOrderQueryRequest;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

/**
 * 查询机票单品订单
 * @author qihuisong
 */
public interface FlightOrderQueryAdapter {

    /** 查询订单详情，拿到票号 */
	FitSuppMainOrderDto completeSuppFlightInfo(FlightOrderQueryRequest flightOrderQueryRequest);


}
