package com.lvmama.lvfit.sdp.booking.domain;

import java.util.Date;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelComboDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;

public class FitOrderHotelCombo implements Domain<FitOrderHotelComboDto> {

    private FitOrderHotelComboDto self = new FitOrderHotelComboDto();

    public FitOrderHotelCombo() {
    }

    @Override
    public FitOrderHotelComboDto self() {
        return this.self;
    }

    public FitOrderHotelCombo(FitOrderHotelComboDto self) {
        super();
        this.self = self;
    }

    public FitOrderHotelComboDto buildFitOrderHotelComboDto(FitSdpShoppingDto shoppingDto) {

    	FitSdpHotelComboGoodsDto selectedHotelComboGoods = shoppingDto.getSelectedHotelComboGoods(); 
    	FitSdpShoppingRequest shoppingRequest = shoppingDto.getFitSdpShoppingRequest();
        this.self.setProductId(selectedHotelComboGoods.getProductId());
        this.self.setProductName(selectedHotelComboGoods.getProductName());
        //this.self.setProductCategoryId();
        this.self.setGoodsId(selectedHotelComboGoods.getSuppGoodsId());
        this.self.setBranchId(selectedHotelComboGoods.getBranchId());
        this.self.setBranchName(selectedHotelComboGoods.getBranchName());
        this.self.setBranchDesc(selectedHotelComboGoods.getBranchDesc());
        this.self.setQuantity(selectedHotelComboGoods.getQuantity());
        this.self.setPrice(selectedHotelComboGoods.getPrice());
        this.self.setCheckIn(selectedHotelComboGoods.getStartDay());
        this.self.setCheckOut(DateUtils.getDateAfterDateDays(selectedHotelComboGoods.getStartDay(), selectedHotelComboGoods.getStayDays()));
        this.self.setCheckInCity(shoppingRequest.getArrCityCode());
        this.self.setDetailId(selectedHotelComboGoods.getDetailId());
        return this.self;
    }
    
}
