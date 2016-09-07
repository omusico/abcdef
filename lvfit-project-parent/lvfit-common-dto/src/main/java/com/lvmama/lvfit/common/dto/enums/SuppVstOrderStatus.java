package com.lvmama.lvfit.common.dto.enums;


public enum SuppVstOrderStatus {
	

	NORMAL("正常"),
	COMPLETE("已完成"),
	CANCEL("已取消");

	private  String cnName;

	private SuppVstOrderStatus(String cnName){
		this.cnName = cnName;
	}

	public static String getCnName(String code){
		for(SuppVstOrderStatus item:SuppVstOrderStatus.values()){
			if(item.getCode().equals(code)){
				return item.cnName;
			}
		}
		return code;
	}

	public static SuppVstOrderStatus getValueByCode(String code) {
		SuppVstOrderStatus ret = null;
		for(SuppVstOrderStatus item:SuppVstOrderStatus.values()){
			if(item.name().equals(code)){
				ret = item;
			}
		}

		return ret;
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
