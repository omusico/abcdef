package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;

public class FlightOrderTicketAllowRuleDto extends AEEntity implements Serializable {

    private static final long serialVersionUID = 5361916799512121838L;

    /** 是否出发机场 */
    private Boolean allDepartureAirport;

    /** 是否到达机场 */
    private Boolean allArrivalAirport;

    /** 出发机场 */
    private String includeDepartureAirports;

    /** 到达机场 */
    private String includeArrivalAirports;

    /** 出发机场不适用 */
    private String excludeDepartureAirports;

    /** 到达机场不适用 */
    private String excludeArrivalAirports;

    /** 航线 不适用 */
    private String excludeAirLines;

    /** 航线 */
    private String includeAirLines;

    /** 舱位 */
    private String includeSeatClasses;

    /** 舱位不适用 */
    private String excludeSeatClasses;

    @FkId
    private Long orderTicketRuleId;

    public Long getOrderTicketRuleId() {
        return orderTicketRuleId;
    }

    public void setOrderTicketRuleId(Long orderTicketRuleId) {
        this.orderTicketRuleId = orderTicketRuleId;
    }

    public String getIncludeSeatClasses() {
        return includeSeatClasses;
    }

    public void setIncludeSeatClasses(String includeSeatClasses) {
        this.includeSeatClasses = includeSeatClasses;
    }

    public String getExcludeSeatClasses() {
        return excludeSeatClasses;
    }

    public void setExcludeSeatClasses(String excludeSeatClasses) {
        this.excludeSeatClasses = excludeSeatClasses;
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

    public String getExcludeAirLines() {
        return excludeAirLines;
    }

    public void setExcludeAirLines(String excludeAirLines) {
        this.excludeAirLines = excludeAirLines;
    }

    public String getIncludeAirLines() {
        return includeAirLines;
    }

    public void setIncludeAirLines(String includeAirLines) {
        this.includeAirLines = includeAirLines;
    }

}
