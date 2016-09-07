package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.SuppDataMappingType;

/**
 * 供应商数据映射
 * @author majun
 * @date 2015-8-10
 */
public class SuppDataMapping extends Entity implements Serializable
{
	private static final long serialVersionUID = 2034607688098576822L;
	
	/** 供应商编码 */
	private String suppCode;
	
	/** 供应商数据映射类型 */
	private SuppDataMappingType suppDataMappingType;
	
	/** 供应商数据值 */
	private String suppValue;
	
	/** 对应驴妈妈数据值 */
	private String lvValue;

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public SuppDataMappingType getSuppDataMappingType() {
		return suppDataMappingType;
	}

	public void setSuppDataMappingType(SuppDataMappingType suppDataMappingType) {
		this.suppDataMappingType = suppDataMappingType;
	}

	public String getSuppValue() {
		return suppValue;
	}

	public void setSuppValue(String suppValue) {
		this.suppValue = suppValue;
	}

	public String getLvValue() {
		return lvValue;
	}

	public void setLvValue(String lvValue) {
		this.lvValue = lvValue;
	}

}	
