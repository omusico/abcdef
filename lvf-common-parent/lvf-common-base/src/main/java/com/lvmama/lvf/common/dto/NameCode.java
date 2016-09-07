package com.lvmama.lvf.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 名称编码
 * @author majun
 * @date   2015-1-13
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NameCode extends Entity implements Serializable
{
	private static final long serialVersionUID = 3705934114544649232L;
	
	/** 名称 */
	private String name;
	
	/** 编码 */
	private String code;
	
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
}
