package com.lvmama.lvfit.common.dto.sdp.product.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvfit.common.dto.enums.JudgeType;

public class FitSdpProductBasicInfoRequestForm implements Serializable,Dto{

	private static final long serialVersionUID = -8985878888267999622L;
	
	private  FitSdpProductBasicInfoRequest request = new FitSdpProductBasicInfoRequest();
	
    /** 订单查询 分页信息  **/
	private Pagination pagination = new Pagination();
	
	public FitSdpProductBasicInfoRequest getRequest() {
		return request;
	}

	public void setRequest(FitSdpProductBasicInfoRequest request) {
		this.request = request;
	}
	public Long getProductId() {
		return request.getProductId();
	}
	public void setProductId(Long productId) {
		request.setProductId(productId);
	}
	public String getProductName() {
		return request.getProductName();
	}
	public void setProductName(String productName) {
		request.setProductName(productName);
	}
	public Long getBizCategoryId() {
		return request.getBizCategoryId();
	}
	public void setBizCategoryId(Long bizCategoryId) {
		request.setBizCategoryId(bizCategoryId);
	}
	public Long getBizCategoryName() {
		return request.getBizCategoryName();
	}
	public void setBizCategoryName(Long bizCategoryName) {
		request.setBizCategoryName(bizCategoryName);
	}
	public Long getPackagedProductId() {
		return request.getPackagedProductId();
	}
	public void setPackagedProductId(Long packagedProductId) {
		request.setPackagedProductId(packagedProductId);
	}
	public String getManagerName() {
		return request.getManagerName();
	}
	public void setManagerName(String managerName) {
		request.setManagerName(managerName);
	}
	public JudgeType getMuiltDpartureFlag() {
		return request.getMuiltDpartureFlag();
	}
	public void setMuiltDpartureFlag(JudgeType muiltDpartureFlag) {
		request.setMuiltDpartureFlag(muiltDpartureFlag);
	}
	public JudgeType getCancelFlag() {
		return request.getCancelFlag();
	}
	public void setCancelFlag(JudgeType cancelFlag) {
		request.setCancelFlag(cancelFlag);
	}
	public JudgeType getSaleFlag() {
		return request.getSaleFlag();
	}
	public void setSaleFlag(JudgeType saleFlag) {
		request.setSaleFlag(saleFlag);
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
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCreateTimeStart() {
		return request.getCreateTimeStart();
	}
	public void setCreateTimeStart(String createTimeStart) {
		request.setCreateTimeStart(createTimeStart);
	}
	public String getCreateTimeEnd() {
		return request.getCreateTimeEnd();
	}
	public void setCreateTimeEnd(String createTimeEnd) {
		request.setCreateTimeEnd(createTimeEnd);
	}
}
