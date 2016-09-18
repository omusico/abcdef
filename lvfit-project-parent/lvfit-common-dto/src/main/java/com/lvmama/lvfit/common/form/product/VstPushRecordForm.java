package com.lvmama.lvfit.common.form.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.vst.VstPushRecord;

public class VstPushRecordForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1001906511602158076L;

	private VstPushRecord VstPushRecord;

	/** 查询 分页信息  **/
	private Pagination pagination = new Pagination();
	
	

	public VstPushRecord getVstPushRecord() {
		return VstPushRecord;
	}

	public void setVstPushRecord(VstPushRecord vstPushRecord) {
		VstPushRecord = vstPushRecord;
	}

	
	public BigDecimal getId() {
		return VstPushRecord.getId();
	}

	public void setId(BigDecimal id) {
		VstPushRecord.setId(id);
	}

	public BigDecimal getObjectId() {
		return VstPushRecord.getObjectId();
	}

	public void setObjectId(BigDecimal objectId) {
		VstPushRecord.setObjectId(objectId);
	}

	public Date getCreateTime() {
		return VstPushRecord.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		VstPushRecord.setCreateTime(createTime);
	}

	public BigDecimal getObjectType() {
		return VstPushRecord.getObjectType();
	}

	public void setObjectType(BigDecimal objectType) {
		VstPushRecord.setObjectType(objectType);
	}

	public String getPushFlag() {
		return VstPushRecord.getPushFlag();
	}

	public void setPushFlag(String pushFlag) {
		VstPushRecord.setPushFlag(pushFlag);
	}

	public String getPushCount() {
		return VstPushRecord.getPushCount();
	}

	public void setPushCount(String pushCount) {
		VstPushRecord.setPushCount(pushCount);
	}

	public BigDecimal getPushContent() {
		return VstPushRecord.getPushContent();
	}

	public void setPushContent(BigDecimal pushContent) {
		VstPushRecord.setPushContent(pushContent);
	}

	public BigDecimal getDataType() {
		return VstPushRecord.getDataType();
	}

	public void setDataType(BigDecimal dataType) {
		VstPushRecord.setDataType(dataType);
	}

	public String getOperateType() {
		return VstPushRecord.getOperateType();
	}

	public void setOperateType(String operateType) {
		VstPushRecord.setOperateType(operateType);
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
