package com.lvmama.lvfit.common.dto.enums;

public enum JudgeType {

		Y("是"),
		N("否");
	
		private String cnName;
	
		public String getCnName() {
			return cnName;
		}
	
		public void setCnName(String cnName) {
			this.cnName = cnName;
		}
	
		private JudgeType (String cnName) {
			this.cnName = cnName;
		}
}
