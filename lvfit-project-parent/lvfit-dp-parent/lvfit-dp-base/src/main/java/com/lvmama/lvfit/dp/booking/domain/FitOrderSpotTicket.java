package com.lvmama.lvfit.dp.booking.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;

public class FitOrderSpotTicket implements Domain<FitOrderSpotTicketDto> {

    private static final Logger logger = LoggerFactory.getLogger(FitOrderSpotTicket.class);

	
    private FitOrderSpotTicketDto self = new FitOrderSpotTicketDto();

    public FitOrderSpotTicket() {
    }

    @Override
    public FitOrderSpotTicketDto self() {
        return this.self;
    }

    public FitOrderSpotTicket(FitOrderSpotTicketDto self) {
        super();
        this.self = self;
    }

    public FitOrderSpotTicketDto buildFitOrderSpotTicketDto(FitShoppingSelectedTicketDto selectedTicketDto) {
    	   
    	   this.self.setSpotId(selectedTicketDto.getProductId());
    	   this.self.setSpotName(selectedTicketDto.getSpotName());
    	   this.self.setTicketCount(selectedTicketDto.getTicketCount());
    	   this.self.setTicketId(selectedTicketDto.getSuppGoodsId());
    	   this.self.setTicketName(selectedTicketDto.getTicketName());
    	   this.self.setTicketSpec(selectedTicketDto.getTicketSpec());
    	   this.self.setVisitDate( selectedTicketDto.getTicketDate());
    	   this.self.setTicketPrice(selectedTicketDto.getTicketPrice());
    	   try {
			this.self.setTicketDetail(JSONMapper.getInstance().writeValueAsString(selectedTicketDto.getTicketDtl()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
        return this.self;
    }


}
