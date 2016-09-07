package com.lvmama.lvf.common.form.settlement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.StatementStatus;
import com.lvmama.lvf.common.dto.request.SettlementOrderRequest;
import com.lvmama.lvf.common.dto.settlement.SettlementOrderDto;
import com.lvmama.lvf.common.dto.status.order.OrderSettlementStatus;
import com.lvmama.lvf.common.form.Form;

/**
 * 结算列表inputForm
 * @author hedandan
 *
 */
public class SettlementOrderInputForm implements Serializable,Form{

	private static final long serialVersionUID = -8435744100844510130L;

	private SettlementOrderRequest request = new SettlementOrderRequest();

	private Pagination pagination = new Pagination();
	
	public SettlementOrderRequest getRequest() {
		return request;
	}

	public void setRequest(SettlementOrderRequest request) {
		this.request = request;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public SettlementOrderDto getSettlementOrderDto() {
		return request.getSettlementOrderDto();
	}

	public void setSettlementOrderDto(SettlementOrderDto settlementOrderDto) {
		request.setSettlementOrderDto(settlementOrderDto);
	}

	public String getSequence() {
		return request.getSequence();
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

	public void setUuid(String uuid) {
		request.setUuid(uuid);
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

	public String getSettlementOrderNo() {
		return request.getSettlementOrderNo();
	}

	public void setSettlementOrderNo(String settlementOrderNo) {
		request.setSettlementOrderNo(settlementOrderNo);
	}

	public BusinessType getMainBusinessType() {
		return request.getMainBusinessType();
	}

	public void setMainBusinessType(BusinessType mainBusinessType) {
		request.setMainBusinessType(mainBusinessType);
	}

	public String getMainBusinessId() {
		return request.getMainBusinessId();
	}

	public void setMainBusinessId(String mainBusinessId) {
		request.setMainBusinessId(mainBusinessId);
	}

	public String getMainBusinessNo() {
		return request.getMainBusinessNo();
	}

	public void setMainBusinessNo(String mainBusinessNo) {
		request.setMainBusinessNo(mainBusinessNo);
	}

	public BusinessType getBusinessType() {
		return request.getBusinessType();
	}

	public void setBusinessType(BusinessType businessType) {
		request.setBusinessType(businessType);
	}

	public String getBusinessId() {
		return request.getBusinessId();
	}

	public void setBusinessId(String businessId) {
		request.setBusinessId(businessId);
	}

	public String getBusinessNo() {
		return request.getBusinessNo();
	}

	public void setBusinessNo(String businessNo) {
		request.setBusinessNo(businessNo);
	}

	public String getBusinessStatus() {
		return request.getBusinessStatus();
	}

	public void setBusinessStatus(String businessStatus) {
		request.setBusinessStatus(businessStatus);
	}

	public String getBusinessPayStatus() {
		return request.getBusinessPayStatus();
	}

	public void setBusinessPayStatus(String businessPayStatus) {
		request.setBusinessPayStatus(businessPayStatus);
	}

	public Date getBusinessPayTime() {
		return request.getBusinessPayTime();
	}

	public void setBusinessPayTime(Date businessPayTime) {
		request.setBusinessPayTime(businessPayTime);
	}

	public Date getBusinessCreateTime() {
		return request.getBusinessCreateTime();
	}

	public void setBusinessCreateTime(Date businessCreateTime) {
		request.setBusinessCreateTime(businessCreateTime);
	}

	public String getBusinessContacter() {
		return request.getBusinessContacter();
	}

	public void setBusinessContacter(String businessContacter) {
		request.setBusinessContacter(businessContacter);
	}

	public Boolean getIsRefund() {
		return request.getIsRefund();
	}

	public void setIsRefund(Boolean isRefund) {
		request.setIsRefund(isRefund);
	}

	public String getRefundRemark() {
		return request.getRefundRemark();
	}

	public void setRefundRemark(String refundRemark) {
		request.setRefundRemark(refundRemark);
	}

	public String getBusinessDesc() {
		return request.getBusinessDesc();
	}

	public void setBusinessDesc(String businessDesc) {
		request.setBusinessDesc(businessDesc);
	}

	public BigDecimal getSalesPrice() {
		return request.getSalesPrice();
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		request.setSalesPrice(salesPrice);
	}

	public BigDecimal getSettlePrice() {
		return request.getSettlePrice();
	}

	public void setSettlePrice(BigDecimal settlePrice) {
		request.setSettlePrice(settlePrice);
	}

	public BigDecimal getTo3rdSettlePrice() {
		return request.getTo3rdSettlePrice();
	}

	public void setTo3rdSettlePrice(BigDecimal to3rdSettlePrice) {
		request.setTo3rdSettlePrice(to3rdSettlePrice);
	}

	public Long getBusinessSize() {
		return request.getBusinessSize();
	}

	public void setBusinessSize(Long businessSize) {
		request.setBusinessSize(businessSize);
	}

	public Date getUsedTime() {
		return request.getUsedTime();
	}

	public void setUsedTime(Date usedTime) {
		request.setUsedTime(usedTime);
	}

	public StatementStatus getStatementStatus() {
		return request.getStatementStatus();
	}

	public void setStatementStatus(StatementStatus statementStatus) {
		request.setStatementStatus(statementStatus);
	}

	public BigDecimal getRefundedAmount() {
		return request.getRefundedAmount();
	}

	public void setRefundedAmount(BigDecimal refundedAmount) {
		request.setRefundedAmount(refundedAmount);
	}

	public BigDecimal getTo3rdSettleAmount() {
		return request.getTo3rdSettleAmount();
	}

	public void setTo3rdSettleAmount(BigDecimal to3rdSettleAmount) {
		request.setTo3rdSettleAmount(to3rdSettleAmount);
	}

	public BigDecimal getTotalPayedAmount() {
		return request.getTotalPayedAmount();
	}

	public void setTotalPayedAmount(BigDecimal totalPayedAmount) {
		request.setTotalPayedAmount(totalPayedAmount);
	}

	public BigDecimal getTo3rdActualSettleAmount() {
		return request.getTo3rdActualSettleAmount();
	}

	public void setTo3rdActualSettleAmount(BigDecimal to3rdActualSettleAmount) {
		request.setTo3rdActualSettleAmount(to3rdActualSettleAmount);
	}

	public BigDecimal getPayedAmount() {
		return request.getPayedAmount();
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		request.setPayedAmount(payedAmount);
	}

	public String getBelongBU() {
		return request.getBelongBU();
	}

	public void setBelongBU(String belongBU) {
		request.setBelongBU(belongBU);
	}

	public String getSettlePeriod() {
		return request.getSettlePeriod();
	}

	public void setSettlePeriod(String settlePeriod) {
		request.setSettlePeriod(settlePeriod);
	}

	public String getSuppCode() {
		return request.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		request.setSuppCode(suppCode);
	}

	public OrderSettlementStatus getOrderSettlementStatus() {
		return request.getOrderSettlementStatus();
	}

	public void setOrderSettlementStatus(
			OrderSettlementStatus orderSettlementStatus) {
		request.setOrderSettlementStatus(orderSettlementStatus);
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

	public String getStartPayedTime() {
		return request.getStartPayedTime();
	}

	public void setStartPayedTime(String startPayedTime) {
		request.setStartPayedTime(startPayedTime);
	}

	public String getEndPayedTime() {
		return request.getEndPayedTime();
	}

	public void setEndPayedTime(String endPayedTime) {
		request.setEndPayedTime(endPayedTime);
	}

	public String getStartCreateTime() {
		return request.getStartCreateTime();
	}

	public void setStartCreateTime(String startCreateTime) {
		request.setStartCreateTime(startCreateTime);
	}

	public String getEndCreateTime() {
		return request.getEndCreateTime();
	}

	public void setEndCreateTime(String endCreateTime) {
		request.setEndCreateTime(endCreateTime);
	}

	public String getStartUsedTime() {
		return request.getStartUsedTime();
	}

	public void setStartUsedTime(String startUsedTime) {
		request.setStartUsedTime(startUsedTime);
	}

	public String getEndUsedTime() {
		return request.getEndUsedTime();
	}

	public void setEndUsedTime(String endUsedTime) {
		request.setEndUsedTime(endUsedTime);
	}

	public List<Long> getIds() {
		return request.getIds();
	}

	public void setIds(List<Long> ids) {
		request.setIds(ids);
	}
	
}
