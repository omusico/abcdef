package com.lvmama.lvf.common.dto.policy;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.*;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.FlightOfficeDto;
import com.lvmama.lvf.common.dto.md.FlightPolicyLabel;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 机票政策基本信息
 * 
 * @author yuanweihong
 * @date 2015-1-14
 */
@XmlRootElement
public class FlightPolicyDto extends AEEntity implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5801562630365623536L;

    private static final String ENUM_TYPE_SPLITER = ",";

    /** 承运人信息 */
    private Carrier carrier;

    /** 政策枚举类型 */
    private PolicyType flightPolicyType;

    /** 政策标签 */
    private List<FlightPolicyLabel> flightPolicyLabels = new ArrayList<FlightPolicyLabel>();

    /** 机票类型枚举信息 */
    private List<FlightTicketType> flightTicketTypes = new ArrayList<FlightTicketType>();

    /** 机票类型枚举信息(对应数据库字段) */
    private String ticketType;

    /** 是否更换PNR信息 */
    private NeedSwitchPNR needSwitchPNR;

    /** 编码授权信息 */
    private NeedAuth needAuth;

    /** 出票类型信息 */
    private AutoPrintTicket autoPrintTicket;

    /** 去程回程信息 */
    private List<FlightTripType> flightTripTypes = new ArrayList<FlightTripType>();

    /** 去程回程信息(对应数据库字段) */
    private String tripType;

    /** 乘客类型信息 */
    private List<PassengerType> passengerTypes = new ArrayList<PassengerType>();

    /** 乘客类型信息(对应数据库字段) */
    private String passengerType;

    /** PNR配置组及城市信息 */
    private List<FlightOfficeDto> flightOffices = new ArrayList<FlightOfficeDto>();

    /** 政策规则基本信息 */
    private FlightPolicyRuleDto flightPolicyRule;

    /** 政策有效期 */
    private FlightPolicyDepartureRuleDto flightPolicyDepartureRule;

    /** 政策出票有效期 */
    private FlightPolicyArrivalRuleDto flightPolicyArrivalRule;

    /** 政策利润规则信息 */
    private FlightPolicyProfitRuleDto flightPolicyProfitRule;

    /** 政策舱位及舱位价格规则信息 */
    private FlightPolicySeatPriceRuleDto flightPolicySeatPriceRule;

    /** RMK订单 */
    private String RMKOrder;

    /** 政策备注信息 */
    private FlightPolicyRemarkDto flightPolicyRemark;

    /** 航程类型信息枚举 */
    private List<RouteType> routeTypes = new ArrayList<RouteType>();

    /** 航程类型信息枚举(对应数据库字段) */
    private String routeType;

    /** 政策票描述规则 */
    private FlightPolicyTicketRuleDto flightPolicyTicketRule;

    /** 供应商政策基本信息 */
    private FlightPolicySuppDto flightPolicySupp;

    /** 机票政策库存信息 */
    private FlightPolicyInventoryDto flightPolicyInventory;

    /** 机票政策审核信息 */
    private FlightPolicyPublishDto flightPolicyPublish;

    /** 机票特殊政策基本信息 */
    private FlightPolicySpecDto flightPolicySpec;

    /** 最后更新时间 */
    private Date lastUpdateTime;

    /** 同步政策最后更新时间 */
    private String lastUpdatePolicyId;

    public FlightPolicyPublishDto getFlightPolicyPublish() {
        return flightPolicyPublish;
    }

    public void setFlightPolicyPublish(FlightPolicyPublishDto flightPolicyPublish) {
        this.flightPolicyPublish = flightPolicyPublish;
    }

    public FlightPolicyInventoryDto getFlightPolicyInventory() {
        return flightPolicyInventory;
    }

    public void setFlightPolicyInventory(FlightPolicyInventoryDto flightPolicyInventory) {
        this.flightPolicyInventory = flightPolicyInventory;
    }

    public FlightPolicyProfitRuleDto getFlightPolicyProfitRule() {
        return flightPolicyProfitRule;
    }

    public void setFlightPolicyProfitRule(FlightPolicyProfitRuleDto flightPolicyProfitRule) {
        this.flightPolicyProfitRule = flightPolicyProfitRule;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public FlightPolicySuppDto getFlightPolicySupp() {
        return flightPolicySupp;
    }

    public void setFlightPolicySupp(FlightPolicySuppDto flightPolicySupp) {
        this.flightPolicySupp = flightPolicySupp;
    }

    public PolicyType getFlightPolicyType() {
        return flightPolicyType;
    }

    public void setFlightPolicyType(PolicyType flightPolicyType) {
        this.flightPolicyType = flightPolicyType;
    }

    public List<FlightPolicyLabel> getFlightPolicyLabels() {
        return flightPolicyLabels;
    }

    public void setFlightPolicyLabels(List<FlightPolicyLabel> flightPolicyLabels) {
        this.flightPolicyLabels = flightPolicyLabels;
    }

    public List<FlightTicketType> getFlightTicketTypes() {
        this.flightTicketTypes = splitTypeEnum(ticketType, FlightTicketType.class);
        return flightTicketTypes;
    }

    public void setFlightTicketTypes(List<FlightTicketType> flightTicketTypes) {
        this.flightTicketTypes = flightTicketTypes;
    }

    public NeedSwitchPNR getNeedSwitchPNR() {
        return needSwitchPNR;
    }

    public void setNeedSwitchPNR(NeedSwitchPNR needSwitchPNR) {
        this.needSwitchPNR = needSwitchPNR;
    }

    public NeedAuth getNeedAuth() {
        return needAuth;
    }

    public void setNeedAuth(NeedAuth needAuth) {
        this.needAuth = needAuth;
    }

    public AutoPrintTicket getAutoPrintTicket() {
        return autoPrintTicket;
    }

    public void setAutoPrintTicket(AutoPrintTicket autoPrintTicket) {
        this.autoPrintTicket = autoPrintTicket;
    }

    public List<FlightTripType> getFlightTripTypes() {
        this.flightTripTypes = splitTypeEnum(tripType, FlightTripType.class);
        return flightTripTypes;
    }

    public void setFlightTripTypes(List<FlightTripType> flightTripTypes) {
        this.flightTripTypes = flightTripTypes;
    }

    public List<PassengerType> getPassengerTypes() {
        this.passengerTypes = splitTypeEnum(passengerType, PassengerType.class);
        return passengerTypes;
    }

    public void setPassengerTypes(List<PassengerType> passengerTypes) {
        this.passengerTypes = passengerTypes;
    }

    public List<FlightOfficeDto> getFlightOffices() {
        return flightOffices;
    }

    public void setFlightOffices(List<FlightOfficeDto> flightOffices) {
        this.flightOffices = flightOffices;
    }

    public FlightPolicyRuleDto getFlightPolicyRule() {
        return flightPolicyRule;
    }

    public void setFlightPolicyRule(FlightPolicyRuleDto flightPolicyRule) {
        this.flightPolicyRule = flightPolicyRule;
    }

    public FlightPolicyDepartureRuleDto getFlightPolicyDepartureRule() {
        return flightPolicyDepartureRule;
    }

    public void setFlightPolicyDepartureRule(FlightPolicyDepartureRuleDto flightPolicyDepartureRule) {
        this.flightPolicyDepartureRule = flightPolicyDepartureRule;
    }

    public FlightPolicySeatPriceRuleDto getFlightPolicySeatPriceRule() {
        return flightPolicySeatPriceRule;
    }

    public void setFlightPolicySeatPriceRule(FlightPolicySeatPriceRuleDto flightPolicySeatPriceRule) {
        this.flightPolicySeatPriceRule = flightPolicySeatPriceRule;
    }

    public String getRMKOrder() {
        return RMKOrder;
    }

    public void setRMKOrder(String rMKOrder) {
        RMKOrder = rMKOrder;
    }

    public FlightPolicyRemarkDto getFlightPolicyRemark() {
        return flightPolicyRemark;
    }

    public void setFlightPolicyRemark(FlightPolicyRemarkDto flightPolicyRemark) {
        this.flightPolicyRemark = flightPolicyRemark;
    }

    public List<RouteType> getRouteTypes() {
        this.routeTypes = splitTypeEnum(routeType, RouteType.class);
        return routeTypes;
    }

    public void setRouteTypes(List<RouteType> routeTypes) {
        this.routeTypes = routeTypes;
    }

    public FlightPolicyTicketRuleDto getFlightPolicyTicketRule() {
        return flightPolicyTicketRule;
    }

    public void setFlightPolicyTicketRule(FlightPolicyTicketRuleDto flightPolicyTicketRule) {
        this.flightPolicyTicketRule = flightPolicyTicketRule;
    }

    public FlightPolicyArrivalRuleDto getFlightPolicyArrivalRule() {
        return flightPolicyArrivalRule;
    }

    public void setFlightPolicyArrivalRule(FlightPolicyArrivalRuleDto flightPolicyArrivalRule) {
        this.flightPolicyArrivalRule = flightPolicyArrivalRule;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getTicketType() {
        this.ticketType = buildEnumString(flightTicketTypes);
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTripType() {
        this.tripType = buildEnumString(flightTripTypes);
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getPassengerType() {
        this.passengerType = buildEnumString(passengerTypes);
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public String getRouteType() {
        this.routeType = buildEnumString(routeTypes);
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public FlightPolicySpecDto getFlightPolicySpec() {
        return flightPolicySpec;
    }

    public void setFlightPolicySpec(FlightPolicySpecDto flightPolicySpec) {
        this.flightPolicySpec = flightPolicySpec;
    }

    public String getLastUpdatePolicyId() {
        return lastUpdatePolicyId;
    }

    public void setLastUpdatePolicyId(String lastUpdatePolicyId) {
        this.lastUpdatePolicyId = lastUpdatePolicyId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private <T> String buildEnumString(List<T> types) {
        StringBuilder ticketType = new StringBuilder("");
        if (types != null && types.size() > 0) {
            for (T type : types) {
                ticketType.append(type).append(ENUM_TYPE_SPLITER);
            }
        }
        if (!ticketType.toString().equals("")) {
            return ticketType.substring(0, ticketType.length() - 1);
        }
        return ticketType.toString();
    }

    private <E extends Enum<E>> List<E> splitTypeEnum(String types, Class<E> type) {
        List<E> list = new ArrayList<E>();
        if (StringUtils.isNotEmpty(types)) {
            String[] typeArray = types.split(ENUM_TYPE_SPLITER);
            for (String s : typeArray) {
                list.add(Enum.valueOf(type, s));
            }
        }
        return list;
    }
    
    @Override
    @JsonIgnore
    public String getSequence() {
        return "S_FFLI_POLICY";
    }

}
