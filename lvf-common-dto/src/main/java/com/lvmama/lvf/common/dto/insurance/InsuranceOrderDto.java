package com.lvmama.lvf.common.dto.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.Gender;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.enums.InsuranceStatus;

/**
 * 订单保险信息
 * @author lven
 *
 */
public class InsuranceOrderDto extends Entity implements Serializable {
	
	private static final long serialVersionUID = -5443145211166313773L;
	
	/** 保单号:投保后接口返回*/
	private String insuranceNo;
	
	/** 保险订单号:本地生成*/
	private String insuranceOrderNo;

	/**子订单Id*/
	private Long orderId;
	
	/**子订单号*/
	private String orderNo;
	
	/**票号*/
	private String ticketNo;
	 
	/**航班号*/
	private String flightNo;
	
	/**投保份数*/
	private Integer insuredNum = 1;
	
	/**结算价*/
	private BigDecimal settleAccounts;
	
	/**投保状态*/
	private InsuranceStatus insuranceStatus;
	
	/**生效时间，航班起飞时间*/
    private Date effectDate;
	
	/**过期时间*/
    private Date expireDate;
	
	/**投保时间*/
    private Date insureDate=new Date();
    
    /**废保时间*/
    private Date hesitateDate;
    
	/**投/被保人姓名*/
	private String insuredName;
	
	/**性别*/
	private Gender gender;
	
	/**证件类型*/
	private IDCardType idCardType;
	
	/**证件号码*/
	private String idCardNo;
	
	/**出生日期*/
	private Date  birthday;//19900202
	
	/** 邮箱 */
	private String email;
	
	/** 手机号码 */
	private String cellphone;
	
	/** 产品编码*/
	private String insuranceCode;
	
	/** 供应商返回orderId*/
	private String suppOrderId;
	
	/** 供应商投保单Id*/
	private String suppApplicationId;
	
	/**Fk*/
	@FkId
	private InsuranceInfoDto insuranceInfoDto;
	/**保险供应商*/
	private String insSuppCode;
	
	public InsuranceOrderDto() {
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Date getInsureDate() {
		return insureDate;
	}

	public void setInsureDate(Date insureDate) {
		this.insureDate = insureDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public InsuranceStatus getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(InsuranceStatus insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public InsuranceInfoDto getInsuranceInfoDto() {
		return insuranceInfoDto;
	}

	public void setInsuranceInfoDto(InsuranceInfoDto insuranceInfoDto) {
		this.insuranceInfoDto = insuranceInfoDto;
	}



	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public IDCardType getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(IDCardType idCardType) {
		this.idCardType = idCardType;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getInsuranceOrderNo() {
		return insuranceOrderNo;
	}

	public void setInsuranceOrderNo(String insuranceOrderNo) {
		this.insuranceOrderNo = insuranceOrderNo;
	}

	public Integer getInsuredNum() {
		return insuredNum;
	}

	public void setInsuredNum(Integer insuredNum) {
		this.insuredNum = insuredNum;
	}

	public BigDecimal getSettleAccounts() {
		return settleAccounts;
	}

	public void setSettleAccounts(BigDecimal settleAccounts) {
		this.settleAccounts = settleAccounts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Date getHesitateDate() {
		return hesitateDate;
	}

	public void setHesitateDate(Date hesitateDate) {
		this.hesitateDate = hesitateDate;
	}

	public String getInsuranceCode() {
		return insuranceCode;
	}

	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}

	public String getSuppOrderId() {
		return suppOrderId;
	}

	public void setSuppOrderId(String suppOrderId) {
		this.suppOrderId = suppOrderId;
	}

	public String getSuppApplicationId() {
		return suppApplicationId;
	}

	public void setSuppApplicationId(String suppApplicationId) {
		this.suppApplicationId = suppApplicationId;
	}

	public String getInsSuppCode() {
		return insSuppCode;
	}

	public void setInsSuppCode(String insSuppCode) {
		this.insSuppCode = insSuppCode;
	}
}
