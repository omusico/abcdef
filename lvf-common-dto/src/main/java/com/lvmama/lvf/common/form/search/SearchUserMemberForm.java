package com.lvmama.lvf.common.form.search;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.form.Form;

/**
 * 用户会员信息
 * @author zzs
 *
 */
public class SearchUserMemberForm implements Serializable, Form {

	private static final long serialVersionUID = -3809963706837761747L;
	
	private Long userId;//用户id
	private String userNo;//用户编号
    private String userName;//用户名称
    private String userPassword;//用户密码
    private String mobileNumber;//手机号码
    private String email;//邮箱
    private String phoneNumber;//电话号码
    private String memberShipCard;	//会员卡卡号
	private Date activeMscardDate;	//会员卡绑定时间
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMemberShipCard() {
		return memberShipCard;
	}
	public void setMemberShipCard(String memberShipCard) {
		this.memberShipCard = memberShipCard;
	}
	public Date getActiveMscardDate() {
		return activeMscardDate;
	}
	public void setActiveMscardDate(Date activeMscardDate) {
		this.activeMscardDate = activeMscardDate;
	}

}
