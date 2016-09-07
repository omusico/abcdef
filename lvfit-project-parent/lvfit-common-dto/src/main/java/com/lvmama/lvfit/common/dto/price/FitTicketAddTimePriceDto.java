package com.lvmama.lvfit.common.dto.price;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.utils.PriceUtil;



public class FitTicketAddTimePriceDto extends FitTicketBaseTimePriceDto{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4433874693558352014L;
	/**
	 * 是否有库存( Y:限制日库存 N:不限日库存)
	 */
	private String stockFlag;
	/**
	 * 结算价
	 */
    private Long settlementPrice;
    /**
     * 市场价
     */
    private Long markerPrice;
    /**
     * 售价
     */
    private BigDecimal price;
    /**
     * 售价模式
     */
    private String priceModel;
    /**
     * 售价模式为溢价时选择加价类型
     */
    private String addType;
    /**
     * 加价数量
     */
    private Long addValue;
    /**
     * 是否可超卖
     */
    private String oversellFlag;
    /**
     * 开始时间
     */
	private Date startDate;
	/**
	 * 结束时间
	 */
	private Date endDate;
	
	/**
	 * 预定限制
	 */
	protected String bookLimitType;
	
   

    public String getStockFlag() {
        return stockFlag;
    }

    public void setStockFlag(String stockFlag) {
        this.stockFlag = stockFlag == null ? null : stockFlag.trim();
    }

  
    public String getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(String priceModel) {
        this.priceModel = priceModel == null ? null : priceModel.trim();
    }

    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType == null ? null : addType.trim();
    }

    public Long getAddValue() {
        return addValue;
    }

    public void setAddValue(Long addValue) {
        this.addValue = addValue;
    }

   

    public String getOversellFlag() {
        return oversellFlag;
    }

    public void setOversellFlag(String oversellFlag) {
        this.oversellFlag = oversellFlag == null ? null : oversellFlag.trim();
    }

      
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	public String getPriceYuan() {
		
		return price.setScale(2).toString();
	}

	public String getMarkerPriceYuan() {
		return PriceUtil.trans2YuanStr(markerPrice);
	}

	public float getSettlementPriceYuan() {
		return PriceUtil.convertToYuan(settlementPrice);
	}

	public float getAddValueYuan() {
		return PriceUtil.convertToYuan(addValue);
	}

	public Long getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(Long settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public Long getMarkerPrice() {
		return markerPrice;
	}

	public void setMarkerPrice(Long markerPrice) {
		this.markerPrice = markerPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getBookLimitType() {
		return bookLimitType;
	}

	public void setBookLimitType(String bookLimitType) {
		this.bookLimitType = bookLimitType;
	}

		

}
