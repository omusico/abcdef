package com.lvmama.lvfit.common.dto.order;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 当地游快照
 * @author leizhengwei
 *
 */
public class FitOrderLocalTripProductDto extends Entity{
	
	private static final long serialVersionUID = 6360048547533936663L;
	// 产品ID
    private Long productId;
    // 产品名称
    private String productName;
    // 产品组名
    private String groupName;
    //商品Id
    private Long goodsId;
    // 团期（天数）
    private Long travelDays;
    // 团期（晚）
    private Long stayDays;
    // 第*天
    private String dayOfDuration;
    // 日期
    private Date visitDate;
    // 房差
    private BigDecimal roomDiffPrice;
    // 选中日期的价格 （作为日期产品的总价）
    private BigDecimal price;
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getTravelDays() {
		return travelDays;
	}
	public void setTravelDays(Long travelDays) {
		this.travelDays = travelDays;
	}
	public Long getStayDays() {
		return stayDays;
	}
	public void setStayDays(Long stayDays) {
		this.stayDays = stayDays;
	}
	public String getDayOfDuration() {
		return dayOfDuration;
	}
	public void setDayOfDuration(String dayOfDuration) {
		this.dayOfDuration = dayOfDuration;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public BigDecimal getRoomDiffPrice() {
		return roomDiffPrice;
	}
	public void setRoomDiffPrice(BigDecimal roomDiffPrice) {
		this.roomDiffPrice = roomDiffPrice;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getDetailId() {
		return detailId;
	}
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
    
    

}
