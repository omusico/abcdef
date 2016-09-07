package com.lvmama.lvf.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.order.status.GenerateStatus;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 导入订单
 * @author qihuisong
 */
public class FlightOrderImportDto extends Entity implements Serializable {

	private static final long serialVersionUID = -6199871469066518977L;

	/** 上传记录ID **/
	private Long recordId;
	/** 订单ID **/
	private Long orderId;
	/** 订单号 **/
	private String orderNo;
	/** PNR **/
	private String pnr;
	/** 票面价 **/
	private BigDecimal ticketAmount;
	/** 机建费 **/
	private BigDecimal airportTaxAmount;
	/** 燃油费 **/
	private BigDecimal fuelTaxAmount;
	/** 销售价 **/
	private BigDecimal saleAmount;
	/** 结算价 **/
	private BigDecimal settleAmount;
	/** 供应商Code **/
	private String suppCode;
	/** 联系人姓名 **/
	private String contactName;
	/** 联系人手机 **/
	private String contactCellphone;
	/** 航延险销售价 **/
	private BigDecimal dalayInsuranceAmount;
	/** 航延险供应商 **/
	private String dalayInsuranceSupp;
	/** 航延险code **/
	private String dalayInsuranceCode;
	/** 航意险销售价 **/
	private BigDecimal accidentInsuranceAmount;
	/** 航意险供应商 **/
	private String accidentInsuranceSupp;
	/** 航意险code **/
	private String accidentInsuranceCode;
	/** 邮寄地址 **/
	private String expressAddress;
	/** 收件人 **/
	private String expressRecipient;
	/** 收件人手机号码 **/
	private String expressTelephone;
	/** 邮寄费 **/
	private BigDecimal expressAmount;
	/** 状态 **/
	private GenerateStatus status;
	/** 操作账号 **/
	private String accountName;
	/** 公司名称 **/
	private String companyName;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public BigDecimal getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(BigDecimal ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	public BigDecimal getAirportTaxAmount() {
		return airportTaxAmount;
	}

	public void setAirportTaxAmount(BigDecimal airportTaxAmount) {
		this.airportTaxAmount = airportTaxAmount;
	}

	public BigDecimal getFuelTaxAmount() {
		return fuelTaxAmount;
	}

	public void setFuelTaxAmount(BigDecimal fuelTaxAmount) {
		this.fuelTaxAmount = fuelTaxAmount;
	}

	public BigDecimal getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

	public BigDecimal getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(BigDecimal settleAmount) {
		this.settleAmount = settleAmount;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactCellphone() {
		return contactCellphone;
	}

	public void setContactCellphone(String contactCellphone) {
		this.contactCellphone = contactCellphone;
	}

	public BigDecimal getDalayInsuranceAmount() {
		return dalayInsuranceAmount;
	}

	public void setDalayInsuranceAmount(BigDecimal dalayInsuranceAmount) {
		this.dalayInsuranceAmount = dalayInsuranceAmount;
	}

	public String getDalayInsuranceSupp() {
		return dalayInsuranceSupp;
	}

	public void setDalayInsuranceSupp(String dalayInsuranceSupp) {
		this.dalayInsuranceSupp = dalayInsuranceSupp;
	}

	public String getDalayInsuranceCode() {
		return dalayInsuranceCode;
	}

	public void setDalayInsuranceCode(String dalayInsuranceCode) {
		this.dalayInsuranceCode = dalayInsuranceCode;
	}

	public BigDecimal getAccidentInsuranceAmount() {
		return accidentInsuranceAmount;
	}

	public void setAccidentInsuranceAmount(BigDecimal accidentInsuranceAmount) {
		this.accidentInsuranceAmount = accidentInsuranceAmount;
	}

	public String getAccidentInsuranceSupp() {
		return accidentInsuranceSupp;
	}

	public void setAccidentInsuranceSupp(String accidentInsuranceSupp) {
		this.accidentInsuranceSupp = accidentInsuranceSupp;
	}

	public String getAccidentInsuranceCode() {
		return accidentInsuranceCode;
	}

	public void setAccidentInsuranceCode(String accidentInsuranceCode) {
		this.accidentInsuranceCode = accidentInsuranceCode;
	}

	public String getExpressAddress() {
		return expressAddress;
	}

	public void setExpressAddress(String expressAddress) {
		this.expressAddress = expressAddress;
	}

	public String getExpressRecipient() {
		return expressRecipient;
	}

	public void setExpressRecipient(String expressRecipient) {
		this.expressRecipient = expressRecipient;
	}

	public String getExpressTelephone() {
		return expressTelephone;
	}

	public void setExpressTelephone(String expressTelephone) {
		this.expressTelephone = expressTelephone;
	}

	public BigDecimal getExpressAmount() {
		return expressAmount;
	}

	public void setExpressAmount(BigDecimal expressAmount) {
		this.expressAmount = expressAmount;
	}

	public GenerateStatus getStatus() {
		return status;
	}

	public void setStatus(GenerateStatus status) {
		this.status = status;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
