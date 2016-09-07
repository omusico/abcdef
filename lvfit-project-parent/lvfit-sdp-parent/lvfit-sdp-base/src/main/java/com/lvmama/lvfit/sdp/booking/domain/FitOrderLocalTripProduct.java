package com.lvmama.lvfit.sdp.booking.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.order.FitOrderLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;

public class FitOrderLocalTripProduct implements Domain<FitOrderLocalTripProductDto> {
	
	  private FitOrderLocalTripProductDto self = new FitOrderLocalTripProductDto();

	    public FitOrderLocalTripProduct() {
	    }

	    @Override
	    public FitOrderLocalTripProductDto self() {
	        return this.self;
	    }

	    public FitOrderLocalTripProduct(FitOrderLocalTripProductDto self) {
	        super();
	        this.self = self;
	    }

	    public FitOrderLocalTripProductDto buildFitOrderLocalTripProductDto(FitSdpShoppingDto shoppingDto) {
             
	         FitSdpLocalTripProductDto selectLocalTripPrduct = shoppingDto.getSelectLocalTripPrduct();
	         this.self.setProductId(selectLocalTripPrduct.getProductId());
	         this.self.setProductName(selectLocalTripPrduct.getProductName());
	         this.self.setGroupName(selectLocalTripPrduct.getGroupName());
	         this.self.setTravelDays(selectLocalTripPrduct.getTravelDays());
	         this.self.setStayDays(selectLocalTripPrduct.getStayDays());
	         this.self.setDayOfDuration(selectLocalTripPrduct.getDayOfDuration());
	         this.self.setVisitDate(selectLocalTripPrduct.getVisitDate());
	         this.self.setRoomDiffPrice(selectLocalTripPrduct.getRoomDiffPrice());
	         this.self.setPrice(selectLocalTripPrduct.getPrice());
	    	 this.self.setGoodsId(selectLocalTripPrduct.getSuppGoodsId());
	    	 this.self.setDetailId(selectLocalTripPrduct.getDetailId());
	         return this.self;
	    }
	    
}
