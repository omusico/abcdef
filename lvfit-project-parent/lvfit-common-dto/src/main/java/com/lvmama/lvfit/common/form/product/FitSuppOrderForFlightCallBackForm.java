package com.lvmama.lvfit.common.form.product;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.ZipUnZipUtils;
import com.lvmama.lvfit.common.dto.enums.CallbackType;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;

public class FitSuppOrderForFlightCallBackForm implements Serializable, Form {


	private FitSuppOrderForFlightCallBackDto fitSuppOrderForFlightCallBackDto;

	/** 查询 分页信息  **/
	private Pagination pagination = new Pagination();
	
	public FitSuppOrderForFlightCallBackDto getFitSuppOrderForFlightCallBackDto() {
		return fitSuppOrderForFlightCallBackDto;
	}

	public void setCallBackDto(FitSuppOrderForFlightCallBackDto fitSuppOrderForFlightCallBackDto) {
		this.fitSuppOrderForFlightCallBackDto = fitSuppOrderForFlightCallBackDto;
	}

	public PersistenceType getPtype() {
		return fitSuppOrderForFlightCallBackDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		fitSuppOrderForFlightCallBackDto.setPtype(ptype);
	}

	public String getSequence() {
		return fitSuppOrderForFlightCallBackDto.getSequence();
	}

	public Long getId() {
		return fitSuppOrderForFlightCallBackDto.getId();
	}

	public void setId(Long id) {
		fitSuppOrderForFlightCallBackDto.setId(id);
	}

	public Long getSuppOrderId() {
		return fitSuppOrderForFlightCallBackDto.getSuppOrderId();
	}

	public void setSuppOrderId(Long suppOrderId) {
		fitSuppOrderForFlightCallBackDto.setSuppOrderId(suppOrderId);
	}

	public void setUuid(String uuid) {
		fitSuppOrderForFlightCallBackDto.setUuid(uuid);
	}

	public String getVstOrderMainNo() {
		return fitSuppOrderForFlightCallBackDto.getVstOrderMainNo();
	}

	public Date getCreateTime() {
		return fitSuppOrderForFlightCallBackDto.getCreateTime();
	}

	public void setVstOrderMainNo(String vstOrderMainNo) {
		fitSuppOrderForFlightCallBackDto.setVstOrderMainNo(vstOrderMainNo);
	}

	public void setCreateTime(Date createTime) {
		fitSuppOrderForFlightCallBackDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return fitSuppOrderForFlightCallBackDto.getUpdateTime();
	}

	public String getVstOrderNo() {
		return fitSuppOrderForFlightCallBackDto.getVstOrderNo();
	}

	public void setUpdateTime(Date updateTime) {
		fitSuppOrderForFlightCallBackDto.setUpdateTime(updateTime);
	}

	public void setVstOrderNo(String vstOrderNo) {
		fitSuppOrderForFlightCallBackDto.setVstOrderNo(vstOrderNo);
	}

	public String getCallRequestStr() {
		if(StringUtils.isNotBlank(fitSuppOrderForFlightCallBackDto.getCallRequestStr())){
			try {
				return ZipUnZipUtils.getInstance().unzipBase642String(fitSuppOrderForFlightCallBackDto.getCallRequestStr());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void setCallRequestStr(String callRequestStr) {
		fitSuppOrderForFlightCallBackDto.setCallRequestStr(callRequestStr);
	}

	public FlightTripType getTripType() {
		return fitSuppOrderForFlightCallBackDto.getTripType();
	}

	public void setTripType(FlightTripType tripType) {
		fitSuppOrderForFlightCallBackDto.setTripType(tripType);
	}

	public CallbackType getCallbackType() {
		return fitSuppOrderForFlightCallBackDto.getCallbackType();
	}

	public void setCallbackType(CallbackType callbackType) {
		fitSuppOrderForFlightCallBackDto.setCallbackType(callbackType);
	}

	public Date getCallbackTime() {
		return fitSuppOrderForFlightCallBackDto.getCallbackTime();
	}

	public void setCallbackTime(Date callbackTime) {
		fitSuppOrderForFlightCallBackDto.setCallbackTime(callbackTime);
	}

	public boolean equals(Object obj) {
		return pagination.equals(obj);
	}

	public int hashCode() {
		return pagination.hashCode();
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public String toString() {
		return pagination.toString();
	}

	/**   pagination start	 * 	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
    
    public Pagination getPagination() {
		return pagination;
	}
    
	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}
	/**   pagination end	 * 	 */
	

}
