package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.Gender;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.enums.PassengerType;

/**
 * 乘客信息
 * 
 * @author majun
 * @date 2015-1-13
 */
public class FlightOrderPassengerDto extends Entity implements Serializable {

	private static final long serialVersionUID = 2033465695382456177L;

	/** 主订单主键 */
	private Long orderMainId;

	/** 乘客姓名 */
	private String passengerName;

	/** 乘客类型 */
	private PassengerType passengerType;

	/** 乘客性别 */
	private Gender gender;

	/** 证件类型 */
	private IDCardType passengerIDCardType;

	/** 证件号码 */
	private String passengerIDCardNo;

	/** 生日 */
	private Date passengerBirthday;

	/** 手机号码 */
	private String cellphone;

	/** 电话 */
	private String telphone;

	/** 保险信息 */
	private List<FlightOrderInsuranceDto> flightOrderInsurances =new ArrayList<FlightOrderInsuranceDto>();
	
	/** H5对应票detailId */
	private Long detailId;
	
	/** 转换名   当姓名中存在生僻字，将转换后的姓名存入“转换名”；若姓名中不存在生僻字，直接将原姓名存入“转换名” */
	private String changedName;
	
	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
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

	public List<FlightOrderInsuranceDto> getFlightOrderInsurances() {
		return flightOrderInsurances;
	}

	public void setFlightOrderInsurances(
			List<FlightOrderInsuranceDto> flightOrderInsurances) {
		this.flightOrderInsurances = flightOrderInsurances;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	/**
	 * @return  the changedName
	 */
	public String getChangedName() {
		if(StringUtils.isNotEmpty(changedName)){
			return changedName;
		}
		return this.getPassengerName();
	}

	/**
	 * @param changedName the changedName to set
	 */
	public void setChangedName(String changedName) {
		this.changedName = changedName;
	}


}
