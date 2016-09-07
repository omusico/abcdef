package com.lvmama.lvf.common.dto;

import java.io.Serializable;

/**
 * 
 * @author lutianyu
 * @date   2015年4月19日
 */
public class BaseVSTRequest implements Serializable{
	private static final long serialVersionUID = 6498709651400798863L;
	
	/** 限制查询条数*/
	private Integer limit;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
