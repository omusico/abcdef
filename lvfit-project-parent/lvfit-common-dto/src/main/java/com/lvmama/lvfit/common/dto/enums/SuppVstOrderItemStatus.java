package com.lvmama.lvfit.common.dto.enums;


public enum SuppVstOrderItemStatus {
	

	UNVERIFIED("未审核"),
	VERIFIEDING("审核中"),/** 资源满足 **/
	VERIFIED("审核通过"), /** 资源不满足 **/
	NOVERIFIED("审核不通过"); /** 审核不通过 **/

	private final String cnName;

	private SuppVstOrderItemStatus(String cnName){
		this.cnName = cnName;
	}

	public static String getCnName(String code){
		for(SuppVstOrderItemStatus item:SuppVstOrderItemStatus.values()){
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
