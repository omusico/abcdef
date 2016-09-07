package com.lvmama.lvf.common.dto.adapter.response;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.flight.FlightDayPriceDto;
import com.lvmama.lvf.common.dto.flight.FlightInfoDto;
import com.lvmama.lvf.common.dto.flight.FlightInfosDto;
import com.lvmama.lvf.common.dto.flight.FlightRefundEndorseRuleDto;
import com.lvmama.lvf.common.dto.order.verify.FlightBookingVerifyInfosDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicyDtos;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderMainDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderRefundDto;
import com.lvmama.lvf.common.dto.supp.SuppFlightProductDto;
import com.lvmama.lvf.common.dto.ticket.FlightTicketRuleInfo;

/**
 * 供应商共用返回对象
 * 
 * @author majun
 * @date 2015-1-14
 */
@XmlRootElement
@XmlSeeAlso({ FlightInfoDto.class, FlightOrderSuppOrderDto.class, FlightTicketRuleInfo.class,
        FlightSuppOrderRefundableResponse.class, FlightOrderSuppOrderRefundDto.class,
        FlightBookingVerifyInfosDto.class, FlightInfosDto.class, FlightPolicyDtos.class,
        FlightDayPriceDto.class, FlightOrderSuppOrderMainDto.class, SuppFlightProductDto.class ,
        FlightSuppOrderChangeResponse.class,FlightRefundEndorseRuleDto.class})
public class SuppResponse<T> implements Serializable {
    
    private static final long serialVersionUID = 2565581941667956192L;

    /** 结果状态枚举 */
    private ResultStatus status;

    /** 错误编码 */
    private String errCode;

    /** 返回信息 */
    private String message;

    /** 实际返回对象 */
    // @XmlTransien
    private T result;

    /** 分页对象 */
    private Pagination pagination;

    /** 最后更新时间 */
    private Date lastUpdateTime;

    /** 最后id */
    private String lastId;

    /** 最后剩余页数 */
    private String lastPageNum;

    public String getLastPageNum() {
        return lastPageNum;
    }

    public void setLastPageNum(String lastPageNum) {
        this.lastPageNum = lastPageNum;
    }

    public String getLastId() {
        return lastId;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
