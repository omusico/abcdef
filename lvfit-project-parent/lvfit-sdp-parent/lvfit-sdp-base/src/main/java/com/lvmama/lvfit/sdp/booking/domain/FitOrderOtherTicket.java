package com.lvmama.lvfit.sdp.booking.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.order.FitOrderOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectOtherTicketDto;

public class FitOrderOtherTicket implements Domain<FitOrderOtherTicketDto> {
	
	  private FitOrderOtherTicketDto self = new FitOrderOtherTicketDto();

	    public FitOrderOtherTicket() {
	    }

	    @Override
	    public FitOrderOtherTicketDto self() {
	        return this.self;
	    }

	    public FitOrderOtherTicket(FitOrderOtherTicketDto self) {
	        super();
	        this.self = self;
	    }

	    public FitOrderOtherTicketDto buildFitOrderOtherTicketDto(FitSdpSelectOtherTicketDto selectOtherTicketDto) {
	        this.self.setProductName(selectOtherTicketDto.getProductName());
	        this.self.setGoodsId(selectOtherTicketDto.getSuppGoodsId());
	        this.self.setGoodsName(selectOtherTicketDto.getGoodsName());
	        this.self.setBranchDesc(selectOtherTicketDto.getBranchDesc());
	        this.self.setSelectCount(selectOtherTicketDto.getSelectCount());
	        this.self.setSelectDate(DateUtils.parseDate(selectOtherTicketDto.getSelectDate()));
	        this.self.setSelectPrice(selectOtherTicketDto.getSelectPrice());
	        return this.self;
	    }
	    
}
