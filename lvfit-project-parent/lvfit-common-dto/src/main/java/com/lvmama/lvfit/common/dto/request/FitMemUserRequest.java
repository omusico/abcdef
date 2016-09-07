/**
 * Project Name:lvfit-common-dto
 * File Name:FitMemUserRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.member
 * Date:2015-12-10下午3:30:42
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

/**
 * ClassName:FitMemUserRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-10 下午3:30:42 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class FitMemUserRequest implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 3010895448413490040L;
	private Long userId;
	private String userNo;

	/**
	 * 
	 * @return the userId
	 * @since JDK 1.6
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId the userId to set
	 * @since JDK 1.6
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * userNo.
	 * 
	 * @return the userNo
	 * @since JDK 1.6
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * userNo.
	 * 
	 * @param userNo the userNo to set
	 * @since JDK 1.6
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

}
