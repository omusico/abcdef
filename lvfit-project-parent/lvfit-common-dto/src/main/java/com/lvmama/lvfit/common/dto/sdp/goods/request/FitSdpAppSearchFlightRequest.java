package com.lvmama.lvfit.common.dto.sdp.goods.request;

import java.io.Serializable;
import java.util.Date;

public class FitSdpAppSearchFlightRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3322799904010786857L;
	
	 //自主打包产品Id 
    private Long productId;
    //行程开始日期
    private Date departDate;
    // 成人数
    private Long adultQuantity;
    // 儿童数
    private Long childQuantity;
    // 份数
    private Long quantity;
    
    /******机票信息查询参数（结合自主打包产品本身交通规则过滤航班）******************/
    //行程天数
    private int routeNum;
    //出发城市code
    private String depCityCode;
    //到达城市code
    private String arvCityCode;
    
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
