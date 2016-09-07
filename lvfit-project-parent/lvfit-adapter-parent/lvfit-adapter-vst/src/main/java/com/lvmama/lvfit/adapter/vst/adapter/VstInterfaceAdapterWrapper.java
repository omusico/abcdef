package com.lvmama.lvfit.adapter.vst.adapter;

import com.lvmama.vst.back.order.po.OrdOrder;
import com.lvmama.vst.comm.vo.ResultHandleT;
import com.lvmama.vst.comm.vo.order.BuyInfo;

public interface VstInterfaceAdapterWrapper {

	ResultHandleT<OrdOrder> createOrder(final BuyInfo buyInfo, String operatorId);
	
}
