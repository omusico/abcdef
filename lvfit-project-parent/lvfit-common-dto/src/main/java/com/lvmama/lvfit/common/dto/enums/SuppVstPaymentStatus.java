package com.lvmama.lvfit.common.dto.enums;


public enum SuppVstPaymentStatus {


	UNPAY("待支付"), /** 待支付 **/
	TRANSFERRED("已转移"),/**资金转移**/
	PART_PAY("部分支付"), /** 部分支付 **/
	PAYED("已支付 ");/** 已支付 **/

	private final String cnName;

	private SuppVstPaymentStatus(String cnName){
		this.cnName = cnName;
	}

	public static String getCnName(String code){
		for(SuppVstPaymentStatus item:SuppVstPaymentStatus.values()){
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
