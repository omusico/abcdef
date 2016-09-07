package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.dto.enums.InventoryType;
import com.lvmama.lvf.common.dto.policy.FlightPolicyDto;
import com.lvmama.lvf.common.dto.supp.Supp;
import com.lvmama.lvf.common.dto.ticket.FlightTicketRuleDto;
import com.lvmama.lvf.common.utils.DateUtils;

@XmlRootElement
public class FlightSeatInventoryDto extends AEEntity implements Serializable {
	
	private static final long serialVersionUID = -6439055866359379904L;
	
	@FkId
	/**座位信息 */
	private FlightSeatDto flightSeat;
	
	/** 每日航班信息：1对多 */
	@FkId
	private FlightInfoDailyDto flightInfoDaily;
	
	@FkId
	/**供应商信息 */
	private Supp supp;
	
	@FkId
	/**供应商政策ID */
	private String suppPolicyId;

	@FkId
	/**政策ID */
	private Long policyId;
	
	/**库存类型 */
	private InventoryType inventoryType;
	
	/**库存状态 */
	private InventoryStatus inventoryStatus;
	
	/**库存数量 */
	private Integer inventoryCount;
	
	/**政策信息 */
	private FlightPolicyDto flightPolicy; 
	
	/**客规信息（包括成人、儿童、婴儿） */
	private  List<FlightTicketRuleDto> flightTicketRules = new ArrayList<FlightTicketRuleDto>();
	
	private String md5Sign;
	

	
	
	
	
	public Long getDepartureDate() 
	{
		if(this.flightInfoDaily != null && this.flightInfoDaily.getTimeSegmentRange() != null)
		{
			return this.flightInfoDaily.getTimeSegmentRange().getDepartureDate();
		}
		return null;
	}
	
	public void setDepartureTime(Date DepartureTime){}
	
	public Date getDepartureTime() {
		if(null!=flightInfoDaily
				&& null!=flightInfoDaily.getTimeSegmentRange()
				&& null!=flightInfoDaily.getTimeSegmentRange().getDepartureTime()){
			return flightInfoDaily.getTimeSegmentRange().getDepartureTime();
		}
		return null;
	}
	
	public void setArrivalTime(Date ArrivalTime){}
	
	public Date getArrivalTime() {
		if(null!=flightInfoDaily
				&& null!=flightInfoDaily.getTimeSegmentRange()
				&& null!=flightInfoDaily.getTimeSegmentRange().getArrivalTime()){
			return flightInfoDaily.getTimeSegmentRange().getArrivalTime();
		}
		return null;
	}

	
	
	


	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public FlightSeatDto getFlightSeat() {
		return flightSeat;
	}

	public void setFlightSeat(FlightSeatDto flightSeat) {
		this.flightSeat = flightSeat;
	}

	public FlightInfoDailyDto getFlightInfoDaily() {
		return flightInfoDaily;
	}

	public void setFlightInfoDaily(FlightInfoDailyDto flightInfoDaily) {
		this.flightInfoDaily = flightInfoDaily;
	}

	public Supp getSupp() {
		return supp;
	}

	public void setSupp(Supp supp) {
		this.supp = supp;
	}

	public String getSuppPolicyId() {
		return suppPolicyId;
	}

	public void setSuppPolicyId(String suppPolicyId) {
		this.suppPolicyId = suppPolicyId;
	}

	public InventoryType getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(InventoryType inventoryType) {
		this.inventoryType = inventoryType;
	}

	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public Integer getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	public FlightPolicyDto getFlightPolicy() {
		return flightPolicy;
	}

	public void setFlightPolicy(FlightPolicyDto flightPolicy) {
		this.flightPolicy = flightPolicy;
	}

	public List<FlightTicketRuleDto> getFlightTicketRules() {
		return flightTicketRules;
	}

	public void setFlightTicketRules(List<FlightTicketRuleDto> flightTicketRules) {
		this.flightTicketRules = flightTicketRules;
	}

	public String getMd5Sign() {
		return md5Sign;
	}

	public void setMd5Sign(String md5Sign) {
		this.md5Sign = md5Sign;
	}
	
}
