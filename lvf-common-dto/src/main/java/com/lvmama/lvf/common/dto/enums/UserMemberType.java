package com.lvmama.lvf.common.dto.enums;
/**
 * 用户会员等级
 * @author zzs
 *
 */
public enum UserMemberType {
	DEFAULT("普通会员"),
	DISTRON("分销会员"),
	COMPANY("企业会员"),
	OTHER("其它");
	
	private String cnName;

	private UserMemberType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
}
