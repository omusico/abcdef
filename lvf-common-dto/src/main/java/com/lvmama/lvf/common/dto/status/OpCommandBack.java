package com.lvmama.lvf.common.dto.status;

import com.lvmama.lvf.common.dto.status.order.OrderStatusVaild;

public class OpCommandBack {
	
	
	public static final Op APPLY_SUPP_RTVT =  new Op("退票申请供应商处理", OpSource.BACK,
			OpType.RTVT, OpAction.APPLY_SUPP_OP,OpLevel.LEVEL_TWO).putVaild(OrderStatusVaild.IS_CAN_SUPP_RTVT);
			
	public static final Op SUPP_OP_PASS_RTVT =  new Op("退票供应商处理通过",OpSource.BACK,
			OpType.RTVT, OpAction.SUPP_OP_PASS,OpLevel.LEVEL_THREE);

	public static final Op SUPP_OP_REJECT_RTVT =  new Op("退票供应商处理驳回", OpSource.BACK,
			OpType.RTVT, OpAction.SUPP_OP_REJECT,OpLevel.LEVEL_ONE);
	
	public static final Op SYNC_SUPP_RTVT = new Op("同步供应商退票", OpSource.BACK,
			OpType.RTVT, OpAction.SYNC_SUPP_OP,OpLevel.LEVEL_TWO);

	/**
	 * 申请退款
	 */
	public static final  Op APPLY_REFUND = new Op("申请退款",OpSource.BACK,
			OpType.REFUND, OpAction.APPLY,OpLevel.LEVEL_TWO).putVaild(OrderStatusVaild.IS_CAN_REFUND);
	
	/**
	 * 退款完成
	 */
	public static final Op OP_PASS_REFUND = new Op("完成退款",OpSource.BACK,
			OpType.REFUND, OpAction.OP_PASS,OpLevel.LEVEL_THREE);	
	
	/**
	 * 退款失败
	 */
	public static final Op OP_REJECT_REFUND = new Op("退款失败",OpSource.BACK,
			OpType.REFUND, OpAction.OP_REJECT,OpLevel.LEVEL_ONE);	
	
	
	/**
	 * 去支付
	 */
	public static final Op APPLY_PAY = new Op("去支付",OpSource.BACK,
			OpType.PAY, OpAction.APPLY,OpLevel.LEVEL_FOUR).putVaild(OrderStatusVaild.IS_CAN_PAY);
	
	/**
	 * 支付完成
	 */
	public static final Op OP_PASS_PAY = new Op("完成支付",OpSource.BACK,
			OpType.PAY, OpAction.OP_PASS,OpLevel.LEVEL_THREE);	
	
	/**
	 * 支付失败
	 */
	public static final Op OP_REJECT_PAY = new Op("支付失败",OpSource.BACK,
			OpType.PAY, OpAction.OP_REJECT,OpLevel.LEVEL_ONE);	
	
	/**
	 * 支付超时
	 */
	public static final Op OP_OUTTIME_PAY = new Op("支付超时",OpSource.BACK,
			OpType.PAY, OpAction.OP_OUTTIME,OpLevel.LEVEL_ONE);	
	
	/**
	 * 去核对
	 */
	public static final Op APPLY_CONFIRM = new Op("去核对",OpSource.BACK,
			OpType.CONFIRM, OpAction.APPLY,OpLevel.LEVEL_FOUR);
	
	/**
	 * 核对完成
	 */
	public static final Op OP_PASS_CONFIRM = new Op("核对完成",OpSource.BACK,
			OpType.CONFIRM, OpAction.OP_PASS,OpLevel.LEVEL_THREE);
	
	/**
	 * 订位申请
	 */
	public static final Op APPLY_BOOKING = new Op("订位申请",OpSource.BACK,
			OpType.BOOKING, OpAction.APPLY,OpLevel.LEVEL_TWO);
	
	/**
	 * 订位完成
	 */
	public static final Op OP_PASS_BOOKING = new Op("订位完成",OpSource.BACK,
			OpType.BOOKING, OpAction.OP_PASS,OpLevel.LEVEL_THREE);	

	
	/**
	 * 订位失败
	 */
	public static final Op OP_REJECT_BOOKING = new Op("订位失败",OpSource.BACK,
			OpType.BOOKING, OpAction.OP_REJECT,OpLevel.LEVEL_ONE);
	
	/**
	 * 申请取消 
	 */
	public static final Op APPLY_CANCEL = new Op("申请取消",OpSource.BACK,
			OpType.CANCEL, OpAction.APPLY,OpLevel.LEVEL_TWO).putVaild(OrderStatusVaild.IS_CAN_CANCEL);
	
	/**
	 * 回退取消
	 */
	public static final Op ROLLBACK_CANCEL = new Op("回退取消",OpSource.BACK,
			OpType.CANCEL, OpAction.ROLLBACK,OpLevel.LEVEL_TWO).putVaild(OrderStatusVaild.IS_CAN_ROLLBACK_CANCEL);
	
	/**
	 * 取消 通过处理
	 */
	public static final Op OP_PASS_CANCEL = new Op("取消处理完成",OpSource.BACK,
			OpType.CANCEL, OpAction.OP_PASS,OpLevel.LEVEL_THREE);
	/**
	 * 取消 处理驳回
	 */
	public static final Op OP_REJECT_CANCEL = new Op("取消处理驳回",OpSource.BACK,
			OpType.CANCEL, OpAction.OP_REJECT,OpLevel.LEVEL_ONE);
	
	/**
	 * 已登机
	 */
	public static final Op OP_PASS_ONBROAD = new Op("已登机",OpSource.BACK,
			OpType.ONBROAD, OpAction.OP_PASS,OpLevel.LEVEL_THREE);
	
	/**
	 * 申请出票
	 */
	public static final Op APPLY_ISSUE = new Op("申请出票",OpSource.BACK,
			OpType.ISSUE, OpAction.APPLY,OpLevel.LEVEL_TWO).putVaild(OrderStatusVaild.IS_CAN_APPLY_ISSUE);
	
	/**
	 * 出票 审核通过
	 */
	public static final Op AUDIT_PASS_ISSUE = new Op("出票审核通过",OpSource.BACK,
			OpType.ISSUE, OpAction.AUDIT_PASS,OpLevel.LEVEL_THREE);

	/**
	 * 出票 审核驳回
	 */
	public static final Op AUDIT_REJECT_ISSUE = new Op("出票审核驳回",OpSource.BACK,
			OpType.ISSUE, OpAction.AUDIT_REJECT,OpLevel.LEVEL_ONE);
	
	/**
	 * 出票 处理通过
	 */
	public static final Op OP_PASS_ISSUE = new Op("出票处理完成",OpSource.BACK,
			OpType.ISSUE, OpAction.OP_PASS,OpLevel.LEVEL_THREE).putVaild(OrderStatusVaild.IS_CAN_OP_PASS_ISSUE);

	/**
	 * 出票 处理驳回
	 */
	public static final Op OP_REJECT_ISSUE = new Op("出票处理驳回",OpSource.BACK,
			OpType.ISSUE, OpAction.OP_REJECT,OpLevel.LEVEL_ONE).putVaild(OrderStatusVaild.IS_CAN_OP_REJECT_ISSUE);
	
    /**
     * 申请供应商出票
     */
    public static final Op APPLY_SUPP_ISSUE = new Op("申请供应商出票", OpSource.BACK, OpType.ISSUE,
            OpAction.APPLY_SUPP_OP,OpLevel.LEVEL_TWO).putVaild(OrderStatusVaild.IS_CAN_APPLY_ISSUE);

    /**
     * 同步供应商出票信息
     */
    public static final Op SYNC_SUPP_ISSUE = new Op("同步供应商出票信息", OpSource.BACK, OpType.ISSUE,
            OpAction.SYNC_SUPP_OP,OpLevel.LEVEL_TWO).putVaild(OrderStatusVaild.IS_CAN_SYNC_SUPP_ISSUE);
    
    /**
     * 供应商出票处理通过
     */
    public static final Op SUPP_OP_PASS_ISSUE = new Op("供应商出票处理通过", OpSource.BACK, OpType.ISSUE,
            OpAction.SUPP_OP_PASS,OpLevel.LEVEL_THREE);

    /**
     * 供应商出票处理驳回
     */
    public static final Op SUPP_OP_REJECT_ISSUE = new Op("供应商出票处理驳回", OpSource.BACK, OpType.ISSUE,
            OpAction.SUPP_OP_REJECT,OpLevel.LEVEL_ONE);
	
	/**
	 * 申请变更
	 */
	public static final Op APPLY_CTMT = new Op("申请变更",OpSource.BACK,
			OpType.CTMT, OpAction.APPLY,OpLevel.LEVEL_TWO);

	/**
	 * 变更审核通过
	 */
	public static final Op AUDIT_PASS_CTMT = new Op("变更审核通过",OpSource.BACK,
			OpType.CTMT, OpAction.AUDIT_PASS,OpLevel.LEVEL_THREE);

	/**
	 * 变更审核驳回
	 */
	public static final Op AUDIT_REJECT_CTMT = new Op("变更审核驳回",OpSource.BACK,
			OpType.CTMT, OpAction.AUDIT_REJECT,OpLevel.LEVEL_ONE);
	
	/**
	 * 变更处理通过
	 */
	public static final Op OP_PASS_CTMT = new Op("变更处理完成",OpSource.BACK,
			OpType.CTMT, OpAction.OP_PASS,OpLevel.LEVEL_THREE);

	/**
	 * 变更处理驳回
	 */
	public static final Op OP_REJECT_CTMT = new Op("变更处理驳回",OpSource.BACK,
			OpType.CTMT, OpAction.OP_REJECT,OpLevel.LEVEL_ONE);
	
    /**
     * 供应商改签申请
     */
    public static final Op APPLY_SUPP_CTMT = new Op("供应商改签申请", OpSource.BACK, OpType.CTMT,
            OpAction.APPLY_SUPP_OP, OpLevel.LEVEL_TWO);

    /**
     * 供应商改签处理通过
     */
    public static final Op SUPP_OP_PASS_CTMT = new Op("供应商改签处理通过", OpSource.BACK, OpType.CTMT,
            OpAction.SUPP_OP_PASS, OpLevel.LEVEL_THREE);

    /**
     * 供应商改签处理通过
     */
    public static final Op SUPP_OP_REJECT_CTMT = new Op("供应商改签处理驳回", OpSource.BACK, OpType.CTMT,
            OpAction.SUPP_OP_REJECT, OpLevel.LEVEL_ONE);
	
	/**
	 * 申请退票 
	 */
	public static final Op APPLY_RTVT = new Op("申请退票",OpSource.BACK,
			OpType.RTVT, OpAction.APPLY,OpLevel.LEVEL_TWO);

	/**
	 * 退票 审核通过
	 */
	public static final Op AUDIT_PASS_RTVT = new Op("退票审核通过",OpSource.BACK,
			OpType.RTVT, OpAction.AUDIT_PASS,OpLevel.LEVEL_THREE);

	/**
	 * 退票 审核驳回
	 */
	public static final Op AUDIT_REJECT_RTVT = new Op("退票审核驳回",OpSource.BACK,
			OpType.RTVT, OpAction.AUDIT_REJECT,OpLevel.LEVEL_ONE);
	
	/**
	 * 退票 处理通过
	 */
	public static final Op OP_PASS_RTVT = new Op("退票处理完成",OpSource.BACK,
			OpType.RTVT, OpAction.OP_PASS,OpLevel.LEVEL_THREE);

	/**
	 * 退票 处理驳回
	 */
	public static final Op OP_REJECT_RTVT = new Op("退票处理驳回",OpSource.BACK,
			OpType.RTVT, OpAction.OP_REJECT,OpLevel.LEVEL_ONE);
	
	
	
	/**
	 *申请结算
	 */
	public static final Op APPLY_SUPP_SETTLMENT = new Op("申请结算",OpSource.BACK,
			OpType.SUPP_SETTLMENT, OpAction.APPLY,OpLevel.LEVEL_TWO).putVaild(OrderStatusVaild.IS_CAN_SETTLEMENT);
	
	
	/**
	 * 结算成功
	 */
	public static final Op OP_PASS_SUPP_SETTLMENT = new Op("结算成功",OpSource.BACK,
			OpType.SUPP_SETTLMENT, OpAction.OP_PASS,OpLevel.LEVEL_THREE);
	
	
	/**
	 * 结算失败
	 */
	public static final Op OP_REJECT_SUPP_SETTLMENT = new Op("结算失败",OpSource.BACK,
			OpType.SUPP_SETTLMENT, OpAction.OP_REJECT,OpLevel.LEVEL_ONE);
	
    /**
     * 重新下单
     */
    public static final Op BOOKING_AGAIN = new Op("重新下单", OpSource.BACK,
            OpType.ORDER, OpAction.APPLY,OpLevel.LEVEL_FOUR);
	
    
	/**
	 * 延后取消 
	 */
	public static final Op WAIT_CANCEL = new Op("延后取消时间",OpSource.BACK,
			OpType.CANCEL, OpAction.WAIT,OpLevel.LEVEL_ONE).putVaild(OrderStatusVaild.IS_CAN_DELAY);
	
	/**
	 * 查看日志
	 */
	public static final Op OP_LOG = new Op("查看日志",OpSource.BACK,
			OpType.LOG, OpAction.OP_LOG,OpLevel.LEVEL_ONE);
	/**
	 * 查看备注
	 */
	public static final Op OP_REMARK = new Op("查看备注",OpSource.BACK,
			OpType.LOG, OpAction.OP_REMAK,OpLevel.LEVEL_ONE);
	
	/**
	 * 调控支付金额
	 */
	public static final Op DIRECT_REDUCTION_PAY = new Op("支付金额直减",OpSource.BACK,
			OpType.ORDER, OpAction.DIRECT_REDUCTION_PAY,OpLevel.LEVEL_FOUR).putVaild(OrderStatusVaild.IS_CAN_DIRECT_REDUCTION);

}
