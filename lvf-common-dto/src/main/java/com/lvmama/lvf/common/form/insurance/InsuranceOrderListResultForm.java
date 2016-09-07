package com.lvmama.lvf.common.form.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.InsuranceStatus;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderListDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 保单列表信息
 * 
 */
public class InsuranceOrderListResultForm implements Serializable, Form {

	private static final long serialVersionUID = 8453181192819829068L;
	
	private InsuranceOrderListDto insuranceOrderListDto;
	
	private String insuranceType;
	
	private String insureTime;
	
	private String effectTime;
	
	private String hesitateTime;
	
	private String createDate;
	
	private String orderStatus;
	
	private String productStr;
	
	public BigDecimal getInsurePrice() {
		return insuranceOrderListDto.getInsurePrice();
	}

	public void setInsurePrice(BigDecimal insurePrice) {
		insuranceOrderListDto.setInsurePrice(insurePrice);
	}

	private String insuranceStatusName;
	
	public InsuranceOrderListDto getInsuranceOrderListDto() {
		return insuranceOrderListDto;
	}

	public void setInsuranceOrderListDto(InsuranceOrderListDto insuranceOrderListDto) {
		this.insuranceOrderListDto = insuranceOrderListDto;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public String getIsRelated() {
		return insuranceOrderListDto.getIsRelated();
	}

	public void setIsRelated(String isRelated) {
		insuranceOrderListDto.setIsRelated(isRelated);
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	
	public String getInsureTime() {
		if (null != insuranceOrderListDto && null != insuranceOrderListDto.getInsureDate()) {
			this.insureTime =  DateUtils.formatCnHmDate(insuranceOrderListDto.getInsureDate());
		}
		return insureTime;
	}

	public void setInsureTime(String insureTime) {
		this.insureTime = insureTime;
	}

	public String getEffectTime() {
		if (null != insuranceOrderListDto && null != insuranceOrderListDto.getEffectDate()) {
			this.effectTime =  DateUtils.formatCnHmDate(insuranceOrderListDto.getEffectDate());
		}
		return effectTime;
	}

	public void setEffectTime(String effectTime) {
		this.effectTime = effectTime;
	}

	public PersistenceType getPtype() {
		return insuranceOrderListDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		insuranceOrderListDto.setPtype(ptype);
	}

	public String getSequence() {
		return insuranceOrderListDto.getSequence();
	}

	public Long getId() {
		return insuranceOrderListDto.getId();
	}

	public void setId(Long id) {
		insuranceOrderListDto.setId(id);
	}

	public String getUuid() {
		return insuranceOrderListDto.getUuid();
	}

	public void setUuid(String uuid) {
		insuranceOrderListDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return insuranceOrderListDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		insuranceOrderListDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return insuranceOrderListDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		insuranceOrderListDto.setUpdateTime(updateTime);
	}

	public String getInsuranceNo() {
		return insuranceOrderListDto.getInsuranceNo();
	}

	public void setInsuranceNo(String insuranceNo) {
		insuranceOrderListDto.setInsuranceNo(insuranceNo);
	}

	public String getOrderNo() {
		return insuranceOrderListDto.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		insuranceOrderListDto.setOrderNo(orderNo);
	}

	public String getTicketNo() {
		return insuranceOrderListDto.getTicketNo();
	}

	public void setTicketNo(String ticketNo) {
		insuranceOrderListDto.setTicketNo(ticketNo);
	}

	public InsuranceStatus getInsuranceStatus() {
		return insuranceOrderListDto.getInsuranceStatus();
	}

	public void setInsuranceStatus(InsuranceStatus insuranceStatus) {
		insuranceOrderListDto.setInsuranceStatus(insuranceStatus);
	}

	public Date getEffectDate() {
		return insuranceOrderListDto.getEffectDate();
	}

	public void setEffectDate(Date effectDate) {
		insuranceOrderListDto.setEffectDate(effectDate);
	}

	public Date getInsureDate() {
		return insuranceOrderListDto.getInsureDate();
	}

	public void setInsureDate(Date insureDate) {
		insuranceOrderListDto.setInsureDate(insureDate);
	}

	public String getInsuredName() {
		return insuranceOrderListDto.getInsuredName();
	}

	public void setInsuredName(String insuredName) {
		insuranceOrderListDto.setInsuredName(insuredName);
	}

	public String getIdCardNo() {
		return insuranceOrderListDto.getIdCardNo();
	}

	public void setIdCardNo(String idCardNo) {
		insuranceOrderListDto.setIdCardNo(idCardNo);
	}

	public String getInsuranceClassName() {
		return insuranceOrderListDto.getInsuranceClassName();
	}

	public void setInsuranceClassName(String insuranceClassName) {
		insuranceOrderListDto.setInsuranceClassName(insuranceClassName);
	}

	public String getSuppName() {
		return insuranceOrderListDto.getSuppName();
	}

	public void setSuppName(String suppName) {
		insuranceOrderListDto.setSuppName(suppName);
	}

	public String getOrderId() {
		return insuranceOrderListDto.getOrderId();
	}

	public void setOrderId(String orderId) {
		insuranceOrderListDto.setOrderId(orderId);
	}

	public Long getInsuranceOrderId() {
		return insuranceOrderListDto.getInsuranceOrderId();
	}

	public void setInsuranceOrderId(Long insuranceOrderId) {
		insuranceOrderListDto.setInsuranceOrderId(insuranceOrderId);
	}

	public Status getStatus() {
		return insuranceOrderListDto.getStatus();
	}

	public void setStatus(Status status) {
		insuranceOrderListDto.setStatus(status);
	}

	public String getCreateDate() {
		if (null != insuranceOrderListDto && null != insuranceOrderListDto.getCreateTime()) {
			this.createDate =  DateUtils.formatCnHmDate(insuranceOrderListDto.getCreateTime());
		}
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getOrderStatus() {
		if (null != insuranceOrderListDto && null != insuranceOrderListDto.getStatus()) {
			if (Status.VALID.equals(insuranceOrderListDto.getStatus())) {
				orderStatus = "有效";
			}else {
				orderStatus = "无效";
			}
		}
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getHesitateDate() {
		return insuranceOrderListDto.getHesitateDate();
	}

	public void setHesitateDate(Date hesitateDate) {
		insuranceOrderListDto.setHesitateDate(hesitateDate);
	}

	public String getHesitateTime() {
		if (null != insuranceOrderListDto && null != insuranceOrderListDto.getHesitateDate()) {
			this.hesitateTime =  DateUtils.formatCnHmDate(insuranceOrderListDto.getHesitateDate());
		}
		return hesitateTime;
	}

	public void setHesitateTime(String hesitateTime) {
		this.hesitateTime = hesitateTime;
	}

	public String getInsuranceStatusName() {
		if (null != insuranceOrderListDto && null != insuranceOrderListDto.getInsuranceStatus()) {
			this.insuranceStatusName =  insuranceOrderListDto.getInsuranceStatus().getCnName();
		}
		return insuranceStatusName;
	}

	public void setInsuranceStatusName(String insuranceStatusName) {
		this.insuranceStatusName = insuranceStatusName;
	}
	public String getProductStr() {
		String productNameStr = "";
		if (null != this.insuranceOrderListDto && null != this.insuranceOrderListDto.getProductTypes()) {
			String [] productStr = this.insuranceOrderListDto.getProductTypes().split(",");
			for (int i = 0; i < productStr.length; i++) {
				productNameStr = Product.valueOf(productStr[i]).getCnName();
				if (i==0) {
					this.productStr = productNameStr;
				}else {
					this.productStr = this.productStr + " , " + productNameStr;
				}
				
			}
		}
		return productStr;
	}

	public void setProductStr(String productStr) {
		this.productStr = productStr;
	}

	public String getProductTypes() {
		return insuranceOrderListDto.getProductTypes();
	}

	public void setProductTypes(String productTypes) {
		insuranceOrderListDto.setProductTypes(productTypes);
	}

}

