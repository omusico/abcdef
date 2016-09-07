package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.StatementStatus;
import com.lvmama.lvf.common.dto.settlement.SettlementOrderDto;
import com.lvmama.lvf.common.dto.status.order.OrderSettlementStatus;

/**   
 * @Title: SettlementOrderRequest.java 
 * @Package com.lvmama.lvf.common.dto.request 
 * @Description: 结算请求
 * @author hedandan
 * @date 2015年8月24日
 */
public class SettlementOrderRequest implements Serializable, Dto {

	private static final long serialVersionUID = 99421658643522944L;
	
	private String startPayedTime;
	
	private String endPayedTime;
	
	private String startCreateTime;
	
	private String endCreateTime;
	
	private String startUsedTime;
	
	private String endUsedTime;

	private SettlementOrderDto settlementOrderDto = new SettlementOrderDto();
	
	//结算列表list
	private List<Long> ids = new ArrayList<Long>();
	
	public SettlementOrderDto getSettlementOrderDto() {
		return settlementOrderDto;
	}

	public void setSettlementOrderDto(SettlementOrderDto settlementOrderDto) {
		this.settlementOrderDto = settlementOrderDto;
	}

	public String getSequence() {
		return settlementOrderDto.getSequence();
	}

	public Long getId() {
		return settlementOrderDto.getId();
	}

	public void setId(Long id) {
		settlementOrderDto.setId(id);
	}

	public String getUuid() {
		return settlementOrderDto.getUuid();
	}

	public void setUuid(String uuid) {
		settlementOrderDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return settlementOrderDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		settlementOrderDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return settlementOrderDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		settlementOrderDto.setUpdateTime(updateTime);
	}

	public String getSettlementOrderNo() {
		return settlementOrderDto.getSettlementOrderNo();
	}

	public void setSettlementOrderNo(String settlementOrderNo) {
		settlementOrderDto.setSettlementOrderNo(settlementOrderNo);
	}

	public BusinessType getMainBusinessType() {
		return settlementOrderDto.getMainBusinessType();
	}

	public void setMainBusinessType(BusinessType mainBusinessType) {
		settlementOrderDto.setMainBusinessType(mainBusinessType);
	}

	public String getMainBusinessId() {
		return settlementOrderDto.getMainBusinessId();
	}

	public void setMainBusinessId(String mainBusinessId) {
		settlementOrderDto.setMainBusinessId(mainBusinessId);
	}

	public String getMainBusinessNo() {
		return settlementOrderDto.getMainBusinessNo();
	}

	public void setMainBusinessNo(String mainBusinessNo) {
		settlementOrderDto.setMainBusinessNo(mainBusinessNo);
	}

	public BusinessType getBusinessType() {
		return settlementOrderDto.getBusinessType();
	}

	public void setBusinessType(BusinessType businessType) {
		settlementOrderDto.setBusinessType(businessType);
	}

	public String getBusinessId() {
		return settlementOrderDto.getBusinessId();
	}

	public void setBusinessId(String businessId) {
		settlementOrderDto.setBusinessId(businessId);
	}

	public String getBusinessNo() {
		return settlementOrderDto.getBusinessNo();
	}

	public void setBusinessNo(String businessNo) {
		settlementOrderDto.setBusinessNo(businessNo);
	}

	public String getBusinessStatus() {
		return settlementOrderDto.getBusinessStatus();
	}

	public void setBusinessStatus(String businessStatus) {
		settlementOrderDto.setBusinessStatus(businessStatus);
	}

	public String getBusinessPayStatus() {
		return settlementOrderDto.getBusinessPayStatus();
	}

	public void setBusinessPayStatus(String businessPayStatus) {
		settlementOrderDto.setBusinessPayStatus(businessPayStatus);
	}

	public Date getBusinessPayTime() {
		return settlementOrderDto.getBusinessPayTime();
	}

	public void setBusinessPayTime(Date businessPayTime) {
		settlementOrderDto.setBusinessPayTime(businessPayTime);
	}

	public Date getBusinessCreateTime() {
		return settlementOrderDto.getBusinessCreateTime();
	}

	public void setBusinessCreateTime(Date businessCreateTime) {
		settlementOrderDto.setBusinessCreateTime(businessCreateTime);
	}

	public String getBusinessContacter() {
		return settlementOrderDto.getBusinessContacter();
	}

	public void setBusinessContacter(String businessContacter) {
		settlementOrderDto.setBusinessContacter(businessContacter);
	}

	public Boolean getIsRefund() {
		return settlementOrderDto.getIsRefund();
	}

	public void setIsRefund(Boolean isRefund) {
		settlementOrderDto.setIsRefund(isRefund);
	}

	public String getRefundRemark() {
		return settlementOrderDto.getRefundRemark();
	}

	public void setRefundRemark(String refundRemark) {
		settlementOrderDto.setRefundRemark(refundRemark);
	}

	public String getBusinessDesc() {
		return settlementOrderDto.getBusinessDesc();
	}

	public void setBusinessDesc(String businessDesc) {
		settlementOrderDto.setBusinessDesc(businessDesc);
	}

	public BigDecimal getSalesPrice() {
		return settlementOrderDto.getSalesPrice();
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		settlementOrderDto.setSalesPrice(salesPrice);
	}

	public BigDecimal getSettlePrice() {
		return settlementOrderDto.getSettlePrice();
	}

	public void setSettlePrice(BigDecimal settlePrice) {
		settlementOrderDto.setSettlePrice(settlePrice);
	}

	public BigDecimal getTo3rdSettlePrice() {
		return settlementOrderDto.getTo3rdSettlePrice();
	}

	public void setTo3rdSettlePrice(BigDecimal to3rdSettlePrice) {
		settlementOrderDto.setTo3rdSettlePrice(to3rdSettlePrice);
	}

	public Long getBusinessSize() {
		return settlementOrderDto.getBusinessSize();
	}

	public void setBusinessSize(Long businessSize) {
		settlementOrderDto.setBusinessSize(businessSize);
	}

	public Date getUsedTime() {
		return settlementOrderDto.getUsedTime();
	}

	public void setUsedTime(Date usedTime) {
		settlementOrderDto.setUsedTime(usedTime);
	}

	public StatementStatus getStatementStatus() {
		return settlementOrderDto.getStatementStatus();
	}

	public void setStatementStatus(StatementStatus statementStatus) {
		settlementOrderDto.setStatementStatus(statementStatus);
	}

	public BigDecimal getRefundedAmount() {
		return settlementOrderDto.getRefundedAmount();
	}

	public void setRefundedAmount(BigDecimal refundedAmount) {
		settlementOrderDto.setRefundedAmount(refundedAmount);
	}

	public BigDecimal getTo3rdSettleAmount() {
		return settlementOrderDto.getTo3rdSettleAmount();
	}

	public void setTo3rdSettleAmount(BigDecimal to3rdSettleAmount) {
		settlementOrderDto.setTo3rdSettleAmount(to3rdSettleAmount);
	}

	public BigDecimal getTotalPayedAmount() {
		return settlementOrderDto.getTotalPayedAmount();
	}

	public void setTotalPayedAmount(BigDecimal totalPayedAmount) {
		settlementOrderDto.setTotalPayedAmount(totalPayedAmount);
	}

	public BigDecimal getTo3rdActualSettleAmount() {
		return settlementOrderDto.getTo3rdActualSettleAmount();
	}

	public void setTo3rdActualSettleAmount(BigDecimal to3rdActualSettleAmount) {
		settlementOrderDto.setTo3rdActualSettleAmount(to3rdActualSettleAmount);
	}

	public BigDecimal getPayedAmount() {
		return settlementOrderDto.getPayedAmount();
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		settlementOrderDto.setPayedAmount(payedAmount);
	}

	public String getBelongBU() {
		return settlementOrderDto.getBelongBU();
	}

	public void setBelongBU(String belongBU) {
		settlementOrderDto.setBelongBU(belongBU);
	}

	public String getSettlePeriod() {
		return settlementOrderDto.getSettlePeriod();
	}

	public void setSettlePeriod(String settlePeriod) {
		settlementOrderDto.setSettlePeriod(settlePeriod);
	}

	public String getSuppCode() {
		return settlementOrderDto.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		settlementOrderDto.setSuppCode(suppCode);
	}

	public OrderSettlementStatus getOrderSettlementStatus() {
		return settlementOrderDto.getOrderSettlementStatus();
	}

	public void setOrderSettlementStatus(
			OrderSettlementStatus orderSettlementStatus) {
		settlementOrderDto.setOrderSettlementStatus(orderSettlementStatus);
	}

	public String getStartPayedTime() {
		return startPayedTime;
	}

	public void setStartPayedTime(String startPayedTime) {
		this.startPayedTime = startPayedTime;
	}

	public String getEndPayedTime() {
		return endPayedTime;
	}

	public void setEndPayedTime(String endPayedTime) {
		this.endPayedTime = endPayedTime;
	}

	public String getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(String startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public String getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public String getStartUsedTime() {
		return startUsedTime;
	}

	public void setStartUsedTime(String startUsedTime) {
		this.startUsedTime = startUsedTime;
	}

	public String getEndUsedTime() {
		return endUsedTime;
	}

	public void setEndUsedTime(String endUsedTime) {
		this.endUsedTime = endUsedTime;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
