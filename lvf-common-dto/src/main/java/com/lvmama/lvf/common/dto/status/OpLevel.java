package com.lvmama.lvf.common.dto.status;
/**
 * 操作等级
 * @author zhangzongshuang
 * @date 2015年8月21日
 */
public enum OpLevel {
	LEVEL_ZERO("0"),
	LEVEL_ONE("1"),
	LEVEL_TWO("2"),
	LEVEL_THREE("3"),
	LEVEL_FOUR("4");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OpLevel(String cnName) {
		this.cnName = cnName;
	}
}
