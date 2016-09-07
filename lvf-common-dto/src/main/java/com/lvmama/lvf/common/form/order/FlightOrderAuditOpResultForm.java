package com.lvmama.lvf.common.form.order;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.AuditStatus;
import com.lvmama.lvf.common.dto.enums.AuditType;
import com.lvmama.lvf.common.dto.enums.OrderAuditOpType;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.order.result.FlightOrderAuditOpDto;
import com.lvmama.lvf.common.dto.status.OpType;
import com.lvmama.lvf.common.dto.status.order.OrderAuditStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;

/**
 * 出票改签退票审核/处理列表ResultForm
 * 
 * @author yuanweihong
 * @date 2015-3-11
 */
public class FlightOrderAuditOpResultForm implements Serializable, Form {

    private static final long serialVersionUID = 1774586340205493518L;

    /** 出票改签退票审核/处理列表 */
    private FlightOrderAuditOpDto flightOrderAuditOpDto;

    /** 订单操作类型 */
    private OpType opType;

    /** 效率 */
    private String efficiency;

    /** 航程 */
    private String flightSegment;

    /** 订单状态 */
    private String orderStatus;

    /** 订单类型 */
    private OrderAuditOpType orderAuditOpType;

    /** 操作类型 */
    private String operateType;
    
    /** 订单供应商审核状态(出票用) */
    private String suppOrderAuditStatus;

    public FlightOrderAuditOpResultForm() {
        super();
    }

    public FlightOrderAuditOpResultForm(FlightOrderAuditOpDto flightOrderAuditOpDto) {
        super();
        this.flightOrderAuditOpDto = flightOrderAuditOpDto;

        if (this.flightOrderAuditOpDto != null) {
            // 构造订单操作类型
            this.opType = this.flightOrderAuditOpDto.getAuditType().getOpType();

            // 构造航程
            this.flightSegment = StringUtil.replaceNullStr(this.flightOrderAuditOpDto.getDepCode()) + "-"
                               +  StringUtil.replaceNullStr(this.flightOrderAuditOpDto.getArrCode());
            // 构造效率
            if (this.flightOrderAuditOpDto.getOrderUpdateTime() != null) {
                this.efficiency = DateUtils.getDateDiffByMin(new Date(), this.flightOrderAuditOpDto.getOrderUpdateTime()) + "分钟";
            }
            
            // 订单供应商审核状态(出票用)
            if (this.flightOrderAuditOpDto.getSuppOrderAuditStatus() != null) {
                this.suppOrderAuditStatus = this.flightOrderAuditOpDto.getSuppOrderAuditStatus().getCnName();
            }

            // 构造流程状态
            if (this.flightOrderAuditOpDto.getOrderAuditStatus() != null) {
                this.orderStatus = this.flightOrderAuditOpDto.getOrderAuditStatus().getCnName();
                if (this.flightOrderAuditOpDto.getOrderAuditStatus().equals(OrderAuditStatus.NOT_AUDIT)){
                    this.operateType = "审核";
                } else if (this.flightOrderAuditOpDto.getOrderAuditStatus().equals(OrderAuditStatus.AUDIT_PASS)){
                    this.operateType = "处理";
                } else {
                    this.operateType = "查看";
                }
            } else if (this.flightOrderAuditOpDto.getOrderTicketStatus() != null
                    && OrderType.NORMAL.equals(this.flightOrderAuditOpDto.getOrderType())) {
                this.orderStatus = this.flightOrderAuditOpDto.getOrderTicketStatus().getCnName();
                if (this.flightOrderAuditOpDto.getOrderTicketStatus().equals(OrderTicketStatus.ISSUE_SUCC) 
                		|| this.flightOrderAuditOpDto.getOrderTicketStatus().equals(OrderTicketStatus.ISSUE_FAIL)){
                    this.operateType = "查看";
                } else 
                    this.operateType = "出票";
            } else if (this.flightOrderAuditOpDto.getOrderTicketStatus() != null
            		&& OrderType.RTVT.equals(this.flightOrderAuditOpDto.getOrderType())) {
                this.orderStatus = this.flightOrderAuditOpDto.getOrderTicketStatus().getCnName();
                if (!this.flightOrderAuditOpDto.getOrderTicketStatus().equals(OrderTicketStatus.RTVT_SUCC)
                        && !this.flightOrderAuditOpDto.getOrderTicketStatus().equals(OrderTicketStatus.RTVT_FAIL)){
                    this.operateType = "确认";
                } else 
                    this.operateType = "查看";
            } else if (this.flightOrderAuditOpDto.getOrderTicketStatus() != null
            		&& OrderType.CTMT.equals(this.flightOrderAuditOpDto.getOrderType())) {
                this.orderStatus = this.flightOrderAuditOpDto.getOrderTicketStatus().getCnName();
                if (!this.flightOrderAuditOpDto.getOrderTicketStatus().equals(OrderTicketStatus.CTMT_SUCC)
                        && !this.flightOrderAuditOpDto.getOrderTicketStatus().equals(OrderTicketStatus.CTMT_FAIL)){
                    this.operateType = "改签";
                } else 
                    this.operateType = "查看";
            } else {
            	this.operateType = "退改查看";
            }
        }

    }

    public FlightOrderAuditOpDto getFlightOrderAuditOpDto() {
        return flightOrderAuditOpDto;
    }

    public void setFlightOrderAuditOpDto(FlightOrderAuditOpDto flightOrderAuditOpDto) {
        this.flightOrderAuditOpDto = flightOrderAuditOpDto;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getFlightSegment() {
        return flightSegment;
    }

    public void setFlightSegment(String flightSegment) {
        this.flightSegment = flightSegment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderAuditOpType getOrderAuditOpType() {
        return orderAuditOpType;
    }

    public void setOrderAuditOpType(OrderAuditOpType orderAuditOpType) {
        this.orderAuditOpType = orderAuditOpType;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public PersistenceType getPtype() {
        return flightOrderAuditOpDto.getPtype();
    }

    public void setPtype(PersistenceType ptype) {
        flightOrderAuditOpDto.setPtype(ptype);
    }

    public String getSequence() {
        return flightOrderAuditOpDto.getSequence();
    }

    public Long getId() {
        return flightOrderAuditOpDto.getId();
    }

    public void setId(Long id) {
        flightOrderAuditOpDto.setId(id);
    }

    public String getUuid() {
        return flightOrderAuditOpDto.getUuid();
    }

    public void setUuid(String uuid) {
        flightOrderAuditOpDto.setUuid(uuid);
    }

    public Date getCreateTime() {
        return flightOrderAuditOpDto.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        flightOrderAuditOpDto.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return flightOrderAuditOpDto.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        flightOrderAuditOpDto.setUpdateTime(updateTime);
    }

    public Long getOrderMainId() {
        return flightOrderAuditOpDto.getOrderMainId();
    }

    public void setOrderMainId(Long orderMainId) {
        flightOrderAuditOpDto.setOrderMainId(orderMainId);
    }

    public Long getOrderId() {
        return flightOrderAuditOpDto.getOrderId();
    }

    public void setOrderId(Long orderId) {
        flightOrderAuditOpDto.setOrderId(orderId);
    }

    public FlightOrderNoDto getFlightOrderNo() {
        return flightOrderAuditOpDto.getFlightOrderNo();
    }

    public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
        flightOrderAuditOpDto.setFlightOrderNo(flightOrderNo);
    }

    public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
        return flightOrderAuditOpDto.getFlightOrderPNRInfo();
    }

    public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
        flightOrderAuditOpDto.setFlightOrderPNRInfo(flightOrderPNRInfo);
    }

    public String getFlightNo() {
        return flightOrderAuditOpDto.getFlightNo();
    }

    public void setFlightNo(String flightNo) {
        flightOrderAuditOpDto.setFlightNo(flightNo);
    }

    public String getDepCode() {
        return flightOrderAuditOpDto.getDepCode();
    }

    public void setDepCode(String depCode) {
        flightOrderAuditOpDto.setDepCode(depCode);
    }

    public String getArrCode() {
        return flightOrderAuditOpDto.getArrCode();
    }

    public void setArrCode(String arrCode) {
        flightOrderAuditOpDto.setArrCode(arrCode);
    }

    public String getSeatClassCode() {
        return flightOrderAuditOpDto.getSeatClassCode();
    }

    public void setSeatClassCode(String seatClassCode) {
        flightOrderAuditOpDto.setSeatClassCode(seatClassCode);
    }

    public String getFlightTime() {
        return flightOrderAuditOpDto.getFlightTime();
    }

    public void setFlightTime(String flightTime) {
        flightOrderAuditOpDto.setFlightTime(flightTime);
    }

    public AuditType getAuditType() {
        return flightOrderAuditOpDto.getAuditType();
    }

    public void setAuditType(AuditType auditType) {
        flightOrderAuditOpDto.setAuditType(auditType);
    }

    public OrderAuditStatus getOrderAuditStatus() {
        return flightOrderAuditOpDto.getOrderAuditStatus();
    }

    public void setOrderAuditStatus(OrderAuditStatus orderAuditStatus) {
        flightOrderAuditOpDto.setOrderAuditStatus(orderAuditStatus);
    }

    public OrderTicketStatus getOrderTicketStatus() {
        return flightOrderAuditOpDto.getOrderTicketStatus();
    }

    public void setOrderTicketStatus(OrderTicketStatus orderTicketStatus) {
        flightOrderAuditOpDto.setOrderTicketStatus(orderTicketStatus);
    }

    public FlightOrderCustomerDto getFlightOrderCustomer() {
        return flightOrderAuditOpDto.getFlightOrderCustomer();
    }

    public void setFlightOrderCustomer(FlightOrderCustomerDto flightOrderCustomer) {
        flightOrderAuditOpDto.setFlightOrderCustomer(flightOrderCustomer);
    }

    public FlightOrderContacterDto getFlightOrderContacter() {
        return flightOrderAuditOpDto.getFlightOrderContacter();
    }

    public void setFlightOrderContacter(FlightOrderContacterDto flightOrderContacter) {
        flightOrderAuditOpDto.setFlightOrderContacter(flightOrderContacter);
    }

    public FlightOrderPassengerDto getFlightOrderPassenger() {
        return flightOrderAuditOpDto.getFlightOrderPassenger();
    }

    public void setFlightOrderPassenger(FlightOrderPassengerDto flightOrderPassenger) {
        flightOrderAuditOpDto.setFlightOrderPassenger(flightOrderPassenger);
    }

    public FlightOrderTicketInfoDto getFlightOrderTicketInfoDto() {
        return flightOrderAuditOpDto.getFlightOrderTicketInfoDto();
    }

    public void setFlightOrderTicketInfoDto(FlightOrderTicketInfoDto flightOrderTicketInfoDto) {
        flightOrderAuditOpDto.setFlightOrderTicketInfoDto(flightOrderTicketInfoDto);
    }

    public String getBookingTime() {
        return flightOrderAuditOpDto.getBookingTime();
    }

    public void setBookingTime(String bookingTime) {
        flightOrderAuditOpDto.setBookingTime(bookingTime);
    }



    public Date getOrderUpdateTime() {
        return flightOrderAuditOpDto.getOrderUpdateTime();
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        flightOrderAuditOpDto.setOrderUpdateTime(orderUpdateTime);
    }

    public String getOper() {
        return flightOrderAuditOpDto.getOper();
    }

    public void setOper(String oper) {
        flightOrderAuditOpDto.setOper(oper);
    }

    public String getRemark() {
        return flightOrderAuditOpDto.getRemark();
    }

    public void setRemark(String remark) {
        flightOrderAuditOpDto.setRemark(remark);
    }

    public OpType getOpType() {
        return opType;
    }

    public void setOpType(OpType opType) {
        this.opType = opType;
    }

    public AuditStatus getAuditStatus() {
        return flightOrderAuditOpDto.getAuditStatus();
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        flightOrderAuditOpDto.setAuditStatus(auditStatus);
    }

    public String getPreOrderNo() {
        return flightOrderAuditOpDto.getPreOrderNo();
    }

    public void setPreOrderNo(String preOrderNo) {
        flightOrderAuditOpDto.setPreOrderNo(preOrderNo);
    }

    public String getSuppOrderAuditStatus() {
        return suppOrderAuditStatus;
    }

    public void setSuppOrderAuditStatus(String suppOrderAuditStatus) {
        this.suppOrderAuditStatus = suppOrderAuditStatus;
    }

	public OrderType getOrderType() {
		return flightOrderAuditOpDto.getOrderType();
	}

	public void setOrderType(OrderType orderType) {
		flightOrderAuditOpDto.setOrderType(orderType);
	}
	
	public String getSuppCode() {
		return flightOrderAuditOpDto.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		flightOrderAuditOpDto.setSuppCode(suppCode);
	}

    public String getSaleType() {
        return flightOrderAuditOpDto.getSaleType();
    }

    public void setSaleType(String saleType) {
        flightOrderAuditOpDto.setSaleType(saleType);
    }
}
