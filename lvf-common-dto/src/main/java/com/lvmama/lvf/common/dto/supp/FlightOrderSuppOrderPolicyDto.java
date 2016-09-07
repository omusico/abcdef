package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightPolicyDto;

/**
 * 供应商政策信息
 * 
 * @author majun
 * @date 2015-1-27
 */
public class FlightOrderSuppOrderPolicyDto extends Entity implements Serializable {
    private static final long serialVersionUID = -5749656564488950903L;

    /** 订单政策信息 */
    @FkId
    private FlightOrderFlightPolicyDto flightOrderFlightPolicy;

    /** 供应商订单主键 */
    private Long suppOrderId;

    /** 供应商政策编码 */
    private String suppPolicyNo;
    
	/** 销售类型 */
	private String saleType;
	
	/** 携程PID */
	private String pid;

    public FlightOrderFlightPolicyDto getFlightOrderFlightPolicy() {
        return flightOrderFlightPolicy;
    }

    public void setFlightOrderFlightPolicy(FlightOrderFlightPolicyDto flightOrderFlightPolicy) {
        this.flightOrderFlightPolicy = flightOrderFlightPolicy;
    }

    public Long getSuppOrderId() {
        return suppOrderId;
    }

    public void setSuppOrderId(Long suppOrderId) {
        this.suppOrderId = suppOrderId;
    }

    public String getSuppPolicyNo() {
        return suppPolicyNo;
    }

    public void setSuppPolicyNo(String suppPolicyNo) {
        this.suppPolicyNo = suppPolicyNo;
    }
    
	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
    /**
     * 同步供应商政策信息(xslt)
     * 
     * @param request
     *            供应商政策信息
     * @return void
     */
    public void copyFromDto(FlightOrderSuppOrderPolicyDto flightOrderSuppOrderPolicyRequest) {
        this.setFlightOrderFlightPolicy(flightOrderSuppOrderPolicyRequest.getFlightOrderFlightPolicy());
        this.setSuppPolicyNo(flightOrderSuppOrderPolicyRequest.getSuppPolicyNo());
        this.setUpdateTime(new Date());
    }

}
