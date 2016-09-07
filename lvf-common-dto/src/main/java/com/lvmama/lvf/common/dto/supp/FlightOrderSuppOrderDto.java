package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;

/**
 * 调用供应商创建订单接口的业务对象
 * 
 * @author majun
 * @date 2015-1-13
 */
@XmlRootElement
public class FlightOrderSuppOrderDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = -2185459415713194390L;

	/** 订单主键 */
	private Long orderId;
	
	/** 供应商主订单主键 */
	private Long suppOrderMainId;
	
	/** 供应商基本信息 */
	private Supp supp;

	/** 供应商订单对应的驴妈妈编号 */
	private String suppOrderLvNo;
	
	/** 供应商订单编号 */
	private String suppOrderNo;
	
	/** 供应商OFFICE号 */
	private String suppOfficeNo;
	
	/** 供应商订单政策信息 */
	private FlightOrderSuppOrderPolicyDto flightOrderSuppOrderPolicy;

	/** 订单联系人信息 */
	@FkId
	private FlightOrderContacterDto flightOrderContacter;
	
	/** 订单PNR信息(用于供应商订单和订单进行关联) */
	@FkId
	private FlightOrderPNRInfoDto flightOrderPNRInfo;
	
	/** 供应商订单PNR信息 */
	private FlightOrderSuppOrderPNRInfoDto flightOrderSuppOrderPNRInfo;

	/** 订单对应航班相关信息 */
	@FkId
	private List<FlightOrderFlightInfoDto> flightOrderFlightInfos;
	
	/** 供应商订单乘机人信息 */
	private List<FlightOrderSuppOrderPassengerDto> flightOrderSuppOrderPassengers;
	
	/** 供应商订单票号信息 */
	private List<FlightOrderSuppOrderTicketInfoDto> flightOrderSuppOrderTicketInfos;

	/** 供应商订单金额信息 */
	private FlightOrderSuppOrderAmountDto flightOrderSuppOrderAmount;

	/** 供应商订单状态 */
	private FlightOrderSuppOrderStatusDto flightOrderSuppOrderStatus;
	
	/** 供应商订单操作状态 */
	private FlightOrderSuppOrderOpStatusDto flightOrderSuppOrderOpStatus;
	
	/** 供应商订单PNR退票信息 */
	private List<FlightOrderSuppOrderPNRRefundDto> flightOrderSuppOrderPNRRefunds;
	
	/** 供应商订单明细信息 */
	private List<FlightOrderSuppOrderDetailDto> flightOrderSuppOrderDetails;
	
	/////////携程改签适用///////////
    /** 票台ID */
    private String suppAgencyNo;
	
	public String getSuppOrderLvNo() {
		return suppOrderLvNo;
	}

	public void setSuppOrderLvNo(String suppOrderLvNo) {
		this.suppOrderLvNo = suppOrderLvNo;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getSuppOrderMainId() {
		return suppOrderMainId;
	}

	public void setSuppOrderMainId(Long suppOrderMainId) {
		this.suppOrderMainId = suppOrderMainId;
	}

	public Supp getSupp() {
		return supp;
	}

	public void setSupp(Supp supp) {
		this.supp = supp;
	}

	public String getSuppOrderNo() {
		return suppOrderNo;
	}

	public void setSuppOrderNo(String suppOrderNo) {
		this.suppOrderNo = suppOrderNo;
	}

	public String getSuppOfficeNo() {
		return suppOfficeNo;
	}

	public void setSuppOfficeNo(String suppOfficeNo) {
		this.suppOfficeNo = suppOfficeNo;
	}

	public FlightOrderSuppOrderPolicyDto getFlightOrderSuppOrderPolicy() {
		return flightOrderSuppOrderPolicy;
	}

	public void setFlightOrderSuppOrderPolicy(
			FlightOrderSuppOrderPolicyDto flightOrderSuppOrderPolicy) {
		this.flightOrderSuppOrderPolicy = flightOrderSuppOrderPolicy;
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return flightOrderContacter;
	}

	public void setFlightOrderContacter(FlightOrderContacterDto flightOrderContacter) {
		this.flightOrderContacter = flightOrderContacter;
	}

	public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
		return flightOrderPNRInfo;
	}

	public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
		this.flightOrderPNRInfo = flightOrderPNRInfo;
	}

	public FlightOrderSuppOrderPNRInfoDto getFlightOrderSuppOrderPNRInfo() {
		return flightOrderSuppOrderPNRInfo;
	}

	public void setFlightOrderSuppOrderPNRInfo(
			FlightOrderSuppOrderPNRInfoDto flightOrderSuppOrderPNRInfo) {
		this.flightOrderSuppOrderPNRInfo = flightOrderSuppOrderPNRInfo;
	}

	public List<FlightOrderFlightInfoDto> getFlightOrderFlightInfos() {
		return flightOrderFlightInfos;
	}

	public List<FlightOrderSuppOrderPassengerDto> getFlightOrderSuppOrderPassengers() {
		return flightOrderSuppOrderPassengers;
	}

	public void setFlightOrderSuppOrderPassengers(
			List<FlightOrderSuppOrderPassengerDto> flightOrderSuppOrderPassengers) {
		this.flightOrderSuppOrderPassengers = flightOrderSuppOrderPassengers;
	}

	public void setFlightOrderFlightInfos(
			List<FlightOrderFlightInfoDto> flightOrderFlightInfos) {
		this.flightOrderFlightInfos = flightOrderFlightInfos;
	}

	public List<FlightOrderSuppOrderTicketInfoDto> getFlightOrderSuppOrderTicketInfos() {
		return flightOrderSuppOrderTicketInfos;
	}

	public void setFlightOrderSuppOrderTicketInfos(
			List<FlightOrderSuppOrderTicketInfoDto> flightOrderSuppOrderTicketInfos) {
		this.flightOrderSuppOrderTicketInfos = flightOrderSuppOrderTicketInfos;
	}

	public FlightOrderSuppOrderAmountDto getFlightOrderSuppOrderAmount() {
		return flightOrderSuppOrderAmount;
	}

	public void setFlightOrderSuppOrderAmount(
			FlightOrderSuppOrderAmountDto flightOrderSuppOrderAmount) {
		this.flightOrderSuppOrderAmount = flightOrderSuppOrderAmount;
	}

	public FlightOrderSuppOrderStatusDto getFlightOrderSuppOrderStatus() {
		return flightOrderSuppOrderStatus;
	}

	public void setFlightOrderSuppOrderStatus(
			FlightOrderSuppOrderStatusDto flightOrderSuppOrderStatus) {
		this.flightOrderSuppOrderStatus = flightOrderSuppOrderStatus;
	}

	public FlightOrderSuppOrderOpStatusDto getFlightOrderSuppOrderOpStatus() {
		return flightOrderSuppOrderOpStatus;
	}

	public void setFlightOrderSuppOrderOpStatus(
			FlightOrderSuppOrderOpStatusDto flightOrderSuppOrderOpStatus) {
		this.flightOrderSuppOrderOpStatus = flightOrderSuppOrderOpStatus;
	}

	public List<FlightOrderSuppOrderPNRRefundDto> getFlightOrderSuppOrderPNRRefunds() {
		return flightOrderSuppOrderPNRRefunds;
	}

	public void setFlightOrderSuppOrderPNRRefunds(
			List<FlightOrderSuppOrderPNRRefundDto> flightOrderSuppOrderPNRRefunds) {
		this.flightOrderSuppOrderPNRRefunds = flightOrderSuppOrderPNRRefunds;
	}
	
	public List<FlightOrderSuppOrderDetailDto> getFlightOrderSuppOrderDetails() {
		return flightOrderSuppOrderDetails;
	}

	public void setFlightOrderSuppOrderDetails(
			List<FlightOrderSuppOrderDetailDto> flightOrderSuppOrderDetails) {
		this.flightOrderSuppOrderDetails = flightOrderSuppOrderDetails;
	}

    public String getSuppAgencyNo() {
        return suppAgencyNo;
    }

    public void setSuppAgencyNo(String suppAgencyNo) {
        this.suppAgencyNo = suppAgencyNo;
    }

    /**
     * 同步供应商订单信息(xslt)
     * 
     * @param request
     *            供应商订单信息
     * @return void
     */
	public void copyFromDto(FlightOrderSuppOrderDto flightOrderSuppOrder){
		this.setFlightOrderSuppOrderAmount(flightOrderSuppOrder.getFlightOrderSuppOrderAmount());
		this.setSuppOrderNo(flightOrderSuppOrder.getSuppOrderNo());
		this.setSuppAgencyNo(flightOrderSuppOrder.getSuppAgencyNo());
		this.setUpdateTime(new Date());
	}
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_SUPP_ORDER";
	}
}