package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;

@XmlRootElement
public class FlightPolicyRuleDto extends AEEntity implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 364839302958885807L;

    /** 政策表主键Id */
    private Long policyId;

    /** 是否出发机场 */
    private Boolean allDepartureAirport;

    /** 是否到达机场 */
    private Boolean allArrivalAirport;

    /** 出发机场 */
    private String includeDepartureAirports;

    /** 到达机场 */
    private String includeArrivalAirports;

    /** 航线 */
    private String includeAirLines;

    /** 出发机场不适用 */
    private String excludeDepartureAirports;

    /** 到达机场不适用 */
    private String excludeArrivalAirports;

    /** 航线 不适用 */
    private String excludeAirLines;

    /** 是否出发航班 */
    private Boolean allDepartureFlightNo;

    /** 是否到达航班 */
    private Boolean allArrivalFlightNo;

    /** 适用的航班 */
    private String cludeFlightNo;

    /** 适用的航班2 */
    private String cludeFlightNo2;

    /** 适用的航班3 */
    private String cludeFlightNo3;

    /** 不适用的航班 */
    private String excludeFlightNo;

    /** 不适用的航班2 */
    private String excludeFlightNo2;

    /** 不适用的航班3 */
    private String excludeFlightNo3;

    /** 出发舱位 */
    private String departureSeats;

    /** 到达舱位 */
    private String arrivalSeats;

    /** 航班开始日期 */
    private String departureWeekDays;

    /** 航班结束日期 */
    private String arrivalWeekDays;

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getIncludeAirLines() {
        return includeAirLines;
    }

    public void setIncludeAirLines(String includeAirLines) {
        this.includeAirLines = includeAirLines;
    }

    public String getExcludeAirLines() {
        return excludeAirLines;
    }

    public void setExcludeAirLines(String excludeAirLines) {
        this.excludeAirLines = excludeAirLines;
    }

    public String getExcludeDepartureAirports() {
        return excludeDepartureAirports;
    }

    public void setExcludeDepartureAirports(String excludeDepartureAirports) {
        this.excludeDepartureAirports = excludeDepartureAirports;
    }

    public String getExcludeArrivalAirports() {
        return excludeArrivalAirports;
    }

    public void setExcludeArrivalAirports(String excludeArrivalAirports) {
        this.excludeArrivalAirports = excludeArrivalAirports;
    }

    public Boolean getAllDepartureAirport() {
        return allDepartureAirport;
    }

    public void setAllDepartureAirport(Boolean allDepartureAirport) {
        this.allDepartureAirport = allDepartureAirport;
    }

    public Boolean getAllArrivalAirport() {
        return allArrivalAirport;
    }

    public void setAllArrivalAirport(Boolean allArrivalAirport) {
        this.allArrivalAirport = allArrivalAirport;
    }

    public String getIncludeDepartureAirports() {
        return includeDepartureAirports;
    }

    public void setIncludeDepartureAirports(String includeDepartureAirports) {
        this.includeDepartureAirports = includeDepartureAirports;
    }

    public String getIncludeArrivalAirports() {
        return includeArrivalAirports;
    }

    public void setIncludeArrivalAirports(String includeArrivalAirports) {
        this.includeArrivalAirports = includeArrivalAirports;
    }

    public Boolean getAllDepartureFlightNo() {
        return allDepartureFlightNo;
    }

    public void setAllDepartureFlightNo(Boolean allDepartureFlightNo) {
        this.allDepartureFlightNo = allDepartureFlightNo;
    }

    public Boolean getAllArrivalFlightNo() {
        return allArrivalFlightNo;
    }

    public void setAllArrivalFlightNo(Boolean allArrivalFlightNo) {
        this.allArrivalFlightNo = allArrivalFlightNo;
    }

    public String getExcludeFlightNo() {
        return excludeFlightNo;
    }

    public void setExcludeFlightNo(String excludeFlightNo) {
        this.excludeFlightNo = excludeFlightNo;
    }

    public String getDepartureSeats() {
        return departureSeats;
    }

    public void setDepartureSeats(String departureSeats) {
        this.departureSeats = departureSeats;
    }

    public String getArrivalSeats() {
        return arrivalSeats;
    }

    public void setArrivalSeats(String arrivalSeats) {
        this.arrivalSeats = arrivalSeats;
    }

    public String getDepartureWeekDays() {
        return departureWeekDays;
    }

    public void setDepartureWeekDays(String departureWeekDays) {
        this.departureWeekDays = departureWeekDays;
    }

    public String getArrivalWeekDays() {
        return arrivalWeekDays;
    }

    public void setArrivalWeekDays(String arrivalWeekDays) {
        this.arrivalWeekDays = arrivalWeekDays;
    }

    public String getCludeFlightNo() {
        return cludeFlightNo;
    }

    public void setCludeFlightNo(String cludeFlightNo) {
        this.cludeFlightNo = cludeFlightNo;
    }

    public String getCludeFlightNo2() {
        return cludeFlightNo2;
    }

    public void setCludeFlightNo2(String cludeFlightNo2) {
        this.cludeFlightNo2 = cludeFlightNo2;
    }

    public String getCludeFlightNo3() {
        return cludeFlightNo3;
    }

    public void setCludeFlightNo3(String cludeFlightNo3) {
        this.cludeFlightNo3 = cludeFlightNo3;
    }

    public String getExcludeFlightNo2() {
        return excludeFlightNo2;
    }

    public void setExcludeFlightNo2(String excludeFlightNo2) {
        this.excludeFlightNo2 = excludeFlightNo2;
    }

    public String getExcludeFlightNo3() {
        return excludeFlightNo3;
    }

    public void setExcludeFlightNo3(String excludeFlightNo3) {
        this.excludeFlightNo3 = excludeFlightNo3;
    }

}
