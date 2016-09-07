package com.lvmama.lvf.common.dto.status;
/**
 * @author lutianyu
 * @date   2015年4月9日
 */
public enum BatchFlag {
	NEW("需同步"),
	SUCC("已同步"),
	
	ADD("新增"),//获取本地库中需要新增的数据
	UPDATE("更新");//获取本地库中需要更新的数据
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private BatchFlag(String cnName) {
		this.cnName = cnName;
	}
}
