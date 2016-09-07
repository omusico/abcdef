package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.SelfType;
import com.lvmama.lvf.common.dto.status.order.OrderBookingStatus;

/**
 * 供应商订单PNR信息
 * 
 * @author majun
 * @date 2015-2-4
 */
public class FlightOrderSuppOrderPNRInfoDto extends Entity implements Serializable {
    private static final long serialVersionUID = 7395686565141441330L;

    /** 供应商订单主键 */
    private Long suppOrderId;

    /** 订单资源采购类型 */
    private SelfType selfType;

    /** PNR编码 */
    private String pnr;

    /** oldPNR(新加) */
    private String oldPnr;
    
    /** 订单状态 */
    private OrderBookingStatus orderBookingStatus;

    /** PNR文本 */
    private String pnrTxt;

    /** PATA文本 */
    private String pataTxt;

    public OrderBookingStatus getOrderBookingStatus() {
		return orderBookingStatus;
	}

	public void setOrderBookingStatus(OrderBookingStatus orderBookingStatus) {
		this.orderBookingStatus = orderBookingStatus;
	}

	public Long getSuppOrderId() {
        return suppOrderId;
    }

    public void setSuppOrderId(Long suppOrderId) {
        this.suppOrderId = suppOrderId;
    }

    public SelfType getSelfType() {
        return selfType;
    }

    public void setSelfType(SelfType selfType) {
        this.selfType = selfType;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getOldPnr() {
        return oldPnr;
    }

    public void setOldPnr(String oldPnr) {
        this.oldPnr = oldPnr;
    }

    public String getPnrTxt() {
        return pnrTxt;
    }

    public void setPnrTxt(String pnrTxt) {
        this.pnrTxt = pnrTxt;
    }

    public String getPataTxt() {
        return pataTxt;
    }

    public void setPataTxt(String pataTxt) {
        this.pataTxt = pataTxt;
    }

    /**
     * 同步供应商订单PNR信息(xslt)
     * 
     * @param newSuppPnrDto
     *            供应商订单PNR信息
     * @return void
     */
    public void copyFromDto(FlightOrderSuppOrderPNRInfoDto newSuppPnrDto) {
        this.setOldPnr(newSuppPnrDto.getOldPnr());
        this.setPataTxt(newSuppPnrDto.getPataTxt());
        this.setPnr(newSuppPnrDto.getPnr());
        this.setPnrTxt(newSuppPnrDto.getPnrTxt());
        this.setUpdateTime(new Date());
    }

}
