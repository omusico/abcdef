package com.lvmama.lvf.common.dto.risk;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.RiskLevelType;
import com.lvmama.lvf.common.dto.enums.Status;

/**
 * 风控黑名单信息
 * 
 * @author yuanweihong
 * @date 2015-9-1
 */
public class BlackIdDto extends Entity implements Serializable {

    private static final long serialVersionUID = 802986018324202629L;

    /** 客户ID */
    private String customerId;

    /** 客户姓名 */
    private String customerName;

    /** 客户手机号码 */
    private String customerCellphone;

    /** 触发风控黑名单规则记录标志 **/
    private Integer riskTriggerNum;

    /** 风控名单等级 **/
    private RiskLevelType riskLevelType;

    /** 有效无效标志 **/
    private Status status;

    /** 封禁黑名单开始时间 **/
    private Date blackStartTime;

    /** 封禁黑名单结束时间 **/
    private Date blackEndTime;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public RiskLevelType getRiskLevelType() {
        return riskLevelType;
    }

    public void setRiskLevelType(RiskLevelType riskLevelType) {
        this.riskLevelType = riskLevelType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCellphone() {
        return customerCellphone;
    }

    public void setCustomerCellphone(String customerCellphone) {
        this.customerCellphone = customerCellphone;
    }

    public Date getBlackStartTime() {
        return blackStartTime;
    }

    public void setBlackStartTime(Date blackStartTime) {
        this.blackStartTime = blackStartTime;
    }

    public Date getBlackEndTime() {
        return blackEndTime;
    }

    public void setBlackEndTime(Date blackEndTime) {
        this.blackEndTime = blackEndTime;
    }

    public Integer getRiskTriggerNum() {
        return riskTriggerNum;
    }

    public void setRiskTriggerNum(Integer riskTriggerNum) {
        this.riskTriggerNum = riskTriggerNum;
    }

}
