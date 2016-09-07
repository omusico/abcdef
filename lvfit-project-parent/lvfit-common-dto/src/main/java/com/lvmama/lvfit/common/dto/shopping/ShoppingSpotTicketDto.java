package com.lvmama.lvfit.common.dto.shopping;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.utils.DateUtils;

public class ShoppingSpotTicketDto extends Entity {
	
	
	private static final long serialVersionUID = -1144894683608205778L;
	
	private String shoppingUuid;
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
	//版本号
    private Long versionNo;
  //门票金额
    private BigDecimal  ticketPrice;
    //游玩日期-string类型
    private String visitTime;
    
	public String getShoppingUuid() {
		return shoppingUuid;
	}
	public void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
	}
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
	public Long getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getVisitTime() {
		return DateUtils.getFormatDate(this.getVisitDate(),DateUtils.YYYY_MM_DD);
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	
}
