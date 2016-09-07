package com.lvmama.lvfit.common.dto.sdp.product.request;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 自主打包产品低价日历查询条件
 * @author leizhengwei
 *
 */
public class FitSdpProductCalendarRequest  implements Serializable{

	private static final long serialVersionUID = 8965517871220343864L;

	/**自主打包产品Id，用于获取航班筛选规则 */
	private Long productId;
	
	 /**被打包产品Id(用于获取vst产品的起价) */
	private Long packagedProductId;

	/**打包产品品类CODE*/
	private String categoryId;

	/**出发城市code*/
	private String departureCityCode;
	
	/**出发城市code*/
	private String arrivalCityCode;
	
	/**开始日期*/
	private Date beginDate = new Date();
	
	/**截止日期*/
	private Date endDate = DateUtils.getDateAfterDateDays(new Date() ,89);
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPackagedProductId() {
		return packagedProductId;
	}

	public void setPackagedProductId(Long packagedProductId) {
		this.packagedProductId = packagedProductId;
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonIgnore
	public String getGoKey(){
		if(StringUtils.isNotBlank(departureCityCode)&&StringUtils.isNotBlank(arrivalCityCode)){
			return departureCityCode+"_"+arrivalCityCode;
		}
		return null;
	}
	
	@JsonIgnore
	public String getBackKey(){
		if(StringUtils.isNotBlank(departureCityCode)&&StringUtils.isNotBlank(arrivalCityCode)){
			return arrivalCityCode+"_"+departureCityCode;
		}
		return null;
	}
    
	
}
