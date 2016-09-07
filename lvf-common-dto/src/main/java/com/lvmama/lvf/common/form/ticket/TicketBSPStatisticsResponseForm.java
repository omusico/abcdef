package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPStatisticsDetailDto;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPStatisticsDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 行程单统计 responseForm
 * 
 * @author zzs
 */
public class TicketBSPStatisticsResponseForm implements Serializable, Form {

	private static final long serialVersionUID = -4757538370658143285L;
	private FlightTicketBSPStatisticsDetailDto flightTicketBSPStatisticsDetail;
	private FlightTicketBSPStatisticsDto flightTicketBSPStatistics;
    

	public TicketBSPStatisticsResponseForm(FlightTicketBSPStatisticsDto flightTicketBSPStatistics,FlightTicketBSPStatisticsDetailDto flightTicketBSPStatisticsDetailDto) {
		super();
		this.flightTicketBSPStatistics = flightTicketBSPStatistics;
		this.flightTicketBSPStatisticsDetail = flightTicketBSPStatisticsDetailDto;
	}


	public Integer getTotalStorageCount() {
		return flightTicketBSPStatistics.getTotalStorageCount();
	}


	public void setTotalStorageCount(Integer totalStorageCount) {
		flightTicketBSPStatistics.setTotalStorageCount(totalStorageCount);
	}


	public Integer getTotalOutStorageCount() {
		return flightTicketBSPStatistics.getTotalOutStorageCount();
	}


	public void setTotalOutStorageCount(Integer totalOutStorageCount) {
		flightTicketBSPStatistics.setTotalOutStorageCount(totalOutStorageCount);
	}


	public Integer getTotalUsedCount() {
		return flightTicketBSPStatistics.getTotalUsedCount();
	}


	public void setTotalUsedCount(Integer totalUsedCount) {
		flightTicketBSPStatistics.setTotalUsedCount(totalUsedCount);
	}


	public Integer getTotalPrintCount() {
		return flightTicketBSPStatistics.getTotalPrintCount();
	}


	public void setTotalPrintCount(Integer totalPrintCount) {
		flightTicketBSPStatistics.setTotalPrintCount(totalPrintCount);
	}


	public Integer getTotalInvalidCount() {
		return flightTicketBSPStatistics.getTotalInvalidCount();
	}


	public void setTotalInvalidCount(Integer totalInvalidCount) {
		flightTicketBSPStatistics.setTotalInvalidCount(totalInvalidCount);
	}


	public Integer getTotalRecycleCount() {
		return flightTicketBSPStatistics.getTotalRecycleCount();
	}


	public void setTotalRecycleCount(Integer totalRecycleCount) {
		flightTicketBSPStatistics.setTotalRecycleCount(totalRecycleCount);
	}


	public String getBspStartNo() {
		return flightTicketBSPStatisticsDetail.getBspStartNo();
	}


	public void setBspStartNo(String bspStartNo) {
		flightTicketBSPStatisticsDetail.setBspStartNo(bspStartNo);
	}


	public String getBspEndNo() {
		return flightTicketBSPStatisticsDetail.getBspEndNo();
	}


	public void setBspEndNo(String bspEndNo) {
		flightTicketBSPStatisticsDetail.setBspEndNo(bspEndNo);
	}


	public List<String> getOfficeNos() {
		return flightTicketBSPStatisticsDetail.getOfficeNos();
	}


	public void setOfficeNos(List<String> officeNos) {
		flightTicketBSPStatisticsDetail.setOfficeNos(officeNos);
	}


	public String getOfficeNo() {
		return flightTicketBSPStatisticsDetail.getOfficeNo();
	}


	public void setOfficeNo(String officeNo) {
		flightTicketBSPStatisticsDetail.setOfficeNo(officeNo);
	}


	public Integer getStorageCount() {
		return flightTicketBSPStatisticsDetail.getStorageCount();
	}


	public void setStorageCount(Integer storageCount) {
		flightTicketBSPStatisticsDetail.setStorageCount(storageCount);
	}


	public Integer getOutStorageCount() {
		return getStorageCount()-getUnUsedCount();
	}


	public void setOutStorageCount(Integer outStorageCount) {
		flightTicketBSPStatisticsDetail.setOutStorageCount(outStorageCount);
	}



	public Integer getPrintCount() {
		return flightTicketBSPStatisticsDetail.getPrintCount();
	}


	public void setPrintCount(Integer printCount) {
		flightTicketBSPStatisticsDetail.setPrintCount(printCount);
	}


	public Integer getInvalidCount() {
		return flightTicketBSPStatisticsDetail.getInvalidCount();
	}


	public void setInvalidCount(Integer invalidCount) {
		flightTicketBSPStatisticsDetail.setInvalidCount(invalidCount);
	}


	public Integer getRecycleCount() {
		return flightTicketBSPStatisticsDetail.getRecycleCount();
	}


	public void setRecycleCount(Integer recycleCount) {
		flightTicketBSPStatisticsDetail.setRecycleCount(recycleCount);
	}


	public String getOperName() {
		return flightTicketBSPStatisticsDetail.getOperName();
	}


	public void setOperName(String operName) {
		flightTicketBSPStatisticsDetail.setOperName(operName);
	}


	public Long getId() {
		return flightTicketBSPStatisticsDetail.getId();
	}


	public void setId(Long id) {
		flightTicketBSPStatisticsDetail.setId(id);
	}


	public String getCreateTime() {
		return DateUtils.formatCnHmDate(flightTicketBSPStatisticsDetail.getCreateTime());
	}


	public void setCreateTime(Date createTime) {
		flightTicketBSPStatisticsDetail.setCreateTime(createTime);
	}


	public Integer getUnUsedCount() {
		return flightTicketBSPStatisticsDetail.getUnUsedCount();
	}


	public void setUnUsedCount(Integer unUsedCount) {
		flightTicketBSPStatisticsDetail.setUnUsedCount(unUsedCount);
	}

}
