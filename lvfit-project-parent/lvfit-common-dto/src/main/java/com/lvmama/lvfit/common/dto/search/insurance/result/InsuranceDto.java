package com.lvmama.lvfit.common.dto.search.insurance.result;

import java.io.Serializable;
import java.util.List;

/**
 * 保险搜索相关 对象
 * @author wanghuihui
 * @date:2016年2月22日 下午6:07:47
 */
public class InsuranceDto implements Serializable {
	private static final long serialVersionUID = -6748683994513978578L;
	/** 产品ID **/
	private Long productId;	
	private String reType;  //保险类型
	private Long reBranchId;
	List<InsuranceProdProduct> insuranceProductList ;
	
	public final Long getProductId() {
		return productId;
	}
	public final void setProductId(Long productId) {
		this.productId = productId;
	}
	public final String getReType() {
		return reType;
	}
	public final void setReType(String reType) {
		this.reType = reType;
	}
	public final Long getReBranchId() {
		return reBranchId;
	}
	public final void setReBranchId(Long reBranchId) {
		this.reBranchId = reBranchId;
	}
	public final List<InsuranceProdProduct> getInsuranceProductList() {
		return insuranceProductList;
	}
	public final void setInsuranceProductList(
			List<InsuranceProdProduct> insuranceProductList) {
		this.insuranceProductList = insuranceProductList;
	}
}
