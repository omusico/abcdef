package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.BaseAuditRequest;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;

/**
 * 改签申请
 * 
 * @author qihuisong
 * @date 2015-10-09
 */
public class FlightOrderTicketCTMTAutoRequest extends BaseAuditRequest implements Serializable {

    private static final long serialVersionUID = -3306964652841662301L;

    /** 供应商订单号 */
    private String suppOrderNo;

    /** 改签航段序号 */
    private String suppSegementNo;

    /** 改签起飞日期 */
    private String changeDepartDate;

    /** 改签航班号 */
    private String changeFlightNo;
    
    /** 原航班号 */
    private String flightNo;
    
    /** 订单明细信息 */
    private List<FlightOrderDetailDto> flightOrderDetails = new ArrayList<FlightOrderDetailDto>();

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

    public String getSuppSegementNo() {
        return suppSegementNo;
    }

    public void setSuppSegementNo(String suppSegementNo) {
        this.suppSegementNo = suppSegementNo;
    }

    public String getChangeDepartDate() {
        return changeDepartDate;
    }

    public void setChangeDepartDate(String changeDepartDate) {
        this.changeDepartDate = changeDepartDate;
    }

    public String getChangeFlightNo() {
        return changeFlightNo;
    }

    public void setChangeFlightNo(String changeFlightNo) {
        this.changeFlightNo = changeFlightNo;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public List<FlightOrderDetailDto> getFlightOrderDetails() {
        return flightOrderDetails;
    }

    public void setFlightOrderDetails(List<FlightOrderDetailDto> flightOrderDetails) {
        this.flightOrderDetails = flightOrderDetails;
    }

}
