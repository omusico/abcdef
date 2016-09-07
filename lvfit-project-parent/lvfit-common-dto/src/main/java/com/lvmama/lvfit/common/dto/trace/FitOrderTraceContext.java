package com.lvmama.lvfit.common.dto.trace;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvfit.common.dto.order.FitOrderMsgDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOpLogDto;

public class FitOrderTraceContext {


    // 保存订单状态，错误信息
    private static ThreadLocal<List<FitOrderMsgDto>> orderMsgThreadLocal =
            new ThreadLocal<List<FitOrderMsgDto>>();
    
	private static ThreadLocal<List<FitOrderOpLogDto>> threadLocal = new ThreadLocal<List<FitOrderOpLogDto>>();

    public static void setOrderMsg(FitOrderMsgDto orderMsgDto) {
    	List<FitOrderMsgDto> orderMsgDtos = orderMsgThreadLocal.get();
		if(CollectionUtils.isEmpty(orderMsgDtos))
		{
			orderMsgDtos = new ArrayList<FitOrderMsgDto>();
		}
		orderMsgDtos.add(orderMsgDto);
		orderMsgThreadLocal.set(orderMsgDtos);
    }

    public static List<FitOrderMsgDto> getOrderMsg() {
        return orderMsgThreadLocal.get();
    }

	/**
	 * 设置订单操作日志
	 * @param orderOpLogDto		订单操作日志信息
	 */
	public static void setOrderOpLog(FitOrderOpLogDto orderOpLogDto)
	{
		List<FitOrderOpLogDto> orderOpLogDtos = threadLocal.get();
		if(CollectionUtils.isEmpty(orderOpLogDtos))
		{
			orderOpLogDtos = new ArrayList<FitOrderOpLogDto>();
		}
		orderOpLogDtos.add(orderOpLogDto);
		threadLocal.set(orderOpLogDtos);
	}
	
	/**
	 * 获取订单操作日志List
	 * @return
	 */
	public static List<FitOrderOpLogDto> getOrderOpLogs()
	{
		return threadLocal.get();
	}

    public static void clear() {
    	
        orderMsgThreadLocal.set(null);
        orderMsgThreadLocal.remove();
        threadLocal.set(null);
		threadLocal.remove();
    }

}
