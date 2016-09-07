package com.lvmama.lvfit.common.dto.enums;
/**
 * 用户会员类型
 * @author zzs
 *
 */
public enum UserMemberGrade {
	/** 普通会员 */
	NORMAL("NORMAL", "普通会员", 1),
	/** 金牌会员  */
	GOLD("GOLD", "金牌会员", 2),
	/** 白金会员 */
	PLATINUM("PLATINUM", "白金会员", 3),
	/** 钻石会员 */
	DIAMOND("DIAMOND", "钻石会员", 4);
	
	//英文标示
	private String enName;
	//中文标示
	private String znName;
	//对应值
	private int value;
	
	private UserMemberGrade(String enName, String znName, int value) {
		this.enName = enName;
		this.znName = znName;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public String getGrade() {
		return enName;
	}

	public String getChGrade() {
		return znName;
	}
}
