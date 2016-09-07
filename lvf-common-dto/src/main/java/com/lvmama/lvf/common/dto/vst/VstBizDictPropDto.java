package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.AEEntity;

/**
 * @author lutianyu
 * @date   2015年7月30日
 */
public class VstBizDictPropDto extends AEEntity implements Serializable{
	private static final long serialVersionUID = 7803340731657942043L;
	
	private Long dictPropId;
	
	private Long dictId;
	
	private Long dictPropDefId;
	
	private Long dictDefId;
	
	private String dictPropValue;

	public Long getDictPropId() {
		return dictPropId;
	}

	public void setDictPropId(Long dictPropId) {
		this.dictPropId = dictPropId;
	}

	public Long getDictId() {
		return dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public Long getDictPropDefId() {
		return dictPropDefId;
	}

	public void setDictPropDefId(Long dictPropDefId) {
		this.dictPropDefId = dictPropDefId;
	}

	public Long getDictDefId() {
		return dictDefId;
	}

	public void setDictDefId(Long dictDefId) {
		this.dictDefId = dictDefId;
	}

	public String getDictPropValue() {
		return dictPropValue;
	}

	public void setDictPropValue(String dictPropValue) {
		this.dictPropValue = dictPropValue;
	}
}
