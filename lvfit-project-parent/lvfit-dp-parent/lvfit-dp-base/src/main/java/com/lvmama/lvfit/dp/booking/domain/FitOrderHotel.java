package com.lvmama.lvfit.dp.booking.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;

public class FitOrderHotel implements Domain<FitOrderHotelDto> {

    private FitOrderHotelDto self = new FitOrderHotelDto();

    public FitOrderHotel() {
    }

    @Override
    public FitOrderHotelDto self() {
        return this.self;
    }

    public FitOrderHotel(FitOrderHotelDto self) {
        super();
        this.self = self;
    }

    public FitOrderHotelDto buildFitOrderHotelDto(HotelSearchHotelDto searchHotel,HotelSearchRoomDto searchRoom, HotelSearchPlanDto searchPlan) {

    	this.self.setHotelId(searchHotel.getProductId());
        this.self.setHotelName(searchHotel.getProductName());
        this.self.setRoomId(searchRoom.getBranchId());
        this.self.setRoomName(searchRoom.getBranchName());
        this.self.setRoomCount(searchPlan.getRoomCounts());
        this.self.setPlanId(searchPlan.getSuppGoodsId());
        this.self.setPlanName(searchPlan.getGoodsName());
        //this.self.setSalesPrice(new BigDecimal(searchPlan.getSellPrice()));
        this.self.setBedType(searchRoom.getBedType());
        this.self.setBroadband(searchRoom.getBroadband());
        this.self.setBreakfast(searchPlan.getBreakfast());
        return this.self;
    }


}
