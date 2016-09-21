package com.lvmama.lvfit.common.dto.sdp.product.request;

import java.io.Serializable;
import com.lvmama.lvf.common.dto.Pagination;

public class FitSdpCityGroupRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1821792595744787705L;
	
	/**产品Id*/
	private Long productId;
	
	/**出发城市区域Id*/
	private Long departureCityDistrictId;
	
	/**出发城市名称*/
	private String departureCityName;
	
	
    /** 订单查询 分页信息  **/
	private Pagination pagination = new Pagination();
	
	public Long getDepartureCityDistrictId() {
		return departureCityDistrictId;
	}

	public void setDepartureCityDistrictId(Long departureCityDistrictId) {
		this.departureCityDistrictId = departureCityDistrictId;
	}

	public String getDepartureCityName() {
		return departureCityName;
	}

	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
