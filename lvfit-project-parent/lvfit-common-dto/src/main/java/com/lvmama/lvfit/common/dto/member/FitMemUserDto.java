/**
 * Project Name:lvfit-common-dto
 * File Name:FitMemUserDto.java
 * Package Name:com.lvmama.lvfit.common.dto.vst
 * Date:2015-12-8下午2:29:58
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.member;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvfit.common.dto.enums.UserMemberGrade;
import com.lvmama.lvfit.common.dto.enums.UserMemberType;

/**
 * ClassName:FitMemUserDto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-8 下午2:29:58 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class FitMemUserDto implements Serializable{

	/**
	 * serialVersionUID.
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 8290356086399689311L;
	private Long userId;
	private String userNo;
    private String userName;
    private String userPassword;
    private String mobileNumber;
    private String email;
    private String phoneNumber;
    private String memberShipCard;	//会员卡卡号
	private Date activeMscardDate;	//会员卡绑定时间
    
    
    private String nickName;
    private String groupId;
    private String cityId;
    private String passwordPrompt;
    private String passwordAnswer;
    private String realName;
    private String address;
    private String isLocked;
    private Date createdDate;
    private Date updatedDate;
    private String isValid;
    private String gender;
    private String idNumber;
    private Long point;

    private String memo;
    private Date birthday;
    private String qqAccount;
    private String msnAccount;
    private String imageUrl;
    private String spaceUrl;
    private String registStepId;
    private String isEmailChecked;
    private String realPass;
    private String cardId;
    private String isAcceptEdm;
    private String isMobileChecked;
    private String zipCode;
    
    private String homeCity;
    private Long awardBalance;
    private Long withdraw;
    private String channel;
    private String grade = UserMemberGrade.NORMAL.name(); //会员等级  
    protected Date levelValidityDate;//会员等级有效期
    private Date lastLoginDate;
    
    private String nameIsUpdate;//登录用户名是否更新过
    protected Long cashBalance;//现金账户
    protected Long bonusBalance;//奖金余额
    protected String cancellationReason;//注销原因
    
    private String registerIp;//这个属性暂时用于存user action collection LOG
    private Long registerPort;//用户注册源端口号用于存user action collection LOG
    protected String wechatId;//微信id
    protected String subScribe;
    private boolean cashFrozen = false;
    //是否保存信用卡信息
    private String saveCreditCard;
    protected String loginType;
    private String userType = UserMemberType.DEFAULT.getCnName();//用户类型
    private String userTypeTest;
    private String isZJ;//判断该用户是否是自驾游用户
    
    private String userStatus;  //用户当前状态 
    
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getPasswordPrompt() {
		return passwordPrompt;
	}
	public void setPasswordPrompt(String passwordPrompt) {
		this.passwordPrompt = passwordPrompt;
	}
	public String getPasswordAnswer() {
		return passwordAnswer;
	}
	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Long getPoint() {
		return point;
	}
	public void setPoint(Long point) {
		this.point = point;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getQqAccount() {
		return qqAccount;
	}
	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}
	public String getMsnAccount() {
		return msnAccount;
	}
	public void setMsnAccount(String msnAccount) {
		this.msnAccount = msnAccount;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getSpaceUrl() {
		return spaceUrl;
	}
	public void setSpaceUrl(String spaceUrl) {
		this.spaceUrl = spaceUrl;
	}
	public String getRegistStepId() {
		return registStepId;
	}
	public void setRegistStepId(String registStepId) {
		this.registStepId = registStepId;
	}
	public String getIsEmailChecked() {
		return isEmailChecked;
	}
	public void setIsEmailChecked(String isEmailChecked) {
		this.isEmailChecked = isEmailChecked;
	}
	public String getRealPass() {
		return realPass;
	}
	public void setRealPass(String realPass) {
		this.realPass = realPass;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getIsAcceptEdm() {
		return isAcceptEdm;
	}
	public void setIsAcceptEdm(String isAcceptEdm) {
		this.isAcceptEdm = isAcceptEdm;
	}
	public String getIsMobileChecked() {
		return isMobileChecked;
	}
	public void setIsMobileChecked(String isMobileChecked) {
		this.isMobileChecked = isMobileChecked;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getHomeCity() {
		return homeCity;
	}
	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}
	public Long getAwardBalance() {
		return awardBalance;
	}
	public void setAwardBalance(Long awardBalance) {
		this.awardBalance = awardBalance;
	}
	public Long getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(Long withdraw) {
		this.withdraw = withdraw;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getLevelValidityDate() {
		return levelValidityDate;
	}
	public void setLevelValidityDate(Date levelValidityDate) {
		this.levelValidityDate = levelValidityDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getNameIsUpdate() {
		return nameIsUpdate;
	}
	public void setNameIsUpdate(String nameIsUpdate) {
		this.nameIsUpdate = nameIsUpdate;
	}
	public Long getCashBalance() {
		return cashBalance;
	}
	public void setCashBalance(Long cashBalance) {
		this.cashBalance = cashBalance;
	}
	public Long getBonusBalance() {
		return bonusBalance;
	}
	public void setBonusBalance(Long bonusBalance) {
		this.bonusBalance = bonusBalance;
	}
	public String getCancellationReason() {
		return cancellationReason;
	}
	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}
	public String getRegisterIp() {
		return registerIp;
	}
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}
	public Long getRegisterPort() {
		return registerPort;
	}
	public void setRegisterPort(Long registerPort) {
		this.registerPort = registerPort;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public String getSubScribe() {
		return subScribe;
	}
	public void setSubScribe(String subScribe) {
		this.subScribe = subScribe;
	}
	public boolean isCashFrozen() {
		return cashFrozen;
	}
	public void setCashFrozen(boolean cashFrozen) {
		this.cashFrozen = cashFrozen;
	}
	public String getSaveCreditCard() {
		return saveCreditCard;
	}
	public void setSaveCreditCard(String saveCreditCard) {
		this.saveCreditCard = saveCreditCard;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserTypeTest() {
		return userTypeTest;
	}
	public void setUserTypeTest(String userTypeTest) {
		this.userTypeTest = userTypeTest;
	}
	public String getIsZJ() {
		return isZJ;
	}
	public void setIsZJ(String isZJ) {
		this.isZJ = isZJ;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FitMemUserDto [userId=" + userId + ", userNo=" + userNo + ", userName=" + userName + ", userPassword=" + userPassword + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", memberShipCard=" + memberShipCard + ", activeMscardDate=" + activeMscardDate + ", nickName=" + nickName + ", groupId=" + groupId + ", cityId="
				+ cityId + ", passwordPrompt=" + passwordPrompt + ", passwordAnswer=" + passwordAnswer + ", realName=" + realName + ", address=" + address + ", isLocked=" + isLocked
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", isValid=" + isValid + ", gender=" + gender + ", idNumber=" + idNumber + ", point=" + point + ", memo=" + memo
				+ ", birthday=" + birthday + ", qqAccount=" + qqAccount + ", msnAccount=" + msnAccount + ", imageUrl=" + imageUrl + ", spaceUrl=" + spaceUrl + ", registStepId=" + registStepId
				+ ", isEmailChecked=" + isEmailChecked + ", realPass=" + realPass + ", cardId=" + cardId + ", isAcceptEdm=" + isAcceptEdm + ", isMobileChecked=" + isMobileChecked + ", zipCode="
				+ zipCode + ", homeCity=" + homeCity + ", awardBalance=" + awardBalance + ", withdraw=" + withdraw + ", channel=" + channel + ", grade=" + grade + ", levelValidityDate="
				+ levelValidityDate + ", lastLoginDate=" + lastLoginDate + ", nameIsUpdate=" + nameIsUpdate + ", cashBalance=" + cashBalance + ", bonusBalance=" + bonusBalance
				+ ", cancellationReason=" + cancellationReason + ", registerIp=" + registerIp + ", registerPort=" + registerPort + ", wechatId=" + wechatId + ", subScribe=" + subScribe
				+ ", cashFrozen=" + cashFrozen + ", saveCreditCard=" + saveCreditCard + ", loginType=" + loginType + ", userType=" + userType + ", userTypeTest=" + userTypeTest + ", isZJ=" + isZJ
				+ ", userStatus=" + userStatus + "]";
	}
    

}

