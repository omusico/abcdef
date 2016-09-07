package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;

public class VstPropValue implements Serializable{
	private static final long serialVersionUID = -5656054222095362442L;
	private Long id;
	private String name;
	private String addValue;
	private Long dictPropDefId;
	private String dictPropValue;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddValue() {
		return addValue;
	}
	public void setAddValue(String addValue) {
		this.addValue = addValue;
	}
	public Long getDictPropDefId() {
		return dictPropDefId;
	}
	public void setDictPropDefId(Long dictPropDefId) {
		this.dictPropDefId = dictPropDefId;
	}
	public String getDictPropValue() {
		return dictPropValue;
	}
	public void setDictPropValue(String dictPropValue) {
		this.dictPropValue = dictPropValue;
	}

}
