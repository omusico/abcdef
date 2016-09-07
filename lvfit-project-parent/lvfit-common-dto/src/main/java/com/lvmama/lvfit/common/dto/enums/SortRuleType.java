package com.lvmama.lvfit.common.dto.enums;


/**
 * 排序规则
 * @author leizhengwei
 *
 */
public enum SortRuleType {

	SORT_BY_PRICE_ASC("价格由低到高"),
	SORT_BY_DEPTIME_ASC("出发时间由早到晚");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private SortRuleType (String cnName) {
		this.cnName = cnName;
	}
	
}
