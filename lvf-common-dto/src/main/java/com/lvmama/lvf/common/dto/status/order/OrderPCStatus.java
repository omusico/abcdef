package com.lvmama.lvf.common.dto.status.order;


/**
 * @author lutianyu
 * @date   2016年2月25日
 */
public enum OrderPCStatus {
	CANCEL_DONE("已取消"),
	NOT_PAY("待支付"),
	PAY_DONE("已支付"),
	ISSUE_DONE("已出票"),
	CTMT_PART("部分变更"),
	CTMT_DONE("已变更"),
	RTVT_PART("部分退票"),
	RTVT_DONE("已退票");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	/**
	 * 通过枚举名获取中文名
	 * @param code
	 * @return
	 */
	public static String getCnName(String code) {
		for (OrderPCStatus item : OrderPCStatus.values()) {
			if (item.name().equals(code)) {
				return item.getCnName();
			}
		}
		return "";
	}
	
	/**
	 * 通过中文名获取枚举名
	 * @param cnName
	 * @return
	 */
	public static String getNameByCnName(String cnName){
		for (OrderPCStatus item : OrderPCStatus.values()) {
			if (item.getCnName().equals(cnName)) {
				return item.name();
			}
		}
		return "";
	}
	
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private OrderPCStatus(String cnName) {
		this.cnName = cnName;
	}
	
//	public static void main(String[] args) {
//		System.out.println(OrderPCStatus.getCnName("PAY_DONE"));
//	}
}
