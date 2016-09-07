package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstProductBranchDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VSTProductBranchResponseForm implements Form, Serializable {

	private static final long serialVersionUID = -8450111197191424793L;
	
	private FlightVstProductBranchDto vstProductBranch = new FlightVstProductBranchDto();
	
	private Pagination pagination = new Pagination();
	
	public FlightVstProductBranchDto getVstProductBranch() {
		return vstProductBranch;
	}

	public void setVstProductBranch(FlightVstProductBranchDto vstProductBranch) {
		this.vstProductBranch = vstProductBranch;
	}
	
	public Long getVstProductBranchId() {
		return vstProductBranch.getVstProductBranchId();
	}

	public void setVstProductBranchId(Long vstProductBranchId) {
		vstProductBranch.setVstProductBranchId(vstProductBranchId);
	}

	public Long getVstProductId() {
		return vstProductBranch.getVstProductId();
	}

	public void setVstProductId(Long vstProductId) {
		vstProductBranch.setVstProductId(vstProductId);
	}

	public String getSeatClassTypeCode() {
		return vstProductBranch.getSeatClassTypeCode();
	}

	public void setSeatClassTypeCode(String seatClassTypeCode) {
		vstProductBranch.setSeatClassTypeCode(seatClassTypeCode);
	}

	public String getSeatClassTypeName() {
		return vstProductBranch.getSeatClassTypeName();
	}

	public void setSeatClassTypeName(String seatClassTypeName) {
		vstProductBranch.setSeatClassTypeName(seatClassTypeName);
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
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
	
	public BatchFlag getBatchFlag() {
		return vstProductBranch.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		vstProductBranch.setBatchFlag(batchFlag);
	}
	
	public Date getUpdateTime(){
		return vstProductBranch.getUpdateTime();
	}
	
	public void setUpdateTime(Date updateTime){
		vstProductBranch.setUpdateTime(updateTime);
	}
	
	public Date getCreateTime(){
		return vstProductBranch.getCreateTime();
	}
	
	public void setCreateTime(Date createTime){
		vstProductBranch.setCreateTime(createTime);
	}
	
	public String getUpdateTimeStr(){
		if(this.getUpdateTime()!=null){
			return DateUtils.formatDate(this.getUpdateTime(), DateUtils.YYYY_MM_DD);
		}
		return null;
	}
	
	public String getCreateTimeStr(){
		if(this.getCreateTime()!=null){
			return DateUtils.formatDate(this.getCreateTime(), DateUtils.YYYY_MM_DD);
		}
		return null;
	}

}
