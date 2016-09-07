package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VstPushRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4771147126167105488L;
	/**
	 * serialVersionUID:TODO.
	 * 
	 * @since JDK 1.6
	 */
	private BigDecimal id;
	private BigDecimal objectId;
	private Date createTime;
	private BigDecimal objectType;
	private String pushFlag;
	private String pushCount;
	private BigDecimal pushContent;
	private BigDecimal dataType;
	private String operateType;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getObjectId() {
		return objectId;
	}
	public void setObjectId(BigDecimal objectId) {
		this.objectId = objectId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getObjectType() {
		return objectType;
	}
	public void setObjectType(BigDecimal objectType) {
		this.objectType = objectType;
	}
	public String getPushFlag() {
		return pushFlag;
	}
	public void setPushFlag(String pushFlag) {
		this.pushFlag = pushFlag;
	}
	public String getPushCount() {
		return pushCount;
	}
	public void setPushCount(String pushCount) {
		this.pushCount = pushCount;
	}
	public BigDecimal getPushContent() {
		return pushContent;
	}
	public void setPushContent(BigDecimal pushContent) {
		this.pushContent = pushContent;
	}
	public BigDecimal getDataType() {
		return dataType;
	}
	public void setDataType(BigDecimal dataType) {
		this.dataType = dataType;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
}
