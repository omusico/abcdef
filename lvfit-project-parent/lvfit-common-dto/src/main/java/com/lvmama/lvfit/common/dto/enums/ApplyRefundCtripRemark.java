package com.lvmama.lvfit.common.dto.enums;

public enum ApplyRefundCtripRemark {
	
	RT_FREEWILL("自愿退票"),
	RT_NOT_FREEWILL("非自愿退票"),
	VT("当日作废"),
	RT_FLIGHT_LATE_OR_CANCEL("航班变动，请核对！"),
	RT_ILL("病退，资料证明可线下沟通！"),
	RT_CRASH_LANDING("如需证明，线下沟通！"),
	RT_REPURCHASE_ALL_REFUND("请核对是否重购全退！"),
	RT_FORM_REFUND("形式全退"),
	RT_OTHER("其它");

	private String cnName;
	
	private ApplyRefundCtripRemark(String cnName) {
		this.cnName = cnName;
	}	

	public String getCnName() {
		return cnName;
	}
}
