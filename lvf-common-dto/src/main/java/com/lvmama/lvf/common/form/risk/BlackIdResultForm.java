package com.lvmama.lvf.common.form.risk;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.RiskLevelType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.risk.BlackIdDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 风控黑名单返回信息Form
 * 
 * @author yuanweihong
 * @date 2015-9-1
 */
public class BlackIdResultForm implements Serializable, Form {

    private static final long serialVersionUID = 4585935560943794119L;

    /** 风控黑名单信息 */
    private BlackIdDto blackIdDto;

    /** 风控名单等级 **/
    private String riskLevelTypeStr;

    /** 有效无效标志 **/
    private String statusStr;

    /** 处理时间 **/
    private String updateTimeStr;
    
    /** 封禁黑名单开始时间 **/
    private String blackTimeStr;
    
    /** 封禁黑名单结束时间 **/
    private String blackTimeEnd;

    public BlackIdResultForm() {
        super();
    }

    public BlackIdResultForm(BlackIdDto blackIdDto) {
        super();
        this.blackIdDto = blackIdDto;
        if (this.blackIdDto != null) {
            if (this.blackIdDto.getRiskLevelType() != null) {
                this.riskLevelTypeStr = this.blackIdDto.getRiskLevelType().getCnName();
            }
            if (this.blackIdDto.getStatus() != null) {
                this.statusStr = this.blackIdDto.getStatus().getCnName();
            }
            if (this.blackIdDto.getUpdateTime() != null) {
                this.updateTimeStr = DateUtils.formatCnHmDate(this.blackIdDto.getUpdateTime());
            }
            if (this.blackIdDto.getBlackStartTime() != null) {
                this.blackTimeStr = DateUtils.formatCnHmDate(this.blackIdDto.getBlackStartTime());
            }
            if (this.blackIdDto.getBlackEndTime() != null) {
                this.blackTimeEnd = DateUtils.formatCnHmDate(this.blackIdDto.getBlackEndTime());
            }
        }
    }

    public BlackIdDto getBlackIdDto() {
        return blackIdDto;
    }

    public void setBlackIdDto(BlackIdDto blackIdDto) {
        this.blackIdDto = blackIdDto;
    }

    public PersistenceType getPtype() {
        return blackIdDto.getPtype();
    }

    public void setPtype(PersistenceType ptype) {
        blackIdDto.setPtype(ptype);
    }

    public String getCustomerId() {
        return blackIdDto.getCustomerId();
    }

    public String getSequence() {
        return blackIdDto.getSequence();
    }

    public void setCustomerId(String customerId) {
        blackIdDto.setCustomerId(customerId);
    }

    public Long getId() {
        return blackIdDto.getId();
    }

    public void setId(Long id) {
        blackIdDto.setId(id);
    }

    public RiskLevelType getRiskLevelType() {
        return blackIdDto.getRiskLevelType();
    }

    public String getUuid() {
        return blackIdDto.getUuid();
    }

    public void setRiskLevelType(RiskLevelType riskLevelType) {
        blackIdDto.setRiskLevelType(riskLevelType);
    }

    public void setUuid(String uuid) {
        blackIdDto.setUuid(uuid);
    }

    public Date getCreateTime() {
        return blackIdDto.getCreateTime();
    }

    public Status getStatus() {
        return blackIdDto.getStatus();
    }

    public void setCreateTime(Date createTime) {
        blackIdDto.setCreateTime(createTime);
    }

    public void setStatus(Status status) {
        blackIdDto.setStatus(status);
    }

    public Date getUpdateTime() {
        return blackIdDto.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        blackIdDto.setUpdateTime(updateTime);
    }

    public String getRiskLevelTypeStr() {
        return riskLevelTypeStr;
    }

    public void setRiskLevelTypeStr(String riskLevelTypeStr) {
        this.riskLevelTypeStr = riskLevelTypeStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public String getCustomerName() {
        return blackIdDto.getCustomerName();
    }

    public void setCustomerName(String customerName) {
        blackIdDto.setCustomerName(customerName);
    }

    public String getCustomerCellphone() {
        return blackIdDto.getCustomerCellphone();
    }

    public void setCustomerCellphone(String customerCellphone) {
        blackIdDto.setCustomerCellphone(customerCellphone);
    }


    public Date getBlackStartTime() {
        return blackIdDto.getBlackStartTime();
    }

    public void setBlackStartTime(Date blackStartTime) {
        blackIdDto.setBlackStartTime(blackStartTime);
    }

    public Date getBlackEndTime() {
        return blackIdDto.getBlackEndTime();
    }

    public void setBlackEndTime(Date blackEndTime) {
        blackIdDto.setBlackEndTime(blackEndTime);
    }

    public String getBlackTimeStr() {
        return blackTimeStr;
    }

    public void setBlackTimeStr(String blackTimeStr) {
        this.blackTimeStr = blackTimeStr;
    }

    public String getBlackTimeEnd() {
        return blackTimeEnd;
    }

    public void setBlackTimeEnd(String blackTimeEnd) {
        this.blackTimeEnd = blackTimeEnd;
    }

}
