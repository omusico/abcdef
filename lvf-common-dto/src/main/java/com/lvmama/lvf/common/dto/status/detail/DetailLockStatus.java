package com.lvmama.lvf.common.dto.status.detail;

/**
 * 明细锁定状态
 * @author majun
 * @date 2015年6月11日
 */
public enum DetailLockStatus 
{
	UN_LOCK("未锁定"),
	BACK_LOCK("后台锁定"),
	FRONT_LOCK("前台锁定");
	
	private String cnName;
	
	private DetailLockStatus(String cnName) {
		this.cnName = cnName;
	}
	
	public String getCnName() {
		return cnName;
	}
	
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
}
