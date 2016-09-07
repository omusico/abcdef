package com.lvmama.lvf.common.form.travel;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.Gender;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.travel.TravelCompanyInfoDto;
import com.lvmama.lvf.common.dto.travel.TravelPassengerDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * @author lutianyu
 * @date   2016年1月26日
 */
public class TravelPassengerForm implements Serializable, Form{
	private static final long serialVersionUID = 1L;
	
	private TravelPassengerDto travelPassengerDto = new TravelPassengerDto();
	private Pagination pagination = new Pagination();
	
	public TravelPassengerDto getTravelPassengerDto() {
		return travelPassengerDto;
	}
	public void setTravelPassengerDto(TravelPassengerDto travelPassengerDto) {
		this.travelPassengerDto = travelPassengerDto;
	}
	public Long getCompanyId() {
		return travelPassengerDto.getCompanyId();
	}
	public void setCompanyId(Long companyId) {
		travelPassengerDto.setCompanyId(companyId);
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public ActiveStatus getActiveStatus() {
		return travelPassengerDto.getActiveStatus();
	}
	public String getPassengerName() {
		return travelPassengerDto.getPassengerName();
	}
	public void setActiveStatus(ActiveStatus activeStatus) {
		travelPassengerDto.setActiveStatus(activeStatus);
	}
	public void setPassengerName(String passengerName) {
		travelPassengerDto.setPassengerName(passengerName);
	}
	public Long getId() {
		return travelPassengerDto.getId();
	}
	public void setId(Long id) {
		travelPassengerDto.setId(id);
	}
	public String getPassengerType() {
		return travelPassengerDto.getPassengerType();
	}
	public void setPassengerType(String passengerType) {
		travelPassengerDto.setPassengerType(passengerType);
	}
	public Date getCreateTime() {
		return travelPassengerDto.getCreateTime();
	}
	public String getPassengerIdCardType() {
		return travelPassengerDto.getPassengerIdCardType();
	}
	public void setPassengerIdCardType(String passengerIdCardType) {
		travelPassengerDto.setPassengerIdCardType(passengerIdCardType);
	}
	public Date getUpdateTime() {
		return travelPassengerDto.getUpdateTime();
	}
	public void setUpdateTime(Date updateTime) {
		travelPassengerDto.setUpdateTime(updateTime);
	}
	public String getPassengerIdCardNo() {
		return travelPassengerDto.getPassengerIdCardNo();
	}
	public void setPassengerIdCardNo(String passengerIdCardNo) {
		travelPassengerDto.setPassengerIdCardNo(passengerIdCardNo);
	}
	public String getGender() {
		return travelPassengerDto.getGender();
	}
	public void setGender(String gender) {
		travelPassengerDto.setGender(gender);
	}
	public Date getPassengerBirthday() {
		return travelPassengerDto.getPassengerBirthday();
	}
	public void setPassengerBirthday(Date passengerBirthday) {
		travelPassengerDto.setPassengerBirthday(passengerBirthday);
	}
	public String getPassengerTelphone() {
		return travelPassengerDto.getPassengerTelphone();
	}
	public void setPassengerTelphone(String passengerTelphone) {
		travelPassengerDto.setPassengerTelphone(passengerTelphone);
	}
	public String getPassengerCellphone() {
		return travelPassengerDto.getPassengerCellphone();
	}
	public void setPassengerCellphone(String passengerCellphone) {
		travelPassengerDto.setPassengerCellphone(passengerCellphone);
	}
	public TravelCompanyInfoDto getCompany() {
		return travelPassengerDto.getCompany();
	}
	public void setCompany(TravelCompanyInfoDto company) {
		travelPassengerDto.setCompany(company);
	}
	public String getJob() {
		return travelPassengerDto.getJob();
	}
	public void setJob(String job) {
		travelPassengerDto.setJob(job);
	}
	public String getRemark() {
		return travelPassengerDto.getRemark();
	}
	public void setRemark(String remark) {
		travelPassengerDto.setRemark(remark);
	}
	public int getPage() {
		return pagination.getPage();
	}
	public void setPage(int page) {
		pagination.setPage(page);
	}
	public int hashCode() {
		return pagination.hashCode();
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
	public String toString() {
		return pagination.toString();
	}
	public boolean equals(Object obj) {
		return pagination.equals(obj);
	}
	
	public String getPassengerBirthdayStr() {
		return DateUtils.formatDate(getPassengerBirthday());
	}
	public String getPassengerTypeStr(){
		return StringUtils.isNotBlank(getPassengerType())?PassengerType.getCnNameByName(getPassengerType()):"";
	}
	public String getGenderStr(){
		return StringUtils.isNotBlank(getGender())? Gender.getCnNameByName(getGender()):"";
	}
	public String getPassengerIDCardTypeStr(){
		return StringUtils.isNotBlank(getPassengerIdCardType())?IDCardType.getCnNameByName(getPassengerIdCardType()):"";
	}
	
}
