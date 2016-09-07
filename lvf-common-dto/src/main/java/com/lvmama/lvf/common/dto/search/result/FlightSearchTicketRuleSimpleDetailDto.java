package com.lvmama.lvf.common.dto.search.result;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.dto.enums.RuleType;


public class FlightSearchTicketRuleSimpleDetailDto {
	

	/** detailFeeType like VT("废票"),RT("退票"),MT("签转"),CT("改期");*/
	private String detailFeeType;
	
	/** detailFeeTypeName 类型名称*/
	private String detailFeeTypeName;
	
	/**详细费用描述 */
	private String detailFeeDesc;

	public String getDetailFeeType() {
		return detailFeeType;
	}

	public void setDetailFeeType(String detailFeeType) {
		this.detailFeeType = detailFeeType;
	}
	
	public String getDetailFeeTypeName() {
		if(StringUtils.isNotBlank(this.getDetailFeeType())){
			return RuleType.getRuleTypeKey(RuleType.valueOf(this.getDetailFeeType()));
		}
		return detailFeeTypeName;
	}

	public void setDetailFeeTypeName(String detailFeeTypeName) {
		this.detailFeeTypeName = detailFeeTypeName;
	}

	public String getDetailFeeDesc() {
		return detailFeeDesc;
	}

	public void setDetailFeeDesc(String detailFeeDesc) {
		this.detailFeeDesc = detailFeeDesc;
	}
	
	 
	
}
