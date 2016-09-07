package com.lvmama.lvf.common.dto.risk;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.status.ConditionType;

/**
 * 禁用词DTO
 * 
 * @author lizongze
 *
 */
public class ForbiddenWordDto extends Entity implements Serializable {

	private static final long serialVersionUID = -6877863009143540692L;

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
}
