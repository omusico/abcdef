package com.lvmama.lvf.common.form.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.adapter.request.insurance.FlightInsuranceRequest;
import com.lvmama.lvf.common.dto.enums.Gender;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.enums.InsuranceStatus;
import com.lvmama.lvf.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 保单列表信息
 * 
 */
public class InsuranceOrderListInputForm implements Serializable, Form {

	private static final long serialVersionUID = -5784076058798325712L;

	private FlightInsuranceRequest request = new FlightInsuranceRequest();

	private Pagination pagination = new Pagination();

	public InsuranceOrderDto getInsuranceOrderDto() {
		return request.getInsuranceOrderDto();
	}

	public void setInsuranceOrderDto(InsuranceOrderDto insuranceOrderDto) {
		request.setInsuranceOrderDto(insuranceOrderDto);
	}

	public Long getId() {
		return request.getId();
	}

	public void setId(Long id) {
		request.setId(id);
	}

	public String getUuid() {
		return request.getUuid();
	}

	public Date getCreateTime() {
		return request.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		request.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return request.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		request.setUpdateTime(updateTime);
	}

	public String getInsuranceNo() {
		return request.getInsuranceNo();
	}

	public void setInsuranceNo(String insuranceNo) {
		request.setInsuranceNo(insuranceNo);
	}

	public String getTicketNo() {
		return request.getTicketNo();
	}

	public void setTicketNo(String ticketNo) {
		request.setTicketNo(ticketNo);
	}

	public Date getInsureDate() {
		return request.getInsureDate();
	}

	public void setInsureDate(Date insureDate) {
		request.setInsureDate(insureDate);
	}

	public Gender getGender() {
		return request.getGender();
	}

	public void setGender(Gender gender) {
		request.setGender(gender);
	}

	public InsuranceStatus getInsuranceStatus() {
		return request.getInsuranceStatus();
	}

	public void setInsuranceStatus(InsuranceStatus insuranceStatus) {
		request.setInsuranceStatus(insuranceStatus);
	}

	public String getInsuredName() {
		return request.getInsuredName();
	}

	public void setInsuredName(String insuredName) {
		request.setInsuredName(insuredName);
	}

	public InsuranceInfoDto getInsuranceInfoDto() {
		return request.getInsuranceInfoDto();
	}

	public void setInsuranceInfoDto(InsuranceInfoDto insuranceInfoDto) {
		request.setInsuranceInfoDto(insuranceInfoDto);
	}

	public Date getBirthday() {
		return request.getBirthday();
	}

	public void setBirthday(Date birthday) {
		request.setBirthday(birthday);
	}

	public Date getEffectDate() {
		return request.getEffectDate();
	}

	public void setEffectDate(Date effectDate) {
		request.setEffectDate(effectDate);
	}

	public Date getExpireDate() {
		return request.getExpireDate();
	}

	public void setExpireDate(Date expireDate) {
		request.setExpireDate(expireDate);
	}

	public IDCardType getIdCardType() {
		return request.getIdCardType();
	}

	public void setIdCardType(IDCardType idCardType) {
		request.setIdCardType(idCardType);
	}

	public String getIdCardNo() {
		return request.getIdCardNo();
	}

	public void setIdCardNo(String idCardNo) {
		request.setIdCardNo(idCardNo);
	}

	public String getFlightNo() {
		return request.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		request.setFlightNo(flightNo);
	}

	public String getInsuranceOrderNo() {
		return request.getInsuranceOrderNo();
	}

	public void setInsuranceOrderNo(String insuranceOrderNo) {
		request.setInsuranceOrderNo(insuranceOrderNo);
	}

	public Integer getInsuredNum() {
		return request.getInsuredNum();
	}

	public void setInsuredNum(Integer insuredNum) {
		request.setInsuredNum(insuredNum);
	}

	public BigDecimal getSettleAccounts() {
		return request.getSettleAccounts();
	}

	public void setSettleAccounts(BigDecimal settleAccounts) {
		request.setSettleAccounts(settleAccounts);
	}

	public String getEmail() {
		return request.getEmail();
	}

	public void setEmail(String email) {
		request.setEmail(email);
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

	public FlightInsuranceRequest getRequest() {
		return request;
	}

	public void setRequest(FlightInsuranceRequest request) {
		this.request = request;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setUuid(String uuid) {
		request.setUuid(uuid);
	}

	public String getStartInsureDate() {
		return request.getStartInsureDate();
	}

	public void setStartInsureDate(String startInsureDate) {
		request.setStartInsureDate(startInsureDate);
	}

	public String getEndInsureDate() {
		return request.getEndInsureDate();
	}

	public void setEndInsureDate(String endInsureDate) {
		request.setEndInsureDate(endInsureDate);
	}

	public String getStartEffectDate() {
		return request.getStartEffectDate();
	}

	public void setStartEffectDate(String startEffectDate) {
		request.setStartEffectDate(startEffectDate);
	}

	public String getEndEffectDate() {
		return request.getEndEffectDate();
	}

	public void setEndEffectDate(String endEffectDate) {
		request.setEndEffectDate(endEffectDate);
	}

	public String getOrderNo() {
		return request.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		request.setOrderNo(orderNo);
	}
	
	public Long getOrderId() {
		return request.getOrderId();
	}

	public void setOrderId(Long orderId) {
		request.setOrderId(orderId);
	}

	public String getDesc() {
		return request.getDesc();
	}

	public void setDesc(String desc) {
		request.setDesc(desc);
	}

	public String getCellphone() {
		return request.getCellphone();
	}

	public void setCellphone(String cellphone) {
		request.setCellphone(cellphone);
	}

	public String getStartHesitateDate() {
		return request.getStartHesitateDate();
	}

	public void setStartHesitateDate(String startHesitateDate) {
		request.setStartHesitateDate(startHesitateDate);
	}

	public String getEndHesitateDate() {
		return request.getEndHesitateDate();
	}

	public void setEndHesitateDate(String endHesitateDate) {
		request.setEndHesitateDate(endHesitateDate);
	}

	public String getInsuranceClassName() {
		return request.getInsuranceClassName();
	}

	public void setInsuranceClassName(String insuranceClassName) {
		request.setInsuranceClassName(insuranceClassName);
	}

	public String getProductTypes() {
		return request.getProductTypes();
	}

	public void setProductTypes(String productTypes) {
		request.setProductTypes(productTypes);
	}
}
