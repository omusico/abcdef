package com.lvmama.lvfit.common.form.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;

public class FitSdpProductSyncMsgForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1001906511602158076L;

	private FitSdpProductSyncMsgDto fitSdpProductSyncMsgDto;

	/** 查询 分页信息  **/
	private Pagination pagination = new Pagination();
	
	

	public FitSdpProductSyncMsgDto getFitSdpProductSyncMsgDto() {
		return fitSdpProductSyncMsgDto;
	}

	public void setFitSdpProductSyncMsgDto(
			FitSdpProductSyncMsgDto fitSdpProductSyncMsgDto) {
		this.fitSdpProductSyncMsgDto = fitSdpProductSyncMsgDto;
	}

	public PersistenceType getPtype() {
		return fitSdpProductSyncMsgDto.getPtype();
	}

	public Long getProductId() {
		return fitSdpProductSyncMsgDto.getProductId();
	}

	public void setPtype(PersistenceType ptype) {
		fitSdpProductSyncMsgDto.setPtype(ptype);
	}

	public void setProductId(Long productId) {
		fitSdpProductSyncMsgDto.setProductId(productId);
	}

	public String getSequence() {
		return fitSdpProductSyncMsgDto.getSequence();
	}

	public Long getProductSyncTime() {
		return fitSdpProductSyncMsgDto.getProductSyncTime();
	}

	public Long getId() {
		return fitSdpProductSyncMsgDto.getId();
	}

	public void setProductSyncTime(Long productSyncTime) {
		fitSdpProductSyncMsgDto.setProductSyncTime(productSyncTime);
	}

	public void setId(Long id) {
		fitSdpProductSyncMsgDto.setId(id);
	}

	public String getUuid() {
		return fitSdpProductSyncMsgDto.getUuid();
	}

	public Long getIndexSyncTime() {
		return fitSdpProductSyncMsgDto.getIndexSyncTime();
	}

	public void setUuid(String uuid) {
		fitSdpProductSyncMsgDto.setUuid(uuid);
	}

	public void setIndexSyncTime(Long indexSyncTime) {
		fitSdpProductSyncMsgDto.setIndexSyncTime(indexSyncTime);
	}

	public Date getCreateTime() {
		return fitSdpProductSyncMsgDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		fitSdpProductSyncMsgDto.setCreateTime(createTime);
	}

	public ResultStatus getProductSyncStatus() {
		return fitSdpProductSyncMsgDto.getProductSyncStatus();
	}

	public Date getUpdateTime() {
		return fitSdpProductSyncMsgDto.getUpdateTime();
	}

	public void setProductSyncStatus(ResultStatus productSyncStatus) {
		fitSdpProductSyncMsgDto.setProductSyncStatus(productSyncStatus);
	}

	public void setUpdateTime(Date updateTime) {
		fitSdpProductSyncMsgDto.setUpdateTime(updateTime);
	}

	public ResultStatus getIndexSyncStatus() {
		return fitSdpProductSyncMsgDto.getIndexSyncStatus();
	}

	public void setIndexSyncStatus(ResultStatus indexSyncStatus) {
		fitSdpProductSyncMsgDto.setIndexSyncStatus(indexSyncStatus);
	}

	public boolean equals(Object obj) {
		return pagination.equals(obj);
	}

	public int hashCode() {
		return pagination.hashCode();
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public String toString() {
		return pagination.toString();
	}

	/**   pagination start	 * 	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
    
    public Pagination getPagination() {
		return pagination;
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
	/**   pagination end	 * 	 */
	

}
