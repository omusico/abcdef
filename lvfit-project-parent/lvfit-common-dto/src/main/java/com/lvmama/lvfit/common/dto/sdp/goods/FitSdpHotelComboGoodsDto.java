package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 酒店套餐商品
 * @author lizongze
 *
 */
public class FitSdpHotelComboGoodsDto implements Serializable {

    private static final long serialVersionUID = 7859865883852602292L;
    
    // 产品ID
    private Long productId;
    // 产品名称
    private String productName;
    // 产品组名
    private String groupName;
    // 团期（天数）
    private Long travelDays;
    // 团期（晚）
    private Long stayDays;
    // 第*天
    private String dayOfDuration;
    // 开始日期
    private Date startDay;
   // 开始日期Str
    private String startDayStr;
    // 商品ID
    private Long suppGoodsId;
    // 规格ID
    private Long branchId;
    // 规格名
    private String branchName;
    // 规格详情
    private String branchDesc;
    // 价格
    private BigDecimal price;
    // 份数
    private Long quantity;
    
    private String goodType = "hotelCombo";//商品类型--酒店套餐
    // 差价
    private BigDecimal diffPrice;
    // 是否被选中
    private String isBeSelected;
    //打包关系id
    private Long detailId;
    
    
	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Long getSuppGoodsId() {
		return suppGoodsId;
	}

	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
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

	public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

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

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }
    
    public String getStartDayStr() {
    	if(this.getStartDay()!=null){
    		return DateUtils.formatDate(this.getStartDay());
    	}
		return startDayStr;
	}

	public void setStartDayStr(String startDayStr) {
		this.startDayStr = startDayStr;
	}

	public BigDecimal getDiffPrice() {
        return diffPrice;
    }

    public void setDiffPrice(BigDecimal diffPrice) {
        this.diffPrice = diffPrice;
    }

    public String getIsBeSelected() {
        return isBeSelected;
    }

    public void setIsBeSelected(String isBeSelected) {
        this.isBeSelected = isBeSelected;
    }

}
