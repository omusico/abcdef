package com.lvmama.lvf.common.dto.enums;

public enum InventoryStatus {
	A("库存足够,可以提供1-9或9个以上座位"),
	L("没有可利用座位,但旅客可以候补"),
	Q("永久申请状态,没有可利用座位,但可以申请(HN)"),
	S("因达到限制销售数而没有可利用座位,但可以候补"),
	C("该等级彻底关闭,不允许候补或申请"),
	X("该等级取消, 不允许候补或申请"),
	R(""),
	N(""),
	Z("可利用情况不明,这种情况有可能在外航航班上出现");
	
	private String cnName;
	

	public String getCnName() {
		return cnName;
	}

	private InventoryStatus(String cnName) {
		this.cnName = cnName;
	}
	
	
}
