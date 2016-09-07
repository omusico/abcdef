package com.lvmama.lvf.common.dto.status.order;
/**
 * TASK #30159 下单请求记录功能
 * 记录下单成功失败的状态
 */
public enum OrderStatus {
	SUCCESS("成功"),
	FAIL("失败");
	private OrderStatus(String cnName){
		this.cnName = cnName;
	}
	private String cnName;
	public String getCnName() {
		return cnName;
	}
}
