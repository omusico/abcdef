package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.enums.CreatePNR;
import com.lvmama.lvf.common.dto.enums.NeedSwitchSeat;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.md.TimeRange;

/**
 * 机票特殊政策基本信息
 * 
 * @author yuanweihong
 * @date   2015-1-14
 */
@XmlRootElement
public class FlightPolicySpecDto implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 5945028802961087258L;
	
	/** 是否换舱出票枚举 */
	private NeedSwitchSeat needSwitchSeat;
	
	/** PNR枚举 */
	private CreatePNR createPNR;
	
	/** 提前出票 */
	private Integer preTicketHours;
	
	/** 预计申请时间 */
	private Integer applySpeedMinutes;
	
	/** 开始结束时间 */
	private TimeRange applyTimeRange;
	
	/** 价格公式信息 */
	private PriceFormula specPolicyPrice;
	
	public NeedSwitchSeat getNeedSwitchSeat() {
		return needSwitchSeat;
	}
	public void setNeedSwitchSeat(NeedSwitchSeat needSwitchSeat) {
		this.needSwitchSeat = needSwitchSeat;
	}
	public CreatePNR getCreatePNR() {
		return createPNR;
	}
	public void setCreatePNR(CreatePNR createPNR) {
		this.createPNR = createPNR;
	}
	public Integer getPreTicketHours() {
		return preTicketHours;
	}
	public void setPreTicketHours(Integer preTicketHours) {
		this.preTicketHours = preTicketHours;
	}
	public Integer getApplySpeedMinutes() {
		return applySpeedMinutes;
	}
	public void setApplySpeedMinutes(Integer applySpeedMinutes) {
		this.applySpeedMinutes = applySpeedMinutes;
	}
	public TimeRange getApplyTimeRange() {
		return applyTimeRange;
	}
	public void setApplyTimeRange(TimeRange applyTimeRange) {
		this.applyTimeRange = applyTimeRange;
	}
	public PriceFormula getSpecPolicyPrice() {
		return specPolicyPrice;
	}
	public void setSpecPolicyPrice(PriceFormula specPolicyPrice) {
		this.specPolicyPrice = specPolicyPrice;
	}
	
	
	
}
