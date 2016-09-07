package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

public class MemUserRequest implements Serializable{
	
	private static final long serialVersionUID = 3709050332495217225L;
	
	private String userId;
	private String lvSessionId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLvSessionId() {
		return lvSessionId;
	}
	public void setLvSessionId(String lvSessionId) {
		this.lvSessionId = lvSessionId;
	}
	
}
