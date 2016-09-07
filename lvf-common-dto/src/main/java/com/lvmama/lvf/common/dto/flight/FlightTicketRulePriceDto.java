package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.RefundEndorseType;
import com.lvmama.lvf.common.dto.flight.FlightRefundEndorseRuleDto;

/**
 * 航班退改签费用
 * @author zengzhimin
 * @date 2016-01-18
 */
@XmlRootElement
public class FlightTicketRulePriceDto extends Entity implements Serializable
{
	private static final long serialVersionUID = -1032049546008855213L;
    
	/** 退改签规则*/
	//private FlightRefundEndorseRuleDto flightRefundEndorseRuleDto;
	/**退票或改签费用**/
	private String feeAmount;
	/**起飞时间**/
	private String beginHour;
	/**是否起飞前:true:起飞前 false:起飞后**/
	private Boolean endHourFlag;
	/**费率**/
	private String feeRate;
	/**改签或退票类型**/
	private RefundEndorseType type;
	public String getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}
	public String getBeginHour() {
		return beginHour;
	}
	public void setBeginHour(String beginHour) {
		this.beginHour = beginHour;
	}
	public Boolean getEndHourFlag() {
		return endHourFlag;
	}
	public void setEndHourFlag(Boolean endHourFlag) {
		this.endHourFlag = endHourFlag;
	}
	public String getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}
	public RefundEndorseType getType() {
		return type;
	}
	public void setType(RefundEndorseType type) {
		this.type = type;
	}
//	public FlightRefundEndorseRuleDto getFlightRefundEndorseRuleDto() {
//		return flightRefundEndorseRuleDto;
//	}
//	public void setFlightRefundEndorseRuleDto(
//			FlightRefundEndorseRuleDto flightRefundEndorseRuleDto) {
//		this.flightRefundEndorseRuleDto = flightRefundEndorseRuleDto;
//	}
	//退改签费描述
	public String convertRefundEndorseFeeDesc(String type){
		if(getType() == RefundEndorseType.REFUND && "RT".equals(type)){
			if(getEndHourFlag()){
				if(!"0".equals(beginHour)){
					return " 起飞前"+beginHour+"小时以外收取:"+feeAmount+"元。";
				}
				if("0".equals(beginHour)){
					return " 起飞前收取:"+feeAmount+"元。";
				}
				
			}else{
				if(!"0".equals(beginHour)){
					return " 起飞前"+beginHour+"小时以内(含)收取:"+feeAmount+"元。";
				}
				if("0".equals(beginHour)){
					return " 起飞后收取:"+feeAmount+"元。";
				}
			}
		}
		if(getType() == RefundEndorseType.ENDORSE && "CT".equals(type)){
			if(getEndHourFlag()){
				if(!"0".equals(beginHour)){
					return " 起飞前"+beginHour+"小时以外收取:"+feeAmount+"元。";
				}
				if("0".equals(beginHour)){
					return " 起飞前收取:"+feeAmount+"元。";
				}
				
			}else{
				if(!"0".equals(beginHour)){
					return " 起飞前"+beginHour+"小时以内(含)收取:"+feeAmount+"元。";
				}
				if("0".equals(beginHour)){
					return " 起飞后收取:"+feeAmount+"元。";
				}
				
			}
		}
		return "";
	}
	
	
}
