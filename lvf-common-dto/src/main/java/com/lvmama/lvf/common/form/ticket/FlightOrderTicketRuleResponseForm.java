package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.util.List;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.policy.FlightPolicyRemarkDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchTicketRuleSimpleDetailDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchTicketRuleSimpleDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 申请页面订单退改签规定Form
 * 
 * @author yuanweihong
 * @date 2015-4-27
 */
public class FlightOrderTicketRuleResponseForm implements Serializable, Form {

    private static final long serialVersionUID = -4032791793413057264L;

    /** 退改签规则信息 */
    private FlightSearchTicketRuleSimpleDto flightSearchTicketRuleSimple;

    /** 政策备注信息 */
    private FlightPolicyRemarkDto flightPolicyRemark;

    public FlightOrderTicketRuleResponseForm() {
        super();
    }

    public FlightOrderTicketRuleResponseForm(FlightSearchTicketRuleSimpleDto flightSearchTicketRuleSimple, FlightPolicyRemarkDto flightPolicyRemark) {
        super();
        this.flightSearchTicketRuleSimple = flightSearchTicketRuleSimple;
        this.flightPolicyRemark = flightPolicyRemark;
    }

    public FlightPolicyRemarkDto getFlightPolicyRemark() {
        return flightPolicyRemark;
    }

    public void setFlightPolicyRemark(FlightPolicyRemarkDto flightPolicyRemark) {
        this.flightPolicyRemark = flightPolicyRemark;
    }

    public String getSuppRemark() {
        return flightPolicyRemark.getSuppRemark();
    }

    public void setSuppRemark(String suppRemark) {
        flightPolicyRemark.setSuppRemark(suppRemark);
    }

    public FlightSearchTicketRuleSimpleDto getFlightSearchTicketRuleSimple() {
        return flightSearchTicketRuleSimple;
    }

    public void setFlightSearchTicketRuleSimple(
            FlightSearchTicketRuleSimpleDto flightSearchTicketRuleSimple) {
        this.flightSearchTicketRuleSimple = flightSearchTicketRuleSimple;
    }

    public PassengerType getPassengerType() {
        return flightSearchTicketRuleSimple.getPassengerType();
    }

    public void setPassengerType(PassengerType passengerType) {
        flightSearchTicketRuleSimple.setPassengerType(passengerType);
    }

    public List<FlightSearchTicketRuleSimpleDetailDto> getSimpleDetails() {
        return flightSearchTicketRuleSimple.getSimpleDetails();
    }

    public void setSimpleDetails(List<FlightSearchTicketRuleSimpleDetailDto> simpleDetails) {
        flightSearchTicketRuleSimple.setSimpleDetails(simpleDetails);
    }

    public String getRemark() {
        return flightSearchTicketRuleSimple.getRemark();
    }

    public void setRemark(String remark) {
        flightSearchTicketRuleSimple.setRemark(remark);
    }

    public String getAdditionalRemark() {
        return flightSearchTicketRuleSimple.getAdditionalRemark();
    }

    public void setAdditionalRemark(String additionalRemark) {
        flightSearchTicketRuleSimple.setAdditionalRemark(additionalRemark);
    }

    public String getPassengerTypeName() {
        return flightSearchTicketRuleSimple.getPassengerTypeName();
    }

    public void setPassengerTypeName(String passengerTypeName) {
        flightSearchTicketRuleSimple.setPassengerTypeName(passengerTypeName);
    }

}
