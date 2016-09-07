package com.lvmama.lvfit.business.order.service;

import java.util.List;

import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;

/**
 * 订单同步
 * @author qihuisong
 */
public interface OrderSyncService {
    
	/**
	 * 根据vst主订单号同步vst主单状态
	 * @param vstOrderMainNo
	 * @return
	 */
	FitSuppMainOrderStatusDto syncSuppMainOrderStatus(Long vstOrderMainNo);
	
	
	List<FitSuppMainOrderStatusDto> queryNeedToSyncSuppMainOrderStatus();

}
