package com.lvmama.lvfit.common.dto.order;


import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.ticket.FitTicketGoodsDetailDto;

public class FitOrderSpotTicketDto extends Entity {
	
	
	private static final long serialVersionUID = -1144894683608205778L;
	
	// 产品ID
	private String spotId;
	// 产品名称
	private String spotName;
	// 商品ID
	private String ticketId;
	// 商品名称
	private String ticketName;
	// 所属票种
	private String ticketSpec;
	//所订票数
	private int ticketCount;
	//游玩日期
    private Date visitDate;  
    //门票详情串
    private String ticketDetail;
    //门票单价
    private BigDecimal ticketPrice;
    
    private FitTicketGoodsDetailDto ticketGoodsDetailDto;

	public String getSpotId() {
		return spotId;
	}
	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public String getTicketSpec() {
		return ticketSpec;
	}
	public void setTicketSpec(String ticketSpec) {
		this.ticketSpec = ticketSpec;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getTicketDetail() {
		return ticketDetail;
	}
	public void setTicketDetail(String ticketDetail) {
		this.ticketDetail = ticketDetail;
	}
	public FitTicketGoodsDetailDto getTicketGoodsDetailDto() {
		
		if(StringUtils.isNotBlank(this.getTicketDetail())){
			try {
				ticketGoodsDetailDto = JSONMapper.getInstance().readValue(this.getTicketDetail(), FitTicketGoodsDetailDto.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ticketGoodsDetailDto;
	}
	public void setTicketGoodsDetailDto(FitTicketGoodsDetailDto ticketGoodsDetailDto) {
		this.ticketGoodsDetailDto = ticketGoodsDetailDto;
	}
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
	
}
