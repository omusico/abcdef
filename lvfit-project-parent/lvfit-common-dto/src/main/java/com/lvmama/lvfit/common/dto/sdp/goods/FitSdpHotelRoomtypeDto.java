package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 酒店房型信息
 * 
 * @author lishuiqing
 * 
 */
public class FitSdpHotelRoomtypeDto implements Serializable {
	private static final long serialVersionUID = 7859865883852602292L;
	private List<FitSdpHotelTimePriceDto> timePrice;
	// 房型id
	private Long roomId;
	// 房型名称
	private String roomName;
	// 酒店id
	private Long hotelId;
	// 酒店name
	private String hotelName;
	// 商品id
	private Long goodsId;
	// 商品名称
	private String goodsName;
	// 商品最低价
	private BigDecimal goodsLowestPrice;
	// 使用人数
	private Long defaultQuantity;
	// 分组关系id
	private Long groupId;
	// 库存。
	private Long stock;
	//是否早餐
    private String breakfast;
    //早餐价格
    private String breakfastAddValue;
	// 保留房标示》N：非保留房，不用验证库存
	private String stockFlag;
	// 总库存
	private Long totalStock;
	// 当前选择branch
	private Long currentProductBranchId;
	// 房型人数
	private Long capacity;
	// 是否有窗
	private String window;
	// 网络
	private String internet;
	// 价格
	private BigDecimal price;
	// 描述信息
	private String description; 
	// 最低价
	private BigDecimal dailyLowestPrice;
	// 床型,
	private String bedType;
	// 是否可以加床*,
	private String addBedFlag;
	// 是否可以取消,
	private String cancelFlag;
	// 是否可以销售,
	private String saleFlag;
	// 最多人数,
	private Long maxVisitor;
	// 面积,
	private String area;
	// 楼层,
	private String floor;
	// 房间描述,
	private String desc;
	// 是否吸烟室,
	private String smokelessRoom;
	// 打包关系id
	private Long detailId;
	// 是否被选中
	private String isBeSelected;
	// 差价
	private BigDecimal diffPrice;  
	// 团期（天数）
    private Long travelDays;
    // 团期（晚）
    private String stayDays; 
    //入住日期
    private String checkIn;
    //退房日期
    private String checkOut; 
    //使用的数量
    private Integer roomCount;
    //最大房间数量.供下拉菜单选择
    private Long maxCount;
    //最少房间数量.供下拉菜单选择
    private Long minCount;  
    
	public Integer getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}

	public String getHotelName() {
		return hotelName;
	} 

	public Long getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(Long maxCount) {
		this.maxCount = maxCount;
	}

	public Long getMinCount() {
		return minCount;
	}

	public void setMinCount(Long minCount) {
		this.minCount = minCount;
	}

	public Long getTravelDays() {
		return travelDays;
	}

	public void setTravelDays(Long travelDays) {
		this.travelDays = travelDays;
	}

	public String getStayDays() {
		return stayDays;
	}

	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
 

	public String getIsBeSelected() {
		return isBeSelected;
	}

	public void setIsBeSelected(String isBeSelected) {
		this.isBeSelected = isBeSelected;
	}

	public BigDecimal getDiffPrice() {
		return diffPrice;
	}

	public void setDiffPrice(BigDecimal diffPrice) {
		this.diffPrice = diffPrice;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getGoodsLowestPrice() {
		return goodsLowestPrice;
	}

	public void setGoodsLowestPrice(BigDecimal goodsLowestPrice) {
		this.goodsLowestPrice = goodsLowestPrice;
	}

	public Long getDefaultQuantity() {
		return defaultQuantity;
	}

	public void setDefaultQuantity(Long defaultQuantity) {
		this.defaultQuantity = defaultQuantity;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getCurrentProductBranchId() {
		return currentProductBranchId;
	}

	public void setCurrentProductBranchId(Long currentProductBranchId) {
		this.currentProductBranchId = currentProductBranchId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Long getCapacity() {
		return capacity;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	} 
	
	public String getBreakfastAddValue() {
		return breakfastAddValue;
	}

	public void setBreakfastAddValue(String breakfastAddValue) {
		this.breakfastAddValue = breakfastAddValue;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 

	public BigDecimal getDailyLowestPrice() {
		return dailyLowestPrice;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getStockFlag() {
		return stockFlag;
	}

	public void setStockFlag(String stockFlag) {
		this.stockFlag = stockFlag;
	}

	public Long getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(Long totalStock) {
		this.totalStock = totalStock;
	}

	public void setDailyLowestPrice(BigDecimal dailyLowestPrice) {
		this.dailyLowestPrice = dailyLowestPrice;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getAddBedFlag() {
		return addBedFlag;
	}

	public void setAddBedFlag(String addBedFlag) {
		this.addBedFlag = addBedFlag;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public List<FitSdpHotelTimePriceDto> getTimePrice() {
		return timePrice;
	}

	public void setTimePrice(List<FitSdpHotelTimePriceDto> timePrice) {
		this.timePrice = timePrice;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getSaleFlag() {
		return saleFlag;
	}

	public void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}

	public Long getMaxVisitor() {
		return maxVisitor;
	}

	public void setMaxVisitor(Long maxVisitor) {
		this.maxVisitor = maxVisitor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSmokelessRoom() {
		return smokelessRoom;
	}

	public void setSmokelessRoom(String smokelessRoom) {
		this.smokelessRoom = smokelessRoom;
	}

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

}
