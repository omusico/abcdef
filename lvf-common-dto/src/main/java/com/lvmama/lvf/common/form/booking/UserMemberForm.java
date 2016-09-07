package com.lvmama.lvf.common.form.booking;

import java.io.Serializable;

public class UserMemberForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6174307101752530176L;
	private String userId;
	private String userName;
	private String grade;
	private String userCode;
	private String userCellphone;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserCellphone() {
		return userCellphone;
	}
	public void setUserCellphone(String userCellphone) {
		this.userCellphone = userCellphone;
	}
	
}
