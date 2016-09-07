package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.RiskLevelType;
import com.lvmama.lvf.common.dto.enums.Status;

/**
 * 风控黑名单请求信息
 * 
 * @author yuanweihong
 * @date 2015-9-1
 */
public class BlackIdRequest implements Serializable, Dto {

    private static final long serialVersionUID = -1130882509859543909L;

    /** 主键ID **/
    private Long id;

    /** 客户ID **/
    private String customerId;

    /** 客户姓名 */
    private String customerName;

    /** 客户手机号码 */
    private String customerCellphone;

    /** 风控名单等级 **/
    private RiskLevelType riskLevelType;

    /** 有效无效标志 **/
    private Status status;

    /** 封禁黑名单开始时间1**/
    private String blackStartBegTime;
    
    /** 封禁黑名单开始时间2**/
    private String blackStartEndTime;
    
    /** 封禁黑名单开始时间**/
    private String blackStartTime;
    
    /** 封禁黑名单结束时间 **/
    private String blackEndTime;
    
    /** 触发风控黑名单规则记录标志 **/
    private Integer riskTriggerNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getBlackStartBegTime() {
        return blackStartBegTime;
    }

    public void setBlackStartBegTime(String blackStartBegTime) {
        this.blackStartBegTime = blackStartBegTime;
    }

    public String getBlackStartEndTime() {
        return blackStartEndTime;
    }

    public void setBlackStartEndTime(String blackStartEndTime) {
        this.blackStartEndTime = blackStartEndTime;
    }

    public String getBlackEndTime() {
        return blackEndTime;
    }

    public void setBlackEndTime(String blackEndTime) {
        this.blackEndTime = blackEndTime;
    }

    public Integer getRiskTriggerNum() {
        return riskTriggerNum;
    }

    public void setRiskTriggerNum(Integer riskTriggerNum) {
        this.riskTriggerNum = riskTriggerNum;
    }

	public String getBlackStartTime() {
		return blackStartTime;
	}

	public void setBlackStartTime(String blackStartTime) {
		this.blackStartTime = blackStartTime;
	}
   
}
