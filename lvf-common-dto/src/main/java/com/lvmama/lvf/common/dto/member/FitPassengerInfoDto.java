/**
 * Project Name:lvfit-common-dto
 * File Name:FitPassengerInfoDto.java
 * Package Name:com.lvmama.lvfit.common.dto.member
 * Date:2015-12-10下午10:17:37
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvf.common.dto.member;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:FitPassengerInfoDto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-10 下午10:17:37 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class FitPassengerInfoDto implements Serializable {
	private static final long serialVersionUID = 2033465695382456177L;
	/** 联系人编号 */
	private String receiverId;
	/** 联系人姓名 */
	private String receiverName;
	/** 姓（英文或拼音） */
	private String lastName;
	/** 名（英文或拼音） */
	private String firstName;
	/** 证件类型 */
	private String certType;
	/** 证件号码 */
	private String certNo;
	/** 电子邮箱 */
	private String email;
	/** 性别 */
	private String receiverGender;
	/** 手机号码 */
	private String mobileNumber;
	/** 生日 */
	private Date birthday;
	/** 旅客类型ADULT ("成人")，CHILD ("儿童") */
	private String peopleType;

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReceiverGender() {
		return receiverGender;
	}

	public void setReceiverGender(String receiverGender) {
		this.receiverGender = receiverGender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPeopleType() {
		return peopleType;
	}

	public void setPeopleType(String peopleType) {
		this.peopleType = peopleType;
	}


}
