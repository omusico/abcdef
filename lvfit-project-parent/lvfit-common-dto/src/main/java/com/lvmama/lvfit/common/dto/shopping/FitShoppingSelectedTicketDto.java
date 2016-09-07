package com.lvmama.lvfit.common.dto.shopping;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.ticket.FitTicketGoodsDetailDto;

/**
 * 保存购物车选择的门票信息用Dto
 * 
 * @author lizongze
 *
 */
public class FitShoppingSelectedTicketDto implements Serializable, Dto {

    private static final long serialVersionUID = 8289954198151157490L;

    // 景点ID
    private String productId;
    //景点名称
    private String spotName;
    // 门票商品ID
    private String suppGoodsId;
    // 门票名称
    private String ticketName;
   // 所属票种
 	private String ticketSpec;
    // 门票日期
    private Date ticketDate;
    // 门票张数
    private int ticketCount;
    // 门票价格
    private BigDecimal ticketPrice;
    // 门票详情
    private FitTicketGoodsDetailDto ticketDtl;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public String getSuppGoodsId() {
        return suppGoodsId;
    }

    public void setSuppGoodsId(String suppGoodsId) {
        this.suppGoodsId = suppGoodsId;
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

	public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return null;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    

    public FitTicketGoodsDetailDto getTicketDtl() {
        return ticketDtl;
    }

    public void setTicketDtl(FitTicketGoodsDetailDto ticketDtl) {
        this.ticketDtl = ticketDtl;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  
        if (obj == null) return false;  
        if (getClass() != obj.getClass()) return false;  
        final FitShoppingSelectedTicketDto other = (FitShoppingSelectedTicketDto) obj;  
        boolean flag = true;
        if (this.getProductId() != null) {
            if (!this.getProductId().equals(other.getProductId())) {
                flag = false;
            }
        }
        if (this.getSuppGoodsId() != null) {
            if (!this.getSuppGoodsId().equals(other.getSuppGoodsId())) {
                flag = false;
            }
        }
        if (this.getTicketDate() != null) {
            if (!this.getTicketDate().equals(other.getTicketDate())) {
                flag = false;
            }
        }
        
        if (this.getTicketCount() != other.getTicketCount()) {
            flag = false;
        }
        return flag;
    }
    
    @Override
    public int hashCode() {
        return this.getSuppGoodsId().hashCode();
    }

}
