package com.lvmama.lvfit.common.dto.order;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;


/**
 * 订单酒店套餐快照
 * @author leizhengwei
 *
 */
public class FitOrderHotelComboDto extends Entity {

	private static final long serialVersionUID = 5065493580078139421L;
	
	private Long productId;
	
    private String productName;

	private Long categoryId;
	
	private Long goodsId;
	
	private Long branchId;
	
    private String branchName;
    
    private String branchDesc;
	
	private Long quantity;
	
	private BigDecimal price;
	
	private Date checkIn;
	
	private Date checkOut;
	
	private String checkInCity;
	
	//打包关系id
	 private Long detailId; 

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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchDesc() {
		return branchDesc;
	}

	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public String getCheckInCity() {
		return checkInCity;
	}

	public void setCheckInCity(String checkInCity) {
		this.checkInCity = checkInCity;
	}

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	/*private String mainItem;
	
	private String detailId;
	
	private String routeRelation;
	
	private String goodType;*/
	
	
}
