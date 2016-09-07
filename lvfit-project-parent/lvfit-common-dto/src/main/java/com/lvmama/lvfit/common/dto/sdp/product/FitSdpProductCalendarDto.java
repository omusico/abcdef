package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FitSdpProductCalendarDto implements Serializable{

	private static final long serialVersionUID = -8453333824669985356L;

	private Long groupDateId;

	/**
	 * 产品ID
	 */
    private Long productId;

    /**
     * 团期日期
     */
    private Date specDate;

    /**
     * 团期名称
     */
    private String groupName;
    
    /**
     * 剩余库存
     */
    private Long stock;
    
    /**
     * 最低销售起价
     */
    private BigDecimal lowestSaledPrice;
    
    /**
     * 儿童价
     */
    private BigDecimal lowestSaledChildPrice;
    
    /**
     * 市场价
     */
    private BigDecimal marketPrice;
    
    /**
     *  出发日期
     */
    private String departureDate;
    
    
    /**
     * 适用渠道集合
     */
    private String distributorName;
    
    /**
     * 提前预定时间
     */
    private Long aheadBookTime;
    
    /**
     * 所属行程
     */
    private Long  lineRouteId;
    
    
    /**
     * 显示方式
     */
    private String displayType = "";

    /**
     * 是否限制日库存
     */
    private String stockFlag;

    /**
     * 是否可超卖
     */
    private String oversellFlag;
    
    // 日期（不含年份）
    private String monthAndDay;
    // 星期几
    private String dayOfWeek;

	public final Long getGroupDateId() {
		return groupDateId;
	}

	public final void setGroupDateId(Long groupDateId) {
		this.groupDateId = groupDateId;
	}

	public final Long getProductId() {
		return productId;
	}

	public final void setProductId(Long productId) {
		this.productId = productId;
	}

	public final Date getSpecDate() {
		return specDate;
	}

	public final void setSpecDate(Date specDate) {
		this.specDate = specDate;
	}

	public final String getGroupName() {
		return groupName;
	}

	public final void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public final Long getStock() {
		return stock;
	}

	public final void setStock(Long stock) {
		this.stock = stock;
	}

	public final BigDecimal getLowestSaledPrice() {
		return lowestSaledPrice;
	}

	public final void setLowestSaledPrice(BigDecimal lowestSaledPrice) {
		this.lowestSaledPrice = lowestSaledPrice;
	}

	public final BigDecimal getLowestSaledChildPrice() {
		return lowestSaledChildPrice;
	}

	public final void setLowestSaledChildPrice(BigDecimal lowestSaledChildPrice) {
		this.lowestSaledChildPrice = lowestSaledChildPrice;
	}

	public final BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public final void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public final String getDepartureDate() {
		return departureDate;
	}

	public final void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public final String getDistributorName() {
		return distributorName;
	}

	public final void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public final Long getAheadBookTime() {
		return aheadBookTime;
	}

	public final void setAheadBookTime(Long aheadBookTime) {
		this.aheadBookTime = aheadBookTime;
	}

	public final Long getLineRouteId() {
		return lineRouteId;
	}

	public final void setLineRouteId(Long lineRouteId) {
		this.lineRouteId = lineRouteId;
	}

	public final String getDisplayType() {
		return displayType;
	}

	public final void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public final String getStockFlag() {
		return stockFlag;
	}

	public final void setStockFlag(String stockFlag) {
		this.stockFlag = stockFlag;
	}

	public final String getOversellFlag() {
		return oversellFlag;
	}

	public final void setOversellFlag(String oversellFlag) {
		this.oversellFlag = oversellFlag;
	}

    public String getMonthAndDay() {
        return monthAndDay;
    }

    public void setMonthAndDay(String monthAndDay) {
        this.monthAndDay = monthAndDay;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
