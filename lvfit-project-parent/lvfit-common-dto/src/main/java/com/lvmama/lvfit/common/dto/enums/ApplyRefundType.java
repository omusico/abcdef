package com.lvmama.lvfit.common.dto.enums;

public enum ApplyRefundType {
	
	RT_FREEWILL("自愿退票",ApplyRefundActionType.RT_FREEWILL),
	RT_NOT_FREEWILL("非自愿退票", ApplyRefundActionType.RT_FLIGHT_LATE_OR_CANCEL),
	VT("当日作废", ApplyRefundActionType.VT),
	
	RT_FLIGHT_LATE_OR_CANCEL("航变", ApplyRefundActionType.RT_FLIGHT_LATE_OR_CANCEL),
	RT_ILL("病退", ApplyRefundActionType.RT_ILL),
	RT_CRASH_LANDING("备降", ApplyRefundActionType.RT_CRASH_LANDING),
	RT_REPURCHASE_ALL_REFUND("重购全退", ApplyRefundActionType.RT_REPURCHASE_ALL_REFUND),
	RT_FORM_REFUND("形式全退", ApplyRefundActionType.RT_FORM_REFUND),
	RT_OTHER("其它", ApplyRefundActionType.RT_OTHER);

	private String cnName;
	
	private ApplyRefundActionType applyRefundActionType;
	
	private ApplyRefundType(String cnName, ApplyRefundActionType applyRefundActionType) {
		this.cnName = cnName;
		this.applyRefundActionType = applyRefundActionType;
	}	

	public String getCnName() {
		return cnName;
	}

	public ApplyRefundActionType getApplyRefundActionType() {
		return applyRefundActionType;
	}
}
