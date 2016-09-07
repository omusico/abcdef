package com.lvmama.lvf.common.dto.enums;

public enum PolicyStatus {

		EFFECTIVE("有效"),
		INVALID("无效");
		
		private String cnName;

		public String getCnName() {
			return cnName;
		}

		private PolicyStatus(String cnName) {
			this.cnName = cnName;
		}
		
		

}
