package com.lvmama.lvf.common.form.ticket;

import java.util.List;

import com.lvmama.lvf.common.dto.enums.PassengerType;

public class FlightTicketRuleForm {

    /** 乘客类型枚举 */
    private PassengerType passengerType;

    /** 起飞前起飞后等类型 */
    private List<String> heads;

    /** 废票说明 */
    private List<String> vts;

    /** 退票说明 */
    private List<String> rts;

    /** 更改说明 */
    private List<String> cts;

    /** 签转说明 */
    private List<String> mts;

    /** 退改详情 */
    private List<String> ticketRuleDesc;

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public List<String> getHeads() {
        return heads;
    }

    public void setHeads(List<String> heads) {
        this.heads = heads;
    }

    public List<String> getVts() {
        return vts;
    }

    public void setVts(List<String> vts) {
        this.vts = vts;
    }

    public List<String> getRts() {
        return rts;
    }

    public void setRts(List<String> rts) {
        this.rts = rts;
    }

    public List<String> getCts() {
        return cts;
    }

    public void setCts(List<String> cts) {
        this.cts = cts;
    }

    public List<String> getMts() {
        return mts;
    }

    public void setMts(List<String> mts) {
        this.mts = mts;
    }

    public List<String> getTicketRuleDesc() {
        return ticketRuleDesc;
    }

    public void setTicketRuleDesc(List<String> ticketRuleDesc) {
        this.ticketRuleDesc = ticketRuleDesc;
    }
}
