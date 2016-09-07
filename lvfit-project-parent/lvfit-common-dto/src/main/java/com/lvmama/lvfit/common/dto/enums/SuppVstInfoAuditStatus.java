package com.lvmama.lvfit.common.dto.enums;


public enum SuppVstInfoAuditStatus {
	

	UNVERIFIED("未确认"), /** 未确认 **/
	INFOPASS("确认通过"), /** 已审核 **/
	INFOFAIL("确认不通过");/** 审核失败 **/

	private final String cnName;

	private SuppVstInfoAuditStatus(String cnName){
		this.cnName = cnName;
	}

	public static String getCnName(String code){
		for(SuppVstInfoAuditStatus item:SuppVstInfoAuditStatus.values()){
			if(item.getCode().equals(code)){
				return item.cnName;
			}
		}
		return code;
	}

	public String getCode(){
		return this.name();
	}

	public String getCnName(){
		return this.cnName;
	}

	@Override
	public String toString() {
		return this.name();
	}


}
