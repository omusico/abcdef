package com.lvmama.lvf.common.dto.status;

public enum ActiveStatusEnum {
	
	ACTIVE("上架"),
	APPLY_ACTIVE("申请上架"),
	INACTIVE("下架"),
	APPLY_INACTIVE("申请下架");	
	
	private String cnName;

	private ActiveStatusEnum(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public static ActiveStatusEnum getActiveStatus(String activeStatus){
		try {
			return ActiveStatusEnum.valueOf(activeStatus);
		} catch (Exception e) {
			return null;
		}
	}
}
