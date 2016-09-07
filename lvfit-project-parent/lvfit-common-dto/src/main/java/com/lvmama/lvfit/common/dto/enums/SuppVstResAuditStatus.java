package com.lvmama.lvfit.common.dto.enums;


public enum SuppVstResAuditStatus {
	

	UNVERIFIED("未审核"),
	AMPLE("资源满足"),/** 资源满足 **/
	LOCK("资源不满足"); /** 资源不满足 **/

	private final String cnName;

	private SuppVstResAuditStatus(String cnName){
		this.cnName = cnName;
	}

	public static String getCnName(String code){
		for(SuppVstResAuditStatus item:SuppVstResAuditStatus.values()){
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
