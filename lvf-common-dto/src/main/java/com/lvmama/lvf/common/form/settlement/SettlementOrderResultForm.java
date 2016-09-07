package com.lvmama.lvf.common.form.settlement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.StatementStatus;
import com.lvmama.lvf.common.dto.settlement.SettlementOrderDto;
import com.lvmama.lvf.common.dto.status.order.OrderSettlementStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;


/**
 * 结算列表resultForm
 * @author hedandan
 *
 */
public class SettlementOrderResultForm implements Serializable,Form{

	private static final long serialVersionUID = 9181766472026693408L;
	
	private String payedDate;
	
	private String createDate;
	
	private String usedDate;
	
	//结算状态
	private String settlementStatus;
	
	//结算单状态
	private String stateStatus;
	
	//订单状态
	private String orderStatus;
	
	//支付状态
	private String payStatus;
	
	private SettlementOrderDto settlementOrderDto;

	public SettlementOrderDto getSettlementOrderDto() {
		return settlementOrderDto;
	}

	public void setSettlementOrderDto(SettlementOrderDto settlementOrderDto) {
		this.settlementOrderDto = settlementOrderDto;
	}

	public PersistenceType getPtype() {
		return settlementOrderDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		settlementOrderDto.setPtype(ptype);
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

	public String getPayedDate() {
		if (null != this.settlementOrderDto && null != this.settlementOrderDto.getBusinessPayTime()) {
			this.payedDate = DateUtils.formatCnHmDate(this.settlementOrderDto.getBusinessPayTime());
		}
		return payedDate;
	}

	public void setPayedDate(String payedDate) {
		this.payedDate = payedDate;
	}

	public String getCreateDate() {
		if (null != this.settlementOrderDto && null != this.settlementOrderDto.getBusinessCreateTime()) {
			this.createDate = DateUtils.formatCnHmDate(this.settlementOrderDto.getBusinessCreateTime());
		}
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUsedDate() {
		if (null != this.settlementOrderDto && null != this.settlementOrderDto.getUsedTime()) {
			this.usedDate = DateUtils.formatCnHmDate(this.settlementOrderDto.getUsedTime());
		}
		return usedDate;
	}

	public void setUsedDate(String usedDate) {
		this.usedDate = usedDate;
	}

	public String getSettlementStatus() {
		if (null != this.settlementOrderDto && null != this.settlementOrderDto.getOrderSettlementStatus()) {
			this.settlementStatus = this.settlementOrderDto.getOrderSettlementStatus().getCnName();
		}
		return settlementStatus;
	}

	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public String getStateStatus() {
		if (null != this.settlementOrderDto && null != this.settlementOrderDto.getStatementStatus()) {
			this.stateStatus = this.settlementOrderDto.getStatementStatus().getCnName();
		}
		return stateStatus;
	}

	public void setStateStatus(String stateStatus) {
		this.stateStatus = stateStatus;
	}

	public String getOrderStatus() {
		if (null != this.settlementOrderDto && null != this.settlementOrderDto.getBusinessStatus()) {
			if ("NORMAL".equals(this.settlementOrderDto.getBusinessStatus())) {
				this.orderStatus = "正常";
			}else if ("DONE".equals(this.settlementOrderDto.getBusinessStatus())) {
				this.orderStatus = "完成";
			}else {
				this.orderStatus = "取消";
			}
		}
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPayStatus() {
		if (null != this.settlementOrderDto && null != this.settlementOrderDto.getBusinessPayStatus()) {
			if ("NOT_PAY".equals(this.settlementOrderDto.getBusinessPayStatus())) {
				this.payStatus = "待支付";
			}else if ("PAY_TIMEOUT".equals(this.settlementOrderDto.getBusinessPayStatus())) {
				this.payStatus = "超时未支付";
			}else if ("PAY_SUCC".equals(this.settlementOrderDto.getBusinessPayStatus())) {
				this.payStatus = "支付成功";
			}else if ("PAY_FAIL".equals(this.settlementOrderDto.getBusinessPayStatus())) {
				this.payStatus = "支付失败";
			}else if ("NOT_REFUND".equals(this.settlementOrderDto.getBusinessPayStatus())) {
				this.payStatus = "未退款";
			}else if ("APPLY_REFUND".equals(this.settlementOrderDto.getBusinessPayStatus())) {
				this.payStatus = "申请退款";
			}else if ("REFUND_REJECT".equals(this.settlementOrderDto.getBusinessPayStatus())) {
				this.payStatus = "退款驳回";
			}else if ("REFUND_SUCC".equals(this.settlementOrderDto.getBusinessPayStatus())) {
				this.payStatus = "退款成功";
			}else if ("REFUND_FAIL".equals(this.settlementOrderDto.getBusinessPayStatus())) {
				this.payStatus = "退款失败";
			}else {
				this.payStatus = "";
			}
		}
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	
}
