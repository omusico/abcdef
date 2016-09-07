package com.lvmama.lvf.common.dto.status;

public enum PublishStatus{
	
	PUBLISHED("已发布"),
	WAIT_PUBLISH_AUDIT("待审核"),
	DRAFT("草稿");
	
	private String cnName;

	private PublishStatus(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	
}
