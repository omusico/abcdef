package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.ConfirmType;
import com.lvmama.lvf.common.dto.enums.Gender;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.enums.PassengerType;

/**
 * 供应商订单乘机人信息
 * @author majun
 * @date   2015-2-4
 */public class FlightOrderSuppOrderPassengerDto extends Entity implements Serializable
{
	private static final long serialVersionUID = 335654385779790644L;
	
	/** 供应商订单主键 */
	private Long suppOrderId;
	
	/** 乘客姓名 */
	private String passengerName;
	
	/** 乘客类型*/
	private PassengerType passengerType;
	
	/** 证件类型 */
	private IDCardType passengerIDCardType;
	
	/** 证件号码 */
	private String passengerIDCardNo;
	
	/** 生日 */
	private Date passengerBirthday;
	
	/** 乘客性别 */
	private Gender gender;
	
	/** 确认类型 */
	private ConfirmType confirmType;
	
	/** 手机号码 */
	private String cellphone;
	
	/** 携程证件类型 */
	private String psgIDCardType;

	public Long getSuppOrderId() {
		return suppOrderId;
	}

	public void setSuppOrderId(Long suppOrderId) {
		this.suppOrderId = suppOrderId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public IDCardType getPassengerIDCardType() {
		return passengerIDCardType;
	}

	public void setPassengerIDCardType(IDCardType passengerIDCardType) {
		this.passengerIDCardType = passengerIDCardType;
	}

	public String getPassengerIDCardNo() {
		return passengerIDCardNo;
	}

	public void setPassengerIDCardNo(String passengerIDCardNo) {
		this.passengerIDCardNo = passengerIDCardNo;
	}

	public Date getPassengerBirthday() {
		return passengerBirthday;
	}

	public void setPassengerBirthday(Date passengerBirthday) {
		this.passengerBirthday = passengerBirthday;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ConfirmType getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(ConfirmType confirmType) {
		this.confirmType = confirmType;
	}

	public void copyFromDto(FlightOrderSuppOrderPassengerDto passengerRequest){
		this.setPassengerBirthday(passengerRequest.getPassengerBirthday());
		this.setPassengerIDCardNo(passengerRequest.getPassengerIDCardNo());
		this.setPassengerIDCardType(passengerRequest.getPassengerIDCardType());
		this.setPassengerName(passengerRequest.getPassengerName());
		this.setPassengerType(passengerRequest.getPassengerType());
		this.setSuppOrderId(passengerRequest.getSuppOrderId());
		this.setUpdateTime(new Date());
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPsgIDCardType() {
		return psgIDCardType;
	}

	public void setPsgIDCardType(String psgIDCardType) {
		this.psgIDCardType = psgIDCardType;
	}
}
