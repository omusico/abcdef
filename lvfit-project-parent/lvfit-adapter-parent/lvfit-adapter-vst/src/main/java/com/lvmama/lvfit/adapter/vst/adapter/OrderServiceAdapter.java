/**
 * Project Name:lvfit-adapter-vst
 * File Name:OrderServiceAdapter.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter
 * Date:2015-11-13下午6:11:29
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.adapter;

import com.lvmama.lvfit.common.dto.adapter.request.VstBookingRequest;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

/**
 * ClassName:OrderServiceAdapter <br/>
 * Function: vst订单适配器. <br/>
 * Date:     2015-11-13 下午6:11:29 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface OrderServiceAdapter {

    FitSuppMainOrderDto createOrder(VstBookingRequest vstBookingRequest);
}

