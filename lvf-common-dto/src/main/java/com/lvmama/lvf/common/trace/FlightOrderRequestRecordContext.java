package com.lvmama.lvf.common.trace;

import java.util.List;

import com.lvmama.lvf.common.dto.booking.FlightOrderRequestRecordDto;

/**
 * 订单请求记录上下文
 */
public class FlightOrderRequestRecordContext {
	private static ThreadLocal<List<FlightOrderRequestRecordDto>> threadLocal = new ThreadLocal<List<FlightOrderRequestRecordDto>>();
	
	public static void setOrderReqRecords(List<FlightOrderRequestRecordDto> orderReqRecords){
		threadLocal.set(orderReqRecords);
	}
	
	/**
	 * 获取订单请求记录List
	 * @return
	 */
	public static List<FlightOrderRequestRecordDto> getOrderReqRecords()
	{
		return threadLocal.get();
	}
	
	/**
	 * 清除ThreadLocal存储的订单请求记录
	 */
	public static void clear()
	{
		threadLocal.set(null);
		threadLocal.remove();
	}
}
