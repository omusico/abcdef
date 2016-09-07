package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Oper;
/**
 * 会员信息 request
 * @author zhangzongshuang
 *
 */
public class UserMemberRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9200591157580411112L;

	private Long userId;
	private String userNo;
    private String mobileNumber;
    private String parameters;
  	private Oper oper;
 
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public Oper getOper() {
		return oper;
	}
	public void setOper(Oper oper) {
		this.oper = oper;
	}

}
