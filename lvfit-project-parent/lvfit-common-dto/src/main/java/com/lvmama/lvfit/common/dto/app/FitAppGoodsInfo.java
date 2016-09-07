package com.lvmama.lvfit.common.dto.app;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;

/**
 * Created by leizhengwei
 * 2016/7/14
 * 0:36
 */
public class FitAppGoodsInfo implements Serializable {


    private static final long serialVersionUID = 3474029558615403646L;


    private String goodsId;

    /**商品价格（注：对于酒店套餐和当地游为份数总价） */
    private BigDecimal price;

    /**选中的份数 */
    private int count;
    
    /**访问日期 */
    private String visitDate;

    private FitAppHotelRequest appHotelRequest;


    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public FitAppHotelRequest getAppHotelRequest() {
        return appHotelRequest;
    }

    public void setAppHotelRequest(FitAppHotelRequest appHotelRequest) {
        this.appHotelRequest = appHotelRequest;
    }

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
}
