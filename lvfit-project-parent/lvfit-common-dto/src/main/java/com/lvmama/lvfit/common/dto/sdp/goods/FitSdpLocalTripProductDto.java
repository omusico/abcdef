package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.utils.DateUtils;

public class FitSdpLocalTripProductDto implements Serializable {

    private static final long serialVersionUID = -9013089205090778051L;

    // 产品ID
    private Long productId;
    // 产品名称
    private String productName;
    // 产品组名
    private String groupName;
    // 商品ID
    private Long suppGoodsId;
    // 团期（天数）
    private Long travelDays;
    // 团期（晚）
    private Long stayDays;
    // 第*天
    private String dayOfDuration;
    // 日期
    private Date visitDate;
    // 日期
    private String visitDateStr;
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
    public Long getSuppGoodsId() {
		return suppGoodsId;
	}
	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
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
	public String getVisitDateStr() {
		return DateUtils.formatDate(getVisitDate(), DateUtils.YYYY_MM_DD);
	}
	public void setVisitDateStr(String visitDateStr) {
		this.visitDateStr = visitDateStr ;
	}
	public Long getDetailId() {
		return detailId;
	}
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
}
