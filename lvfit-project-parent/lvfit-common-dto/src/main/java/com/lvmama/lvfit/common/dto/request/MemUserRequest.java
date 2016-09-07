/**
 * Project Name:lvfit-common-dto
 * File Name:MemUserRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.request
 * Date:2015-12-18下午4:33:31
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

/**
 * ClassName:MemUserRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-18 下午4:33:31 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class MemUserRequest implements Serializable {
	private static final long serialVersionUID = 6965038546382482394L;
	private String lvSessionId;
	private String userId;

	/**
	 * lvSessionId.
	 * 
	 * @return the lvSessionId
	 * @since JDK 1.6
	 */
	public String getLvSessionId() {
		return lvSessionId;
	}

	/**
	 * lvSessionId.
	 * 
	 * @param lvSessionId the lvSessionId to set
	 * @since JDK 1.6
	 */
	public void setLvSessionId(String lvSessionId) {
		this.lvSessionId = lvSessionId;
	}

	/**
	 * userId.
	 * 
	 * @return the userId
	 * @since JDK 1.6
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userId.
	 * 
	 * @param userId the userId to set
	 * @since JDK 1.6
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
