package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Oper;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.TaskOpType;
import com.lvmama.lvf.common.dto.vst.VstTaskOpLog;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VstTaskOpLogResponseForm implements Form, Serializable {

	private static final long serialVersionUID = 8673353406593470724L;

	private VstTaskOpLog taskOpLog = new VstTaskOpLog();

	private Pagination pagination = new Pagination();
	
	public VstTaskOpLog getTaskOpLog() {
		return taskOpLog;
	}

	public void setTaskOpLog(VstTaskOpLog taskOpLog) {
		this.taskOpLog = taskOpLog;
	}
	
	public Long getId(){
		return taskOpLog.getId();
	}
	
	public void setId(Long id){
		taskOpLog.setId(id);
	}

	public String getDeptCityCode() {
		return taskOpLog.getDeptCityCode();
	}

	public void setDeptCityCode(String deptCityCode) {
		taskOpLog.setDeptCityCode(deptCityCode);
	}

	public String getArrvCityCode() {
		return taskOpLog.getArrvCityCode();
	}

	public void setArrvCityCode(String arrvCityCode) {
		taskOpLog.setArrvCityCode(arrvCityCode);
	}

	public Long getVstTaskConfigId() {
		return taskOpLog.getVstTaskConfigId();
	}

	public void setVstTaskConfigId(Long vstTaskConfigId) {
		taskOpLog.setVstTaskConfigId(vstTaskConfigId);
	}

	public int getBasicFlightCount() {
		return taskOpLog.getBasicFlightCount();
	}

	public void setBasicFlightCount(int basicFlightCount) {
		taskOpLog.setBasicFlightCount(basicFlightCount);
	}

	public int getGoodsCount() {
		return taskOpLog.getGoodsCount();
	}

	public void setGoodsCount(int goodsCount) {
		taskOpLog.setGoodsCount(goodsCount);
	}

	public String getRemark() {
		return taskOpLog.getRemark();
	}

	public void setRemark(String remark) {
		taskOpLog.setRemark(remark);
	}

	public Oper getOper() {
		return taskOpLog.getOper();
	}

	public void setOper(Oper oper) {
		taskOpLog.setOper(oper);
	}

	public TaskOpType getTaskOpType() {
		return taskOpLog.getTaskOpType();
	}

	public void setTaskOpType(TaskOpType taskOpType) {
		taskOpLog.setTaskOpType(taskOpType);
	}

	public Date getOpTime() {
		return taskOpLog.getOpTime();
	}

	public void setOpTime(Date opTime) {
		taskOpLog.setOpTime(opTime);
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
		return pagination .getSord();
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
	
	public String getOpTimeStr(){
		if(this.getOpTime()!=null){
			return DateUtils.formatCnHmDate(this.getOpTime());
		}
		return null;
	}
	
	public String getTaskOpTypeStr(){
		if(this.getTaskOpType()!=null){
			return this.getTaskOpType().getCnName();
		}
		return null;
	}
}
