package com.lvmama.lvfit.common.dto.enums;

/**
 * 供应商数据映射类型
 * @author majun
 * @date 2015-8-10
 */
public enum SuppDataMappingType 
{
	CITY_CODE("城市编码");
	
	private String cnName;
	
	private SuppDataMappingType(String cnName) {
		this.cnName = cnName;
	}
	
	public String getCnName() {
		return cnName;
	}
}
