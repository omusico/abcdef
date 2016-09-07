package com.lvmama.lvfit.adapter.vst.adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvfit.adapter.vst.adapter.VstInterfaceAdapterWrapper;
import com.lvmama.lvfit.common.aspect.suppinterface.SuppInterfacePoint;
import com.lvmama.vst.back.client.ord.service.OrderService;
import com.lvmama.vst.back.order.po.OrdOrder;
import com.lvmama.vst.comm.vo.ResultHandleT;
import com.lvmama.vst.comm.vo.order.BuyInfo;

@Service
public class VstInterfaceAdapterWrapperImpl  implements VstInterfaceAdapterWrapper{

	 @Autowired
	 private OrderService orderService;
	
	@Override
	@SuppInterfacePoint(InterfaceKey.FIT_BOOKING_VST)
	public ResultHandleT<OrdOrder> createOrder(BuyInfo buyInfo,String operatorId) {
		 return orderService.createOrder(buyInfo, operatorId);
	}

	

}
