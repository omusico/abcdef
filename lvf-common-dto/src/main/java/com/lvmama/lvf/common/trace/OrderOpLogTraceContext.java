package com.lvmama.lvf.common.trace;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import com.lvmama.lvf.common.dto.order.OrderOpLogDto;

/**
 * 订单操作日志监控上下文
 * @author majun
 * @date 2015-6-16
 */
public class OrderOpLogTraceContext 
{
	private static ThreadLocal<List<OrderOpLogDto>> threadLocal = new ThreadLocal<List<OrderOpLogDto>>();
	
	/**
	 * 设置订单操作日志
	 * @param orderOpLogDto		订单操作日志信息
	 */
	public static void setOrderOpLog(OrderOpLogDto orderOpLogDto)
	{
		List<OrderOpLogDto> orderOpLogDtos = threadLocal.get();
		if(CollectionUtils.isEmpty(orderOpLogDtos))
		{
			orderOpLogDtos = new ArrayList<OrderOpLogDto>();
		}
		orderOpLogDtos.add(orderOpLogDto);
		threadLocal.set(orderOpLogDtos);
	}
	
	/**
	 * 获取订单操作日志List
	 * @return
	 */
	public static List<OrderOpLogDto> getOrderOpLogs()
	{
		return threadLocal.get();
	}
	
	/**
	 * 清除ThreadLocal存储的订单操作日志
	 */
	public static void clear()
	{
		threadLocal.set(null);
		threadLocal.remove();
	}
}
