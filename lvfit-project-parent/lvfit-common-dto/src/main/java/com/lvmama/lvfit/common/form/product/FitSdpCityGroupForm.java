package com.lvmama.lvfit.common.form.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;

public class FitSdpCityGroupForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1001906511602158076L;

	private FitSdpCityGroupDto fitSdpCityGroupDto;

	/** 查询 分页信息  **/
	private Pagination pagination = new Pagination();
	

	public PersistenceType getPtype() {
		return fitSdpCityGroupDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		fitSdpCityGroupDto.setPtype(ptype);
	}

	public String getSequence() {
		return fitSdpCityGroupDto.getSequence();
	}

	public Long getId() {
		return fitSdpCityGroupDto.getId();
	}

	public void setId(Long id) {
		fitSdpCityGroupDto.setId(id);
	}

	public String getUuid() {
		return fitSdpCityGroupDto.getUuid();
	}

	public void setUuid(String uuid) {
		fitSdpCityGroupDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return fitSdpCityGroupDto.getCreateTime();
	}

	public Long getProductId() {
		return fitSdpCityGroupDto.getProductId();
	}

	public void setCreateTime(Date createTime) {
		fitSdpCityGroupDto.setCreateTime(createTime);
	}

	public void setProductId(Long productId) {
		fitSdpCityGroupDto.setProductId(productId);
	}

	public Date getUpdateTime() {
		return fitSdpCityGroupDto.getUpdateTime();
	}

	public Long getDepartureCityDistrictId() {
		return fitSdpCityGroupDto.getDepartureCityDistrictId();
	}

	public void setUpdateTime(Date updateTime) {
		fitSdpCityGroupDto.setUpdateTime(updateTime);
	}

	public void setDepartureCityDistrictId(Long departureCityDistrictId) {
		fitSdpCityGroupDto.setDepartureCityDistrictId(departureCityDistrictId);
	}

	public String getDepartureCityShortPinYin() {
		return fitSdpCityGroupDto.getDepartureCityShortPinYin();
	}

	public void setDepartureCityShortPinYin(String departureCityShortPinYin) {
		fitSdpCityGroupDto
				.setDepartureCityShortPinYin(departureCityShortPinYin);
	}

	public String getDepartureCityCode() {
		return fitSdpCityGroupDto.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		fitSdpCityGroupDto.setDepartureCityCode(departureCityCode);
	}

	public String getDepartureCityName() {
		return fitSdpCityGroupDto.getDepartureCityName();
	}

	public void setDepartureCityName(String departureCityName) {
		fitSdpCityGroupDto.setDepartureCityName(departureCityName);
	}

	public Long getArrivalCityDistrictId() {
		return fitSdpCityGroupDto.getArrivalCityDistrictId();
	}

	public void setArrivalCityDistrictId(Long arrivalCityDistrictId) {
		fitSdpCityGroupDto.setArrivalCityDistrictId(arrivalCityDistrictId);
	}

	public String getArrivalCityShortPinYin() {
		return fitSdpCityGroupDto.getArrivalCityShortPinYin();
	}

	public void setArrivalCityShortPinYin(String arrivalCityShortPinYin) {
		fitSdpCityGroupDto.setArrivalCityShortPinYin(arrivalCityShortPinYin);
	}

	public String getArrivalCityCode() {
		return fitSdpCityGroupDto.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		fitSdpCityGroupDto.setArrivalCityCode(arrivalCityCode);
	}

	public String getArrivalCityName() {
		return fitSdpCityGroupDto.getArrivalCityName();
	}

	public void setArrivalCityName(String arrivalCityName) {
		fitSdpCityGroupDto.setArrivalCityName(arrivalCityName);
	}

	public JudgeType getIsSelectedDeparture() {
		return fitSdpCityGroupDto.getIsSelectedDeparture();
	}

	public void setIsSelectedDeparture(JudgeType isSelectedDeparture) {
		fitSdpCityGroupDto.setIsSelectedDeparture(isSelectedDeparture);
	}

	public FitSdpCityGroupDto getFitSdpCityGroupDto() {
		return fitSdpCityGroupDto;
	}

	public void setFitSdpCityGroupDto(FitSdpCityGroupDto fitSdpCityGroupDto) {
		this.fitSdpCityGroupDto = fitSdpCityGroupDto;
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
