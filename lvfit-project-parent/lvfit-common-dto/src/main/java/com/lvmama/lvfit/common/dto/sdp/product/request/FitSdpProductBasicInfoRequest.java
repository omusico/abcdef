package com.lvmama.lvfit.common.dto.sdp.product.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvfit.common.dto.enums.JudgeType;

public class FitSdpProductBasicInfoRequest implements Serializable,Dto{

	private static final long serialVersionUID = -8985878888267999622L;
	
	// 产品ID
    private Long productId;
    // 产品名称
    private String productName;
    // 业务类型
    private Long bizCategoryId;
	// 业务类型名称
    private Long bizCategoryName;
    // 被打包产品Id
    private Long packagedProductId;
    // 产品经理
    private String managerName;
    // 多出发地标志，'N'非多出发地，'Y'多出发地
    private JudgeType muiltDpartureFlag;
    //产品状态
    private JudgeType cancelFlag;
    //是否可售
    private JudgeType saleFlag;
    //创建时间开始
    private String createTimeStart;
    //创建时间结束
    private String createTimeEnd;
    
    /** 订单查询 分页信息  **/
	private Pagination pagination = new Pagination();
	
    public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getBizCategoryId() {
		return bizCategoryId;
	}
	public void setBizCategoryId(Long bizCategoryId) {
		this.bizCategoryId = bizCategoryId;
	}
	public Long getBizCategoryName() {
		return bizCategoryName;
	}
	public void setBizCategoryName(Long bizCategoryName) {
		this.bizCategoryName = bizCategoryName;
	}
	public Long getPackagedProductId() {
		return packagedProductId;
	}
	public void setPackagedProductId(Long packagedProductId) {
		this.packagedProductId = packagedProductId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public JudgeType getMuiltDpartureFlag() {
		return muiltDpartureFlag;
	}
	public void setMuiltDpartureFlag(JudgeType muiltDpartureFlag) {
		this.muiltDpartureFlag = muiltDpartureFlag;
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
		return createTimeStart;
	}
	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}
	public String getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	public JudgeType getSaleFlag() {
		return saleFlag;
	}
	public void setSaleFlag(JudgeType saleFlag) {
		this.saleFlag = saleFlag;
	}
	public JudgeType getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(JudgeType cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	
}
