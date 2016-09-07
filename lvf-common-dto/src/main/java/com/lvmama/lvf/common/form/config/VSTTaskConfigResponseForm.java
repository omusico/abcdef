package com.lvmama.lvf.common.form.config;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Oper;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.vst.VstTaskConfigDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VSTTaskConfigResponseForm implements Form, Serializable {

	private static final long serialVersionUID = 5459276355535199891L;
	
	private VstTaskConfigDto vstTaskConfig = new VstTaskConfigDto();

	private String message;
	
	private Boolean flag = true;
	
	private Pagination pagination = new Pagination();
	
	private String updateTimeStr;
	
	private String createTimeStr;
	
	private String lastStartTimeStr;
	
	private String lastEndTimeStr;
	
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

	@JsonIgnore
	public int getStartRow() {
		return pagination.getStartRow();
	}

	@JsonIgnore
	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
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
	
	public Long getId(){
		return vstTaskConfig.getId();
	}
	
	public void setId(Long id){
		vstTaskConfig.setId(id);
	}
	
	public String getUpdateTimeStr(){
		if(this.getUpdateTime()!=null){
			return DateUtils.formatCnHmDate(this.getUpdateTime());
		}
		return null;
	}
	
	public String getCreateTimeStr(){
		if(this.getCreateTime()!=null){
			return DateUtils.formatCnHmDate(this.getCreateTime());
		}
		return null;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
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
	
	public Oper getOper() {
		return vstTaskConfig.getOper();
	}

	public void setOper(Oper oper) {
		vstTaskConfig.setOper(oper);
	}
	
	public String getLastStartTimeStr(){
		if(this.getLastStartTime()!=null){
			return DateUtils.formatCnHmDate(this.getLastStartTime());
		}
		return null;
	}
	
	public String getLastEndTimeStr(){
		if(this.getLastEndTime()!=null){
			return DateUtils.formatCnHmDate(this.getLastEndTime());
		}
		return null;
	}

}
