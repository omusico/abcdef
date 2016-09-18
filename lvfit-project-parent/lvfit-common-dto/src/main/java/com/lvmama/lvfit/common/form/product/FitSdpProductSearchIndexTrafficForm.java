package com.lvmama.lvfit.common.form.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;

public class FitSdpProductSearchIndexTrafficForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1001906511602158076L;

	private FitSdpProductSearchIndexTraffic fitSdpProductSearchIndexTraffic;

	/** 查询 分页信息  **/
	private Pagination pagination = new Pagination();
	
	

	public FitSdpProductSearchIndexTraffic getFitSdpProductSearchIndexTraffic() {
		return fitSdpProductSearchIndexTraffic;
	}

	public void setFitSdpProductSearchIndexTraffic(
			FitSdpProductSearchIndexTraffic fitSdpProductSearchIndexTraffic) {
		this.fitSdpProductSearchIndexTraffic = fitSdpProductSearchIndexTraffic;
	}
	
	public PersistenceType getPtype() {
		return fitSdpProductSearchIndexTraffic.getPtype();
	}

	public Long getProductId() {
		return fitSdpProductSearchIndexTraffic.getProductId();
	}

	public void setPtype(PersistenceType ptype) {
		fitSdpProductSearchIndexTraffic.setPtype(ptype);
	}

	public void setProductId(Long productId) {
		fitSdpProductSearchIndexTraffic.setProductId(productId);
	}

	public String getSequence() {
		return fitSdpProductSearchIndexTraffic.getSequence();
	}

	public Long getId() {
		return fitSdpProductSearchIndexTraffic.getId();
	}

	public String getToTraffic() {
		return fitSdpProductSearchIndexTraffic.getToTraffic();
	}

	public void setId(Long id) {
		fitSdpProductSearchIndexTraffic.setId(id);
	}

	public void setToTraffic(String toTraffic) {
		fitSdpProductSearchIndexTraffic.setToTraffic(toTraffic);
	}

	public String getUuid() {
		return fitSdpProductSearchIndexTraffic.getUuid();
	}

	public void setUuid(String uuid) {
		fitSdpProductSearchIndexTraffic.setUuid(uuid);
	}

	public String getBackTraffic() {
		return fitSdpProductSearchIndexTraffic.getBackTraffic();
	}

	public Date getCreateTime() {
		return fitSdpProductSearchIndexTraffic.getCreateTime();
	}

	public void setBackTraffic(String backTraffic) {
		fitSdpProductSearchIndexTraffic.setBackTraffic(backTraffic);
	}

	public void setCreateTime(Date createTime) {
		fitSdpProductSearchIndexTraffic.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return fitSdpProductSearchIndexTraffic.getUpdateTime();
	}

	public String getDepatureTime() {
		return fitSdpProductSearchIndexTraffic.getDepatureTime();
	}

	public void setUpdateTime(Date updateTime) {
		fitSdpProductSearchIndexTraffic.setUpdateTime(updateTime);
	}

	public void setDepatureTime(String depatureTime) {
		fitSdpProductSearchIndexTraffic.setDepatureTime(depatureTime);
	}

	public String getSalesVolume() {
		return fitSdpProductSearchIndexTraffic.getSalesVolume();
	}

	public void setSalesVolume(String salesVolume) {
		fitSdpProductSearchIndexTraffic.setSalesVolume(salesVolume);
	}

	public JudgeType getIsMultiDepature() {
		return fitSdpProductSearchIndexTraffic.getIsMultiDepature();
	}

	public void setIsMultiDepature(JudgeType isMultiDepature) {
		fitSdpProductSearchIndexTraffic.setIsMultiDepature(isMultiDepature);
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
