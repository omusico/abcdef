package com.lvmama.comm.jms;

import java.io.Serializable;

/**
 * vst产品队列消息
 * @author leizhengwei
 *
 */
public class Message implements Serializable{

	
	private static final long serialVersionUID = -1118236567096207803L;
	
	private Long objectId;
	private String objectType;
	private String eventType;
	private String addition;	//无特定，可以灵活跟随信息
	private String systemType;
	private String trackNumber;
	private String parentAppName;
	private String distributedContextJson;

	public Message() {
		super();
	}
	
	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}

	public String getParentAppName() {
		return parentAppName;
	}

	public void setParentAppName(String parentAppName) {
		this.parentAppName = parentAppName;
	}

	public String getDistributedContextJson() {
		return distributedContextJson;
	}

	public void setDistributedContextJson(String distributedContextJson) {
		this.distributedContextJson = distributedContextJson;
	}

	@Override
	public String toString() {
		return "Message{" +
				"objectId=" + objectId +
				", objectType='" + objectType + '\'' +
				", eventType='" + eventType + '\'' +
				", addition='" + addition + '\'' +
				", systemType='" + systemType + '\'' +
				", trackNumber='" + trackNumber + '\'' +
				", parentAppName='" + parentAppName + '\'' +
				", distributedContextJson='" + distributedContextJson + '\'' +
				'}';
	}

	
}
