package com.lvmama.lvf.common.event;

import java.util.ArrayList;
import java.util.List;

public enum Event {

	TEST_ORDER_BOOKING("预订"),
	TEST_ORDER_BOOKING_DONE("预订完成"),
	TEST_SUPPORDER_BOOKING_DONE("供应商预订"),

	ORDER_BOOKING("订单预订"),
	ORDER_AUDIT("订单审核"),
	ORDER_OP_REJECT("订单预订驳回"),
	ORDER_OP_PASS("订单预订通过"),
	ORDER_BOOKING_FINISH("预订完成"),
	
	ORDER_MODIFY("订单修改"),
	ORDER_CANCEL("订单取消"),
	ORDER_CANCEL_FINISH("订单取消完成"),
	ORDER_REFUND_TICKET("订单退票"),
	
	//--支付
	ORDER_PAY_BACK("支付回调"),
	ORDER_PAY("申请支付"),
	
	//--退款
	ORDER_REFUND("申请退款"),
	ORDER_REFUND_TO_VST("向VST发送退款请求"),
	ORDER_REFUND_BACK("退款回调"),
	
	
	SETTLEMENT_ISSUE_DONE("出票完成结算"),
	SETTLEMENT_RTVT_OP_DONE("退废票完成结算"),
	SETTLEMENT_CTMT_DONE("改期改签完成"),
	
	
	TICKET_ISSUE_APPLY_PRE("出票待申请"),
	TICKET_ISSUE_APPLY("出票申请"),
	TICKET_ISSUE_AUDIT_PRE("出票待审核"),
	TICKET_ISSUE_AUDIT("出票审核"),
	TICKET_ISSUE_OP_PRE("出票待处理"),
	TICKET_ISSUE_OP("出票处理"),
	TICKET_ISSUE_SUPP_OP("供应商出票处理"),
	GET_NOTISSUE_ORDER_LIST("获取出票超时订单列表"),
	GET_NOTISSUE_ORDER("获取出票超时订单"),
	
	
	
	TICKET_RTVT_APPLY_PRE("退废票待申请"),
	TICKET_RTVT_APPLY("退废票申请"),
	TICKET_RTVT_AUDIT_PRE("退废票待审核"),
	TICKET_RTVT_AUDIT("退废票审核"),
	TICKET_RTVT_APPLY_SUPP_OP("申请供应商退废票处理"),
	TICKET_RTVT_OP_PRE("退废票待处理"),
	TICKET_RTVT_OP("退废票处理"),
	
	TICKET_CTMT_APPLY_PRE("改期改签待申请"),
	TICKET_CTMT_APPLY("改期改签申请"),
	TICKET_CTMT_AUDIT_PRE("改期改签待审核"),
	TICKET_CTMT_AUDIT("改期改签审核"),
	TICKET_CTMT_OP_PRE("改期改签待处理"),
	TICKET_CTMT_OP("改期改签处理"),
	
	TICKET_PRINT("行程单打印"),
	
	SUPPORDER_BOOKING("供应商预订"),
	SUPPORDER_PAY("供应商支付"),
	SUPPORDER_CANCEL("供应商订单取消"),
	SUPPORDER_REFUND_TICKET("供应商订单退票"),
	SUPPORDER_REFUND("供应商订单退款"),
	SUPPORDER_SYNC("供应商订单同步"),
	MANUAL_SUPPORDER_REFUND_SYNC("手动供应商订单退款信息同步"),
	SUPPORDER_REFUND_SYNC("供应商订单退款信息同步"),
	INSURE_INSURANCE("订单投保"),
	
	VSTORDER_BOOKING("VST预订"),
	VSTORDER_CANCEL("VST订单取消"),
	VSTORDER_REFUND_TICKET("VST订单退票"),
	VSTORDER_REFUND("VST订单退款"),
	VSTORDER_SYNC("VST订单同步"),
	
	DIRECT_REDUCTION_AMOUNT("支付金额直减");

	private String cnName;
	
	private List<EventListener> listeners = new ArrayList<EventListener>();

	public String getCnName() {
		return cnName;
	}

	private Event(String cnName) {
		this.cnName = cnName;
	}

	public Boolean register(EventListener listener){
		return listeners.add(listener);
	}

	public List<EventListener> getListeners() {
		return listeners;
	}
	
}
