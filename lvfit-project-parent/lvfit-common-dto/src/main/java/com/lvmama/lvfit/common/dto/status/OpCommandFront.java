package com.lvmama.lvfit.common.dto.status;

import com.lvmama.lvfit.common.dto.status.order.OrderStatusVaild;

public class OpCommandFront {
	
	/**
	 * 去支付
	 */
	public static final Op APPLY_PAY = new Op("去支付",OpSource.FRONT,
			OpType.PAY, OpAction.APPLY,OpLevel.LEVEL_FOUR);
	
	/**
	 * 去核对
	 */
	public static final Op APPLY_CONFIRM = new Op("去核对",OpSource.FRONT,
			OpType.CONFIRM, OpAction.APPLY,OpLevel.LEVEL_FOUR);

	/**
	 * 隐藏订单
	 */
	public static final Op APPLY_HIDDEN = new Op("删除订单",OpSource.FRONT,
			OpType.HIDDEN, OpAction.APPLY,OpLevel.LEVEL_ZERO);
	
	/**
	 * 申请取消
	 */
	public static final Op APPLY_CANCEL = new Op("取消订单",OpSource.FRONT,
			OpType.CANCEL, OpAction.APPLY,OpLevel.LEVEL_TWO).putVaild(OrderStatusVaild.IS_CAN_CANCEL);
	
	/**
	 * 申请变更
	 */
	public static final Op APPLY_CTMT = new Op("申请变更",OpSource.FRONT,
			OpType.CTMT, OpAction.APPLY,OpLevel.LEVEL_TWO);
	
	/**
	 * 申请退票
	 */
	public static final Op APPLY_RTVT = new Op("申请退票",OpSource.FRONT,
			OpType.RTVT, OpAction.APPLY,OpLevel.LEVEL_TWO);
	
}
