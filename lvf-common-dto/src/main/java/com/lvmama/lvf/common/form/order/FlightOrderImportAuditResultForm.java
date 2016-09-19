package com.lvmama.lvf.common.form.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.order.FlightOrderImportDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class FlightOrderImportAuditResultForm implements Serializable, Form {

	private static final long serialVersionUID = -4426181585884699287L;

	private FlightOrderImportDto dto;
	
	public FlightOrderImportAuditResultForm(FlightOrderImportDto dto){
		this.dto = dto;
	}

	public Long getOrderMainId() {
		return dto.getOrderId();
	}
	
	public Long getOrderId(){
		return dto.getId();
	}
	
	public String getOrderMainNo(){
		return dto.getOrderNo();
	}
	
	public String getPnr(){
		return dto.getPnr();
	}
	
	public BigDecimal getParPrice(){
		return dto.getTicketAmount();
	}
	
	public BigDecimal getSettleAmount(){
		return dto.getSettleAmount();
	}
	
	public BigDecimal getSaleAmount(){
		return dto.getSaleAmount();
	}
	
	public Date getCreateTime() {
		return dto.getCreateTime();
	}
	
	public String getCreateTimeStr(){
		if (this.getCreateTime() != null) {
			return DateUtils.formatDate(this.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		}
		return null;
	}
	
	public String getCompanyName(){
		return dto.getCompanyName();
	}
}
