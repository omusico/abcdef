package com.lvmama.lvfit.business.booking.service;

import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

/**
 * 预定
 * @author qihuisong
 */
public interface FitBookingService {

    /**
     * 创建机酒系统订单 mainOrder--order--orderdetail
     * 
     * 完整的预定过程:
     * booking 创建机酒系统订单
     * -->并发1vst订单预定  获取vst主订单Id和子订单Id/并发2机票订单预定 获取机票主订单Id和子订单Id
     * -->机票订单和VST主单和机票子单关系绑定/触发vst订单资源审核callback
     * -->回填信息到机酒系统订单
     * 
     * @param fitOrderBookingRequest
     * @return
     */
    FitOrderMainDto booking(FitOrderBookingRequest fitOrderBookingRequest);

    public void storeOrder(FitOrderMainDto orderMainDto);

    ResultStatus validatePassengers(FitOrderBookingRequest fitOrderBookingRequest);
}
