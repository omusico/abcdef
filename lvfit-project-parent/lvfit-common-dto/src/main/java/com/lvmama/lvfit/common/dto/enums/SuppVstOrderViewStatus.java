package com.lvmama.lvfit.common.dto.enums;


public enum SuppVstOrderViewStatus {
	
	
	UNVERIFIED("待审核"),
	PAYED("已支付"),
	WAIT_PAY("待支付 "),
	APPROVING("审核中"),
	CANCEL("取消"),
	COMPLETE("完成 ");

	private  String cnName;

	private SuppVstOrderViewStatus(String cnName){
		this.cnName = cnName;
	}

	public static String getCnName(String code){
		for(SuppVstOrderViewStatus item:SuppVstOrderViewStatus.values()){
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
