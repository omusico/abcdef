package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.status.PublishStatus;

@XmlRootElement
public class FlightPolicyPublishDto implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -804215474179187577L;
	
	/** 审核发布枚举 */
	private PublishStatus publishStatus;
	
	/** 政策建立日期 */
	private Date createDate;
	
	/** 建立者 */
	private String creater;
	
	/** 发布日期 */
	private Date publishDate;
	
	/** 发布者 */
	private String publisher;
	
	/** 审核日期 */
	private Date auditDate;
	
	/** 审核者 */
	private String auditer;
	
	/** 操作日志 */
	private List<OpLog> opLogs;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public List<OpLog> getOpLogs() {
		return opLogs;
	}
	public void setOpLogs(List<OpLog> opLogs) {
		this.opLogs = opLogs;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public String getAuditer() {
		return auditer;
	}
	public void setAuditer(String auditer) {
		this.auditer = auditer;
	}
	public PublishStatus getPublishStatus() {
		return publishStatus;
	}
	public void setPublishStatus(PublishStatus publishStatus) {
		this.publishStatus = publishStatus;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
}
