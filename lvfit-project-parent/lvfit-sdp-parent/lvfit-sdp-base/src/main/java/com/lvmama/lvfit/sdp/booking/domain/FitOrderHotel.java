package com.lvmama.lvfit.sdp.booking.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;

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

    public FitOrderHotelDto buildFitOrderHotelDto(FitSdpHotelRoomtypeDto selectHotelRoom) {

    	this.self.setHotelId(String.valueOf(selectHotelRoom.getHotelId()));//(searchHotel.getProductId());
        this.self.setHotelName(selectHotelRoom.getHotelName());//(searchHotel.getProductName());
        this.self.setRoomId(String.valueOf(selectHotelRoom.getRoomId()));
        this.self.setRoomName(selectHotelRoom.getRoomName());
        this.self.setRoomCount(selectHotelRoom.getRoomCount());
        this.self.setPlanId(String.valueOf(selectHotelRoom.getGoodsId()));//商品Id
        this.self.setPlanName(selectHotelRoom.getGoodsName());
        //this.self.setSalesPrice(selectHotelRoom.getPrice());
        this.self.setBedType(selectHotelRoom.getBedType());
        //this.self.setBroadband(selectHotelRoom.getBroadband());
        //this.self.setBreakfast(selectHotelRoom.getBreakfast());
        this.self.setDetailId(String.valueOf(selectHotelRoom.getDetailId()));
        return this.self;
    }


}
