package com.lvmama.lvf.common.form.md;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.SeatClassStatus;
import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.dto.md.SeatClass;
import com.lvmama.lvf.common.dto.request.SeatRuleRequest;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class SeatForm implements Serializable,Form {

    private static final long serialVersionUID = -6630756527609337957L;
    
    private SeatClass seatClass=new SeatClass();
    
    private String seatClassTypeCnName;
    
    private String seatClassStatusCnName;
    
    private List<SeatRuleRequest> seatRuleRequests=new ArrayList<SeatRuleRequest>();

    public List<SeatRuleRequest> getSeatRuleRequests() {
        return seatRuleRequests;
    }

    public void setSeatRuleRequests(List<SeatRuleRequest> seatRuleRequests) {
        this.seatRuleRequests = seatRuleRequests;
    }

    public SeatForm(){
        
    }
    
    public SeatForm(SeatClass seatClass) {
        super();
        this.seatClass = seatClass;
    }
    
    public SeatClass getSeatClassCarrier() {
        return seatClass;
    }

    public void setSeatClassCarrier(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public String getSeatClassTypeCnName() {
        if(seatClass.getSeatClassType() != null)
        {
            return seatClass.getSeatClassType().getCnName();
        }   
        return seatClassTypeCnName;
    }

    public void setSeatClassTypeCnName(String seatClassTypeCnName) {
        this.seatClassTypeCnName = seatClassTypeCnName;
    }
    
    public String getSeatClassStatusCnName() {
        if(seatClass.getSeatClassStatus() != null){
            return seatClass.getSeatClassStatus().getCnName();
        } else {
            return "";
        }
    }

    public void setSeatClassStatusCnName(String seatClassStatusCnName) {
        this.seatClassStatusCnName = seatClassStatusCnName;
    }
    
    public SeatClassStatus getSeatClassStatus() {
        return seatClass.getSeatClassStatus();
    }

    public void setSeatClassStatus(SeatClassStatus seatClassStatus) {
        this.seatClass.setSeatClassStatus(seatClassStatus);
    }
    public String getPolicyExpDate() {
        
        return DateUtils.formatDateByFormat(this.seatClass.getPolicyExpDate(),DateUtils.YYYY_MM_DD);
    }
    public void setPolicyExpDate(Date policyExpDate) {
        this.seatClass.setPolicyExpDate(policyExpDate);
    }

    public String getTravelExpDate() {
        return DateUtils.formatDateByFormat(this.seatClass.getTravelExpDate(),DateUtils.YYYY_MM_DD);
    }

    public void setTravelExpDate(Date travelExpDate) {
        this.seatClass.setTravelExpDate(travelExpDate);
    }
    
    public void setId(Long id){
        this.seatClass.setId(id);
    }
    
    public Long getId(){
        return seatClass.getId();
    }
    
    public String getName() {
        return seatClass.getName();
    }
    public void setName(String name) {
        this.seatClass.setName(name);
    }
    public String getCode() {
        return seatClass.getCode();
    }
    public void setCode(String code) {
        this.seatClass.setCode(code);
    }
    public SeatClassType getSeatClassType() {
        return seatClass.getSeatClassType();
    }

    public void setSeatClassType(SeatClassType seatClassType) {
        this.seatClass.setSeatClassType(seatClassType);
    }

    public String getCarrierCode() {
        return seatClass.getCarrierCode();
    }

    public void setCarrierCode(String carrierCode) {
        this.seatClass.setCarrierCode(carrierCode);
    }

    public String getTicketRule() {
        return seatClass.getTicketRule();
    }

    public void setTicketRule(String ticketRule) {
        this.seatClass.setTicketRule(ticketRule);
    }

    public String getSeatRemark() {
        return seatClass.getSeatRemark();
    }

    public void setSeatRemark(String seatRemark) {
        this.seatClass.setSeatRemark(seatRemark);
    }

    
    public FlightTicketPriceDto getFlightTicketPriceDto() {
        return seatClass.getFlightTicketPriceDto();
    }

    public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
        this.seatClass.setFlightTicketPriceDto(flightTicketPriceDto);
    }

    //新增字段
    /*public SeatClassStatus getSeatClassStatus() {
        return this.seatClass.getSeatClassStatus();
    }

    public void setSeatClassStatus(SeatClassStatus seatClassStatus) {
        this.seatClass.setSeatClassStatus(seatClassStatus);
    }*/
    
    public Integer getHot() {
        return seatClass.getHot();
    }

    public void setHot(Integer hot) {
        seatClass.setHot(hot);
    }
    
    public String getChdSeatClassCode() {
        return this.seatClass.getChdSeatClassCode();
    }
    
    public void setChdSeatClassCode(String chdSeatClassCode) {
        this.seatClass.setChdSeatClassCode(chdSeatClassCode);
    }
    
	public String getPolicyValidDate() {
		return DateUtils.formatDateByFormat(seatClass.getPolicyValidDate(),DateUtils.YYYY_MM_DD);
	}

	public void setPolicyValidDate(Date policyValidDate) {
		seatClass.setPolicyValidDate(policyValidDate);
	}

	public String getTravelValidDate() {
		return DateUtils.formatDateByFormat(this.seatClass.getTravelValidDate(),DateUtils.YYYY_MM_DD);
	}

	public void setTravelValidDate(Date travelValidDate) {
		seatClass.setTravelValidDate(travelValidDate);
	}
}
