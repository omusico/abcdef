package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;

public class FitShoppingTicketRequest implements Serializable, Dto {

    private static final long serialVersionUID = 7501178250424247851L;
    // 购物车ID
    private String shoppingUuid;
    
    private FitShoppingSelectedTicketDto ticketDto = new FitShoppingSelectedTicketDto();
    
    private String ticketDate;

    public String getShoppingUuid() {
        return shoppingUuid;
    }

    public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }

    public String getProductId() {
        return ticketDto.getProductId();
    }

    public void setProductId(String productId) {
        ticketDto.setProductId(productId);
    }

    public String getSuppGoodsId() {
        return ticketDto.getSuppGoodsId();
    }

    public void setSuppGoodsId(String suppGoodsId) {
        ticketDto.setSuppGoodsId(suppGoodsId);
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
        this.ticketDto.setTicketDate(DateUtils.parseDate(this.ticketDate, DateUtils.YYYY_MM_DD));
    }

    public int getTicketCount() {
        return ticketDto.getTicketCount();
    }

    public void setTicketCount(int ticketCount) {
        ticketDto.setTicketCount(ticketCount);
    }

    public FitShoppingSelectedTicketDto getTicketDto() {
        return ticketDto;
    }

    public void setTicketDto(FitShoppingSelectedTicketDto ticketDto) {
        this.ticketDto = ticketDto;
    }
    
    public String getTicketName() {
        return ticketDto.getTicketName();
    }

    public void setTicketName(String ticketName) {
        ticketDto.setTicketName(ticketName);
    }

    public BigDecimal getTicketPrice() {
        return ticketDto.getTicketPrice();
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        ticketDto.setTicketPrice(ticketPrice);
    }
    
    public String getSpotName() {
        return ticketDto.getSpotName();
    }

    public void setSpotName(String spotName) {
        ticketDto.setSpotName(spotName);
    }

    @Override
    public Long getId() {
        return null;
    }


}
