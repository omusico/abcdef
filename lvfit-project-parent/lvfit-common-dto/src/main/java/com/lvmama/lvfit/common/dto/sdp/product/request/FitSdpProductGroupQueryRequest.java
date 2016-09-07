package com.lvmama.lvfit.common.dto.sdp.product.request;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.utils.DateUtils;

public class FitSdpProductGroupQueryRequest implements Serializable{

	private static final long serialVersionUID = -8550458234831757251L;
	
	/**被打包产品id*/
	private Long packagedProductId;
	
	/**默认取产品90天的低价日历数据 */
	
	/**开始日期*/
	private Date beginDate = new Date();
	
	/**截止日期*/
	private Date endDate = DateUtils.getDateAfterDateDays(beginDate, 90);
	
	// 品类CODE
	private String categoryCode;
	// 打包产品ID
	private Long productId;
	
	public final Date getBeginDate() {
		return beginDate;
	}
	
	public final void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	public final Date getEndDate() {
		return endDate;
	}
	
	public final void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

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
}
