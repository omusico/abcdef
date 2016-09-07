/**
 * Project Name:lvfit-adapter-vst
 * File Name:OrderQueryServiceAdapterImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter
 * Date:2015-11-12下午3:25:17
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.adapter;

import com.lvmama.lvfit.common.dto.order.FitOrderDetail;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;
import com.lvmama.vst.back.order.po.OrdOrder;

/**
 * ClassName:OrderQueryServiceAdapterImpl <br/>
 * Function: vst订单是适配器. <br/>
 * Date:     2015-11-12 下午3:25:17 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface OrderQueryServiceAdapter {

	/**
	 * 根据vstOrderId查询VST订单信息
	 * @param vstOrderId
	 * @return
	 */
     OrdOrder queryVstOrderByVstOrderMainNo(Long vstOrderMainNo);
	
     FitOrderDetail getOrderMainByVstOrderMainNo(Long vstOrderMainNo);
     
     FitSuppMainOrderStatusDto getVstOrderStatusByVstOrderMainNo(Long vstOrderMainNo);
    
}

