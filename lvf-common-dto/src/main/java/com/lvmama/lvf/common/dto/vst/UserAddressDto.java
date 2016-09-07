package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 登录用户的收货人地址
 * @author zhoubinbin
 *
 */
public class UserAddressDto implements Serializable {
	
	private static final long serialVersionUID = 16553515303019121L;
	
	private Long addressId;
	private String userNo;
	private String addressNo;				
	private String mobileNumber;		//手机号码
	private String areacode;			//区号
	private String phoneNumber;		//电话号码
	private String userName;			//收货人
	private String province;			//省
	private String city;				//市
	private String county;				//区
	private String address;			    //地址
	private String postCode;			//邮编
	private String isValid;				//是否有效
	private Date createDate;			//
	private Date updateDate;			//
	private Long provinceId;			//省份ID
	private Long cityId;				//市ID
	private Long countyId;				//区ID
	
	public Long getAddressId() {
		return addressId;
	}
	public String getUserNo() {
		return userNo;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getAreacode() {
		return areacode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getCounty() {
		return county;
	}
	public String getAddress() {
		return address;
	}
	public String getPostCode() {
		return postCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = StringUtils.isNotBlank(mobileNumber)?mobileNumber:"";
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = StringUtils.isNotBlank(phoneNumber)?phoneNumber:"";
	}
	public void setUserName(String userName) {
		this.userName = StringUtils.isNotBlank(userName)?userName:"";
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getAddressNo() {
		return addressNo;
	}
	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}
	public Long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public Long getCountyId() {
		return countyId;
	}
	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}
}
