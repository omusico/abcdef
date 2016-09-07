package com.lvmama.lvf.common.dto.vst;

/**
 * 返回退改签热线给分销
 * @author XuJunhui
 * @Date 2016年7月4日
 */
public class HotLineDto{

	private String telPhone;
	
	private String workingTimeStart;
	
	private String workingTimeEnd;
	
	public String getDescription(){
		return "退改签请呼叫服务热线："+ this.telPhone +" ( 上下班时间: "+ this.workingTimeStart +" -- "+ this.workingTimeEnd +" )";
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getWorkingTimeStart() {
		return workingTimeStart;
	}

	public void setWorkingTimeStart(String workingTimeStart) {
		this.workingTimeStart = workingTimeStart;
	}

	public String getWorkingTimeEnd() {
		return workingTimeEnd;
	}

	public void setWorkingTimeEnd(String workingTimeEnd) {
		this.workingTimeEnd = workingTimeEnd;
	}
	
	

}
