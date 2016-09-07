package com.lvmama.lvf.common.form.risk;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.ForbiddenWordRequest;
import com.lvmama.lvf.common.dto.status.ConditionType;
import com.lvmama.lvf.common.form.Form;

/**
 * 禁用词管理
 * 
 * @author lizongze
 *
 */
public class ForbiddenWordInputForm implements Serializable, Form {

  private static final long serialVersionUID = 3588114502649900849L;
  /**
   * 查询条件
   */
  private ForbiddenWordRequest request = new ForbiddenWordRequest();
  /**
   * 分页信息
   */
  private Pagination pagination = new Pagination();
  /**
   * 条件类型 备注：对于非基本类型的数据，不能使用代理方法
   */
  private String type;

  public ForbiddenWordRequest getRequest() {
    if (StringUtils.isNotBlank(this.getType())) {
      ConditionType type = ConditionType.valueOf(this.getType());
      this.request.setType(type);
    }
    return this.request;
  }

  public void setRequest(ForbiddenWordRequest request) {
    this.request = request;
  }

  public Pagination getPagination() {
    return pagination;
  }

  public void setPagination(Pagination pagination) {
    this.pagination = pagination;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }

  // -----代理方法-------
  public String getName() {
    return request.getName();
  }

  public void setName(String name) {
    request.setName(name);
  }

  public Long getWordId() {
    return request.getWordId();
  }

  public void setWordId(Long wordId) {
    request.setWordId(wordId);
  }

  public Long getId() {
    return request.getId();
  }

  public int getPage() {
    return pagination.getPage();
  }

  public void setPage(int page) {
    pagination.setPage(page);
  }

  public int getRows() {
    return pagination.getRows();
  }

  public void setRows(int rows) {
    pagination.setRows(rows);
  }

  public void setRowsByCustom(int customRows) {
    pagination.setRowsByCustom(customRows);
  }

  public int getRecords() {
    return pagination.getRecords();
  }

  public void setRecords(int records) {
    pagination.setRecords(records);
  }

  public void countRecords(int records) {
    pagination.countRecords(records);
  }

  public int getTotal() {
    return pagination.getTotal();
  }

  public void setTotal(int total) {
    pagination.setTotal(total);
  }

  public String getSidx() {
    return pagination.getSidx();
  }

  public void setSidx(String sidx) {
    pagination.setSidx(sidx);
  }

  public String getSord() {
    return pagination.getSord();
  }

  public void setSord(String sord) {
    pagination.setSord(sord);
  }

  public int getStartRow() {
    return pagination.getStartRow();
  }

  public int getEndRow() {
    return pagination.getEndRow();
  }

  public boolean isSearch() {
    return pagination.isSearch();
  }

  public void setSearch(boolean search) {
    pagination.setSearch(search);
  }
}
