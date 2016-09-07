package com.lvmama.lvf.common.form.risk;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.risk.ForbiddenWordDto;
import com.lvmama.lvf.common.dto.status.ConditionType;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 禁用词管理查询结果FORM
 * 
 * @author lizongze
 *
 */
public class ForbiddenWordResultForm implements Serializable, Form {

  private static final long serialVersionUID = -9082469832807636400L;

  private ForbiddenWordDto forbiddenWordDto;

  public ForbiddenWordResultForm() {}

  public ForbiddenWordResultForm(ForbiddenWordDto forbiddenWordDto) {
    this.forbiddenWordDto = forbiddenWordDto;
  }

  public ForbiddenWordDto getForbiddenWordDto() {
    return forbiddenWordDto;
  }

  public void setForbiddenWordDto(ForbiddenWordDto forbiddenWordDto) {
    this.forbiddenWordDto = forbiddenWordDto;
  }

  public String getName() {
    return this.forbiddenWordDto.getName();
  }

  public void setName(String name) {
    this.forbiddenWordDto.setName(name);
  }

  public String getType() {
    return this.forbiddenWordDto.getType().getCnName();
  }

  public void setType(ConditionType type) {
    this.forbiddenWordDto.setType(type);
  }

  public Long getWordId() {
    return this.forbiddenWordDto.getWordId();
  }

  public void setId(Long id) {
    this.forbiddenWordDto.setWordId(id);
  }

  public String getCreateTime() {
    return DateUtils.formatDate(forbiddenWordDto.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
  }

  public String getUpdateTime() {
    return DateUtils.formatDate(forbiddenWordDto.getUpdateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
  }

  public void setCreateTime(Date createTime) {
    forbiddenWordDto.setCreateTime(createTime);
  }

  public void setUpdateTime(Date updateTime) {
    forbiddenWordDto.setUpdateTime(updateTime);
  }
}
