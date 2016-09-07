package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.status.ConditionType;

/**
 * 禁用词管理查询条件类
 * 
 * @author lizongze
 *
 */
public class ForbiddenWordRequest implements Serializable, Dto {

	private static final long serialVersionUID = -2264901976434294094L;
	private Long wordId;
	private String name;
	private ConditionType type;

	public Long getWordId() {
		return wordId;
	}

	public void setWordId(Long wordId) {
		this.wordId = wordId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConditionType getType() {
		return type;
	}

	public void setType(ConditionType type) {
		this.type = type;
	}

	@Override
	public Long getId() {
		return null;
	}


}
