package com.lvmama.lvf.common.form.api;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.api.ApiFlowDto;
import com.lvmama.lvf.common.dto.enums.AuditStatus;
import com.lvmama.lvf.common.dto.enums.AuditType;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.enums.OrderAuditOpType;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.order.result.FlightOrderAuditOpDto;
import com.lvmama.lvf.common.dto.status.OpType;
import com.lvmama.lvf.common.dto.status.order.OrderAuditStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;


public class ApiFlowResultForm implements Serializable, Form {

	private static final long serialVersionUID = -6838239268016794144L;
	
	private ApiFlowDto apiFlowDto;
	
	private String interfaceKeyCnName;

	public ApiFlowResultForm(ApiFlowDto apiFlowDto) {
		super();
		this.apiFlowDto = apiFlowDto;
	}

	public RequestResponse getRequestResponse() {
		return apiFlowDto.getRequestResponse();
	}

	public void setRequestResponse(RequestResponse requestResponse) {
		apiFlowDto.setRequestResponse(requestResponse);
	}

	public String getDate() {
		return apiFlowDto.getDate();
	}

	public void setDate(String date) {
		apiFlowDto.setDate(date);
	}

	public String getTime() {
		return apiFlowDto.getTime();
	}

	public void setTime(String time) {
		apiFlowDto.setTime(time);
	}

	public Date getSearchTime() {
		return apiFlowDto.getSearchTime();
	}

	public ApiFlowDto getApiFlowDto() {
		return apiFlowDto;
	}

	public void setApiFlowDto(ApiFlowDto apiFlowDto) {
		this.apiFlowDto = apiFlowDto;
	}

	public PersistenceType getPtype() {
		return apiFlowDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		apiFlowDto.setPtype(ptype);
	}

	public void setSearchTime(Date searchTime) {
		apiFlowDto.setSearchTime(searchTime);
	}

	public String getSequence() {
		return apiFlowDto.getSequence();
	}

	public String getSuppCode() {
		return apiFlowDto.getSuppCode();
	}

	public Long getId() {
		return apiFlowDto.getId();
	}

	public void setSuppCode(String suppCode) {
		apiFlowDto.setSuppCode(suppCode);
	}

	public void setId(Long id) {
		apiFlowDto.setId(id);
	}

	public String getUuid() {
		return apiFlowDto.getUuid();
	}

	public InterfaceKey getInterfaceKey() {
		return apiFlowDto.getInterfaceKey();
	}

	public void setUuid(String uuid) {
		apiFlowDto.setUuid(uuid);
	}

	public void setInterfaceKey(InterfaceKey interfaceKey) {
		apiFlowDto.setInterfaceKey(interfaceKey);
	}

	public Date getCreateTime() {
		return apiFlowDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		apiFlowDto.setCreateTime(createTime);
	}

	public String getIp() {
		return apiFlowDto.getIp();
	}

	public void setIp(String ip) {
		apiFlowDto.setIp(ip);
	}

	public Date getUpdateTime() {
		return apiFlowDto.getUpdateTime();
	}

	public String getLocation() {
		return apiFlowDto.getLocation();
	}

	public void setUpdateTime(Date updateTime) {
		apiFlowDto.setUpdateTime(updateTime);
	}

	public void setLocation(String location) {
		apiFlowDto.setLocation(location);
	}

	public int hashCode() {
		return apiFlowDto.hashCode();
	}

	public boolean equals(Object obj) {
		return apiFlowDto.equals(obj);
	}

	public String toString() {
		return apiFlowDto.toString();
	}

	public String getInterfaceKeyCnName() {
		return apiFlowDto.getInterfaceKey().getCnName();
	}

	public void setInterfaceKeyCnName(String interfaceKeyCnName) {
		this.interfaceKeyCnName = interfaceKeyCnName;
	}

	public String getTraceNo() {
		return apiFlowDto.getTraceNo();
	}

	public void setTraceNo(String traceNo) {
		apiFlowDto.setTraceNo(traceNo);
	}

	public String getServerTrace() {
		return apiFlowDto.getServerTrace();
	}

	public void setServerTrace(String serverTrace) {
		apiFlowDto.setServerTrace(serverTrace);
	}

	public String getServerTraceTime() {
		return apiFlowDto.getServerTraceTime();
	}

	public void setServerTraceTime(String serverTraceTime) {
		apiFlowDto.setServerTraceTime(serverTraceTime);
	}

	public String getMessage() {
		return apiFlowDto.getMessage();
	}
	
	public void setMessage(String message) {
		apiFlowDto.setMessage(message);
	}
	
	public String getRequestResponseLink() {
		String gid = apiFlowDto.getGid();
		InterfaceKey interfaceKey = apiFlowDto.getInterfaceKey();
		if (RequestResponse.RE.equals(apiFlowDto.getRequestResponse())) {
			return "<a href='javascript:;' style='color:blue' onclick='getREMessageDetail(\""+gid+"\",\""+interfaceKey+"\")'>请求详情</a>";
		} else {
			return "<a href='javascript:;' style='color:blue' onclick='getRSMessageDetail(\""+gid+"\",\""+interfaceKey+"\")'>响应详情</a>";
		}
	}

}
