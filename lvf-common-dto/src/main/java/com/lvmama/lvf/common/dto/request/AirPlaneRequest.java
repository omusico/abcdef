package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.md.Airplane;

public class AirPlaneRequest implements Serializable, Dto {
	
	/********************前台搜索参数***********************/
	
	/** 机型名称 */
	private String name;

	/** 机型代码 */
	private String code;
	
	private static final long serialVersionUID = 13083684907505663L;
	
	private Airplane airPlane;
	
	/** 机型名称简称 */
	private String simpleName;
	
	@Override
	public Long getId() {
		return null;
	}
	
	public Airplane getAirPlane() {
		return airPlane;
	}
	public void setAirPlane(Airplane airPlane) {
		this.airPlane = airPlane;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	
}
