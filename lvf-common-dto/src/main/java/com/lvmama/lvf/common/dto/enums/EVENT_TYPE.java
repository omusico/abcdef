package com.lvmama.lvf.common.dto.enums;

public enum EVENT_TYPE {
	//-----------机票-------------
//	NULL,//默认值
	/** 机票订单创建成功 */
	FLIGHT_ORDER_CREATE_SUCC,
	
	/** 机票订单取消成功 */
	FLIGHT_ORDER_CANCEL_SUCC,
	
	/** 机票订单支付成功 */
	FLIGHT_ORDER_PAY_SUCC,

	/** 机票订单出票成功 */
	FLIGHT_ORDER_TICKET_SUCC,
	
	/** 机票订单出票失败 */
	FLIGHT_ORDER_TICKET_FAIL,
	
	/** 机票订单退票成功 */
	FLIGHT_ORDER_REFUND_SUCC
}
