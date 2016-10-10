package com.lvmama.lvfit.common.dto.price;

import java.math.BigDecimal;
import java.util.Date;



public class FitHotelPlanPriceDto extends FitBasePriceDto {
	//毛利率
	public final static  BigDecimal GROSS_PROFIT_RATE = new BigDecimal(0.08);
	//实际销售价格=1+毛利率-优惠率
	public final static  BigDecimal SALE_RATE = new BigDecimal(1.06);
	//优惠利率
	public final static  BigDecimal DISCOUNT_RATE = new BigDecimal(0.02);
	//private long HotelId;//商品ID
	/**
	 * 名义销售价
	 */
	private BigDecimal displaySalesPrice;

	/**
	 * 实际销售价
	 */
	private BigDecimal salesPrice;

	/**
	 * 结算价,不要传到前台去
	 */
	private BigDecimal settlePrice;
	
	/**优惠金额*/
	private BigDecimal promotion;
	
	/**原始销售金额*/
	private BigDecimal originalSalesPrice;

	/**库存数量 */
	private Integer inventoryCount;
	
	/**
	 * 入驻日期范围，对应每天的价格
	 */
	private Date priceEveryDay;

	/**是否可售*/
	private String onsaleFlag;//Y可售N禁售
	
	/**是否在提前预定时间之前*/
	private Boolean isBeforeAheadBookTime;
	
	/**是否过了最晚预定时间*/
	private Boolean isBeforeLastHoldTime;
	
	/**用来判断是否符合最早和最晚预定时间*/
	protected Date specDate;
	
	protected Long aheadBookTime;// 提前预定时间
	
	private Long latestHoldTime;// 最晚预定时间
	
	private String stockStatus;// 房态
	
	private String freeSaleFlag;//freeSale
	
	private String stockFlag ;//是否保留库存（是否是非保留房）
	
	private Integer breakfast;// 早餐
	
	/**
	 * 是否可超卖
	 */
    private String oversellFlag;
    
    /**预定限制*/
	private String bookLimitType;
	/**
	 * salesPrice.
	 *
	 * @return  the salesPrice
	 * @since   JDK 1.6
	 */
	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	/**
	 * salesPrice.
	 *
	 * @param   salesPrice    the salesPrice to set
	 * @since   JDK 1.6
	 */
	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	/**
	 * settlePrice.
	 *
	 * @return  the settlePrice
	 * @since   JDK 1.6
	 */
	public BigDecimal getSettlePrice() {
		return settlePrice;
	}

	/**
	 * settlePrice.
	 *
	 * @param   settlePrice    the settlePrice to set
	 * @since   JDK 1.6
	 */
	public void setSettlePrice(BigDecimal settlePrice) {
		this.settlePrice = settlePrice;
	}

	/**
	 * promotion.
	 *
	 * @return  the promotion
	 * @since   JDK 1.6
	 */
	public BigDecimal getPromotion() {
		return promotion;
	}

	/**
	 * promotion.
	 *
	 * @param   promotion    the promotion to set
	 * @since   JDK 1.6
	 */
	public void setPromotion(BigDecimal promotion) {
		this.promotion = promotion;
	}

	/**
	 * originalSalesPrice.
	 *
	 * @return  the originalSalesPrice
	 * @since   JDK 1.6
	 */
	public BigDecimal getOriginalSalesPrice() {
		return originalSalesPrice;
	}

	/**
	 * originalSalesPrice.
	 *
	 * @param   originalSalesPrice    the originalSalesPrice to set
	 * @since   JDK 1.6
	 */
	public void setOriginalSalesPrice(BigDecimal originalSalesPrice) {
		this.originalSalesPrice = originalSalesPrice;
	}

	/**
	 * inventoryCount.
	 *
	 * @return  the inventoryCount
	 * @since   JDK 1.6
	 */
	public Integer getInventoryCount() {
		return inventoryCount;
	}

	/**
	 * inventoryCount.
	 *
	 * @param   inventoryCount    the inventoryCount to set
	 * @since   JDK 1.6
	 */
	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
	
	

/*	public long getHotelId() {
		return HotelId;
	}

	public void setHotelId(long hotelId) {
		HotelId = hotelId;
	}*/

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FitHotelPlanPriceDto [displaySalesPrice=" + displaySalesPrice + ", salesPrice=" + salesPrice + ", settlePrice=" + settlePrice + ", promotion=" + promotion + ", originalSalesPrice="
				+ originalSalesPrice + ", inventoryCount=" + inventoryCount + "]";
	}

	public BigDecimal getDisplaySalesPrice() {
		return displaySalesPrice;
	}

	public void setDisplaySalesPrice(BigDecimal displaySalesPrice) {
		this.displaySalesPrice = displaySalesPrice;
	}

	public Date getPriceEveryDay() {
		return priceEveryDay;
	}

	public void setPriceEveryDay(Date priceEveryDay) {
		this.priceEveryDay = priceEveryDay;
	}

	public String getOnsaleFlag() {
		return onsaleFlag;
	}

	public void setOnsaleFlag(String onsaleFlag) {
		this.onsaleFlag = onsaleFlag;
	}

	public Boolean getIsBeforeAheadBookTime() {
		return isBeforeAheadBookTime;
	}

	public void setIsBeforeAheadBookTime(Boolean isBeforeAheadBookTime) {
		this.isBeforeAheadBookTime = isBeforeAheadBookTime;
	}

	public Boolean getIsBeforeLastHoldTime() {
		return isBeforeLastHoldTime;
	}

	public void setIsBeforeLastHoldTime(Boolean isBeforeLastHoldTime) {
		this.isBeforeLastHoldTime = isBeforeLastHoldTime;
	}

	public Date getSpecDate() {
		return specDate;
	}

	public void setSpecDate(Date specDate) {
		this.specDate = specDate;
	}

	public Long getAheadBookTime() {
		return aheadBookTime;
	}

	public void setAheadBookTime(Long aheadBookTime) {
		this.aheadBookTime = aheadBookTime;
	}

	public Long getLatestHoldTime() {
		return latestHoldTime;
	}

	public void setLatestHoldTime(Long latestHoldTime) {
		this.latestHoldTime = latestHoldTime;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getFreeSaleFlag() {
		return freeSaleFlag;
	}

	public void setFreeSaleFlag(String freeSaleFlag) {
		this.freeSaleFlag = freeSaleFlag;
	}

	public String getStockFlag() {
		return stockFlag;
	}

	public void setStockFlag(String stockFlag) {
		this.stockFlag = stockFlag;
	}

	public String getOversellFlag() {
		return oversellFlag;
	}

	public void setOversellFlag(String oversellFlag) {
		this.oversellFlag = oversellFlag;
	}	
	
	// 房态
	public static enum STOCKSTATUS {

		FULL("满房"), LESS("紧张"), NORMAL("正常");

		private String cnName;

		public static String getCnName(String code) {
			for (STOCKSTATUS item : STOCKSTATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		STOCKSTATUS(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public Integer getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Integer breakfast) {
		this.breakfast = breakfast;
	}

	public String getBookLimitType() {
		return bookLimitType;
	}

	public void setBookLimitType(String bookLimitType) {
		this.bookLimitType = bookLimitType;
	}
	
}
