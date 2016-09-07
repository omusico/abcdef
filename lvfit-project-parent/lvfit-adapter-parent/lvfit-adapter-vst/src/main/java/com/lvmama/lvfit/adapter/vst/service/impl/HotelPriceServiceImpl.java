package com.lvmama.lvfit.adapter.vst.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.adapter.vst.adapter.GoodsServiceAdapter;
import com.lvmama.lvfit.adapter.vst.service.HotelPriceService;
import com.lvmama.lvfit.common.dto.hotel.FitHotelTimePrice;
import com.lvmama.lvfit.common.dto.request.FitHotelPriceRequest;
import com.lvmama.lvfit.common.dto.vst.VstSuppGoodPrice;

@Service
public class HotelPriceServiceImpl implements HotelPriceService {

	@Autowired
	private GoodsServiceAdapter GoodsServiceAdapter;
	@Override
	public FitHotelTimePrice findTimePriceBySpecDate(
			FitHotelPriceRequest request) {
		Long salesPrice =0L;
		Long settlePrice = 0L;			
	    Long promotion = 0L;
	    FitHotelTimePrice timePrice = new FitHotelTimePrice();
		List<VstSuppGoodPrice> list = GoodsServiceAdapter.findTimePriceBySpecDate(request);
		if(CollectionUtils.isNotEmpty(list)){		
			for(VstSuppGoodPrice vstSuppGoodPrice:list){
				salesPrice += vstSuppGoodPrice.getPrice();
				settlePrice += vstSuppGoodPrice.getSettlementPrice();
			}
			promotion =salesPrice-salesPrice;
			timePrice.setPricePlanId(request.getPricePlanId());
			timePrice.setSalesPrice(new BigDecimal(salesPrice).divide(new BigDecimal(100)));
			timePrice.setSettlePrice(new BigDecimal(salesPrice).divide(new BigDecimal(100)));
			timePrice.setPromotion(new BigDecimal(promotion).divide(new BigDecimal(100)));
		}
		return timePrice;
	}

}
