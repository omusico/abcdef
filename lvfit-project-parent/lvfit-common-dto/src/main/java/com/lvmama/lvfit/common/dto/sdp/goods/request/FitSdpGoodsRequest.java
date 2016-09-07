package com.lvmama.lvfit.common.dto.sdp.goods.request;

import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.BookingSource;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品对应的商品查询对象
 * @author leizhengwei
 *
 */
public class FitSdpGoodsRequest implements Serializable {

    private static final long serialVersionUID = 3884841122439907273L;
    
    /***********************************自主打包产品商品信息查询参数*********************************************/
    // 购物车ID
    private String shoppingUuid;
    //自主打包产品Id 
    private Long productId;
    //品类Id
    private Long bizCategoryId;
    //行程开始日期
    private Date departDate;
    // 成人数
    private Long adultQuantity;
    // 儿童数
    private Long childQuantity;
    // 份数
    private Long quantity;
    // 分销ID
    private Long distributorId;
    // 出发地ID
    private Long startDistrictId;
    // 目的地ID
    private Long destDistrictId;
    // 是否为多出发地
    private String isMuiltDeparture;
    //被打包产品的类别id
    private Long packagedProdCatId;
    
    //是否非对接优先，即是否包机优先
    private String isCharterFlightFirst;
    
    /******机票信息查询参数（结合自主打包产品本身交通规则过滤航班）******************/
    //行程天数
    private int routeNum;
    //出发城市code
    private String depCityCode;
    //到达城市code
    private String arvCityCode;

    public String getIsCharterFlightFirst() {
		return isCharterFlightFirst;
	}

	public void setIsCharterFlightFirst(String isCharterFlightFirst) {
		this.isCharterFlightFirst = isCharterFlightFirst;
	}

	public Long getPackagedProdCatId() {
		return packagedProdCatId;
	}

	public void setPackagedProdCatId(Long packagedProdCatId) {
		this.packagedProdCatId = packagedProdCatId;
	}

	private BookingSource bookingSource;

    public String getShoppingUuid() {
        return shoppingUuid;
    }

    public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBizCategoryId() {
        return bizCategoryId;
    }

    public void setBizCategoryId(Long bizCategoryId) {
        this.bizCategoryId = bizCategoryId;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Long getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(Long adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public Long getChildQuantity() {
        return childQuantity;
    }

    public void setChildQuantity(Long childQuantity) {
        this.childQuantity = childQuantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public Long getStartDistrictId() {
        return startDistrictId;
    }

    public void setStartDistrictId(Long startDistrictId) {
        this.startDistrictId = startDistrictId;
    }

    public Long getDestDistrictId() {
        return destDistrictId;
    }

    public void setDestDistrictId(Long destDistrictId) {
        this.destDistrictId = destDistrictId;
    }

    public String getIsMuiltDeparture() {
        return isMuiltDeparture;
    }

    public void setIsMuiltDeparture(String isMuiltDeparture) {
        this.isMuiltDeparture = isMuiltDeparture;
    }

    public int getRouteNum() {
        return routeNum;
    }

    public void setRouteNum(int routeNum) {
        this.routeNum = routeNum;
    }

    public String getDepCityCode() {
        return depCityCode;
    }

    public void setDepCityCode(String depCityCode) {
        this.depCityCode = depCityCode;
    }

    public String getArvCityCode() {
        return arvCityCode;
    }

    public void setArvCityCode(String arvCityCode) {
        this.arvCityCode = arvCityCode;
    }

    public BookingSource getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(BookingSource bookingSource) {
        this.bookingSource = bookingSource;
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.parseDate("2016-08-22").getTime());
    }

}
