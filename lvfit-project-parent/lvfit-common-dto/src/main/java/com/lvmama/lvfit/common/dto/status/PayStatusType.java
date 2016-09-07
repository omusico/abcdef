package com.lvmama.lvfit.common.dto.status;

public enum PayStatusType 
{
	NULL(""),
	PAY("支付"){
		public boolean isPay(){
			return true;
		}
	},
	REFUND("退款"){
		public boolean isRefund(){
			return true;
		}
	};
	
	private String cnName;
	
	private PayStatusType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	public boolean isPay(){
		return false;
	};
	public boolean isRefund(){
		return false;
	};
}
