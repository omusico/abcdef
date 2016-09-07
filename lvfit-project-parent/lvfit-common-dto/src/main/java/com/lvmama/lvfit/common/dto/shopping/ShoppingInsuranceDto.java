package com.lvmama.lvfit.common.dto.shopping;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;

public class ShoppingInsuranceDto extends Entity {
	
	private static final long serialVersionUID = 8022650790555675570L;
	
	private String shoppingUuid;
	// 产品ID
	private String insuranceId;
	// 产品名称
	private String insuranceName;
	//产品类型
	private String insuranceType;
	//规格id
	private String insuranceBranchId;
	//规格名称
	private String insuranceBranchName;
	// 商品ID
	private String insuranceSuppGoodsId;
	// 商品名称
	private String insuranceSuppGoodsName;
	//购买份数
	private int insuranceCount;
	//购买份数
	private Integer useDays;
    //门票金额
    private BigDecimal  insurancePrice;
    //版本号
    private Long versionNo;
   //游玩日期
    private Date visitDate;  
  //保险详情
    private String insuranceDetail;
    
	public String getShoppingUuid() {
		return shoppingUuid;
	}
	public void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
	}
	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getInsuranceBranchId() {
		return insuranceBranchId;
	}
	public void setInsuranceBranchId(String insuranceBranchId) {
		this.insuranceBranchId = insuranceBranchId;
	}
	public String getInsuranceBranchName() {
		return insuranceBranchName;
	}
	public void setInsuranceBranchName(String insuranceBranchName) {
		this.insuranceBranchName = insuranceBranchName;
	}
	public String getInsuranceSuppGoodsId() {
		return insuranceSuppGoodsId;
	}
	public void setInsuranceSuppGoodsId(String insuranceSuppGoodsId) {
		this.insuranceSuppGoodsId = insuranceSuppGoodsId;
	}
	public String getInsuranceSuppGoodsName() {
		return insuranceSuppGoodsName;
	}
	public void setInsuranceSuppGoodsName(String insuranceSuppGoodsName) {
		this.insuranceSuppGoodsName = insuranceSuppGoodsName;
	}
	public int getInsuranceCount() {
		return insuranceCount;
	}
	public void setInsuranceCount(int insuranceCount) {
		this.insuranceCount = insuranceCount;
	}
	public Integer getUseDays() {
		return useDays;
	}
	public void setUseDays(Integer useDays) {
		this.useDays = useDays;
	}
	public BigDecimal getInsurancePrice() {
		return insurancePrice;
	}
	public void setInsurancePrice(BigDecimal insurancePrice) {
		this.insurancePrice = insurancePrice;
	}
	public Long getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getInsuranceDetail() {
		return insuranceDetail;
	}
	public void setInsuranceDetail(String insuranceDetail) {
		this.insuranceDetail = insuranceDetail;
	}
	
	

}
