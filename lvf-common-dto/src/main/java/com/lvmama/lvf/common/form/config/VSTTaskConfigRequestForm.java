package com.lvmama.lvf.common.form.config;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Oper;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.vst.VstTaskConfigDto;
import com.lvmama.lvf.common.form.Form;

public class VSTTaskConfigRequestForm implements Form, Serializable {

	private static final long serialVersionUID = 5459276355535199891L;
	
	private VstTaskConfigDto vstTaskConfig = new VstTaskConfigDto();
	
	private String updateBeginTime;
	
	private String updateEndTime;
	
	private Date updateStartTime;
	
	private Pagination pagination = new Pagination(); 
	
	private String handleFlag;
	
	private String lastStartTimeStr;
	
	private String lastEndTimeStr;
	
	private String handleUpdateTimeStr;
	
	public VstTaskConfigDto getVstTaskConfig() {
		return vstTaskConfig;
	}

	public void setVstTaskConfig(VstTaskConfigDto vstTaskConfig) {
		this.vstTaskConfig = vstTaskConfig;
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

	public String getUpdateBeginTime() {
		return updateBeginTime;
	}

	public void setUpdateBeginTime(String updateBeginTime) {
		this.updateBeginTime = updateBeginTime;
	}

	public String getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(String updateEndTime) {
		this.updateEndTime = updateEndTime;
	}
	
	public String getDeptCityCode() {
		return vstTaskConfig.getDeptCityCode();
	}

	public void setDeptCityCode(String deptCityCode) {
		vstTaskConfig.setDeptCityCode(deptCityCode);
	}

	public String getArrvCityCode() {
		return vstTaskConfig.getArrvCityCode();
	}

	public void setArrvCityCode(String arrvCityCode) {
		vstTaskConfig.setArrvCityCode(arrvCityCode);
	}
	
	public String getRunTimeStart() {
		return vstTaskConfig.getRunTimeStart();
	}

	public void setRunTimeStart(String runTimeStart) {
		vstTaskConfig.setRunTimeStart(runTimeStart);
	}

	public String getRunTimeEnd() {
		return vstTaskConfig.getRunTimeEnd();
	}

	public void setRunTimeEnd(String runTimeEnd) {
		vstTaskConfig.setRunTimeEnd(runTimeEnd);
	}

	public Long getRate() {
		return vstTaskConfig.getRate();
	}

	public void setRate(Long rate) {
		vstTaskConfig.setRate(rate);
	}

	public String getWorkerNo() {
		return vstTaskConfig.getWorkerNo();
	}

	public void setWorkerNo(String workerNo) {
		vstTaskConfig.setWorkerNo(workerNo);
	}

	public Long getRunTimes() {
		return vstTaskConfig.getRunTimes();
	}

	public void setRunTimes(Long runTimes) {
		vstTaskConfig.setRunTimes(runTimes);
	}

	public String getActiveFlag() {
		return vstTaskConfig.getActiveFlag();
	}

	public void setActiveFlag(String activeFlag) {
		vstTaskConfig.setActiveFlag(activeFlag);
	}
	
	public Date getUpdateTime(){
		return vstTaskConfig.getUpdateTime();
	}
	
	public void setUpdateTime(Date updateTime){
		vstTaskConfig.setUpdateTime(updateTime);
	}
	
	public Date getCreateTime(){
		return vstTaskConfig.getCreateTime();
	}
	
	public void setCreateTime(Date createTime){
		vstTaskConfig.setCreateTime(createTime);
	}

	public Date getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Date updateStartTime) {
		this.updateStartTime = updateStartTime;
	}
	
	public Long getId(){
		return vstTaskConfig.getId();
	}
	
	public void setId(Long id){
		vstTaskConfig.setId(id);
	}

	public String getHandleFlag() {
		return handleFlag;
	}

	public void setHandleFlag(String handleFlag) {
		this.handleFlag = handleFlag;
	}
	
	public Date getLastEndTime() {
		return vstTaskConfig.getLastEndTime();
	}

	public void setLastEndTime(Date lastEndTime) {
		vstTaskConfig.setLastEndTime(lastEndTime);
	}

	public Date getLastStartTime() {
		return vstTaskConfig.getLastStartTime();
	}

	public void setLastStartTime(Date lastStartTime) {
		vstTaskConfig.setLastStartTime(lastStartTime);
	}

	public int getRunFlag() {
		return vstTaskConfig.getRunFlag();
	}

	public void setRunFlag(int runFlag) {
		vstTaskConfig.setRunFlag(runFlag);
	}

	public String getLastStartTimeStr() {
		return lastStartTimeStr;
	}

	public void setLastStartTimeStr(String lastStartTimeStr) {
		this.lastStartTimeStr = lastStartTimeStr;
	}

	public String getLastEndTimeStr() {
		return lastEndTimeStr;
	}

	public void setLastEndTimeStr(String lastEndTimeStr) {
		this.lastEndTimeStr = lastEndTimeStr;
	}
	
	public Oper getOper() {
		return vstTaskConfig.getOper();
	}

	public void setOper(Oper oper) {
		vstTaskConfig.setOper(oper);
	}
	
	public Date getHandleUpdateTime(){
		return vstTaskConfig.getHandleUpdateTime();
	}
	
	public void setHandleUpdateTime(Date handleUpdateTime){
		vstTaskConfig.setHandleUpdateTime(handleUpdateTime);
	}

	public String getHandleUpdateTimeStr() {
		return handleUpdateTimeStr;
	}

	public void setHandleUpdateTimeStr(String handleUpdateTimeStr) {
		this.handleUpdateTimeStr = handleUpdateTimeStr;
	}
	
	public Long getLowPriceGetPeriod(){
		return vstTaskConfig.getLowPriceGetPeriod();
	}
	
	public void setLowPriceGetPeriod(Long lowPriceGetPeriod){
		vstTaskConfig.setLowPriceGetPeriod(lowPriceGetPeriod);
	}
}
