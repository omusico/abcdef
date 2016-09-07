package com.lvmama.lvfit.common.dto.enums;

/**
 * 备注类型
 * @author majun
 * @date   2015-3-16
 */
public enum RemarkType 
{
	CUSTOMER("客户备注"),
	BACK("后台备注"),
	SUPP("供应商备注"),
	ISSUE_TICKET("出票备注"),
	RTVT_TICKET("退票备注"),
	CTMT_TICKET("改签备注"),
	CANCEL("取消备注"),
	PAYMENT("支付备注"),
	REUND("退款备注");
	
	private String cnName;

	private RemarkType(String cnName) {
		this.cnName = cnName;
	}
	
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	public static RemarkType getRemarkTypeByName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (RemarkType remarkType : RemarkType.values()) {
			if (name.equals(remarkType.name())) {
				return remarkType;
			}
		}
		return null;
	}
	
}
