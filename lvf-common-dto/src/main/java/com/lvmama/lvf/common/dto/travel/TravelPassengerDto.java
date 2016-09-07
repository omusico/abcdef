package com.lvmama.lvf.common.dto.travel;

import java.util.Date;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.utils.DateUtils;

public class TravelPassengerDto extends AEEntity{
	
	private static final long serialVersionUID = 1L;
	
	//乘机人姓名
	private String passengerName;
	//乘机人类型
	private String passengerType;
	//乘机人证件类型
	private String passengerIdCardType;
	//乘机人证件号码
	private String passengerIdCardNo;
	//性别
	private String gender;
	//生日
	private Date passengerBirthday;
	//电话
	private String passengerTelphone;
	//手机
	private String passengerCellphone;
	//所属公司
	private TravelCompanyInfoDto company;
	//所属公司ID
	private Long companyId;
	//工作
	private String job;
	//备注
	private String remark;
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	public String getPassengerIdCardType() {
		return passengerIdCardType;
	}
	public void setPassengerIdCardType(String passengerIdCardType) {
		this.passengerIdCardType = passengerIdCardType;
	}
	public String getPassengerIdCardNo() {
		return passengerIdCardNo;
	}
	public void setPassengerIdCardNo(String passengerIdCardNo) {
		this.passengerIdCardNo = passengerIdCardNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getPassengerBirthday() {
		return passengerBirthday;
	}
	public void setPassengerBirthday(Date passengerBirthday) {
		this.passengerBirthday = passengerBirthday;
	}
	public String getPassengerTelphone() {
		return passengerTelphone;
	}
	public void setPassengerTelphone(String passengerTelphone) {
		this.passengerTelphone = passengerTelphone;
	}
	public String getPassengerCellphone() {
		return passengerCellphone;
	}
	public void setPassengerCellphone(String passengerCellphone) {
		this.passengerCellphone = passengerCellphone;
	}
	public TravelCompanyInfoDto getCompany() {
		return company;
	}
	public void setCompany(TravelCompanyInfoDto company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getBirthdayStr() {
		if(getPassengerBirthday() != null)
			return DateUtils.formatDate(getPassengerBirthday(), DateUtils.YYYY_MM_DD);
		return null;
	}
	
}
