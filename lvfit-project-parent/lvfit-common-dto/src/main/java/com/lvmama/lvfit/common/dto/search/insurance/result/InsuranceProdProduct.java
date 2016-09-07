package com.lvmama.lvfit.common.dto.search.insurance.result;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.InsuranceType;

/**
 * 保险搜索相关 对象
 * @author wanghuihui
 * @date:2016年2月22日 下午6:07:47
 */
public class InsuranceProdProduct implements Serializable {
	private static final long serialVersionUID = -6748683994513978578L;
	private Long productId;
	private Long attributionId;
	private String attributionName;
	private String productName;
	private String cancelFlag;
	private String saleFlag;
	private Long recommendLevel;
	private Long bizCategoryId;
	private Map<String, Object> propValue ;
	/** 一个产品对应多个规格   **/
	private List<InsuranceProdProductBranch> insuranceProductBranchList ;
	
	private Long insuranceType;
	
	private int insuranceCount = 0;
	
	public final Long getProductId() {
		return productId;
	}

	public final void setProductId(Long productId) {
		this.productId = productId;
	}

	public final Long getAttributionId() {
		return attributionId;
	}

	public final void setAttributionId(Long attributionId) {
		this.attributionId = attributionId;
	}

	public final String getAttributionName() {
		return attributionName;
	}

	public final void setAttributionName(String attributionName) {
		this.attributionName = attributionName;
	}

	public final String getProductName() {
		return productName;
	}

	public final void setProductName(String productName) {
		this.productName = productName;
	}

	public final String getCancelFlag() {
		return cancelFlag;
	}

	public final void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public final String getSaleFlag() {
		return saleFlag;
	}

	public final void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}

	public final Long getRecommendLevel() {
		return recommendLevel;
	}

	public final void setRecommendLevel(Long recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	public final Long getBizCategoryId() {
		return bizCategoryId;
	}

	public final void setBizCategoryId(Long bizCategoryId) {
		this.bizCategoryId = bizCategoryId;
	}

	public final Map<String, Object> getPropValue() {
		return propValue;
	}

	public final void setPropValue(Map<String, Object> propValue) {
		this.propValue = propValue;
	}

	public final List<InsuranceProdProductBranch> getInsuranceProductBranchList() {
		return insuranceProductBranchList;
	}

	public final void setInsuranceProductBranchList(
			List<InsuranceProdProductBranch> insuranceProductBranchList) {
		this.insuranceProductBranchList = insuranceProductBranchList;
	}
	
    public int getInsuranceCount() {
        return insuranceCount;
    }

    public void setInsuranceCount(int insuranceCount) {
        this.insuranceCount = insuranceCount;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((propValue == null) ? 0 : propValue.get("insurance_type").hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		InsuranceProdProduct other = (InsuranceProdProduct) obj;
		if (propValue == null) {
			if (other.propValue != null)
				return false;
		} else{
			List<Map<String,Object>> object = (List<Map<String, Object>>) propValue.get("insurance_type");
			List<Map<String,Object>> object2 = (List<Map<String, Object>>) other.propValue.get("insurance_type");
			if(!object.get(0).get("id").equals(object2.get(0).get("id"))&&object.get(0).get("name").equals(object2.get(0).get("name"))){
				return false;
			}
		}
		return true;
	}

	public final Long getInsuranceType() {
		Object o = this.propValue.get("insurance_type");
	    try {
	        String json = JSONMapper.getInstance().writeValueAsString(o);
            InsuranceType insurance =JSONMapper.getInstance().readValue(json, InsuranceType[].class)[0];
            String id = insurance.getId();
            insuranceType = Long.valueOf(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return insuranceType;
	}

	public final void setInsuranceType(Long insuranceType) {
		
	    this.insuranceType = insuranceType;
	}

}
