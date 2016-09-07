package com.lvmama.lvf.common.dto.enums;

/**
 * 供应商退票类型
 * @author majun
 * @date   2015-5-8
 */
public enum ApplyRefundActionType {
	
	VT("1", "当日作废,扣手续费",false),
	VT_OTHER("2", "其它废票情况",false),
	RT_FREEWILL("3", "客人自愿退票，按客规收取手续费",false),
	RT_SPEC_FCY("4", "南航F/C舱、国航F/C舱、东航F/C/Y舱、海航F/C舱，申请全退",true),
	RT_FLIGHT_LATE_OR_CANCEL("5", "因航班取消/延误，申请全退",true),
	RT_EXCHANGE_OR_UPGRADE("6", "升舱换开，申请全退",true),
	RT_WRONG_NAME("7", "名字错换开重出，申请全退",true),
	RT_ILL("8","客人因病无法乘机，申请全退",true),
	RT_OTHER("9", "其它退票情况",false),
	RT_DIFFERENCE("10", "申请退回票款差价",false),
	RT_CRASH_LANDING("11", "备降，如需证明，线下沟通",true),
	RT_FORM_REFUND("12", "形式全退",true),
	RT_REPURCHASE_ALL_REFUND("13", "请核对是否重购全退！",true);
	
	/** 供应商具体退款类型(用于和供应商接口进行对接) */
	private String actionType;
	
	private String cnName;
	
	private Boolean applyAllRefund;
	
	private ApplyRefundActionType(String actionType, String cnName,
			Boolean applyAllRefund) {
		this.actionType = actionType;
		this.cnName = cnName;
		this.applyAllRefund = applyAllRefund;
	}

	public String getActionType() {
		return actionType;
	}

	public String getCnName() {
		return cnName;
	}
	
	public Boolean getApplyAllRefund() {
		return applyAllRefund;
	}
}