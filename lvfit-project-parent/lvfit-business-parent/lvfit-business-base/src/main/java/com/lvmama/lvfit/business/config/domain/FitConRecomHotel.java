package com.lvmama.lvfit.business.config.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;

/**
 * @author lutianyu
 * @date   2016年1月6日
 */
public class FitConRecomHotel implements Domain<FitConRecomHotelDto> {
	private FitConRecomHotelDto self;
	   
	@Override
	public FitConRecomHotelDto self() {
		// TODO Auto-generated method stub
		return this.self;
	}

	public FitConRecomHotelDto getSelf() {
		return self;
	}

	public void setSelf(FitConRecomHotelDto self) {
		this.self = self;
	}

	private FitConRecomHotel(FitConRecomHotelDto self) {
		super();
		this.self = self;
	}

	private FitConRecomHotel() {
		super();
		// TODO Auto-generated constructor stub
	}
}
