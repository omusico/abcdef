package com.lvmama.lvfit.common.dto.shopping;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Dto;

public class FitShoppingSelectedInsuranceDto implements Serializable, Dto  {

	private static final long serialVersionUID = -5909960720458104967L;
	
	/**品类id*/
	private String productId; 
	/**类型*/
	private String productType;
	/**名称*/
	private String productName;
	/**规格id*/
	private String branchId;
	/**规格名称*/
	private String branchName;
	/**商品id*/
	private String suppGoodsId;
	/**商品名称*/
	private String suppGoodsName;
	/**购买数量*/
	private Integer insuranceCount;
	/**单价*/
	private BigDecimal insurancePrice;
	/**使用天数*/
	private Integer useDays;
	/**使用天数*/
	private String insuranceDetail;
	/**游玩日期*/
	private Date visitDate;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getSuppGoodsId() {
		return suppGoodsId;
	}
	public void setSuppGoodsId(String suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}
	public String getSuppGoodsName() {
		return suppGoodsName;
	}
	public void setSuppGoodsName(String suppGoodsName) {
		this.suppGoodsName = suppGoodsName;
	}
	public Integer getInsuranceCount() {
		return insuranceCount;
	}
	public void setInsuranceCount(Integer insuranceCount) {
		this.insuranceCount = insuranceCount;
	}
	public BigDecimal getInsurancePrice() {
		return insurancePrice;
	}
	public void setInsurancePrice(BigDecimal insurancePrice) {
		this.insurancePrice = insurancePrice;
	}
	public Integer getUseDays() {
		return useDays;
	}
	public void setUseDays(Integer useDays) {
		this.useDays = useDays;
	}
	public String getInsuranceDetail() {
		return insuranceDetail;
	}
	public void setInsuranceDetail(String insuranceDetail) {
		this.insuranceDetail = insuranceDetail;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productType == null) ? 0 : productType.hashCode());
		result = prime * result
				+ ((suppGoodsId == null) ? 0 : suppGoodsId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FitShoppingSelectedInsuranceDto other = (FitShoppingSelectedInsuranceDto) obj;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (suppGoodsId == null) {
			if (other.suppGoodsId != null)
				return false;
		} else if (!suppGoodsId.equals(other.suppGoodsId))
			return false;
		return true;
	}
	

}
