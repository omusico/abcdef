package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryDto;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryPeopleDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;

/**
 *  订单查询
 * @author wanghuihui
 * @date:2016年1月5日 下午9:53:26
 */
public class FitOrderQueryRequest implements Serializable, Dto{
	/**  
	 * @author wanghuihui
	 * @date:2016年1月6日 下午4:49:58
	 */
	private static final long serialVersionUID = 2216537847410311988L;
	/** 订单查询 人员信息  **/
	FitOrderQueryPeopleDto fitPeopleDto = new FitOrderQueryPeopleDto();
	/** 订单查询 订单信息  **/
	FitOrderQueryDto fitOrderDto = new FitOrderQueryDto();
	/**  供应商主单状态相关  **/
	FitSuppMainOrderStatusDto suppMainStatus = new FitSuppMainOrderStatusDto();
	/** 订单查询 分页信息  **/
	private Pagination pagination = new Pagination();
	/**  订单主ID: 格式：id1,id2,id3  **/
	private String mainIds ;
	
	/*** 乘客人信息 开始   **/
	public final FitOrderQueryPeopleDto getFitOrderQueryPeopleDto() {
		return fitPeopleDto;
	}
	public final void setFitOrderQueryPeopleDto(
			FitOrderQueryPeopleDto fitOrderQueryPeopleDto) {
		this.fitPeopleDto = fitOrderQueryPeopleDto;
	}
	
	/*** 乘客人信息 结束   **/
	
	
	
	/*** 下单信息 start   **/
	public final FitOrderQueryDto getFitOrderQueryDto() {
		return fitOrderDto;
	}
	public final void setFitOrderQueryDto(FitOrderQueryDto fitOrderQueryDto) {
		this.fitOrderDto = fitOrderQueryDto;
	}
	/*public final String getOrderMainNo() {
		return fitOrderDto.getOrderMainNo();
	}
	public final void setOrderMainNo(String orderMainNo) {
		fitOrderDto.setOrderMainNo(orderMainNo);
	}
	public final String getOrderNo() {
		return fitOrderDto.getOrderNo();
	}
	public final void setOrderNo(String orderNo) {
		fitOrderDto.setOrderNo(orderNo);
	}
	public final Long getCustomerId() {
		return fitOrderDto.getCustomerId();
	}
	public final void setCustomerId(Long customerId) {
		fitOrderDto.setCustomerId(customerId);
	}
	public final String getMainStartTime() {
		return fitOrderDto.getMainStartTime();
	}
	public final void setMainStartTime(String mainStartTime) {
		fitOrderDto.setMainStartTime(mainStartTime);
	}
	public final String getMainEndTime() {
		return fitOrderDto.getMainEndTime();
	}
	public final void setMainEndTime(String mainEndTime) {
		fitOrderDto.setMainEndTime(mainEndTime);
	}
	public final List<String> getBookingSources() {
		return fitOrderDto.getBookingSources();
	}
	public final void setBookingSources(List<String> bookingSources) {
		fitOrderDto.setBookingSources(bookingSources);
	}*/
	/*** 下单信息 END   **/
	
	/**   pagination start	 * 	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
    
    public Pagination getPagination() {
		return pagination;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
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
	public final String getMainIds() {
		return mainIds;
	}
	public final FitSuppMainOrderStatusDto getSuppMainStatus() {
		return suppMainStatus;
	}
	public final void setSuppMainStatus(FitSuppMainOrderStatusDto suppMainStatus) {
		this.suppMainStatus = suppMainStatus;
	}
	public final void setMainIds(String mainIds) {
		this.mainIds = mainIds;
	}

}

