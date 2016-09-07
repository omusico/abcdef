package com.lvmama.lvf.common.dto.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.InsuranceStatus;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.utils.DateUtils;

public class InsuranceOrderListDto extends Entity implements Serializable {

	private static final long serialVersionUID = 4490358113871305893L;

	/** 保单号:投保后接口返回*/
	private String insuranceNo;
	
	private Long insuranceOrderId;
	
	private String orderId;
	
	/**子订单号*/
	private String orderNo;
	
	/**票号*/
	private String ticketNo;
	 
	/**投保状态*/
	private InsuranceStatus insuranceStatus;
	
	/**生效时间，航班起飞时间*/
    private Date effectDate;
	
	/**投保时间*/
    private Date insureDate;
    
    /**废保时间*/
    private Date hesitateDate;
    
	/**投/被保人姓名*/
	private String insuredName;
	
	/**证件号码*/
	private String idCardNo;
	
	/**产品名称*/
	private String insuranceClassName;
	
	/**供应商名称*/
	private String suppName;
	
	/**订单保险状态*/
	private Status status;
	
	/**是否关联（insuranceorder与orderinsurance之间的关联）*/
	private String isRelated;
	
	/** 销售价格*/
	private BigDecimal insurePrice;
	
	/**适用产品类型*/
	private String productTypes;

	public BigDecimal getInsurePrice() {
		return insurePrice;
	}

	public void setInsurePrice(BigDecimal insurePrice) {
		this.insurePrice = insurePrice;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public Long getInsuranceOrderId() {
		return insuranceOrderId;
	}

	public void setInsuranceOrderId(Long insuranceOrderId) {
		this.insuranceOrderId = insuranceOrderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public InsuranceStatus getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(InsuranceStatus insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public Date getInsureDate() {
		return insureDate;
	}

	public void setInsureDate(Date insureDate) {
		this.insureDate = insureDate;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getInsuranceClassName() {
		return insuranceClassName;
	}

	public void setInsuranceClassName(String insuranceClassName) {
		this.insuranceClassName = insuranceClassName;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Date getHesitateDate() {
		return hesitateDate;
	}

	public void setHesitateDate(Date hesitateDate) {
		this.hesitateDate = hesitateDate;
	}

	public String getIsRelated() {
		return isRelated;
	}

	public void setIsRelated(String isRelated) {
		this.isRelated = isRelated;
	}

	public String getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(String productTypes) {
		this.productTypes = productTypes;
	}
	
	/**
	 * 构造订单列表String
	 * @return
	 */
	public String constructInsOrderListStr(){
		StringBuffer InsOrderListStr = new StringBuffer();
		InsOrderListStr.append(this.getOrderNo()).append(",");
		if (null != this.getTicketNo()) {
			InsOrderListStr.append(this.getTicketNo()).append(",");
		}else {
			InsOrderListStr.append("").append(",");
		}
		if (null != this.getInsuranceNo()) {
			InsOrderListStr.append(this.getInsuranceNo()).append(",");
		}else {
			InsOrderListStr.append("").append(",");
		}
		InsOrderListStr.append(this.getInsuranceClassName()).append(",");
		InsOrderListStr.append(code2Name(this.getProductTypes())).append(",");
		InsOrderListStr.append(this.getSuppName()).append(",");
		InsOrderListStr.append(this.getInsuredName()).append(",");
		InsOrderListStr.append(this.getIdCardNo()).append(",");
		InsOrderListStr.append(DateUtils.formatDate(this.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS)).append(",");
		if (null != this.getInsureDate()) {
			InsOrderListStr.append(DateUtils.formatDate(this.getInsureDate(), DateUtils.YYYY_MM_DD_HH_MM_SS)).append(",");
		}else {
			InsOrderListStr.append("").append(",");
		}
		InsOrderListStr.append(DateUtils.formatDate(this.getEffectDate(), DateUtils.YYYY_MM_DD_HH_MM_SS)).append(",");
		if (null != this.getHesitateDate()) {
			InsOrderListStr.append(DateUtils.formatDate(this.getHesitateDate(), DateUtils.YYYY_MM_DD_HH_MM_SS)).append(",");
		}else {
			InsOrderListStr.append("").append(",");
		}
		InsOrderListStr.append(this.getStatus().getCnName()).append(",");
		InsOrderListStr.append(this.getInsuranceStatus().getCnName());
		
		return InsOrderListStr.toString();
	}

	private String code2Name(String productTypes){
		String productNameStr = "";
		String productStr = "";
		if (null != productTypes) {
			String [] productStrArr = productTypes.split(",");
			for (int i = 0; i < productStrArr.length; i++) {
				productNameStr = Product.valueOf(productStrArr[i]).getCnName();
				if (i==0) {
					productStr = productNameStr;
				}else {
					productStr = productStr + " , " + productNameStr;
				}
				
			}
		}
		return productStr;
	}
	
}
