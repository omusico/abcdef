package com.lvmama.lvf.common.dto.order.status;

/**
 * 制单状态
 */
public enum GenerateStatus {

	NOT_GENERATE("未制单"),
	GENERATE_ING("制单中"),
	GENERATE_SUCC("制单完成"),
	GENERATE_FAIL("制单失败");

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private GenerateStatus(String cnName) {
		this.cnName = cnName;
	}
}
