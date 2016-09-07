package com.lvmama.lvf.common.form.search;
import java.util.Date;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.vst.UserMemberDto;
import com.lvmama.lvf.common.form.Form;

public class SearchUserMemberResponseForm implements Form {
	
	private UserMemberDto userMemberDto;
	
	private BaseResponseDto<UserMemberDto> response;
	
	public UserMemberDto getUserMemberDto() {
		return userMemberDto;
	}
	public void setUserMemberDto(UserMemberDto userMemberDto) {
		this.userMemberDto = userMemberDto;
	}
	public BaseResponseDto<UserMemberDto> getResponse() {
		return response;
	}
	public void setResponse(BaseResponseDto<UserMemberDto> response) {
		this.response = response;
	}
	
	public Long getUserId() {
		return userMemberDto.getUserId();
	}
	public void setUserId(Long userId) {
		userMemberDto.setUserId(userMemberDto.getUserId());
	}
	public String getUserNo() {
		return userMemberDto.getUserNo();
	}
	public void setUserNo(String userNo) {
		userMemberDto.setUserNo(userMemberDto.getUserNo());
	}
	public String getUserName() {
		return userMemberDto.getUserName();
	}
	public void setUserName(String userName) {
		userMemberDto.setUserName(userMemberDto.getUserName());
	}
	public String getUserPassword() {
		return userMemberDto.getUserPassword();
	}
	public void setUserPassword(String userPassword) {
		userMemberDto.setUserPassword(userMemberDto.getUserPassword());
	}
	public String getMobileNumber() {
		return userMemberDto.getMobileNumber();
	}
	public void setMobileNumber(String mobileNumber) {
		userMemberDto.setMobileNumber(userMemberDto.getMobileNumber());
	}
	public String getEmail() {
		return userMemberDto.getEmail();
	}
	public void setEmail(String email) {
		userMemberDto.setEmail(userMemberDto.getEmail());
	}
	public String getPhoneNumber() {
		return userMemberDto.getPhoneNumber();
	}
	public void setPhoneNumber(String phoneNumber) {
		userMemberDto.setPhoneNumber(userMemberDto.getPhoneNumber());
	}
	public String getMemberShipCard() {
		return userMemberDto.getMemberShipCard();
	}
	public void setMemberShipCard(String memberShipCard) {
		userMemberDto.setMemberShipCard(userMemberDto.getMemberShipCard());
	}
	public Date getActiveMscardDate() {
		return userMemberDto.getActiveMscardDate();
	}
	public void setActiveMscardDate(Date activeMscardDate) {
		userMemberDto.setActiveMscardDate(userMemberDto.getActiveMscardDate());
	}
}
