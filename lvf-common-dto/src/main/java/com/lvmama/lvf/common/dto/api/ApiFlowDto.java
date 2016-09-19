package com.lvmama.lvf.common.dto.api;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.utils.DateUtils;

public class ApiFlowDto extends Entity implements Serializable{

	private static final long serialVersionUID = 5767145960404452986L;
	/********************前台日期转化****************************/
	
	private String date;//日期
	private String time;//时刻
	
	
	/********************数据库****************************/
	/**供应商*/
	private String suppCode;
	
	/**接口名*/
	private InterfaceKey interfaceKey;
	
	/**用户ip*/
	private String ip;
	//设备号
	private String equipmentNo;
	
	/**地区*/
	private String location;
	
	/**查询时间:数据库存储*/
	private Date searchTime;
	
	private String traceNo;
	private String serverTrace;
	private String serverTraceTime;
	
	private String message;
	
	private String result;
	
	private String gid;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**请求响应类型*/
	private RequestResponse requestResponse;
	
	
	
	
	public RequestResponse getRequestResponse() {
		return requestResponse;
	}

	public void setRequestResponse(RequestResponse requestResponse) {
		this.requestResponse = requestResponse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return DateUtils.formatDate(this.getCreateTime());
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return DateUtils.formatTimeMillisecond(this.getCreateTime());
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(Date searchTime) {
		this.searchTime = searchTime;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public InterfaceKey getInterfaceKey() {
		return interfaceKey;
	}

	public void setInterfaceKey(InterfaceKey interfaceKey) {
		this.interfaceKey = interfaceKey;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public String getServerTrace() {
		return serverTrace;
	}

	public void setServerTrace(String serverTrace) {
		this.serverTrace = serverTrace;
	}

	public String getServerTraceTime() {
		return serverTraceTime;
	}

	public void setServerTraceTime(String serverTraceTime) {
		this.serverTraceTime = serverTraceTime;
	}

	/**
	 * @return  the gid
	 */
	public String getGid() {
		return gid;
	}

	/**
	 * @param gid the gid to set
	 */
	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	
	
}
